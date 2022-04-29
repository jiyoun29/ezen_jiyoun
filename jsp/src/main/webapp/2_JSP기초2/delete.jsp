<%@page import="Dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");	

	//dao의 삭제 메소드 호출
	MemberDao dao = new MemberDao();
	boolean result = dao.delete(id, pw);

	//성공시
	if(result){ response.sendRedirect("Main.jsp");}

%>