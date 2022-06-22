package com.mouse.controller.subcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;
import com.mouse.util.HttpUitl;


//Controller 인터페이스를 구현할 구현 클래스
public class MouseListController implements Controller{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("list Controller입니다.");
		response.setContentType("text/html;charset=UTF-8");

		String path = null;
		
		MouseService service = MouseService.getInstance();
		

		try {
			ArrayList<Mouse> mouseList = service.mouseList();
			request.setAttribute("list", mouseList);
			
			path = "mouseListView.jsp";
			
//			System.out.println(mouseList);
//			PrintWriter out = response.getWriter();
//			out.print(mouseList.get(0).getId() + "<br/>");
//			out.print(mouseList.get(0).getName() + "<br/>");
//			out.print(mouseList.get(0).getCountry()  + "<br/>");
//			out.print(mouseList.get(0).getAddress()  + "<br/>");
//			out.close();
		} catch (SQLException e) {
			request.setAttribute("errorMessage", e.getMessage());
			path = "error.jsp";
		}
		//실제 페이지 이동
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);
		
		HttpUitl.forward(request, response, path);
		
		
	}

}
