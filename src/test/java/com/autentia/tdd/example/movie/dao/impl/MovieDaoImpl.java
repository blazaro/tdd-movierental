package com.autentia.tdd.example.movie.dao.impl;

import java.util.Arrays;
import java.util.List;

import com.autentia.tdd.example.movie.dao.MovieDAO;
import com.autentia.tdd.example.movie.model.Movie;

public class MovieDaoImpl implements MovieDAO {

	public List<Movie> find() {
		return Arrays.asList(new Movie("Star Wars"),new Movie("El señor de los anillos"),new Movie("Harry Potter"));
	}

}
