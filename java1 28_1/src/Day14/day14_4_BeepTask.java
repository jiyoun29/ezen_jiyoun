package Day14;

import java.awt.Toolkit;

public class day14_4_BeepTask implements Runnable {
	//���ʵ��̶�� �������̽��κ��� ����
	
	//implements �� �ʼ� : ���� �߻� �޼ҵ带 ���� *******
		//���� ctrl space ����
	@Override
	public void run() { //�߻�
		//runnable�� �ִ� �������̽� �� run�޼ҵ带 �����Ѵ�.
		
		//�Ȱ��� ƩŶ
		Toolkit toolkit = Toolkit.getDefaultToolkit(); //1.��ü����
		
		//�ݺ��� ������
		
			for(int i = 0 ; i<5 ; i++ ) {
				
				toolkit.beep(); // �Ҹ�����
				try {
					Thread.sleep(500); //@ 0.5�ʸ� ���� 500 = 500�и���  //2. 5ȸ �ݺ�
					//�Ϲ� ���ܰ� ������ �߻��ϹǷ�  trycatch �ʤˤ� ����ó�� ������**
				} catch (Exception e) { } 
				
				
			}
		
	}
	
		
	
		
///////////////////////////////////////////////		
	
}
