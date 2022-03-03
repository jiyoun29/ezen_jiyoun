package Day03;

import java.util.Scanner;

public class Day03_3 {
	public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);

		//문제6 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합
		System.out.print("점수 입력:"); int 점수 = scanner.nextInt();
		if(점수 > 90) System.out.println("합격");
		else if(점수 < 90) System.out.println("불합격");
		
//		풀이
		// System.out.print("점수:"); int 점수 = scanner.nextInt();
//		if(점수 > 90) System.out.println("합격");
//		else (점수 < 90) System.out.println("불합격");
		
		//문제7 : 점수를 입력받아 점수가 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 그 외 재시험
		System.out.println("점수 입력:"); int 점수2 = scanner.nextInt();
		if(점수2 >= 90) System.out.println("A");
		else if(점수2 >= 80) System.out.println("B");
		else if(점수2 >= 70) System.out.println("C");
		else System.out.println("재시험");
		
		
		//문제8 : 로그인 페이지
			// [입력]: 아이디와 비번 입력
			// [조건]: 회원아이디가 admin이고 비밀번호가 1234일 경우에는 로그인 성공 아니면 로그인 실패 출력
//		System.out.println("아이디 : "); int 아이디 = scanner.nextInt();
//		System.out.println("비번 : "); int 비번 = scanner.nextInt();
//		if ( 아이디 = admin ) { if (비번 = 1234) System.out.println( "로그인 성공" ) ; }
//		else System.out.println( "로그인 실패" );
			//풀이
		System.out.println("-----로그인 페이지-----");
		System.out.print("아이디 : "); String 아이디 = scanner.next(); // 그냥 next 이용
			// char 자료형 [ 문자 1개(여러개x) 저장 ]
			// 자료형으로는 문자열을 저장할 수 없다.
				// 1. String 클래스를 사용하면 문자열 저장 가능
				// 2. char 배열/리스트 사용하면 가능
		System.out.print("비번 : "); int 비번 = scanner.nextInt();
			// 객체는 연산 불가
				// 자료형 사용하는 변수는 연산자 사용 가능
				// 클래스 사용하는 객체는 연산자 사용 불가 -> 메소드 [미리 만들어짐] 이용
					// 문자열비교시 .equals 이용
					// 문자열1.equals(문자열2) <-문자열1과 문자열2 비교
				// if (아이디.equals("admin")) ) { //아이디는 객체이기 때문에 불가능. 객체비교시 이퀄스()사용
				// if (비번 == 1234) { // 패스워드는 자료형 변수이기 때문에 가능
		
		//올라옴(boolean에서)
//		boolean 로그인성공 = false;
//		if ( 아이디 == "admin" ) { //입력한 아이디가 admin이면
//			if (비번 == 1234) { //입력한 비번이 1234이면
//				System.out.println( "로그인 성공" ) ;
//				로그인성공 = true;
//			} // 여기까지한 다음 boolean을 이용해 다시 만들기. boolean : 1비트 true 혹은 false 저장
//			else {
//				System.out.println("비밀번호가 틀렸습니다.");
//				 else { System.out.println("아이디가 틀렸습니다.");}
//		if(로그인성공 == false)	System.out.println("로그인 실패");
//			}
		
		//풀이
		System.out.println("---------로그인 페이지-----------");
		System.out.print(" 아이디 : ");	String id = scanner.next();
			// char 자료형 [ 문자 1개 저장 ] -> 자료형으로 문자열을 저장할수 없다.
				// 1. String 클래스 사용하면 문자열 저장가능 
				// 2. char 배열/리스트 사용하면 가능 
		System.out.print(" 비밀번호 : ");	int pw = scanner.nextInt();
			// 객체는 연산불가
				// 자료형 사용하는 변수는 연산자 사용 가능 
				// 클래스 사용하는 객체는 연산자 사용 불가 -> 메소드
					// 문자열 비교시 .equals
					// 문자열1.equals( 문자열2 ) 
		boolean 로그인성공 = false;
			// boolean : 1비트 true 혹은 false 저장 
		if( id.equals("admin") ) {	// id 는 클래스 객체이기 때문에 == 불가능 // 객체비교시에는 .equals() 사용
			// 입력한 id가 admin 이면 
			if( pw == 1234 ) { // pw 는 자료형 변수이기 때문에 == 가능  
				// 입력한 pw 1234 이면 
				System.out.println(" 알림) 로그인 성공 ");
				로그인성공 = true; // id , pw 가 모두 동일하면 로그인성공 변수를 true 변경
			}
			else { // 입력한 pw 1234 아니면 
				System.out.println(" 알림) 비밀번호 틀렸습니다. ");
			}
		}else { // 입력한 id가 admin 이 아니면 
			System.out.println(" 알림) 아이디가 틀렸습니다. ");
		}
		
		if( 로그인성공 == false ) System.out.println(" 알림) 로그인 실패 ");
			// 로그인 성공 변수가 false 이면 출력 
		
		//**** 이부분 제대로 이해하고 넘어갈것 ***연습도 많이하기
		
		
		//문제9 [ 입력 ] : 국어,영어,수학 입력받기
//			[ 조건 ] (경우의수 3가지)
//				평균이 90점 이상이면서 (if)
//					국어점수 100점 이면 '국어우수' 출력
//					영어점수 100점 이면 '영어우수' 출력
//					수학점수 100점 이면 '수학우수' 출력
//				평균이 80점 이상이면서  (else if)
//					국어점수 90점 이상이면 '국어장려' 출력
//					영어점수 90점 이상이면 '영어정려' 출력
//					수학점수 90점 이상이면 '수학장려' 출력
//				그외 재시험 (else)
		System.out.println("국어 : "); int 국어 = scanner.nextInt();
		System.out.println("영어 : "); int 영어 = scanner.nextInt();
		System.out.println("수학 : "); int 수학 = scanner.nextInt();
		//평균부터 계산. 소수점 없이 진행한다면 int로
		int 평균 = (국어+영어+수학)/3;
		// 점수에 따른 멘트 출력
		if(평균>=90) { //if스타트 //평균이 90점 이상이면
			//if중첩 
			if(국어==100) System.out.println("국어 우수");
			if(영어==100) System.out.println("영어 우수");
			if(수학==100) System.out.println("수학 우수");
		} //if엔딩 else if 시작
		else if(평균>=80) { //평균이 80점 이상이면
			if(국어>=90) System.out.println("국어 장려");
			if(영어>=90) System.out.println("영어 장려");
			if(수학>=90) System.out.println("수학 장려");
		} // else if 끝
		else {System.out.println("제시험");} //그외이면
		
		
	} // me
} // ce
