package com.local_global;

public class Animal {
	int age; // 인스턴스 변수
	static String kind; //static(클래스)
	void instanceMethod() { //인스턴스 메서드
		System.out.println(age); //age는 인스턴스 변수기 떄문에 접근 가능
//		인스턴스 메서드를 호출한다는 것은 객체가 이미 생성되었다는 것이기 떄문
		System.out.println(kind);
	}
	
	static void staticMethod() {
//		System.out.println(age); // staticMethod()가 올라갈 ㅅ점에는 인스턴스가 생성되지 않았을 수 있기 떄문에 접근 불가능
		
		System.out.println(kind); //둘 다 static 키워드가 있기 떄문에 가능
		
//		instanceMethod()  // age와 같은 의미로 안 됨
		
//		만약 여기서 객체(인스턴스)를 생성한다면?
		Animal a = new Animal(); //static 메서드 내부라고 할지라도, 객체(인스턴스)가 생성되었기 떄문에 그 다음부터는 접근이 가능해짐
		System.out.println(a.age);
		a.instanceMethod();
		
	}
	
	

}
