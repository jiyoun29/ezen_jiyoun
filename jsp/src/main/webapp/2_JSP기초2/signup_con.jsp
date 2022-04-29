<%@page import="Dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% //컨트롤 페이지로 사용
    
    //요청 [서버가 클라이언트에게]
    		//요청 시 사용되는 한글 인코딩 변환 [설정]
    request.setCharacterEncoding("UTF-8");
    		//서블릿 -> 외국()
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
    String name = request.getParameter("name");
    
    //변수 3개를 dto로 객체화
    Member member = new Member(0, id, pw, name);
    
    //객체화(dto) -> dao(db에 영구저장)
    MemberDao dao = new MemberDao();
    
    //dao 가입메소드 실행
	boolean result = dao.signup(member);
    
    if(result){
    	response.sendRedirect("Main.jsp");
    	//response.sendRedirect("이동할 페이지"); 
    }
    
    %>
    