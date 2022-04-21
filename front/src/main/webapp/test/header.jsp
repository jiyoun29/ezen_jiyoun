<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>헤더</title>
	<style type="text/css">
	
	li{list-style: none; display: inline;}
	
	#header{height: 150px;}
	#box{width: 1100px; margin: 0 auto;}	

	#one{ font-size: 45px; font-weight: bold;
		margin: 30px 0 0 50px; float: left;}
	
	#menu{padding : 20px; float: right; text-align: right; font-weight: bold; }
	
	span{ color:blue;}
	
	</style>
</head>
<body>
	<div id="header"> <!-- 헤더 전체 -->

		<div id="box"> <!-- 헤더 박스권 -->
		<!-- 참고 이미지를 보면서 토막낼 것들을 확인한 다음 div를 생성한다. -->
		
			<div id="one">
				<span> The </span> 스튜디오
			</div>
			
			<div id="menu"> <!-- 메뉴 -->
				<ul class="top_menu"> <!-- 상단 메뉴 -->
					<li>스튜디오 소개</li>
					<li>스튜디오 예약</li>
					<li>블로그</li>				
					<li>포도 갤러리</li>
					<li>오시는 길</li>	
				</ul>

			</div>
		
		</div> <!-- 헤더 박스권 종료 -->
	
	
	
	</div>
</body>
</html>