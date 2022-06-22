package com;

public class Ex1 {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for (int i = 0; i < args.length; i++) {
			
		}
		
//		number값을 랜덤값으로 나눈 결과 출력
		for(int i = 0; i < 10; i ++) {
			result = number/(int)(Math.random()*10);
		}

	}

}
