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
	
	<style type="text/css">
	
	a{text-decoration: none; color:#FFAAAA; }
	
	</style>
	
</head>
<body>


	<%
		String loginid = (String)session.getAttribute("login"); //세션 호출(기본타입 = object)
	%>


	<!-- 헤더페이지[모든페이지에서 사용되기 때문에 절대경로.]  -->
	<!-- 반드시 최상위 경로로 적을 것 -->
	<div class="container">	
		<!-- 공통 -->

		<h3><a href="/JSPweb/main.jsp">HOME</a></h3><br>
		<a href="#"> BIG SIZE </a>
		<a href="#"> MUSCLE-FIT </a>
		<a href="#"> 1+1 이벤트 </a>
		<a href="#"> 아우터 </a>
		<a href="#"> 상의 </a>
		<a href="#"> 바지 </a>
		<a href="#"> 슈즈 </a>
		<a href="#"> 악세사리 </a>
		<a href="#"> BEST </a>
		<a href="#"> 트레이닝 </a>
		<a href="#"> 모델처럼입자 </a>
		<a href="#"> 50% 할인 </a><br>

		
		<input type="text" style="text-align: left;"><button>검색</button> 
		<a href="search.jsp"><img src="../img/cart.png" width="30px;"></a>	
		
		
		<!-- 로그인이 안 된 상태 = 만약에 세선이 없으면-->	
		<% if(loginid ==null){ %>
		<div class="col-md-3 offset-9">	
		<a href="/JSPweb/member/login.jsp">로그인</a>
		<a href="/JSPweb/member/signup.jsp">회원가입</a>
		</div>
		<% } %>
		
		<!-- 로그인이 된 상태 = 만약에 세션이 있으면-->
		<% if(loginid != null){ %>
		<div class="col-md-5 offset-7">	
		<span> <%=loginid %>님 </span>
		
		<a href="/JSPweb/logout">로그아웃</a> <!-- 서블릿으로 생성 -->
		<a href="/JSPweb/member/myshopping.jsp">나의쇼핑</a>
		</div>
		<% } %>
		
	</div>
	
	
	
	
	
	
	<!-- 부트스트랩 js cdn **몇개더생기니잘챙겨놓기 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
	<!-- 사용자 정의 js -->
	<script src="/JSPweb/js/main.js" type="text/javascript"></script>
	
	<!-- jquert 최신 cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</body>
</html>