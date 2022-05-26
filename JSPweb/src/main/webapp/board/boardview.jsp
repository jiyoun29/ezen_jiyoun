<%@page import="dto.Reply"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDao"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{text-align: center; }
	button{background-color: white; border: solid 1px black;}	
</style>
<link rel="stylesheet" href="/css/main.css">
</head>
<body>
<%@include file = "../header.jsp" %>

	
	<!-- 게시물 번호 끌고 오기(자바 열어서 요청) -->
	<div class="container">
		
	<%
		int bno = Integer.parseInt(request.getParameter("bno"));
		String mid = (String)session.getAttribute("login"); //세션
		
		//조회수 기록 세션이 존재하지 않으면
		if(session.getAttribute(mid+bno) == null){
			//조회수 증가처리
			BoardDao.getBoardDao().increview(bno);
			
			//조회수 중복방지[세션] / 생명주기
			session.setAttribute( mid+bno , true);//세션명 : 아이디 + 게시물번호 / 세션의값: true
			session.setMaxInactiveInterval(60 * 60 * 24); //60초(1분) 60분(1시간) 24시간
		} //존재하면 아래로 내려감
		
		//게시물번호로 게시물 dto 가져오기
		board board = BoardDao.getBoardDao().getboard(bno);
			
	%>
			
	<table class="boardview_title col-md-10 offset-1">
		<tr>
		<td>번호</td> <td><%=board.getBno()%></td>
		<td>작성자</td><td><%=board.getMid()%></td>
		<td>작성일</td> <td><%=board.getBdate()%></td>
		</tr>
		
		<tr> <td>제목</td> <td><%=board.getBtitle()%></td> </tr>
		
		<tr> <td colspan="4"><div class="boardview_content"> <%=board.getBcontent()%> </div></td> </tr>

	<% if(board.getBfile()==null){
	%> <!-- 첨부파일 없을때 -->
		<tr> <td colspan="4">첨부파일</td> <td> - </td> </tr>
		
	<%} else { %>	
	
		<tr> <td colspan="4">첨부파일</td> <td><a href="filedown?bfile=<%=board.getBfile()%>">
		<%=board.getBfile()%></a></td> </tr> <!-- 첨부파일 다운로드 -->
		
	<%} %>
	</table>
	
	<!-- ------------------------ 게시물 삭제/수정.목록 버튼 구역 -->
	
	<div class="row">
	<%
		//회원번호 빼오기
		if(board.getMno() == MemberDao.getMemberDao().getmno(mid)) {
	%>
	<!-- boarddao에 쓴 메소드를 불러온다. -->
		<!-- 삭제받을 bno을 받아온다. -->
	<a href="deleteboard?bno=<%=board.getBno()%>"><button>삭제</button></a>
	<a href="update.jsp?bno=<%=board.getBno()%>"><button>수정</button></a>
	
	<%} %>

			<a href="boardlist.jsp"><button>목록</button></a>		
	
	</div>
	
	
	<!-- ------------------------ 댓글 쓰기 구역 -->
	
	<hr/>
	<h4 class="boardview_title">댓글</h4>
	
	<% if(mid != null){ %>
	<div class="row"> <!-- row 가로배치 -->
		<div class="col-md-8">
			<textarea id="rcontent" class="form-control"></textarea>
		</div>
		<div class="col-md-2">	
			<button class="form-control py-3 my-1" onclick="replywrite(<%=bno%>)">등록</button>
		</div>
	</div>
	
	<%} else { %>
		<h5 class="text-center"> 로그인 후 댓글 작성이 가능합니다. </h5>
	<%} %>
	
	
	<!-- ------------------ 댓글 출력 구역 -->
	
	<table id="replytable" class="table"> <!-- 댓글작성 성공시 해당 태그는 새로고침 -->
		<% ArrayList<Reply> replylist = BoardDao.getBoardDao().replylist(bno);
			for(Reply reply : replylist){ %>
		<tr>
			<td class="replywriter" width="15%"><%=reply.getMid() %><br>
			<span class="replydate"><%=reply.getRdate() %></span></td>
			
			<td width="80%"  colspan="2">
				<%=reply.getRcontent() %> <br>
				
		<% if( mid !=null && mid.equals( reply.getMid() ) ){ // 본인 작성한 댓글이면 %>
			<button class="btn replybtn" onclick="reupdateview(<%=reply.getRno()%>)"> 수정 </button>
			<button class="btn replybtn" onclick="replydelete(<%=reply.getRno()%>)"> 삭제 </button>
		<%} %>

				<button class="btn replybtn"
				onclick="rereplyview(<%=reply.getRno()%>,<%=reply.getBno()%>,'<%=mid%>')">
				답글</button>
			</td>
			
		</tr>
		
	<!-- -------------------------- 대댓글 ------------------------------ -->
		
		<tr> <!-- 대댓글 입력 창 -->
			<td></td>
			<td colspan="2" id=<%=reply.getRno()%>></td>
			<!-- 해당 태그의 id값을 변수로 설정 = 댓글 번호(댓글 한개당 1개씩) -->
		</tr>
		
		
		<!-- 대댓글 출력 창 -->
		<%ArrayList<Reply> rereplylist = BoardDao.getBoardDao().rereplylist(bno,reply.getRno());
			for(Reply rereply : rereplylist){ %>
				<tr>
					<td></td>
					<td width="10%" class="replywriter">
						<%=rereply.getMid() %> <br> 
						<span class="replydate"> <%=rereply.getRdate() %> </span>
					</td>
					
					<td width="80%">
						<%=rereply.getRcontent() %> <br> 
					<% if( mid != null && mid.equals( rereply.getMid() ) ){ %>
						<button class="btn replybtn"
							onclick="reupdateview(<%=rereply.getRno()%>)"> 수정 </button>
							
						<button class="btn replybtn"
							onclick="replydelete(<%=rereply.getRno()%>)"> 삭제 </button>
					<%} %>
					</td>
				</tr>
		<%} }%>
	</table>
	
	
</div>
	
	
<script src="/JSPweb/js/board.js" type="text/javascript"></script>	
<%@include file = "../footer.jsp" %>
</body>
</html>