<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>


	<style type="text/css">
	
	form{ line-height: 180%; }
	
	h3{ text-align: center; }
	li{ list-style-type: none; } /*�۸Ӹ� ����*/

	/*��ü�� �ڽ��� ����*/
	#join{ width: 600px; /*�ڽ� ũ�Ⱑ �־�߸� ���� ����*/ 
		margin: 0 auto; /*��� ����*/
		border-top: 2px solid #cccccc; 
		border-bottom: 2px solid #cccccc;
		padding: 30px;
	}
 	
	.cols{padding: 5px;} /*���� ���� ���� ��� ul�� �־��ָ� �� ���� �ȴ�.*/
	.cols li{display: inline-block;}
	.col1{width: 150px;}
	.col2 input, select{ width:200px; height: 30px;} /*�� �̸� �ٿ�����...*/
	
	.email input , select  { height: 30px; }
	.hello{ vertical-align: top; } /* �ؽ�Ʈ �������� */
	
	#button{width: 600px;
			margin: 0 auto;
			text-align: right;	}
			
	#button input{ padding: 10px 20px; 
			margin-top: 20px; }
		
	</style>
	
</head>
<body>

	<!-- ��� -->
	<%@include file="header.jsp" %> <!-- jsp ���� ���� -->	
	
		
	<!-- ��� �̹��� -->
	<%@include file="mainimg.jsp" %>
	
	
	<!-- ���� -->
	
	<div id="contents">
	
	
	
	<h3>ȸ�� ���� ��</h3>

	<form> <!-- ����� -->

		<ul id=join>	<!-- ��ü -->
			<li> <!-- ��[tr] -->
				<ul class="cols"> 
					<li class="col1">���̵�</li> <li class="col2">
					<input type="text"> </li> </ul> </li> <!-- ��[td] -->
			
			<li> <ul class="cols"> <li class="col1"> ��й�ȣ</li>
			<li class="col2"> <input type="text"> </li> </ul> </li>
				
				
			<li> <ul class="cols"> <li class="col1">��й�ȣ Ȯ��</li>
			<li class="col2"> <input type="text"> </li> </ul> </li>
			<li> <ul class="cols"> <li class="col1">�̸�</li>
			<li class="col2"><input type="text"> </li> </ul> </li>
			
			<li> <ul class="cols"> <li class="col1">�̸���</li>
			<li class="col2"> <input type="text"> @ <select>
			 		<option> �����Է� </option>
			 		<option> naver.com </option>
			 		<option> hanmail.net </option>
			 		<option> gmail.com </option></select></li> </ul> </li>
			 		
			<li> <ul class="cols"> <li class="col1">�̸��� ����</li>
			<li> <input type="radio" name="email" checked="checked" > �����
			<input type="radio" name="email">���� </li> </ul> </li>
	
			<li> <ul class="cols"> <li class="col1">���԰��</li>
				<li><input type="checkbox" name="item1"> ģ����õ
			 	  <input type="checkbox" name="item2" > ���ͳݰ˻�
			 		 <input type="checkbox" name="item3" checked="checked"> ��Ÿ </li> </ul> </li>
			 		 
			<li> <ul class="cols"> <li class="col1 hello">�λ縻</li>
			<li class="col2"> <textarea rows="7" cols="50"></textarea></li> </ul> </li>
		</ul>
		
		<div id="button">
				<input type="submit" value="�����ϱ�">
				<input type="reset" value="����ϱ�">
			</div>
		
		</form>
	
	
	</div>
	
	
	<!-- Ǫ�� -->
	<%@include file="foot.jsp" %>
	
</body>
</html>