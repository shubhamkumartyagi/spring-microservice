package com.shubham.moviecatalougeservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shubham.moviecatalougeservice.domain.Movie;
import com.shubham.moviecatalougeservice.domain.MovieCatalogue;
import com.shubham.moviecatalougeservice.domain.Rating;

@RestController
@RequestMapping("/catalogue")
public class MovieController {

	@RequestMapping("/{userId}")
	public List<MovieCatalogue> getMovieCatalogue(@PathVariable("userId") String userId) {

		RestTemplate restTemplate = new RestTemplate();
		

		List<Rating> movieRatings = Arrays.asList(new Rating("12345", 4), new Rating("45678", 3));
		
		return movieRatings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			return new MovieCatalogue(movie.getName(), "Test", rating.getRating());
		}).collect(Collectors.toList());

	}

}
