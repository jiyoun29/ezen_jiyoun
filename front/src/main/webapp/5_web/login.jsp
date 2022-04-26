<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">

.button{padding:22px 20px; background-color: grey; color: white;}
.button2{padding:14px 150px; background-color: grey; color: white;}
h3{text-align: center;}
.sidebo{font-size: 11px;}
.social{padding:20px 0 20px 0; magin:0; border:0;}
span{margin-left: 50px;}
.nologin{font-size:12px;}
.nologinmem{background: white; soild:grey; padding: 10px 90px;}
.center{width: 500px; margin: 0 auto;}

</style>
</head>
<body>
	<%@include file="Index.jsp" %>
	
	<div class="container d-flex justify-content-center">
	<div class="content col-md-6 mx-6">
	
	<h3>LOGIN</h3>
		<br><br><br>
		<div class="center">

			<table class="col-md-4 offset-2">
				<tr>
					<td class="login"> <input type="text" placeholder="아이디"> </td>
					<td id="login" rowspan="2"> <button class="button">LOGIN</button> </td>
				</tr>
				<tr>
					<td class="login"> <input type="password" placeholder="비밀번호"> </td>	
				</tr>
			</table>
			
			<table class="col-md-8 offset-2">
				<tr class="sidebo nav">
				<td>
			<input class="form-check-input" type="checkbox" value=""> 아이디 저장
				</td>
				<td>보안접속 | &nbsp;&nbsp;</td>
				<td>아이디찾기 |&nbsp;&nbsp;</td>
				<td>비밀번호찾기</td>
				</tr>
			</table>

		
		<ul class="social row">
			<li class="col-md-5">
			<img src="//img.echosting.cafe24.com/skin/base_ko_KR/member/btn_naver_login.gif" alt="네이버 로그인">
			</li>
			<li class="col-md-5">
			<img src="//img.echosting.cafe24.com/skin/base_ko_KR/member/btn_facebook_login.gif" alt="Facebook으로 로그인">			
			</li>
			<li class="col-md-5">
			<img src="//img.echosting.cafe24.com/skin/base_ko_KR/member/btn_kakao_login.gif" alt="카카오계정 로그인">			
			</li>
			<li class="col-md-5">
			<img src="//img.echosting.cafe24.com/skin/base_ko_KR/member/btn_apple_login.gif" alt="Apple로 로그인">
			</li>
			
		</ul>
		
		<button class="button2">JOIN US</button>
		
		<br><br>
		<span style="font-size:13px; color:gray;">비회원의 경우, 주문시의 주문번호로 주문조회가 가능합니다.</span>
		<br>		
		<table class="nologin col-md-7 offset-2">
			<tr>
				<td>주문자명</td>
				<td><input type="text"></td>
			</tr>
		
			<tr>
				<td>주문번호</td>
				<td><input type="text"></td>
			</tr>

			<tr>
				<td>비회원주문 비밀번호</td>
				<td><input type="text"></td>
			</tr>		
			
			<tr>
				<td colspan="2">
				<button class="nologinmem">비회원 로그인</button>
				</td>
			</tr>
		</table>
		</div>
	</div>
	</div> <!-- 콘테이너 끝 -->
	
</body>
</html>