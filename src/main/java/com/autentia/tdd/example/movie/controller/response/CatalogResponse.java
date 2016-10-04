package com.autentia.tdd.example.movie.controller.response;

import java.util.Collections;
import java.util.List;

import com.autentia.tdd.example.movie.model.Movie;
import com.autentia.tdd.example.movie.service.exception.MovieServiceException;

public class CatalogResponse {
	
	public static final String NO_HAY_PELICULAS_DISPONIBLES = "No hay peliculas disponibles.";
	public static final String HA_OCURRIDO_UN_ERROR = "Ha ocurrido un error.";

	private final List<Movie> movies;
	private final String errorMessage;

	public CatalogResponse(List<Movie> movies) {
		this.movies = movies;
		this.errorMessage = calculateErrorMesage(movies);
		
	}

	private String calculateErrorMesage(List<Movie> movies) {
		if(movies != null && !movies.isEmpty()){
			return "";
		}else{
			return NO_HAY_PELICULAS_DISPONIBLES;
		}
	}


	public CatalogResponse(MovieServiceException e) {
		this.movies=Collections.emptyList();
		this.errorMessage = HA_OCURRIDO_UN_ERROR;
	}

	public String getErroMessage() {
		return errorMessage;
	}

	public List<Movie> getMovies() {
		return movies;
	}

}
