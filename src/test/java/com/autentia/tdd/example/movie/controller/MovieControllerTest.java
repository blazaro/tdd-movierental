package com.autentia.tdd.example.movie.controller;

import static org.mockito.Mockito.*;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.autentia.tdd.example.movie.model.Movie;
import com.autentia.tdd.example.movie.service.MovieCatalog;

public class MovieControllerTest {
	
	private static final String EL_CLUB_DE_LA_LUCHA = "El club de la lucha";
	private final MovieCatalog movieCatalog = mock(MovieCatalog.class);
	private final MovieController movieControllerSUT = new MovieControllerImpl(movieCatalog );
	
	
	@Test
	public void shouldReturnTheMovieList(){
		//given
		when(movieCatalog.search()).thenReturn(Arrays.asList(new Movie(EL_CLUB_DE_LA_LUCHA)));
		//when
		final CatalogResponse catalogResponse = movieControllerSUT.search();
		//then
		assertThat(catalogResponse.getErroMessage(),is(empty()));
		assertThat(catalogResponse.getMovies(),hasSize(1));
		assertThat(catalogResponse.getMovies().get(0).getName(),is(EL_CLUB_DE_LA_LUCHA));
	}

}
