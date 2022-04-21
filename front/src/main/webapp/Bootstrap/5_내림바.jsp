<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>래빗바navbar</title>
</head>
<body>
	<!-- 끌고올때 골뱅이 잊지말기 -->
	<%@include file="1_설치.jsp" %>
	
	<!-- 
		container / grid 12칸
	 -->




		<div class="container"> <!-- 박스권 -->	<!-- 색깔사라짐.  bg-dark는 배경을 까맣게 만드러줌 -->	
			<div class="navbar navbar-expand-md navbar-light"> <!-- 네비게이션 바 -->
			
				<a href="#" class="navbar-brand"> 로고 </a>


			<!-- 메뉴 사이즈가 작아지는 경우 -->
			<button class="navbar-toggle" type="button"

				data-bs-toggle="collapse" data-bs-target="#navmenu" 
				aria-controls="navbarcontents"aria-expanded="false" >
				<!-- 타겟과 아이디 동일하게 만들것 -->
				
				
					<!-- 메뉴가 사라져도 보이게 하려면 collapse -->
				<span class="navbar-toggler-icon"></span>
			</button>


			<!-- collapse는 특정 사이즈로 줄어들면 사라진다 -->
			<div class="collapse navbar-collapse" id="navmenu"> <!-- 760px 이하가 되면 사라짐 -->
			
			
			
				<ul class="navbar-nav"> <!-- 글머리 빠짐, 네비게이션 목록 -->
					<!-- 네이게이션 목록 값 / 아이템 -->
					<li class="navbar-item"> <a href="#" class="nav-link"> 메뉴1 </a> </li>	
					<li class="navbar-item"> <a href="#" class="nav-link"> 메뉴2 </a> </li>	
					<li class="navbar-item"> <a href="#" class="nav-link"> 메뉴3 </a> </li>				
					
					
					<!-- 늘 버전체크 잘하기 -->
					<li  class="nav-item dropdown"> <!-- 드롭다운 메뉴 -->
	
						<!-- nav-link : 밑줄, 색 바꿔줌 / dropdown-toggle : 화살표 -->
						<!-- 하당 텍스트를 클릭했을 때 메뉴 펼치기 -->
						<a href="#" data-bs-toggle="dropdown">
						드랍다운 </a>
						
						<div class="dropdown-menu" aria-labelledby="navdrop"> <!-- 메뉴라고 알려줌(사라짐) -->
							<a class="dropdown-item" href="#"> 드랍다운 메뉴1 </a>
							<a class="dropdown-item" href="#"> 드랍다운 메뉴2 </a>
							<a class="dropdown-item" href="#"> 드랍다운 메뉴3 </a>
						</div>
						
					</li>
					
				</ul> <!-- 네비게이션 목록 끝 -->
	
	
	
	
				
				<form action="">
					<div class="row">
						<div class="col-md-5">
							<input type="text" class="form-control" placeholder="검색어">
						</div>
						
						<div class="col-md-5">
						<button class="form-control" type="submit"> 검색 </button>
						</div>
						
					</div>
				</form>
			</div>
		</div>


	
	</div>
	
	
	
	
</body>
</html>