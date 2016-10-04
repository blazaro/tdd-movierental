package com.autentia.tdd.example.movie.service.impl;

import java.util.List;

import com.autentia.tdd.example.movie.dao.MovieDAO;
import com.autentia.tdd.example.movie.dao.exception.MovieDaoException;
import com.autentia.tdd.example.movie.model.Movie;
import com.autentia.tdd.example.movie.service.MovieCatalog;
import com.autentia.tdd.example.movie.service.exception.MovieServiceException;

public class MovieCatalogImpl implements MovieCatalog {

	private final MovieDAO movieDao;

	public MovieCatalogImpl(MovieDAO movieDao) {
		this.movieDao = movieDao;
	}

	public List<Movie> search() throws MovieServiceException {
		try{
			return movieDao.find();
		}catch(MovieDaoException e){
			throw new MovieServiceException(e);
		}
	}

}
