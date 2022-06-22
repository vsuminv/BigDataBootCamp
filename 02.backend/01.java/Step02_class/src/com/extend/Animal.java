package com.extend;

public class Animal {
	private int age; //멤버 변수  중에서도 인스턴스 변
	private String color;
	
//	기본 생성자
	public Animal() { super(); }
	
//	모든 필드를 매개변수로 받는 생성자
	public Animal(int age, String color) {
		super();
		System.out.println("Animal(age,color)호출");
		this.age = age;
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
//	void sing()
	public void sing() {
		System.out.println("동물은 어떻게 울지?");
	}
	
	
	


}
