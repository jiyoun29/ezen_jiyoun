<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������navbar</title>
</head>
<body>
	<!-- ����ö� ����� �������� -->
	<%@include file="1_��ġ.jsp" %>
	
	<!-- 
		container / grid 12ĭ
	 -->




		<div class="container"> <!-- �ڽ��� -->	<!-- ��������.  bg-dark�� ����� ��İ� ���巯�� -->	
			<div class="navbar navbar-expand-md navbar-light"> <!-- �׺���̼� �� -->
			
				<a href="#" class="navbar-brand"> �ΰ� </a>


			<!-- �޴� ����� �۾����� ��� -->
			<button class="navbar-toggle" type="button"

				data-bs-toggle="collapse" data-bs-target="#navmenu" 
				aria-controls="navbarcontents"aria-expanded="false" >
				<!-- Ÿ�ٰ� ���̵� �����ϰ� ����� -->
				
				
					<!-- �޴��� ������� ���̰� �Ϸ��� collapse -->
				<span class="navbar-toggler-icon"></span>
			</button>


			<!-- collapse�� Ư�� ������� �پ��� ������� -->
			<div class="collapse navbar-collapse" id="navmenu"> <!-- 760px ���ϰ� �Ǹ� ����� -->
			
			
			
				<ul class="navbar-nav"> <!-- �۸Ӹ� ����, �׺���̼� ��� -->
					<!-- ���̰��̼� ��� �� / ������ -->
					<li class="navbar-item"> <a href="#" class="nav-link"> �޴�1 </a> </li>	
					<li class="navbar-item"> <a href="#" class="nav-link"> �޴�2 </a> </li>	
					<li class="navbar-item"> <a href="#" class="nav-link"> �޴�3 </a> </li>				
					
					
					<!-- �� ����üũ ���ϱ� -->
					<li  class="nav-item dropdown"> <!-- ��Ӵٿ� �޴� -->
	
						<!-- nav-link : ����, �� �ٲ��� / dropdown-toggle : ȭ��ǥ -->
						<!-- �ϴ� �ؽ�Ʈ�� Ŭ������ �� �޴� ��ġ�� -->
						<a href="#" data-bs-toggle="dropdown">
						����ٿ� </a>
						
						<div class="dropdown-menu" aria-labelledby="navdrop"> <!-- �޴���� �˷���(�����) -->
							<a class="dropdown-item" href="#"> ����ٿ� �޴�1 </a>
							<a class="dropdown-item" href="#"> ����ٿ� �޴�2 </a>
							<a class="dropdown-item" href="#"> ����ٿ� �޴�3 </a>
						</div>
						
					</li>
					
				</ul> <!-- �׺���̼� ��� �� -->
	
	
	
	
				
				<form action="">
					<div class="row">
						<div class="col-md-5">
							<input type="text" class="form-control" placeholder="�˻���">
						</div>
						
						<div class="col-md-5">
						<button class="form-control" type="submit"> �˻� </button>
						</div>
						
					</div>
				</form>
			</div>
		</div>


	
	</div>
	
	
	
	
</body>
</html>