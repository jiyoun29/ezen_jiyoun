
/*-------------- 카테고리 버튼 눌렀을 때 이벤트---------- */

function categorybtn(){
	//특정태그의 html넣기
	$("#categoryinput").html(
		'<div class="row">'+
			'<div class="col-md-5">'+
			'<input class="form-control" type="text" id="caname">'+"<div>"+
			'<div class="col-md-5">'+
			'<button onclick="categoryadd()" type="button">등록</button>'+"<div>"+
		'<div>'
	)
}

/*-------------- 카테고리 등록 눌렀을 때 이벤트---------- */

function categoryadd(){
	let caname = $("#caname").val(); //해당 입력값 가져오기
	
	$.ajax({ /* 비동기 통신 */
		url : "categoryadd" , //서블릿 url 매핑
		data : {"caname" : caname } , //보내는 데이터 : 카테고리명
		success : function(result){ //통신 성공시 받는 데이터
			if(result == 1){
				alert("카테고리 추가");
				$("#categoryinput").html(" ");
				getcategory();
			}else{
				alert("카테고리 실패");
			}
		}
	});
	
}

/*==-------------------------------- */

$(function category(){
	getcategory();
});

/*--------------------------------------- */

/*-------------- 카테고리 호출---------- */
//$(함수({})) 조건 없이 실행. js열람시 실행되는 함수
function getcategory(){
	
	//비동기통신
	$.ajax({
		url : "getcategory",
		success : function( re ){
			$("#categorybox").html(re);
		}
	});
};


/*--------------------------------------- */
/* -------- form 전송  ------------ */
function productadd(){

	var form = $("#addform")[0]; // 폼 태그 id 호출 [0] 인덱스 호출 
	var formData = new FormData( form ); // js 지원하는 FormData 클래스를 이용한 form태그 객체화
	// ajax 기본적으로 문자열 전송한다.  인코딩 URL 타입 : application/x-www-form-urlencoded

	
	$.ajax({
		url : "productadd",
		type : 'POST' , /* type : 1.GET(기본타입) 2.POST(첨부파일사용시,보안용 등)*/
		data : formData , 		/* form 객체를 전송 */
		contentType : false ,  /* 전송시 문자열 타입X *
		/* contentType 전송시 내용물 URL 타입 //  String방식 : https://finance.naver.com/item/main.naver?code=005930 */
		/* contentType : true : URL 인코딩 타입 문자열 O [ 기본타입 ]
		/* contentType : false : URL 인코딩 타입 문자열 X */ 
		processData : false ,  /* 전송시 문자열 전송X */
		/*  html 에서 enctype="multipart/form-data"  */
		/*  ajax 에서 contentType : false, processData : false */
		success : function( re ){
			if( re == 1){
				alert(" 등록이 되었습니다. "); 
				form.reset(); 	/* form안에 적혀있는 내용 지우기 */
			}else{
				alert(" 등록이 실패 했습니다 [ 관리자에게 문의 ] ");
			}
		}
	});
}

/*--------------------------------------- */

/*첨부파일이 변경되면 특정태그에 첨부파일 이미지 표시 */
/* js : 객체지향 언어 */
$("#pimg").change(function(e){
	
//	alert(e); /* change 된 객체 */
//	alert(e.target); /* 객체.target() 내가 체인지한 html 태그 */
//	alert(e.target.files[0]);
//	alert($("#pimg").val());
	/* 클라이언트가 사진을 서버에 올릴때 서버가 클라이언트의 경로를 알 수가 없다 */
	
	//클라이언트가 업로드시 업로드 파일의 경로 알기
	let reader = new FileReader(); //파일의 경로를 읽어오는 클래스
	reder.redaAsDataURL(e.target.files[0]); 
	
	reader.onload = function(e){ //찾은 파일 경로 실행
		$("preview").attr("src", e.target.result); }
	
//	alert($("#pimg").val());
});




/* ------------------------- */



