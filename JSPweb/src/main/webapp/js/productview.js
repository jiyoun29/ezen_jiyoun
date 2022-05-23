
/* 칼라 select 목록이 변경 되었을 때 */
$("#color_select").change(function(){
	
	let color = $("#color_select").val(); //색상
	if(color == ""){return;} //색상이 공백이면 실행x
	//제품 번호와 칼라가 동일한 경우에 사이즈 가져오기
	let pno = $("#pno").val();
	
	$.ajax({ //통신시 사용되는 데이터 타입 -> 문자열/첨부파일/json도 가능
		url : 'getstocksize',
		data : {'pno':pno , 'color':color},
		success : function(re){
//			let map = new Map(); // js map 객체 선언
//			map = re; //map 객체에 결과물 넣기
			let list = re.replace("{","");
			let list2 =list.replace( "}","");
			let itemlist = list2.split(", ");
			
			let html = "";
				html +="<option value=''>-[필수]-옵션 선택-</option>";
			
			for(let item of itemlist){
			let size = item.split("=")[0];
			let amount = item.split("=")[1];
				html += "<option value='"+size+"'>"+size+" - "+amount+"</option>";
			}
			$("size_select").html(html); 	// id.html( )  : 새로운 데이터 
			// $("#size_select").append('<option>asdasd</option>'); // id.append( ) : 데이터 추가
		}
	});
});

////////////////////////////////////////////////////

//js배열
	//let 배열명 = []
	//추가 : puch => 배열 내 마지막 인덱스에 추가
	//제거 : pop() => 제일 끝에 있는 인덱스 삭제
	//특정 인덱스 삭제 : splice(시작인덱스, 개수) -> 특정 시작인덱스부터 개수만큼 삭제
		//배열내 중간인덱스 삭제시 빈공간 인덱스 당기기 -> java arraylist 클래스와 동일
			//예) 3번 삭제시 4번 인덱스가 3번 자리에 온다.
//js객체 선언 -> object
	//let 객체명 = {필드명1 : 값 , 필드명2 : 값} <-ajax와 유사함(아잣트도 자스의 객체이다)
		// 호출 [ .연산자 ] 
			// 객체명.필드명 

 let selectlist = [ ]; //js 배열

//사이즈를 목록이 변경되었을 때
$("#size_select").change(function(){
	//필요한 거 가져오기
	let pname = $("#pname").html(); //제품 이름

	let color = $("#color_select").val(); // 선택한 색상
		if(color == ""){return;} //색상이 공백이면 실행x
	let size = $("#size_select").val(); //선택한 사이즈
		//val값을 빼올 때에는 ()를 반드시 포함시킬 것
		if(size == ""){return;} //색상이 공백이면 실행x
	
	
	
	let amount = $("#amount").val(); //구매 수량
	//input 생성되기 전이면 기본값 1
	if($("#amount").val()==null) amount = 1;

	let pprice = $("#pprice").val(); //가격
	
	let overcheck = color+size; //옵션 - 식별용
	
	let product  = { //js 객체 선언
		pname : pname, //필드명 = 속성명. ,을 기준으로 데이터를 넣음
		color : color,
		size : size ,
		amount : amount ,
		pprice : pprice, 
		totalprice : pprice * amount ,
		point : (pprice * amount)* 0.01 ,
		overcheck : overcheck
	}
	
	
	for(let i = 0; i<selectlist.length; i++){ //만약에 배열에 이미 있는 옵션이라면 중지
	//배열에서 i번째 객체를 빼냄
		if(selectlist[i].overcheck == overcheck){ alert("이미 선택한 옵션입니다."); return; }
	//배열내 i번째 객체의 필드[중복체크]호출
		//js : 문자열 비교 ==
		//java : 문자열 비교x -> eqluas
		
	} selectlist.push(product); //배열 추가
	
	optionprint();
	
});


