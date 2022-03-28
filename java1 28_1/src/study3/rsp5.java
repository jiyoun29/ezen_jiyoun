package study3;

import java.util.Random;
import java.util.Scanner;

public class rsp5 {

	public static void main(String[] args) {
		
		int me; int com; int game = 0; int mewin =0; int comwin=0;
		Scanner scanner = new Scanner(System.in);

	while(true) {
		System.out.println("-----가위바위보 게임을 시작합니다.-----");
		System.out.println("가위(0) 바위(1) 보(2)  ||  종료(3)"); me = scanner.nextInt();
		System.out.println("내가 낸 수 : "+me);

			//컴퓨터 랜덤
		Random random = new Random();
		com = random.nextInt(3);
		System.out.println("컴퓨터가 낸 수 : "+com);
	
		if(me == 3) {
		
			System.out.println("게임을 종료하였습니다. 게임 횟수 : "+game);
				if( mewin > comwin ) {System.out.println("승리자 : 플레이어");}
				else if( mewin < comwin ) {System.out.println("승리자 : 컴퓨터");}
				else {System.out.println("승리자 : 무승부");} break; }
			//break로 종료
		
		else if(me >=0 && me <= 2) {
		
			if( (me==0 && com==2 || (me==1 && com==0) || (me==2 && com==1) )) {
			System.out.println("플레이어 승리입니다."); mewin++; }
			
			else if((me==0 && com==0 || (me==1 && com==1) || (me==2 && com==2) )) {
			System.out.println("비겼습니다."); }
		
			else {System.out.println("컴퓨터 승리입니다."); comwin++; } game++;}

		else {System.out.println("컴퓨터의 승리입니다.");}
			
		
		} //while end
	} // main end
} // class end
