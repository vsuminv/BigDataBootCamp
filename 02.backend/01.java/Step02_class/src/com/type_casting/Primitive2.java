package com.type_casting;

public class Primitive2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 159305823;
		byte b = (byte)a; // 데이터의 손실이 발생
		System.out.println(b); 
		
		int c = 127;
		byte d = (byte)c;
		System.out.println(d);
		
		int f = 128;
		byte g = (byte)f;
		System.out.println(g);

	}

}
