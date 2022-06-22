package com.todo.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.todo.model.Todo;

public class TodoTSVParser {
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
//	하나의 Todo 데이터를 파싱하는 메서드, Todo 인스턴스 반환
	private Todo parseFromTSV(String line) {
		final String[] columns = line.split("\t");
		
		final Long id = Long.parseLong(columns[0]);
		final String title = columns[1];
		final LocalDate dueDate = LocalDate.parse(columns[2], DATE_PATTERN);
		final String description = columns[3];
		
		Todo todo = new Todo(id,title, dueDate, description);
		
		return todo;
	}
				
		
//		한 줄씩 파싱 후, 리스트을 추가하는 메서드. 파싱이 완료된 todo 리스트를 반환

		public List<Todo> parseLinesFromTSV(List<String> lines, int numberOfRows) {
//			1. todos 리스트 선언 및 초기화
			 List<Todo>  todos = new  ArrayList<>() ;

//			3. 반복문 작성
			for (String line : lines) {
				Todo todo = parseFromTSV(line);
				todos.add(todo);

			}
			return todos;
		}
	}
	


