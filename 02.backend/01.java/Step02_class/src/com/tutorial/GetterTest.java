package com.tutorial;

public class GetterTest {

	public static void main(String[] args) {
		// Person 인스턴스의 필드값 조회
//		1. getter()를 통한 필드값 조회
		Person joo = new Person();
		joo.setName("주현영");
		joo.setAge(25);
		
		System.out.println(joo.getName());
		System.out.println(joo.getAge());
		
//		생성자 함수를 제외하고,
//		setter()를 호출하지 않아도, 필드값을 설정할 수 있음
//		getter()를 호출하지 않아도, 필드값에 접근할 수 있음
		Person kwon = new Person();
		kwon.setAge(20);
		kwon.setAge(200);
		System.out.println(kwon.getAge());
		
		
	}

}
