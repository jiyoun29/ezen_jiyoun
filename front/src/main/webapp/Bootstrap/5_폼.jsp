<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>폼</title>
</head>
<body>

	<!-- 끌고올때 골뱅이 잊지말기 -->
	<%@include file="1_설치.jsp" %>
	
	<form> <!-- html만 사용한 폼 -->
		<label> 이름 </label>
		<input type="text" placeholder="이름">
		<label> 이메일 </label>	
		<input type="text" placeholder="이메일">
		<button type="submit"> 확인 </button>
	</form>

	<p>-------------------</p>

	<form> <!-- 부스트스랩 -->
		<div class="form-group"> <!-- 컨트롤 묶음 : from-group -->
			<label> 이름 </label>
			
					<!-- 폼 예브게 만드러짐 -->
			<input class="form-control" type="text" placeholder="이름">
		</div>
		
		<div class="form-group">
			<label> 이메일 </label>	
			<input class="form-control" type="text" placeholder="이메일">
		</div>
		
		<div class="form-group"><button type="submit"> 확인 </button> </div>
	</form>
	
	<!-- form-control : 형식 꾸미기 -->
	<input type="text" class="form-control">
	<input type="password" class="form-control">
	<input type="datetime-local" class="form-control">
	<textarea rows="5" cols="5" class="form-control"></textarea>
	
	
	<!-- 체크박스 -->
	<div class="form-check">
		<input type="checkbox" class="form-check-input">
	</div>
	
	<!-- 라디오 -->
	<div class="form-check">
		<input type="radio"  class="form-check-input">
	</div>
	
	
	<div class="container row"> <!-- 복수로 사용할때에는 클래스명1 클래스명2로 띄어ㅏ서 쓰기 -->
		<div class="col-md-2"> <input type="text" class="form-control"> </div>
		<div class="col-md-2 offset-3"> <input type="text" class="form-control"> </div>
		<div class="col-md-2 offset-3"> <input type="text" class="form-control"> </div>
	</div>
	
	
	
	<!-- 기본제공 색깔은 쪼금밖에 없슴,, css로 적용하면 더많이 사용 가능 -->
	<!-- 회사에서는 별로 안 좋아함,, -->
	<button type="button" class="btn btn-primary"> 버튼 </button> <!-- 파랑 -->
	<button type="button" class="btn btn-secondary"> 버튼 </button> <!-- 회색 -->
	<button type="button" class="btn btn-info"> 버튼 </button> <!-- 하늘색 -->
	<button type="button" class="btn btn-success"> 버튼 </button> <!-- 녹색 -->
	<button type="button"> 버튼 </button>
	
	
	<!-- 이미지 -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<img alt="" src="../cat2.jpg" width="100%"> <!-- 사진크기 변경 -->
			</div>

			<div class="col-md-3">
				<img alt="" src="../cat2.jpg" width="100%" style="border-radius: 50px">
			</div>

			<div class="col-md-3">
				<img alt="" src="../cat2.jpg"  width="100%">
			</div>
		</div>
	</div>
	
	
	
</body>
</html>