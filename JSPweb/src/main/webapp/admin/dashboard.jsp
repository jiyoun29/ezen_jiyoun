<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대쉬보드</title>
	<!-- 사용자 정의 css -->
	<link href="/JSPweb/css/admin.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   <!-- 폰트어썸[ 아이콘 ]  -->
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"> 

</head>
<body>

	<marquee scrollamount="10"> 제품 관리 철저히 하기 </marquee> <!-- 흘러감 -->
	
	<div id = "sidebar">
		<ul> <!-- 사이드바 목록 -->
			<li><h6> 관리자님을 환영합니다.</h6></li>
			<li><button onclick="pagechange('productlist')">제품 목록</button></li>
			<li><button onclick="pagechange('productadd')">제품 등록</button></li>
			<li><button onclick="pagechange('productstock')">제품 재고</button></li>
			<li><button onclick="#">주문 현황</button></li>
			<li><button onclick="#">주문 배송</button></li>
			<li><button onclick="pagechange('productsales')">매출 관리</button></li>
			<li> <a href="/JSPweb/main.jsp">홈페이지</a></li>
			<li> <a href="/JSPweb/logout">로그아웃</a></li>
		</ul>
		<!-- 사이드바 열기/닫기 사용 -->
		<span class="sidebarbtn" id="sidebarbtn">|||</span>
	</div>




	<!-- 페이지 전환시 페이지가 포함되는 구역  -->
	<div class="container" id="mainbox"> <!-- 부트스트랩이 잘 끌려왔는지는 컨테이너로 확인 -->
		<h3>관리자 메인 페이지</h3>
	</div>



<!-- -------------------------------------------------------- -->
	<!-- 부트스트랩 js cdn **몇개더생기니잘챙겨놓기 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<!-- jquery 최신 cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	
		<!-- amchart api cdn  -->
	<script src="https://cdn.amcharts.com/lib/5/index.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/locales/de_DE.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/geodata/germanyLow.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/fonts/notosans-sc.js"></script>
	
	<script src="https://cdn.amcharts.com/lib/5/percent.js"></script>
	
	
	<!-- 사용자 정의 js -->
	<script src="/JSPweb/js/main.js" type="text/javascript"></script>
	<script src="/JSPweb/js/dashboard.js" type="text/javascript"></script>

</body>
</html>