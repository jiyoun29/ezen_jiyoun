package Day12;

public class day12_2 {
	public static void main(String[] args) {
		
		
		//String 메소드
		// 499 charAt(); : 문자열에서 특정문자 추출
		String ssn = "010624-1230123"; //주민등록번호
		char sex = ssn.charAt(7);
		switch(sex) { //케이스를 입력하고 출력문 작성
		//switch 제어문 [ switch 검사대상 ]
			case '1' : //변수 값이 1, 3이면
			case '3' : System.out.println("남자"); break;
			case '2' : //변수 값이 2, 4이면
			case '4' : System.out.println("여자"); break; //break필수
		}
		
		//501 equals() : 문자열 비교
			//기본자료형 사용하는 변수는 연산자 사용가능 [ == ]
			//String 클래스 사용하는 객체는 == 연산자 사용불가능 [ equals ]
		
		
		//자바 메모리 [ jvm ]
			//스택 메모리 : 지역변수
			//힙 메모리 : 객체
			//메소드 : 
		//스택은 힙에 주소값을 가지고 있음.
		//new 객체를 쓰면 힙 영역에 저장된다.
		//스택에 저장[힙위치=힙메모리주소] = 힙에 저장
		
		
		
		//1.문자열 선언 []
		String strVar1 = new String("신민철");
		String strVar2 = "신민철"; //String은 new없어도 ok. 자동으로 객체 생성이 된다.
		
		//2.문자열 비교
		if(strVar1 == strVar2) { //문자열 == 불가능. ==은 힙주소가 동일한지 비교를 함
			System.out.println("같은 String 객체를 참조");
		} else { //502
			System.out.println("다른 String 객체를 참조");
		}
		
		
		//3.
		if(strVar1.equals(strVar2)) { //  equals는 힙 내용을 비교한다.
			System.out.println("같은 문자열을 가짐");
		} else {
			System.out.println("다른 문자열을 가짐");
		}
		
			
		
		
		//502 (추후 파일처리에서 사용)
		//getBytes() : 문자열 -> 바이트열 변환
		String str = "안녕하세요"; //영문대소문자 1바이트, 한글2바이트
		
		
		byte[] bytes1 = str.getBytes(); //문자열 -> 바이트열 변환
		System.out.println("영문1bytes 한글2bytes : " + bytes1.length);
		//배열명.length : 배열
		
		
		//바이트열 -> 문자열 변환 *******************************
		String str1 = new String(bytes1);
		System.out.println("바이트열 -> 문자열 :" +str1);
		
		
		try {
			// 1.인코딩타입[인코딩/디코딩 : 변환 방식]
			
			//1. EUC-KR 한글/영문 한글 2바이트
			//예외처리
			byte[] bytes2 = str.getBytes("EUC-KR"); //일반예외 발생
			System.out.println("EUC-KR 길이 : "+bytes2.length);
			String str2 = new String(bytes2, "EUC-KR");
			System.out.println("바이트열 -> 문자열 :"+str2);
			
			//2. UTF-8
			//크면 클수록 더 많이 표현. 전세계 용어; 한글 3바이트
			byte[] bytes3 = str.getBytes("UTF-8"); //일반예외 발생
			System.out.println("UTF-8 길이 : "+bytes3.length);
			String str3 = new String(bytes3, "UTF-8");
			System.out.println("바이트열 -> 문자열 :"+str3);
			
		} catch(Exception e) {}
		
		
		//504
		
	System.out.println("=====================================");
		
		//indexOf(): 문자 위치[인덱스] 찾기
		String subject = "자바 프로그래밍";
		
		//특정 문자로 문자열 내 특정 위치(인덱스) 찾기
		
		//**검색용으로 많이 쓰임
		int location = subject.indexOf("프로그래밍");
		System.out.println(location); //3번 인덱스에서  프로그래밍 찾기
		
		//문자열내 특정문자열 위치(인덱스) 찾기 / 만일 없으면 -1로.
		
		if(subject.indexOf("자바") != -1 ) //인덱스는 0부터
		{	//-1일이라는 건 인덱스가 없다는 뜻
			System.out.println("자바와 관련 책");
		} else {
		System.out.println("자바와 관련 없는 책");
		}
		
		
		//505
		//length() : 문자열 길이
		String ssn2 = "7306241230123";
		int length = ssn2.length(); //문자열 내 문자 개수(길이 구하기)
		
		//반복문, 유효성 검사에서 주로 사용한다.
		if(length == 13) { //만일 길이(글자수)가 13글자 이면
			System.out.println("주민번호 자리수가 맞습니다.");
			//아니면
		} else { System.out.println("주민번호 자리수가 틀립니다."); }
		
		//회원가입할때 유효성검사 필수(중복체크)
		
		

		
		System.out.println("=====================================");
		//506 replace("기존문자", "새로운문자") : 문자열 대치[변경]
		String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "JAVA");
					//문자열.replace("기존문자","새로운문자")
		
		System.out.println("기본문자열 : "+oldStr);
		System.out.println("새로운문자열 : "+newStr);


		
		//507 Substring(): 인덱스 기준 vs split() : 문자 기준 [문자열 자르기]
				
		//511 참고
		String ssn3 = "880815-1234567";
		
		String firstNum = ssn3.substring(0,6); //시작인덱스, 마지막 인덱스 전
		System.out.println("확인 : "+firstNum); 
		
		String secondNum = ssn3.substring(7); //인덱스~마지막 인덱스
		System.out.println("확인 : "+secondNum); 
		System.out.println("=====================================");
		//split
			// "880815-1234567" "-" 하이픈 기준으로 자르기시 2조각이 생기며 배열로 반환됩니다.
			// 0 인덱스는 880815가 저장되고 1번 인덱스에는 1234567이 저장된다.
		System.out.println("앞부분 : "+ssn3.split("-")[0] ); //0:첫번째이다.
		
		
		
		//508
			//영문문자열.toLowerCase("영문") -> 영문 [소문자로 변환]
			//영문문자열.toUpperCase("영문") -> 영문 [대문자로 변환]
		
		
		//509
			//문자열.trim() : 앞뒤 공백제거[]
		//너무 많은건 제거x
		
		
		//510
			// valuOf() : 기본타입[int,double 등] -> 문자열 변환
		String str2 = String.valueOf(10); //int형 10 -> String 10으로 변환
		String str3 = String.valueOf(10.5); //double형 10.5 -> String 10.5으로 변환
		String str4 = String.valueOf(true); //boolean형 true -> String true로 변환
		String str5 = 10+""; //10마ㅣㄴ 두면 안 되지만 " "를 붙이면 된다. 연결함으로서 문자+숫자=문자 를 만든다.
		
		System.out.println(str2+10); //문자+문자 : 연결		
		System.out.println(str3+10);
		// if(str4) 오류 : str5에는 boolean형이 아닌 문자형 true 저장
		
		
		/////////////////////////
	}	
}
