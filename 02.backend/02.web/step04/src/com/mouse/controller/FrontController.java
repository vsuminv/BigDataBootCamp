package com.mouse.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.subcontroller.MouseDeleteController;
import com.mouse.controller.subcontroller.MouseInsertController;
import com.mouse.controller.subcontroller.MouseListController;
import com.mouse.controller.subcontroller.MouseReadController;
import com.mouse.controller.subcontroller.MouseUpdateController;

@WebServlet("/board")
public class FrontController extends HttpServlet {
	// 필드 생성 및 null로 초기화
	HashMap<String, Controller> list = null;

	@Override
	// 서블릿 초기화 기능 담당, list라는 문자열으로 클라이언트에서 날라오면 new MouseListController로 넣겠다.
	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<String, Controller>();
		list.put("list", new MouseListController());
		list.put("insert", new MouseInsertController());
		list.put("read", new MouseReadController());
		list.put("update", new MouseUpdateController());
		list.put("delete", new MouseDeleteController());
		System.out.println("init() 호출");
		System.out.println(list.toString());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// 아무값이 없으면 list 문자열로 comm에 넣어줘~ 그럼
		// localhost:8080/step04/board?command=값
		String comm = req.getParameter("command");
		System.out.println("command는 " + comm);
		if (comm == null) {
			comm = "list";
		}
		// command가 "list"일경우, HashMap의 "list"하는 key의 인스턴스를 얻어옴
		// 다형성 개념으로 Controller 인터페이스는 MouseListController가 구현한 메서드이기 때문이다.
		// Controller subController = new MouseListController(); 치환됨
		// hashmap타입인 list에 키값이 "list"이고, value는 new MouseListContrller()를 줘~
		// 그런 다음 인터페이스타입인 subController인 변수에 담겠다~
		// Controller인터페이스에 있는 메서드 excute 실행
		Controller subController = list.get(comm);
		subController.excute(req, resp);
	}

}