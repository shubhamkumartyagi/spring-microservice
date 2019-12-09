package com.shubham.ratingsservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.ratingsservice.controller.domain.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

	
	public Rating getRating(@PathVariable("movieId") String movieId) {
		
		return new Rating("foo", 4);
	}
	
}
