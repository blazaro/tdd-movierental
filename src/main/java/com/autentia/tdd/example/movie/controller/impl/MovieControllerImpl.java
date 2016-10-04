package com.autentia.tdd.example.movie.controller.impl;

import java.util.List;

import com.autentia.tdd.example.movie.controller.MovieController;
import com.autentia.tdd.example.movie.controller.response.CatalogResponse;
import com.autentia.tdd.example.movie.model.Movie;
import com.autentia.tdd.example.movie.service.MovieCatalog;
import com.autentia.tdd.example.movie.service.exception.MovieServiceException;

public class MovieControllerImpl implements MovieController {

	public static final String NO_HAY_PELICULAS_DISPONIBLES = "No hay peliculas disponibles.";
	private final MovieCatalog movieCatalog;

	public MovieControllerImpl(MovieCatalog movieCatalog) {
		this.movieCatalog = movieCatalog;
	}

	public CatalogResponse search() {
		try {
			return buildCatalogResponse(movieCatalog.search());
		} catch (MovieServiceException e) {
			return new CatalogResponse("ERROR");
		}
	}

	private CatalogResponse buildCatalogResponse(List<Movie> movies) {
		if(movies != null && !movies.isEmpty()){
			return new CatalogResponse(movies);
		}
		return new CatalogResponse(NO_HAY_PELICULAS_DISPONIBLES);
	}

}
