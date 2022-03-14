package study5;

import java.util.Random;
import java.util.Scanner;

public class ttt_2 {

	// 삼목 게임
	// 1. 9칸 생성 : String[] 배열 = new String[9]
	// 2. 사용자에게 0~8 인덱스 번호 입력받기 : 해당 인덱스에 O 표시
	// 3. 컴퓨터는 0~8 사이 난수 발생 : 해당 인덱스에 X 표시
	// * 이미 둔 자리는 입력 불가능(2-3 둘다) 재입력.
	// 4. 승리판단 : 가로,세로,대각선 인덱스들의 모양이 모두 동일
		// 가로 : 012 345 678 . 세로 : 036 147 258 . 대각선 048 246
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		//객체를 읽을 scanner을 출력한다.
		
	
		String[] 게임판 = { "[ ]" , "[ ]" , "[ ]" ,
						  "[ ]" , "[ ]" , "[ ]" ,
						  "[ ]" , "[ ]" , "[ ]" };	
		//게임판을 생성한다.

		String 승리알 = "";

		//반복문을 생성한다. 
		while (true) { //i는 0이고 9가 되기 전까지 1씩 증가한다. 게임판의 인수는 i이다.
			for(int i=0; i<9; i++) { System.out.print(게임판[i]); 
			//입력값 i를 3으로 나눴을 때 2로 떨어지면 줄을 바꿔서 진행한다.
				if(i%3 == 2) {  System.out.println(); 	}}  //반드시 이 syso를 이용해서 줄바꿈을 해야하는지?

			while(true) { System.out.print("위치를 선택해주세요 : ");
			int 위치 = scanner.nextInt();
			//반복문 안의 반복문. 게임의 진행을 위한 위치를 선택하고 입력값을 저장한다.
				if(게임판[위치].equals("[ ]"))
			// 만일 게임판에 집어넣은 위치가 [ ]와 같으면 [O]를 넣고 끝낸다. 
				{  게임판[위치] = "[O]"; break; }
			//[ ]와 같지 않으면=비어있지 않으면 다음 문구를 출력한다.
				else {System.out.println("이미 알이 있습니다. 다시 입력해주세요.");} }

			//새로운 반복문. 이번에는 컴퓨터의 값을 입력 받는다.
			while(true) { Random random = new Random();	int 위치 = random.nextInt(9); 
			//컴퓨터의 값은 랜덤으로 총 9개(0~8)를 받는다.
				if(게임판[위치].equals("[ ]")) { 게임판[위치] = "[X]"; break; }
				// 만일 게임판에 집어넣은 위치가 [ ]와 같으면 [X]를 넣고 끝낸다. 
			}
	
			//승리를 만든다.
			//3씩 증가한다.
			for(int i = 0 ; i<6 ; i+=3) {
				if(게임판[i].equals(게임판[i+1]) && 게임판[i+1].equals(게임판[i+2])) {
					승리알 = 게임판[i];  } }
	
			//1씩 증가한다.
			for(int i = 0; i<=2; i++) { 
				if(게임판[i].equals(게임판[i+3]) && 게임판[i+3].equals(게임판[i+6])) {
					승리알 = 게임판[i]; } }
			
			//2씩 줄어든다.
			if(게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8])) {
				승리알 = 게임판[0]; }
			else if(게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6])) {
				승리알 = 게임판[2]; }
			
	
			if(승리알.equals("[O]")) {System.out.println("플레이어가 승리하였습니다."); break;}
			if(승리알.equals("[X]")) {System.out.println("컴퓨터가 승리하였습니다."); break;}
			
			
			
	} //가장 큰 while문이 끝난다. 

		for(int i = 0 ; i<9 ; i++ ) {	System.out.print(게임판[i]);
		if( i % 3 == 2) { 	System.out.println(); }} 			
			
		
		
///////////////////////////////////////////////////////////		
	}
}
