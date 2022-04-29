<%@page import="java.util.Date"%>
<%@page import="dto.Board"%>
<%@page import="Dao.MemberDao"%>
<%@page import="javax.xml.crypto.Data"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); //요청시 데이터 인코딩 타입 설정
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String writer = (String)session.getAttribute("loginid");
		//작성자는 로그인 성공시 세션에서 가져오기
		//세션 호출 시 기본자료형이 object -> 형변환 (1.자동형변환 2.강제형변환)

	Date now = new Date(); //현재 시스템 날짜/시간
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd"); //날짜 포맷
	String date = sf.format(now); //편재 날짜/시간 포맷
	
	//변수->객체화
	Board board = new Board(0, title, content, writer, date);
	
	//dao
	MemberDao dao = new MemberDao();
	
	//메소드 실행
	boolean result = dao.writer(board);
	if(result){
		response.sendRedirect("Main.jsp");
	}
	
%>