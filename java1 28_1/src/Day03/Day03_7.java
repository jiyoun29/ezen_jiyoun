package Day03;

import java.util.Scanner;

public class Day03_7 {
	public static void main(String[] args) {
		//확인문제
		
		//공통변수 [어디서든 사용할 수 있는 변수]
		boolean run = true ; // 실행 여부 변수 / true=실행 false=종료
		int balance = 0; // 예금액[통장 안에 있는 금액] 변수 //여기가 통장(1번에서 올라옴)
		Scanner scanner = new Scanner(System.in); //입력객체
		
		//다른곳에서도 쓰려면 이 위치에 선택을 넣음. main 밖이나 class 밖도 가능(위의 3개) ->나중에는 빼낼수도 있으니 참고
		
		while ( run ) { //while (true) {} : 무한루프. 트루를 넣으면 무한루프가 된다.
			System.out.println("---------------------------");
			System.out.println("1.예금 2. 출금 3. 잔고 4. 종료");
			System.out.println("---------------------------");
			System.out.println("선택>"); int 선택 = scanner.nextInt();
			//입력 받은 값을 가져오기
			if (선택 == 1 ) { //만약에 입력값이 1이면
				System.out.print("예금액 : "); int 예금액 = scanner.nextInt();
				balance += 예금액; // 입력 받은 예금액을 통장에 넣기
			}
			else if (선택 == 2 ) { //만약에 입력값이 2이면
				System.out.println("출금액"); int 출금액 = scanner.nextInt();
				// 만약에 출금액이 예금액보다 더 크면 잔액부족. 아니면 출금 실행
				if(출금액 > balance ) {
					System.out.println("잔액이 부족합니다.");
				}
				else {
				balance -= 출금액; //입력 받은 출금액을 통장에서 빼기
				}
			}
			else if (선택 == 3 ) { //만약에 입력값이 3이면
				System.out.println("잔고 : " + balance );
			}
			else if (선택 == 4 ) { //만약에 입력값이 4이면
				break; //if가 아니라 while을 빠져나간다.[무한루프 종료]
			} else { //그외
				System.out.println("알 수 없는 번호");
			}
		}
		System.out.println("프로그램 종료");
		
	}

}
