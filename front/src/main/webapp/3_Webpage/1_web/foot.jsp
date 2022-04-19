<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>footer</title>

	<style type="text/css">
	
	#footer{
		width:100%;
		height: 150px;
		clear : both; /*클리어 사용하지 않으면 float 넣을 때 헷갈릴 수 있다*/
		background-color: #2c2a29;
	}
	
	#footerbox{
		width: 1150px;
		height: 150px;
		margin: 0 auto;
	}
	
	#footer_logo{
		float: left;
		margin: 50px 0px 0px 30px;
	}
	
	#address{
		float: right;
		margin: 50px 30px 0px 0px;
		color:white;
	}
	
	
	
	</style>
	
</head>
<body>
	
	<div id="footer">
		<div id="footerbox">
		
			<!-- 로고 -->
			<div id="footer_logo">
				<img alt="" src="img/photo.jpg">
			</div>
			
			<!-- 쪼개는 연습 필요 -->
			
			<!-- 회사정보 -->
			<ul id="address">
				<li>서울시 강남구 삼성동 1234 우:123-1234</li>
          	 	<li>TEL:031-123-1234 Email : email@domain.com</li>
           	 	<li>COPYRIGHT (C) 루바토 ALL RIGHTS RESERVED</li>
			</ul>
			
		</div>
	</div>
	
	
	
</body>
</html>