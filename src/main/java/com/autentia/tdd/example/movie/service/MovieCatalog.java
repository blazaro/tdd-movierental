package com.autentia.tdd.example.movie.service;

import java.util.List;

import com.autentia.tdd.example.movie.model.Movie;
import com.autentia.tdd.example.movie.service.exception.MovieServiceException;

public interface MovieCatalog {

	List<Movie> search() throws MovieServiceException;

}