//천단위 구분쉼표 -> 정규표현식(언어) vs js(내장메소드 : toLocalString())
							//데이터.toLocalString(undefinde, {maximumFractionDigits : 소수점 표시 단위})
	/*
		\d{3}) : 정수 3자리 패턴
		(\d{3})+ : 앞 표현식 반복 대응
		(\d{3})+(?!\d) : 표현식 뒤에 정수가 없는 경우[정수 끝 찾기]
		\B(?= (\d{3})+(?!\d)) : 문자가 없으면 (\d{3})+(?!\d)를 실행시킨다.
	
		ex) /\B(?=(\d{3}+(?!\d))/ <<이런식으로 사용(앞뒤 슬래시o. 쉼표x)
		 /^ : 정규 표현식 시작
		 패턴 : (앞 = 문자 존재) , (뒤 = 문자열 3글자)
		 		([0-9]{3}) = 정수 3자리
		 \d : 정수 [0-9]
		 {} : 길이
		 + : 앞 표현식 반복되는 부분 대응(천 단위 , )
		 x(?!y) : x 뒤에 y가 없는 경우(false) : (?!\d) : 앞에 패턴이 없는 경우(뒤에 더이상 숫자가 없는 경우)
		 x(?=y) : x 뒤에 y가 있는 경우(true) : (?=(\d{3}+(?!\d))
		 \B : 문자 경계선 (문자 제외. 바이트) : \B(?=(\d{3}+(?!\d))
		 /g : 전역 검색[모든 곳 검색]
		 /i : 대소문자 구분없는 검색
	*/
	
	
// let comm = "/\B( ?= (\d{3})+(?!\d))/g "; //천단위 구분쉼표 정규표현식 변수
	//데이터.toString().replace("정규표현식",",");



function optionprint(){
	let html ="<tr><th width='60%'> 상품명 </th> <th width='25%'> 상품수 </th> <th width='15%'> 가격 </th> </tr>";
	//테이블에 추가할 내용물
	
	//배열내 모든 객체의 정보를 html화 하기
	for( let i = 0; i<selectlist.length; i++){

		//총 금액 / 포인트 최신화
		selectlist[i].totalprice =  selectlist[i].pprice *  selectlist[i].amount ;
		selectlist[i].point =  selectlist[i].totalprice * 0.01 ;		
		
		
		//만약에 이미 있는 칼라/색상이면 중지
	html += "<tr>"+
			"<td> <span>"+selectlist[i].pname+"</span> <br>"+
			"<span class='pointbox'>"+selectlist[i].color+"/"+selectlist[i].size+"</span> </td>"+
		"<td> <div class='row g-0'> <div class='col-md-7'>"+ //객체 내 수량
		//수량 입력 상자 -> readonly(읽기 전용)
					//input 박스를 같이 쓰면 문제가 생기므로 자르고 i값 추가
			"<input readonly id='amount"+i+"' value="+selectlist[i].amount+
			" type='text' class='form-control fc amount_input'> </div>"+
				//구매수량 증가/감소 버튼
				"<div class='col-md-4'>"+
				"<button onclick='amountincre("+i+")' class='amount_btn'>▲</button>"+
				"<button onclick='amountdecre("+i+")' class='amount_btn'>▼</button> </div>"+
				"<div class='col-md-1'>"+
				"<button onclick='optioncancle("+i+")' class='cancel_btn'>x</button> </div>"+
						//x버튼을 눌렀을 때 이벤트 -> i값 인수 전달 -> i : 배열내 객체 인덱스
			"</div> </td> <td>"+
			"<span class='pricebox'>"
				+selectlist[i].totalprice.toString()+"원"
					+"</span> <br> "+
			"<span class='pointbox'>(적)"
				+selectlist[i].point.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"원"
				+"</span> </td>"
		+"</tr>";
	}
	$("#select_table").html(html);
	
	//총합계
	let total_price =0;
	let total_amount = 0;
	for(let i =0 ; i<selectlist.length; i++ ){
		total_price += selectlist[i].totalprice;
		total_amount += selectlist[i].amount; }
	//객체 내 총합계를 구함
	$("#total_price").html( total_price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+
				'원 ('+ total_amount +'개)' );
}


