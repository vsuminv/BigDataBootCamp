package dev.sample.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sample.demo.model.Todo;
import dev.sample.demo.service.TodoService;
import lombok.Delegate;

@RestController //json 데이터를 자동으로 직렬화 + Component
@RequestMapping("api/v1/todos") //localhost:8080/api/v1까지 작성해야 TodoController에 접근 가능
@CrossOrigin("*")
public class TodoController {
	//실제 DB에 접근해서 현재 Todo 가져오는 코드 작성
//	TodoService service = new TodoServiceImpl();
	
	@Autowired //필드를 통한 인젝션(주입, DI)
	private TodoService todoService;

	@GetMapping
	public List<Todo> findAll() {
		System.out.println("find All()");
		return todoService.findAll();
	}

//	@PostMapping
//	public String save() {
//		return "save() calles";
//	}
	
	
	@PostMapping 
	public Todo save(@RequestBody Todo todo) { //@Requset - 클라이언트가 보낸 값을 Todo의 필드와 맵핑해서 객체형태로 구성
		System.out.println(todo.getTitle());
		return todoService.save(todo);
	}
	
//	@PutMapping
//	public List<Todo> update(@RequestBody Todo todo){
//		return todoService.update(todo);
//	}
	
	

	
	@DeleteMapping("/{id}")
	public List<Todo> delete(@PathVariable ("id") Long id){
		System.out.println(id);
		return todoService.delete(id);
	}

}
