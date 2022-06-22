package com.sample;

public class App {
	
//  App클래스가 가진 객체(클래스, 정적, static) 메서드 main()
//	코드를 실행하면 Eclipse가 내부적으로 main()을 호출함
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(3,5));
		
		
//		학생 인스턴스 하나 생성
		Student s = new Student(); //생성자 호출
		
		s.showStudent();
		
		new Student("톰",3).showStudent();

	}

//	덧셈 기능을 제공하는 메서드, add(), 반환 타입은 int, 파라미터(매개	변수)로 a,b를 받음
	
	public static int add(int a, int b) {
//		int result = a + b;
//		System.out.println(result);
//		return result;
		return a + b;
	}
}
