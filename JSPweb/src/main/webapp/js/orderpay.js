
let jsonarray;
let totalpay = 0; //총금액

/* 1. 자바스크립트 열리면 무조건 실행되는 메소드 */
$(function(){
	getcart();
});

//2 테이블 출력 메소드(장바구니 데이터 호출ㄹ)
function getcart(){	
		$.ajax({
		url : 'getcart' ,
		success : function(json){
			jsonarray = json; /* 응답받은 데이터를 전역변수에 넣어주기 */
			for(let i = 0; i<jsonarray.length; i++){
				totalpay += jsonarray[i]["totalprice"]; //누적더하기 진행
			}
//			alert(totalpay);
		}		
	});
}

//끌고오기
/*-----------------------------------------------*/

//아임포트 결제api
function payment(){
    IMP.init("imp34553674");
    //가맹점 식별코드. [아임포트 관리자콘솔 - 시스템 설정]
    
         // IMP.request_pay(param, callback) 결제창 호출
      IMP.request_pay({ // param
          pg: "html5_inicis", //pg사 -> 결제 대행 회사
          pay_method: "card", //결제 방식
          merchant_uid: "ORD20180131-0000011", //주문번호[별도] - 오더번호
          name: "HOME", //홈페이지 이름[결제 이름]
          amount: totalpay, //총주문액
          buyer_email: "gildong@gmail.com", //주문하는 이메일
          buyer_name: "홍길동", //주문하는 이름
          buyer_tel: "010-4242-4242", // 주문하는 사람번호
          buyer_addr: "서울특별시 강남구 신사동", //주문하는 주소
          buyer_postcode: "01181" //우편번호
      }, function (rsp) { // callback
          if (rsp.success) {
              // 결제 성공 시 로직,
          } else {  // 결제 실패 시 로직,
	          saveorder();
          }
      });
} //order end


function saveorder(){
	alert("db처리?");
	$.ajax({
		url : "saveorder",
		success : function(re){
			alert("db처리성공");
		}
	});
}














