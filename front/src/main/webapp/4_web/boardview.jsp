<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>boardview</title>
</head>
<body>
	<%@include file="Header.jsp" %>
	<br><br><br><br><br><br><br>
	
	
	<div class="container">
		<h3 class="text-center titleline"> ���� �� </h3>
		
		<!-- ��ư -->
		<div class="my-3"> <!-- �ۼ��� ���� -->
			<a href="board.jsp"><button class="btn btn-outline-info">���</button></a>
			<a href="board.jsp"><button class="btn btn-outline-info">����</button></a> <!-- �ۼ��ڸ� ����[��ȿ�� �˻�] -->
			<a href="board.jsp"><button class="btn btn-outline-info">����</button></a><!-- �ۼ��ڸ� ����[��ȿ�� �˻�] -->
			<a href="board.jsp"><button class="btn btn-outline-info">�亯</button></a>  <!-- �����ڸ� ����[��ȿ�� �˻�] -->
		</div>

		<!-- �ۼ��ڰ� �Է��� ���� -->
		<div> <!-- �ڽ���:display:block/ span �ڽ��� : display:inline -->
		 <!-- ���ٷ� �� ��� span -->
			<div><span> �ۼ��� </span> <span> ���缮 </span></div>
			<div><span> ���ǳ�¥ </span> <span> 2022-0425 </span></div>
		</div>
		<div>
			<input type="text" value="ȯ�����ּ���" class="form-control" readonly>
		</div>
		<div> <!-- db���� �������ų� textarea�� �������� -->
			<textarea rows="10" cols="" class="form-control" readonly style="resize:none;"> ȯ�� ��Ź�帳�ϴ�.</textarea>
		</div>												<!-- �����Ұ�disabled="disabled" -->
		<br>
		

		<div class="row"> <!-- ÷�ε� ������ -->
		<h3>÷�� ����</h3>
			<div class="col-md-3">
				<img alt="" src="img/img (3).jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="img/img (3).jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="img/img (3).jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="img/img (3).jpg" width="100%">
			</div>
		</div>
		
		
		<br>
		<!-- ������ �亯 -->
		<h4>�亯</h4>
		<p>�亯��¥ : 2022-04-23 12:10</p>
		<div>												<!-- �б��� / ũ����� -->
			<textarea rows="5" cols="" class="form-control" readonly style="resize:none;"> ����ϰڽ��ϴ�. </textarea>
		</div>
		
	</div>
	
	<br><br><br><br><br>
	<%@include file="Footer.jsp" %>
</body>
</html>