<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp main</title>
</head>
<body>


	<!-- ���� ��ġ(����)�� �ٸ� ���� �����ϱ� -->
	<%@include file = "Header.jsp" %>
	
	<br><br><br><br><br><br>
	<!--  ĳ���� : �̹��� �����̵�  -->
	<div id="cs" class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000">
								<!-- �����̵�ð� : �и���(1000/1��)  -->
		<!-- �����̵� ��ġ ǥ�� : �ε������� -->
		<div class="carousel-indicators">
			<button data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
			<button data-bs-target="#cs" data-bs-slide-to="1"></button>
			<button data-bs-target="#cs" data-bs-slide-to="2"></button>
			<button data-bs-target="#cs" data-bs-slide-to="3"></button>
		</div>
		 <!-- ĳ���� ���빰 -->
		<div class="carousel-inner">
			<div class="carousel-item active"> <img alt="" src="img/img (1).jpg"> </div>
			<div class="carousel-item "> <img alt="" src="img/img (2).jpg"> </div>
			<div class="carousel-item "> <img alt="" src="img/img (3).jpg"> </div>
			<div class="carousel-item "> <img alt="" src="img/img (4).jpg"> </div>
		</div>
		<!-- �̹��� �̵� ��ư -->
		<button class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
		
	</div><!-- ĳ���� end -->
	
	<br><br>
	
	<div class="container text-center">
		 <hr> <!-- �Ǽ� �±� -->
		 	<h3> new arrival </h3>
		 	<p> �Ż�ǰ </p>
	</div>
	
	<div class="container">
		<div class="row">
		
		<!-- ���δ�Ʈ ����Ʈ ���� % �̿��ؼ� db������ ���Ѽ� i�ڸ��� ����Ʈ ����� ���� -->

			<div class="col-md-3 col-sm-6"> <!-- col-md-* :760px �̻�. col-sm-* : 570px �̻� -->
				<div class="card"> <!-- ī�� ���� -->
					<img class="card-item-top" alt="" src="img/img.webp"> <!-- �̹��� -->
					<div class="card-body">
						<p class="item">
							<span class="title"> ���Ĵٵ� ���� ������ 7�� ������ </span>
							<br>
							<span class="content">
							[1+1] ������� ������ ����
							(+S/M/L/XL)
							700�� �ı� ����! ���� �Ǹ� 1��
							</span>
							<br>
							<span class="price"> 79,900�� </span> 75,900��
							<br>
								<!-- ��ư �������� �ٹ̱� -->
							<span class="badge bg-warning text-dark">�ֹ�����</span>
							<span class="badge bg-danger text-dark">ǰ���ӹ�</span>
						</p>
					</div>
				</div>
			</div>
			
			
			
		</div>
	</div>
	
		 	

	<%@include file = "Footer.jsp" %>
	
</body>
</html>