package Day03;

import java.util.Scanner;

public class Day03_4 {

	public static void main(String[] args) {
		
		// 제어문 : 1. if문 2. switch문 (용도는 같으나 아래와 같은 차이점이 있음)
			// if: 논리검사(true or false) 맞으면 실행. 아니면 실행 안함. / 경우의 수가 정해져 있지 않은 경우
				// 이상 이하(>= 등) 등등에 사용할 수 있으나 스위치는 안 됨
			// switch: 데이터 검사 / 경우의 수가 정해져 있는 경우(무조건 딱 떨어질 때 편리. 간결해서 속도가 더 빠르다.)
					// 동일한 case를 찾으면 실행문을 처리하나 그 후에 다음 case로 이동한다.
			// 형태
				// switch(검사대상) {
				// case '값' : 실행문; ->case는 여러개 입력 가능. break;를 옆에 달아야 검사대상에 일치하는 것에 스톱
				// default : 실행문; / (그 외)
				// } 닫음
			// 필수! break; : 가장 가까운 switch 혹은 반복문에서 탈출
		
		// 예1) 점수가 90점 이면 A, 80점이면 B, 70점이면 C. 그 외 탈락
		int 점수 = 80;
		if ( 점수 == 90)System.out.println("A");
		else if(점수 ==80)System.out.println("B");
		else if(점수 ==70)System.out.println("C");
		else System.out.println("탈락");
		// 위 코드를 스위치로 변경
		switch( 점수 ) {
		case 90 : System.out.println("A"); break; //여기에 브레이크 추가
		case 80 : System.out.println("B"); break; // if와 동일하게 이용할거면 break 추가. 아니면 제외
		case 70 : System.out.println("C"); break;
		default : System.out.println("탈락");		 break; }
		//실행 결과는 동일
		//if는 하나만. switch는 둘 다 출력함
		
		//예2
		int 버튼 = 3;
		switch(버튼) {
			case 1 : System.out.println("1층으로 이동"); break;
			case 2 : System.out.println("2층으로 이동"); break;
			case 3 : System.out.println("3층으로 이동"); break;
			case 4 : System.out.println("4층으로 이동"); break;
			default : System.out.println("정지"); }
		
		//예3 캐릭터-문자
		char 등급 = 'B';
		switch(등급) {
			case 'A' : // breake가 없으므로 a가 실행되면 b로 가서 우수회원 출력
			case 'B' : System.out.println("우수회원"); break;
			case 'C' : 
			case 'D' : System.out.println("일반회원"); break;
			default : System.out.println("손님");   	}
		
		//논리x선택조건이므로 이퀄스를 사용하지 않아도 직급이 과장인 걸 선택 가능
		//예4 스트링 문자열
		String 직급 = "과장";
		switch(직급) {
			case "부장" : System.out.println("700만원"); break;
			case "과장" : System.out.println("500만원"); break;
			default : System.out.println("300만원");			}
		
		// 문제1) switch 문제
		// 국영수 점수를 입력 받아 평균이 90점 이상이면 a 80점 이상이면 b 나머지는 탈락
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 : "); int 국어 = scanner.nextInt();
		System.out.print("영어 : "); int 영어 = scanner.nextInt();
		System.out.print("수학 : "); int 수학 = scanner.nextInt();
		int 평균 = (국어+영어+수학)/3;
		System.out.println("평균:"+평균 + "나누기/10" + 평균/10 ); //10의 자리만 가지고 1의 자리는 버리게 하기
		switch(평균/10) { //논리검사(이상이하초과미만) 못하므로 값을 넣기. 1의 자리수만 판단
			case 9 : System.out.println("A"); break;
			case 8 : System.out.println("B"); break;
			default : System.out.println("탈락");		}
		
		
	} // me
} //ce
