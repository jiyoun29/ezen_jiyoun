
<%@page import="dto.Board"%>
<%@page import="Dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	//링크를  href="View.jsp?bno=게시물 번호로 가져왔기 때문에 가능
	int bnum = Integer.parseInt(request.getParameter("bnum"));
		//링크에서 선택한 게시물 가져오기
	MemberDao dao = new MemberDao();
	Board board = dao.get(bnum);
	
	//만약 로그인된 정보와 작성자가 동일할 경우 삭제/수정 표시
	String loginid = (String)session.getAttribute("loginid");
	if(loginid != null && loginid.equals(board.getWriter())){
	%>
	
	<a href="board_update.jsp"> <button>수정</button> </a>
	<a href="bdeletecontroller.jsp?bnum=<%=bnum%>"> <button>삭제</button> </a>
	
	<% } %>

	<a href="Main.jsp"> <button>목록보기</button> </a>

	<div> 제목 : <%=board.getTitle() %> </div>
	<div> 작성자 : <%=board.getWriter() %> </div>
	<div> 작성일 : <%=board.getDate() %></div>
	<div> 내용 : <%=board.getContent() %></div>

</body>
</html>