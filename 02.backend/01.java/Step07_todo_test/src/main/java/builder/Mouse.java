package builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//
//@Setter
//@Getter
//@ToString
//@NoArgsConstructor //NoArgs(Arguments) 인자값이 없는 기본 생성자
//@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 
public class Mouse {
	private String name;
	private String address;
	private String color;
	private int age;
	private int height;
	

//	//기본 생성자
//	public Mouse() {	
//	}
//	
//	//이름만 알고 있을 떄
//	public Mouse(String name) {
////		this.name = name; //this : 인스턴스 자기 자신 
////		this(); // this(): 생성자 호출
//		this(name,null,null,0,0);
//	}
//	
//	//이름, 주소를 알고 있을 때
//	public Mouse(String name, String address) {
//		this(name,address,null,0,0);
//	}
//	public Mouse(String name, String address, String color, int age, int height) {
//		super();
//		this.name = name;
//		this.address = address;
//		this.color = color;
//		this.age = age;
//		this.height = height;
//	}


	@Override
	public String toString() {
		return "Mouse [name=" + name + ", address=" + address + ", color=" + color + ", age=" + age + ", height="
				+ height + "]";
	}
	
	public Mouse(Builder builder) {
		this.name = builder.name;
		this.address = builder.address;
		this.color = builder.color;
		this.age = builder.age;
		this.height = builder.height;
		
	}
	
	
	public static class Builder {
		private String name;
		private String address;
		private String color;
		private int age;
		private int height;
		
		//name이 필수로 작성해야하는 필드일 경우
		public Builder(String name) {
			this.name=name;
			
		}
		
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		
		public Builder color(String color) {
			this.color = color;
			return this;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		
		public Builder height(int height) {
			this.height = height;
			return this;
		}
		
		public Mouse build() {
			return new Mouse(this); //다 작성했으면 완료하라는 의미
		}
	}
	
	
	
	
}

