package class1;

import java.util.Scanner;

public class View { // class start

	public static void main(String[] args) { // main start
		Scanner scanner = new Scanner(System.in);
		
		
		/////////////////////////////////////////////////////
		
		
		for (int i = 0 ; i <= 11 ; i++) {  // 12���� ����Ʈ ���� ������ȣ�� " " �־� " "�ϰ�� ���ڸ��� ���
			
			Car car = new Car(i, " ", " ");
			//
			
			Controller.carlist.add(car);
			//��Ʈ�ѷ��� ������ �������� ������ ��
		}
		Controller.load();
		Controller.load2();
		while(true) { // ���ѷ��� �������� ����
			System.out.println("----- �������� ���α׷� ------");
			int i = 1 ; // �Ѱ����� 4ĭ�� ��µǵ��� �ϱ� ���� ���� ���� 
			for (Car temp : Controller.carlist) {
				if(temp.getCarnum().equals(" ")) { // ������ȣ ������ �������� ���
					System.out.printf("[    ]\t");
				}
				else if(temp.getCarnum() != " ") { // ������ȣ������ ������ȣ�� ���
					System.out.print("["+temp.getCarnum()+"]\t");
				}
				if(i%4==0) { // 4�� ���� �ٹٲ㼭 ������ ǥ��
					System.out.println();
				}
				i++;
			}
			try { // int�� �� �Է½� �����߻��� ���� ����ó��
				System.out.println("1.���� 2.���� 3.����Ȯ��");
				System.out.print("���� > ");
				int ch = scanner.nextInt();
				if(ch==1) { // ���� �޴�
					System.out.print("������ȣ�� �Է��ϼ��� : "); String carnum = scanner.next();
					System.out.print("�������� �Է��ϼ��� [ex) 3��18�� = 0318] : "); String date = scanner.next();
					System.out.print("�����ð��� �Է��ϼ��� [ex) ���� 3�� 15�� = 1515] : "); String time = scanner.next();
					boolean result = Controller.checkdate(date); // ������ üũ �޼ҵ�
					boolean result2 = Controller.checktime(time); // �����ð� üũ �޼ҵ�
					boolean result4 = Controller.checkcnum(carnum);
					if (result4 == false) {
						System.out.println("�˸�] ������ȣ�� �߸��Է��ϼ̽��ϴ�.");
					}
					else {
						if (result==false) { // ������ �߸��Է��Ұ��
							System.out.println("�˸�] ��¥�� �߸��Է��ϼ̽��ϴ�.");
						}
						else {	// �����ð� �߸��Է��Ұ��	
							if(result2==false) {
								System.out.println("�˸�] �ð��� �߸��Է��ϼ̽��ϴ�.");
							}
							else { // �ð� ����� �Է½� ���� �޼ҵ�
								String intime = date+time;
								boolean result3  = Controller.carin(carnum, intime);
								if(result3) {
									System.out.println("�˸�] ���� ����.");
								}
								else {
									System.out.println("�˸�] ���� ���� [�ڸ��� �����ϴ�.]");
								}
							}
						}
					}
				} // ���� �޴�
				
				else if(ch==2) { // ���� �޴�
					System.out.print("������ȣ�� �Է��ϼ��� : "); String carnum = scanner.next();
					System.out.print("�������� �Է��ϼ��� [ex) 3��18�� = 0318] : "); String date = scanner.next();
					System.out.print("�����ð��� �Է��ϼ��� [ex) ���� 3�� 15�� = 1515] : "); String time = scanner.next();
					String outtime = date+time;
					boolean result = Controller.checkouttimedate(carnum, outtime); // �����ð� üũ �޼ҵ�
					boolean result3 = Controller.checkdate(date); // ������ üũ �޼ҵ�
					boolean result4 = Controller.checktime(time); // �����ð� üũ �޼ҵ�					
					if (result == false || result3 == false || result4 == false) { // �����ð��� �����ð� ������ �Է��Ұ��
						System.out.println("�˸�] �����ð��� �߸��Է��ϼ̽��ϴ�.");
					}
					else {  // �����ð� ����� �Է�������
						String result2 = Controller.carout(carnum);
						if(result2 == null) { // ���ϰ��� null�̸� (=�������н�)
							System.out.println("�˸�] ���� ���� [�߸��� ������ȣ �Դϴ�.]");		
						}
						else { // ���ϰ��� null�̾ƴϸ� �����ð� �޾Ƽ� ���޼ҵ� �μ���
							int fee = Controller.pay(carnum, outtime, result2); // ��ȯ�� �ð����̸� ������ ����		
							if (fee == 0) { // 30�� �̳� ����
								System.out.println("�˸�) ȸ�� ���� �ð�");
							}
							else { // 1�� ��� �ִ� 5��
								while(true) {
									System.out.println("�˸�) ��������� : " + fee  + "�� �Դϴ�.");
									System.out.print("�Ա��ϼ��� : "); int money = scanner.nextInt() ;
									if (money >= fee) {
										System.out.println("�����մϴ�");
										System.out.println("�Ž����� " +(money-fee) +" �� �޾ư�����");
										Controller.volume(date, fee); // ���� ������� ������޼ҵ� �μ�
										Controller.save2();
										break;
									}
									else {
										System.out.println("�˸�] ���� �����մϴ�. �ٽ� �Ա����ּ���");
									}
								}
								
							}

						}	
					}
				} // ���� �޴�
				
				else if(ch==3) { // ����Ȯ�� �޴�
					System.out.println("�� ���� ������ ��� �Ͻðڽ��ϱ� : ");
					System.out.print("�Է� > ");
					int month = scanner.nextInt();
					if ( 1 <= month && month <= 12) {
						if (Controller.totalcharge[month-1] == 0) {
							System.out.println("�˸�] ������ �����ϴ�. ");
						}
						else {
							System.out.println(month+"���� ������ : " + Controller.totalcharge[month-1] + "�� �Դϴ�.");
						}
					}
					else {
						System.out.println("�˸�] �߸� �Է� �ϼ̽��ϴ�");						
					}
				} // ������ �޴�
				
				else { // �߸��� ��ȣ �Է�
					System.out.println("�˸�] �߸��� ��ȣ�Դϴ�.");
				} // �߸��� ��ȣ �Է�
			}
			
			catch(Exception e) { // ���� catch
				System.out.println("�˸�] �߸��� �Է��Դϴ�.");
				scanner = new Scanner(System.in);
			} // ���� catch
			
		} // while end	
		

////////////////////////////////////////////////////////////////
	} // main end
}
