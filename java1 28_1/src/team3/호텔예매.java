package team3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Total.Main;
import Total.��������;
import Total.��������_Controller;
import Total.ȣ�ڿ���_Room;
import Total.ȸ����������;


public class ȣ�ڿ��� {
	
	public static Room[] roomlist = new Room[100];
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) {
			try {
				System.out.println("************** ȣ�� ���� ���α׷� **************");
				System.out.println("1.���� 2.������ 3. �������"); int ch2 = scanner.nextInt();
				if(ch2==1) {
					System.out.println("��¥�Է�(mmdd) :");	String ��¥ = scanner.next();
					
					boolean result = Controller.��¥üũ(��¥);
					
					if(result==true) {
						
						boolean[] ���డ�� = new boolean[5];
						for(Room temp : roomlist) {
							if(temp != null) {
						 // ��¥�� MM(��)dd(��)�� String ������ ��ü����
							if(temp.getDate().equals(��¥)) { // temp���� ��¥�� �Է¹��� ��¥�� �����ϰ�
								if(temp.getRname().equals("Ʈ����")) { // temp���� ���̸��� Ʈ����� �����ϸ�
									���డ��[0] = true;	} // if e
								if(temp.getRname().equals("�����")) {
									���డ��[1] = true;	} // if e
								if(temp.getRname().equals("�ٴٺ�Ʈ����")) {
									���డ��[2] = true;	} // if e
								if(temp.getRname().equals("�ٴٺ�����")) {
									���డ��[3] = true;	} // if e
								if(temp.getRname().equals("����Ʈ��")) {
									���డ��[4] = true;	} // if e
								}	
							} // if e
						} // for e
						
						
			
						System.out.println("************** �� ���� ��Ȳǥ **************");
						System.out.println("��ȣ\t���̸�\t\t�ݾ�\t\t���࿩��");
						System.out.println("1"+".\t"+"Ʈ����\t\t"+"10,000��\t\t"+((���డ��[0])?"����Ұ�":"���డ��")); // ���ǿ�����[���ǽ�? �� : ����]
						System.out.println("2"+".\t"+"�����\t\t"+"20,000��\t\t"+((���డ��[1])?"����Ұ�":"���డ��"));
						System.out.println("3"+".\t"+"�ٴٺ�Ʈ����\t"+"30,000��\t\t"+((���డ��[2])?"����Ұ�":"���డ��"));
						System.out.println("4"+".\t"+"�ٴٺ�����\t"+"40,000��\t\t"+((���డ��[3])?"����Ұ�":"���డ��"));
						System.out.println("5"+".\t"+"����Ʈ��\t\t"+"50,000��\t\t"+((���డ��[4])?"����Ұ�":"���డ��"));
						
						System.out.println("�� ��ȣ ���� : ");	int ch = scanner.nextInt();
						System.out.println("������ �̸� : ");	String name = scanner.next();
					
						int result2 = Controller.����(��¥, name, ch);
						
							
						if(result2==1) { System.out.println("1���� Ʈ������ ����Ǿ����ϴ�.");
							System.out.println("���Ǳݾ��� 10,000���Դϴ�."); } // if e
						if(result2==2) { System.out.println("2���� ������� ����Ǿ����ϴ�.");	} // if e
						if (result2==3) { System.out.println("3���� �ٴٺ�Ʈ������ ����Ǿ����ϴ�."); } // if e
						if(result2==4) { System.out.println("4���� �ٴٺ������� ����Ǿ����ϴ�."); } // if e
						if(result2==5) { System.out.println("5���� ����Ʈ���� ����Ǿ����ϴ�."); } // if e
						if(result2==6) { System.out.println("�˸�))������ �� �����ϴ�."); }
						
//						System.out.println("�ݾ��Է� : "); int �ݾ� = scanner.nextInt();
//						int result3 = Controller.����(�ݾ�);
//						
//						if(result3==1) {
//							System.out.println("�ݾ��� �����մϴ�.");
//						}
//						else if(result3==2) {
//							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
//						}
						
						
						
						for(Room temp1 : roomlist) {
							if(temp1 != null) {
								System.out.println(temp1.getRname()+"\t"+temp1.getReserve()+"\t"+temp1.getDate());
							} // if e
					
						} // for e
						
					} // if e
					else {
						System.out.println("�˸�))��¥�� �߸��Է��Ͽ����ϴ�.");
					}
				} // if e
				else if(ch2==2) {
					System.out.println("��¥\t���̸�\t\t������");
					Controller.������();
				}
				
				/////////////////////
				
				
				else if(ch2 == 3) { //��¥�� �޾ƿͼ� 
					System.out.println("��¥�Է�(mmdd) :"); String ��ҳ� = scanner.next(); //��ҳ�¥ �޾ƿ�
					
					boolean result = Controller.��¥üũ(��ҳ�);
					//����� ���� ��¥ �˻�. ��¥�� �����ϸ�?
					Controller.������(); //���� ����� �������� ����� �� ��ȣ �ޱ�

					//���ȣ�� ���̵� �޾Ƽ� �������� Ȯ�� �� ��� ����
					System.out.println("��Ҹ� �����մϴ�. ���̵� �Է����ּ��� : ");	String id = scanner.next();
					
//					System.out.println("������ �� ���");
//					System.out.println("���ȣ\t���̸�");
					//int i = 0;					
						
						for( ȣ�ڿ���_Room temp : Main.roomList) {
							if(temp.getid().equals(id)) {
								Main.roomList.remove(temp);
								System.out.println("��Ұ� �Ϸ�Ǿ����ϴ�.");

//								System.out.print( i +"\t");
//								System.out.print( temp.getRname() +"\t");
//								System.out.print( temp.getDate() +"\n");
//								i++;
							} //if end
						} //for end
//						
		//			System.out.println(" ����� ���ȣ : "); int �������ȣ = scanner.nextInt();
			//			Main.roomList.remove( �������ȣ );
						

				} //else if 3 end
		
			/////////////////////////////////////
				
			} catch(Exception e) {
				System.out.println("�˸�))�����Դϴ�(�����ڿ��Թ���)");
			} // catch e
		} // while e
		
	} // me

}
