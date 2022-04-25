<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>board jsp</title>
</head>
<body>
	
	<!--jsp 헤더 파일 끌어오기 -->
	<%@include file="Header.jsp" %>
	
	<br><br><br><br><br><br><br>
	
	<div class="container"> <!-- 부트스트랩. 박스권 생성 -->
		
		<h3>고객센터</h3>

			<!-- 그리드를 한줄로 표기하기 위해서 row 사용(inline 써도 상관x), my:위아래 바깥여백 -->
		<div class="col-md-5 offset-7 row g-0 my-4"> <!-- 그리드[박스권 세로 12조각] -->
				<!-- 5칸 사용 왼쪽 7칸 여백 -->
			<div class="col-md-3"> <!-- 목록 상자 -->
				<select class="form-select"> <!-- 박스권에 효과 생성 -->
					<option>키워드</option>
					<option>번호</option>
					<option>제목</option>
					<option>작성자</option>
				</select>
			</div>

			<div class="col-md-6">
				<input type="text" class="form-control">
			</div>
			
			<div class="col-md-3"> <!-- 검색버튼 -->
				<button class="form-control"> 검색 </button>		
			</div>	
			
		</div>

		
		<!-- 인풋박스, 버튼을 쓰면 기본 여백 때문에 컨트롤 끼리 붙지 않는다.
		따라서 붙이고 싶다면 g-0 으로 여백을 제거한다. (가장 상위 클래스에 넣기) -->
		
		
		<table class="table table-hover text-center"> <!-- 테이블 태그 -->
		
			<tr class="text-center"> <!-- 행row태그 -->
				<th> 번호 </th>
				<th> 문의상태 </th>
				<th> 제목 </th>
				<th> 작성일 </th>
				<th> 작성자 </th>
			</tr> <!-- 행 end -->
			
			<tr class="text-center">
				<td> 1 </td> <td> 접수 </td> <td> <a href="boardview.jsp"> 환불 요청 드립니다. </a> </td> <td> 2022-04-23 </td> <td> 유재석 </td>
			</tr>
			<tr class="text-center">
				<td> 2 </td> <td> 접수 </td> <td>	  <a href="boardview.jsp"> 배송 문의 </a> </td> <td> 2022-04-24 </td> <td> 송지효 </td>
			</tr>
			<tr class="text-center">
				<td> 3 </td> <td> 접수 </td> <td>  <a href="boardview.jsp"> 회원 탈퇴 </a> </td> <td> 2022-04-25 </td> <td> 이광수 </td>
			</tr>
			<tr class="text-center">
				<td> 4 </td> <td> 접수 </td> <td>  <a href="boardview.jsp"> 사이즈 문의 </a> </td> <td> 2022-04-25 </td> <td> 전소민 </td>
			</tr>
			
		</table> <!-- 테이블 end -->
	
	<!-- 페이지 처리 -->
		<div class="row">
			<div class="col-md-4 offset-4 my-3">
				<ul class="pagination"> <!-- 페이징. navbar처럼 가로 -->
					<li class="page-item"> <a class="page-link" href="#">이전</a> </li>
					<li class="page-item"> <a class="page-link" href="#">1</a> </li>
					<li class="page-item"> <a class="page-link" href="#">2</a> </li>
					<li class="page-item"> <a class="page-link" href="#">3</a> </li>
					<li class="page-item"> <a class="page-link" href="#">4</a> </li>
					<li class="page-item"> <a class="page-link" href="#">5</a> </li>
					<li class="page-item"> <a class="page-link" href="#">다음</a> </li>
				</ul>
			</div>
			<div class="col-md-2 offset-2 my-3">
				<a href="boardwrite.jsp"><button class="form-control">문의하기</button></a>
			</div>
		</div>
	
	</div> <!-- 박스 종료 -->

	<br><br><br><br><br><br><br>
	
	<%@include file="Footer.jsp" %>
	
</body>
</html>