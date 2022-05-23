/* json 형식의 변수를 선언 */
let jsonarray; //전역변수로 써서 모두 이용
//초기화 필요
let sumprice = 0; //상품 총 가격
let deliverypay = 0; //배송비
let totalpay = 0; //총 주문액
let point = 0; //포인트 변수 선언

/* 1. 자바스크립트 열리면 무조건 실행되는 메소드 */
$(function(){
	//object를 써서 모든 key값을 빼올 수 있다.
	//js에서 json 객체 내 key값을 이용한 value를 추출할 때  ' 객체명[key값] '으로 value값 호출이 가능
		//jsonarray[i][key] -> json배열 내 i 번째 객체인 key값 호출
	//공백 넣기
	
	getcart();

});

/* 자바스크립트 열리면 무조건 실행되는 메소드 */
//2 테이블 출력 메소드(장바구니 데이터 호출ㄹ)
function getcart(){
	
		$.ajax({
		url : 'getcart' ,
		success : function(json){
			jsonarray = json; /* 응답받은 데이터를 전역변수에 넣어주기 */
			tableview(); /* 테이블 호출 메소드 1회 호출 */
		}		
	});
}



/* 테이블에 데이터를 넣어주는 함수 */
	//함수를 왜 쓰는지 늘 사용이유를 생각해볼것.
	//늘 사용해야하기 때문에 밖으로 빼낸것
function tableview(){
				let tr = '<tr>'+
'			<th width="60%">상품정보</th>'+
'			<th width="20%">수량</th>'+
'			<th width="20%">가격</th>'+
'			</tr>';

			sumprice = 0; /*상품 총가격 */
			deliverypay = 0; // 배송비 
			totalpay = 0; // 총주문액 
			
			for(let i = 0 ; i<jsonarray.length; i++){
				//무조건 진행. 누적더하기
				sumprice += jsonarray[i]["totalprice"];
				
//				alert(re[i]);
//				alert(Object.keys(re[i]));
					/* Object.keys(json 객체) -> 객체 내 모든 키 반환 */
//				alert(re[i]['ssize']); /* json 객체[key] -> 객체 내 key에 해당하는 value 호출 */
				
//			tr += '<tr>'+
//			'<td width="10%"> <img width="100%" alt="" src="../admin/productimg/'+jsonarray[i]['pimg']+'"></td>'+
//			'<td>'+jsonarray[i]['pname']+'<br>'+jsonarray[i]['scolor']+'/'+jsonarray[i]['ssize']+'</td>'+
//			'<td>'+jsonarray[i]['totalprice']+'</td>'+
//			'<td> <button>x</button> </td></tr>'

	//jsp에서 작성한거 가져옴
	tr += '<tr>'+
'			<td>'+
'				<div class="row">'+
'					<div class="col-sm-2">'+
'						<img alt="" src="/JSPweb/admin/productimg/'+jsonarray[i]["pimg"]+'" width="70%">'+
'					</div>'+
'					<div class="col-sm-10">'+
'						<div class="pnamebox">'+jsonarray[i]["pname"]+'</div>'+
'						<div class="optionbox">'+jsonarray[i]["scolor"]+'/'+jsonarray[i]["ssize"]+'</div>'+
'					</div>'+
'				</div>'+
'				<br>'+
'			</td> <!-- 수량 -->'+
'			<td class="align-middle">'+
'				<div class="row g-0">'+
'					<div class="col-sm-5 offset-3">'+
'						<input readonly id="" value="'+jsonarray[i]["samount"]+
							'" type="text" class="form-control" style="background-color: white;">'+
'					</div>'+
'					<div class="col-sm-2">'+
'						<button onclick="amountincre('+i+')" class="amount_btn">▲</button>'+
'						<button onclick="amountdecre('+i+')" class="amount_btn">▼</button>'+
'					</div>'+
'				</div>'+
'			</td>'+
'			<td class="align-middle">'+
'				<div class="row g-0">'+
'					<div class="col-md-8 pricebox">'+jsonarray[i]["totalprice"].toLocaleString()+'원</div>'+
'					<div class="col-md-4 deletebox"><button onclick="cancel('+i+')">X</button></div>'+
'				</div>'+
'			</td>'+
'		</tr>';
		} // json에 있는거 받아서 뿌리기 db->서블릿->js->jsp 순서
		
		//만약에 총가격이 7만원 이상이면 배송비 무료
		if(sumprice >= 70000){ deliverypay = 0;
		} else { deliverypay = 2500; }
		
		
		//만약에 장바구니에 상품이 없으면
		if( jsonarray.length == 0 ){
			tr += '<td style="text-align : center" colspan="3"> 상품이 없습니다. </td>'
		 deliverypay = 0; }

		
		//총주문금액=총가격=배송비
		totalpay = sumprice + deliverypay;
		
		
		//포인트
		point = parseInt(sumprice * 0.01 ); //parseInt(데이터) : 정수형 변환
		
		//출력
		$("#sumprice").html( sumprice.toLocaleString()+'원' );
		$("#deliverypay").html( deliverypay.toLocaleString()+'원' );
		$("#totalpay").html( totalpay.toLocaleString()+'원' );
		$("#point").html( point.toLocaleString() );
		
		$("#carttable").html(tr);
}


