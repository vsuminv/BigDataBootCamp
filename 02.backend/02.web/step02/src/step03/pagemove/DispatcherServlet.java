package step03.pagemove;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//DispatcherServlet은 같은 위치에서만 이동 가능
@WebServlet("/page1")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<h3>DispatcherServlet 수행 결과</h3>");
		
		//다른 페이지로 옮기기 위한 객체를 사용하기 위한 문법
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/page2");
		
		//실제 이동 수행
		rd.forward(request, response);
		
		out.close();
		
		
		
	}

}
