package com.shubham.movieinfoservie.controller.domain;

import lombok.Data;

@Data
public class Movie {

	private int movieId;
	
	private String name;

	public Movie(int movieId, String name) {
		this.movieId = movieId;
		this.name = name;
	}
	
}
