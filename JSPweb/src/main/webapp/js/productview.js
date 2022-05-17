
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
			let itemlist = list.split(",");
			
			let html = "";
				html +="<option value=''>-[필수]-옵션 선택-</option>";
			
			for(let item of itemlist){
			let color = item.split("=")[0];
			let amount = item.split("=")[1];
				html += "<option value=''>"+color+"-"+amount+"</option>";
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
	//특정 인덱스 삭제 : splice
//js객체 선언 -> object
	//let 객체명 = {필드명1 : 값 , 필드명2 : 값} <-ajax와 유사함(아잣트도 자스의 객체이다)
		// 호출 [ .연산자 ] 
			// 객체명.필드명 

 let selectlist = []; //js 배열

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



function optionprint(){
	let html ="<tr><th width='60%'> 상품명 </th> <th width='25%'> 상품수 </th> <th width='15%'> 가격 </th> </tr>";
	//테이블에 추가할 내용물
	
	//배열내 모든 객체의 정보를 html화 하기
	for( let i = 0; i<selectlist.length; i++){
		//만약에 이미 있는 칼라/색상이면 중지
		html +=
		"<tr>"+
			"<td> <span>"+selectlist[i].pname+"</span> <br>"+
			"<span class='pointbox'>"+selectlist[i].color+"/"+selectlist[i].size+"</span> </td>"+
		"<td> <div class='row g-0'> <div class='col-md-7'>"+
			"<input value='1' type='text' class='form-control fc amount_input'> </div>"+
				"<div class='col-md-4'> <button class='amount_btn'>▲</button>"+
					"<button class='amount_btn'>▼</button> </div>"+
				"<div class='col-md-1'> <button onclick='optioncancle("+i+
						//x버튼을 눌렀을 때 이벤트 -> i값 인수 전달 -> i : 배열내 객체 인덱스
					")' class='cancel_btn'>x</button> </div>"+
			"</div> </td> <td>"+
			"<span class='pricebox'>"+(selectlist[i].amount*selectlist[i].pprice)+"</span> <br> "+
			"<span class='pointbox'>(적)"+(selectlist[i].amount*selectlist[i].pprice)*0.01+"</span> </td>"
		+"</tr>";
	}
	$("#select_table").html(html);
}

//삭제할 인덱스를 건네받음. 해당 배열 내 인덱스 제거
function optioncancle(i){
	selectlist.splice(i , 1); //i번째 인덱스부터 1개의 인덱스 삭제
	optionprint(); //삭제 후 옵션목록을 다시 출력
}





