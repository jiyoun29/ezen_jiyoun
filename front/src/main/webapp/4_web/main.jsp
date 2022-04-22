<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp main</title>
</head>
<body>


	<!-- 현재 위치(파일)에 다른 파일 포함하기 -->
	<%@include file = "Header.jsp" %>
	
	<br><br><br><br><br><br>
	<!--  캐러셀 : 이미지 슬라이드  -->
	<div id="cs" class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000">
								<!-- 슬라이드시간 : 밀리초(1000/1초)  -->
		<!-- 슬라이드 위치 표시 : 인디케이터 -->
		<div class="carousel-indicators">
			<button data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
			<button data-bs-target="#cs" data-bs-slide-to="1"></button>
			<button data-bs-target="#cs" data-bs-slide-to="2"></button>
			<button data-bs-target="#cs" data-bs-slide-to="3"></button>
		</div>
		 <!-- 캐러셀 내용물 -->
		<div class="carousel-inner">
			<div class="carousel-item active"> <img alt="" src="img/img (1).jpg"> </div>
			<div class="carousel-item "> <img alt="" src="img/img (2).jpg"> </div>
			<div class="carousel-item "> <img alt="" src="img/img (3).jpg"> </div>
			<div class="carousel-item "> <img alt="" src="img/img (4).jpg"> </div>
		</div>
		<!-- 이미지 이동 버튼 -->
		<button class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
		
	</div><!-- 캐러셀 end -->
	
	<br><br>
	
	<div class="container text-center">
		 <hr> <!-- 실선 태그 -->
		 	<h3> new arrival </h3>
		 	<p> 신상품 </p>
	</div>
	
	<div class="container">
		<div class="row">
		
		<!-- 프로덕트 리스트 만들어서 % 이용해서 db연동을 시켜서 i자리에 리스트 만들기 가능 -->

			<div class="col-md-3 col-sm-6"> <!-- col-md-* :760px 이상. col-sm-* : 570px 이상 -->
				<div class="card"> <!-- 카드 형식 -->
					<img class="card-item-top" alt="" src="img/img.webp"> <!-- 이미지 -->
					<div class="card-body">
						<p class="item">
							<span class="title"> 스탠다드 세미 오버핏 7부 슬림진 </span>
							<br>
							<span class="content">
							[1+1] 맞춤기장 히든밴딩 스판
							(+S/M/L/XL)
							700건 후기 인증! 데님 판매 1위
							</span>
							<br>
							<span class="price"> 79,900원 </span> 75,900원
							<br>
								<!-- 버튼 느낌으로 꾸미기 -->
							<span class="badge bg-warning text-dark">주문폭주</span>
							<span class="badge bg-danger text-dark">품절임박</span>
						</p>
					</div>
				</div>
			</div>
			
			
			
		</div>
	</div>
	
		 	

	<%@include file = "Footer.jsp" %>
	
</body>
</html>