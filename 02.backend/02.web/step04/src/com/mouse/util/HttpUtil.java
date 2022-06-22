package com.mouse.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//페이지 이동이 필요한 메서드를 하나의 클래스로 뺌
public class HttpUtil {
	
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {
		//실제 페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			
		//실제 요청객체와 응답객체를 request, reponse에 담았기 때문에 두가지 값을 받음
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void redirect(HttpServletResponse response, String path) {
		try {
			response.sendRedirect(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
