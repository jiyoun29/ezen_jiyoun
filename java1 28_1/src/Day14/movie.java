package Day14;

public class movie extends Thread { //day14_5_��Ƽ�÷��̾�

	static boolean stop = true; //����/���� ���� ����
	
	public void moivestop( boolean stop ) {

		this.stop = stop;
			if(stop) { //stop�� ture�϶�
				System.out.println("���� ��� ����");
			} else {System.out.println("���� ����");}		
	}
	
	@Override
		public void run() {
			while(stop) {
				System.out.println("���� ��� ��");
					try { Thread.sleep(1000); }
					catch(Exception e) {}
			}
	}
	
}
