package Day14;

public class 고양이소리 extends Thread {
//강아지 소리와 동일하게
	
	@Override
	public void run() {
		
		for(int i = 0 ; i<5 ; i++)
		System.out.println("야옹! "+i+"번");
			//너무 빠르니 예외처리묶어서 잠간 멈춤
		try { Thread.sleep(500);}
		catch (Exception e) { }
	}
	
	
}
