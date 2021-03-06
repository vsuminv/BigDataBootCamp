package dev.sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.sample.model.Book;

public class App {

	public static void main(String[] args) {
		
		//JPA의 인터페이스 화용
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01");
		
		//EntityManagerFactory를 통해 EntityManager 객체 생성
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin(); // 트랜잭션 시작
			Book book = new Book();		
			
//			book.setBookName("노인과 바다");
			
			//등록, em.persist(등록할 enettity)실제로 DB에 INSERT 처리
//			em.persist(book);
			
			//수정, em.update() 같은 별도의 수정 메서드는 존재하지 않음
			//setXxx로 가져와 데이터 수정
//			book.setBookName("바다와 노인");
			
			Book findBook = em.find(Book.class,1L);
			System.out.println(findBook.getBookName());
			
			//삭제: em.remove(삭제할 entity)
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
