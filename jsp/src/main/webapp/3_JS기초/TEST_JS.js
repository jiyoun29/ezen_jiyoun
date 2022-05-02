
/*
	js 문법 [사용 이유 : 유효성검사, 비동기통신 등]
		1. 주석 : java 동일
		2. 변수선언
			a. var : 변수명 중복o, 메모리 초기화o
			b. const : 변수명 중복x, 메모리 초기화x (final과 유사)
			c. let : 변수명 중복x, 메모리 초기화o
			
		3. 내장객체/메소드
			a. alert("알림내용") : 알림창 메소드
			b. document : 문서 객체 [현 html 객체화]
				ㄱ. .write("html 작성") : html 쓰기
				ㄴ. getElementById("html 해당태그의 id명") : 해당 태그 가져오기
				ㄷ. innerHTML("해당 태그에 넣을 데이터") : 해당 태그에 html 넣기
				ㄹ. textContent("해당 태그에 넣을 데이터") : 해당 태그에 데이터 넣기
				ㅁ. style.css속성명 = 속성값 : 해당 태그에 css 속성 적용
				ㅂ. value : 해당 태그에 value 값 가져오기[value 속성이 있는 태그만 가능]
			c. console.log() : 브라우저(f12)내 console창에 출력 [테스트 목적]
			
		4. 반복문 / 제어문 *기초
			a. for(초기값;조건식;증감식){}
			b. if(논리식){}
		
		5. 함수선언
			a. function 함수명(){실행문;} : 인수가 없을때
			b. function 함수명(인수명, 인수명){}
*/

 var 메시지1 = "자바 var변수";	alert(메시지1);
 var 메시지1 = "자바 var중복변수";	alert(메시지1);
 //변수 var : 중복 가능, 메모리 초기화 가능 [구버전이라 잘 안 씀]


 const 메시지2 = "자바 const변수"; 	alert(메시지4);
// 메시지4 = "자바 const 변수 값 변경" 	alert(메시지4);
 //변수 const : 고정값, 변수명 중복 불가능, 메모리 초기화 불가능 = 상수

 
 let 메시지5 = "자바 let 변수";	alert(메시지5);
//let은 변수명 중복 불가능
메시지5 = "자바 let 변수 값 변경";



let tag1 = document.getElementById("spantag1");
tag1.innerHTML = "js에서 작성된 문자";

//let=int와 유사
let 가격 = 500; //변수선언
let 개수 = 10; //변수선언
let total = 가격*개수; //변수연산
let tag2 = document.getElementById("spantag2");
tag2.innerHTML = total;


//함수 = 메소드
	//function 함수명(인수){실행문}
function 함수1(){
	let 색상배열 = ['red', 'white', 'black'];
	//배열선언 : let 배열명 = [값1, 값2, 값3 ~~~];
	//배열 호출 : 배열명[인덱스 번호];
	
	let tag3 = document.getElementById("spantag3");
	tag3.textContent = 색상배열[0]; //배열 호출(인덱스 사용)
	tag3.style.color = 색상배열[0];
	
	//body 태그에 css 배경색 변경
	document.body.style.backgroundColor = "#eeeeee";
}


function 함수2(){ //메소드 선언

	//while문
	//클릭시 리스트가 생성
	let i = 1; //변수 선언
	while( i <= 10){ //반복은 10회 반복
		let tag4 = document.getElementById("orderlist1");
		tag4.innerHTML = "<li>반복횟수 : "+i+"</li>";
		i++; //+=(대입연산자) 기존 html에 추가
	}
	
	//for
	let j = 0;//변수선언
	let 제품배열 = ["갤럭시", "아이폰", "엘지폰"]; //배열선언
	for( j ; j<제품배열.length; j++ ){
		let tag5 = document.getElementById("orderlist2");
		tag5.innerHTML += "<li> 제품명 : "+제품배열[j]+"</li>";
	}
}

function 함수3(){ //메소드 선언
//	let 제품명 = "콜라";
	let 제품명 = document.getElementById("input1").value;
	document.getElementById("orderlist3").innerHTML
		+= "<li>"+제품명+"</li>";
	
}


function 함수4(){ //공백을 넣어서 지우기(모두 삭제)
	document.getElementById("orderlist3").innerHTML="";
}



function 함수5(이름, 성별){
	document.writeln("입력하신 이름은 :"+ 이름);
	document.writeln("입력하신 성별은 :"+ 성별);
	
}




