package com.tutorial;

public class ConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Person p = new Person();
//		p.showPerson("톰", 12);
		
		Person tom = new Person("톰",2);
		System.out.println(tom.showPerson());

		Person jerry = new Person("제리",95);
		System.out.println(jerry.showPerson());
		
		System.out.println(tom == jerry);
		
		System.out.println(tom);
		System.out.println(jerry);
		
//		기본 생성자로 인스턴스를 생성하려면?
		Person somebody = new Person();
	}

}
