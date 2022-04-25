<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>boardview</title>
</head>
<body>
	<%@include file="Header.jsp" %>
	<br><br><br><br><br><br><br>
	
	
	<div class="container">
		<h3 class="text-center titleline"> 문의 글 </h3>
		
		<!-- 버튼 -->
		<div class="my-3"> <!-- 작성자 기준 -->
			<a href="board.jsp"><button class="btn btn-outline-info">목록</button></a>
			<a href="board.jsp"><button class="btn btn-outline-info">삭제</button></a> <!-- 작성자만 가능[유효성 검사] -->
			<a href="board.jsp"><button class="btn btn-outline-info">수정</button></a><!-- 작성자만 가능[유효성 검사] -->
			<a href="board.jsp"><button class="btn btn-outline-info">답변</button></a>  <!-- 관리자만 가능[유효성 검사] -->
		</div>

		<!-- 작성자가 입력한 내용 -->
		<div> <!-- 박스권:display:block/ span 박스권 : display:inline -->
		 <!-- 한줄로 갈 경우 span -->
			<div><span> 작성자 </span> <span> 유재석 </span></div>
			<div><span> 문의날짜 </span> <span> 2022-0425 </span></div>
		</div>
		<div>
			<input type="text" value="환불해주세요" class="form-control" readonly>
		</div>
		<div> <!-- db에서 꺼내오거나 textarea로 꺼내오기 -->
			<textarea rows="10" cols="" class="form-control" readonly style="resize:none;"> 환불 부탁드립니다.</textarea>
		</div>												<!-- 수정불가disabled="disabled" -->
		<br>
		

		<div class="row"> <!-- 첨부된 사진들 -->
		<h3>첨부 사진</h3>
			<div class="col-md-3">
				<img alt="" src="img/img (3).jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="img/img (3).jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="img/img (3).jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="img/img (3).jpg" width="100%">
			</div>
		</div>
		
		
		<br>
		<!-- 관리자 답변 -->
		<h4>답변</h4>
		<p>답변날짜 : 2022-04-23 12:10</p>
		<div>												<!-- 읽기모드 / 크기고정 -->
			<textarea rows="5" cols="" class="form-control" readonly style="resize:none;"> 노력하겠습니다. </textarea>
		</div>
		
	</div>
	
	<br><br><br><br><br>
	<%@include file="Footer.jsp" %>
</body>
</html>