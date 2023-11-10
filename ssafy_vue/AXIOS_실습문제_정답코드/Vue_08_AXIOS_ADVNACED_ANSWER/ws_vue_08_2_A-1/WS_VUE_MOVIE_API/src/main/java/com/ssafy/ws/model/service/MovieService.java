package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.Movie;

public interface MovieService {

	List<Movie> list();

	Movie search(int id);

	boolean create(Movie movie);
	
	boolean modify(Movie movie);
	
}
