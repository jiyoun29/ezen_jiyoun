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
		clear : both; /*Ŭ���� ������� ������ float ���� �� �򰥸� �� �ִ�*/
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
		
			<!-- �ΰ� -->
			<div id="footer_logo">
				<img alt="" src="img/photo.jpg">
			</div>
			
			<!-- �ɰ��� ���� �ʿ� -->
			
			<!-- ȸ������ -->
			<ul id="address">
				<li>����� ������ �Ｚ�� 1234 ��:123-1234</li>
          	 	<li>TEL:031-123-1234 Email : email@domain.com</li>
           	 	<li>COPYRIGHT (C) ����� ALL RIGHTS RESERVED</li>
			</ul>
			
		</div>
	</div>
	
	
	
</body>
</html>