package study;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ramyeon1 {
 public static void main(String[] args) {
	
	 /* ��� ������
	  * 1. �� 3���� �ְ� ���� ������ ��, �и������� �ִ´�.
	  * ���⿡ ���� ���Ŀ� ����� �ִ´�.
	  */
 
	 Scanner scanner = new Scanner(System.in);
	 //���� �� �ִ� ��ĳ�ʸ� �����Ѵ�.
	 StringBuffer ���� = new StringBuffer();
	 Random random = new Random();
	 // ������ ���� �� �ְ� ��ü�� �����Ѵ�.
	 
	 String chars[] = "�����,���ִ�,�Ǹ���,¬©��".split(",");
	 
	 while(true) {  System.out.println("----------��� ���̱� ����!----------");
	 // 1. ���� ���� ä���.
	 	System.out.print("���� ���� �� �� ä����? : "); int water = scanner.nextInt(); 
	 	// ������� �Է°�(��)�� �����Ѵ�.
	 	System.out.println("���� ���� "+ water + "�� ä�����ϴ�.");
		// ������ �Է°��� ���� �����Ͽ� Ȯ���ϰ� �Ѵ�. 
	 	
	 	//2. ��� ���� �ֱ�
		 	System.out.println("���� �����ϴ�. 1. �� ���� �ִ´�. 2. ���� ���� �ִ´�."); int ch = scanner.nextInt();
		 	// ������� �Է°��� ������ ����, if, else if, else�� �������� �������� �����Ѵ�.
		 		if(ch == 1) { System.out.println("���� ���� �־����ϴ�."); System.out.println("���� Ǯ������ ������ �ְ� �����մϴ�."); }
		 		//���� ���� �־��� ���� ������ �����Ѵ�.
	 			else if (ch == 2) { System.out.println("������ ���� �־����ϴ�.");	System.out.println("������ ������ ���� �ְ� �����մϴ�.");
		 		//������ ���� �־��� ���� ������ �����Ѵ�.
		 		} else { System.out.println("�˸�) �� �� ���� ��ȣ�Դϴ�."); } 
		 		//�ùٸ��� ���� ��ȣ�� �Է��Ͽ��� ��츦 �Է��صд�.
		 // 3. �߰��� ���
		 		System.out.println("���� �;�ϴ�. �߰��� ��ᰡ �ֳ���?");
		 		//�߰� ���θ� ���� �������� ���� �Է°��� �޴´�.
		 		System.out.println("1. ���� 2. ��� 3.����."); int ch2 = scanner.nextInt();
		 		
		 		//����
		 		while(true) { if(ch2 == 1) { System.out.println("���ĸ� �� �� �������? : "); String ���� =scanner.next();
		 		// ���� �Է� ������ �����ϰ� �����Ѵ�.
		 			System.out.println("���ĸ� " + ���� + "�� �־����ϴ�.");  }
		 		
		 		else if (ch2 == 2) {  System.out.println("����� �� �� �������?"); String ��� = scanner.next();
		 		//��� �Է� ������ �����ϰ� �����Ѵ�.
		 			System.out.println("����� "+ ��� +" �־����ϴ�.");
		 			
		 		} else if (ch2 == 3) { System.out.println("����� �ϼ��Ǿ� ���ϴ�.");
		 		//�߰� ���� ��� ���� ��Ȳ ����
		 		
		 		}else { System.out.println("�˸�) �� �� ���� ��ȣ�Դϴ�."); }
		 		//�߸��� ���� �Է½� �˸� �߼�'
		 		
		 		 System.out.println( ����.append(chars[random.nextInt(chars.length)]) + " ����� �ϼ� �Ǿ����ϴ�.");
		 		 //�������� ����� ���� �����Ѵ�.
		 		 
		 		 break;
		 		} // while2 end
		 		
	 } // while end
 
	 
 } // me
	
} // c e
