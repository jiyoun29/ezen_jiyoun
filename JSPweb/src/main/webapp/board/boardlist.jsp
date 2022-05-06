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
	.box{background-color: white; border: solid 1px #FFAAAA;}	
</style>
</head>
<body>
<%@include file = "../header.jsp" %>

	<div class="container">
	<h3>자유게시판</h3>
	<button class="box"><a href="boardwrite.jsp">글쓰기</a></button>
	<table class="table"> <!-- 부트스트랩 -->
		<tr>
			<th> 번호 </th><th> 제목 </th><th> 작성자 </th><th> 조회수 </th><th> 작성일 </th>
		</tr>
		<!-- for문 -->
		<% //모든 게시물 호출
		ArrayList<board> boardlist = BoardDao.getBoardDao().getboardlist();		
		for(board board : boardlist){%>
		
		<tr>
			<td> <%=board.getBno() %> </td>
			<td> <a href="#"> <%=board.getBtitle() %></a> </td>
			<td> <%=board.getMid() %> </td>
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