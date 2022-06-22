package com.overriding;

public class Mouse extends Animal{
	public String address;
	
	public void showAdrr() {
		System.out.printf("%s는 %dp 살아",name, address);
	}
	
//	오버라이딩 - 재정의 : 상위 클래스의 메서드와 '같은' 메서드 이름, '같은' 인자 리스트
	public  void showName() {
		System.out.println("내 이름은 비밀이야");
	}
	
//	오버로딩 - 중복정의 : '같은' 메서드 이름, '다른'인자리스트, 상위 클래스와 관련 없는 개념
	public void showName(String yourname ) {
		System.out.printf("%s 안녕, 나는 %s야",yourname,name);
	}
	
}
