package com;

public class Ex3 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(2.5);
			System.out.println(3/0); // 예외가 발생해서, 예외 인스턴스(new ArithmeticException())가 생성되는 부분
			System.out.println(3); //위에서 예외가 발생해서 실행 안 됨
		} catch (Exception e) {
//			코드를 자유롭게 작성 가능한 부분
			if(e instanceof ArithmeticException) {
//				참초 변수 exception 내부에 들어있는 실제 인스턴스 ArithmeticException 클래스의 인스턴스인지 확인하는 연산자
//				실제 인스턴스가 ArithmeticException이면 해당 조건식의 결과값은 true, 아니면 false
				System.out.println(e instanceof ArithmeticException);
				System.out.println("true");
			}
			System.out.println(4);
		}
		System.out.println(5);

	}

}
