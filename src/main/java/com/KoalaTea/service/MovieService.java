package com.KoalaTea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoalaTea.model.Movie;
import com.KoalaTea.repository.MovieRepository;

@Service(value="movieService")
public class MovieService {
	
	//The implementation of this dependency doesn't matter here.
	MovieRepository movieRepository;
//	MovieRepository movieRepository2;
	
//	//We want to use setter injection, so let's create a setter.
//	public void setMovieRepository(MovieRepository movieRepository) {
//		this.movieRepository = movieRepository;
//	}
	
	//Using constructor injection.
	@Autowired
	public MovieService(MovieRepository movieRepository2) {
		this.movieRepository = movieRepository2;
	}
	
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public void insertMovie(Movie m) {
		movieRepository.save(m);
	}
	
	public Movie getMovieById(int id) {
		return movieRepository.findById(id);
	}
	
//	public Movie getMovieByName(String name) {
//		return movieRepository.getMovieByName(name);
//	}
	
//	public void updateMovie(Movie m) {
//		movieRepository.updateMovie(m);
//	}
}
