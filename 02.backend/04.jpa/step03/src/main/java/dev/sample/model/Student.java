package dev.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="STUDENT_ID") //TABLE�� �÷����� STUDENT_ID�� ����
	private Long id;
	
	@Column(name="STUDNET_NAME")
	private String studentName;
	
	@ManyToOne //student�� major�� ����� N:1(�ٴ��� ����)
	@JoinColumn(name="MAJOR_ID")
	private Major major;
	
	//�⺻������
	public Student() {}
	
	public Student(Long id, String studentName) {
		super();
		this.id = id;
		this.studentName = studentName;
	}
	
	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public Major getMajor() {
		return major;
	}


	public void setMajor(Major major) {
		this.major = major;
	}

//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", studentName=" + studentName + ", major=" + major + "]";
//	}

	
}