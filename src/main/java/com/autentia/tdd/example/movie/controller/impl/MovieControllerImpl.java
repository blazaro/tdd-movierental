package com.autentia.tdd.example.movie.controller.impl;

import com.autentia.tdd.example.movie.controller.MovieController;
import com.autentia.tdd.example.movie.controller.response.CatalogResponse;
import com.autentia.tdd.example.movie.service.MovieCatalog;

public class MovieControllerImpl implements MovieController {

	private final MovieCatalog movieCatalog;

	public MovieControllerImpl(MovieCatalog movieCatalog) {
		this.movieCatalog = movieCatalog;
	}

	public CatalogResponse search() {
		return null;
	}

}
