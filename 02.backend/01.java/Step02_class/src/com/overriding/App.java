package com.overriding;

public class App {

	public static void main(String[] args) {
		Animal someAnimal = new Animal();
		someAnimal.name = "어떤 동물";
		someAnimal.showName();
		System.out.println();
		
		Mouse jerry  = new Mouse();
		jerry.name = "제리";
		jerry.address = "하와이";
		
		jerry.showName();//내 이름은 비밀이야
		
		jerry.showName("톰"); //톰 안녕, 내 이름은 제리야
		
//		다형성(Polymorphism)
		Animal animal = new Animal();
		Mouse jey = new Mouse(); 
		Animal mickey = new Mouse();// 하위 클래스인 Mouse 타입의 인스턴스를 상위 클래스인 Animal 타입의 참조변수에 대입
//		하위 타입에서 상위 타입으로의 형 변환은 자동
		
		mickey.name = "미키마우스";
//		mickey.address = "롯데타워"; // 상위타입의 참조변수 (Animal mickey)로 하위타입의 멤버(address) 사용불가
		
		mickey.showName(); //mickey는 상위타입(Animal)의 참조변수지만, 오버라이딩이 되어있기 때문에 예외적으로 사용 가능
		
//		mickey.showAddr(); //상위타입의 참조변수 (Animal mickey)로 하위타입의 멤버(showAddr()) 사용(접근)불가

	}

}
