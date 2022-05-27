
//스크립트가 실행될때 입력창에 커서 두기
$("#incontent").focus();
//js 웹소켓 변수
let websoket = null;


start(); //웹소켓 실행


/* 엔터를 입력했을 때 이벤트 */
function enterkey(mid){
	if( window.event.keyCode == 13 ){
		if( mid == 'null' ){
			alert("로그인 후 채팅 입력이 가능합니다."); return;
		}
	send( mid );	 //a메시지 전송
	}
}

/* 전송 버튼을 눌렀을때 이벤트 */
function sendbtn(mid){	
	
	if( mid == 'null' ){
		alert("로그인 후 채팅 입력이 가능합니다."); return;
	}
	send( mid );  //a메시지 전송
	
}


////////////////////


/* 채팅 소켓 실행 */
function start(){
	let mid = $("#mid").val();
	
	//js에서 사용되는 웹소켓 클레스(ws : IP번호/PORT번호/프로젝트명/서버소켓 )
	websoket = new WebSocket("ws://localhost:8282/JSPweb/chatting/"+mid);
														// ?말고 /를 씀
	websoket.onopen = function( e ){ onOpen(e) } //누가들어왔는지 체크 
	websoket.onmessage = function( e ){ onmessage(e) }
	websoket.onclose = function( e ){ onclose(e) }
	websoket.onerror = function( e ){ onerror(e) }

}			

function onclose( e ){ alert("채팅방을 나갑니다.")+e; }
function onerror( e ){ alert("서버소켓오류입니다" +e); }

function onOpen( e ){
	alert("서버소켓으로 들어왔습니다."+e);
	console.log(e);
}

function onmessage(e){
//	alert("메시지를 받습니다."+e+"내용물:"+e.data); //뭐가 들었는지 확인
//	console.log(e);
//	alert("메소드 실행 정보 : "+e );
//	alert("메시지 정보[문자열] : "+e.data );
//	alert("메시지 정보[json형변환] : "+JSON.parse(e.data) );
	
	// e : 메소드 이벤트 실행정보가 담겨있는 객체
		// e.data : 메시지 내용이 담겨있는 필드		
	let msg = JSON.parse( e.data ); // 문자열 -> json
	
//	alert( msg[0]["type"] );
		
		if(msg["type"] != "1"){	 //메시지 이면
		
			let html ="";
			//명단이기 때문에 반복문을 돌려서 빼옴
			for(let i = 0 ; i<msg.length ; i ++){
			html +=
			'<div class="row p-3"> <!-- 접속자 정보 box -->	'+
	'			<div class="col-sm-4"> <!-- 프로필 이미지 표시 구역 -->'+
	'				<img alt="" src="../img/'+img+'" class="rounded-cicle"  width="100%">'+
	'			</div>'+
	'			<div class="col-sm-8"> <!-- 접속자 이름, 기능 -->'+
	'				<div class="member_name">'+msg[i]["mid"]+'</div>'+
	'				<div class="btnbox">'+
	'					<span>귓속말</span>'+
	'					<span>친구추가</span>'+
	'				</div>'+
	'			</div>'+
	'		</div> <!-- 접속자 정보 box 종료 -->';
			}
			$("#enterlist").html( html );		
		
		

	} else { //메시지가 메시지 타입이면
		
	let from = msg["from"]; //key값. json 키를 통한 value 호출
	
	let content = msg["content"]; //key값. json 키를 통한 value 호출
	let img = msg["img"]; //key값. json 키를 통한 value 호출
	let date = msg["date"]; //key값. json 키를 통한 value 호출
//	alert(from + content + img + data);

	let html = $("#contentbox").html();

	if(from ==  $("#mid").val() ){ //현재 로그인된 아이디와 보낸사람이 같으면
	//내가 보냈을 때
		html += 
		'<div class="secontent my-2"> <!-- 보낼때 -->'+
			'<span class="date">'+date+'</span>'+
			'<span class="content">'+content+'</span>'+
		'</div>';
	} else {	
	//다른 사람이 보냈을때
		html += 
		'<div class="row g-0"> <!-- g-0 : 여백 제거 -->'+
'			<div class="col-sm-1 mx-2">'+
'				<img alt="" src="../img/'+img+'" class="rounded-cicle"  width="100%">'+
'			</div>'+
'			<div class="col-sm-9">'+
'				<div class="recontent"> <!-- 받을때 -->'+
'					<div class="member_name">'+from+'</div>'+
'					<span class="content">'+content+'</span>'+
'					<span class="date">'+date+'</span>'+
'				</div>'+
'			</div>'+
'		</div>  <!-- g-0 : 여백 제거 -->';
	}
	
	 $("#contentbox").html( html ); //추가된 html 넣어주기
	 //스크롤 하단으로 내리기
	 $("#contentbox").scrollTop( $("#contentbox")[0].scrollHeight );
		// $("#contentbox").scrollTop : 현재 스크롤의 상단 위치
		// $("#contentbox")[0].scrollHeight : 현재 스크롤의 전체 길이

	}
}



function send( mid ){
	let content = $("#incontent").val();
	
	
	//dto없이 json 형식으로 통신 [ js <---> java, db(x) ]
	let msg	= { // js 객체화 // 객체명 = {속성명(key ) : 값(value)}
		type : "1" ,
		from : mid , //보내는 사람
		content : content , //채팅 내용
		img : "프사.webp" ,
		date : new Date().toLocaleTimeString() // 채팅 보낸 시간
	}
//가능하지만 사용하지않는 방법:	String msg = "비회원,content,프로필1.jpg"
	
	//json 통신할때 json모양 문자열로 변환
		//json -> 문자열		JSON.stringify
		//문자열 -> json		JSON.parse( )
		
	websoket.send( JSON.stringify(msg) );
	$("#incontent").val(""); //전송 후 입력창 초기화
	$("#incontent").focus(); //전송 후 포커스
}



