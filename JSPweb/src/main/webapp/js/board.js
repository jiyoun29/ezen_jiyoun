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