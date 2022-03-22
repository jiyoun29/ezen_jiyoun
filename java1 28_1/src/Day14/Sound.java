package Day14;

public class Sound extends Thread { //day14_5_멀티플레이어

	//				제어
	static boolean stop = true; //현재 재생인지 중지인지 실행여부 확인을 위함
		//true 시작 false 종료
	//@저장하고 싶으면 무조건 필드
	
	//boolean 앞에 static이 있으면 중지 되고 없으면 계속 진행
	//
	
	//사운드 생성자 만들고
	public void Soundstop ( boolean stop ) {
		this.stop = stop;
		if(this.stop) { System.out.println("소리 재생 시작"); }
		else {System.out.println("소리 재생 중지");}
	}
	
	
	//스레드 사용할때 기본으로 run 만들기
	@Override
	public void run() {
		
		//무한루프로 돌림
		while(this.stop) { System.out.println("소리가 재생 중");
		//stop 변수가 true이면 무한 루프 [ 종료 조건 : stop이 꺼지면(false) ]
		
			try { Thread.sleep(1000); } catch (Exception e) {}
		
		
		}
		
	}
	
	
}
