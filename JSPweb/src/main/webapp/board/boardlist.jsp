<%@page import="dao.MemberDao"%>
<%@page import="dao.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{text-align: center;}
	.box{background-color: white; border: solid 1px black;}	
</style>
<link rel="stylesheet" href="/css/main.css">
</head>
<body>
<%@include file = "../header.jsp" %>

	<div class="container">
	
		<%
			String mid = (String)session.getAttribute("login");
			if( mid != null ){
		%>
			<a href="boardwrite.jsp" class="box"> 글쓰기 </a>
		<%} %>
		
	<table class="table "> <!-- 부트스트랩 -->
		<tr>
			<th> 번호 </th><th> 제목 </th><th> 작성자 </th><th> 조회수 </th><th> 작성일 </th>
		</tr>
		<!-- for문 -->
		<% //모든 게시물 호출
		ArrayList<board> boardlist = BoardDao.getBoardDao().getboardlist();		
		for(board board : boardlist){%>
		
		<!-- 행을 클릭했을 때(location) -->
		<!-- <tr onclick="location.href='boardview.jsp'" style="cursor: pointer;"> -->
		<!-- 상세페이지로 이동시 상세 게시물, 게시물 번호 등의 값을 가지고 가야 한다(같이 이동)
			1. html : 파일명(경로).jsp?변수명=값 (a태그 사용)
			2. js : location.href='파일명(경로).jsp?변수명=값'"
			3. jsp : response.sendRedirect("파일명(경로).jsp?변수명=값");
		 -->
		<tr>
			<td> <%=board.getBno() %> </td>
			<!-- 행을 클릭하거나 타이틀 클릭하거나 -->
			<!-- 반드시 어떤 값ㅇ르 넘겨야함(getBno) -->
			<td> <a href="boardview.jsp?bno=<%=board.getBno()%>"><%=board.getBtitle() %></a> </td>
			<td> <%=board.getMid() %> </td>
<!-- 		<td> //=MemberDao.getMemberDao().getmid(mno)%></td> -->
			<td> <%=board.getBview() %> </td>
			<td> <%=board.getBdate() %> </td>
		</tr>
		
		<%} %>
		
		<tr>
		</tr>
	</table>
	</div>
		
<%@include file = "../footer.jsp" %>
</body>
</html>