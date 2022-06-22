package com.mouse.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;
import com.mouse.util.HttpUitl;

public class MouseUpdateController implements Controller {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Update Controller입니다.");
//		
		//프론트에서 입력한 데이터 받기(mouseInsert.jsp에서 mouse 등록 폼에서 입력ㅎ나 mouse 정보 추출)
		String id = request.getParameter("id"); //자동으로 받기 떄문에 생략가능
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");

		Mouse mouse = new Mouse();
		mouse.setId(Integer.parseInt(id));
		mouse.setName(name);
		mouse.setCountry(country);
		mouse.setAddress(address);

		MouseService service = MouseService.getInstance();


		// 등록 처리용 메서드 int mouseInsert(Mouse mouse) 호출
		int result = service.mouseUpdate(mouse);

		String path = "board?command=list";


		HttpUitl.redirect(response, path);
	}

}