//해당 인덱스를 배열내 제거 함수
//삭제할 인덱스를 건네받음. 해당 배열 내 인덱스 제거
function optioncancle(i){
	selectlist.splice(i , 1); //i번째 인덱스부터 1개의 인덱스 삭제
	optionprint(); //삭제 후 옵션목록을 다시 출력
}

//해당 인덱스의 상품수 증가 함수
function amountincre(i){
	//만약에 재고보다 상품수 더 크면 함수 종료
		let pno = $("#pno").val(); //pno값 가져오기
		//재고 가져오기
		$.ajax({
			url : 'getamount',		 //리스트의 i번째에 칼라가 있음
			data : {'pno':pno, 'color':selectlist[i].color, 'size':selectlist[i].size},
			success : function(maxamount){
				//만일 max 값이 재고보다 크거나 같으면
				if(selectlist[i].amount >= maxamount){
					alert('재고가 부족합니다.'); return;	}
		//if가 아닐 경우 아래 코드 실행
	selectlist[i].amount++; //선택한 객체들이 모여있는 배열
	//해당 인덱스의 객체 내 수량 1 증가
	optionprint(); //옵션목록을 다시 출력
			}
		});
}

//해당 인덱스의 상품수 감소 함수
function amountdecre(i){
	//만약 수량이 1이면 함수 종료(-로 가지 못하게 막음)
	if(selectlist[i].amount == 1){alert('최소 수량 입니다.');return;}
	selectlist[i].amount --;	
	//해당 인덱스의 객체 내 수량 1 감소
	optionprint(); //옵션목록을 다시 출력
}


//관심등록 버튼을 눌렀을 때 함수 -> mno, pno
function saveplike(mid){
	//만일 mid가 null(문자로 받음)이면 로그인 후 접속하게 한다.
	if(mid == 'null'){alert('로그인 후 가능합니다.'); return;}
	let pno = $("#pno").val();
	$.ajax({
		url : "saveplike",
		data : {"mid" : mid , "pno" : pno}, //input hidden으로 숨겨놓은 pno값을 가져옴
		success : function(re){ //성공했다면 값을 가져온다.
			if(re == 1){ //만일 서블릿으로부터 전달 받은 값이 1이면
				alert("관심 등록 했습니다.");
			} else if (re == 2){alert("관심 등록을 취소 했습니다.");}
			else if (re == 3){alert("오류 [관리자에게 문의]");}
			//특정 태그 새로고침(문법 겹침 방지를 위해 한 번 띄어쓰기 필요)
			$("#btnbox").load( location.href + " #btnbox");
		}
	});
}


//현재 선택된 제품들을 장바구니(카트)에 담기
function savecart(mno){
	//로그인이 안 되어 있을 때
	if(mno == 0){alert("로그인 후 장바구니 이용이 가능합니다."); return;}
	
	//선택한 옵션의 개수 -> 만약에 선택한 옵션이 없으면
	if(selectlist.length == 0){alert("최소 수량 1개부터 가능합니다."); return;}

	//서블릿에게 배열 보내기
		//사용이유 : 서로 다른 언어들끼리 데이터 타입의 통일성을 주기 위하여
		//ajax <----- json -----> 서블릿
			//js : json 라이브러리 내장. java : json 라이브러리 다운로드
				//stringify : 형변환 가능
				// JSON.stringify() : 배열이나 객체를 JSON 형식으로 변환 시키는 메소드
				//key : value -> entry
				//여러개 entry -> JSONobject //{키1:값, 키2:값,}
				//여러개 JSONobject -> JSONarray //[{키1: 값, 키2:값},{키1: 값, 키2:값}]
				// 키 : value(JSONarray)
				
	$.ajax({ //전송인코딩 기본타입 -> 문자열
		url : "savecart",
		data : {"json" : JSON.stringify(selectlist) , "pno" : $("#pno").val() },
								//형식을 변환하기
		success : function(re){
			if(re == -1 ){alert("장바구니에 등록하였습니다.");}
			else {alert("오류발생[관리자에게 문의] : "+(re+1)+"옵션 ");}
		}
	});




}



