package Day15;

public class User2 extends Thread {
	
	//�ʵ�
	private Calculator calculator;

	public void setCalculator() {
		this.setName("user2");
		this.calculator = calculator;
	}

	//����ó��
	public void run() {
		calculator.setMemory(50);
	};
}
