package step02;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import dev.sample.model.Major;
import dev.sample.model.Student;

public class AppTest {
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test // testSave에 커서를 두고 우클릭 run하면 초록색으로 실행/ 전체 런하면 갈색됨
	public void testSave() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		//학과 페이지 생성
		Major major1 = new Major("컴퓨터 공학");
		em.persist(major1); // entitymanage가 major1 엔티티를 영속화(persist) 시켜줘
		
		//학생 데이터 저장
		Student student1 = new Student("Lee");
		// 연관관계 설정(외래키 설정)
		student1.setMajor(major1); 
		
		em.persist(student1); //entitymanage가 student1 엔티티를 영속화(persist) 시켜줘
		
		//학생 2 생성, 컴공과로 맵핑, 저장(INSERT)
		Student student2 = new Student("Kang");
		student2.setMajor(major1);
		
		
		em.persist(student2);
		
		tx.commit();
		
	}
	@Test
	public void testRead() { //전공 이름 조회
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		
		Student student = em.find(Student.class, 1L);
		System.out.println(student);
		Major major = student.getMajor();
		System.out.println("전공 이름 :" + major.getMajorName());
	}
	@Test
	public void updateRelation() {
		/*
		 * 1. 새로운 major 국문화과 생성, 영속화(persist)
		 * 2. 학생(1L) 조회 후(find), 새로운 학과(국문학과)로 설정
		 * 
		 */
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Major major2 = new Major("국문학과");
		em.persist(major2);
		
		Student student1 = em.find(Student.class, 1L);
		student1.setMajor(major2); //em.update() 같은 별도 메서드는 없고, setXxx()을 활용하여 엔티티 변경
		tx.commit(); // commit()이 호출되면 flush()가 내부적으로 호출, 변경 감지 기능(dirty checking)동작, 변경 사항을 DB에 자동으로 반영시킴
	}
	@Test
	public void deleteRelation() { // 연관 관계 제거
		/*
		 * 1. 학생1의 전공을 제거(null)
		 * 
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Student student1 = em.find(Student.class, 1L);
		student1.setMajor(null);
		tx.commit();
		
	}
	
	@Test
	public void deleteEntity() {//Entity 제거, (table의 레코드 제거), delete from,
		/*
		 * 1. 컴퓨터 공학 전공 Entity를 DB에서 제거
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		//학과 폐지 전에 학생에게 미리 통보
		Student student1 = em.find(Student.class,1L);
		student1.setMajor(null);
		
		Student student2 = em.find(Student.class,2L);
		student2.setMajor(null);
		
		//학교 폐지
		Major major = em.find(Major.class, 1L);
		em.remove(major);
		tx.commit();
	}
}
