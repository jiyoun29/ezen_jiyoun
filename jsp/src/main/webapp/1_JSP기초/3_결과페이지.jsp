<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	
	
    <!-- ������Ʈ�� ������ 
    �� �������κ��� request(��û)
    	request : ���� Ŭ������ �������ִ� ���尴ü(�̸� ������� ��ü)
    	request.getParameter("��û�� ������ name��")
    		���� : (String)���ڸ� ����
    		����ȯ : ���� -> ������ : integer.paseInt
     -->
    
    <% //��ũ��Ʈ�� = �ڹ� �� �ۼ��ϰ� �����ϴ� ����(�޼ҵ�����x)
    	String �̸� = request.getParameter("name");
    	String ���� = request.getParameter("color");
    	
    //���
    boolean admin = true;
    if(!�̸�.equals("������")){admin=false;}
    int �ݺ�Ƚ�� = Integer.parseInt(request.getParameter("number"));
    int �� = Integer.parseInt(request.getParameter("hang"));
    %>
    
<html>
<body style="background-color: <%=����%> ">
    
    �ۼ��� �̸� : <%=�̸� %><br>
    ������ ���� : <%=���� %><br>

	<% if(admin == true){%>
	<div> �����ڴ��̽ñ���. </div>
	<%}%>
    
    <!-- �ݺ��� -->
    <% 	for(int i = 0; i<�ݺ�Ƚ��; i++){		%>
   		<span> �� </span>
    <% 	}    %>

	<br>

    <!-- �ݺ��� -->
    <% 	for(int i = 0; i<�ݺ�Ƚ��; i++){
    		for(int s = 0; s<=i; s++){
    	%>
   		<span> �� </span>
    <% 	} %>
    	<br>
    <%   }%>


	<!-- �ݺ��� -->
	<% for(int j =0; j<5; j++){
    	
    	for(int k=1; k<5-j; k++){ %>
    	<span> &nbsp;  </span>
    <%   }%>
      <%for(int h=0; h<j*1+1; h++){ %>
		<span> �� </span>
    <%   }%>
    	<span><br> </span>    
	<%  }%>
    
    
    
    
    
    
</body>
</html>