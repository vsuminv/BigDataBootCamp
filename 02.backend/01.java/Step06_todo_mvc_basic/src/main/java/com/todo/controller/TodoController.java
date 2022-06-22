package com.todo.controller;

import java.util.List;

import com.todo.model.Todo;
import com.todo.service.TodoService;
import com.todo.view.TodoView;;
public class TodoController {
//	사용자의 요청에 따라 액션을 분기만 해주는 역할
	
//	todos 리스트를 필드를 선언
	private  List<Todo> todos;
	private final TodoView todoView;//		View 역할하는 직원 호출
	private final TodoService todoService;
	private Exception errorObject;
	
//	기본생성자
	public TodoController() {
		this.todoView = new TodoView();
		this.todoService = new TodoService();
	}
	
	
//	전체 데이터 조회 처리를 위한 분기
	public void findAll() {
		todos = todoService.findAll();		
		todoView.findAll(todos);
	}
	
//	하나의 데이터 조회 처리를 분기만
	public void findById(Long id) {
		
//		todoSevice에게세ㅓ id값으로 찾은 todo 데이터 전달 받음
		Todo todo = todoService.findById(id); // 하나의 투두데이터 받음
		
		if (todo != null) {
			todoView.findById(todo);
		}else {
			errorObject = new Exception("해당하는 Todo 데이터가 존재하지 않습니다.");
			todoView.errorPage(errorObject);
		}
		
		
	}
	
	public void save(Todo newTodo) {
//		실제 데이터 저장에 대한 처리는 service 클래스가 한다.
		boolean result = todoService.save(newTodo);
//		System.out.println(result); //true 출력
		
//		데이터 저장 성공여부는 todoview가 출력
		if(result) {
			todoView.successPage();
		}else {
			todoView.errorPage();
		}
	}


	public void updateById(Long todoNumber, Todo todo) {
		Todo previudsTodo = todoService.updateById(todoNumber,todo);
//		System.out.println(updatedTodo);
		
		if(previudsTodo != null) {
			todoView.update(previudsTodo);
		}else {
			errorObject = new Exception("수정 실패");
			todoView.errorPage(errorObject);
		}
		
	}


	public void deleteById(Long todoNumber) {
		Todo deletedTodo = todoService.deleteById(todoNumber);
		
		if(deletedTodo != null) {
			todoView.delete(deletedTodo);
		}else {
			errorObject = new Exception("수정 실패");
			todoView.errorPage(errorObject);
		}
		
	}



}
