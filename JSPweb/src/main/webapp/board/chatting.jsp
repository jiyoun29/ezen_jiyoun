<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>
<link href="/JSPweb/css/chatting.css" rel="stylesheet">
</head>
<body>
<%@include file = "../header.jsp" %> <!-- 스크립트 많이 사용하게 될 것 -->
<div class="container m-5"> <!-- 박스권 -->

<div class="col-sm-6 offset-3 chattingbox"> <!-- 전체 채팅 관련 구역 -->

	<div class="row"> <!-- 가로배치. 하위태그 -->

		<div class="col-sm-4"> <!-- 접속자 목록 표시 구역 -->
			<h5 class="enter_title"> 접속자 목록 </h5>
			
				<div id = "enterlist"> <!-- 접속된 정보 표시 -->
					
				</div>
			
			<div class="row p-3"> <!-- 접속자 정보 box -->	
				<div class="col-sm-4"> <!-- 프로필 이미지 표시 구역 -->
					<img alt="" src="../img/프사.jpg" class="rounded-cicle"  width="100%">
				</div>
				<div class="col-sm-8"> <!-- 접속자 이름, 기능 -->
					<div class="member_name"> 이름 </div>
					<div class="btnbox">
						<span>귓속말</span>
						<span>친구추가</span>
					</div>
				</div>
			</div> <!-- 접속자 정보 box 종료 -->


					
		</div> <!-- 접속자 목록 표시 구역 종료 -->
		
		
		
		
		
		
		<div class="col-sm-8"> <!-- 채팅창 구역 -->
			<div id="contentbox" class="contentbox">	<!-- 메세지 표시 구역 -->


				
				<div class="alert">
					<span> 이름 님께서 입장 하셨습니다. </span>
				</div>


			</div> <!-- 메세지 표시 구역 -->
	
	
	<%
	
	String mid = (String)session.getAttribute("login");
	
	%>
	<input type="hidden" value="<%=mid%>" id="mid">
	
	
		<div class="row g-0"> <!-- 입력 상자 혹은 전송 버튼 -->
			<div class="col-sm-10"> <!-- 입력창 --> <!-- onkeyup:엔터키 눌럿을때 이벤트로 전송 -->
				<textarea id="incontent" rows="3" cols="" class="form-control" onkeyup="enterkey('<%=mid%>')"></textarea>
			</div>
			<div class="col-sm-2"> <!-- 전송버튼 -->
				<button class="sendbtn" class="form-control" onclick="sendbtn('<%=mid%>')">전송</button>
			</div>
		</div>
		
		<div class="btnbox">
			<span>첨부파일</span>
			<span>이모티콘</span>
		</div>
	
	
		</div>
		
		
	</div>
	
</div> <!-- 전체 채팅 관련 구역 end -->


</div>
<script type="text/javascript" src="/JSPweb/js/chatting.js"></script>
<%@include file = "../footer.jsp" %>
</body>
</html>