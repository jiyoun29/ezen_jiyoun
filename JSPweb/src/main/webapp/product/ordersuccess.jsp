<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>완료하기</title>
<link href="/JSPweb/css/productcart.css" rel="stylesheet">
</head>
<body>
<%@include file = "../header.jsp" %>
<div class="container">
		<div class="processbox">
			<span> 01 옵션선택 </span> <span> > </span>
			<span> 02 장바구니 </span> <span> > </span>
			<span> 03 주문결제 </span> <span> > </span>
			<span id="process_active"> 04 주문완료 </span>
		</div>
		
		주문 완료
</div>
<script src="/JSPweb/js/orderpay.js" type="text/javascript"></script>
<%@include file = "../footer.jsp" %>
</body>
</html>