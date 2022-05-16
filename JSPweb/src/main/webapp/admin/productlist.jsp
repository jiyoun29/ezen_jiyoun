<%@page import="dto.Stock"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 목록 페이지</title>
</head>
<body>

	<h3>제품 목록 페이지</h3>
	<table id="producttable" class="table table-hover">
		<tr>
			<th width="5%">제품번호</th> <th width="5%">대표이미지</th>
			<th width="5%">제품명</th> <th width="5%">가격</th>
			<th width="5%">할인율</th> <th width="5%">판매금액</th>
			<th width="5%">제품상태</th> <th width="5%">카테고리</th>
			<th width="5%">색상</th> <th width="5%">사이즈</th>
			<th width="5%">재고수량</th> <th width="5%">수정일</th>
			<th width="5%">비고</th>
		</tr>		
		
		<%
		ArrayList<Product> products = ProductDao.getProductDao().getproductlist();
		for(Product p : products){ //모든 제품 반복문
		%>
		
		<tr>
			<th><%=p.getPno() %></th>
				<th><img width="100%" src="/JSPweb/admin/productimg/<%=p.getPimg()%>"></th>
			<th><%=p.getPname() %></th> <th><%=p.getPprice() %></th>
			<th><%=p.getPdiscount() %></th> <th><%=p.getPprice()*p.getPdiscount() %></th>
			<th><%=p.getPactive() %></th> <th><%=p.getCano() %></th>
			
			
			<th> <!-- 색상 선택 [id값을 제품별 select 식별id='문자'+pk값] -->
				<!-- select 변경 되면 이벤트 -->
				<!-- 서로 다른 셀렉트 값 식별 가능 -->			<!-- pno를 인수로 넘김 -->
				<select id = "colorbox<%=p.getPno()%>" onchange="getamount(<%=p.getPno()%>)">
				<% ArrayList<Stock> stocks = ProductDao.getProductDao().getstock(p.getPno());
				for(Stock s : stocks){ %>
				
				<option><%=s.getScolor() %></option>
				
				<%} %>
				</select>
			</th>
			

			<th> <!-- 사이즈 박스 -->
				<select id = "sizebox<%=p.getPno()%>" onchange="getamount( <%=p.getPno()%> )">
							 <!-- 사이즈 선택 -->
				<% for(Stock s : stocks) { %>
					<option><%=s.getSsize() %> </option>
				<%} %>
				</select>
			</th>			
			
			
			<!-- 색상과 사이즈에 따른 재고 표시 -->
			<th> 
			<%if(!stocks.isEmpty()){// 재고리스트가 비어 있지 않으면 %>
				<%if(stocks.get(0).getSamount() == 0){ // 재고리스트의 첫번쨰 재고정보가 0이면 %>
					<span id='amountbox<%=p.getPno()%>'>재고 없음</span>
				<%}else{ %>
					<span id='amountbox<%=p.getPno()%>'><%=stocks.get(0).getSamount() %></span>
			<% }%>
				<%}else{ // 재고리스트가 비어 있으면 %>
					<span id='amountbox<%=p.getPno()%>'> 재고없음 </span> 
				<%} %>
			</th> 	
			
			<!-- 색상과 사이즈에 따른 수정일 표시 -->
			<th>
				<% if( !stocks.isEmpty() ){ // 재고리스트가 비어 있지 않으면 %>
						<% if(stocks.get(0).getSamount() == 0 ){ // 재고리스트의 첫번쨰 재고정보가 0이면 %>
							<span id="datebox<%=p.getPno()%>"> - </span> 
						<% }else{ %>
							<span id="datebox<%=p.getPno()%>"> <%=stocks.get(0).getUpdatedate() %> </span> 
					<% }%>
					<%}else{ // 재고리스트가 비어 있으면 %>
							<span id="datebox<%=p.getPno()%>"> - </span> 
					<%} %>
					
			</th>
			
		<th>
			<div class="row">
		
			<button onclick="#" class="btn">제품 삭제</button>
			<button onclick="#" class="btn">제품 수정</button>
			<button onclick="pnomove(<%=p.getPno() %>)" data-bs-toggle="modal" data-bs-target="#activemodal">상태 변경</button> 
			<button onclick="getstock(<%=p.getPno() %>)" data-bs-toggle="modal" data-bs-target="#stockmodal" >재고 변경</button>
			 		<!-- 내가 클릭한 pno을 넘김  -->
			 </div>
		</th>
		</tr>		
		
		<%} %>
		
	</table>

	<!-- ----------------------------------------------------------------- -->
	
	<!-- 상태 변경 모달 구역 -->
<div class="modal" tabindex="-1" id="activemodal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">제품 상태 변경</h5> <!-- 모달 제목 -->
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>변경할 상태를 선택해주세요.</p> <!-- 모달. 데이터 삽입 자유. -->
        <input type="hidden" id="modalinput">
      </div>
      <div class="modal-footer"> <!-- 모달 버튼 -->
      	<button type="button" class="btn btn-primary" onclick="activechange(0)">준비</button>
        <button type="button" class="btn btn-primary" onclick="activechange(1)">판매</button>
        <button type="button" class="btn btn-primary" onclick="activechange(2)">품절</button>
        <button type="button" class="btn btn-primary" onclick="activechange(3)">중단</button>
        <button id="madalclosebtn" type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>
	
	
	<!-- ----------------------------------------------------------------- -->
	
	
	<!-- 제품 수정 모달 구역 -->
<div class="modal" tabindex="-1" id="stockmodal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">제품 재고 변경</h5> <!-- 모달 제목 -->
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      
      <div class="modal-body">  <!-- 모달. 데이터 삽입 자유. -->
      
        <table id = "stocklistbox">
        
        </table>
        
        <div id="updatebox" style="display: none;">
        	재고번호 : <input type="hidden" id="sno">
        	재고수량 : <input type="text" id="samount">
		</div>
		
      </div>
      
      <div class="modal-footer"> <!-- 모달 버튼 -->
        <button type="button" class="btn btn-primary" onclick="stockupdate()">수정 처리</button>
        <button id="madalclosebtn2" type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>
	
	
	
	<script src="/JSPweb/js/productlist.js" type="text/javascript"></script>
</body>
</html>