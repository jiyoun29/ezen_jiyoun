//무조건 문서가 열렸을 때 실행
$(document).ready(function(){


  $('#summernote').summernote({
    placeholder: '내용을 입력해주세요.',
    tabsize: 2,
    width: 800,
    minHeight: 250, //최소 높이
    maxHeight : null, //최대 높이
//    lang : 'ko-KR' //메뉴 한글 버전
    
  });
  
 });
 
 
 function filedelete(bno){
	//html -> js 변수를 이동
		//1. 메소드 인수로 이동
		//2. 태그의 value 혹은 html로 이동
	alert("파일삭제");
	
	//비동기 통신 = 페이지 전환이 없는 상태 db통신
	//jquery 라이브러리의 ajax 사용
	$.ajax({
		url : "filedelete", //서블릿통신
		date : {"bno" : bno }, // 통신 데이터 : {변수명 : 값 , 변수명2 : 값}
		success : function(result){
			if(result == "1"){alert("첨부파일 삭제 성공");
			location.reload(); //현재 페이지 새로 고침
			}
			else{alert("첨부파일 삭제 실패[관리자에게 문의]")}
		}
	});
}



function replywrite(bno){
	let rcontent = $("#rcontent").val();
	
	$.ajax({
		url : "replywrite",
		data : {"bno":bno , "rcontent" : rcontent},
		success : function(result){
			if(result == 1){
				alert("댓글이 작성되었습니다.");
				//성공 메시지 알림
				$("#rcontent").val(""); //작성 input마다 공백으로 초기화
				$("#replytable").load(location.href+" #replytable"); //특정 태그를 새로고침할때 사용
				//해당 리플테이블의 불러오기 = 본인태그를 다시 불러옴
			} else{alert("댓글작성에 실패하였습니다.");}
		}
	});
}


function rereplyview( rno , bno , mid ){ // 대댓글 입력창 표시 메소드 
	// ' '  or " "	: 문자처리 	// '문자열' + 변수 + '문자열'

	if( mid == null ){ // 로그인 안되어 있으면
		alert("로그인 후 작성이 가능합니다."); return;
	} 
	// JS 작성 공간 에서는 HTML 작성 불가능 --> HTML 문자처리 
	
	$("#"+rno).html(
		'<div class="row">'+
			'<div class="col-md-10">'+
				'<textarea id="rrcontent" class="form-control" rows=3></textarea>'+
			'</div>'+
			'<div class="col-md-2">'+
				'<button class="form-control py-4 my-1" onclick="rereplywrite('+rno+','+bno+')">대댓글 등록</button>'+
			'</div>'+
		'</div>'
	);	
}


function rereplywrite(rno, bno){

	let rrcontent = $("#rrcontent").val();
	$.ajax({
		url : "rereplywrite",
		data : {"rno":rno , "bno":bno, "rrcontent":rrcontent},
		success : function(result){
				if(result == 1){
				alert("답글이 작성되었습니다.");
				//성공 메시지 알림
				$("#rrcontent").val(""); //작성 input마다 공백으로 초기화
				$("#replytable").load(location.href+" #replytable"); //특정 태그를 새로고침할때 사용
				//해당 리플테이블의 불러오기 = 본인태그를 다시 불러옴
			} else{alert("답글 작성에 실패하였습니다.");}
		
		}
	});
	
}

//대댓글
function reupdateview(rno){
	
	$("#"+rno).html(
		 '<div class="row">'+
         '<div class="col-md-10">'+
            '<textarea id="rupcontent" class="form-control" rows="3"></textarea>'+
         '</div>'+
         '<div class="col-md-2">'+
            '<button class="form-control py-4 my-1" onclick="replyupdate('+rno+')">댓글수정</button>'+
         '</div>'+
      '</div>'
	);
	
}

//댓글 수정
function replyupdate(rno){

	let rcontent = $("#rupcontent").val();
	
	$.ajax({
		url : "/JSPweb/board/replyupdate",
		data : {"rno" : rno , "rcontent" : rcontent },
		success : function(result){
			if(result == 1){alert("수정 되었습니다.");
				$("#replytable").load(location.href+" #replytable");}
				
			else{alert("수정 실패[관리자에게 문의]");}
		}
		
	});
}



function replydelete(rno){
	
	$.ajax({
		url : "replydelete",
		data : {"rno":rno},
		success : function(result){
			if(result == 1){
				alert("삭제 되었습니다.");
				$("#replytable").load(location.href+" #replytable");
			} else { alert("삭제 실패[관리자에게 문의]"); }
		}
		
	})
	
}


function chatwrite(){
	let cname = $("#cname").val();
	let ccontent = $("#ccontent").val();
	
	$.ajax({
		url : "../chat",
		data : {"cname":cname, "ccontent":ccontent},
		success : function(result){
			if(result == 1){
				$("#ccontent").val(""); //작성 input마다 공백으로 초기화
				$("#chattable").load(location.href+" #chattable");
			} else { alert("삭제 실패[관리자에게 문의]"); }
		}
		
	});
	
}




