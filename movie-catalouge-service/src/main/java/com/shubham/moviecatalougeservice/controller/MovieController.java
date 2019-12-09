package com.shubham.moviecatalougeservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.moviecatalougeservice.domain.MovieCatalogue;

@RestController
@RequestMapping("/catalogue")
public class MovieController {
	
	@RequestMapping("/{userId}")
	public List<MovieCatalogue> getMovieCatalogue(@PathVariable("userId") String userId) {
		
		return null;
	}

}
