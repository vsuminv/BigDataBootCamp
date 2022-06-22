package com.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import com.todo.data.TodoTSVParser;
import com.todo.data.TodoTSVWriter;
import com.todo.model.Todo;

public class App {
	
	// 객체 멤버 변수 RESOURCES 초기화
	private static final String RESOURCES = "src/main/resources/";
	// 객체 멤버 변수 DATE_PATTERN 초기화
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void main(String[] args) throws IOException {
		
		/**
		 * 1. 데이터의 입출력
		 * 2. 입출력데이터 파싱(Parsing)
		   3. 결과값 출력(findAll, findById) 
		 */
		
//		1. 데이터의 입출력 : 데이터 읽어들임(read, 입력)
		final Path filePath = Paths.get(RESOURCES + "todo-data-simple.txt");
		Long numberOfRows = Files.lines(filePath).count();
		List<String> lines = Files.readAllLines(filePath);
		
//		2. 데이터 파싱 : 데이터를 파싱하는 부분을 별도의 클래스 TodoSVParser.java로 분리
		TodoTSVParser todoTSVParser = new TodoTSVParser();
		
//		배열을 컬렉션으로 변경 List인터페이스를 타입으로, todos, Todo 타입에 데이터만 받을 수 있어야함
		List<Todo> todos = todoTSVParser.parseLinesFromTSV(lines,numberOfRows.intValue());
		
//		3. 결과값 출력 : 파싱된 데이터를 활용하여 결과 데이터 출격하는 부분\\
//		전체 Todos 조회
		findAll(todos);
		
		Long todoNumber = 2L;
		System.out.println(todoNumber + "번쨰로 할 일은 "+  findByID(todos, todoNumber).getTitle() +"입니다.");
		
//		할 일을 추가하는 부분을 별도의 클래스 TodoTSWriter.java로 분리
		
//		TodoTSWriter 인스턴스 생성
		TodoTSVWriter todoTSVWiter = new TodoTSVWriter();
		
//		새롭게 등록할 Todo 일정(객체) 생성
		Todo newTodo = new Todo("산책하기","강아지와 산책한다.", LocalDate.of(2022, 04, 05));
		
//		todo 데이터 쓰기(저장) 처리
		todoTSVWiter.save(RESOURCES, filePath, newTodo);


	}
	
//	전체 Todos 조회
	public static void findAll(List<Todo> todos) { //static이 없으면 App 클래스의 인스턴스 메서드가 되고, 인스턴스 멤버는 객체를 생성한 후에 접근이 가능하기 떄문에
		System.out.println(todos);
	}
	
//	할 일 순서 번호로 하나의 Todo 조회
	public static Todo findByID(List<Todo> todos, Long todoNumber){
		for (Todo todo : todos) {
			if(todo.getId() ==  todoNumber) {
				return new Todo(todo.getId(), todo.getTitle(),todo.getDueDate(), todo.getDescription());
			}
		}
		return null;
	}

}
