package com.capgemini.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.capgemini.amazonviewer.db.IDBConnection;
import com.capgemini.amazonviewer.model.Movie;
import static com.capgemini.amazonviewer.db.DataBase.*;

public interface MovieDao extends IDBConnection{

	default Movie setMovieViewed(Movie movie) {
		return movie;
	}
	
	default ArrayList<Movie> read(){
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try (Connection connection = connectToDB()){
			String query = "SELECT * FROM "+TMOVIE;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie(rs.getString(TMOVIE_TITLE), rs.getString(TMOVIE_GENRE), rs.getString(TMOVIE_CREATOR), 
						Integer.valueOf(rs.getString(TMOVIE_DURATION)), Short.valueOf(rs.getString(TMOVIE_YEAR)));
				
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				
				movies.add(movie);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	private boolean getMovieViewed() {
		return false;
	} 
	
}
