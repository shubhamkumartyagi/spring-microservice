package com.shubham.ratingsservice.controller.domain;

import java.util.List;

import lombok.Data;

@Data
public class UserRating {

	private List<Rating> userRating;

	public UserRating() {
	}
}
