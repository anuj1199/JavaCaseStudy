package com.app.project.main.serviceinterface;

import java.util.List;

import com.app.project.main.model.Movie;
public interface MovieInterface {

public Movie saveMovie(Movie movie);
	
	public Movie updateMovie(Movie movie);
	
	public List<Movie> findAllMovies();
	
	public void deleteMovie(int id);
}
