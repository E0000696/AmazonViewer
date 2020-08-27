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
				movie.setViewed(getMovieViewed(
						preparedStatement, 
						connection, 
						Integer.valueOf(rs.getString(TMOVIE_ID))));
				movies.add(movie);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	private boolean getMovieViewed(PreparedStatement prepareStatement, Connection connection, int id_movie) {
		boolean viewed  = false;
		String query ="SELECT * FROM "+TVIEWED+
				" WHERE "+TVIEWED_IDMATERIAL + " = "+" ? " +
				" AND "+TVIEWED_IDELEMENT + " = "+" ? " +
				" AND "+TVIEWED_IDUSUARIO + " = "+" ? " ;
		
		ResultSet rs = null;
		try {
			prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, ID_TMATERIALS[0]);
			prepareStatement.setInt(2, id_movie);
			prepareStatement.setInt(3, TUSER_IDUSUARIO);
			
			
			
			rs = prepareStatement.executeQuery();
					
			viewed = rs.next();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return viewed;
	} 
	
}
