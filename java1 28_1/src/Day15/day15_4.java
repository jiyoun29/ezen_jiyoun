package Day15;

public class day15_4 {
	public static void main(String[] args) {
		//스레드에게 상속을 받았고 런너블은 구현해서 구현객체에 넣음?..
		
		/*12장 : 스레드
		 	코드 -> 파일 -> 프로세스[프로그램](@스레드를 가짐)
			목적 : 병렬 처리
				main메소드에 main스레드 포함
			사용방법
				1. Thread 클래스
				
				2. Runnable 인터페이스
			run 메소드 : 실제로 멀티 스레드의 실행코드
			
		*/ //음악	
		음악 m1 = new 음악();
		m1.start(); //run메소드를 실행 시킴 -> 스레드 실행

		// 예2) runnable 인터페이스를 이용한 병렬처리 객체 만들기
		채팅 c1 = new 채팅();
		Thread thread = new Thread( c1 );
		//인터페이스는 스타트 메소드를 가지고 있지 않음
		//그래서 스레드를 하나 더 만들어서 사용
		thread.start();
		//만들어서 이렇게 가져와서 쓰면 실행이 된다.
		
		//	예1) Thread 클래스를 이용한 병렬처리 객체 만들기

		while(true) {
			System.out.println("프로그램 작동 중");
			
			try {	
				Thread.sleep(500);
			} catch (Exception e) {}
			
		}
		
		
		
		
		
		
	}
}
