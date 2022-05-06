<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입</title>
<style type="text/css">

	
	*{color: #FFAAAA; text-align: center;}
	
	.sign{width: 100px; height: 50px; padding:10px 10px;}
	button{background-color: white; border: solid 1px #FFAAAA;}
	.back{ width:1280px;height:720px; background: linear-gradient(to top, #FFC9C9, white);}


</style>
</head>
<body>
	<%@include file = "../header.jsp" %>
	
	<div class="container col-md-6">
		<div class="back">
		<h3>회원가입 페이지</h3>
		<form id="signupform" action="../signup" method="post">
			아이디<br><input type="text" id="mid" name="mid" placeholder="user id"> <br>
			<span id="idcheck"></span> <br>

			비밀번호<br><input type="password" id="mpw" name="mpw" placeholder="user pw"> <br>
			비밀번호 확인<br><input type="password" id="mpwcheck" placeholder="password check"> <br>
			<span id="mpwch"> </span> <br>
			
			이름<br><input type="text" id="mname" name="mname" placeholder="user name"> <br>
			<span id="namecheck"> </span> <br>

			전화번호<br><input type="text" id="mphone" name="mphone" placeholder="user phone"> <br>
			<span id="phonecheck"> </span> <br>


			이메일<br><input type="email" id="memail" name="memail" placeholder="user email" style="width: 100px;">@
			<input type="text" id="memailaddress" name="memailaddress" style="width: 120px;"> 
			<select id="emailselect">
				<option value=""> 직접 입력 </option>
				<option value="naver.com"> naver.com </option>
				<option value="hanmail.net"> hanmail.net </option>
				<option value="kakako.com"> kakako.com </option>
				<option value="gmail.com"> gmail.com </option>
			</select> <br>
			<span id="emailcheck"> </span> <br>
			
			
			주소<br>
		<input type="text" id="sample4_postcode" name="address1" placeholder="우편번호" style="width: 100px;">
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" style="background-color: white; border: solid 1px #FFAAAA;"><br>
		<input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소"><br>
		<input type="text" id="sample4_jibunAddress" name="address3" placeholder="지번주소"><br>
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress" name="address4" placeholder="상세주소">
			<span id="addresscheck"> </span> <br>	
		
		<br>
			<button onclick="signup()" type="button" class="sign"> 가입하기</button>
		</form>
		
	</div>
	</div>



	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="../js/signup.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>
</body>
</html>