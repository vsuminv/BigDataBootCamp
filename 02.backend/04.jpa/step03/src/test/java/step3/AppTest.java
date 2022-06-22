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
		 * 1. �а� ������ ����(��ǻ�� ���а�), ����
		 * 
		 * 2. �л� ������ ����(�л�1, �л�2) �� ��ǻ�� ���а��� ���� ���踦 ���� �� ����
		 */
		
		tx.begin();
		Major major1 = new Major("��ǻ�� ���а�");
		em.persist(major1);
		
		//2-1. �л�1 ����, ����
		Student student1 = new Student("Lee");
		student1.setMajor(major1); 
		em.persist(student1);// �������� ����
		
		//2-2. �л�2 ����, ����
		Student student2 = new Student("Kang");
		student2.setMajor(major1); // �������� ����
		em.persist(student2);
		
		
		tx.commit();
	}
	
	@Test
	public void readStudents() {//JPA�� �л� ����Ʈ ��ȸ
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
	public void testSaveNonOwnerWithJPA() {//JPA�� ������ ����� �������迡���� ������ �ƴ� ������ ���� �Է��� ���
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		//�а� ������ ����
		Major major1 = new Major("��ǻ�� ����");
		em.persist(major1);

		//�л�1 ����
		Student studnet1 = new Student("Lee");
//		studnet1.setMajor(major1); //���������� ���ο� �������� ����
		
		//���� ���������� ������ �ƴ� ������ �������踦 ������ ���
		List<Student> students = major1.getStudents();
		students.add(studnet1); 
		em.persist(studnet1);
		
		//�л�2 ����
		Student student2 = new Student("Kang");
		students.add(student2);
		em.persist(student2);
		
		tx.commit();
	}
	@Test
	public void testSaveOwnerWithOOP() { // ������ ��ü���� �ڵ忡�� ���������� ���� (��������� ������ �ʼ� / jpa������ �������ʸ� �ϸ� ��)
		Major major1 = new Major("��ǻ�� ����");
		List<Student> students = major1.getStudents();
		
		Student student1 = new Student("Lee");
		student1.setMajor(major1); //���������� ���� ���⿡�� �������� ����
		students.add(student1);// �ݴ��������� �������� ����

		Student student2 = new Student("Kang");
		student2.setMajor(major1); //���������� ���� ���⿡�� �������� ����
		students.add(student2);// �ݴ��������� �������� ����
		
		System.out.println("student.size" + students.size());

	}
	
	@Test
	public void biWidthJPA() { //JPA�� Ȱ���� ����� ����
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Major major1 = new Major("������");
		em.persist(major1);
		
		Student student1 = new Student("Park");
		
		//����� �������� ����
		student1.setMajor(major1); // ���������� ���� ���⿡�� ����
		List<Student> students = major1.getStudents();
		students.add(student1); //�ݴ��������� ����
		em.persist(student1); //����ȭ
		
		// �л� 2�� ���� �� �������� ����, ����ȭ
		Student student2 = new Student("kim");
		student2.setMajor(major1);
		students.add(student2);
		em.persist(student2);
		tx.commit(); //flusch()�� ���������� �߻�. db�� �����Ͱ� ��
		//select s.* , m.major_name FROM student s JOIN major m ON s.major_id = m.major_id where s.major_od = 2;
	}

}