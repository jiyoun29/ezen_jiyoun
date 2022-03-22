package Day15;

public class 채팅 implements Runnable {
	
	//추상은 오버라이드
	@Override
	public void run() {
			//병렬처리 실행
		while(true) { //채팅 클래스 내 스레드가 실행 중
			System.out.println("채팅 중");

			try {	
				Thread.sleep(500);
			} catch (Exception e) {}
		}
	}
	
}
