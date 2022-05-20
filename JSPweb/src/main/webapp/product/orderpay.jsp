<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
	<link href="/JSPweb/css/productcart.css" rel="stylesheet">
</head>
<body>

<%@include file = "../header.jsp" %>
<div class="container">
		<div class="processbox">
			<span> 01 옵션선택 </span> <span> > </span>
			<span> 02 장바구니 </span> <span> > </span>
			<span id="process_active"> 03 주문결제 </span> <span> > </span>
			<span> 04 주문완료 </span> <span> > </span>
		</div>
<!---------------------------------------------------------->






<!---------------------------------------------------------->
	
	<div class="row my-5">
		<div class="col-sm-3 offset-3">
			<a href="/JSPweb/main.jsp">
			<button class="form-control py-4"> 계속 쇼핑하기 </button> </a>
		</div>
		<div class="col-sm-3">
			<button onclick="payment()" style="background-color: darkcyan; color : white;"
		 class="form-control py-4"> 결제하기 </button>
		</div>
	</div>
	
</div>
 <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="/JSPweb/js/orderpay.js" type="text/javascript"></script>
<%@include file = "../footer.jsp" %>
</body>
</html>