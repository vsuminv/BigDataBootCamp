package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.book.model.Book;
import com.book.utils.DBUtils;

//Data Access Object, DB 접근을 담당하는 클래스.
public class BookDAO {


	
	public List<Book> findAll() {
		String selectQuery = "SELECT * FROM book ORDER BY rank limit 5";

		List<Book> books = new ArrayList<>();
		
		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
				ResultSet resultSet = preparedStatement.executeQuery();

				)
		{
			while (resultSet.next()) {
				Book book = new Book(resultSet.getInt("rank"), 
								resultSet.getString("book_id"), 
								resultSet.getString("title"), 
								resultSet.getString("author"), 
								resultSet.getString("field"), 
								resultSet.getBoolean("rental_status"));
			
				books.add(book);

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return books;
		
	}

	}
