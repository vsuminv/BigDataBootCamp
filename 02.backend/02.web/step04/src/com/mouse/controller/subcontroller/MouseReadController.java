package com.mouse.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;
import com.mouse.util.HttpUitl;

public class MouseReadController implements Controller{
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("read 컨드롤러입니다.");
		
		String path = null;
		String id = request.getParameter("id");
//		System.out.println("id는" + id);
		
		//mouseUpdate.jsp로 이동
		MouseService service = MouseService.getInstance();
//		
//		Mouse mouse = service.mouseRead(id);
//		System.out.println(mouse); // mouseListView에서 아이디 클릭하면 콘솔창에 id~address출력
		
		
		try {
			Mouse mouse = service.mouseRead(id);
			//mouse 인스턴스를 request 객체를 담아서 공유해주는 코드
			request.setAttribute("mouse", mouse);
			
			//mouseUpdate.jsp로 이동
			path = "mouseUpdate.jsp";
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
			path = "error.jsp";
		}
		
		//실제 페이지 포워딩
		HttpUitl.forward(request, response, path);
		 
	}


}
