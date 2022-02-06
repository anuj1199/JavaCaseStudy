package com.app.project.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.app.project.main.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>{

}
