<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>정말로 탈퇴하시겠습니까?</div>
	<form action="delete.jsp" method="post">
		<input type="text" name="id" placeholder="아이디">
		<input type="password" name="pw" placeholder="비밀번호">
		<input type="submit" value="탈퇴">
	</form>
</body>
</html>