package teat2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class View { //����ڰ� ���� ȭ��. ������ ��Ȳ ǥ�� ���� ���� ��ư�� ������
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //�Է°�ü ����
		
		
		//������Ȳǥ
		//����ð�
		//��¥, ������ȣ, �����ð�, �����ð�, �ݾ�
		
		while(true) { //�ݺ�
			
			System.out.println("=========������Ȳǥ=========");
		
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("����ð� : yyyy - MM - dd \t hh:mm");
//			Date now = new Date(); 
			//����ð��� �ҷ��� ���� ���
			System.out.println(dateFormat.format(date)+"\n"); //�ٹٲ�
			
			System.out.println("��¥\t������ȣ\t�����ð�\t�����ð�\t�ݾ�\n");
			//���⿡ �Է��� ������ ��µǵ��� ��
			
			//��ü ȣ��		
//			System.out.print(Controller.get);

			//ȣ���� �ݺ��ȴ�. �ݺ����� �ɾ �ش�.
			
			//�������� �ҷ��ͼ� ������.
			for(teat2.Car temp : Controller.������) { //?\
				System.out.println(temp.get��¥());
				System.out.println(temp.get������ȣ());
				System.out.println(temp.get�����ð�().getHour());
				System.out.println(temp.get�����ð�());
				System.out.println(temp.get�ݾ�());
				
				
			}
			
		
		System.out.println("\t 1.���� \t\t 2.����"); int ch = scanner.nextInt();
								//������ �Է� ����
		
		if(ch==1) { //����
			System.out.println("���� ��ȣ�� �Է��ϼ���. : ");
			String ����ȣ = scanner.next(); //�Է¹��� �� �����ؼ� �ѱ��
			//�Է� ���� ������ȣ�� �Ѱܼ� �����Ѵ�.
			boolean �����Ϸ� = Controller.����(����ȣ );
			//�ҷ�����
			
			return;
		} else if (ch ==2) { //����
			System.out.println("���� ��ȣ�� �Է��ϼ���. : ");
			String ����ȣ = scanner.next(); //�Է¹��� �� �����ؼ� �ѱ��
			boolean �����Ϸ� = Controller.����(����ȣ );

			
			return;			
		} else { System.out.println("�ٽ� �������ּ���."); }
		
		
		} //while end		
		
///////////////////////////////////////////////////////		
	}
}
