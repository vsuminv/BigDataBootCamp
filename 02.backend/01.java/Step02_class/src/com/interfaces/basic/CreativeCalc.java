package com.interfaces.basic;

public class CreativeCalc implements Calc {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		int c = 5; //랜덤값
		return a+b+c;
	}

	@Override
	public int substract(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
