package com.interfaces.basic;

public interface Calc {
//	상수와 추상 메서드만 작성할 수 있음
	
//	상수, public static final은 작성하지 않아도 컴파일러가 자동으로 생성해줌
	public static final double PI =3.14;
	public static final int ERROR = -999999;
	
//	추상 메서드, public static final은 작성하지 않아도 컴파일러가 자동으로 생성해줌
	public abstract int add(int a, int b);
	public abstract int substract(int a, int b);
	
//	기본으로 작성해두고 다른 클래스에서 원하는 걸로 바꿔서 사용가능, 교체해서 사용할 수 있음(CreativeCalc 처럼) app.java에서는 클래스만 바꾸면 됨
	

}
