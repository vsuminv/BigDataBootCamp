package com.builder;

public class MouseTest {
	public static void main(String[] args) {
		
		//jerry의 주소,키를 모를 때
		Mouse jerry = new Mouse("제리",null,"갈색",2,0);
		
		//위 코드 안에 위치에 뭐가 뭔지  null에 값을 무엇을 넣는지  모르기 때문에 가독성 높이기 위해 점층적 생성자 패턴 사용 //오버로딩 사용
		Mouse jay = new Mouse();
		System.out.println(jay);
		
		//이름만 알고 있을 떄
		Mouse jamie = new Mouse("제이미");
		System.out.println(jamie);
		
		
		
	}

	
}
