<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>board jsp</title>
</head>
<body>
	
	<!--jsp ��� ���� ������� -->
	<%@include file="Header.jsp" %>
	
	<br><br><br><br><br><br><br>
	
	<div class="container"> <!-- ��Ʈ��Ʈ��. �ڽ��� ���� -->
		
		<h3>������</h3>

			<!-- �׸��带 ���ٷ� ǥ���ϱ� ���ؼ� row ���(inline �ᵵ ���x), my:���Ʒ� �ٱ����� -->
		<div class="col-md-5 offset-7 row g-0 my-4"> <!-- �׸���[�ڽ��� ���� 12����] -->
				<!-- 5ĭ ��� ���� 7ĭ ���� -->
			<div class="col-md-3"> <!-- ��� ���� -->
				<select class="form-select"> <!-- �ڽ��ǿ� ȿ�� ���� -->
					<option>Ű����</option>
					<option>��ȣ</option>
					<option>����</option>
					<option>�ۼ���</option>
				</select>
			</div>

			<div class="col-md-6">
				<input type="text" class="form-control">
			</div>
			
			<div class="col-md-3"> <!-- �˻���ư -->
				<button class="form-control"> �˻� </button>		
			</div>	
			
		</div>

		
		<!-- ��ǲ�ڽ�, ��ư�� ���� �⺻ ���� ������ ��Ʈ�� ���� ���� �ʴ´�.
		���� ���̰� �ʹٸ� g-0 ���� ������ �����Ѵ�. (���� ���� Ŭ������ �ֱ�) -->
		
		
		<table class="table table-hover text-center"> <!-- ���̺� �±� -->
		
			<tr class="text-center"> <!-- ��row�±� -->
				<th> ��ȣ </th>
				<th> ���ǻ��� </th>
				<th> ���� </th>
				<th> �ۼ��� </th>
				<th> �ۼ��� </th>
			</tr> <!-- �� end -->
			
			<tr class="text-center">
				<td> 1 </td> <td> ���� </td> <td> <a href="boardview.jsp"> ȯ�� ��û �帳�ϴ�. </a> </td> <td> 2022-04-23 </td> <td> ���缮 </td>
			</tr>
			<tr class="text-center">
				<td> 2 </td> <td> ���� </td> <td>	  <a href="boardview.jsp"> ��� ���� </a> </td> <td> 2022-04-24 </td> <td> ����ȿ </td>
			</tr>
			<tr class="text-center">
				<td> 3 </td> <td> ���� </td> <td>  <a href="boardview.jsp"> ȸ�� Ż�� </a> </td> <td> 2022-04-25 </td> <td> �̱��� </td>
			</tr>
			<tr class="text-center">
				<td> 4 </td> <td> ���� </td> <td>  <a href="boardview.jsp"> ������ ���� </a> </td> <td> 2022-04-25 </td> <td> ���ҹ� </td>
			</tr>
			
		</table> <!-- ���̺� end -->
	
	<!-- ������ ó�� -->
		<div class="row">
			<div class="col-md-4 offset-4 my-3">
				<ul class="pagination"> <!-- ����¡. navbaró�� ���� -->
					<li class="page-item"> <a class="page-link" href="#">����</a> </li>
					<li class="page-item"> <a class="page-link" href="#">1</a> </li>
					<li class="page-item"> <a class="page-link" href="#">2</a> </li>
					<li class="page-item"> <a class="page-link" href="#">3</a> </li>
					<li class="page-item"> <a class="page-link" href="#">4</a> </li>
					<li class="page-item"> <a class="page-link" href="#">5</a> </li>
					<li class="page-item"> <a class="page-link" href="#">����</a> </li>
				</ul>
			</div>
			<div class="col-md-2 offset-2 my-3">
				<a href="boardwrite.jsp"><button class="form-control">�����ϱ�</button></a>
			</div>
		</div>
	
	</div> <!-- �ڽ� ���� -->

	<br><br><br><br><br><br><br>
	
	<%@include file="Footer.jsp" %>
	
</body>
</html>