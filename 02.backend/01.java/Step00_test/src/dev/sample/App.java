package dev.sample;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] person = new Person[2];
		
		person[0] = new Person("이수민",24);
		person[1] = new Person("홍길동", 33);
		
		for (Person persons : person) {
			System.out.println(persons.getName() + " "+ persons.getAge());
		}
	}

}
