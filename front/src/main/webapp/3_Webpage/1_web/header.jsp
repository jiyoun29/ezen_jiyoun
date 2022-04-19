<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Index_header</title>

	<style type="text/css">
	
	@font-face {
    font-family: 'IM_Hyemin-Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2106@1.1/IM_Hyemin-Bold.woff2') format('woff');
    font-weight: normal;
    font-style: normal; }
    
    
    	/*<a href>��ũ ���� �⺻�� ����*/
	a{ text-decoration: none; color:maroon; }
	a:hover{color:darksalmon;}
	/*�⺻������ ������ ���� ��� �⺻ ���� ���� (�� �ΰ��� ���ο� �θ� ����)*/
	*{padding: 0px; margin: 0px;}
	
	
	
	#header{
		width: 1150px; /*���� ����*/
		height: 100px; /*���� ����*/
		margin : 0 auto; /*�ڽ��� ��� ����*/
	}
		
		#logo{float: left; margin: 20px 0 0 20px;}
		#menus{float: right;}
		
		#top_menu{ text-align: right; margin-top: 20px;	}
		
		
		#main_menu{margin-top: 20px; font-family: IM_Hyemin-Bold; font-size: 20px;}
		
		/*���� �޴��� ����Ʈ ���� ����������.		�޴� �� ����*/
		#main_menu li{ display: inline; margin-left: 80px;}
		
		
		
	</style>
	
</head>
<body>
	
	<!-- ��� ���丷 ���� -->
	<div id="header"> 
	
		<div id="logo"> <!-- �ΰ� -->
			<a href="Index.jsp"> <img alt="" src="img/logo.jpg"> </a>
		</div>
	
	
	
		<div id="menus"> <!-- �޴� -->
			<div id="top_menu"> <!-- ��� �޴� -->	<!-- �����۸�ũ �ɱ�. #�� �ӽ� -->
				<a href="login.jsp">�α���</a> �� 
				<a href="signup.jsp">ȸ������</a> �� 
				<a href="board.jsp">��������</a>
			</div>
			
			
			<ul id=main_menu> <!-- ���� �޴� -->
			
				<li><a href="#">�����̷�</a></li>
				<li><a href="#">��������</a></li>
				<li><a href="#">�����۰�</a></li>
				<li><a href="#">������1</a></li>
				<li><a href="#">������2</a></li>
			
			</ul>
		
		
		</div> 
	
	
	</div>
	
</body>
</html>