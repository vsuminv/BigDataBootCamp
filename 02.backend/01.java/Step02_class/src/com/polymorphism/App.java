package com.polymorphism;

public class App {

	public static void main(String[] args) {
//		Animal animal = new Animal();
//		Mammal mammal = new Mammal();
//		Whale whale = new Whale();
//		Cat cat = new Cat();
		
//		animal.showMe();
//		mammal.showMe();
//		whale.showMe();
//		cat.showMe();
		
//		다형성 적용, 상위 타입의 참조변수에 하위 타입의 인스턴스 초기화 가능
		Animal animal = new Animal();
		Mammal mammal = new Mammal();
		Whale whale = new Whale();
		Cat cat = new Cat();
//		
//		animal.showMe();
//		mammal.showMe();
//		whale.showMe();
//		cat.showMe();

//		객체 배열에 담고 반복문 활용한다면?
//		길이가 4인 Animal 타입의 배열 animals 생성
		Animal[] animals = new Animal[4];
		animals[0] = animal;
		animals[1] = mammal;
		animals[2] = new Whale(); 
		animals[3] = cat;
		
		for(Animal anAnimal : animals  ) {
			anAnimal.showMe();
		}
		

	}

}
