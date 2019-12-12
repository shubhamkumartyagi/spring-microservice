package com.shubham.movieinfoservie.controller.domain;

import lombok.Data;

@Data
public class Movie {

	private String movieId;

	private String name;

	private String overview;

	public Movie(String movieId, String name, String overview) {
		this.movieId = movieId;
		this.name = name;
		this.overview = overview;
	}

	public Movie() {

	}
}
