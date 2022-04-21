<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>메인 이미지</title>
	<style type="text/css">
	
	*{box-sizing: border-box;} /*박스 사이즈를 보더 기준으로 맞춤*/
	
		#mainimg{
			height: 350px;
			background-image: url("img/main_bg.jpg");
			background-repeat: no-repeat;
			background-position: top center;
			text-align: center; /*이미지 배치할 땐 align 쓰기*/
			padding: 200px 0 0 760px;
		}
		
		
		
	
	</style>
</head>
<body>
	<div id="mainimg">
		<a href="#"><img src="img/btn_class.jpg"></a>
		<!-- 배경 위에 버튼 이미지 만들기 -->
		<!-- a태그 넣고 소스값을 이미지 소스를 넣기 -->
	</div>
</body>
</html>