
//$(function(){}); <-현재 page가 로드 되는 메소드
//$:제이쿼리식을 의미


let parentlist;

//제품 빼오기
$(function(){ //문서가 열렸을 때
	$.ajax({ //비동기로 주문 제품 리스트 가져오기
		url : "../product/getorder", //현재 스크립트의 위치와 서블릿 위치를 확인
		success : function(result){
			parentlist = result;
//확인		console.log(parentlist);
			view();
		}
	});	
});


let viewcount = 2;

//스크롤을 내릴 때마다 데이터를 추가로 가져옴
	//브라우저 내 스크롤 사용 이벤트
$(window).scroll(function(){ 
		//$(window).scroll : 브라우저(인터넷창) 스크롤
		//$(window).scrollTop() : 스크롤막대의 상단 위치
		//$(document).hight() : 문서내 높이
		//$(window).hight() : 스크롤의 높이

	//만약에 스크롤이 바닥에 닿았을 때
	if( $(window).scrollTop() == $(document).height() - $(window).height() ){
		//현재 스크롤의 상단 위치 ----현재 보고 있는 문서의 높이 ---- 현재 보고 있는 화면의 높이
		viewcount++; //스크롤이 바닥에 닿을 때마다 1씩 증가
		view(); //뷰 불러내기
	}
 });


//제품리스트를 출력하는 메소드
function view(){
	
	let html = ""; //초기가 없을때 ["" 문자가 들어감]
	
	for(let i = 0; i<parentlist.length ; i++){ //count 개수만큼 제품 수 출력
		if(i == viewcount) break; //만약에 i가 화면에 표시할 주문수와 동일하면 출력하는 주문개수를 증가
	
		html +=
				/* 주문 정보 출력 구역 */
		'<div class="orderinfo">'+
'			<span> 주문번호 </span> <span>'+parentlist[i][0]["orderno"]+'</span>'+
'			<span> 주문날짜 </span> <span>'+parentlist[i][0]["orderdate"]+'/span>'+
'			<a href="#"> <span> 주문 상세 보기 ▷</span> </a>'+
'			</div> <div class="orderdetailbox col-sm-11">';

	
			for (let j = 0; j<parentlist[i].length; j++){ /* 제품 상세 출력 구역 */
				let childlist = parentlist[i]; // 상위 리스트에서 하나씩 하위리스트 꺼내기
		html +=	 '<div class="row product">'+
'			<div class="col-sm-2"> <!-- 이미지 -->'+
'				<img width="100%" alt="" src="/JSPweb/admin/productimg/'+childlist[j]["pimg"]+'"> </div>'+
'			<div class="col-sm-7 my-4"> <!-- 정보 -->'+
'				<div class="row">'+
'					<div class="pname">'+childlist[j]["pname"]+'</div>'+
'					<div class="poption">'+childlist[j]["scolor"]+'/'+childlist[j]["ssize"]+'</div>'+
'					<div class="orderbtnbox">'+
'						<button> 배송 조회 </button>'+
'						<button> 취소 신청 </button>'+
'						<button> 리뷰 작성 </button>'+
'					</div>'+
'				</div>'+
'			</div> <div class="col-sm-3">'+
'				<span> 상품 준비중 </span>'+
'				</div>'+
'		</div>';
	}
		html +=
	'</div>';
	}
	$("#orderbox").html(html);
}


