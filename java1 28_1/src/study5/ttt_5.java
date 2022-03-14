package study5;

import java.util.Random;
import java.util.Scanner;

public class ttt_5 {

	// 삼목 게임
	// 1. 9칸 생성 : String[] 배열 = new String[9]
	// 2. 사용자에게 0~8 인덱스 번호 입력받기 : 해당 인덱스에 O 표시
	// 3. 컴퓨터는 0~8 사이 난수 발생 : 해당 인덱스에 X 표시
	// * 이미 둔 자리는 입력 불가능(2-3 둘다) 재입력.
	// 4. 승리판단 : 가로,세로,대각선 인덱스들의 모양이 모두 동일
		// 가로 : 012 345 678 . 세로 : 036 147 258 . 대각선 048 246
	

	public static void main(String[] args) {

		
	Scanner scanner = new Scanner(System.in);
		
		//게임판
		String[] 게임판 = { "[ ]" , "[ ]" , "[ ]" ,
						  "[ ]" , "[ ]" , "[ ]" ,
						  "[ ]" , "[ ]" , "[ ]" };	
		String 승리알 = ""; //3목이 되면 저장
		
		while (true) { //9칸 모두 알이 있거나 승리자가 나오면 종료.
			for(int i=0; i<9; i++) { System.out.print(게임판[i]);
			//i는 0부터 시작하고 9가 되기 전까지 1씩 증가한다.			
				if(i%3 == 2) { //i를 3으로 나눴을 때 나머지가 2일 경우
					System.out.println(); } //줄바꿈 한다.
			} // for end
			
			
		//플레이어
			//루프를 열고 위치를 입력 받는다.
			while(true) { System.out.print("위치를 선택해주세요 : "); int 위치 = scanner.nextInt();
				if(게임판[위치].equals("[ ]")) { //선택한 위치가 공백이면 돌을 놓는다.
					게임판[위치] = "[O]"; break; //돌을 놓으면 멈추고 가장 가까이로 돌아간다.
				} else {System.out.println("이미 알이 있습니다. 다시 입력해주세요.");}
			} //while end
			
		//컴퓨터 위치
			while(true) { Random random = new Random();	int 위치 = random.nextInt(9); //0~8사이
				if(게임판[위치].equals("[ ]")) { //선택한 위치가 공백이면 돌을 놓는다.
					게임판[위치] = "[X]"; break; //돌을 놓으면 멈추고 가장 가까이로 돌아간다.
			} //이미 알있다고 표현하지 않는다.
		}//while end	
			
			
			
			
		// 승리 판단
		// 가로 : 012 345 678 . 세로 : 036 147 258 . 대각선 048 246			
			
			
				//가로 0 3 6
		for(int i = 0 ; i<6 ; i+=3) { 
			if(게임판[i].equals(게임판[i+1])
					&& 게임판[i+1].equals(게임판[i+2])) {
				승리알 = 게임판[i];  // ??
			}
		}
			
				//세로 0 1 2
		for(int i = 0; i<=2; i++) { if(게임판[i].equals(게임판[i+3])
				&& 게임판[i+3].equals(게임판[i+6])) {
				승리알 = 게임판[i]; 
			}
		}
			
				//대각선 2 0 -2
		if(게임판[0].equals(게임판[4])
				&& 게임판[4].equals(게임판[8])) {
			승리알 = 게임판[0]; 
		}
		
		else if(게임판[2].equals(게임판[4])
				&& 게임판[4].equals(게임판[6])) {
			승리알 = 게임판[2]; 
		}
		
		//승패 출력
		if(승리알.equals("[O]")) {System.out.println("플레이어가 승리하였습니다."); break;}
		if(승리알.equals("[X]")) {System.out.println("컴퓨터가 승리하였습니다."); break;}

		
	} //while end
		for(int i = 0 ; i<9 ; i++ ) {	System.out.print(게임판[i]);
		if( i % 3 == 2) { 	System.out.println(); }} 			
		
		
		
///////////////////////////////////////////////////////////
	}
}
