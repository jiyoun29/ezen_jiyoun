
//jquruy : js 프레임워크
	//$ : 제이쿼리
	//$(function(){ 실행문; }) : 문서 실행시 무저건 실행되는 함수
	//js식		id 불러오기 : .getElementById(id명)
	//jquery식 	id 불러오기 : $("#id명")
		//keyup() : 해당 id에 키보드가 눌렸을때 [ 입력 되었을 때 ]
	//라이브러리 설치 : header파일 body 태그에 추가
	
//	$메소드(function(){코드짜기});
	//이 양식을 늘 기억할 것
	

	//입력상자 유효성 확인 체크 배열(통과*5)
	let pass = [false, false, false, false, false, false, false];
	//배열[] 대괄호를 쓰면 배열, 안 쓰면 변수
	//전역변수로 여기저기서 쓰므로 밖에다 뺌

	
$(function(){  //문서가 열리면 해당 코드가 실행


////////////////아이디 체크	
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
					idcheck.innerHTML="사용중인 아이디입니다.";
					pass[0] = false;
				} else {idcheck.innerHTML="사용 가능한 아이디입니다.";
					pass[0] = true;}
				}
			}); //끝
			
		} else {
			idcheck.innerHTML = "5~15 길이의 숫자+영문으로 입력해주세요.";
			pass[0] = false;
			//유효성검사와 중복체크 모두 완료 	
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
				pass[1] = false;
			}else{
				$("#mpwch").html("사용 가능한 비밀번호 입니다.");
				pass[1] = true; pass[2] = true;
			}
		}else{ // 정규현식 다르면
			$("#mpwch").html("영소문자 5~15 사이로 입력해주세요!");
			pass[1] = false;
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
					pass[2] = false;
				}else{
					$("#mpwch").html("사용 가능한 비밀번호 입니다.");
					pass[2] = true; pass[1] = true;
				}
			}else{ // 정규현식 다르면
				$("#mpwch").html("영소문자 5~15 사이로 입력해주세요!");
					pass[2] = false;
			}
	}); // keyup end 
	
	
	
	
	//이름 체크
	$("#mname").keyup(function(){
		
		//샵 넣어서 제이쿼리로 사용
		let mname = $("#mname").val(); //해당 id의 데이터 가져오기
		let namej = /^[가-힣]{2,10}$/; //정규표현식. 한글만 2~10 정규표현식
		
		if(namej.test(mname)){ $("#namecheck").html("사용 가능한 이름입니다.");
		pass[3] = true;
		} else { $("#namecheck").html("한글 2~10사이만 입력 가능합니다.");
		pass[3] = false;}
	}); // keyup end 
	
	
	
	
	// 전화번호 체크
	$("#mphone").keyup(function(){
		
		//샵 넣어서 제이쿼리로 사용
		let mphone = $("#mphone").val(); //해당 id의 데이터 가져오기
		let phonej = /^010-([0-9]{4})-([0-9]{4})$/; //정규표현식. 
		
		if(phonej.test(mphone)){$("#phonecheck").html("사용 가능한 번호입니다.");
		pass[4] = true;
		} else { $("#phonecheck").html("010-0000-0000 양식에 맞춰주세요.");
		pass[4] = false;}	
	});  // keyup end 
	
	
	
	//이메일 체크
	$("#memail").keyup(function(){ //# 잘 넣기
		let memail = $("#memail").val();
		let memailaddress = $("#memailaddress").val();
		
		//중복체크
		if(memailaddress == " "){ //공백이면
			$("#emailcheck").html("이메일 주소를 입력해주세요.");
			pass[5] = false;
		} else { //공백이 아니면
		let emailj = /^[a-zA-Z0-9]{3,20}$/;
		if(emailj.test(memail)){ //중복체크
		
		//합치기
		let email = memail+"@"+memailaddress;
		
		//합친걸 달러 아잣트로 전송
		$.ajax({
			url : "../emailcheck",
			date : { "email" : email }, //{변수명, 값(값은 큰따옴표x)}
			success : function(result){ //성공했으면
				if(result == 1){
					$("#emailcheck").html("사용 중인 이메일 입니다.");			
					pass[5] = false;
				} else {
					$("#emailcheck").html("사용 가능한 이메일 입니다.");			
					pass[5] = true;				
				}
			}
		}); //ejax 끝
		
		//여기까지 만들고 서블릿 만들러감(자바에 서블릿에 이메일체크 생성)
			}else{
				$("#emailcheck").html("이메일 형식이 아닙니다.");  pass[5] = false;
			} }
	}); //keyup end
	
	
	//이메일 주소 목록 상자 선택시
	$("#emailselect").change(function(){
		//목록 상자 내 값이 변경 되었을 때 : change
		
		let emailselect = $("#emailselect").val();
		if(emailselect ==""){ //공백이 아니면
			$("#memailaddress").val("");
			$("#memailaddress").attr("readonly", false);	 //읽기모드 해제	
		} else { $("#memailaddress").val(emailselect); //val -> value 값
				$("#memailaddress").attr("readonly", true); } //attr -> attribute 속성
								//수정할 수 없게 막기
	}); //keyup end
	
	
	
	
	//주소체크
	$("#sample4_detailAddress").keyup(function(){
			
		let address1 = $("#sample4_postcode").val();
		let address2 = $("#sample4_roadAddress").val();
		let address3 = $("#sample4_jibunAddress").val();
		let address4 = $("#sample4_detailAddress").val();
		
		if(address1 =="" || address2 =="" ||
			address3 =="" || address4 =="" ){
				$("#addresscheck").html("모든 주소를 입력해주세요.");
				pass[6] = false;
			} else {$("#addresscheck").html("사용 가능한 주소입니다.");
				pass[6] = true;}
		
	});
	
	
}); // 문서 열리면 해당 코드가 종료 



//폼 전송 메소드

	function signup(){ //pass 배열이 모두 true 이면 폼 전송
		let check = true;
		for(let i = 0; i<pass.length ; i++){
			if(pass[i] == false) check = false;
			//하나라도 false이면 전송x
		}	
			//js에서 form 전송하는 방법****
		 if(check) document.getElementById("signupform").submit();
		 	//모두 true라면 submit으로 온다.
	//만일 없으면 알림창
		else{alert("필수 입력 사항이 입력되지 않았습니다.");}
		//하나라도 false이면 여기로 온다.	
	}


	//비밀번호 변경
	function passwordchange(){
		$("#passwordbox").css("display","block");
	
}







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