package com.autentia.tdd.example.movie.service;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.autentia.tdd.example.movie.dao.MovieDAO;
import com.autentia.tdd.example.movie.dao.exception.MovieDaoException;
import com.autentia.tdd.example.movie.model.Movie;
import com.autentia.tdd.example.movie.service.exception.MovieServiceException;
import com.autentia.tdd.example.movie.service.impl.MovieCatalogImpl;

public class MovieCatalogTest {
	
	MovieDAO movieDao = mock(MovieDAO.class);
	
	private final MovieCatalog filmCatalogSUT = new MovieCatalogImpl(movieDao);
	
	@Test
	public void shouldReturnMoviesFromDao() throws MovieDaoException, MovieServiceException{
		//given
		String IRONMAN = "Ironman";
		when(movieDao.find()).thenReturn(Arrays.asList(new Movie(IRONMAN)));
		//when
		final List<Movie> movies = filmCatalogSUT.search();
		//then
		assertThat(movies,hasSize(1));
		assertThat(movies.get(0).getName(),is(IRONMAN));
	}
	
	@Test(expected=MovieServiceException.class)
	public void shouldThrowAnExceptionIfDaoFail() throws MovieDaoException, MovieServiceException{
		//given
		when(movieDao.find()).thenThrow(new MovieDaoException());
		//when
		filmCatalogSUT.search();
		//then es la anotación @expected
	}

}
