package com.autentia.tdd.example.movie.dao;

import java.util.List;

import com.autentia.tdd.example.movie.dao.exception.MovieDaoException;
import com.autentia.tdd.example.movie.model.Movie;

public interface MovieDAO {

	List<Movie> find() throws MovieDaoException;

}
