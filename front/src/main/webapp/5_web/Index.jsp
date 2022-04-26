<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>huns</title>

	<!-- 부트스트랩 css cdn -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<!-- 사용자정의 css -->
	<link href="Index.css" rel="stylesheet" >
	<!-- 폰트어썸[ 아이콘 ]  -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
</head>
<body>

	<!-- 부트스트랩 js cdn -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

	<div class="col-md-10 offset-2 fixed-top pb-1 pt-5 px-5">
		<div class="col-md-7 d-flex justify-content-end offset-5"><!-- 헤더, 오른쪽에 배치 -->
			<ul class="nav"> <!-- 해당 리스트 ul, ol, 가로배치 inline -->
				<li class="tophead"><a href="login.jsp"> LOGIN </a></li>
				<li class="tophead"><a href="#"> JOIN </a></li>
				<li class="tophead"><a href="#"> CART </a></li>
				<li class="tophead"><a href="#"> MY PAGE </a></li>
				<li class="tophead"><a href="#"> SNS </a></li>
				<li class="tophead"><a href="#"> BOOKMARK </a></li>
			</ul>
		</div>
	</div>


	<!-- 본문과 사이드바를 같은 선상에 배치 -->
	<div class="row">
 <!-- 사이드바 -->
	
		<div class="sidemenu col-md-2">
			<div class="logo col-md-1 py-4 mx-4 my-3">
				<a href="main.jsp"> HUNS </a>
			</div>
			
			<div class="navbar-nav-scroll" id="scrol">
			
			<div class="position">
				<ul>
				<li class="sidebar"> <a href="#"> BEST </a></li>
				<li class="sidebar"> <a href="#">NEW </a></li>
				<li class="sidebar"> <a href="#">당일배송 </a></li>
				<li style="margin-bottom:20px;" class="sidebar"> <a href="#">1+1/코디세트 </a></li>
				<li class="sidebar"> <a href="#">아우터 </a></li>
				<li class="sidebar"> <a href="#">상의 </a></li>
				<li class="sidebar"> <a href="#">셔츠 </a></li>
				<li class="sidebar"> <a href="#">니트/가디건 </a></li>
				<li class="sidebar"> <a href="#">팬츠 </a></li>
				<li class="sidebar"> <a href="#">트레이닝 </a></li>
				<li class="sidebar"> <a href="#">신발 </a></li>
				<li class="sidebar"> <a href="#">악세사리 </a></li>
				<li class="sidebar"> <a href="#">세일 </a></li>
				</ul>
	
				<ul>
				<li class="sidebar2">NOTICE</li>
				<li class="sidebar2">Q & A</li>
				<li class="sidebar2">REVIEW</li>
				<li class="sidebar2">EVENT</li>
				</ul>
				
			<!-- 검색 -->
			<div> <input type="text" class="col-md-10"> <i class="fas fa-search"></i> </div>
							
			</div>
		
			<br>
			
			<!-- 안내 -->
			<div class="info">
			<p class="info2">고객센터　070-7710-4745<br>
			카카오채널 @훈스</p>
			MON - FRI AM9 - PM4<br>
			(LUNCH TIME PM12:30 - PM13:30)<br>
			SAT, SUN, HOLIDAY CLOSE<br>
			업무시간외 문의는<br>
			Q＆A 게시판을 이용부탁드립니다.<br>
			우리은행 1005-504-072722<br>
			예금주 : (주)유엔미컴퍼니<br>
			</div>
			
		</div>
		
		</div>
		
	 <!-- 본문 -->

		<div class="col-md-10 offset-2 content">
		

	
			<div> <!-- 캐러셀 -->
			</div>
	
			<div><!-- 내용물,제품 3구역 -->
			</div>
	
			<div><!-- 푸터 -->
			</div>
	
		</div>
	
	</div>
	
	
</body>
</html>