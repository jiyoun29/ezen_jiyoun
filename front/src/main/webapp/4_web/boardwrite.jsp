<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>boardwrite</title>
</head>
<body>
	<%@include file="Header.jsp" %>
	
	<br><br><br><br><br><br><br>
	
	<div class="container"> <!-- 본문 -->
	
		<h3 class="text-center"> 문의글 쓰기 </h3>
		<div class="titleline"></div>
		
		<form action="" method="get"> <!-- 폼 양식 [입력값을 전송가능:어디론가 보낼 수 있음 중요***] -->
			<!-- 자바 컨트롤에게 전송(action 괄호 안에) -->	<!-- 입력 받을 수 있는 글자 최대 수(size=""도 사용 가능) -->
			
			<div class="row"> <!-- 위치 변경 -->
				<div class="col-md-3">
			작성자 : <input type="text" class="form-control" placeholder="작성자" maxlength="10">
				</div>
				<div class="col-md-3">
			비밀번호 : <input type="password" class="form-control" placeholder="작성자" maxlength="5" >
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-8">
			제목 : <input type="text" class="form-control" placeholder="문의 제목을 작성해주세요." maxlength="50">
				</div>
			</div>
							<!-- col은 따로 입력 없을시 풀 사이즈 -->
			내용 : <textarea rows="15" cols="" class="form-control" ></textarea>
			
				<div class="col-md-3">
			첨부파일 : <input type="file" class="form-control" >
				</div>
			 <!-- html로 형태를 잡고 부트스트랩으로 모양 바꿈 -->
			 
			 
			<div class="com-md-4 offset-4 row">
				<div class="col-md-4">
			<input type="submit" value="등록" class="form-control" > <!-- 폼 전송버튼. 액션 안에 적은 곳으로 날아감 -->
				</div>
				<div class="col-md-4">
			<input type="reset" value="다시 쓰기" class="form-control" >
				</div>
				<div class="col-md-4">
			<a href="board.jsp"><button class="form-control"> 목록 </button></a>
				<!-- 뒤로가기 버튼을 대신함 -->
				</div>
			</div>
			
		</form>

	</div>	
	
	<br><br><br><br><br>
	
	<%@include file="Footer.jsp" %>

</body>
</html>