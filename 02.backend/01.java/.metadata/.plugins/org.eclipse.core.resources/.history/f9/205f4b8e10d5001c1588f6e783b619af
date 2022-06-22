package com.book.view;

import java.util.Scanner;
import java.util.List;

import com.book.model.Book;

public class BookView {

	// 첫 화면에 베스트셀러 출력하도록 하려면 controller에서 BookService.java를 이용하여 top5 book list받은 후 
	// systemStart()의 매개변수로 받아 여기서 출력해주기
	public String programStart(List<Book> books) {
		String choice="";
		System.out.println("\n ==== > Book Rental < ====\n"+"\n ==== > Best 5 < ====\n");
		
		// Best 5 출력되도록~~~~
		System.out.println("베스트셀러 리스트입니다.");
		for(Book book : books) {
			System.out.println(book);
		}
	
		// 원하는 Service 선택
		System.out.println("1.책 대여          2.책 추가           3.책 파손          4.프로그램 종료\n");
		System.out.print("▷ 메뉴번호 선택 : ");
		Scanner sc = new Scanner(System.in);
		
		choice = sc.nextLine();
		
		return choice;
	}
	public void programEnd() {
		System.out.println("\n>>> 프로그램이 종료되었습니다 <<<");
		
	}

	public void programErrorPage() {
		System.out.println("\n>>> 메뉴에 없는 번호입니다. 다시 선택하세요. <<<");

	}
	// 파손된 책을 삭제하는 서비스 실행 시 출력되는 문구
	public String deleteBook() {
		System.out.print("\n▷ 파손된 책 이름 혹은 책 ID 입력 : ");
		Scanner sc = new Scanner(System.in);
		String brokenBook = sc.nextLine(); 
		return brokenBook;
	}

	// 파손된 책 정상적으로 삭제
	public void deleteBookSuccessPage(String brokenBook) {
		System.out.println(String.format("\n▷ SUCCESS! <%S> 해당 책이 정상적으로 삭제되었습니다.",brokenBook));		
	}
	// 파손된 책 삭제 과정에서 error발생
	public void deleteBookErrorPage(String brokenBook) {
		System.out.println(String.format("\n▷ FAIL! <%S> 해당 책이 존재하지 않습니다.",brokenBook));	
	}
	public Book SaveBook() {
		Scanner saveInput = new Scanner(System.in);
    	System.out.println("등록할 book_id :");
    	Long saveBookId = saveInput.nextLong();
    	saveInput.nextLine();
    	System.out.println("등록할 rank_id :");
    	int saveRank = saveInput.nextInt();
    	saveInput.nextLine();
    	System.out.println("등록할 title :");
    	String saveTitle = saveInput.nextLine();
    	System.out.println("등록할 author :");
    	String saveAuthor = saveInput.nextLine();
    	System.out.println("등록할 field :");
    	String saveField = saveInput.nextLine();
    	
    	Book newBook = new Book.Builder(saveBookId)
        		.rank(saveRank)
        		.title(saveTitle)
        		.author(saveAuthor)
        		.field(saveField)
        		.rentalStatus(true)
        		.build();
    
		return newBook;
	}
	public void successPage(Book saveBook) {
		System.out.println(String.format("\\n▷ SUCCESS! <%S> 해당 책이 정상 등록 되었습니다.",saveBook));
		
	}
	public void errorPage(Book saveBook) {
		System.out.println(String.format("\\n▷ FAIL! <%S> 해당 책이 정상 등록되지 않았습니다.",saveBook));
		
	}

	
	}


