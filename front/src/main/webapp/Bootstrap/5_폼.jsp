<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��</title>
</head>
<body>

	<!-- ����ö� ����� �������� -->
	<%@include file="1_��ġ.jsp" %>
	
	<form> <!-- html�� ����� �� -->
		<label> �̸� </label>
		<input type="text" placeholder="�̸�">
		<label> �̸��� </label>	
		<input type="text" placeholder="�̸���">
		<button type="submit"> Ȯ�� </button>
	</form>

	<p>-------------------</p>

	<form> <!-- �ν�Ʈ���� -->
		<div class="form-group"> <!-- ��Ʈ�� ���� : from-group -->
			<label> �̸� </label>
			
					<!-- �� ����� ���巯�� -->
			<input class="form-control" type="text" placeholder="�̸�">
		</div>
		
		<div class="form-group">
			<label> �̸��� </label>	
			<input class="form-control" type="text" placeholder="�̸���">
		</div>
		
		<div class="form-group"><button type="submit"> Ȯ�� </button> </div>
	</form>
	
	<!-- form-control : ���� �ٹ̱� -->
	<input type="text" class="form-control">
	<input type="password" class="form-control">
	<input type="datetime-local" class="form-control">
	<textarea rows="5" cols="5" class="form-control"></textarea>
	
	
	<!-- üũ�ڽ� -->
	<div class="form-check">
		<input type="checkbox" class="form-check-input">
	</div>
	
	<!-- ���� -->
	<div class="form-check">
		<input type="radio"  class="form-check-input">
	</div>
	
	
	<div class="container row"> <!-- ������ ����Ҷ����� Ŭ������1 Ŭ������2�� ���� ���� -->
		<div class="col-md-2"> <input type="text" class="form-control"> </div>
		<div class="col-md-2 offset-3"> <input type="text" class="form-control"> </div>
		<div class="col-md-2 offset-3"> <input type="text" class="form-control"> </div>
	</div>
	
	
	
	<!-- �⺻���� ������ �ɱݹۿ� ����,, css�� �����ϸ� ������ ��� ���� -->
	<!-- ȸ�翡���� ���� �� ������,, -->
	<button type="button" class="btn btn-primary"> ��ư </button> <!-- �Ķ� -->
	<button type="button" class="btn btn-secondary"> ��ư </button> <!-- ȸ�� -->
	<button type="button" class="btn btn-info"> ��ư </button> <!-- �ϴû� -->
	<button type="button" class="btn btn-success"> ��ư </button> <!-- ��� -->
	<button type="button"> ��ư </button>
	
	
	<!-- �̹��� -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<img alt="" src="../cat2.jpg" width="100%"> <!-- ����ũ�� ���� -->
			</div>

			<div class="col-md-3">
				<img alt="" src="../cat2.jpg" width="100%" style="border-radius: 50px">
			</div>

			<div class="col-md-3">
				<img alt="" src="../cat2.jpg"  width="100%">
			</div>
		</div>
	</div>
	
	
	
</body>
</html>