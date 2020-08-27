package com.capgemini.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.capgemini.amazonviewer.db.DataBase.*;

public interface IDBConnection {

	default Connection connectToDB() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);
			if(connection != null) {
				System.out.println("Se establecio la conexion con la BD =D");
			}
		}catch(Exception e) 
		{ //Debug
			e.printStackTrace();
		}finally {
			return connection;			
		}
		
	}
	
}
