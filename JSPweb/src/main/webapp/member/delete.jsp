<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{color:#FFAAAA; text-align: center;}
	button{background-color: white; border: solid 1px #FFAAAA;}
</style>
</head>
<body>


	<%@include file = "../header.jsp" %>
<% //섹션값을 가져옴
	String mid = (String)session.getAttribute("login");
%>


	<div class="container"> <!-- 박스권 -->
		<div class="row"> <!-- 가로배치 -->
			<div class="col-md-3"> <!-- 사이드바 -->
				<%@include file = "sidebar.jsp" %>
			</div>
			
			
			<div class="col-md-9"> <!-- 본문 -->
				<h3>회원탈퇴 확인</h3>
					<!-- 패스워드 일치에 따라 삭제 여부 -->
						<input type="password" name="mpassword" id="mpassword" placeholder="비밀번호를 입력해주세요.">
						<button id="btncofirm" onclick="passwordcheck('<%=mid%>')">확인</button>

						<span id="checkmsg"></span>
						<!-- 숨겨놓았다가 패스워드가 동일하면 열어주기 -->
						<button id="btndelete" style="display:none;" onclick="mdelete('<%=mid%>')">탈퇴</button>
					
			</div>
		</div>
	</div>
	<!-- 사용자 정의 js 파일 포함시키기 -->
	<script src="../js/info.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>

</body>
</html>