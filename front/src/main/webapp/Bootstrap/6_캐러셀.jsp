<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ĳ����</title>
	
	<style type="text/css">
	
		.carousel-item{ /*�̹� ���ǵ� ��Ʈ��Ʈ�� Ŭ���� ����*/
			width: 70%; height: 50%;	}
	
	
	
	</style>
	
	
	
</head>
<body>

	<!-- ����ö� ����� �������� -->
	<%@include file="1_��ġ.jsp" %>
	
	
	<!-- �̹��� �����̵� : ĳ���� -->
	<div class="container"> <!-- �ڽ��� -->
	
		<div id="cs" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="2000"> <!-- ĳ���� -->
								<!-- data-interbval : �����̵� �ð�(�и���) -->


			<!-- ���콺 �ø� ���¿����� �� �����δ� -->

			<!-- ĳ���� [���� ��ġ] �ϴ� ��ư : �ε������� -->
			<div class="carousel-indicators">			<!-- ����(�ε���) ���� -->
				<button type="button" data-bs-target="#cs" data-bs-slide-to="0" class="active"> </button> <!-- ���� ������ŭ -->
				<button type="button" data-bs-target="#cs" data-bs-slide-to="1" class="active"> </button>
				<button type="button" data-bs-target="#cs" data-bs-slide-to="2" class="active"> </button>
				<button type="button" data-bs-target="#cs" data-bs-slide-to="3" class="active"> </button>
			</div>
			<!-- 0������ �����ؼ� ��� ����. active�� �־ �����ϵ��� ���ش�. -->


				<div class="carousel-inner">
				
					<div class="carousel-item active"> <!-- ĳ���� ����, active:���� -->
						<img alt="" src="../cat2.jpg" width="100%">
						
							<div> ĳ�������� ���� �����̴� ���� ��������׸� �ִ� </div>
						
					</div>
		
					<div class="carousel-item">  <img alt="" src="../city.jpg" width="100%"></div>
					<div class="carousel-item"> <img alt="" src="../cloud.jpg" width="100%"></div>
					<div class="carousel-item"> <img alt="" src="../dang.jpg" width="100%"></div>
					
					
					<!-- ĳ���� �̵� ��ư -->	<!-- ������ -->
					<a class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
									<!-- �ش� �ɷ����� ��ư�̶�� ������ id�� �̸� �ű�� �ݵ�� ����(�� ���������� bs�߰� �ʿ�) -->
						<span class="carousel-control-prev-icon"></span>
					</a>
					
					<!-- ĳ���� �̵� ���� ��ư -->
					<button type="button" class="carousel-control-next" data-bs-target="#cs" data-bs-slide="prev">
									<!-- �ش� �ɷ����� ��ư�̶�� ������ id�� �̸� �ű�� �ݵ�� ����(�� ���������� bs�߰� �ʿ�) -->
						<span class="carousel-control-next-icon"></span>
					</button>
	
				</div>
			
		</div> <!-- ĳ���� �� -->
	
	</div>
</body>
</html>