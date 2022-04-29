<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	// session.invalidate(); //모든 세션 초기화
    	//특정 세션 제거
    	session.setAttribute("loginid", null);
    					//null = 메모리 자동 해체 기능
		//페이지전환
		response.sendRedirect("Main.jsp");
    %>