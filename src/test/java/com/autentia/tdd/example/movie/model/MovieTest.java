package com.autentia.tdd.example.movie.model;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {
	
	@Test
	public void shouldReturnMovieName(){
		final String BATMAN = "BATMAN";
		final Movie movie = new Movie(BATMAN );
		assertThat(movie.getName(),is(BATMAN));
	}

}
