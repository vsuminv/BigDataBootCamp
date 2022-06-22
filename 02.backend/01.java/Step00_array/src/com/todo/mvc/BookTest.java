package com.todo.mvc;

public class BookTest {

	public static void main(String[] args) {
//		���̰� 3�� Book Ÿ���� ��ü �迭
		Book[] books = new Book[3];
		
		Book book1 = new Book("노인과 바다","헤밍웨이");
		System.out.println(book1);
		System.out.println(book1.getBookname());
		
		books[0] = book1;
		books[1] = new Book("어린왕자","생텍쥐페리");
		books[2] = new Book("다빈치 코드","댄 브라운");
		
//		�ݺ������� ������� ���ڸ� ���
		for (Book book : books) {
			System.out.println(book.getBookname()+ " "+ book.getAuthor());
		}

	}

}
