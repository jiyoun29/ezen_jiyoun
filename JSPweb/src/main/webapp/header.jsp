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
	
</head>
<body>

	<!-- 헤더페이지[모든페이지에서 사용되기 때문에 절대경로.]  -->
	<div class="container">	
		<!-- 반드시 최상위 경로로 적을 것 -->
		<a href="/JSPweb/main.jsp">HOME</a>		
		<a href="/JSPweb/member/login.jsp">로그인</a>
		<a href="/JSPweb/member/signup.jsp">회원가입</a>
	</div>
	<!-- 부트스트랩 js cdn **몇개더생기니잘챙겨놓기 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
	<!-- 사용자 정의 js -->
	<script src="/JSPweb/js/main.js" type="text/javascript"></script>
	
	<!-- jquert 최신 cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</body>
</html>