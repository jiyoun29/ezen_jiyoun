<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% //자바 작성 공간
	// 폼이 전송하기전에는 요청 할수가 없다. [ null ]
			
	//1 현재 달력 가져오기
	Calendar calendar = Calendar.getInstance(); //왜 new?
	int year = calendar.get(Calendar.YEAR); //현재연도
	int month = calendar.get(Calendar.MONDAY)+1; //현재 월
	

	
	// 2. 요청변수가 있을경우 [ 요청변수가 null 아니면 ]
	if(request.getParameter("year") != null &&
		request.getParameter("month") != null ){
		// 2-2. form에서 입력받은 값 요청 
		year = Integer.parseInt(request.getParameter("year")); //입력 받은 거 가져오기
		// 2-3. form에서 입력받은 값 요청 
		month = Integer.parseInt(request.getParameter("month")); }
	
	//만약에 월이 0이하이면 연도를 1 감소 시키고 월을 12로 설정한다.
	if(month < 1){		month = 12; year--;	}
	//만약에 월이 13이상이면 연도 1증가 월을 1로 설정한다.
	if(month > 12){		month = 1; year++;	}

	//지원불가 달력이면 1900년 이하
	boolean ch = false; //출력 가능 달력이면 false;
	if(year < 1900|| year > 2300 || month < 0 || month > 12){
		ch = true; //출력 불가능 달력이면 true;
	}
	

	// 3. 입력받은 값으로 달력 설정
	calendar.set(year, month-1, 1); //month-1 : 0:1월 ~ 11:12월
	int sweek = calendar.get(Calendar.DAY_OF_WEEK); // 해당 월의 시작 요일 구하기
	int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); //해당 월의 마지막 일 구하기
	
	%>
	
	
	<!-- html 작성 공간 -->
	
	<form action="4_달력.jsp" method="get">
		<!-- action은 폼이 전송될 위치(파일명) -->
		<input type="text" name="year" placeholder="연도">
		<input type="text" name="month" placeholder="월">
		<input type="submit" value="검색">
	</form>
	
	<p> 입력한 연도 : <%=year %> </p>
	<p> 입력한 월 : <%=month %> </p>
	

	<form action="4_달력.jsp" method="get">
		<input type="text" name="year" value="<%=year %>">
		<input type="text" name="month" value="<%=month-1 %>">
		<input type="submit" value="이전">	<!-- 현재 월 -1 -->
	</form>
	
	<form action="4_달력.jsp" method="get">
		<input type="text" name="year" value="<%=year %>">
		<input type="text" name="month" value="<%=month+1 %>">
		<input type="submit" value="다음">    <!-- 현재 월 +1  -->
	</form>

	<%if(ch == true){ %>
		<div>표현할 수 없는 달력입니다.</div>
	<%}%>

	<table>
		<tr>
			<th> 일요일 </th>
			<th> 월요일 </th>
			<th> 화요일 </th>
			<th> 수요일 </th>
			<th> 목요일 </th>
			<th> 금요일 </th>
			<th> 토요일 </th>
		</tr>
		
		<tr>
		<!-- 시작 요일까지 공백으로 채움 -->
		<% for(int i = 1; i<sweek; i++){  %>
			<td></td> <!-- 해당 셀 공백 -->
		<% } %>
		
		<!-- 1일부터 마지막일까지 1씩 증가 하면서 출력 -->
		<% for(int i = 1; i<=eday; i++){ %>
			<td> <%=i %></td> <!-- 일수 출력 -->
			<!-- 7의 배수마다 줄바꿈처리(토요일마다) -->
			<%if(sweek % 7 ==0){ %>
				</tr><tr> <!-- 테이블 행 바꿈 -->
			<%} %>
			
			<% sweek++; %> <!-- 일 증가할 때마다 요일도 증가 -->
			
		<%} %>
		</tr>
	</table>
	
</body>
</html>