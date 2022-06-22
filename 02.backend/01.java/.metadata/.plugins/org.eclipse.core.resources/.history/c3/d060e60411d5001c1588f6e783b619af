package com.book.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "book_rental_shop";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	

	
	public static Connection getConnection() throws SQLException {
		

		Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		
		return connection;
	}

}
