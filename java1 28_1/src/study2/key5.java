package study2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class key5 {//Ű����ũ
	
	//1. �޴� [ī����, ��ī����, ����Ʈ]
		// ī����: �Ƹ޸�ī��(1000), ī���(1500)
		// ��ī����: ��ī���� �Ƹ޸�ī��(1000), �����̵�(1500), ��ũ����ũ(2000)
		// ����Ʈ: ��Ű(500), ġ������ũ(1000), ũ����(800)
	//2. �ֹ� �ޱ�
	//3. ���
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		
	ArrayList<String> ���� = new ArrayList<>(Arrays.asList("�Ƹ޸�ī��","ī���","��ī���� �Ƹ޸�ī��","�����̵�","��ũ����ũ","��Ű", "ũ����"));

	
	int �Ƹ޸�ī�뱸�ż� = 0; int ī��󶼱��ż� = 0; int ��ī���α��ż� = 0; int �����̵屸�ż� = 0; int ��ũ���ż� = 0;
	int ��Ű���ż� = 0; int ũ���ñ��ż� = 0;

	
	while (true) { System.out.println("------�޴�-------");
		System.out.println("1.ī���� 2.��ī���� 3.����Ʈ 4.����"); int ch = scanner.nextInt();
	
			if (ch==1) { //ī���� �޴�
				System.out.println("1.�Ƹ޸�ī��(1000), 2.ī���(1000)"); int ch1 = scanner.nextInt();
				
				if(ch1==1) { System.out.println("�Ƹ޸�ī�븦 ���� ��ҽ��ϴ�.");
				�Ƹ޸�ī�뱸�ż�++;
				}
				else if(ch1==2) { System.out.println("ī��󶼸� ���� ��ҽ��ϴ�.");
				ī��󶼱��ż�++;
				}
				
			} else if (ch==2) {	//��ī����
				System.out.println("1.��ī���� �Ƹ޸�ī��(1200), 2.�����̵�(1200), 3.��ũ����ũ(1200)");
				int ch2 = scanner.nextInt();
				
				if(ch2==1) { System.out.println("��ī���� �Ƹ޸�ī�븦 �� �� ��ҽ��ϴ�.");
					��ī���α��ż�++;}
				else if(ch2==2) { System.out.println("�����̵带 �� �� ��ҽ��ϴ�.");
					�����̵屸�ż�++;}
				else if(ch2==3) {System.out.println("��ũ����ũ�� �� �� ��ҽ��ϴ�.");
					��ũ���ż�++;}	
				
			} else if (ch==3) {	//����Ʈ
				System.out.println("1.��Ű(500) 2.ũ����(500)"); int ch3 = scanner.nextInt();
				if(ch3==1) { System.out.println("��Ű�� �ϳ� ��ҽ��ϴ�.");
					��Ű���ż�++;}
				else if(ch3==2) { System.out.println("ũ������ �ϳ� ��ҽ��ϴ�.");
					ũ���ñ��ż�++;}
				
			} else if (ch==4) { //��ٱ���
				System.out.println("-----------------��ٱ���-----------------");
				
				System.out.println("��ǰ��\t����\t�ݾ�");
				
					if(�Ƹ޸�ī�뱸�ż� !=0) System.out.println("�Ƹ޸�ī��\t"+�Ƹ޸�ī�뱸�ż�+"\t"+(�Ƹ޸�ī�뱸�ż�*1000));
					if(ī��󶼱��ż� !=0) System.out.println("ī���\t"+ī��󶼱��ż�+"\t"+(ī��󶼱��ż�*1000));
					if(��ī���α��ż� !=0) System.out.println("��ī���� �Ƹ޸�ī��\t"+��ī���α��ż�+"\t"+(��ī���α��ż�*1200)); 
					if(�����̵屸�ż� !=0) System.out.println("�����̵�\t"+�����̵屸�ż�+"\t"+(�����̵屸�ż�*1200));
					if(��ũ���ż� !=0) System.out.println("��ũ����ũ\t"+��ũ���ż�+"\t"+(��ũ���ż�*1200));
					if(��Ű���ż� !=0) System.out.println("��Ű\t"+��Ű���ż�+"\t"+(��Ű���ż�*500)); 
					if(ũ���ñ��ż� !=0) System.out.println("ũ����\t"+ũ���ñ��ż�+"\t"+(ũ���ñ��ż�*500)); 
					//��ġ�� ���?
					
					
					int �Ѱ����� =
							(�Ƹ޸�ī�뱸�ż�*1000)+(ī��󶼱��ż�*1000)+
							(��ī���α��ż�*1200)+(�����̵屸�ż�*1200)+
							(��ũ���ż�*1200)+
							(��Ű���ż�*500)+(ũ���ñ��ż�*500) ;
					
					System.out.println("��ǰ �� ������ : " + �Ѱ����� );
					System.out.println("1. ���� 2. ���");
					int ch4 = scanner.nextInt();
					
					if( ch4 == 1 ) {
						while(true) {  System.out.println("�˸�) �Ա� �ݾ� : "); int �ݾ� = scanner.nextInt();
							if(�ݾ�<�Ѱ�����) { System.err.println("�˸�) �ݾ��� �����մϴ�. �ٽ� �������ּ���.");} 
							else { System.err.println("�˸�) ���� ����! ���Ű� �Ϸ�Ǿ����ϴ�.");}
							
							�Ƹ޸�ī�뱸�ż� = 0; ī��󶼱��ż� = 0; �����̵屸�ż� = 0; ��ũ���ż� = 0; ��ī���α��ż� = 0;
							��Ű���ż� = 0; ũ���ñ��ż� = 0;
							
							System.out.println("�˸�) �ܵ� : " + (�ݾ� - �Ѱ�����)+"��" );
							
							
						break; } }

	
			} else { System.out.println("�߸��� ��ȣ�� �Է��Ͽ����ϴ�.");}
	}
		
		
				
	}//while end

}
