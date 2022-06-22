package com;

public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int list[] = {1,2,3};
		
		try {
			for (int i = 0; i <= list.length; i++) {
				System.out.println(list[i]);
			}
		} catch (Exception e) {
				System.out.println("배열 크기가 다릅니다");
		
		}

	}

}
