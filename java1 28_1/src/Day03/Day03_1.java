package Day03;

public class Day03_1 {

	public static void main(String[] args) {
		
		// 1일차: 출력, 입력
		// 2일차: 저장(변수), 계산(연산)
				
		// 제어문
			// 컴퓨터는 0,1(이진코드)만 알고 있다. 이 판단력을 키워주는 게 제어문.
			// 경우의 수를 따져서 실행
			// 직접 코드를 짤 때에는 경우의 수=IF 라고 생각하고 짤 것
			
			// 1000원을 주고 A편의점에서 콜라 사오기
				// A편의점에서 콜라를 구매한다.(1000원 초과일시 구매 불가. 1000원 이하일시 불가.)
				// 컴퓨터가 스스로 ()안을 판단하지 못함.
				// 따라서 '콜라가 1000원 이하이면 구매'가 제어문
				// A편의점 콜라가 1500이면 구매 X, B편의점 콜라가 900이면 구매O
				// IF(A편의점<=1000){구매}
				// ELSE IF(B편의점<=1000){구매}
				// ELSE{구매X}
			// 제어문은 경우의 수가 있을 때만 사용.(컴퓨터를 조금 더 똑똑하게)
			// 제어문은 조건식이 true 이면 실행문을 처리한다.
		
			// 형태
				// 1. IF( 조건식[true or false] ) 실행문 ; (;은 코드의 끝마침)
						// 안에는 사칙연산 x
				// 2. IF( 조건식 ) 실행문[참일때 실행] ;
						// ELSE 실행문[거짓일때 실행]
			// if를 만나면 갈림길이 생기는 것
				// 3. 실행문이 2줄 이상(;이 2개 이상) = {}로 묶음 처리
				// 4. 경우의 수가 다수일때 [조건이 다수일때]
					// if(조건1) {실행문[참1];} ***친해지기
					// else if(조건2) {실행문[참2];}
					// else if(조건3) {실행문[참3];}
					// else if(조건4) {실행문[참4];}
					// else {실행문[거짓];}
				// 5. if 중첩이 가능
					// if 안에 if가 또 들어간다.
					// if (조건식) {  if(조건식) 실행문; }
					// else { 실행문; }
					// }else{
					//  if(조건식){ 실행문; }
					// else{ 실행문; }
					// }
		
			// 예제1
			if(3>1) System.out.println("예1) 3이 1보다 크다."); //true
				// 만약에 3이 1보다 크다면 출력o. 아니면 출력x
			// 예제2
			if(3>5) System.out.println("예2) 3이 5보다 크다."); //false
				// 만약에 3이 5보다 크면 출력x. 아니면 출력o
			// 예제3
			if(3>1) System.out.println("예3_1) 3이 1보다 크다.");
			else System.out.println("예3_2) 3이 1보다 작다.");
				// 만약에 3이 1보다 크면 예3_1 출력
				// 아니면(3이 1보다 작으면) 예3_2 출력
			// 예제4
			if(3>1) { // true 실행문 시작 [ 실행문 ; 2개 이상일때 ]
				System.out.println("true");
				System.out.println("3이 2보다 크다."); } //true 실행문 끝
				// 시작과 끝을 스스로 판단하지 못하므로 {}로 2개 이상을 묶어준다.
			else { // false 실행믄 시작
				System.out.println("true");
				System.out.println("3이 2보다 작다.");
			} // false 실행문 끝
			// 예제5
			if(3>5) System.out.println("예5) 3이 5보다 크다"); //false
			else if(3>4) System.out.println("예5) 3이 4보다 크다"); //false
			else if(3>3) System.out.println("예5) 3이 3보다 크다"); //false
			else if(3>2) System.out.println("예5) 3이 2보다 크다"); //true
			else System.out.println("true 없다."); // 실행x
			// 묶음 1개로 취급 = 결과는 1개

			if(3>5) System.out.println("예5) 3이 5보다 크다"); //false
			if(3>4) System.out.println("예5) 3이 4보다 크다"); //false
			if(3>3) System.out.println("예5) 3이 3보다 크다"); //false
			if(3>2) System.out.println("예5) 3이 2보다 크다"); //true
			if(3>2) System.out.println("true 없다."); // 실행x
			// 모두 개별로 처리 = 결과가 다수로 나올 수 있음

	}
}
