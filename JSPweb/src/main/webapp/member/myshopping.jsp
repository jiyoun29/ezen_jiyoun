<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY SHOPPING</title>
<link href="/JSPweb/css/myshopping.css" rel="stylesheet">
</head>
<body>
<%@include file = "../header.jsp" %>
	<div class="container"> <!-- 박스권 -->
		<div class="row"> <!-- 가로배치 -->
			<div class="col-md-2"> <!-- 사이드바 -->
			<%@include file = "sidebar.jsp" %>
			</div>	
			
			
			<div class="col-md-9"> <!-- 본문 -->
				<h3>주문현황</h3>
				
				<div id="orderbox"> <!--  id="orderbox" -->
				
				

					
					
				</div>
					
			</div> <!-- 본문 끝 -->
			
			
		</div>
	</div>
<%@include file = "../footer.jsp" %>
<script src="/JSPweb/js/myshopping.js" type="text/javascript"></script>
</body>
</html>