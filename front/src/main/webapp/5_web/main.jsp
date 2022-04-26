<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>훈스 main</title>
	<!-- 사용자정의 css -->
	<link href="Index.css" rel="stylesheet" >
	
	<style type="text/css">

	.content{ font-size: 11px;}
	.price{font-size:14px; font-weight: bold;}
	.size{font-size: 11px; color:gray;}
	
	</style>
</head>
<body>
	<%@include file="Index.jsp" %>
	
	<!-- http://huns8402.cafe24.com/index.html -->

	<div class="col-md-10 offset-2">
	
		<div id="cs" class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
	 			<button type="button" data-bs-target="#cs" data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#cs" data-bs-slide-to="2"></button>
			</div>
			
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img alt="" src="img/main_1.jpg" width="100%">
				</div>
				<div class="carousel-item">
					<img alt="" src="img/main2.jpg" width="100%">
				</div>
				<div class="carousel-item">
					<img alt="" src="img/main3.jpg" width="100%">
				</div>
			</div>
		</div>
		
		<div class="container">
			<div class="row">
				
			<button class="carousel-control-prev" type="button" data-bs-target="#cas" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#cs" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="visually-hidden">Next</span>
			</button>
			
			</div>
		</div>
		
		
		
			<br><br>
	
	<div class="container text-center">
		<h3>BEST SELLER</h3>
		<p style="color:gray;">#베스트셀러</p>
	</div>


	<div class="row">
	
	<div class="col-md-4 col-sm-6 nav">
		<div class="card">

			<img alt="" src="img/1.jpg">
				<div class="card-body">
					<p class="item">
					<span class="content">[1+1+1]아이스 쿨링 반팔티</span> <br>
					<hr>
					<span class="price">22,900원</span>
					</p>
				</div>
		</div>
	</div>
	
	<div class="col-md-4 col-sm-6 nav">
		<div class="card">	
			<img alt="" src="img/2.webp">
				<div class="card-body">
					<p class="item">
					<span class="content">[1+1]플레인 와이드 밴딩팬츠</span> <br>
					<hr>
					<span class="price">29,800원</span> <br>
					<span class="size">2 color / 2 size</span>
					</p>
				</div>	
		</div>
	</div>


	<div class="col-md-4 col-sm-6 nav">
		<div class="card">						
			<img alt="" src="img/3.webp">
				<div class="card-body">
					<p class="item">
					<span class="content">[1+1]롱&숏 맞춤 레이어드 반팔티</span> <br>
					<hr>
					<span class="price">23,900원</span> <br>
					<span class="size">2 type / 3 color / 4 size</span>
					</p>
				</div>	
		</div>
	</div>
	

	</div> <!-- row -->
	
		<div class="row">
	
	<div class="col-md-4 col-sm-6 nav">
		<div class="card">

			<img alt="" src="img/4.jpg">
				<div class="card-body">
					<p class="item">
					<span class="content">[4 type] 퍼펙트핏 슬랙스(기본/뒷밴딩)</span> <br>
					<hr>
					<span class="price">33,000원</span>
					</p>
				</div>
		</div>
	</div>
	
	<div class="col-md-4 col-sm-6 nav">
		<div class="card">	
			<img alt="" src="img/5.jpg">
				<div class="card-body">
					<p class="item">
					<span class="content">[1+1+1]링클 분또 보트넥 긴팔티</span> <br>
					<hr>
					<span class="price">29,800원</span><br>
					<span class="size">5 color/ 2 size</span>
					</p>
				</div>	
		</div>
	</div>


	<div class="col-md-4 col-sm-6 nav">
		<div class="card">						
			<img alt="" src="img/6.webp">
				<div class="card-body">
					<p class="item">
					<span class="content">[1+1]캔디 바이오 고밀도 셔츠</span> <br>
					<hr>
					<span class="price">24,900원</span>
					</p>
				</div>	
		</div>
	</div>
	

	</div> <!-- row -->
	
	
	<div class="row">
	
	<div class="col-md-4 col-sm-6 nav">
		<div class="card">

			<img alt="" src="img/7.jpg">
				<div class="card-body">
					<p class="item">
					<span class="content">네오 퀄 트렌치코트</span> <br>
					<hr>
					<span class="price">39,800원</span><br>
					<span class="size">3 color / 2 size</span>
					</p>
				</div>
		</div>
	</div>
	
	<div class="col-md-4 col-sm-6 nav">
		<div class="card">	
			<img alt="" src="img/8.jpg">
				<div class="card-body">
					<p class="item">
					<span class="content">[1+2할인]-5도 알래스카 냉감티</span> <br>
					<hr>
					<span class="price">25,900원</span><br>
					<span class="size">5 color/ 2 size</span>
					</p>
				</div>	
		</div>
	</div>


	<div class="col-md-4 col-sm-6 nav">
		<div class="card">						
			<img alt="" src="img/9.jpg">
				<div class="card-body">
					<p class="item">
					<span class="content">힛 워싱 카고조거 팬츠</span> <br>
					<hr>
					<span class="price">24,900원</span><br>
					<span class="size">3 color / 4 size</span>
					</p>
				</div>	
		</div>
	</div>
	

	</div> <!-- row -->
	
	
	
	<div class="row">
	
	<div class="col-md-4 col-sm-6 nav">
		<div class="card">

			<img alt="" src="img/10.jpg">
				<div class="card-body">
					<p class="item">
					<span class="content">라이트헤비쭈리 피그먼트 SET</span> <br>
					<hr>
					<span class="price">49,800원</span><br>
					<span class="size">2 type / 4 color / 2 size</span>
					</p>
				</div>
		</div>
	</div>
	
	<div class="col-md-4 col-sm-6 nav">
		<div class="card">	
			<img alt="" src="img/11.webp">
				<div class="card-body">
					<p class="item">
					<span class="content">피아 세미 와이드 슬랙스</span> <br>
					<hr>
					<span class="price">29,800원</span><br>
					<span class="size">8 color / 4 size</span>
					</p>
				</div>	
		</div>
	</div>


	<div class="col-md-4 col-sm-6 nav">
		<div class="card">						
			<img alt="" src="img/12.jpg">
				<div class="card-body">
					<p class="item">
					<span class="content">스포티 매쉬 투웨이 후드집업</span> <br>
					<hr>
					<span class="price">39,800원</span><br>
					<span class="size">4color / 2 size</span>
					</p>
				</div>	
		</div>
	</div>
	

	</div> <!-- row -->
</div>


<br><br>
	<%@include file="Footer.jsp" %>

</body>
</html>