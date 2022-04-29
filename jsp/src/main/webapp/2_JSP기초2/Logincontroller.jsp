<%@page import="Dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	
	MemberDao dao = new MemberDao();
	boolean result = dao.login(id, pw);
	if(result){
		response.sendRedirect("Main.jsp"); //클라이언트에게 페이지 응답(반환)
		session.setAttribute("loginid", id);
						//세션이름=변수명, 세션값=값
		//서블릿 내장객체 : session
		//서버 내 메모리 장착 / 모든 페이지[파일]에서 접근할 수 있는 메모리
		//브라우저마다 메모리 별도 생성
		
		System.out.print("성공");
	} else{
		response.sendRedirect("Main.jsp"); //클라이언트에게 페이지 응답(반환)		
	}
	
%>