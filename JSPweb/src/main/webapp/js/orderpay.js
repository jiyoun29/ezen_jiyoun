
let jsonarray;
let totalpay = 0; //총금액

let sumprice = 0; //상품 총 가격
let deliverypay = 0; //배송비
let point = 0; //포인트 변수 선언
//밖에서 사용ㅎㅏ기 위해 여기서 선언

let member;
let mpoint = 0; //회원이 사용하는 포인트 // 값을 0으로 넣어두기*****

let pay_method;

/* 1. 자바스크립트 열리면 무조건 실행되는 메소드 */
$(function(){ //$(document).ready(function() 와 동일하다

	
	//현재 로그인 된 회원의 정보 가져오기
	$.ajax({ //멤버에 있는지 확인
		url : "/JSPweb/product/getmember", //서블릿 생성
		success : function(json){
			member = json;
			
		getcart(); //제품 출력 메소드 출력	????
		}
	});
	
	// 위의 member=json을 아래 if에서 사용하기 때문에 member로 맞춰놓기
	$("#checkbox").change(function(){ //체크박스 이벤트
		//체크박스가 변경 되었을 때 이벤트
		if($("#checkbox").is(":checked")){
			//만약에 체크박스가 체크 되어 있으면
				//빼오기
			$("#ordername").val(member["mname"]);
			$("#orderphone").val(member["mphone"]);
			$("#sample4_postcode").val(member["maddress"].split("_")[0]);
			$("#sample4_roadAddress").val(member["maddress"].split("_")[1]);
			$("#sample4_jibunAddress").val(member["maddress"].split("_")[2]);
			$("#sample4_detailAddress").val(member["maddress"].split("_")[3]);

		} else { //되어 있지 않으면
			$("#ordername").val("");
			$("#orderphone").val("");
			$("#orderaddress").val("");
			$("#sample4_postcode").val("");
			$("#sample4_roadAddress").val("");
			$("#sample4_jibunAddress").val("");
			$("#sample4_detailAddress").val("");
		}
	});
});

//2 테이블 출력 메소드(장바구니 데이터 호출ㄹ)
function getcart(){	
	
	
	$.ajax({
		url : 'getcart' ,
		success : function(json){
			jsonarray = json; /* 응답받은 데이터를 전역변수에 넣어주기 */
			
			
//			for(let i = 0; i<jsonarray.length; i++){
	//			totalpay += jsonarray[i]["totalprice"]; //누적더하기 진행
	//		}
//			alert(totalpay);
		cartview();
		}		
	});
}

//끌고오기
/*-----------------------------------------------*/

//3. js내 존재하는 json 객체를 table 에 데이터 출력
function cartview(){

	sumprice = 0; //상품 총 가격
	deliverypay = 0; //배송비
	totalpay = 0; //총 주문액

	//헤더 넣어놓기
			let tr = '<tr> <!-- 헤더 -->'+
'					<th width="60%">상품정보</th>'+
'					<th width="20%">수량</th> 		'+
'					<th width="20%">가격</th> '+
'				</tr>'

	for(let i = 0 ; i<jsonarray.length; i++){

		sumprice += jsonarray[i]["totalprice"]; // 누적합계
		
	tr += 
		'<tr>'+
'			<td> <!--  상품정보 열 -->'+
'				<div class="row"> <!-- row(b) : 하위 태그를 가로배치   -->'+
'					<div class="col-sm-2"> <!-- col-sm-2(b) : 12그리드 중 2그리드 사용 -->'+
'						<img alt="" src="/JSPweb/admin/productimg/'+jsonarray[i]["pimg"]+'" width="70%"> '+
'					</div>'+
'					<div class="col-sm-10">'+
'						<div class="pnamebox"> '+jsonarray[i]["pname"]+' </div>'+
'						<div class="optionbox">'+jsonarray[i]["scolor"]+' / '+jsonarray[i]["ssize"]+'</div>'+
'					</div>'+
'				</div>   '+
'				<br>'+
'			</td> '+
'			<td class="align-middle">'+
'				<div class="row g-0"> '+
'					<div class="col-sm-5 offset-3">'+ jsonarray[i]["samount"] +' 개 </div>'+
'				</div>'+
'			</td>'+
'				<td class="align-middle">'+
'					<div class="row g-0">'+
'						<div class="col-md-8 pricebox">'+jsonarray[i]["totalprice"].toLocaleString()+'원</div>'+
'					</div>'+
'				</td>'+
'		</tr>';
	}
	
		//배송비
		if(sumprice >= 70000){ deliverypay = 0;} else { deliverypay = 2500; }
		
		//만약에 장바구니에 상품이 없으면
		if( jsonarray.length == 0 ){
			tr += '<td style="text-align : center" colspan="3"> 상품이 없습니다. </td>'
		 deliverypay = 0; }

		
		//총주문금액=총가격=배송비
		totalpay = sumprice + deliverypay - mpoint;
		
		//포인트
		point = parseInt(sumprice * 0.01 ); //parseInt(데이터) : 정수형 변환

		//출력
		$("#mpoint").html( member["mpoint"] ); // 사용가능 포인트 출력 
		$("#pointbox").html( mpoint );	// 사용할 포인트 출력 
		$("#totalpay").html( totalpay ); // 총주문금액 출력 
		$("#sumprice").html( sumprice );	// 총상품 출력 
		$("#deliverypay").html( deliverypay ); // 배송비 출력 
		
		$("#carttable").html( tr );	// 테이블 상품 출력 
}


