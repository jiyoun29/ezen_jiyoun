package Day15;

public class ���� extends Thread {

	//run�� �������̵�
	@Override
	public void run() {
		
		while(true) { //���� Ŭ���� �� �����尡 ���� ��
			System.out.println("���� ���� ��");
			
			//�ݺ��� �ʹ� ������ sleep�� �̿��� ������ �����
			
		try {	
			Thread.sleep(500);
		} catch (Exception e) {}
			
		}
		
	}
	
}
