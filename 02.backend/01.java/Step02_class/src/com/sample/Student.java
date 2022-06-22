package com.sample;

// 클래스 외부에는 package 선언과 import 문장 외에는 아무것도 선언하지 않는다.

public class Student {

//	멤버 변수(멤버 필드) => Student(학생)이 가진 속성들을 '정의. 선언'
	int studentID; // 학번
	String studentName; // 학생 이름
	int grade; // 학년
	String adress; // 주소, 사는 곳
	
//	기본 생성자(함수), Default Constructor
//	기본 생성자는 별도로 작성하지 않아도 생성됨
	public Student() {}
	
	public Student (String studentName, int grade) {
		this.studentName = studentName;
		this.grade = grade;
	}

//	멤버 메서드: Student(학생)이 할 수 있는 기능, 행위
	public void showStudent() {
//		1. 첫 번쨰 멤버 메서드, 학생의 이름과 주소만 출력해주는 메서드
//		prototype : (접근제어자) 반환 타입  메서드명() {}
//		void : 반환 타입이 따로 없을 때 사용하는 키워드

//		현재 showStudent()는 학생의 이름과 주소를 출력만 해주고 있고,
//		별도의 값(value)을 반환하고 있지는 않음
//		왜냐하면 return이라는 키워드가 없기 때문
		System.out.println("showStudent() 호출");
		System.out.println(studentName + "," + grade);
	}

}
