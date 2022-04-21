<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>헤더</title>

	<style type="text/css">
	
	@font-face {   font-family: 'ONE-Mobile-POP';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/ONE-Mobile-POP.woff') format('woff');
    font-weight: normal;    font-style: normal;}

		li{list-style: none;} /*글머리 제거*/
		a{text-decoration: none; color:black;} /*밑줄 제거 색상 변경*/
		
		#header{height: 150px;}
		#box{width: 1100px; margin: 0 auto;}
		#logo{float: left; margin: 50px 0 0 50px;}
		#menus{float: right; text-align: right;}
	/*list는 다 블럭으로 되어있으므로 눕힐때에는 li호명 후 display: inline;를 이용해 눕힌다.*/
		#menus li{display: inline;}
		
		#top_menu{margin: 30px 0px;}
		#top_menu li{margin-left: 10px;}
		#main_menu li{ font-family: ONE-Mobile-POP;
		font-size: 20px; margin: 50px 0 0 100px;}
	
	</style>
	
</head>
<body>

	<div id="header"> <!-- 헤더 전체 -->

		<div id="box"> <!-- 헤더 박스권 -->
		<!-- 참고 이미지를 보면서 토막낼 것들을 확인한 다음 div를 생성한다. -->
		
			<div id="logo"> <!-- 로고 -->
				<img alt="" src="img/logo.jpg">			
			</div>
			
			<div id="menus"> <!-- 메뉴 -->
				<ul id="top_menu"> <!-- 상단 메뉴 -->
					<li>김지영(jykim)님</li>
					<li> <a href="#">로그아웃</a> ｜ </li>
					<li> <a href="#">정보수정</a> ｜ </li>				
				</ul>
	
				<ul id="main_menu"> <!-- 하단 메뉴 -->
					<li> <a href="index.jsp">Home</a> </li>
					<li> <a href="#">출석부</a> </li>
					<li> <a href="galley.jsp">작품갤러리</a> </li>
					<li> <a href="#">게시판</a> </li>				
				</ul>
			</div>
			
		
		</div> <!-- 헤더 박스권 종료 -->
	
	
	
	</div>



</body>
</html>