package com.shubham.ratingsservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.ratingsservice.controller.domain.Rating;
import com.shubham.ratingsservice.controller.domain.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

	public Rating getRating(@PathVariable("movieId") String movieId) {

		return new Rating("foo", 4);
	}

	@GetMapping("users/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("3", 4), new Rating("500", 3));
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}

}
