package Day15;

import java.awt.Toolkit;

public class day15_7 {
	public static void main(String[] args) {
		
		/*601 ������ ����
			1. Thread.sleep() : �־��� �ð����� �Ͻ� ����
				�ð� ���� : �и���(1000/1��)
				�Ϲ� ���� �߻� : �Ͻ� ���� ���¿��� �־��� �ð��� �Ǳ� ���� interrupted(����)�� �߻��Ͽ��� �� �̸� ó�� �ڵ带 �־���� ��
			2. Thread.yield() : �ٸ� �����忡�� ���� �纸 [ ��� ���� ]
			3. �ٸ� �������� ���Ḧ ��ٸ� [ �ٸ� �����尡 ����� ������ �Ͻ� ���� ���� ���� ]
		*/
		
		
		//602 sleep ����		
		//@�Ҹ����°�
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//			for(int i = 0 ; i<10 ; i++) {
//				toolkit.beep();
//				//�Ҹ��� �� �� �̻� �۵��ϱ� ���� for���� ����
//				
//				//�Ͻ����� �ֱ� (����ó�� �ʾ�)
//				try {	Thread.sleep(3000);
//				} catch (Exception e) {			}
//			}
//			
		
		
		
//		
//		
//		//604~606 yield ����
//			
//			//1. ��ü ����
//			ThreadA threadA = new ThreadA();
//			ThreadB threadB = new ThreadB();
//			
//			//2. ������ ����
//			threadA.start();
//			threadB.start();
//			
//			//3. ������ �Ͻ� ����
//			try { Thread.sleep(3000); }
//			catch (Exception e) {}
//			
//			//4. ������a�� work�� ����
//			threadA.work = false; // Thread.yield() //�纸
//						
//			//3. ������ 3�ʰ� �Ͻ� ����
//			try { Thread.sleep(3000); }
//			catch (Exception e) {}
//			
//			//4. ������a�� work�� ���� (true������ �ٲ����Ƿ� �Ͻ������� ����)
//			threadA.work = true;
//			
//			//3. ������ 3�ʰ� �Ͻ� ����
//			try { Thread.sleep(3000); }
//			catch (Exception e) {}
//			
//			//5.������ a b ����
//			threadA.stop = true;
//			threadB.stop = true;
//			
//			//6. ����x
////			threadA.stop(); ->�������� �ʴ� �޼ҵ�
//			//�����尡 ���� �Ǵ� ���߿� ���ڱ� ���� ��
//			
			
			
			
			
			
			//607 : join(); ���
			
			//1. ��ü ����
			SumThread sumThread = new SumThread();
			//2. ������ ����
			sumThread.start();
			
			try { //3. main������� sum�����带 join (�ϳ��� �����尡 �ȴ�.)
				sumThread.join(); //�Ϲݿ���ó�� �߻�
			} catch (Exception e) { }
			
			//4.
			System.out.println("1~100�� �� : "+sumThread.getsum());
			//main �����尡 join�� ���� �ʾ��� �� : 0
				//sumThread�� ���ϱ⸦ ������ ���� main�����尡 ���� ��� �����ع���
			//main �����尡 join ���� �� : 5050
			
			
			
	}
}
