package com.reference;

public class App {

	public static void main(String[] args) {
//		학생 인스턴스 2개 생성
		
		Student park = new Student("박서준", 20);
		Student han = new Student("한소희",20);
		
		System.out.println(park.getAge() + park.getName());
		
		System.out.println(han.getAge() + han.getName());
		

	}

}
