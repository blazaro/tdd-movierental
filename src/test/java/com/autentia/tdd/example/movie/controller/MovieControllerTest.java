package com.autentia.tdd.example.movie.controller;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.autentia.tdd.example.movie.controller.impl.MovieControllerImpl;
import com.autentia.tdd.example.movie.controller.response.CatalogResponse;
import com.autentia.tdd.example.movie.model.Movie;
import com.autentia.tdd.example.movie.service.MovieCatalog;
import com.autentia.tdd.example.movie.service.exception.MovieServiceException;

public class MovieControllerTest {
	
	private static final String EL_CLUB_DE_LA_LUCHA = "El club de la lucha";
	private final MovieCatalog movieCatalog = mock(MovieCatalog.class);
	private final MovieController movieControllerSUT = new MovieControllerImpl(movieCatalog );
	
	
	@Test
	public void shouldReturnTheMovieList() throws MovieServiceException{
		//given
		when(movieCatalog.search()).thenReturn(Arrays.asList(new Movie(EL_CLUB_DE_LA_LUCHA)));
		//when
		final CatalogResponse catalogResponse = movieControllerSUT.search();
		//then
		assertThat(catalogResponse,is(not(nullValue())));
		assertThat(catalogResponse.getErroMessage(),isEmptyOrNullString());
		assertThat(catalogResponse.getMovies(),hasSize(1));
		assertThat(catalogResponse.getMovies().get(0).getName(),is(EL_CLUB_DE_LA_LUCHA));
	}

	@Test
	public void shouldReturnErrorMessageIfTheCatalogIsEmpty() throws MovieServiceException{
		//given
		when(movieCatalog.search()).thenReturn(new ArrayList<Movie>());
		//when
		final CatalogResponse catalogResponse = movieControllerSUT.search();
		//then
		assertThat(catalogResponse,is(not(nullValue())));
		assertThat(catalogResponse.getErroMessage(),is(MovieControllerImpl.NO_HAY_PELICULAS_DISPONIBLES));
		assertThat(catalogResponse.getMovies(),is(empty()));
	}
}
