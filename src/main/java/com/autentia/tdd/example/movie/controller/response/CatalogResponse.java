package com.autentia.tdd.example.movie.controller.response;

import java.util.Collections;
import java.util.List;

import com.autentia.tdd.example.movie.model.Movie;

public class CatalogResponse {

	private final List<Movie> movies;
	private final String errorMessage;

	public CatalogResponse(List<Movie> movies) {
		this.movies = movies;
		this.errorMessage= "";
	}

	public CatalogResponse(String errorMessage) {
		this.errorMessage = errorMessage;
		this.movies=Collections.emptyList();
	}

	public String getErroMessage() {
		return errorMessage;
	}

	public List<Movie> getMovies() {
		return movies;
	}

}
