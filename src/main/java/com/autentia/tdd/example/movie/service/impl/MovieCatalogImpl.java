package com.autentia.tdd.example.movie.service.impl;

import java.util.List;

import com.autentia.tdd.example.movie.dao.MovieDAO;
import com.autentia.tdd.example.movie.model.Movie;
import com.autentia.tdd.example.movie.service.MovieCatalog;

public class MovieCatalogImpl implements MovieCatalog {

	private final MovieDAO movieDao;

	public MovieCatalogImpl(MovieDAO movieDao) {
		this.movieDao = movieDao;
	}

	public List<Movie> search() {
		return movieDao.find();
	}

}
