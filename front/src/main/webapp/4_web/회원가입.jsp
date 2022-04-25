<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<%@include file="Header.jsp" %>
	
	<br><br><br><br><br><br><br>
	
<div class="container row" style="float: none; margin: 0 auto;">
		<div class="col-md-6">
			<h6><p>회원가입 및 정상적인 서비스 이용을 위해 아래 약관을 읽어보시고,
			동의 여부를 결정해주세요.</p></h6>
			<p>필수 약관을 동의 하셔야 회원가입이 가능합니다.</p>
		
		<div class="line" style="border-bottom: solid 1px gray; width: 100%"></div><br>
		
	<h3>회원 가입 약관 동의<span style="color:orange">*</span></h3>
		<textarea rows="7" cols="50" readonly class="form-control" resize: none; style="background-color:#ffffff">
	제 1장 총칙
	제 1 조(목적)
	본 약관은 국가공간정보포털 웹사이트(이하 "국가공간정보포털")가 제공하는 모든 서비스(이하 "서비스")의 이용조건 및 절차, 회원과 국가공간정보포털의 권리, 의무, 책임사항과 기타 필요한 사항을 규정함을 목적으로 합니다.
	
	제 2 조(약관의 효력과 변경)
	1. 국가공간정보포털은 이용자가 본 약관 내용에 동의하는 경우, 국가공간정보포털의 서비스 제공 행위 및 회원의 서비스 사용 행위에 본 약관이 우선적으로 적용됩니다.
	2. 국가공간정보포털은 약관을 개정할 경우, 적용일자 및 개정사유를 명시하여 현행약관과 함께 국가공간정보포털의 초기화면에 그 적용일 7일 이전부터 적용 전일까지 공지합니다. 단, 회원에 불리하게 약관내용을 변경하는 경우에는 최소한 30일 이상의 사전 유예기간을 두고 공지합니다. 이 경우 국가공간정보포털은 개정 전 내용과 개정 후 내용을 명확하게 비교하여 회원이 알기 쉽도록 표시합니다.
	3. 변경된 약관은 국가공간정보포털 홈페이지에 공지하거나 e-mail을 통해 회원에게 공지하며, 약관의 부칙에 명시된 날부터 그 효력이 발생됩니다. 회원이 변경된 약관에 동의하지 않는 경우, 회원은 본인의 회원등록을 취소(회원탈퇴)할 수 있으며, 변경된 약관의 효력 발생일로부터 7일 이내에 거부의사를 표시하지 아니하고 서비스를 계속 사용할 경우는 약관 변경에 대한 동의로 간주됩니다.
	제 3 조(약관 외 준칙)
	본 약관에 명시되지 않은 사항은 전기통신기본법, 전기통신사업법, 정보통신윤리위원회심의규정, 정보통신 윤리강령, 프로그램보호법 및 기타 관련 법령의 규정에 의합니다.
	</textarea><br>
		<input type="checkbox">회원가입 약관에 동의합니다. <br>

		<div class="line" style="border-bottom: solid 1px gray; width: 100%"></div><br>
	
	<h3>개인정보처리방침<span style="color:orange">*</span></h3>
		<textarea rows="7" cols="50" readonly  class="form-control" resize: none; style="background-color:#ffffff">
		제 1장 총칙
		
		제1조(목적)이 지침은 「개인정보 보호법」(이하 "법"이라 한다) 제12조 제 1항에 따른 개인정보의 처리에 관한 기준, 개인정보 침해의 유형 및 예방조치 등에 관한 세부적인 사항을 규정함을 목적으로 한다.
		제2조(용어의 정의) 이 지침에서 사용하는 용어의 뜻은 다음과 같다.
		1."개인정보 처리"란 개인정보를 수집, 생성, 연계, 연동, 기록, 저장, 보유, 가공, 편집, 검색, 출력, 정정(訂正), 복구, 이용, 제공, 공개, 파기(破機) 블라블라블라		
		</textarea><br>
		<input type="checkbox">개인정보처리방침에 동의합니다.
	</div>
	
	
	<div class="col-md-6">
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="아이디를 입력하세요*" maxlength="10"> <br>
		</div>
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="비밀번호를 입력하세요*" maxlength="10"> <br>
		</div>
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="한번 더 비밀번호를 입력하세요*" maxlength="10"> <br>
		</div>
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="이름을 입력하세요*" maxlength="10"> <br>
		</div>
		
			<div class="row">
				<div class="form-chek col-md-2 offset-4">
				<input type="radio" name="m">남자 </div>
				<div class="form-chek col-md-2">
				<input type="radio" name="f">여자 </div>
			</div> <br>
			
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="연락처를 입력하세요*" maxlength="20"> <br>
		</div>
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="이메일을 입력하세요*" maxlength="40"> <br>
		</div>
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="나이를 입력하세요*" maxlength="3"> <br>
		</div>
		
		<!-- //////////////////////////////////////////// -->
		<div class="row">
			<div class="col-md-4">
				<h5>주소<span style="color:orange">*</span></h5>
			</div>		
				<div class="col-md-4">
					<input type="text" placeholder="우편번호" class="form-control">
				</div>
				<div class="col-md-4">
					<button class="form-control">우편번호 찾기</button>
				</div>
				
			<div class="col-md-4">	</div>
			<div class="col-md-4">
				<input type="text" placeholder="도로명주소" class="form-control">
			</div>
			<div class="col-md-4">
				<input type="text" placeholder="지번주소" class="form-control">
			</div>
			
			<div class="col-md-4"></div>
			<div class="col-md-8">
				<input type="text" placeholder="상세주소" class="form-control">
			</div>
			
		</div>
				<button class="col-md-6 form-control">회원가입</button>	
	</div>

			
</div>
	
	
	<br><br>

	<%@include file="Footer.jsp" %>
</body>
</html>