package com.autentia.tdd.example.movie.dao;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

import com.autentia.tdd.example.movie.dao.impl.MovieDaoImpl;

public class MovieDaoTest {
	
	private MovieDAO movieDaoSUT = new MovieDaoImpl();

	@Test
	public void shouldReturnMockedList(){
		assertThat(movieDaoSUT.find(),hasSize(3));
	}

}
