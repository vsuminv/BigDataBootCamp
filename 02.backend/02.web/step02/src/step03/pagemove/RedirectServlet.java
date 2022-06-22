package step03.pagemove;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/otherSite")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//test.html에서 radio 태그에 입력된 값 받기
		String site = request.getParameter("site");
		System.out.println(site);
		
		// 그 값이 naver면 naver.com으로 이동
		if (site.equals("naver")) {
			response.getWriter().print("naver 페이지입니다"); //빠르게 넘어가서 안 보임
			
			//naver.com으로 재지정(redirect)
			response.sendRedirect("http://www.naver.com");
			// naver.com으로 이동
		}else if(site.equals("google")) {
			//google.com으로 이동
			response.sendRedirect("http://www.google.com");
		}

		// 그 값이 google면 google.com으로 이동
		
	}

}
