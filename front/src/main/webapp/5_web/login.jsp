<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<!-- ��������� css -->
	<link href="css/login.css" rel="stylesheet" >
	
</head>
<body>
	<%@include file="Index.jsp" %>
	
	<div class="container d-flex justify-content-center">
	<div class="content col-md-6 mx-6">
	
	<h3>LOGIN</h3>
		<br><br><br>
		<div class="center">

			<table class="col-md-4 offset-2 form-floating mb-3">
				<tr>
					<td class="login"> <input type="id" placeholder="���̵�"> </td>
					<td id="login" rowspan="2"> <button class="button">LOGIN</button> </td>
				</tr>
				<tr>
					<td class="login"> <input type="password" placeholder="��й�ȣ"> </td>	
				</tr>
			</table>
			
			<table class="col-md-8 offset-2" id="check">
				<tr class="sidebo nav">
				<td>
			<input class="form-check-input" type="checkbox" value=""> ���̵� ����
				</td>
				<td>�������� | &nbsp;&nbsp;</td>
				<td>���̵�ã�� |&nbsp;&nbsp;</td>
				<td>��й�ȣã��</td>
				</tr>
			</table>

		
		<ul class="social nav justify-content-center">
			<li>
			<img src="//img.echosting.cafe24.com/skin/base_ko_KR/member/btn_naver_login.gif" alt="���̹� �α���">
			</li>
			<li>
			<img src="//img.echosting.cafe24.com/skin/base_ko_KR/member/btn_facebook_login.gif" alt="Facebook���� �α���">			
			</li>
			<li>
			<img src="//img.echosting.cafe24.com/skin/base_ko_KR/member/btn_kakao_login.gif" alt="īī������ �α���">			
			</li>
			<li>
			<img src="//img.echosting.cafe24.com/skin/base_ko_KR/member/btn_apple_login.gif" alt="Apple�� �α���">
			</li>
			
		</ul>
		
		<button class="button2">JOIN US</button>
		
		<br><br>
		<span style="font-size:13px; color:gray;">��ȸ���� ���, �ֹ����� �ֹ���ȣ�� �ֹ���ȸ�� �����մϴ�.</span>
		<br>		
		<table class="nologin col-md-7 offset-2">
			<tr>
				<td>�ֹ��ڸ�</td>
				<td><input type="text"></td>
			</tr>
		
			<tr>
				<td>�ֹ���ȣ</td>
				<td><input type="text"></td>
			</tr>

			<tr>
				<td>��ȸ���ֹ� ��й�ȣ</td>
				<td><input type="text"></td>
			</tr>		
			
			<tr>
				<td colspan="2">
				<button class="nologinmem">��ȸ�� �α���</button>
				</td>
			</tr>
		</table>
		</div>
	</div>
	</div> <!-- �����̳� �� -->
	
</body>
</html>