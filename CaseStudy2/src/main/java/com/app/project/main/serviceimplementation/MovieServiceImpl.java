package com.app.project.main.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.project.main.dao.MovieRepository;
import com.app.project.main.model.Movie;
import com.app.project.main.serviceinterface.MovieInterface;

@Service
public class MovieServiceImpl implements MovieInterface{

	@Autowired
	private MovieRepository movieRepo;

	@Override
	public Movie saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepo.save(movie);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepo.save(movie);
	}

	@Override
	public List<Movie> findAllMovies() {
		// TODO Auto-generated method stub
		return (List<Movie>) movieRepo.findAll();
	}

	@Override
	public void deleteMovie(int id) {
		// TODO Auto-generated method stub
		movieRepo.deleteById(id);
	}
}
