package study5;

import java.util.Random;
import java.util.Scanner;

public class ttt_1 {
	public static void main(String[] args) {
	
		// 삼목 게임
		// 1. 9칸 생성 : String[] 배열 = new String[9]
		// 2. 사용자에게 0~8 인덱스 번호 입력받기 : 해당 인덱스에 O 표시
		// 3. 컴퓨터는 0~8 사이 난수 발생 : 해당 인덱스에 X 표시
		// * 이미 둔 자리는 입력 불가능(2-3 둘다) 재입력.
		// 4. 승리판단 : 가로,세로,대각선 인덱스들의 모양이 모두 동일
			// 가로 : 012 345 678 . 세로 : 036 147 258 . 대각선 048 246
		
		Scanner scanner = new Scanner(System.in);
		
		//게임판 생성
		String[] 게임판 = { "[ ]" , "[ ]" , "[ ]" ,
						  "[ ]" , "[ ]" , "[ ]" ,
						  "[ ]" , "[ ]" , "[ ]" };	
		//String을 통하여 객체 9개를 저장할 수 있는 배열을 선언한다.
		//String[] = new String[9]가 안 되는 이유?
		
		String 승리알 = ""; //3목이 되면 저장한다.
		
		//승패가 난 후에도 다시 게임을 시작할 수 있도록 무한루프로 게임을 출력한다.
		while (true) { //종료조건 : 9칸 모두 알이 있거나 승리자가 나왔을 경우
			for(int i=0; i<9; i++) { //i 초기값을 0으로 지정하고 9보다 작을때까지 1개씩 증가한다.
				System.out.print(게임판[i]); //3의 배수마다 내려온다. %(나머지 찾기 함수)
				
				if(i%3 == 2) { //i를 3으로 나눴을 때 나머지가 2라면
					System.out.println(); //줄바꿈
				}
			} // for end
			
		//플레이어 위치를 선택한다.
			//루프를 열고 위치를 입력 받는다.
			while(true) { System.out.print("위치를 선택해주세요 : "); int 위치 = scanner.nextInt();
				if(게임판[위치].equals("[ ]")) { //선택한 위치가 공백이면 돌을 놓는다.
					게임판[위치] = "[O]"; break; //돌을 놓으면 멈추고 가장 가까이로 돌아간다.
				} else {System.out.println("이미 알이 있습니다. 다시 입력해주세요.");}
			} //while end
			
		//컴퓨터의 위치를 선택한다. 컴퓨터는 랜덤으로 돌을 놓는다.
			while(true) { Random random = new Random();
				int 위치 = random.nextInt(9); //0~8사이 숫자가 랜덤으로 발생한다.
				if(게임판[위치].equals("[ ]")) { //선택한 위치가 공백이면 돌을 놓는다.
					게임판[위치] = "[X]"; break; //돌을 놓으면 멈추고 가장 가까이로 돌아간다.
			} //end
		}//while end	
		// 승리 판단 여부를 기입한다.
		// 가로 : 012 345 678 . 세로 : 036 147 258 . 대각선 048 246			
			
				//가로
		for(int i = 0 ; i<6 ; i+=3) { //i는 0부터 6까지 3씩 증가한다.(0 3 6)
			if(게임판[i].equals(게임판[i+1]) && 게임판[i+1].equals(게임판[i+2])) {
				승리알 = 게임판[i];  // ??
			}
		}
			
				//세로
		for(int i = 0; i<=2; i++) { //i는 0부터 2까지 1씩 총 3회 증가
			if(게임판[i].equals(게임판[i+3]) && 게임판[i+3].equals(게임판[i+6])) {
				승리알 = 게임판[i]; //i에 3을 더한 것과 같거나 3이 더해진 판은 6을 더한 것과 같다.
			}
		}
			
				//대각선
		if(게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8])) {
			승리알 = 게임판[0]; // 대각선으로 놓았을 때 이기는 경우의 수를 기입한다.
		} else if(게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6])) {
			승리알 = 게임판[2]; //게임이 종료된다.
		}
		
		//승리 출력
		if(승리알.equals("[O]")) {System.out.println("플레이어가 승리하였습니다."); break;}
		if(승리알.equals("[X]")) {System.out.println("컴퓨터가 승리하였습니다."); break;}
		//각각 승리 멘트를 출력하고 break를 걸어 가장 가까운 반복문으로 빠져나가게 둔다.
		
	} //while end
		for(int i = 0 ; i<9 ; i++ ) {	System.out.print(게임판[i]);
		if( i % 3 == 2) { 	System.out.println(); }} 			
		
		
///////////////////////////////////////////////////
	} //main end
}
