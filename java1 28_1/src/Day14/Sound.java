package Day14;

public class Sound extends Thread { //day14_5_��Ƽ�÷��̾�

	//				����
	static boolean stop = true; //���� ������� �������� ���࿩�� Ȯ���� ����
		//true ���� false ����
	//@�����ϰ� ������ ������ �ʵ�
	
	//boolean �տ� static�� ������ ���� �ǰ� ������ ��� ����
	//
	
	//���� ������ �����
	public void Soundstop ( boolean stop ) {
		this.stop = stop;
		if(this.stop) { System.out.println("�Ҹ� ��� ����"); }
		else {System.out.println("�Ҹ� ��� ����");}
	}
	
	
	//������ ����Ҷ� �⺻���� run �����
	@Override
	public void run() {
		
		//���ѷ����� ����
		while(this.stop) { System.out.println("�Ҹ��� ��� ��");
		//stop ������ true�̸� ���� ���� [ ���� ���� : stop�� ������(false) ]
		
			try { Thread.sleep(1000); } catch (Exception e) {}
		
		
		}
		
	}
	
	
}
