
function passwordcheck(mid){

	//1.제이쿼리식(# 씀)
	let mpassword = $("#mpassword").val();
	
	//2.자바스크립트식 (# 안 씀)
//	document.getElementById("password").value;

	//비동기 통신 = 제이쿼리 제공해주는 통신() 메소드
		//[js(view) ---> java(controller)]
		
	//
//	$.ajax({속성명 = 속성값, 속성명 = 속성값});

	$.ajax({ //흐름도
		url : "../passwordcheck",//어디로
		data : {"mid":mid, "mpassword":mpassword},//보낼 데이터
		type : "POST",
//		method : post, //http 요청방식 정의[get=기본값, post]
		success : function(result){ //받을 데이터
			alert(result);
			if(result == 1){
				alert("같다");
				$("#checkmsg").html("정말 탈퇴하시겠습니까?");
				$("#password").css("display", "none"); //제이쿼리 css 적용[.css*("속성명, 속성값")]
				$("#btndelete").css("display", "block");
				$("#btncofirm").css("display", "none");
			} else {alert("다르다");
				$("#checkmsg").html("동일한 패스워드가 아닙니다.")}
		}
	});
}

function mdelete(mid){
	
	$.ajax({
		url : "../delete",
		data : {"mid" : mid},
		success : function(result){
		
		if(result == 1){
			alert("회원탈퇴 완료 되었습니다.");
			//js에서 하이퍼링크[페이지 연결]
			//<a href="경로">
			//location.href="경로"
			location.href="/JSPweb/logout";//서블릿
		} else {location.href="/JSPweb/member/error.jsp"; } //페이지 전환
		
		}	
	});
		
		

}

