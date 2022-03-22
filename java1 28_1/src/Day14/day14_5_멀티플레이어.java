package Day14;

import java.util.Scanner;

public class day14_5_멀티플레이어 {
	
	//예제 1. 소리재생/중지 2. 영상 재생/중지
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //입력객체
		
		//꺼져잇는지 켜져있는지 체크를 해야함
		boolean soundsw = true;
		//		상태
		
		boolean moviesw = true;
		//상태 확인
		
		
		while (true) {
			System.out.println("1.소리재생 2.영상재생");
			int ch = scanner.nextInt();
			//받음
			
			//조건 : 소리 or 영상이 재생시 다시 한 번 누르면 중지로 만들기
				if(ch == 1) { //첫작동시 true

					Sound sound = new Sound(); //빈객체 생성
					//지역변수라 중괄호 밖으로 못나가니 같이 슬거면 여기서 입력

					// 소리가 도느냐에 대한 stop
					if(soundsw) { // ==true
						sound.Soundstop(true);
						sound.start();
						
						//sound.stop = false; //소리 종료
						//stop 필드에 직접 변경시 ->바로 종료 되므로 1번 누를때만 종료하도록
						
						soundsw = false; //소리 종료 //실행 중 상태 기록
					}
					else { // ==false
						sound.Soundstop(false);
						//sound.stop = true; //소리재생
						soundsw = true; //실행 종료로 기록
					}
					
				}
				else if (ch == 2) {
					
					movie movie = new movie();
						if(moviesw) {
							movie.moivestop(true); //제어 변경
							movie.start(); //스레드 실행
							moviesw = false; //상태변경
						}
						else { movie.moivestop(false); //제어 변경
						moviesw = true; //상태 변경
						
						}
					
					
					
					
				}
			
			
		}
		
		
		
		
	}

}
