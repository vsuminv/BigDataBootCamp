package com.interfaces.basic;

public class App {

	public static void main(String[] args) {
		// 구현한 계산기 기능을 사용하려면?
		
//		어떤 클래스의 인스턴스를 만들어야 하지?
//		CompleteCalc calculator = new CompleteCalc();

		//창의적인 계산기로 변경	
		CreativeCalc calculator = new CreativeCalc();
		
		int result = calculator.add(3, 5);
		System.out.println(result);
//		System.out.println(calculator.add(3, 5));
		
		
	}

}
