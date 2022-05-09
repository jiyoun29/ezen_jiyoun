<%@page import="dao.BoardDao"%>
<%@page import="dto.board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDao"%>
<%@page import="dto.member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{text-align: center;}
</style>
</head>
<body>
<%@include file = "../header.jsp" %>
	<div class="container"> <!-- 박스권 -->
	<div class="row"> <!-- 가로배치 -->
		<div class="col-md-3"> <!-- 사이드바 -->
		<%@include file = "sidebar.jsp" %>
		</div>
		
		<div class="col-md-9"><!-- 본문 -->
			<h3>내가 쓴 게시글</h3>

				
	<table class="table"> <!-- 부트스트랩 -->
		<tr>
			<th> 번호 </th><th> 제목 </th><th> 작성자 </th><th> 조회수 </th><th> 작성일 </th>
		</tr>
		
		<!-- for문 -->
		<%	
		//게시물 호출
		ArrayList<board> boardlist = BoardDao.getBoardDao().getboardlist();
		for(board board : boardlist){
		%>
		
		<tr>
		<%
		String mid = (String)session.getAttribute("login");
		if(board.getMno() == MemberDao.getMemberDao().getmno(mid)) {%>
		
			<td> <%=board.getBno() %> </td>
			<td> <a href="../board/boardview.jsp?bno=<%=board.getBno()%>"><%=board.getBtitle() %></a> </td>
			<td> <%=board.getMid() %> </td>
			<td> <%=board.getBview() %> </td>
			<td> <%=board.getBdate() %> </td>
		</tr>
		<% } } %>
	</table>
	
		</div>	</div>	</div>
<%@include file = "../footer.jsp" %>
</body>
</html>