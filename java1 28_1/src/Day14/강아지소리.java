package Day14;

public class 강아지소리 extends Thread { //상속

	//재정의
	
	@Override
	public void run() {
		
		for(int i = 0 ; i<5 ; i++)
		System.out.println("멍멍! "+i+"번");
			//너무 빠르니 예외처리묶어서 잠간 멈춤
		try { Thread.sleep(500);}
		catch (Exception e) { }
	}
	
	
}
