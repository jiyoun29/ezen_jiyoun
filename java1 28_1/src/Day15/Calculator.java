package Day15;

public class Calculator {
	
	private int memory;
	
	//생성자
	public int getMemory() {
		return memory;
	}
	
	//메소드
	public void setMemory(int memory) {
		this.memory = memory;
		
		//받고 2초간 딜레이
		try {	
			Thread.sleep(2000);
		} catch (Exception e) {}

		
	}

}
