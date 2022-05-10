<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
	<!-- 사용자 정의 css -->
	<link href="/JSPweb/css/main.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   <!-- 폰트어썸[ 아이콘 ]  -->
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
   	
	<style type="text/css">
	
	a{text-decoration: none; color : black; }
	.box{background-color: white; border: solid 1px black;}	
	
	hr{border-bottom: solid 1px black;}
	</style>
<link rel="stylesheet" href="/css/main.css">
</head>
<body>


	<%
		String loginid = (String)session.getAttribute("login"); //세션 호출(기본타입 = object)
	%>


	<!-- 헤더페이지[모든페이지에서 사용되기 때문에 절대경로.]  -->
	<!-- 반드시 최상위 경로로 적을 것 -->
	<div class="container">	
	
	<div class="py-4">
	<div class="row">
		<div class="col-md-4">
		<h3><a href="/JSPweb/main.jsp" class="header_logo">HOME</a></h3><br>		
		</div>
		<div class="col-md-4 offset-4 d-flex justify-content-end">
		<ul class="nav">

		<!-- 로그인이 안 된 상태 = 만약에 세선이 없으면-->	
		<% if(loginid ==null){ %>
		<li><a href="/JSPweb/member/login.jsp" class="header_topmenu"> 로그인</a> | </li>
		<li><a href="/JSPweb/member/signup.jsp" class="header_topmenu"> 회원가입</a> | </li>
		<% } %>
		<!-- 로그인이 된 상태 = 만약에 세션이 있으면-->
		<% if(loginid != null){ %>
		<li><span> <%=loginid %>님 </span> | </li>
		<li><a href="/JSPweb/logout" class="header_topmenu"> 로그아웃</a> | </li> <!-- 서블릿으로 생성 -->
		<li><a href="/JSPweb/member/myshopping.jsp" class="header_topmenu"> 나의쇼핑</a> | </li>
		<% } %>
		<li><a href="/JSPweb/board/boardlist.jsp"> 자유게시판</a></li>
		
		</ul>
	</div>
	</div> <!-- 상단메뉴 끝 -->
	
	<div class="navbar navbar-expand-md navbar-light bg-white"> <!-- 본 메뉴 -->
		<!-- 공통 -->
	<ul class="navbar-nav col-md-12 justify-content-between"> <!-- 균등배치 -->
		<li class="nav-item"><a href="#"> BIG SIZE </a></li>
		<li class="nav-item"><a href="#" style="color:#00D8FF;"> MUSCLE-FIT </a></li>
		<li class="nav-item"><a href="#" style="color:#0100ff;"> 1+1 이벤트 </a></li>

		<li class="nav-item dropdown"> <!-- dropdown:드랍다운 -->
			<a href="#" class="hover"> 아우터 </a> <!-- data-bs-toggle="dropdown": 해당 태그를 클릭하면 드랍다운 -->
			<!-- 드롭다운 -->
			<div class="dropdown-menu"> <!-- dropdown-menu : 내용물들 -->
				<a class="dropdown-item" href="#"> ㅁ </a>
				<a class="dropdown-item" href="#"> ㅁ </a>
				<a class="dropdown-item" href="#"> ㅁ </a>
				<a class="dropdown-item" href="#"> ㅁ </a>
				<a class="dropdown-item" href="#"> ㅁ </a>
			</div>
		
		</li>
		<li class="nav-item"><a href="#"> 상의 </a></li>
		<li class="nav-item"><a href="#"> 바지 </a></li>
		<li class="nav-item"><a href="#"> 슈즈 </a></li>
		<li class="nav-item"><a href="#"> 악세사리 </a></li>
		<li class="nav-item"><a href="#"> BEST </a></li>
		<li class="nav-item"><a href="#"> 트레이닝 </a></li>
		<li class="nav-item"><a href="#" style="color:#ffbb00;"> 모델처럼입자 </a></li>
		<li class="nav-item"><a href="#" style="color:#ff0000;"> 50% 할인 </a></li>
		<li class="nav-item"><input type="text" class="header_input" size="13"></li>
		<li class="nav-item"><a href="search.jsp"><i class="fas fa-search"></i></a></li>
		<li class="nav-item"><a href="#"> 장바구니<span class="shoppingbox">3</span> </a></li>
		
	</ul>
		<hr/>	
	</div>
	
	</div> <!-- 메뉴 끝 -->
		
		
	</div>

	
	
	
	
	<!-- 부트스트랩 js cdn **몇개더생기니잘챙겨놓기 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
	<!-- 사용자 정의 js -->
	<script src="/JSPweb/js/main.js" type="text/javascript"></script>
	
	<!-- jquert 최신 cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</body>
</html>