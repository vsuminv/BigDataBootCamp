package com.overloading;

public class Mouse {
	private int age;
	private String name; 
	
//	기본 생성자
	public Mouse() {}
	
//	나이만 전달받는 생성자
	public Mouse(int age) { this.age = age;}
	
//	이름만 전달 받는 생성자
	public Mouse(String name) {this.name = name;}
	
//	나이, 이름을  지정하여 생성하는 생성자
	public Mouse(int age, String name) {this.age = age; this.name = name;}

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
