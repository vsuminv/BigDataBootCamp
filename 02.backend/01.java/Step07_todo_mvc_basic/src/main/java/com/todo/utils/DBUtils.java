package com.todo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// DB와 관련된 설정 정보나 수행들을 관리하는 클래스
public class DBUtils {
	// MySQL 서버 URL
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	// 사용하고자 하는 스키마(Database)이름
	private static final String DATABASE_NAME = "testdb";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
//	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Drvier";
	// JDBC4.0 이후로 모든 드라이버들은 클래스패스에 자동으로 로딩됨 - 기존에는 원칙적으로 드라이버를 먼저 로딩(Loading)을 해야했음. 


	// Java와 MySQL Database를 연결
	public static Connection getConnection() throws SQLException {
//		Class.forName(DRIVER_NAME); // 과거의 사용 방식
		Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return connection;
	}
	
	// DDL, 테이블 생성 메서드
//	public static void dropAndCreateTable() {
//		
//		// Java와 MySQL 연결
//		// try - with resources 구문 - 자원을 자동으로 해제
//		try (Connection connection = getConnection();
//			 Statement statement = connection.createStatement();) {
//			
//			// 테이블 제거 SQL, 만약 todo 테이블이 존재할 경우, 삭제. 그렇지 않으면 그냥 지나가~
//			final String dropTableQueryIfExists = "DROP TABLE IF EXISTS todo";
//			
////			// Query 실행 진행시켜
//			statement.execute(dropTableQueryIfExists);
////			
////			// 테이블 생성 SQL
//			final String createTableQuery = 
//	            "CREATE TABLE todo (" +
//	            "id SMALLINT(5) unsigned NOT NULL AUTO_INCREMENT,"+
//	            "title VARCHAR(255),"+
//	            "description VARCHAR(255)," +
//	            "due_date DATE," +
//	            "is_completed BOOLEAN DEFAULT false," +
//	            "PRIMARY KEY (id))";	
//		
////			// Query 실행 진행시켜
//			statement.execute(createTableQuery);
//			System.out.println("Table has created.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
}
