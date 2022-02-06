package com.app.project.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.project.main.model.Movie;
import com.app.project.main.serviceimplementation.MovieServiceImpl;

@RestController
@CrossOrigin("*")

public class Controller {
	
	@Autowired
	private MovieServiceImpl movieServiceImpl;
	
	@PostMapping(value="insertMovie")
	public Movie saveMovie(@RequestBody Movie movie) {
		System.out.println("Movies inserted....");
		movieServiceImpl.saveMovie(movie);
		return movie;
	}
	@GetMapping(value="displayMovie")
	public List<Movie> findAllMovie(){
		return movieServiceImpl.findAllMovies();
	}
	@PutMapping("updateMovie")
	public Movie updateMovie(@RequestBody Movie movie) {
		return movieServiceImpl.updateMovie(movie);
	}
	@DeleteMapping("deleteMovie")
	public String deleteMovie(@RequestParam int id) {
		movieServiceImpl.deleteMovie(id);
		return "Student Deleted";
	}
}
