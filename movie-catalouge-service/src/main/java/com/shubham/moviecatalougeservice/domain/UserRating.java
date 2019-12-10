package com.shubham.moviecatalougeservice.domain;

import java.util.List;

import lombok.Data;

@Data
public class UserRating {

	private List<Rating> userRating;

	public UserRating() {
	}
}
