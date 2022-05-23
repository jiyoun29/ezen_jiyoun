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
			<span style="font-size: 1.0vw"> 04 주문완료 </span> <span> > </span>
		</div>
<!---------------------------------------------------------->

	<div class="row"> <!-- 정보창 -->
		<div class="col-md-8">
			<div> <!-- 제품 목록 -->
				<!-- 장바구니에서 끌고오기(제품, 가격만)  <table class="table my-5" id="carttable"> -->
				<table class="table my-5" id="carttable">
					<!-- 헤더를 자스로 -->
				</table>
			</div>
			
			<div> <!-- 받는 사람 정보 -->
				<h5>받는 사람</h5><input type="checkbox" id = "checkbox"> 회원 정보와 동일
					<!-- 클릭시  로그인 정보 끌어오기 -->
				<form>
					성명 <input id="ordername"> <br>
					연락처 <input id="orderphone"> <br>
					주소 <input> <br>
			<!-- sign up에서 가져오기 -->			
		<input type="text" id="sample4_postcode" name="address1" placeholder="우편번호" style="width: 100px;">
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소"><br>
		<input type="text" id="sample4_jibunAddress" name="address3" placeholder="지번주소"><br>
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress" name="address4" placeholder="상세주소"> <br>
	
					배송 요청사항 <input id="orderrequest"> <br>
				</form>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="paybox">
				<div> <!-- 포인트 사용 -->
					* 5000포인트 이상부터 사용 가능 <br>
					보유 포인트 : <span id="mpoint"></span> <br>
					포인트 사용 <input id="pointinput" value=0> <button onclick="pointbtn()"> 사용 </button>
				</div>
				<div> <!-- 결제 정보 -->
					<div> 총 결제액
						총 상품금액 : <span id="sumprice"></span>  <br>
						배송비 : <span id="deliverypay"></span>  <br>
						포인트사용 : <span id="pointbox"></span> <br>
						총 주문액 : <span id="totalpay"></span> <br>
					</div>
				<div> 결제 방법 <span id ="paymethod"></span>
					<button onclick="paymethod('samsung')"> 삼성페이 </button>
					<button onclick="paymethod('card')"> 카드 </button>
					<button onclick="paymethod('trans')"> 계좌이체 </button>
					<button onclick="paymethod('vbank')"> 무통장 </button>
					<button onclick="paymethod('phone')"> 핸드폰 </button>
				</div>
				
					<div class="row">
						<div class="col-sm-6">
							<a href="/JSPweb/main.jsp">
							<button class="form-control py-4"> 계속 쇼핑하기 </button> </a>
						</div>
						<div class="col-sm-6">
							<button onclick="payment()" style="background-color: darkcyan; color : white;"
						 class="form-control py-4"> 결제하기 </button>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>




<!---------------------------------------------------------->
	

	
</div>
 <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="/JSPweb/js/orderpay.js" type="text/javascript"></script>
<%@include file = "../footer.jsp" %>
</body>
</html>