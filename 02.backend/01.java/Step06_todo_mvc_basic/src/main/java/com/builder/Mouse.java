package com.builder;

public class Mouse {
	private String name;
	private String address;
	private String color;
	private int age;
	private int height;
	
	//기본 생성자
	public Mouse() {	
	}
	
	//이름만 알고 있을 떄
	public Mouse(String name) {
//		this.name = name; //this : 인스턴스 자기 자신 
//		this(); // this(): 생성자 호출
		this(name,null,null,0,0);
	}
	public Mouse(String name, String address, String color, int age, int height) {
		super();
		this.name = name;
		this.address = address;
		this.color = color;
		this.age = age;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Mouse [name=" + name + ", address=" + address + ", color=" + color + ", age=" + age + ", height="
				+ height + "]";
	}
	
	
	
	
}

	
	
	
	

