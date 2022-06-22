package step03.pagemove;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/mouseInsert")
public class MouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		
		//form에서 입력된 값 받기
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		Mouse mouse = new Mouse();
		mouse.setName(name);
		mouse.setCountry(country);
		mouse.setAddress(address);
		System.out.println("DB 등록 처리 진행");
		
		request.setAttribute("mouse", mouse);//mouse라는 이름의 key값으로 mouse 인스턴스를 담았음.
		
		RequestDispatcher rd = request.getRequestDispatcher("mouseResult"); //MouseServlet2로 이동
		 
		//실제 포워딩(이동, 요청) -요청을 한 번만하기 떄문에 mouseInsert만 경로를 요청했기 때문에 mouseResult로 경로가 나오지 않음
		rd.forward(request, response); //MouseServlet의 requset와 respone는 MouseServlet2에서도 공유됨 
		
		out.close();
		
		
 	}

}
