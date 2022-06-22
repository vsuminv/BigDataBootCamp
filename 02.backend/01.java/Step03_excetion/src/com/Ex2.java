package com;

public class Ex2 {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for (int i = 0; i < args.length; i++) {
			
		}
		
//		number값을 랜덤값으로 나눈 결과 출력
		for(int i = 0; i < 10; i ++) {
			try {
				result = number/(int)(Math.random()*10);
				System.out.println(result);
				// exception이라는 인스턴스는 코드의 실행 과정에서 0으로 나누는 예외가 발생하면 그때
				// new ArithmeticException(); 인스턴스를 생성하고, exception 변수에 초기화.
				// exception = new ArithmeticException(); 이 이루어짐.
				
				
				
//			즉, 0으로 나누는 예외가 발생하기 전까지 exception 변수는 선언만 되어 있는 상태인데,
//			0으로 나누는 예외가 발생하면 그 때 인스턴스가 생성되어서 exception 변수가 초기화됨
			} catch (ArithmeticException exception) {
				System.out.println("손님 , 0으로 나누시면 안됩니다.");
//				exception.printStackTrace();
				System.out.println(exception.getMessage());
			}// try-catch 끝
		}//for 끝
	}// main 끝

}// Ex2 끝
