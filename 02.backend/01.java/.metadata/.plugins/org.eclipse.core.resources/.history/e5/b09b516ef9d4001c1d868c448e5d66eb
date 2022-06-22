package com.book.controller;


import com.book.service.BookService;
import com.book.view.BookView;

public class BookController {
	private final BookService bookService;
	private final BookView bookView;
	private Exception errorObject;
	
	public BookController() {
		this.bookView = new BookView();
		this.bookService = new BookService();
	}

	public void updateById() {
		int previudsBook = bookService.updateById();

		
		if(previudsBook != 0) {
			bookView.update();
		}else {
			errorObject = new Exception("수정 실패");
			bookView.errorPage(errorObject);
		}
		
	}

	public void rentalCheck() {
		int previudsBook = bookService.rentalcheck();

		
		if(previudsBook != 0) {
			bookView.rentalcheck();
		}else {
			errorObject = new Exception("수정 실패");
			bookView.errorPage(errorObject);
		}
		
	}
	

}
