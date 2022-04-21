<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>캐러셀</title>
	
	<style type="text/css">
	
		.carousel-item{ /*이미 정의된 부트스트램 클래스 수정*/
			width: 70%; height: 50%;	}
	
	
	
	</style>
	
	
	
</head>
<body>

	<!-- 끌고올때 골뱅이 잊지말기 -->
	<%@include file="1_설치.jsp" %>
	
	
	<!-- 이미지 슬라이드 : 캐러셀 -->
	<div class="container"> <!-- 박스권 -->
	
		<div id="cs" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="2000"> <!-- 캐러셀 -->
								<!-- data-interbval : 슬라이드 시간(밀리초) -->


			<!-- 마우스 올린 상태에서는 안 움직인다 -->

			<!-- 캐러셀 [내용 위치] 하단 버튼 : 인디케이터 -->
			<div class="carousel-indicators">			<!-- 사진(인덱스) 순서 -->
				<button type="button" data-bs-target="#cs" data-bs-slide-to="0" class="active"> </button> <!-- 사진 개수만큼 -->
				<button type="button" data-bs-target="#cs" data-bs-slide-to="1" class="active"> </button>
				<button type="button" data-bs-target="#cs" data-bs-slide-to="2" class="active"> </button>
				<button type="button" data-bs-target="#cs" data-bs-slide-to="3" class="active"> </button>
			</div>
			<!-- 0번부터 시작해서 계속 진행. active를 넣어서 동작하도록 해준다. -->


				<div class="carousel-inner">
				
					<div class="carousel-item active"> <!-- 캐러셀 내용, active:실행 -->
						<img alt="" src="../cat2.jpg" width="100%">
						
							<div> 캐러셀에서 같이 움직이는 글자 고양이한테만 있다 </div>
						
					</div>
		
					<div class="carousel-item">  <img alt="" src="../city.jpg" width="100%"></div>
					<div class="carousel-item"> <img alt="" src="../cloud.jpg" width="100%"></div>
					<div class="carousel-item"> <img alt="" src="../dang.jpg" width="100%"></div>
					
					
					<!-- 캐러셀 이동 버튼 -->	<!-- 프리뷰 -->
					<a class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
									<!-- 해당 케러셀의 버튼이라는 뜻으로 id로 이름 매기고 반드시 연결(이 버전에서는 bs추가 필요) -->
						<span class="carousel-control-prev-icon"></span>
					</a>
					
					<!-- 캐러셀 이동 다음 버튼 -->
					<button type="button" class="carousel-control-next" data-bs-target="#cs" data-bs-slide="prev">
									<!-- 해당 케러셀의 버튼이라는 뜻으로 id로 이름 매기고 반드시 연결(이 버전에서는 bs추가 필요) -->
						<span class="carousel-control-next-icon"></span>
					</button>
	
				</div>
			
		</div> <!-- 캐러셀 끝 -->
	
	</div>
</body>
</html>