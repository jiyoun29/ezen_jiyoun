package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day4_3 {
	public static void main(String[] args) {
	
	// 가위바위보 게임
	// 1. 가위0바위1보2 중에 선택
	// 2. 컴퓨터 난수 발생 0~2
	// 3. 사용자와 컴퓨터 중 승리자 판단 [ 경우의 수 (이김.짐.비김.) ]
	// 4. 3번 선택하기 전까지 게임 실행
	// 5. 3번 선택시 1) 총 게임 수 (n판) 2) 최종 승리(컴퓨터n 사람n) = 출력

		// 가위바위보 게임 -------------------------------------------------------
		
		// 공통변수 먼저 생성
		int 플레이어; // 사용자가 선택한 수
		int 컴퓨터; // 컴퓨터가 생성한 난수를 저장
		int 게임횟수=0; // 총 가위바위보 실행 횟수 저장. 초기값 0 지정
		int 플레이어승리수=0;	int 컴퓨터승리수=0; //각각 승리 횟수 저장. 초기값 0 지정
		Scanner scanner = new Scanner(System.in); //입력 객체
		
		//프로그램 실행 
		while(true) { // 무한루프. 종료 조건은 3번 입력 시. break로 끝낼 것.
			System.out.println("----------------가위바위보----------------");
			
			//플레이어 입력
			System.out.println("가위(0) 바위(1) 보(2)       종료(3)   선택 : ");
			플레이어 = scanner.nextInt(); //플레이어 선택 값을 저장
			System.out.println(" 플레이어가 낸 수 : " + 플레이어 );
			
			
			//컴퓨터 입력
			//ra로 자동완성 랜덤 생성 (import 생성 되면 쓸 수 있는 것
			Random random = new Random(); // 난수 객체를 선언
					// random.nextInt() : int가 표현할 수 있는 범위 내 난수 발생
					// random.nextInt(수)+시작번호 : 0~수까지 범위 내 난수 발생
					// random.nextInt(10) : 0~9까지 범위 내 난수 발생
					// random.nextInt(10)+1 : 0~10까지 범위 내 난수 발생
			
			
			컴퓨터 = random.nextInt(3); //난수 집어넣기. nextInt를 이용해 정수로만 가져옴.
				// 랜덤으로 숫자 3개를 가져온다는 뜻.
					System.out.println("컴퓨터가 낸 수 : " + 컴퓨터);
					
					//종료조건
			if(플레이어 == 3) { //3을 누르면 종료가 되면서 게임 횟수와 최종 승리자가 나온다.
				System.err.println("게임 종료");
				System.out.println("게임 횟수 : " + 게임횟수);
				
				
				if(플레이어승리수 > 컴퓨터승리수) System.err.println("최종 승리자 : 플레이어" );
				else if(플레이어승리수 < 컴퓨터승리수) System.out.println("최종 승리자 : 컴퓨터");
				else System.out.println("최종 승리 : 무승부");
				break;
				
				// 각자 승리수 비교에 따라 승리자 선정 후  break로 멈춤 ->break의 이유?
				
			} else if( 플레이어 >=0 && 플레이어 <=2 ) {//정상 입력
				// 플레이어 값이 0보다 크거나 같거나, 플레이어 값이 2보다 작거나 같을 때.
				
				// 승리 판단
				if( (플레이어==0 && 컴퓨터==2 || (플레이어==1 && 컴퓨터==0) || (플레이어==2 && 컴퓨터==1) )) {
					//플레이어가 승리하는 경우의 수 (-1, 2)
					System.err.println("플레이어가 승리하였습니다.");
					// 이겼으므로 플레이어 승리 수 증가
					
					플레이어승리수++;	} 	
				else if( (플레이어==0 && 컴퓨터==0 || (플레이어==1 && 컴퓨터==1) || (플레이어==2 && 컴퓨터==2) ) ) {
					// 비기는 수 (값이 0일때)
					System.err.println("비겼습니다.");	}
				
				
				else { // 컴퓨터 승리 
					System.err.println("컴퓨터가 승리하였습니다."); 	
					컴퓨터승리수++; }
				
				게임횟수++;
				
			} else {
				System.out.println( "알림) 컴퓨터 승리 ");
			}
			
		} //while end
		
		
		// -------------------------------------------------------------------
		
	} // m e
} // c e
