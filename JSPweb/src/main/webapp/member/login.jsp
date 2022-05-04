<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
	*{color:#FFAAAA; text-align: center;}
	.back{ width:1280px;height:720px; background: linear-gradient(to top, #FFC9C9, white);	}
	.box{width: 100px; height: 50px; padding:10px 10px; background-color: white; border: solid 1px #FFAAAA;}
</style>
</head>
<body>
	<%@include file = "../header.jsp" %>
	<div class="container col-md-4 offset-4">
	<div class="baxk">
	<br>
		<h3>로그인 페이지</h3>
	<br>
		<form action="../login" method="post">
			로그인 : <input type="text" name="mid"> <br>
			비밀번호 : <input type="text" name="mpassword"><br>
	<br>
			<input class="box" type="submit" value="로그인">
			
			<!-- 만일 로그인 실패시 -->
			<%
				String result = request.getParameter("result");
				if(result != null && result.equals("2")){
			%>
			
			<span> 동일한 회원 정보가 없습니다. </span>
			
			<%		
				}
			%>
			
		</form>
	</div>
	</div>
	
	<%@include file = "../footer.jsp" %>
</body>
</html>