package com;

public class Throw2 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
//		throw new Exception("이러면 어떡하지?"); //컴파일 오류
		
		throw new RuntimeException("이건 왜 컴파일 되지?");

	}

}
