package com.book.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB와 관련된 설정 정보나 수행들을 관리하는 클래스
public class DBUtils {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "book_rental_shop";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	public static Connection getConnection() throws SQLException {

		// DriverManager를 통해 각 애플리케이션에 맞는 드라이버 호출 가능
		// DriverManager에서 getConnection 메서드 사용. => Java와 MySQL 사이에 통로를 열어줌
		Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return connection;
	}

}