//json 상태 업데이트 처리 메소드
function updatecart(){
	$.ajax({
		url : "updatecart" ,
		data : { "json" : JSON.stringify(jsonarray) } ,
		success : function ( json ){
	//		jsonarray = json;
			getcart();
		}
	});
}



//8.장바구니 삭제 처리 메소드
function deletecart( i ){
	$.ajax({
		url : 'deletecart' ,
		data : { 'cartno' : jsonarray[i]["cartno"] }	 ,
		success : function(re){
			getcart();
		}
	});
}



//수량증가
function amountincre(i){
		//재고의 최대값 가져오기 -> productview.js에 사용된 서블릿 재사용
		$.ajax({
			url : "getamount" ,
			data : { "pno" : jsonarray[i]['pno'] , "color" : jsonarray[i]['scolor'] ,
					"size" : jsonarray[i]['ssize']} ,
			success : function ( maxamount ){
				if(jsonarray[i]['samount'] >= maxamount ){
					alert("재고가 부족합니다."); return;		}
			//총금액 업데이트
				 let price = parseInt ( ( jsonarray[i]['totalprice'] / jsonarray[i]['samount'] ) ); //제품 하나의 금액
				jsonarray[i]['samount']++; //수량 증가
				jsonarray[i]['totalprice'] = price * jsonarray[i]['samount']; //증가된 수량만큼 총금액 업데이트
			updatecart();	
			}			
		});
}


//수량감소
function amountdecre(i){
	if(jsonarray[i]["samount"] == 1){alert("최소 수량 입니다."); return;}

		//총금액 업데이트
		 let price = parseInt( ( jsonarray[i]['totalprice'] / jsonarray[i]['samount'] )); //제품 하나의 금액
		jsonarray[i]["samount"]--;
		jsonarray[i]['totalprice'] = price * jsonarray[i]['samount'];

	updatecart();
}




/* json 배열내 특정 인덱스 삭제 */
function cancel( i ){
	if( i == -1 ){ //만약에 i가 -1이면 전체 삭제
		if(confirm("전체 삭제 하시겠습니까?")){
			//confirm("내용") 확인/취소 버튼 알림창
				//확인 -true 취소0false
				for(let j = 0 ; j<jsonarray.length ; j++) {
					deletecart(j); //삭제 db 처리
				} //한바퀴 돌려서 전부 삭제
//			jsonarray.splice( 0 , jsonarray.length);
				//0번 인덱스부터 마지막 인덱스(길이=length)까지 삭제
///			updatecart();
		}
	  return;
	}
	deletecart(i); //개별삭제 db처리
//	jsonarray.splice( i , 1); //i번째부터 1개를 삭제
//	tableview(); //업데이트. 새로고침.
}

