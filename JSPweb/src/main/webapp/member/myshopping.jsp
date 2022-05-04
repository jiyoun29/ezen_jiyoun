<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "../header.jsp" %>
	<div class="container"> <!-- 박스권 -->
		<div class="row"> <!-- 가로배치 -->
			<div class="col-md-3"> <!-- 사이드바 -->
			<%@include file = "sidebar.jsp" %>
			</div>
			
			
			<div class="col-md-9"> <!-- 본문 -->
				주문현황
			</div>
		</div>
	</div>
	<%@include file = "../footer.jsp" %>

</body>
</html>