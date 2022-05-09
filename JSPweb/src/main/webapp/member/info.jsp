<%@page import="dto.member"%>
<%@page import="dao.MemberDao"%>
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
			
			
			<div class="col-md-9"> <!-- 본문 -->
				<h3>회원정보</h3>
				
				<%
				//1. 세션 호출 [회원 id 저장](형변환 필요)
				String mid = (String)session.getAttribute("login");
				System.out.println( mid );
				
				//2. db 메소드 호출(호출하고 담기)
				member member = MemberDao.getMemberDao().getMember(mid);
				
				//3. HTML에 객체 표현식
				%>
				
				회원번호 : <%=member.getMno()%> <br>
				아이디 : <%=member.getMid()%> <br>
				비밀번호 : <%=member.getMpassword()%> <br>
				연락처 : <%=member.getMphone()%> <br>
				이메일 : <%=member.getMemail()%> <br>
				배송주소 : <%=member.getMaddress()%> <br>
				포인트 : <%=member.getMpoint()%> <br>
				가입날짜 : <%=member.getMdate()%> <br>
				
				
			</div>
		</div>
	</div>
	<%@include file = "../footer.jsp" %>

</body>
</html>