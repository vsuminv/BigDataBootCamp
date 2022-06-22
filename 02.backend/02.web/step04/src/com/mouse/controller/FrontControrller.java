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
public class FrontControrller extends HttpServlet{
	
	HashMap<String, Controller> list = null;

	
	@Override
	public void init(ServletConfig config) throws ServletException { //서블릿 초기화 담담(처음 실행 시)

		list = new HashMap<String, Controller>();
		//값을 맵핑
		list.put("list", new MouseListController());
		list.put("insert", new MouseInsertController());
		list.put("read", new MouseReadController());
		list.put("update",new MouseUpdateController());
		list.put("delete", new MouseDeleteController());
	}

	//실제 분기하는 담당
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("command는"+command);
		
		if(command == null) { // 처음들ㅇ어왔을 때 목록을 보여줌
			command = "list";
		}
		
		//cammend가 list일 경우 HashMap의 "list"라는 key의 인스턴스를 얻어옴(list.get()를 통해서)
		// 아래 코드가 Controller subController = new MouseListController();로  치환됨
		Controller subController = list.get(command);
		Controller subConroller =new MouseListController();
		subController.excute(request, response);
		
	}

	
	

}
