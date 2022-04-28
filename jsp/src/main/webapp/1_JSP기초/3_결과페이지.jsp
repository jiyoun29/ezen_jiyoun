<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	
	
    <!-- 리퀘스트와 리스폰 
    전 페이지로부터 request(요청)
    	request : 서블릿 클래스가 제공해주는 내장객체(미리 만들어진 객체)
    	request.getParameter("요청할 변수의 name값")
    		단점 : (String)문자만 가능
    		형변환 : 문자 -> 정수열 : integer.paseInt
     -->
    
    <% //스크립트문 = 자바 언어를 작성하고 실행하는 공간(메소드정의x)
    	String 이름 = request.getParameter("name");
    	String 색상 = request.getParameter("color");
    	
    //제어문
    boolean admin = true;
    if(!이름.equals("관리자")){admin=false;}
    int 반복횟수 = Integer.parseInt(request.getParameter("number"));
    int 행 = Integer.parseInt(request.getParameter("hang"));
    %>
    
<html>
<body style="background-color: <%=색상%> ">
    
    작성한 이름 : <%=이름 %><br>
    선택한 색상 : <%=색상 %><br>

	<% if(admin == true){%>
	<div> 관리자님이시군요. </div>
	<%}%>
    
    <!-- 반복문 -->
    <% 	for(int i = 0; i<반복횟수; i++){		%>
   		<span> ★ </span>
    <% 	}    %>

	<br>

    <!-- 반복문 -->
    <% 	for(int i = 0; i<반복횟수; i++){
    		for(int s = 0; s<=i; s++){
    	%>
   		<span> ☆ </span>
    <% 	} %>
    	<br>
    <%   }%>


	<!-- 반복문 -->
	<% for(int j =0; j<5; j++){
    	
    	for(int k=1; k<5-j; k++){ %>
    	<span> &nbsp;  </span>
    <%   }%>
      <%for(int h=0; h<j*1+1; h++){ %>
		<span> ★ </span>
    <%   }%>
    	<span><br> </span>    
	<%  }%>
    
    
    
    
    
    
</body>
</html>