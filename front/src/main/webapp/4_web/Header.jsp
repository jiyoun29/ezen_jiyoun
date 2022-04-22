<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="EUC-KR">
<title>헤더</title>

	<!-- 부트스트랩 css 포함 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
	<!-- 사용자 정의한 css 포함 -->
	<link href="css/main.css" rel="stylesheet">
	
	<!-- 폰트 어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
	
	<style type="text/css">
	
	
	</style>
	
	
</head>
<body>

	<div class="container fixed-top bg-white"> <!-- 박스권 형성 -->
		<div class="py-3"> <!-- 상단메뉴 --> <!-- py:패딩 세로축-값 -->
				<!-- p:안쪽여백 py-*:위아래 안쪽여백 m:바깥여백 my-*:위아래바깥여백 -->
			<div class="row"><!-- 가로배치 -->
			
				<div class="col-md-4  offset-4 text-center"> <!-- 그리드 12조각 중 4조각 -->
											<!-- text-center: 박스권 내 내용물 가운데 정렬 -->
											<!--  offset-4: 여백 그리드 -->
					<a href="main.jsp" class="header_logo"> 이젠 쇼핑몰 </a>
				</div>

								<!--justfy-content-end: 박스를 오른쪽에 배치 -->				
				<div class="col-md-4 d-flex justfy-content-end"> <!-- 상단 메뉴 -->
					<ul class="nav"> <!-- 가로배치 -->
						<li> <a href="#"> 로그인∥ </a></li>
						<li> <a href="#"> 회원가입∥</a></li>
						<li> <a href="#"> 장바구니 </a></li>
					</ul>
				</div>
				
			</div><!-- 가로배치 -->
		</div> <!-- 상단메뉴 -->
		
		
		<div class="navbar navbar-expand-md navbar-light bg-white"> <!-- 본메뉴 -->
		
		<!-- 숨겨진 메뉴 펼치기 버튼 -->
		<button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navcl">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		
		<!-- 사이즈가 부족할 경우 아래 ul 숨기기 -->
			<div class="collapse navbar-collapse" id="navcl">
				<ul class="navbar-nav col-md-12 justify-content-between"> <!-- 눕는다 -->
										<!-- justify-content-between : 자동 간격 배치 -->
					<li class="nav-item"> <a href="#" class="nav-link"> 베스트 상품 </a></li>
					<li class="nav-item"> <a href="#" class="nav-link">1+1</a></li>
					<li class="nav-item"> <a href="#" class="nav-link">아우터</a></li>
					<li class="nav-item"> <a href="#" class="nav-link">상의</a></li>
					<li class="nav-item"> <a href="#" class="nav-link">바지</a></li>
					<li class="nav-item"> <a href="#" class="nav-link">치마</a></li>
					<li class="nav-item"> <a href="#" class="nav-link">원피스</a></li>
					<li class="nav-item"> <a href="#" class="nav-link">가방</a></li>
					<li class="nav-item"> <a href="#" class="nav-link">신발</a></li>
					<li class="nav-item"> <a href="#" class="nav-link">소품</a></li>
					<li class="nav-item"> <a href="#" class="nav-link">리뷰</a></li>
					<li class="nav-item"> <a href="#" class="nav-link">고객센터</a></li>
					<li class="nav-item"> <a href="#"  class="nav-link"> <i class="fas fa-search"></i> </a></li>
				</ul>
			</div>
		
		</div><!-- 본메뉴 -->
		
		
		
		
		
		
		
		
		
	</div> <!-- 박스권 형성 -->
	
	
		
	<!-- 부트스트랩 js 포함 -->	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>