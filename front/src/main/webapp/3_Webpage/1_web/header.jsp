<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Index_header</title>

	<style type="text/css">
	
	@font-face {
    font-family: 'IM_Hyemin-Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2106@1.1/IM_Hyemin-Bold.woff2') format('woff');
    font-weight: normal;
    font-style: normal; }
    
    
    	/*<a href>링크 사용시 기본값 제거*/
	a{ text-decoration: none; color:maroon; }
	a:hover{color:darksalmon;}
	/*기본값으로 여백이 들어가는 경우 기본 여백 제거 (이 두개는 메인에 두면 좋음)*/
	*{padding: 0px; margin: 0px;}
	
	
	
	#header{
		width: 1150px; /*가로 길이*/
		height: 100px; /*세로 길이*/
		margin : 0 auto; /*박스권 가운데 정렬*/
	}
		
		#logo{float: left; margin: 20px 0 0 20px;}
		#menus{float: right;}
		
		#top_menu{ text-align: right; margin-top: 20px;	}
		
		
		#main_menu{margin-top: 20px; font-family: IM_Hyemin-Bold; font-size: 20px;}
		
		/*메인 메뉴의 리스트 블럭을 눕혀버린다.		메뉴 간 간격*/
		#main_menu li{ display: inline; margin-left: 80px;}
		
		
		
	</style>
	
</head>
<body>
	
	<!-- 헤더 반토막 내기 -->
	<div id="header"> 
	
		<div id="logo"> <!-- 로고 -->
			<a href="Index.jsp"> <img alt="" src="img/logo.jpg"> </a>
		</div>
	
	
	
		<div id="menus"> <!-- 메뉴 -->
			<div id="top_menu"> <!-- 상단 메뉴 -->	<!-- 하이퍼링크 걸기. #은 임시 -->
				<a href="login.jsp">로그인</a> ｜ 
				<a href="signup.jsp">회원가입</a> ｜ 
				<a href="board.jsp">공지사항</a>
			</div>
			
			
			<ul id=main_menu> <!-- 메인 메뉴 -->
			
				<li><a href="#">사진이론</a></li>
				<li><a href="#">사진구도</a></li>
				<li><a href="#">사진작가</a></li>
				<li><a href="#">갤러리1</a></li>
				<li><a href="#">갤러리2</a></li>
			
			</ul>
		
		
		</div> 
	
	
	</div>
	
</body>
</html>