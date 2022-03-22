package Day15;

public class ThreadA extends Thread {
	
	//필드
	public boolean stop = false ; //종료 플래그
	public boolean work = true ; //작업 진행 여부 플래그
	
	
	//병렬처리
	@Override
	public void run() {
		while(!stop) { //stop이 false이면 무한 루프
			
			if(work) {
				System.out.println("ThreadA 작업 내용");
			} else { Thread.yield(); //다른 스레드에게 양보
				}
			
		}
	System.out.println("ThreadA 종료");
		
		
		
	}

}