// 4. 결제수단 선택 메소드 
function paymethod( method ){
	$("#paymethod").html( method ); // html에 인수 출력 
	pay_method = method; // 결제수단 변수에 인수 넣기
}

//아임포트 결제api
function payment(){

	if( pay_method == null ){ // 만약에 결제수단을 선택를 안했으면
		alert('결제수단을 선택해주세요.!'); return;
	}
	
	var IMP = window.IMP; 
    IMP.init("imp34553674");
    //가맹점 식별코드. [아임포트 관리자콘솔 - 시스템 설정]
    
         // IMP.request_pay(param, callback) 결제창 호출
      IMP.request_pay({ // 결제 요청 변수
          pg: "html5_inicis", //pg사 -> 결제 대행 회사
          pay_method:  pay_method, //결제 방식
          merchant_uid: "ORD20180131-0000011", //주문번호[별도] - 오더번호
          name: "HOME", //홈페이지 이름[결제 이름]
          amount: totalpay, //총주문액
          buyer_email: member["memail"], //주문하는 이메일
          buyer_name: member["mname"], //주문하는 이름
          buyer_tel: member["mphone"], // 주문하는 사람번호
          buyer_addr:member["maddress"], //주문하는 주소
          buyer_postcode: member["maddress"].split("_")[0] //우편번호
      }, function (rsp) { // callback
          if (rsp.success) {      // 결제 성공 시 로직, -> 주문완료 페이지로 이동
          	
          } else {  // 결제 실패 시 로직,
	          saveorder();
          }
      });
} //order end


//주문처리 메소드
function saveorder(){
	
	//받는 사람 정보
	let ordername = $("#ordername").val();
	let orderphone = $("#orderphone").val();
	let orderaddress = 
				$("#sample4_postcode").val()+"_"+
				$("#sample4_roadAddress").val()+"_"+
				$("#sample4_jibunAddress").val()+"_"+
				$("#sample4_detailAddress").val();
				
	let ordertotalpay = totalpay;
	let orderrequest = $("#orderrequest").val();

	let orderjson = { //객체화
		ordername : ordername,
		orderphone : orderphone,
		orderaddress : orderaddress ,
		ordertotalpay : ordertotalpay,
		orderrequest : orderrequest
	}
	
	
	
	$.ajax({
		url : "saveorder",
		data : {"orderjson" : JSON.stringify(orderjson)} , //객체 -> json형 변환
		success : function(re){
			if( re == "true"){
			location.href = "/JSPweb/product/ordersuccess.jsp";}
			else {alert("오류 발생[관리자에게 문의]");}
		} //성공시 페이지가 넘어가고, 실패시 그대로 있기
	});
}


/////////////////////////


function pointbtn(){
	//만약에 포인트가 5000이상이 아니면
	mpoint = $("#pointinput").val();
	if(mpoint == 0){
		mpoint = 0;
	} else if (mpoint < 5000){
		alert("최소 5000포인트 부터 사용 가능합니다.");
		mpoint = 0; 
		$("#pointinput").val(0);
		return;
	} else if (mpoint > member["mpoint"]) {
		alert("보유 포인트가 부족합니다.")
		mpoint = 0;
		$("#pointinput").val(0);
		return;		
	}
	 cartview(); //새로고침
}







