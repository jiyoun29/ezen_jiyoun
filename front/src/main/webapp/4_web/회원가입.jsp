<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<%@include file="Header.jsp" %>
	
	<br><br><br><br><br><br><br>
	
<div class="container row" style="float: none; margin: 0 auto;">
		<div class="col-md-6">
			<h6><p>ȸ������ �� �������� ���� �̿��� ���� �Ʒ� ����� �о�ð�,
			���� ���θ� �������ּ���.</p></h6>
			<p>�ʼ� ����� ���� �ϼž� ȸ�������� �����մϴ�.</p>
		
		<div class="line" style="border-bottom: solid 1px gray; width: 100%"></div><br>
		
	<h3>ȸ�� ���� ��� ����<span style="color:orange">*</span></h3>
		<textarea rows="7" cols="50" readonly class="form-control" resize: none; style="background-color:#ffffff">
	�� 1�� ��Ģ
	�� 1 ��(����)
	�� ����� ���������������� ������Ʈ(���� "����������������")�� �����ϴ� ��� ����(���� "����")�� �̿����� �� ����, ȸ���� ������������������ �Ǹ�, �ǹ�, å�ӻ��װ� ��Ÿ �ʿ��� ������ �������� �������� �մϴ�.
	
	�� 2 ��(����� ȿ�°� ����)
	1. ������������������ �̿��ڰ� �� ��� ���뿡 �����ϴ� ���, ������������������ ���� ���� ���� �� ȸ���� ���� ��� ������ �� ����� �켱������ ����˴ϴ�.
	2. ������������������ ����� ������ ���, �������� �� ���������� ����Ͽ� �������� �Բ� ������������������ �ʱ�ȭ�鿡 �� ������ 7�� �������� ���� ���ϱ��� �����մϴ�. ��, ȸ���� �Ҹ��ϰ� ��������� �����ϴ� ��쿡�� �ּ��� 30�� �̻��� ���� �����Ⱓ�� �ΰ� �����մϴ�. �� ��� ������������������ ���� �� ����� ���� �� ������ ��Ȯ�ϰ� ���Ͽ� ȸ���� �˱� ������ ǥ���մϴ�.
	3. ����� ����� ���������������� Ȩ�������� �����ϰų� e-mail�� ���� ȸ������ �����ϸ�, ����� ��Ģ�� ��õ� ������ �� ȿ���� �߻��˴ϴ�. ȸ���� ����� ����� �������� �ʴ� ���, ȸ���� ������ ȸ������� ���(ȸ��Ż��)�� �� ������, ����� ����� ȿ�� �߻��Ϸκ��� 7�� �̳��� �ź��ǻ縦 ǥ������ �ƴ��ϰ� ���񽺸� ��� ����� ���� ��� ���濡 ���� ���Ƿ� ���ֵ˴ϴ�.
	�� 3 ��(��� �� ��Ģ)
	�� ����� ��õ��� ���� ������ ������ű⺻��, ������Ż����, ���������������ȸ���Ǳ���, ������� ��������, ���α׷���ȣ�� �� ��Ÿ ���� ������ ������ ���մϴ�.
	</textarea><br>
		<input type="checkbox">ȸ������ ����� �����մϴ�. <br>

		<div class="line" style="border-bottom: solid 1px gray; width: 100%"></div><br>
	
	<h3>��������ó����ħ<span style="color:orange">*</span></h3>
		<textarea rows="7" cols="50" readonly  class="form-control" resize: none; style="background-color:#ffffff">
		�� 1�� ��Ģ
		
		��1��(����)�� ��ħ�� ���������� ��ȣ����(���� "��"�̶� �Ѵ�) ��12�� �� 1�׿� ���� ���������� ó���� ���� ����, �������� ħ���� ���� �� ������ġ � ���� �������� ������ �������� �������� �Ѵ�.
		��2��(����� ����) �� ��ħ���� ����ϴ� ����� ���� ������ ����.
		1."�������� ó��"�� ���������� ����, ����, ����, ����, ���, ����, ����, ����, ����, �˻�, ���, ����(����), ����, �̿�, ����, ����, �ı�(��Ѧ) �������		
		</textarea><br>
		<input type="checkbox">��������ó����ħ�� �����մϴ�.
	</div>
	
	
	<div class="col-md-6">
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="���̵� �Է��ϼ���*" maxlength="10"> <br>
		</div>
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="��й�ȣ�� �Է��ϼ���*" maxlength="10"> <br>
		</div>
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="�ѹ� �� ��й�ȣ�� �Է��ϼ���*" maxlength="10"> <br>
		</div>
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="�̸��� �Է��ϼ���*" maxlength="10"> <br>
		</div>
		
			<div class="row">
				<div class="form-chek col-md-2 offset-4">
				<input type="radio" name="m">���� </div>
				<div class="form-chek col-md-2">
				<input type="radio" name="f">���� </div>
			</div> <br>
			
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="����ó�� �Է��ϼ���*" maxlength="20"> <br>
		</div>
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="�̸����� �Է��ϼ���*" maxlength="40"> <br>
		</div>
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="���̸� �Է��ϼ���*" maxlength="3"> <br>
		</div>
		
		<!-- //////////////////////////////////////////// -->
		<div class="row">
			<div class="col-md-4">
				<h5>�ּ�<span style="color:orange">*</span></h5>
			</div>		
				<div class="col-md-4">
					<input type="text" placeholder="�����ȣ" class="form-control">
				</div>
				<div class="col-md-4">
					<button class="form-control">�����ȣ ã��</button>
				</div>
				
			<div class="col-md-4">	</div>
			<div class="col-md-4">
				<input type="text" placeholder="���θ��ּ�" class="form-control">
			</div>
			<div class="col-md-4">
				<input type="text" placeholder="�����ּ�" class="form-control">
			</div>
			
			<div class="col-md-4"></div>
			<div class="col-md-8">
				<input type="text" placeholder="���ּ�" class="form-control">
			</div>
			
		</div>
				<button class="col-md-6 form-control">ȸ������</button>	
	</div>

			
</div>
	
	
	<br><br>

	<%@include file="Footer.jsp" %>
</body>
</html>