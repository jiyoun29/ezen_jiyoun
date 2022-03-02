package Day02;

import java.util.Scanner;

public class Day02_3 {
	
	public static void main(String[] args) {
		
		// 문제 1 : 급여 계산
		// * 입력 -> 저장 -> 계산 -> 출력
		// 1. 입력 객체 만든다.
		
		Scanner scanner = new Scanner(System.in);
		
		// 2. 입력 받은 값을 변수에 저장한다. [입력 객체는 입력 받을 때마다 기존 데이터가 사라짐]
		System.out.print("기본급 입력 : "); int 기본급 = scanner.nextInt();
							// 입력개체명.nextInt() : int형 데이터 가져오기
							// 입력개체명.next() : 문자열 데이터 가져오기
		System.out.print("수당 입력 : "); int 수당 = scanner.nextInt();
		
		// 3. 변수를 연산(계산)한다.
		int 세금 = (int)(기본급*0.1); // int*double 후에 int 형으로 강제변환(캐스팅)
		int 실수령액 = 기본급 + 수당 - 세금 ; // 100%=1 10%=0.1
		
		// 4. 출력한다.
		System.out.println("회원님의 수령액 : " + 실수령액);
						// 문자열 + 변수명 ( 변수 내 데이터 호출 )
						// + : 1. 연결연산자 가능 2. 더하기 가능
		
		
		
		
	}

}
