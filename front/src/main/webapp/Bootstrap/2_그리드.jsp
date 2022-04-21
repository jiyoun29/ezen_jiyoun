<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>그리드</title>
	
	<style type="text/css">
	
	*{border: solid 1px red;}
	
	</style>
	
</head>
<body>

	<%@include file="1_설치.jsp" %>
	<!-- 1에 설치해둔 부트스트랩 끌고옴 -->

	<!-- 박스권 : container, 그리드 : 12조각으로 쪼갠 작은 상자, 세로 배치 -->
	<!-- 픽셀이 아니라 조각으로 계산해서 만들기(더 편함)... 부트스트랩 문서 읽어보기 -->
	
	<div class="container"> <!-- 박스권 형성(기본값 1200px 기준) -->
		가나다라마바사

	<!-- row : 인라인, 가로배치 -->
		<div class="row">
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>

			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
		</div>
		
		<div class="row"> <!-- 가로배치 -->
			<div class="col-md-8"> .col-md-8 </div>		
			<div class="col-md-4"> .col-md-4 </div>		
		</div>
		
		
		<!-- 반응형 -->
		<div class="row"> <!-- 가로배치 -->
			<div class="col-md-4"> .col-md-4 </div>		
			<div class="col-md-4"> .col-md-4 </div>		
			<div class="col-md-4"> .col-md-4 </div>		
		</div>
		

		<div class="row"> <!-- 가로배치 -->
			<div class="col-md-6"> .col-md-6 </div>		
			<div class="col-md-6"> .col-md-6 </div>		
		</div>
		
	</div>
	
	
	
	

	<div class="container">
		<div class="row">
			<div class="col-md-8"> <!-- 8 -->
				<div class="col-md-4">	외부 8 그리드 내 4그리드 사용	</div>
				<div class="col-md-8">	외부 4그리드 내 8그리드 사용	</div>
			</div>
		
		
			<div class="col-md-4"> <!-- 4 -->
				<div class="row">
					<div class="col-md-6"> 외부 4 그리드 내 6그리드 사용 </div>
					<div class="col-md-6"> 외부 4 그리드 내 6그리드 사용 </div>
				<div>
			</div>

			</div>
		</div>
	</div>
	</div>
	
	
	<!-- 건너뛰기, 오프셋 그리드, 다음칸 생략 -->
	<div class="container">
		<div class="row"> <!-- 남은 2칸을 나누기 위해 offset 사용 -->
			<div class="col-md-5"> col-md-5 </div>		
			<div class="col-md-5 offset-md-2"> col-md-5 </div>		
		</div>
		
		<div class="row"> <!-- 오른쪽으로 이동시키는 오프셋 -->
			<div class="col-md-4"> col-md-4 </div>
			<div class="col-md-7 offset-md-1"> col-md-7 </div>		
		</div>
	</div>
	
	
	<div class="container">
		<div class="row"> <!-- 12그리드가 넘어가면 한줄 배치가 안 됨 -->
			<div class="col-md-5"> col-md-5 </div>
			<div class="col-md-8"> col-md-8 </div>
		</div>
	</div>
	
	
	
	

</body>
</html>