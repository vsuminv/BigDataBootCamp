package com.todo.dao;

import java.util.List;

import com.todo.database.TodoDatabase;
import com.todo.model.Todo;

//Data Access Object, DB 접근을 담당하는 클래스
public class TodoDAO {
	
//	멤버 필드
	private final TodoDatabase todoDatabase;
	
	
	public TodoDAO() {
		this.todoDatabase = new TodoDatabase();
	}

	public List<Todo> findAll() {
		
//		DB에 접근해서 실제 데이터 가져옴
		List<Todo> todos = TodoDatabase.getTodos();
		return todos;
//		return TodoDatabase.getTodos();
	}
	

	public Todo findById(Long id) {
		
		//DB에서 id값과 일치하는 Todo 데이터 조회
		return todoDatabase.findById(id);
		
//		일치하는 데이터가 있을 경우 내부적으로 치환된 모습
//		return new Todo(todo.getId(), todo.getTitle(), todo.getDueDate(), todo.getDescription());
		
//		일치하는 데이터가 없을 경우. 내부적으로 치환된 형태
//		return null;

		
	}

	public Boolean save(Todo newTodo) {
		return todoDatabase.save(newTodo);
		
		
	}

	public Todo updateById(Long todoNumber, Todo todo) {
		return todoDatabase.updateById(todoNumber,todo);
	}

	public Todo deleteById(Long todoNumber) {
		// TODO Auto-generated method stub
		return todoDatabase.deleteById(todoNumber);
	}

	

}
