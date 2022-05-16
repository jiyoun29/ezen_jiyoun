/* 특정 select에 db 데이터 넣기 */

$(function getcategory(){
		
	$.ajax({
		url : "getcategory",
		data : {"type": "option" },
		success : function( re ){
			$("#categorybox").html(re);
			
			
		} 
	});
	
});


/*--------------------------- */
//카테고리 select 값이 변경 될 때마다
$("#categorybox").change(function(){
	
	let cano = $("#categorybox").val();
	$.ajax({
		url : "getproduct",
		data : {"type" : "option", "cano": cano},
		success : function(re){
			if(re == ""){
				alert("해당 카테고리의 제품이 존재하지 않습니다.");	
				$("#productbox").html(" ");
				document.getElementById("#stockaddform").css('display','none');
				//js->attr	vs	jquart -> css 사용
				
			}else{
				$("#productbox").html(re);
				$("#stockaddform").css('display','block');
				getstock();
		}}
	});
		
});


/*---------------------------*/
//제품 재고 추가

function stockadd(){
	//제품번호 빼오기
	let pno = $("#productbox").val();
	let scolor = $("#scolor").val();
	let ssize = $("#ssize").val();
	let samount = $("#samount").val();
	
	$.ajax({
		url : "stockadd",
		data : {"pno":pno, "scolor":scolor,
			"ssize":ssize, "samount":samount },
		success : function(re){
			if(re == 1){
				alert("재고 변경 성공")
				$("#mainbox").load('productstock.jsp');
			} else {alert("재고 변경 실패")}
		}
	});
	
}

/*---------------------------*/
/* 제품명 목록 select 값이 변경 될때마다 .*/
$("#productbox").change( function(){
	getstock();
});

//제품명을 선택 할때마다
function getstock(){
	let pno = $("#productbox").val();
	$.ajax({
		url : 'getstock',
		data : {"pno" : pno},
		success : function(re){
			$("#stocklistbox").html(re);
		}
	});
}

/*---------------------------*/

/*---------------------------*/
