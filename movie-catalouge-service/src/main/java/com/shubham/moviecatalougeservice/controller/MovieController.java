package com.shubham.moviecatalougeservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.shubham.moviecatalougeservice.domain.Movie;
import com.shubham.moviecatalougeservice.domain.MovieCatalogue;
import com.shubham.moviecatalougeservice.domain.UserRating;

@RestController
@RequestMapping("/catalogue")
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@GetMapping("/{userId}")
	@HystrixCommand(fallbackMethod = "getFallbackCatalogue")
	public List<MovieCatalogue> getMovieCatalogue(@PathVariable("userId") String userId) {

		UserRating userRating = this.restTemplate.getForObject("http://ratings-service/ratings/users/" + userId,
				UserRating.class);

		return userRating.getUserRating().stream().map(rating -> {

			// with RestTemplate
			 Movie movie = this.restTemplate.getForObject("http://movie-info-service/movies/"
			 + rating.getMovieId(), Movie.class);

//			Movie movie = webClientBuilder.build().get().uri("http://movie-info-service/movies/" + rating.getMovieId())
//					.retrieve().bodyToMono(Movie.class).block();

			return new MovieCatalogue(movie.getName(), movie.getOverview(), rating.getRating());
		}).collect(Collectors.toList());

	}

	/**
	 * For learning purpose, hystrix is used in controller, normally you would write a service class which calls an
	 * external service and returns you the data. Meaning you call multiple services from your controller.
	 * Which tells us that @Hystrix needs to be used in service class and let service gives back a response. (success or fallback)
	 * In the above example we have two external calls and if either of them fails the circuit will break, we don't wanna
	 * do this is normal case scenario.
	 * @return
	 */
	public List<MovieCatalogue> getFallbackCatalogue(@PathVariable("userId") String userId) {
		return Arrays.asList(new MovieCatalogue("No Movie", "", 0));
	}

}
