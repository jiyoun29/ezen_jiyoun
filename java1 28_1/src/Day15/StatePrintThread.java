package Day15;

public class StatePrintThread extends Thread { //598 ����
	
	//�ʵ�
	private Thread targetThread;
	
	//������
	public StatePrintThread( Thread targetThread) {
		this.targetThread = targetThread;
	}
	
	//����ó��
	public void run() {
		
		while(true) {
			Thread.State state = targetThread.getState();
			//���¸� �����شٰ� ��
			System.out.println("Ÿ�� ������ ���� : "+state);
			//������ ���� ����
				if(state == Thread.State.NEW) { //NRE : ������ ���� ����
					targetThread.start();
				}
			if (state == Thread.State.TERMINATED) { //TERMINATED : ������ ���� ����
				break;
			}
			try {
				//0.5�ʰ� �Ͻ�����
				Thread.sleep(500);
			} catch (Exception e) { }
		}
	}
}
