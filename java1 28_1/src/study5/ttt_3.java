package study5;

import java.util.Random;
import java.util.Scanner;

public class ttt_3 {

	// 삼목 게임
	// 1. 9칸 생성 : String[] 배열 = new String[9]
	// 2. 사용자에게 0~8 인덱스 번호 입력받기 : 해당 인덱스에 O 표시
	// 3. 컴퓨터는 0~8 사이 난수 발생 : 해당 인덱스에 X 표시
	// * 이미 둔 자리는 입력 불가능(2-3 둘다) 재입력.
	// 4. 승리판단 : 가로,세로,대각선 인덱스들의 모양이 모두 동일
		// 가로 : 012 345 678 . 세로 : 036 147 258 . 대각선 048 246
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		//1. 게임판을 만든다.
		String[] 게임판 = {"[ ]" , "[ ]" , "[ ]" ,
					     "[ ]" , "[ ]" , "[ ]" ,
				         "[ ]" , "[ ]" , "[ ]" };
		// [] = 배열
		String 승리알 = ""; //3목이 되면 저장한다.
		
		//true 반복문을 생성한다.
		
	while(true) { //종료 조건을 만든다. 9칸 모두 알이 있거나 승리자가 나왔을 경우.
		for(int i = 0; i<9; i++) {
			System.out.print(게임판[i]); 
			if(i%3 == 2) {System.out.println();}
			//i를 3으로 나눴을 때 나머지가 2와 같다면 줄을 바꾼다.
		} //for end
		
		//2. 플레이어의 입력값
		while(true) { System.out.print("위치를 선택해주세요."); int 위치 = scanner.nextInt();
			if(게임판[위치].equals("[ ]")) { 게임판[위치] = "[O]"; break;}
			
			else {System.out.println("이미 알이 있습니다. 다시 입력해주세요.");}
			
			//선택한 위치가 [ ]와 같을 때 O를 넣고 반복문으로 빠져나간다.
		}// 플레이어while end		
		
		//3. 컴퓨터의 입력값
		while(true) { Random random = new Random(); int 위치 = scanner.nextInt(9);
		//랜덤으로 값을 받는다. 위치는 랜덤 0~8 숫자 중 하나이다.
			// 단 값을 놓는 조건
			if(게임판[위치].equals("[ ]")) { 게임판[위치] = "[X]"; break; }
			//위치가 [ ] 와 같을 때 X를 채우고 다음 반복문으로 빠져나간다.
		}//컴퓨터while end
		
		
		
		// 가로 : 012 345 678 . 세로 : 036 147 258 . 대각선 048 246			
		//4. 승리 조건
			//3씩 증가하고, 1씩 증가하고, 2씩 감소한다.
		
		//3씩 증가하는 가로
			for(int i =0; i<6; i+=3) {
				//0부터 6까지 3씩 증가한다.(036)
				if(게임판[i].equals(게임판[i+1]) 
						&& 게임판[i+1].equals(게임판[i+2])) {
					승리알 = 게임판[i];
				}
			}
		

		//1씩 증가하는 세로
			for(int i =0; i<=2; i+=1) {
				//0부터 2까지 1씩 증가한다.(345)
				if(게임판[i].equals(게임판[i+3]) 
						&& 게임판[i+3].equals(게임판[i+6])) {
					승리알 = 게임판[i];
				}
			}	
		
		//2씩 감소하는 대각선
			//for을 사용하지 않는다.
			
			if(게임판[0].equals(게임판[4])
					&& 게임판[4].equals(게임판[8])) {
				승리알 = 게임판[0];
			} //???
			else if(게임판[2].equals(게임판[4])
					&& 게임판[4].equals(게임판[6])) {
				승리알 = 게임판[2];
			}
			
			
			
		
		//승리 문구를 출력한다.
		if(승리알.equals("[O]")) {System.out.println("플레이어가 승리하였습니다."); break;}
		if(승리알.equals("[X]")) {System.out.println("컴퓨터가 승리하였습니다."); break;}
		
		
		
	} //while end
	
	
	
	for(int i = 0 ; i<9 ; i++ ) {	System.out.print(게임판[i]);
	//i가 0이고 9보다 작으며 1씩 증가한다. 게임판 i를 호출하고 3으로 나눴을 때 2가 남으면 줄바꿈.
		if( i % 3 == 2) { 	System.out.println(); } } 	
	
	
	
	
	
	
		
		////////////////////////////////////////
	}
}
