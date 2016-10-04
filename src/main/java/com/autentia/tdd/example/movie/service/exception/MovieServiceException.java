package com.autentia.tdd.example.movie.service.exception;

import com.autentia.tdd.example.movie.dao.exception.MovieDaoException;

public class MovieServiceException extends Exception{

	public MovieServiceException(MovieDaoException e) {
		super(e);
	}

}
