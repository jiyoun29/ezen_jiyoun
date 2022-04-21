<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>테이블</title>
</head>
<body>

	<!-- 끌고올때 골뱅이 잊지말기 -->
	<%@include file="1_설치.jsp" %>
	
	<table> <!-- 기본 테이블 : css 없음 -->
		<tr>
			<th>번호</th>		<th>제목</th>		<th>글쓴이</th>
		</tr>

		<tr> <td>1</td> <td>테이블 테스트중 1</td> <td>홍길동</td> 	</tr>
		<tr> <td>2</td> <td>테이블 테스트중 2</td> <td>홍길동</td> 	</tr>
		<tr> <td>3</td> <td>테이블 테스트중 3</td> <td>홍길동</td> 	</tr>
	</table>
	
	
		
	<table class="table"> <!-- 부트스트랩 테이블 -->
		<tr>
			<th>번호</th>		<th>제목</th>		<th>글쓴이</th>
		</tr>

		<tr> <td>1</td> <td>테이블 테스트중 1</td> <td>홍길동</td> 	</tr>
		<tr> <td>2</td> <td>테이블 테스트중 2</td> <td>홍길동</td> 	</tr>
		<tr> <td>3</td> <td>테이블 테스트중 3</td> <td>홍길동</td> 	</tr>
	</table>
	
	
	
	
	<table class="table table-hover"> <!-- 부트스트랩 호버 테이블(버전마다 쓰는방식 다름) -->
		<tr>
			<th>번호</th>		<th>제목</th>		<th>글쓴이</th>
		</tr>

		<tr> <td>1</td> <td>테이블 테스트중 1</td> <td>홍길동</td> 	</tr>
		<tr> <td>2</td> <td>테이블 테스트중 2</td> <td>홍길동</td> 	</tr>
		<tr> <td>3</td> <td>테이블 테스트중 3</td> <td>홍길동</td> 	</tr>
	</table>

	
	
	
	<table class="table table-hover table-bordered"> <!-- 부트스트랩 보더 테이블, 테두리 생김 -->
		<tr>
			<th>번호</th>		<th>제목</th>		<th>글쓴이</th>
		</tr>

		<tr> <td>1</td> <td class="align-bottom" style="text-align:center;">테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1테이블 테스트중 1</td> <td>홍길동</td> 	</tr>
		<tr> <td>2</td> <td>테이블 테스트중 2</td> <td>홍길동</td> 	</tr>
		<tr> <td>3</td> <td>테이블 테스트중 3</td> <td>홍길동</td> 	</tr>
	</table>
	
	
	
	
	
	
</body>
</html>