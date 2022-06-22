package dev.sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.sample.model.Book;

public class App {

	public static void main(String[] args) {
		
		//JPA�� �������̽� ȭ��
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01");
		
		//EntityManagerFactory�� ���� EntityManager ��ü ����
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin(); // Ʈ����� ����
			Book book = new Book();		
			
//			book.setBookName("���ΰ� �ٴ�");
			
			//���, em.persist(����� enettity)������ DB�� INSERT ó��
//			em.persist(book);
			
			//����, em.update() ���� ������ ���� �޼���� �������� ����
			//setXxx�� ������ ������ ����
//			book.setBookName("�ٴٿ� ����");
			
			Book findBook = em.find(Book.class,1L);
			System.out.println(findBook.getBookName());
			
			//����: em.remove(������ entity)
			em.remove(findBook); //delete from book where id = 1L;
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}

}