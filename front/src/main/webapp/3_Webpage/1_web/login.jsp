<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
	
		#contents{ margin: 100px 0px; }
		#contents h3{text-align: center;}
		table{ width: 350px; margin: 0px auto; }
		input { height: 25px; }
		button { padding: 22px 20px; }
		h4{ text-align: center; }
		
	
	</style>

</head>
<body>

	<!-- ��� -->
	<%@include file="header.jsp" %>

	<!-- ��� �̹��� -->
	<%@include file="mainimg.jsp" %>
	
	
	<!-- ���� -->
	<div id="contents">
		<h3>�α���</h3>
		
		<table> 
			<tr>
				<td> ���̵� </td>
				<td> <input type="text"> </td>
				<td rowspan="2"> <button>�α���</button> </td>
			</tr>
			<tr>
				<td> ��й�ȣ </td>
				<td> <input type="password"> </td>	
			</tr>
		</table>
	
	</div>
	
	
	<!-- Ǫ�� -->
	<%@include file="foot.jsp" %>

</body>
</html>