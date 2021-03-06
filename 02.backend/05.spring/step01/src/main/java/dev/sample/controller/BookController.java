package dev.sample.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dev.sample.model.Book;

// index.jsp에서 보낸 요청을 처음으로 받는 컨트롤러(Servlet)

//@Controller // @Component의 직관적인 네이밍
//@Controller가 유효한 범위는 ex1~ex3
@RestController //
public class BookController {
	// 1. String으로 해당 페이지를 반환하는 방식
	
	@RequestMapping("/add")
	public String ex1(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		System.out.println(name);
		System.out.println(author);
		
		// 기존의 페이지 이동
		// forward or redirect
		
		return "result1.jsp";
	}
	
	//2. ModelAndView 활용방식 
	@RequestMapping("/add2")
	public ModelAndView ex2(HttpServletRequest requset, HttpServletResponse response) {
		String name = requset.getParameter("name");
		
		//이동할 페이지 및 페이지에 전달할 객체를 담을  ModelAndView 객체 생성
		//Model : 페이지에 전달할 객체
		//View : 이동할 페이지 담당
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("result2.jsp");
		
		modelAndView.addObject("bookName",name);
		
		return modelAndView;
	}
	
	//3. RequsetParam 활용방식, 기존에 사용하던 HttpServletRequset, response를 사용하지 않는 방식
	@RequestMapping("/add3")
	public ModelAndView ex3(@RequestParam("name") String name) {
		
		ModelAndView modelAndViw = new ModelAndView();
		modelAndViw.setViewName("result2.jsp");
		
		modelAndViw.addObject("bookName",name);
		
		return modelAndViw;
	}
	
	//4. JSON 객체 반환 방식
	@RequestMapping("/add4")
	public Book ex4(@RequestParam("name") String name, @RequestParam("author") String author) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		//DB 쿼리 코드 Book 엔티티 반환
		
		tx.begin();
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		em.persist(book);
		
//		Book result = em.find(Book.class, 1);
		tx.commit();
		
		
		return book;
	}
}