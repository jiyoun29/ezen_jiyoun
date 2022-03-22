package Day14;

public class 호랑이소리 extends Thread {


	@Override
	public void run() {
		
		for(int i = 0 ; i<5 ; i++)
		System.out.println("어흥! "+i+"번");
			//너무 빠르니 예외처리묶어서 잠간 멈춤
		try { Thread.sleep(500);}
		catch (Exception e) { }
	}
	
	
}
