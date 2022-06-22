package step04.query.string;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/queryTestEng")
public class QueryServletEng extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서버에서 클라이언트로 응답할 떄 참고로 안내할 응답한 문서(html)의 타입, 문자셋(charset) 지정
		response.setContentType("text/html;charset=UTF-8");
			
		//출력을 위한 PrintWriter 객체 생성
		PrintWriter out = response.getWriter();
		
		//출력문으로 <h1>GET방식으로 요청되었음</h1>
		String id = request.getParameter("id");
		String passwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		//checkbox의 값 받기
		String[] habbies = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String introduction = request.getParameter("introduction");
		
		out.print("Id : " + id  + "<br/>");
		out.print(" pw : " + passwd   + "<br/>");
		out.print( "name : "+ name + "<br/>");
		
		
		for(String hooby : habbies) {
			out.print(hooby);
		}
		
		out.print("gender : " + gender + "<br/>");
		out.print("country : " + country + "<br/>");
		out.print("introduction: " + introduction + "<br/>");
		
		out.print("<h1>GET방식으로 요청되었음</h1>");
		
		
		
		//자원 해제
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Post요청에 따른 encoding 타입 지정
		//서버가 클라이언트로부터 받을 때 참고 인코딩 타입
		// 클라이언트가 서버에 전달할 정보
		request.setCharacterEncoding("UTF-8");
		
		//서버에서 클라이언트로 응답할 떄 참고로 안내할 응답한 문서(html)의 타입, 문자셋(charset) 지정
		//서버가 클라이언트에게 참고로 안내할 문서 타입과 encoding을 명시
		//서버가 클라이언트에게 전달할 정보
		response.setContentType("text/html;charset=UTF-8");
			
		//출력을 위한 PrintWriter 객체 생성
		PrintWriter out = response.getWriter();
//		
//		//출력문으로 <h1>GET방식으로 요청되었음</h1>
		
//		//클라이언트(브라우저)에서 입력한 값 추출(꺼내기)
		String id = request.getParameter("id");
		String passwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		out.print("Id : " + id  + "<br/>");
		out.print(" pw : " + passwd   + "<br/>");
		out.print( "name : "+ name + "<br/>");
		
		//checkbox의 값 받기
		String[] hobbies = request.getParameterValues("hobby"); //배열은 getParameterValues 받기
		for (String hobby : hobbies) {
			out.print(hobby + "<br/>");
		}
		
	
		
		out.print("<h1>POST 방식(method)으로 요청되었씁니다.</h1>");
//		//자원 해제
		out.close();
	}

}
