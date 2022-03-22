package Day15;

public class User1 extends Thread {
	//스레드 클래스에게 상속 받음
	
	
	//필드
	private Calculator calculator;
	
	public void setCalculator( Calculator calculator) {
		this.setName("user1");
		this.calculator = calculator;
		
	}

	
	//병렬처리
	@Override
	public void run() {
		calculator.setMemory(100);
	}
	
	
	
}
