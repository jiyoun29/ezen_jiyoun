<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="signup_con.jsp" method="post"> <!-- 이동경로 -->
		<input type="text" name="id" placeholder="아이디">
		<input type="text" name="pw" placeholder="비밀번호">
		<input type="text" name="name" placeholder="이름">
		<input type="submit" value="전송">
	</form>
</body>
</html>