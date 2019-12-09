package com.shubham.movieinfoservie.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.movieinfoservie.controller.domain.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") int movieId) {
		return new Movie(movieId, "Test Movie");
	}
}
