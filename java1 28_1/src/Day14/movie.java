package Day14;

public class movie extends Thread { //day14_5_멀티플레이어

	static boolean stop = true; //실행/종료 제어 역할
	
	public void moivestop( boolean stop ) {

		this.stop = stop;
			if(stop) { //stop이 ture일때
				System.out.println("영상 재생 시작");
			} else {System.out.println("영상 종료");}		
	}
	
	@Override
		public void run() {
			while(stop) {
				System.out.println("영상 재생 중");
					try { Thread.sleep(1000); }
					catch(Exception e) {}
			}
	}
	
}
