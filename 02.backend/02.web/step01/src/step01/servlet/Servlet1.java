package step01.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class Servlet1 extends HttpServlet {
	
	public void init(ServletConfig config) {
		System.out.println("init() 실행됨");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service() 실행됨");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 실행됨");
		System.out.println("서블릿 할당 자원 해제");
	}

	
	
	
}