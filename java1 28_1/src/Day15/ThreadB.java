package Day15;

public class ThreadB extends Thread {
	
	//606

	public boolean stop = false ; //���� �÷���
	public boolean work = true ; //�۾� ���� ���� �÷���

	
	@Override
	public void run() {
		while(!stop) { //stop�� false�̸� ���� ����
			
			if(work) {
				System.out.println("ThreadB �۾� ����");
			} else { Thread.yield(); //�ٸ� �����忡�� �纸
				}
			
		}
	System.out.println("ThreadA ����");
		
		
		
	}
	
}
