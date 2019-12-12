package com.shubham.movieinfoservie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shubham.movieinfoservie.controller.domain.Movie;
import com.shubham.movieinfoservie.controller.domain.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	@Value("${movie.db.api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		MovieSummary summary = this.restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);

		return new Movie(summary.getId(), summary.getTitle(), summary.getOverview());
	}
}
