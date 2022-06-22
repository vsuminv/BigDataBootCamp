package com.mouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	
	///excuter 메서드 선언
	//Controller 인터페이스를 구현하는 클래스들은 해달 메서드를 재정의(Override)해야함.
	public void excute(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException;
}
