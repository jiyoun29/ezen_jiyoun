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

		
		<div class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
	 			<button type="button" data-bs-target="#cs" data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#cs" data-bs-slide-to="2"></button>
			</div>
			
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img alt="" src="img/1.jpg" width="1080px">
				</div>
				<div class="carousel-item">
					<img alt="" src="img/2.jpg" width="1080px">
				</div>
				<div class="carousel-item">
					<img alt="" src="img/3.jpg" width="1080px">
				</div>
			</div>
		
		</div>
	
	</div>
	<%@include file = "footer.jsp" %>
</div>


</body>
</html>