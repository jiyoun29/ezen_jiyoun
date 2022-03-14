package study5;

import java.util.Random;
import java.util.Scanner;

public class ttt_4 {

	// 삼목 게임
	// 1. 9칸 생성 : String[] 배열 = new String[9]
	// 2. 사용자에게 0~8 인덱스 번호 입력받기 : 해당 인덱스에 O 표시
	// 3. 컴퓨터는 0~8 사이 난수 발생 : 해당 인덱스에 X 표시
	// * 이미 둔 자리는 입력 불가능(2-3 둘다) 재입력.
	// 4. 승리판단 : 가로,세로,대각선 인덱스들의 모양이 모두 동일
		// 가로 : 012 345 678 . 세로 : 036 147 258 . 대각선 048 246

	public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
		//스캔

		String[] 게임판 = { "[ ]" , "[ ]" , "[ ]" ,
						  "[ ]" , "[ ]" , "[ ]" ,
						  "[ ]" , "[ ]" , "[ ]" };	
		// 3목 판을 만들고 승리알 String을 만들어둔다.		
		String 승리알 = ""; 

		while (true) { //반복문 시작
			for(int i=0; i<9; i++) { //i는 9보다 작고 1씩 증가한다.
				System.out.print(게임판[i]); 
				
				if(i%3 == 2) { //i를 3으로 나눴을 때 2가 남으면 줄을 바꾼다.
					System.out.println(); 
				}
			}//for end

//플레이어
			while(true) { System.out.print("위치를 선택해주세요 : "); int 위치 = scanner.nextInt();
				if(게임판[위치].equals("[ ]")) { //플레이어의 위치값을ㄹ 입력 받고, 입력한 위치가 []와 같으면
					게임판[위치] = "[O]"; break;  //플레이어의 말인 O를 받아 넣고 끝낸다.
				} else {System.out.println("이미 알이 있습니다. 다시 입력해주세요.");} //만일 []과 같지 않을 경우
			} 
			
//컴퓨터
			while(true) { Random random = new Random(); //랜덤으로 0~8의 숫자를 받는다.
				int 위치 = random.nextInt(9); 
				if(게임판[위치].equals("[ ]")) { 	게임판[위치] = "[X]"; break; 
				//플레이어와 마찬가지로 []가 맞을 경우에만 컴퓨터 값인 X를 넣는다.
			} 
		}
///////////////////////////////////////
			//승리판단
			
			//가로
		for(int i = 0 ; i<6 ; i+=3) { // 0 3 6의 가로칸
			if(게임판[i].equals(게임판[i+1]) && 게임판[i+1].equals(게임판[i+2])) {
				승리알 = 게임판[i]; 
			}
		}
			
			//세로	
		for(int i = 0; i<=2; i++) { // 0 1 2의 세로칸
			if(게임판[i].equals(게임판[i+3]) && 게임판[i+3].equals(게임판[i+6])) {
				승리알 = 게임판[i]; 
			}
		}
			
			//대각선 (가장 이해 안 된다....)
		if(게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8])) {
			승리알 = 게임판[0]; 
		} else if(게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6])) {
			승리알 = 게임판[2]; 
		}
		
//승리 여부에 따른 멘트를 송출한다.
		if(승리알.equals("[O]")) {System.out.println("플레이어가 승리하였습니다."); break;}
		if(승리알.equals("[X]")) {System.out.println("컴퓨터가 승리하였습니다."); break;}
		
		
	} //while end
	
		//맨 위에 있던 게임판을 다시 가져온다.
		for(int i = 0 ; i<9 ; i++ ) {	System.out.print(게임판[i]);
		if( i % 3 == 2) { 	System.out.println(); }} 			
		
		
		
///////////////////////////////////////////////////
	}
}
