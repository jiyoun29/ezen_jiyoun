package Day15;

public class ThreadA extends Thread {
	
	//�ʵ�
	public boolean stop = false ; //���� �÷���
	public boolean work = true ; //�۾� ���� ���� �÷���
	
	
	//����ó��
	@Override
	public void run() {
		while(!stop) { //stop�� false�̸� ���� ����
			
			if(work) {
				System.out.println("ThreadA �۾� ����");
			} else { Thread.yield(); //�ٸ� �����忡�� �纸
				}
			
		}
	System.out.println("ThreadA ����");
		
		
		
	}

}
