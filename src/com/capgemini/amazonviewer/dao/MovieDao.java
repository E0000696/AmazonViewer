package com.capgemini.amazonviewer.dao;

import java.util.ArrayList;

import com.capgemini.amazonviewer.model.Movie;

public interface MovieDao {

	default Movie setMovieViewed(Movie movie) {
		return movie;
	}
	
	default ArrayList<Movie> read(){
		ArrayList<Movie> movies = new ArrayList<Movie>();
		return movies;
	}
	
	private boolean getMovieViewed() {
		return false;
	} 
	
}
