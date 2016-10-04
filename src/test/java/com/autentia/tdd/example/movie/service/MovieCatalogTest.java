package com.autentia.tdd.example.movie.service;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import com.autentia.tdd.example.movie.dao.MovieDAO;
import com.autentia.tdd.example.movie.model.Movie;

public class MovieCatalogTest {
	
	MovieDAO movieDao = mock(MovieDAO.class);
	
	private final MovieCatalog filmCatalogSUT = new MovieCatalogImpl(movieDao);
	
	public void shouldReturnMoviesFromDao(){
		//given
		String IRONMAN = "Ironman";
		when(movieDao.find()).thenReturn(Arrays.asList(new Movie(IRONMAN)));
		//when
		final List<Movie> movies = filmCatalogSUT.search();
		//then
		assertThat(movies,hasSize(1));
		assertThat(movies.get(0).getName(),is(IRONMAN));
	}

}
