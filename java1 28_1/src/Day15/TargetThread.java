package Day15;

public class TargetThread extends Thread {
	//599
	
	//����ó��
	@Override
	private void run() { //������ ���� : new :��ü�� �����ǰ� ��Ƽ �����尡 ���� ��
		for(long i = 0 ; i<1000000000; i++) {
			//������ ���� : runnable ��Ƽ ������ ���� �ߤ�
		}
				//10�� �ݺ�
			try {
				//1.5�ʰ� �Ͻ� ���� (�и��� = 1000/1��)
				Thread.sleep(1500);
				//������ ���� : Waiting : ��Ƽ������ �Ͻ� ����
			} catch (Exception e) {		}
			
		for(long i = 0; i<1000000000; i++) {}
			//10�� �ݺ�
		//@�ð��� ���� ���� 10���� ������ ��
	}//run�޼ҵ尡 ����Ǹ� ������ ���� : Tearminated ��Ƽ������ ����
	
}
