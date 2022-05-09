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
  
