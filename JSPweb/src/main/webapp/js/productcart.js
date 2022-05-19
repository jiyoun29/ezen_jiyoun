
$(function(){
	
	$.ajax({
		url : 'getcart' ,
		success : function(jsonarray){
			
			//object를 써서 모든 key값을 빼올 수 있다.
			//js에서 json 객체 내 key값을 이용한 value를 추출할 때  ' 객체명[key값] '으로 value값 호출이 가능
				//jsonarray[i][key] -> json배열 내 i 번째 객체인 key값 호출
			//공백 넣기
			let tr = "";
			for(let i = 0 ; i<jsonarray.length; i++){
//				alert(re[i]);
//				alert(Object.keys(re[i]));
					/* Object.keys(json 객체) -> 객체 내 모든 키 반환 */
//				alert(re[i]['ssize']); /* json 객체[key] -> 객체 내 key에 해당하는 value 호출 */
				
			tr += '<tr>'+
			'<td width="10%"> <img width="100%" alt="" src="../admin/productimg/'+jsonarray[i]['pimg']+'"></td>'+
			'<td>'+jsonarray[i]['pname']+'<br>'+jsonarray[i]['scolor']+'/'+jsonarray[i]['ssize']+'</td>'+
			'<td>'+jsonarray[i]['totalprice']+'</td>'+
			'<td> <button>x</button> </td></tr>'
			} // json에 있는거 받아서 뿌리기 db->서블릿->js->jsp 순서
		$("#carttable").html(tr);
		}		
	});
});