package Day15;

public class SumThread extends Thread {

	//�ʵ�
	private long sum;
	
	//�ʵ� ȣ��
	public long getsum() {
		return sum;
	}
	//�޼ҵ�
				//����
	public void setSum() {
		this.sum = sum;
	}

	//����ó��
	@Override
	public void run() {
		for (int i = 1 ; i<=100 ; i++) {
			sum+=i; //1���� 100���� �����հ�
		}
	}
	
	
}
