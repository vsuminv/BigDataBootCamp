<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> <!-- 정적인 데이터 주석 처리 -->
	<% //동적인 데이터
		String user = request.getParameter("name");
		
		if (user == null){
			user = "Guest";
		}
	%>
	<h1>Hello, <%= user%>!</h1> <!-- =기호 추가하면  user가 변수로 인식되어서 출력 -->
</body>
</html>