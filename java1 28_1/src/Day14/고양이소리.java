package Day14;

public class ����̼Ҹ� extends Thread {
//������ �Ҹ��� �����ϰ�
	
	@Override
	public void run() {
		
		for(int i = 0 ; i<5 ; i++)
		System.out.println("�߿�! "+i+"��");
			//�ʹ� ������ ����ó����� �ᰣ ����
		try { Thread.sleep(500);}
		catch (Exception e) { }
	}
	
	
}
