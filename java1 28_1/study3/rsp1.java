package study3;

//1. 가위0바위1보2 중에 선택
	// 2. 컴퓨터 난수 발생 0~2
	// 3. 사용자와 컴퓨터 중 승리자 판단 [ 경우의 수 (이김.짐.비김.) ]
	// 4. 3번 선택하기 전까지 게임 실행
	// 5. 3번 선택시 1) 총 게임 수 (n판) 2) 최종 승리(컴퓨터n 사람n) = 출력

import java.util.Random;
import java.util.Scanner;

public class rsp1 {
	
	public static void main(String[] args) {

		//숫자를 저장할 수 있는 객체를 만든다.
		int me; //내가 선택한 수
		int com; //컴퓨터의 수
		int game =0; //진행된 게임의 수. 초기값은 0
		int mewin = 0; int comwin =0; //각각의 승리 수. 초기값은 0
	
	Scanner scanner = new Scanner(System.in);
	//읽을 수 있는 스캐너를 생성한다.

	//실행
	while(true) { System.err.println("가위바위보 게임을 시작합니다.");
		//3번 진행하면 break로 끝낸다.
	
		//플레이어가 먼저 선택한다.
		System.out.println("가위(0) 바위(1) 보(2)\t 종료(3) \n선택 : ");
		me = scanner.nextInt(); //플레이어 값을 저장한다.
		System.out.println("내가 낸 수 : "+me);
		
		//그 다음 컴퓨터 값을 랜덤으로 출력한다.
		Random random = new Random(); //난수 객체 선언
		com = random.nextInt(3); // 0부터 세므로 3까지 해야 2까지 선언 된다.
		System.out.println("컴퓨터가 낸 수 : "+com); //컴퓨터의 값을 보여준다.
		
		//플레이어의 선택지에 따라 출력문을 만든다.
		if(me == 3) { System.out.println("게임을 종료합니다.\n게임 횟수 :"+game);
				//플레이어가 승리하였을 경우
					if( mewin > comwin ) System.out.println("승리자 : 플레이어");
				//컴퓨터가 승리하였을 경우
					else if( mewin < comwin ) System.out.println("승리자 : 컴퓨터");
				//두가지가 동일할 경우
					else System.out.println("승리자 : 무승부");
					break; } //종료한다.
		//승부에 대해서 출력한다. 내가 낸 값이 0과 같거나 큼, 또는 2와 같거나 작으면?
		else if( me >=0 && me <=2 ) {
		//가위0바위1보2 값을 계산하여 if식 생성
			if( (me==0 && com==2 || (me==1 && com==0) || (me==2 && com==1) )) {
				//플레이아의 승리 : -1, 2
				System.out.println("플레이어 승리입니다."); mewin++;
			} //값이 0이라 비겼을 경우
			else if((me==0 && com==0 || (me==1 && com==1) || (me==2 && com==2) )) {
				System.out.println("비겼습니다.");
				//그 외의 값은 컴퓨터의 승리이다.
			} else {System.out.println("컴퓨터 승리입니다."); comwin++; } game++;
		} else {System.out.println("컴퓨터의 승리입니다.");}



		} //while end
	} // me
}
