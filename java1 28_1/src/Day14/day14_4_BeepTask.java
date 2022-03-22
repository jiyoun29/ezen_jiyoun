package Day14;

import java.awt.Toolkit;

public class day14_4_BeepTask implements Runnable {
	//런너들이라는 인터페이스로부터 구현
	
	//implements 시 필수 : 사용시 추상 메소드를 구현 *******
		//사용시 ctrl space 누름
	@Override
	public void run() { //추상
		//runnable에 있는 인터페이스 내 run메소드를 구현한다.
		
		//똑같이 튜킷
		Toolkit toolkit = Toolkit.getDefaultToolkit(); //1.객체생성
		
		//반복문 돌리기
		
			for(int i = 0 ; i<5 ; i++ ) {
				
				toolkit.beep(); // 소리내기
				try {
					Thread.sleep(500); //@ 0.5초를 위해 500 = 500밀리초  //2. 5회 반복
					//일반 예외가 무조건 발생하므로  trycatch 필ㅛㅜ 예외처리 무조건**
				} catch (Exception e) { } 
				
				
			}
		
	}
	
		
	
		
///////////////////////////////////////////////		
	
}
