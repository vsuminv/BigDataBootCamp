package com.todo;

import java.time.LocalDate;

import com.todo.controller.TodoController;
import com.todo.model.Todo;
//import com.todo.view.TodoView;

public class App {


	public static void main(String[] args) {

		
		
//	Controller 생성 : 사용자의 요청(request)에 따라 등록, 조회 등 어떤 액션을 수행시킬지 분기 , 결정을 담담
		TodoController todoController = new TodoController();
		
//		전체 Todos 조회
		todoController.findAll();

		// 할 일 번호로 특정 Todo 조회
		Long todoNumber = 3L;
		todoController.findById(todoNumber);

//		하나의 Todo 등록
		Todo newTodo = new Todo("산책하기", "강아지와 산책한다", LocalDate.of(2022, 04, 05)); 
		todoController.save(newTodo);
		
//		전체 Todos 다시 조회
		todoController.findAll();
		

//		업데이트 기능
//		id값과 일치하는 데이터에 새로운 데이터로 덮어쓰기
		//		하나의 Todo 수정(UPDATE)
		todoController.updateById(todoNumber,new Todo("유튜브 보기","Ted ed를 시청한다",LocalDate.of(2022, 05, 10)));
		
//		UPDTAE 성공여부 확인
//		todoController.findById(todoNumber);
		todoController.findAll();

//		하나의 Todo 삭제 (DELETE)
		todoController.deleteById(todoNumber);
	
		todoController.findAll();
	}
	
	

}
