package step3;

import static org.junit.Assert.fail;

import java.util.List;

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
	
	@Test
	public void testSave() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		/*
		 * 1. 학과 데이터 생성(컴퓨터 공학과), 저장
		 * 
		 * 2. 학생 데이터 생성(학생1, 학생2) 및 컴퓨터 공학과와 연관 관계를 설정 후 저장
		 */
		
		tx.begin();
		Major major1 = new Major("컴퓨터 공학과");
		em.persist(major1);
		
		//2-1. 학생1 생성, 저장
		Student student1 = new Student("Lee");
		student1.setMajor(major1); 
		em.persist(student1);// 연관관계 설정
		
		//2-2. 학생2 생성, 저장
		Student student2 = new Student("Kang");
		student2.setMajor(major1); // 연관관계 설정
		em.persist(student2);
		
		
		tx.commit();
	}
	
	@Test
	public void readStudents() {//JPA로 학생 리스트 조회
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		
		Major major = em.find(Major.class, 1L);
		System.out.println(major);
		System.out.println(major.getStudents());
		
		List<Student> students = major.getStudents();
		for(Student student : students) {
			System.out.println(student.getStudentName());
		}
		
	}
	@Test
	public void testSaveNonOwnerWithJPA() {//JPA를 적용한 양방향 연관관계에서의 주인이 아닌 곳에만 값을 입력할 경우
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		//학과 데이터 저장
		Major major1 = new Major("컴퓨터 공학");
		em.persist(major1);

		//학생1 저장
		Student studnet1 = new Student("Lee");
//		studnet1.setMajor(major1); //연관관계의 주인에 연관관계 설정
		
		//만약 연관관계의 주인이 아닌 곳에만 연관관계를 설정할 경우
		List<Student> students = major1.getStudents();
		students.add(studnet1); 
		em.persist(studnet1);
		
		//학생2 저장
		Student student2 = new Student("Kang");
		students.add(student2);
		em.persist(student2);
		
		tx.commit();
	}
	@Test
	public void testSaveOwnerWithOOP() { // 순수한 객체지향 코드에서 연관관계의 설정 (양방향으로 설정이 필수 / jpa에서는 주인인쪽만 하면 됨)
		Major major1 = new Major("컴퓨터 공학");
		List<Student> students = major1.getStudents();
		
		Student student1 = new Student("Lee");
		student1.setMajor(major1); //연관관계의 주인 방향에서 연관관계 설정
		students.add(student1);// 반대편에서도 연관관계 설정

		Student student2 = new Student("Kang");
		student2.setMajor(major1); //연관관계의 주인 방향에서 연관관계 설정
		students.add(student2);// 반대편에서도 연관관계 설정
		
		System.out.println("student.size" + students.size());

	}
	
	@Test
	public void biWidthJPA() { //JPA를 활용한 양방향 맵핑
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Major major1 = new Major("국문학");
		em.persist(major1);
		
		Student student1 = new Student("Park");
		
		//양방향 연관관계 설정
		student1.setMajor(major1); // 연관관계의 주인 방향에서 설정
		List<Student> students = major1.getStudents();
		students.add(student1); //반대편에서도 설정
		em.persist(student1); //영속화
		
		// 학생 2도 생성 및 연관관계 설정, 영속화
		Student student2 = new Student("kim");
		student2.setMajor(major1);
		students.add(student2);
		em.persist(student2);
		tx.commit(); //flusch()가 내부적으로 발생. db에 데이터가 들어감
		//select s.* , m.major_name FROM student s JOIN major m ON s.major_id = m.major_id where s.major_od = 2;
	}

}
