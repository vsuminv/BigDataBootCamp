package builder;


public class MouseTest {
	public static void main(String[] args) {
		
//		//jerry의 주소,키를 모를 때
//		Mouse jerry = new Mouse("제리",null,"갈색",2,0);
//		
//		//위 코드 안에 위치에 뭐가 뭔지  null에 값을 무엇을 넣는지  모르기 때문에 가독성 높이기 위해 점층적 생성자 패턴 사용 //오버로딩 사용
//		Mouse jay = new Mouse();
//		System.out.println(jay); //원래 주소가 출력되지만 내부적으로 tostring으로 출력해줌
//		
//		//이름만 알고 있을 떄
//		Mouse jamie = new Mouse("제이미");
//		System.out.println(jamie);
//		
//		// 이름, 주소 알고 있을 떄 
//		Mouse jayz = new Mouse("제이미","5");
//		System.out.println(jamie);
//		
		
		//빌드 패턴
		//Builder 클래스의 인스턴스
		Mouse jerry = new Mouse.Builder("제리")
								.address("하와이")
								.age(5).height(50)
								.build();
		System.out.println(jerry);
		
	}

	
}

