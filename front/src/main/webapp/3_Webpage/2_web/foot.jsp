<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>푸터</title>
	<style type="text/css">
	
	*{border: solid 1px red;}
	
	/*안하면 딸려 올라간다.*/
	#footer{clear: both; background-color: #05354e; color:white; height: 300px;} 
	
	#footer_menu{padding: 20px; font-weight: bold;}
	#footer_menu li{display: inline; margin-right: 30px;}
	#footer .items{float: left; margin: 20px 80px 20px 20px;}
	
	#footer h3{color:#0ca9a3;}
	#footer .items ul{margin-top: 10px;}
	#footer .items li{margin-top: 5px;}
	#footer .items #phone{font-size: 25px; font-weight: bold;}	
	
	</style>
</head>
<body>
	
	<!-- 총 4등분 -->
	<div id="footer">
		<div id="box">

			<ul id="footer_menu"> 
				<li>The 베이킹 소개</li>
				<li>개인정보처리방침</li>
				<li>저작권 정보</li>
				<li>이용 안내</li>
			</ul>			 

			<div class="items">
				<h3>문의전화</h3>
				<ul>
					<li id="phone">123-1234</li>
					<li>10:00 - 18:00(Lunch 12:00 - 13:00)</li>
				</ul>
			</div>
			
			<div class="items">
				<h3>The 베이킹</h3>
				<ul>
					<li>주소 : 경기도 용인시 기흥구 동백대로 123</li>
					<li>전화 : 031-123-1234</li>
					<li>팩스 : 031-123-1234</li>
					<li>이메일 : 123-12-12345</li>
				</ul>
			</div>
			
			<div class="items">
				<h3>입금 정보</h3>
				<ul>
					<li>농협 123-123-123456</li>
					<li>The 베이킹</li>
				</ul>			
			</div>
			
			
		</div> <!-- box end -->
	</div>
	
</body>
</html>