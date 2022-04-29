<%@page import="dto.Board"%>
<%@page import="Dao.MemberDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	
	<h3>회원제 게시판</h3>
	
	<a href="signup.jsp"><button>회원가입</button></a>
	
	<%					//형 변환
		String loginid = (String)session.getAttribute("loginid");
	
		if(loginid != null){ //로그인이 된 상태
			//섹션이 있으면 로그인 성공
	%>
	
	<div> <%=loginid %>님 안녕하세요~ </div>
	<a href="Write.jsp"><button>글쓰기</button></a>
	<a href="logout.jsp"> <button>로그아웃</button> </a>
	<a href="deletecheck.jsp"> <button>회원탈퇴</button> </a>

	<% } else { //로그인이 안 된 상태
	%>
	
	<form action="Logincontroller.jsp" method="post">
		<input type="text" name="id" placeholder="아이디">
		<input type="password" name="pw" placeholder="비밀번호">
		<input type="submit" value="로그인">
	</form>
	
	<%		}	%>
	
	<table>
		<tr>
			<th> 번호 </th>  <th> 작성일 </th> 
			<th>작성자</th> 	<th> 제목 </th>
		</tr>
		
		<!-- 반복문 -->
		
		<%
		 MemberDao dao = new MemberDao();
		 ArrayList<Board> boardList = dao.list();
		 for(int i = 0; i<boardList.size(); i++){
		%>
		 
		<tr>
			<td> <%=boardList.get(i).getBnum() %> </td>
			<td> <%=boardList.get(i).getDate() %> </td>
			<td> <%=boardList.get(i).getWriter() %> </td>
			<td><a href="View.jsp?bnum=<%=boardList.get(i).getBnum()%>">
				<%=boardList.get(i).getTitle()%></a> </td>
				<!-- href="파일명?변수명=값" get방식 -->
		</tr>
		 
		 
		<% } %>
		
	</table>
	
</body>
</html>