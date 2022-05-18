<%@page import="dao.MemberDao"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="dto.Stock"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 구매</title>
<!-- 사용자 css -->
<link rel="stylesheet" href = "/JSPweb/css/productview.css">
</head>
<body>
<%@include file = "../header.jsp" %>

<% //자바 구역
	int pno = Integer.parseInt(request.getParameter("pno")); //제품번호 요청
	Product p = ProductDao.getProductDao().getproduct(pno); //제품 호출
	ArrayList<Stock> stocks = ProductDao.getProductDao().getstock(pno); //해당 재품의 재고

	Set<String> sizelist = new TreeSet<>(); // 사이즈목록 선언   = 중복제거(set컬렉션)
	for(Stock s : stocks) { sizelist.add(s.getSsize()); } //사이즈 목록 만들기

	Set<String> colorlist = new TreeSet<>(); // 사이즈목록 선언   = 중복제거(set컬렉션)
	for(Stock s : stocks) { colorlist.add(s.getScolor()); } //사이즈 목록 만들기

	DecimalFormat df = new DecimalFormat("###,### 원");
	Float price = p.getPprice() - (p.getPprice()*p.getPdiscount()); //할인 금액 계산
	Float point = price * 0.01f ; //포인 금액 계삭(1%)
%>

	<div class="container viewbox">
	<div class="row">
	
		<div class="col-md-6"> <!-- 이미지 -->
			<img alt="" src="../admin/productimg/<%=p.getPimg()%>">
		</div>
		
	<div class="col-md-6"> <!-- 상품 정보 -->
		<div class="infobox">
		<h5 id="pname" class="view_title"><%=p.getPname()%></h5>
			<div class="price_box">
			<%if(p.getPdiscount() == 0) { %>
				<span class="price_dis"><%=df.format(p.getPprice()) %></span>								
			<%} else{ %>
				<span class="price_rat"><%=Math.round( p.getPdiscount()*100 ) +"%" %></span>
				<span class="price_dis"><%=df.format(price) %></span>
				<span class="price"><%=df.format(p.getPprice()) %></span>	
			<%} %>
			</div>
			<div class="size_box">
				<span><%for(String t : sizelist){ %> <!-- 사이즈 목록 출력 -->
					<%=t+ " " %>
				<%} %> </span>
			</div>
			
			
			<!-- 숨겨놓았던 제품 번호 -->
			<input type="hidden" value="<%=pno%>" id="pno">
			<input type="hidden" value="<%=price%>" id="pprice">
			
			
			<table class="table info_t my-5">
				<tr>
					<td width="20%">DELVERY</td> <td>2,500원 (70,000원 이상 구매시 무료)</td>
				</tr>
				<tr> <td>SALE</td> <td> <%=df.format( point )%></td> </tr>
				<tr>
					<td>COLOR</td>
					<td> <select id="color_select" class="form-select info-t">
						<option value="">[필수] 옵션 선택</option>
						<%for(String c : colorlist){ %>
							<option value=<%=c %>><%=c %></option>
						<%} %>
					</select> </td>
				</tr>
				<tr>
					<td>SIZE</td>
					<td> <select id="size_select" class="form-select info-t">
						<option value="">-[필수]-옵션 선택-</option>
						<%for(String s : sizelist){ %>
							<option value=<%=s %>><%=s %></option>
						<%} %>						</select> </td>
				</tr>
			</table>
		
			<table id="select_table" class="table my-5"> 
			
			</table>
<!-- ------- -->
			
			<div class="row my-5">
				<div class="col-md-6">총 상품 금액</div>
				<div id="total_price" class="col-md-6 tatal_price"><%=price %>원</div>
				<!-- 총 상품금액이 표시되는 구역에 id값 추가 -->
			</div>
			<%
			String mid = (String)session.getAttribute("login");
			int mno = MemberDao.getMemberDao().getmno(mid);
			%>
			<div id="btnbox" class="btnbox">
				<button id="btn1">바로 구매하기</button>
				<button onclick="savecart('<%=mno %>')" id="btn2">장바구니 담기</button>
				<%
				//만일 로그인이 있고 관심등록이 되어있으면
				if(mid != null && ProductDao.getProductDao().getplike(pno, mno)){ //되어 있을 경우 	%>
				<!-- 작은따옴표를 넣어 문자로 넘김 -->
				<button onclick="saveplike('<%=mid %>');" id="btn3">♥</button>
				<%} else {  //안 되어 있을 경우 %>
				<!-- 작은따옴표를 넣어 문자로 넘김 -->
				<button onclick="saveplike('<%=mid %>');" id="btn3">♡</button>
				<%} %>
			</div>
		</div>
	</div>
		
	</div>
	</div>
<%@include file = "../footer.jsp" %>

<script src="/JSPweb/js/productview.js" type="text/javascript"></script>
</body>
</html>