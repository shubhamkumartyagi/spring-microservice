package com.shubham.moviecatalougeservice.domain;

import lombok.Data;

@Data
public class MovieCatalogue {

	private String name;
	
	private String desc;
	
	private int rating;

	public MovieCatalogue(String name, String desc, int rating) {
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}
	
}
