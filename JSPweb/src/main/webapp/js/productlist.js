
//선택 제품의 제품번호를 모달로 이동시킴-----------------------
function pnomove(pno){	
	$("#modalinput").val(pno);
}

//상태 변경 비동기식 처리--------------------------------
function activechange(active){
	let pno = $("#modalinput").val();
	
	$.ajax({
		url : "activechange", //activechange라는 onclick
		type : "GET", //기본이 get방식
		data : {"pno":pno, "active" : active},
		success : function(re){
			if(re == 1){alert("상태 변경 완료");
			
			//특정태그 새로고침
//			$("#producttable").load(location.href+' producttable');

			$("#madalclosebtn").click(); //특정버튼 강제클릭 : 모달내 취소 버튼 클릭 이벤트
			$("#mainbox").load('productlist.jsp'); //해당 div에 해당 페이지 로드
			
			} else{alert("상태 변경에 실패하였습니다.");}
		}
	});
	
};

//----------------------------------------------

//재고 빼오기
function getamount(pno){
	//제품번호, 색상, 사이즈 동일한 경우 재고 호출
	
	let scolor = $("#colorbox"+pno).val();
	let ssize = $("#sizebox"+pno).val();

	$.ajax({
		url : 'getstock',
		data : {'field':'amount', "pno":pno ,
				"scolor":scolor, "ssize":ssize},
		success : function(re){
			if(re == ""){
				$("#amountbox"+pno).html("해당 사이즈 색상 <br> 재고없음");
				$("#datebox"+pno).html("");
			} else {
				$("#amountbox"+pno).html(re.split(",")[0]+"개");
				$("#datebox"+pno).html(re.split(",")[1]); }
		}
	});
	//id값을 변수로 연결
	// $("#amount"+pno).html("색상:"+scolor+"<br>"+"사이즈:"+ssize);
};

//----------------------------------------------
//선택한 제품의 재고 변경
function getstock(pno){
	
	$.ajax({
		url : 'getstock',
		data : {'pno':pno},
		success : function(re){
			$('#stocklistbox').html(re);
		}
	});
};



function showupdate(sno){
	$("#updatebox").css("display","block") //재고 수량 수정 입력창 열기
	$("#sno").val(sno); //수정할 재고번호 담기
}

//꺼내오기
function stockupdate(){
	let sno = $("#sno").val();
	let samount = $("#samount").val();
	
	$.ajax({
		url : 'stockupdate',
		data : {'sno' : sno , 'samount' : samount},
		success : function(re){
			$("#modalclosebtn2").click(); // 모달 닫기 버튼를 강제로 클릭이벤트 실행 
			$("#updatebox").css("display","none"); // 재고수량 수정 입력창 숨기기
			$("#samount").val(""); 
			
			$("#mainbox").load( productlist+".jsp");
		}
	});
}

//----------------------------------------------
//----------------------------------------------




