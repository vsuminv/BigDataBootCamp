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

// index.jsp���� ���� ��û�� ó������ �޴� ��Ʈ�ѷ�(Servlet)

//@Controller // @Component�� �������� ���̹�
//@Controller�� ��ȿ�� ������ ex1~ex3
@RestController //
public class BookController {
	// 1. String���� �ش� �������� ��ȯ�ϴ� ���
	
	@RequestMapping("/add")
	public String ex1(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		System.out.println(name);
		System.out.println(author);
		
		// ������ ������ �̵�
		// forward or redirect
		
		return "result1.jsp";
	}
	
	//2. ModelAndView Ȱ���� 
	@RequestMapping("/add2")
	public ModelAndView ex2(HttpServletRequest requset, HttpServletResponse response) {
		String name = requset.getParameter("name");
		
		//�̵��� ������ �� �������� ������ ��ü�� ����  ModelAndView ��ü ����
		//Model : �������� ������ ��ü
		//View : �̵��� ������ ���
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("result2.jsp");
		
		modelAndView.addObject("bookName",name);
		
		return modelAndView;
	}
	
	//3. RequsetParam Ȱ����, ������ ����ϴ� HttpServletRequset, response�� ������� �ʴ� ���
	@RequestMapping("/add3")
	public ModelAndView ex3(@RequestParam("name") String name) {
		
		ModelAndView modelAndViw = new ModelAndView();
		modelAndViw.setViewName("result2.jsp");
		
		modelAndViw.addObject("bookName",name);
		
		return modelAndViw;
	}
	
	//4. JSON ��ü ��ȯ ���
	@RequestMapping("/add4")
	public Book ex4(@RequestParam("name") String name, @RequestParam("author") String author) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		//DB ���� �ڵ� Book ��ƼƼ ��ȯ
		
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