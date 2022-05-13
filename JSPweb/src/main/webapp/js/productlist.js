
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

