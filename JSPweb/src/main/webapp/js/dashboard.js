
/* 사이드바에서 버튼 클릭시 특정 태그의 페이지 넣기 */

function pagechange(page){

	// $ : 제이쿼리에서 사용하는 문법
		// 특정태그 호출 : $("#태그id명")
		// 특정태그.load(페이지경로) : 해당 태그에 페이지 로드
	$("#mainbox").load(page+".jsp");	
}


//무조건 1회 실행되는 메소드
// $(function(){페이지가 열릴때 실행되는 코드});


//기능 통째로 외우기
/*사이드바 위치 변경을 이용한 사이드바 열기/닫기 */
$( function(){
	var side = $("#sidebar"); /* 반복 사용을 위해 변수 담기 */
	
	// side.find('span') ->제이쿼리 문법. find('태그') 찾기
		//해당 태그 내 특정 태그 찾기
	side.find('span').on( 'click' , function(){
					//.on('click', 함수(){실행코드})
					//클릭했을때 함수가 실행
					
		side.toggleClass('open');
	//toggleclass : 해당 태그에 클래스 넣기[open 클래스 넣기]
		
		if( side.hasClass('open') ){	// 해당 태그의 클래스가 open 이면 
			side.stop(true).animate({left:"0px"}, 200);
			// side 태그의 애니메이션 효과 : 해당태그의 왼쪽위치를 0px 이동 
		}else{
			side.stop(true).animate( {left:"-200px"} , 200 );
			// side 태그의 클래스 open 아니면 애니메이션 효과 : 해당태그의 왼쪽위치를 -200px 이동 
		}
		
	});
	
});

