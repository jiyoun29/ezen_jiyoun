package Day14;

public class day14_4_calThread extends Thread { 
	
	//��� ���� ���� ������ �����
	
	public day14_4_calThread(String name) {
		//�̸��� �޾Ƽ� �̸� ����
		setName(name); //�μ��� ���� �����ͷ� ������ �̸� ��
	}
	
	//��Ƽ������ ���� [ �������̵� ]
	@Override
	public void run() {
		
		for(int i =0 ; i<200000000 ; i++) { //2����� ����
			//������ ���ణ ���̸� Ȯ���ϱ� ���� 2��
		}
		//������ �����忡 �̸� Ȯ��
		System.out.println( "���� ���� ���� ������ �� : " + getName());
		
		
	}
	

}
