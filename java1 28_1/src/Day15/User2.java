package Day15;

public class User2 extends Thread {
	
	//필드
	private Calculator calculator;

	public void setCalculator() {
		this.setName("user2");
		this.calculator = calculator;
	}

	//병렬처리
	public void run() {
		calculator.setMemory(50);
	};
}
