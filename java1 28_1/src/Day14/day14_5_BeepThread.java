package Day14;

import java.awt.Toolkit;

public class day14_5_BeepThread extends Thread { //���
									//��Ƽ������ Ŭ����
	
	//run�޼ҵ� �������̵�
		//4�� ����, ������
	@Override
	public void run() { //Thread�� �ִ� run�޼ҵ� ������[�������̵�]
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0 ; i<5 ; i++) {
			toolkit.beep();
			
			try {
			Thread.sleep(500);
			} catch (Exception e) {}
		}
		
		//ó���� : extend�� implemeants��
		
	}

}
