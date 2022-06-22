package com.todo.mvc;

public class App {

	public static void main(String[] args) {
		int studentId1 = 1;
		int studentId2 = 2;
		
//		int []  studentIDs = new int[3];

//		System.out.println(studentIDs.length);
//		
		int studentIDs [] = new int [] {studentId1, studentId2};
		
		System.out.println(studentIDs.length); //2
		
		System.out.println(studentIDs[0]); // 1
		System.out.println(studentIDs.toString()); //주소
		
		
//		���̰� 3�� ���ڿ� �迭 ����
		String [] studentNames = new String[3];
		System.out.println(studentNames.length); //3
		
//		�迭 ��� �߰�
		studentNames[0] = "노인과 바다";
		studentNames[1] = "어린왕자";
		studentNames[2] = "다빈치코드";
		
		for (int i = 0; i < studentNames.length; i++) {
			System.out.println(studentNames[i]);
		}
		
		for (String studentName : studentNames) {
			System.out.println(studentName);
		}

	}

}
