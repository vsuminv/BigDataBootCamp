package com.local_global;

public class App {

	public static void main(String[] args) {
//		countOfTail에 접근하기 위해서는 
		System.out.println(Mouse.countofTail); //static 키워드가 붙어있는 멤버는 프로그램 동작 시 바로 메모리에 등록되기 때문에  인스턴스(Mouse)를 생성하기 전에 접근(사용)이 가능하다. 해당 클래스 이름으로 곧바로 접근 가능
		
		Mouse jerry = new Mouse();
		System.out.println(jerry.countofTail); // 참조변수 명 보다는 클래스 명으로 사용하는 것을 권장 Mouse.countTail
		
		Mouse mickey = new Mouse();
		jerry.countofTail = 2;
		System.out.println("미키의 꼬리 : "+ mickey.countofTail);// 값을 공유하기 떄문에 jerry.coutofTail에 값을 넣어도 값을 공유하기 때문에 2나옴
	}
	
	

}
