<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="writecontroller.jsp" method="get">
		<input type="text" name="title">
		<textarea rows="5" cols="10" name="content"></textarea>	
		<input type="submit" value="쓰기">
	</form>
</body>
</html>