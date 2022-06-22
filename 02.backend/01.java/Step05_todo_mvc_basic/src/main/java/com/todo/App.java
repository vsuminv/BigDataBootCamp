package com.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import com.todo.controller.TodoController;
import com.todo.data.TodoTSVParser;
import com.todo.data.TodoTSVWriter;
import com.todo.model.Todo;
import com.todo.view.TodoView;

public class App {

	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		
		// 1. 데이터의 입출력 : 데이터를 읽어들임(read, 입력)
		final Path filePath = Paths.get(RESOURCES + "todo-data-simple.txt");
		Long numberOfRows = Files.lines(filePath).count();
		List<String> lines = Files.readAllLines(filePath);

		// 2. 입출력 데이터 파싱 : 데이터를 파싱하는 부분을 별도의 클래스 TodoTSVParser.java로 분리
		TodoTSVParser todoTSVParser = new TodoTSVParser();
		List<Todo> todos = todoTSVParser.parseLinesFromTSV(lines, numberOfRows.intValue());
		
		
		
//	Controller 생성 : 사용자의 요청(request)에 따라 등록, 조회 등 어떤 액션을 수행시킬지 분기 , 결정을 담담
		TodoController todoController = new TodoController(todos);
		
//		전체 Todos 조회
		todoController.findAll();

		// 할 일 번호로 특정 Todo 조회
		Long todoNumber = 2L;
		todoController.findById(todoNumber);

//		하나의 Todo 등록
		Todo newTodo = new Todo("산책하기", "강아지와 산책한다", LocalDate.of(2022, 04, 05)); 
		todoController.save(RESOURCES, filePath, newTodo);
		
		
		
//		// 할 일을 추가하는 부분을 별도의 클래스 TodoTSVWriter.java로 분리
//		TodoTSVWriter todoTSVWriter = new TodoTSVWriter();
//		Todo newTodo = new Todo("산책하기", "강아지와 산책한다", LocalDate.of(2022, 04, 05)); 
//		todoController.save(RESOURCES, filePath, newTodo);
	}
	

}
