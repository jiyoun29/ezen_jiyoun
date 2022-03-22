package Day15;

public class TargetThread extends Thread {
	//599
	
	//병렬처리
	@Override
	private void run() { //스레드 상태 : new :객체가 생성되고 멀티 스레드가 실행 전
		for(long i = 0 ; i<1000000000; i++) {
			//스레드 상태 : runnable 멀티 스레드 실행 중ㄴ
		}
				//10억 반복
			try {
				//1.5초간 일시 정지 (밀리초 = 1000/1초)
				Thread.sleep(1500);
				//스레드 상태 : Waiting : 멀티스레드 일시 정지
			} catch (Exception e) {		}
			
		for(long i = 0; i<1000000000; i++) {}
			//10억 반복
		//@시간을 벌기 위해 10억을 돌리는 듯
	}//run메소드가 종료되면 스레드 상태 : Tearminated 멀티스레드 종료
	
}
