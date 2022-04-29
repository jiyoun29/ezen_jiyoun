<%@page import="Dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//1. 전페이지로부터 게시물번호 요청
			//형변환
	int bnum = Integer.parseInt(request.getParameter("bnum"));

	//2. dao 게시물 삭제 메소드 호출
	MemberDao dao = new MemberDao();
	boolean result = dao.bdelete(bnum);

	//3. 삭제가 성공했으면
	if(result){
		response.sendRedirect("Main.jsp");
	}
%>