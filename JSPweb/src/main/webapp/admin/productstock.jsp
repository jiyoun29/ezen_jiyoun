<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product stock</title>
</head>
<body>

	<h3>제품 재고</h3>
	
	카테고리 목록
	<select id="categorybox"> <!-- 현재 카테고리가 출력되는 부분 -->
		<!-- 고정값이 아닌 db에 있는 product를 끌어온다 -->
		<option value="카테고리 번호"> 카테고리 이름 </option> <!-- value는 pk값 -->
	</select>
	
	제품목록
	<select id="productbox"> <!-- 제품명이 출력되는 부분 -->
<!-- 		<option value="제품 번호"> 제품목록 </option> <!-- value는 pk값 --  -->
	</select>
		
	<form id="stockaddform" style="display: none;">
		색상 <input type="text" id="scolor">
		사이즈 <input type="text" id="ssize">
		수량 <input type="text" id="samount">	
		<button type="button" onclick="stockadd()">재고추가</button>
	</form>
	
	재고 목록
	<table id="stocklistbox">
	
	</table>
	
<script src="/JSPweb/js/productstock.js" type="text/javascript"></script>
</body>
</html>