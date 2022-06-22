package step02.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginTest")
public class LoginLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//a태그가 get메소드로 자동으로 오는 이유 => 기본적으로 get요청으로 들어감
		// 로그아웃 처리
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if(session != null && session.getAttribute("id") != null) {
			// 세션의 정보 삭제
			session.invalidate();
			out.print("로그아웃 완료");
		}else {
			out.print("로그인 상태가 아닙니다.");
		}
		
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서버 응답 시 클라이언트에게 메타정보 전달
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//클라이언트에서 입력한 id, pw값 받기
		String id = request.getParameter("id"); 
		String pwd = request.getParameter("pwd");
		
		//id, pw 중 하나라도 입력 안하면 돌려보내기
		if(id.isEmpty() ||pwd.isEmpty() ) //id값이 비어있을 때. 문자열이 가지고 있는 기본 메소드(isEmpty)
		{
			out.print("아이디 및 비밀번호를 입력해주세요");
			return;
		}
		
		//세션은 서버 측에 저장하기 때문에 서버 측에서 세션 객체 만들기
		HttpSession session = request.getSession();
		
		//조건에 따라 세션의 로그인 상태 유무 구분
		if(session.isNew() || session.getAttribute("id") == null) { //isNew() 반환 타입 불린. 서버가 세션을 만들었지만 클라이언트가 세션에 대한 정보를 모르면 로그인이 안 됨 => true
 			session.setAttribute("id", id); //id라는 이름의 key값으로 id값 저장.키값이름도 id. id라는 키값에 우리가 로그인할 때 입력할 id 값을 저장. 
			out.print("로그인 완료"); // 이후로는 세션에 로그인한 id 값 들어가 있음
		}else {
			out.print("이미 현재 로그인 상태입니다.");
		}
		
		out.close();
	}

}
