<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="dto.Stock"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>

<style type="text/css">

	*{text-align: center; color:black;} 
	
	/*.back{background: linear-gradient(to top, #FFC9C9, white);	}*/
	a{text-decoration: none; color:black;}
</style>
<link rel="stylesheet" href="/css/main.css">

</head>
<body>

<div class="back">
	<%@include file = "header.jsp" %>
<div class="container">
	
	<!-- 캐러셀 -->										<!-- 슬라이드 지연 시간(밀리초) -->
	<div id="mainslide" class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000">
	
	<!-- 슬라이드 하단 위치 버튼 -->
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#mainslide" data-bs-slide-to="0" class="active"></button>
 			<button type="button" data-bs-target="#mainslide" data-bs-slide-to="1"></button>
			<button type="button" data-bs-target="#mainslide" data-bs-slide-to="2"></button>
			<button type="button" data-bs-target="#mainslide" data-bs-slide-to="3"></button>
			<button type="button" data-bs-target="#mainslide" data-bs-slide-to="4"></button>
		</div>
		<div class="carousel-inner" id="cs"> <!-- 이미지 목록 -->
			<div class="carousel-item active">
				<img alt="" src="img/1.jpg" width="1080px">
			</div>
			<div class="carousel-item">
				<img alt="" src="img/2.jpg" width="1080px">
			</div>
			<div class="carousel-item">
				<img alt="" src="img/3.jpg" width="1080px">
			</div>
			<div class="carousel-item">
				<img alt="" src="img/4.jpg" width="1080px">
			</div>
			<div class="carousel-item">
				<img alt="" src="img/5.jpg" width="1080px">
			</div>
		</div>
		
	<!-- 버튼 id 타겟을 가져오기 --> <!-- 왼쪽 이동 버튼 -->
		<button class="carousel-control-prev" type="button" data-bs-target="#mainslide" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
	<!-- 오른쪽 이동 버튼 -->
		<button class="carousel-control-next" type="button" data-bs-target="#mainslide" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>

	</div> <!-- 캐러셀 끝 -->
	
	
	<!-- --------------------------------------------- -->
	

	<div class="row adbox"> <!-- 광고/이벤트 -->
		<div class="col-md-6"> <!-- 광고 -->
			<img alt="" src="img/add.gif" width="550px">
		</div>
		<div class="col-md-6">
			<img alt="" src="img/add.jpg" width="550px">
		</div>
	</div>
	
	
	<!-- --------------------------------------------- -->
	

	<div class="main_box"> <!-- 베스트 -->
		<h6 class="main_title"> BEST </h6>
		<div class="row">
			<div class="col-md-3 best_box">
				<img alt="" src="img/best1.webp">
			</div>
			<div class="col-md-3 best_box">
				<img alt="" src="img/best2.jpg">
			</div>
			<div class="col-md-3 best_box">
				<img alt="" src="img/best3.webp">
			</div>
			<div class="col-md-3 best_box">
				<img alt="" src="img/best4.jpg">
			</div>
		</div>
	</div>
	
	
	<!-- --------------------------------------------- -->
	

	<div> <!-- 신상품 -->
		<h6 class="main_title"> NEW ARRIVAL </h6>

		<div class="row">
		
		<!-- 반복문 시작 -->	
		<% ArrayList<Product> list = ProductDao.getProductDao().getproductlist();
		for(Product p : list){
		%>
		
			<div class="col-md-4 best_box">
				<a href="product/productview.jsp?pno=<%=p.getPno() %>">
				<!-- 제품 이미지 클릭시 상세페이지로 이동, 제품번호 -->
					<img alt="" src="admin/productimg/<%=p.getPimg()%>">
				</a>
				<div class="p_item">
					<div class="p_title"><%=p.getPname() %></div>
					
					<% //제품별 모든 재고 가져오기
					ArrayList<Stock> stocks = ProductDao.getProductDao().getstock(p.getPno());
					//해당 제품의 사이즈 목록 만들기(어래이 리스트 받기)
					//중복 제거 = set 컬렉션
					Set<String> sizelist = new TreeSet<>(); 
						for(Stock s : stocks ){
						sizelist.add(s.getSsize()); }
					%>
					
					
					<div class="p_size">
					
					<% for(String temp : sizelist ){ //사이즈 리스트를 돌려서 뿌리기 %>
						<%=temp + "  " %>
					<%} %>
					</div>
					
					
				<div class="row py-3">
					
					<% //천단위 쉼표 -> 형식 클래스
						DecimalFormat df = new DecimalFormat("###,### 원");
					%>
					
				<% if(p.getPdiscount() == 0){ //할인이 없으면 %> 
					<div class="p_price col-md-3"><%=df.format(p.getPprice())%></div>
					 
				<% } else { //할인이 있으면 %>
					<!-- 할인 금액을 넣기 위해 변수 생성 -->
					<% Float price = p.getPprice() - (p.getPprice()*p.getPdiscount()); %>
					<div class="p_price col-md-3"><%=df.format(p.getPprice()) %></div>
					<div class="p_discount"><%=df.format(price) %></div>				
				<% } %>

					<div class="p_review col-md-3 offset-4">리뷰 : 412</div>
				</div>
				</div>
			</div>
		<% } %>
				
		</div>	
	</div>
	
	
	<!-- --------------------------------------------- -->
	

	<div> <!-- 실시간 구매 후기 -->
	</div>





<!-- --------------------------------------------------- -->
</div>		
	<%@include file = "footer.jsp" %>
</div>


</body>
</html>