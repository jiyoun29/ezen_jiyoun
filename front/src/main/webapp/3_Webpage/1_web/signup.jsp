<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>


	<style type="text/css">
	
	form{ line-height: 180%; }
	
	h3{ text-align: center; }
	li{ list-style-type: none; } /*글머리 제거*/

	/*전체를 박스로 만듦*/
	#join{ width: 600px; /*박스 크기가 있어야만 정렬 가능*/ 
		margin: 0 auto; /*가운데 정렬*/
		border-top: 2px solid #cccccc; 
		border-bottom: 2px solid #cccccc;
		padding: 30px;
	}
 	
	.cols{padding: 5px;} /*열로 쓰기 위해 모든 ul에 넣어주면 한 줄이 된다.*/
	.cols li{display: inline-block;}
	.col1{width: 150px;}
	.col2 input, select{ width:200px; height: 30px;} /*싹 이름 붙여야함...*/
	
	.email input , select  { height: 30px; }
	.hello{ vertical-align: top; } /* 텍스트 세로정렬 */
	
	#button{width: 600px;
			margin: 0 auto;
			text-align: right;	}
			
	#button input{ padding: 10px 20px; 
			margin-top: 20px; }
		
	</style>
	
</head>
<body>

	<!-- 헤더 -->
	<%@include file="header.jsp" %> <!-- jsp 파일 포함 -->	
	
		
	<!-- 헤더 이미지 -->
	<%@include file="mainimg.jsp" %>
	
	
	<!-- 본문 -->
	
	<div id="contents">
	
	
	
	<h3>회원 가입 폼</h3>

	<form> <!-- 폼양식 -->

		<ul id=join>	<!-- 전체 -->
			<li> <!-- 행[tr] -->
				<ul class="cols"> 
					<li class="col1">아이디</li> <li class="col2">
					<input type="text"> </li> </ul> </li> <!-- 열[td] -->
			
			<li> <ul class="cols"> <li class="col1"> 비밀번호</li>
			<li class="col2"> <input type="text"> </li> </ul> </li>
				
				
			<li> <ul class="cols"> <li class="col1">비밀번호 확인</li>
			<li class="col2"> <input type="text"> </li> </ul> </li>
			<li> <ul class="cols"> <li class="col1">이름</li>
			<li class="col2"><input type="text"> </li> </ul> </li>
			
			<li> <ul class="cols"> <li class="col1">이메일</li>
			<li class="col2"> <input type="text"> @ <select>
			 		<option> 직접입력 </option>
			 		<option> naver.com </option>
			 		<option> hanmail.net </option>
			 		<option> gmail.com </option></select></li> </ul> </li>
			 		
			<li> <ul class="cols"> <li class="col1">이메일 수신</li>
			<li> <input type="radio" name="email" checked="checked" > 비수신
			<input type="radio" name="email">수신 </li> </ul> </li>
	
			<li> <ul class="cols"> <li class="col1">가입경로</li>
				<li><input type="checkbox" name="item1"> 친구추천
			 	  <input type="checkbox" name="item2" > 인터넷검색
			 		 <input type="checkbox" name="item3" checked="checked"> 기타 </li> </ul> </li>
			 		 
			<li> <ul class="cols"> <li class="col1 hello">인사말</li>
			<li class="col2"> <textarea rows="7" cols="50"></textarea></li> </ul> </li>
		</ul>
		
		<div id="button">
				<input type="submit" value="저장하기">
				<input type="reset" value="취소하기">
			</div>
		
		</form>
	
	
	</div>
	
	
	<!-- 푸터 -->
	<%@include file="foot.jsp" %>
	
</body>
</html>