package com.basic;

import java.util.ArrayList;

public class ArrayListTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })

	public static void main(String[] args) {
		Mouse mini = new Mouse(10, "미니", "하와이", "구직중");
		Mouse mickey = new Mouse(25, "미키", "런던", "맨체스터 유나이티드");
		Mouse jay = new Mouse(15, "제이", "상하이", "텐센트");
		Mouse jerry = new Mouse(20, "제리", "도쿄", "라인");
		Mouse jamie = new Mouse(40, "제이미", "대한민국", "삼성");
		
//	     중복이 허용. 순서가 있음
//	   ArrayList 객체 생성, JS에서의 array와 같음
	   ArrayList list = new ArrayList();
	   System.out.println(list.size());
	   list.add(mini);
	   list.add(mickey);
	   list.add(jay);
	   list.add(jerry);
	   list.add(jamie);
	   
//	   리스트의 전체 길이(요소의 개수) 조회
	   System.out.println(list.size());
	   
//	   1번째 인덱스 조회
	   System.out.println(list.get(0));
	   
//	   3번쨰 요소 삭제
	   System.out.println(list.remove(2) + "요소 삭제");
	   
	   
//	   전체 요소 조회
	   System.out.println("전체 요소 조회");
	   for (Object object : list) {
		   System.out.println((Mouse)object);
		
	}
	}

	
}
