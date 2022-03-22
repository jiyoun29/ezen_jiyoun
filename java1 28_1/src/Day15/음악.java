package Day15;

public class 음악 extends Thread {

	//run을 오버라이드
	@Override
	public void run() {
		
		while(true) { //음악 클래스 내 스레드가 실행 중
			System.out.println("음악 실행 중");
			
			//반복이 너무 빠르니 sleep을 이용해 느리게 만들기
			
		try {	
			Thread.sleep(500);
		} catch (Exception e) {}
			
		}
		
	}
	
}
