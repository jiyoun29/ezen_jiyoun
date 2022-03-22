package Day15;

public class StatePrintThread extends Thread { //598 예제
	
	//필드
	private Thread targetThread;
	
	//생성자
	public StatePrintThread( Thread targetThread) {
		this.targetThread = targetThread;
	}
	
	//병렬처리
	public void run() {
		
		while(true) {
			Thread.State state = targetThread.getState();
			//상태를 말해준다고 함
			System.out.println("타겟 스레드 상태 : "+state);
			//스레드 상태 제어
				if(state == Thread.State.NEW) { //NRE : 스레드 생성 상태
					targetThread.start();
				}
			if (state == Thread.State.TERMINATED) { //TERMINATED : 스레드 종료 상태
				break;
			}
			try {
				//0.5초간 일시정지
				Thread.sleep(500);
			} catch (Exception e) { }
		}
	}
}
