<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>boardwrite</title>
</head>
<body>
	<%@include file="Header.jsp" %>
	
	<br><br><br><br><br><br><br>
	
	<div class="container"> <!-- ���� -->
	
		<h3 class="text-center"> ���Ǳ� ���� </h3>
		<div class="titleline"></div>
		
		<form action="" method="get"> <!-- �� ��� [�Է°��� ���۰���:���а� ���� �� ���� �߿�***] -->
			<!-- �ڹ� ��Ʈ�ѿ��� ����(action ��ȣ �ȿ�) -->	<!-- �Է� ���� �� �ִ� ���� �ִ� ��(size=""�� ��� ����) -->
			
			<div class="row"> <!-- ��ġ ���� -->
				<div class="col-md-3">
			�ۼ��� : <input type="text" class="form-control" placeholder="�ۼ���" maxlength="10">
				</div>
				<div class="col-md-3">
			��й�ȣ : <input type="password" class="form-control" placeholder="�ۼ���" maxlength="5" >
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-8">
			���� : <input type="text" class="form-control" placeholder="���� ������ �ۼ����ּ���." maxlength="50">
				</div>
			</div>
							<!-- col�� ���� �Է� ������ Ǯ ������ -->
			���� : <textarea rows="15" cols="" class="form-control" ></textarea>
			
				<div class="col-md-3">
			÷������ : <input type="file" class="form-control" >
				</div>
			 <!-- html�� ���¸� ��� ��Ʈ��Ʈ������ ��� �ٲ� -->
			 
			 
			<div class="com-md-4 offset-4 row">
				<div class="col-md-4">
			<input type="submit" value="���" class="form-control" > <!-- �� ���۹�ư. �׼� �ȿ� ���� ������ ���ư� -->
				</div>
				<div class="col-md-4">
			<input type="reset" value="�ٽ� ����" class="form-control" >
				</div>
				<div class="col-md-4">
			<a href="board.jsp"><button class="form-control"> ��� </button></a>
				<!-- �ڷΰ��� ��ư�� ����� -->
				</div>
			</div>
			
		</form>

	</div>	
	
	<br><br><br><br><br>
	
	<%@include file="Footer.jsp" %>

</body>
</html>