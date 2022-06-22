package step01.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 서버에서 쿠키 확인하기
@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies(); //요청 객체에 배열(쿠기)을 반환
		
		//SetCookieServlet에서 보내준 쿠키 정보를 서버에서 비교해서 맞는지(상태정보) 확인 후 처리
		for (Cookie cookie : cookies) {
			out.printf("%s : %s", cookie.getName(),cookie.getValue() + "<br/>");
		}
		
		out.close();
	}



}
