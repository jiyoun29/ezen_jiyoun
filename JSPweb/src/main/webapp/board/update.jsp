<%@page import="dao.BoardDao"%>
<%@page import="dto.board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style type="text/css">
	*{text-align: center;}
	button, .box{background-color: white; border: solid 1px #FFAAAA;}	
</style>

   <!-- 썸머노트 기본 부트스트랩버전 3버전 css cdn -->
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
</head>
<body>
<%@include file = "../header.jsp" %>

	<%
	int bno = Integer.parseInt(request.getParameter("bno"));
	board board = BoardDao.getBoardDao().getboard(bno);
	%>

	<br>
	<div class="container">
		<a href="boardlist.jsp"><button>글목록</button></a> <br><br>
		<h3>글 수정</h3>
		<form action="../board/update?bno=<%=board.getBno()%>" method="post" enctype="multipart/form-data">
			제목 : <input type="text" name="btitle" style="width: 600px;" value="<%=board.getBtitle()%>"> <br>
			내용 : <textarea name="bcontent" id="summernote"><%=board.getBcontent()%></textarea><br>

			<%if(board.getBfile()!=null){ %>			
			첨부파일 : <%=board.getBfile() %>
				<button type="button" onclick="filedelete(<%=board.getBno()%>)">파일 삭제</button>
			<%} %>
			<br>
			
			<input type="file" name="bfile"> <br>
<!--			첨부파일(여러개) : <input type="file" multiple="multiple">  -->

			<input type="submit" value="수정" class="box">
			<input type="reset" value="취소" class="box">  <br>
		</form>
	</div>
	
	
   <!-- 썸머노트 기본 부트스트랩 3버전 js cdn -->
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 게시판api(썸머노트) js cbn -->
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <!--  썸머노트 한글 버전 cdn -->
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
    <script src="/JSPweb/js/board.js"></script>
		
<%@include file = "../footer.jsp" %>
</body>
</html>