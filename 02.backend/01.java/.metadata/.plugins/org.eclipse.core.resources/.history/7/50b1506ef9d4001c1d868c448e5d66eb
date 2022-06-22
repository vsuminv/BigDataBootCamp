package com.book;


import java.util.Scanner;

import com.book.controller.BookController;


public class App {
	static BookController bookController;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		System.out.println("반납할 책을 입력해주세요:");
//		title = sc.next();
		
		bookController = new BookController();

		
		System.out.println("번호를 선택하세요.");
		System.out.print("1.책 대여여부 2. 책 대출 반납  3.실행 종료");
		int number = sc.nextInt();
		
		while(true) {
			if (number == 1) {
				bookController.rentalCheck();
				//findbyid처럼 책이름 처자 등을 검색 후 대여 했는지 확인
			}
			else if(number == 2) {
				//책 대출 반납 -- 책 이름 입력 후 결과를 false이면 true로 반환
				bookController.updateById();
			}else {
				System.out.println("실행을 종료합니다");
				System.exit(0);
			}
			
		}
	

	}


}