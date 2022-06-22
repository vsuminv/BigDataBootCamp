package com.polymorphism2;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Animal 타입의 참조변수 animal로 Whale 타입의 인트턴스 생성
		Animal animal = new Whale();
		animal.name = "Animal 타입으로";
		
		animal.Sing();
		
		Whale whale = new  Whale();
		whale.name = "Whale 타입으로";
		whale.Sing();
		
//		animal.swim(); //상위 타입의 참조변수로는 하위 타입의 멤버 사용 불가
	}

}
