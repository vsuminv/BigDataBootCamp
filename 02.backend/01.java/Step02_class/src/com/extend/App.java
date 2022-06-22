package com.extend;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal anAnimal = new Animal();
		anAnimal.sing();
		
		Mouse jerry = new Mouse(15,"제리","뉴욕");
		
		jerry.sing();
		
		System.out.println(jerry.toString());
		System.out.println(jerry);

	}

}
