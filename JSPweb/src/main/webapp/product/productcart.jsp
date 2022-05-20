<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>

	<link href="/JSPweb/css/productcart.css" rel="stylesheet">

</head>
<body>
<!-- css에서 정의되지 않은 클래스명은 모두 부트스트랩-->

<%@include file = "../header.jsp" %>
<div class="container">
		<div class="processbox">
			<span> 01 옵션선택 </span> <span> > </span>
			<span id="process_active"> 02 장바구니 </span> <span> > </span>
			<span> 03 주문결제 </span> <span> > </span>
			<span> 04 주문완료 </span> <span> > </span>
		</div>
	<table class="table my-5" id="carttable"> <!-- b : 테이블 -->

	<!-- 쓴거 몽땅 js로 가져감 -->
		<!-- js에서 데이터가 들어가는 위치 -->

	</table>
	
	<div class="col-sm-2"> <!-- -1이라는 인덱스는 없기 때문에 다 없앨 수 있음 -->
		<button onclick="cancel(-1)" class="form-control"> 상품 전체 삭제 </button>
	</div>
	
	<div class="paybox"> <!-- 사용자정의 css만 사용되는 구역 -->
		<span> 총 상품금액 </span> <span id="sumprice">20,500원</span>
		<span> + </span>
		<span> 배송비 </span> <span id="deliverypay">2,500원</span>
		<span> = </span>
		<span> 총 주문금액 </span> <span id="totalpay"> 23,000원 </span>
		<div class="pointbox">
			<span>주문시 적립 예정 포인트</span> <span id="point"> 2,000 </span>
		</div>
	</div>
	
	<div class="row my-5">
		<div class="col-sm-3 offset-3">
			<a href="/JSPweb/main.jsp">
			<button class="form-control py-4"> 계속 쇼핑하기 </button> </a>
		</div>
		<div class="col-sm-3">
			<a href="/JSPweb/product/orderpay.jsp">
			<button style="background-color: darkcyan; color : white;"
		 class="form-control py-4"> 주문하기 </button> </a>
		</div>
	</div>
	
</div>
<script src="/JSPweb/js/productcart.js" type="text/javascript"></script>
<%@include file = "../footer.jsp" %>
</body>
</html>