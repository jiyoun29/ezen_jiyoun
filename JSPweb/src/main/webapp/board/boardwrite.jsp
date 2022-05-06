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

	<br>
	<div class="container">
		<a href="boardlist.jsp"><button>글목록</button></a> <br><br>
		<h3>글 쓰기</h3>
		<form action="../board/write" method="post" enctype="multipart/form-data"> <!-- 위치??? -->
		<!-- form 전송 인코딩 타입 : 기본타입은 첨부파일 불가능 -->
		<!-- form 첨부파일 전송 인코딩 타입 : enctype="multipart/form-data" -->
		
			제목 : <input type="text" name="btitle" style="width: 600px;"> <br>
			내용 : <textarea name="bcontent"  id="summernote"></textarea><br>
			첨부파일 : <input type="file" name="bfile"> <br>
			<input type="submit" value="등록" class="box"> <input type="reset" value="취소" class="box">  <br>
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