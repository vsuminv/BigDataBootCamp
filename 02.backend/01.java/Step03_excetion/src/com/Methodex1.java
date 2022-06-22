package com;

public class Methodex1 {

//	MethodEx1의 멤버 메소드
	public static void main(String[] args) {
		method1();
	}
	
//	MethodEx1의 멤버 메소드 2
	static void method1() {
		try {
			method2();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("method1() 호출");
	}
	
//	MethodEx1의 멤버 메서드 3
	static void method2() throws Exception{
//		해당 예외에 대한 예외 처리를 method2()를 호출한 호출부에서 처리하도록 책임을 떠넘김.
//		throw new Exception("예외를 고의로 발생시킴");
	}

}
