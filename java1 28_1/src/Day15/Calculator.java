package Day15;

public class Calculator {
	
	private int memory;
	
	//������
	public int getMemory() {
		return memory;
	}
	
	//�޼ҵ�
	public void setMemory(int memory) {
		this.memory = memory;
		
		//�ް� 2�ʰ� ������
		try {	
			Thread.sleep(2000);
		} catch (Exception e) {}

		
	}

}
