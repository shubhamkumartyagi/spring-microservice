package com.shubham.moviecatalougeservice.controller;

import java.util.List;
import java.util.stream.Collectors;

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
	public List<MovieCatalogue> getMovieCatalogue(@PathVariable("userId") String userId) {

		UserRating userRating = this.restTemplate.getForObject("http://ratings-service/ratings/users/" + userId,
				UserRating.class);

		return userRating.getUserRating().stream().map(rating -> {

			// with RestTemplate
			 Movie movie = this.restTemplate.getForObject("http://movie-info-service/movies/"
			 + rating.getMovieId(), Movie.class);

//			Movie movie = webClientBuilder.build().get().uri("http://movie-info-service/movies/" + rating.getMovieId())
//					.retrieve().bodyToMono(Movie.class).block();

			return new MovieCatalogue(movie.getName(), "Test", rating.getRating());
		}).collect(Collectors.toList());

	}

}
