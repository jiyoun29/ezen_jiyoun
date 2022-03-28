package study3;

import java.util.Random;
import java.util.Scanner;

public class rsp2 {
	public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
		
	int me; int com; int game = 0; int mewin = 0; int comwin = 0;
		
	while(true) { System.out.println("가위바위보 게임을 시작합니다.");
		System.out.println("가위(0) 바위(1) 보(2)     종료(3)\n선택 : ");
		me = scanner.nextInt(); //내가 낸 값을 저장
		System.out.println("내가 낸 수 : "+me);

	Random random = new Random();
	com = random.nextInt(3);
		System.out.println("컴퓨터가 낸 수 : "+com);
	
		// 선택지
		// 내가 종료를 선택하였을 경우
		if(me==3) {	System.out.println("게임을 종료합니다.\n게임횟수 : "+game);
		//값에 따라 승패를 입력
		if( mewin > comwin ) System.out.println("승리자 : 플레이어");
		else if( mewin < comwin ) System.out.println("승리자 : 컴퓨터");
		else System.out.println("승리자 : 무승부");break; }
		
		else if( me>=0 && me<=2 ) {
			//2, -1
			if((me==0 && com==2 || (me==1 && com==0) || (me==2 && com==1) ))
			{System.out.println("플레이어 승리입니다."); mewin++; }
			//비긴 경우
			else if((me==0 && com==0 || (me==1 && com==1) || (me==2 && com==2) ))
				{System.out.println("비겼습니다.");}
			else {System.out.println("컴퓨터 승리입니다."); comwin++; } game++;
			} else {System.out.println("컴퓨터의 승리입니다.");}

		
	} //while end
		
/////////////////////////////		
	}

}
