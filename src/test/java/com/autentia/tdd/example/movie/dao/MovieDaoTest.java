package com.autentia.tdd.example.movie.dao;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class MovieDaoTest {
	
	private MovieDAO movieDaoSUT = new MovieDaoImpl();

	@Test
	public void shouldReturnMockedList(){
		assertThat(movieDaoSUT.find(),hasSize(3));
	}

}
