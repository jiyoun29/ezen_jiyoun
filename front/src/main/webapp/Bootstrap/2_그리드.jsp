<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�׸���</title>
	
	<style type="text/css">
	
	*{border: solid 1px red;}
	
	</style>
	
</head>
<body>

	<%@include file="1_��ġ.jsp" %>
	<!-- 1�� ��ġ�ص� ��Ʈ��Ʈ�� ����� -->

	<!-- �ڽ��� : container, �׸��� : 12�������� �ɰ� ���� ����, ���� ��ġ -->
	<!-- �ȼ��� �ƴ϶� �������� ����ؼ� �����(�� ����)... ��Ʈ��Ʈ�� ���� �о�� -->
	
	<div class="container"> <!-- �ڽ��� ����(�⺻�� 1200px ����) -->
		�����ٶ󸶹ٻ�

	<!-- row : �ζ���, ���ι�ġ -->
		<div class="row">
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>

			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
		</div>
		
		<div class="row"> <!-- ���ι�ġ -->
			<div class="col-md-8"> .col-md-8 </div>		
			<div class="col-md-4"> .col-md-4 </div>		
		</div>
		
		
		<!-- ������ -->
		<div class="row"> <!-- ���ι�ġ -->
			<div class="col-md-4"> .col-md-4 </div>		
			<div class="col-md-4"> .col-md-4 </div>		
			<div class="col-md-4"> .col-md-4 </div>		
		</div>
		

		<div class="row"> <!-- ���ι�ġ -->
			<div class="col-md-6"> .col-md-6 </div>		
			<div class="col-md-6"> .col-md-6 </div>		
		</div>
		
	</div>
	
	
	
	

	<div class="container">
		<div class="row">
			<div class="col-md-8"> <!-- 8 -->
				<div class="col-md-4">	�ܺ� 8 �׸��� �� 4�׸��� ���	</div>
				<div class="col-md-8">	�ܺ� 4�׸��� �� 8�׸��� ���	</div>
			</div>
		
		
			<div class="col-md-4"> <!-- 4 -->
				<div class="row">
					<div class="col-md-6"> �ܺ� 4 �׸��� �� 6�׸��� ��� </div>
					<div class="col-md-6"> �ܺ� 4 �׸��� �� 6�׸��� ��� </div>
				<div>
			</div>

			</div>
		</div>
	</div>
	</div>
	
	
	<!-- �ǳʶٱ�, ������ �׸���, ����ĭ ���� -->
	<div class="container">
		<div class="row"> <!-- ���� 2ĭ�� ������ ���� offset ��� -->
			<div class="col-md-5"> col-md-5 </div>		
			<div class="col-md-5 offset-md-2"> col-md-5 </div>		
		</div>
		
		<div class="row"> <!-- ���������� �̵���Ű�� ������ -->
			<div class="col-md-4"> col-md-4 </div>
			<div class="col-md-7 offset-md-1"> col-md-7 </div>		
		</div>
	</div>
	
	
	<div class="container">
		<div class="row"> <!-- 12�׸��尡 �Ѿ�� ���� ��ġ�� �� �� -->
			<div class="col-md-5"> col-md-5 </div>
			<div class="col-md-8"> col-md-8 </div>
		</div>
	</div>
	
	
	
	

</body>
</html>