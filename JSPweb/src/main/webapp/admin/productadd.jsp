<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>제품 등록 페이지</h3>
	<!-- 폼에서 첨부파일 전송시에는 enctype="multipart/form-data" -->
	<form id="addform">
<!-- 	<form action="productadd" method="post" enctype="multipart/form-data"> -->
					<!-- 멀티파트 쓸거니까 post로 사용 -->

		제품명 <input type="text" id="pname" name="pname" placeholder="제품명"><br>
		가격 <input type="text" id="pprice" name="pprice" placeholder="가격"><br>
		할인율 <input type="text" id="pdiscount" name="pdiscount" placeholder="할인율"><br>
		카테고리 <button onclick="categorybtn()" type="button">카테고리 추가</button> <br>
		
		<div id="categoryinput"> </div> <!-- 버튼 클릭시 카테고리 입력창 표시되는 구역 -->
		<div id="categorybox"> </div> <!-- db에 저장된 카테고리만큼 radio 버튼으로 표시[db->java(서블릿)->js->html] -->
		
		대표 이미지 <input type="file" id="pimg" name="pimg"><br>
		<button type="button" onclick="productadd()"> 등록 </button> <!-- js에서 form 비동기 통신 -->
		<input type="reset" value="초기화">
	</form>
	
	<!-- 사용자 정의 js 호출 -->
	<script src="/JSPweb/js/productadd.js" type="text/javascript"></script>
</body>
</html>