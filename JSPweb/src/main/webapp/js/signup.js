
//jquruy : js 프레임워크
	//$ : 제이쿼리
	//$(function(){ 실행문; }) : 문서 실행시 무저건 실행되는 함수
	//js식		id 불러오기 : .getElementById(id명)
	//jquery식 	id 불러오기 : $("#id명")
		//keyup() : 해당 id에 키보드가 눌렸을때 [ 입력 되었을 때 ]
	//라이브러리 설치 : header파일 body 태그에 추가
		
$(function(){  //문서가 열리면 해당 코드가 실행
	
	$("#mid").keyup(function(){  //mid가 입력될때마다 해당 함수 실행

		//1.html 태그내 값 가져오기
	let mid = document.getElementById("mid").value;
	
	//2.htm 태그내 데이터 넣기
	let idcheck = document.getElementById("idcheck");

	//정규표현식 : 특정한 규칙을 가지는 문자열의 집합 언어(스페이스바x)
	let idj = /^[a-zA-Z0-9]{5,15}$/;
			//한글을 제외한 영문+숫자가 포함된 5~15 사이 문자열
	
		// /^ 정규표현식 시작
		// $/ 정규표현식 끝
		//{최소길이, 최대길이} : 최소 길이~최대 길이 까지만 입력
			//정규표현식.text(정규표현식을 적용할 변수){}
				//해당 변수가 정규표현식에 동일하면 true 다르면 false
		
	if( idj.test(mid)){ //정규표현식과 같으면
//			idcheck.innerHTML = "가능한 아이디 입니다.";
			
			//아이디 중복체크
				//비동기식 통신[목적:페이지 전환이 없이 java(controller) 통신]
			// $.ajax({속성 = 속성값, 속성 = 속성값})//jquery에서 제공해주는 메소드 //내장메소드
			$.ajax({
				url : "../idcheck" , //통신할 경로
				date : { "mid" : mid } , //해당 경로로 보내는 데이터
				//기본타입은 get이지만 method : post,로도 사용이 가능하다.
				success: function(result){ //해당 경로에서 받은 데이터
			//id를 보내서 현재 사용중인 아이디인지 체크		
			//get이나 post로 http 통신에 보낼 수 있음(기본타입은 get)
				if(result ==1){
					idcheck.innerHTML="사용중인 아이디입니다."
				} else {idcheck.innerHTML="사용 가능한 아이디입니다."}
				}
			}); //끝
			
		} else {
			idcheck.innerHTML = "5~15 길이의 숫자+영문으로 입력해주세요.";		
		}

	});
	
		// 비밀번호 체크 
	$("#mpw").keyup( function(){  // 비밀번호 입력할때마다
		// let mpassword = document.getElementById("mpassword").value;  // js식
		let mpw = $("#mpw").val();  // jquery 식
		let mpwcheck = $("#mpwcheck").val();
		
		let pwj = /^[a-zA-Z0-9]{5,15}$/; // 정규표현식
		
		if( pwj.test( mpw ) ){ // 정규표현식 같으면
			if( mpw != mpwcheck ){ // 비밀번호 와 비밀번호체크 와 다르면
				// equals(x)  //  != ( o )
			$("#mpwc").html("패스워드가 서로 다릅니다.");
			}else{
				$("#mpwch").html("사용 가능한 비밀번호 입니다.");
			}
		}else{ // 정규현식 다르면
			$("#mpwch").html("영소문자 5~15 사이로 입력해주세요!");
		}
	}); // keyup end 
	
	
	
	//비밀번호 확인 체크(위는 자바, 아래는 제이쿼리)
	$("#mpwcheck").keyup(function(){ // 비밀번호 입력할때마다
	//	let mpw = document.getElementById(mpw).value();
		let mpw =  $("#mpw").val();
		let mpwcheck = $("#mpwcheck").val();
		
		let pwj = /^[a-zA-Z0-9]{5,15}$/; // 정규표현식
		
		if( pwj.test( mpw ) ){ // 정규표현식 같으면
				if( mpw != mpwcheck ){ // 비밀번호 와 비밀번호체크 와 다르면
					// equals(x)  //  != ( o )
				$("#mpwch").html("패스워드가 서로 다릅니다.");
				}else{
					$("#mpwch").html("사용 가능한 비밀번호 입니다.");
				}
			}else{ // 정규현식 다르면
				$("#mpwch").html("영소문자 5~15 사이로 입력해주세요!");
			}
	}); // keyup end 
	
	
	
	
	//이름 체크
	$("#mname").keyup(function(){
		
		//샵 넣어서 제이쿼리로 사용
		let mname = $("#mname").val(); //해당 id의 데이터 가져오기
		let namej = /^[가-힣]{2,10}$/; //정규표현식. 한글만 2~10 정규표현식
		
		if(namej.test(mname)){ $("#namecheck").html("사용 가능한 이름입니다.");
		} else { $("#namecheck").html("한글 2~10사이만 입력 가능합니다.");}
	});
	
	
	
	
	// 전화번호 체크
	$("#mphone").keyup(function(){
		
		//샵 넣어서 제이쿼리로 사용
		let mphone = $("#mphone").val(); //해당 id의 데이터 가져오기
		let phonej = /^010-([0-9]{4})-([0-9]{4})$/; //정규표현식. 
		
		if(phonej.test(mphone)){$("#phonecheck").html("사용 가능한 번호입니다.");
		} else { $("#phonecheck").html("010-0000-0000 양식에 맞춰주세요.");}	
	}); 
	
	
	
	
}); // 문서 열리면 해당 코드가 종료 


//다음 api js
     function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }