<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- HTML파일이 저장될 때 사용할 인코딩 문자코드 설정. -->
<title>Insert title here</title>
</head>
<body>
	<h3>회원 정보</h3>
	<form action="queryTest" method="GET"><!-- POST로도 수정해보기. -->
		ID : <input type="text" name="id"/><br/>
		비밀번호 : <input type="password" name="pwd"/><br/>
		이름 : <input type="text" name="name"/><br/>
		취미 :
			<input type="checkbox" name="hobby" value="netflix" /> 넷플릭스 보기
			<input type="checkbox" name="hobby" value="cook" /> 요리
			<input type="checkbox" name="hobby" value="trip" /> 여행<br/>
		성별 : 
			<input type="radio" name="gender" value="male"/>남자
			<input type="radio" name="gender" value="female"/>여자<br/>
		국적 : 
			<select name="country">
				<option value="ko">대한민국
				<option value="jp">일본
				<option value="ch">중국
			</select><br/>
		프로필 메시지 :<br/>
			<textarea rows="10" cols="30" name="introduction" placeholder="프로필 메시지를 작성하세요"></textarea><br/>
			
			<input type="submit" value="등록"/>
			<input type="reset" value="지우기"/> 
	</form>
</body>
</html>