package study2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class key3 {//Ű����ũ
	
	//1. �޴� [�Ļ�, ���̵�]
		// �Ļ�: ��ġ������(4500) ���(5500) ���(2000)
		// ���̵�: ����Ƣ��(2000) ���̴�(1000)
	//2. �ֹ� �ޱ�
	//3. ���
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	
	ArrayList<String> �޴� = new ArrayList<>(Arrays.asList("��ġ������","���","���","����Ƣ��","���̴�"));
	int ��ġ���ż� = 0; int ������ż� = 0; int ��鱸�ż� = 0;
	int ���ڱ��ż� = 0; int ���̴ٱ��ż� = 0;
	
	while (true) {
		System.out.println("-----------�޴�----------");
		System.out.println("�޴��� �������ּ���.");
		System.out.println("1.�Ļ� 2.���̵� 3.����");
		int ch = scanner.nextInt();
		
		
		//�Ļ�
		if (ch==1) { System.out.println("1.��ġ������(4500), 2.���(5500) 3.���(2000)"); int ch1 = scanner.nextInt();
				if(ch1==1) { System.out.println("��ġ�������� �ֹ��Ͽ����ϴ�."); ��ġ���ż�++;}
				else if(ch1==2) { System.out.println("����� �ֹ��Ͽ����ϴ�."); ������ż�++;}
				else if(ch1==3) { System.out.println("����� �ֹ��Ͽ����ϴ�."); ��鱸�ż�++;}
		}
		//���̵�
		else if (ch==2) { System.out.println("1.����Ƣ��(2000), 2.���̴�(1000)"); int ch2 = scanner.nextInt();
			if(ch2==1) { System.out.println("����Ƣ���� �ֹ��Ͽ����ϴ�."); ���ڱ��ż�++;}
			else if(ch2==2) { System.out.println("���̴ٸ� �� �� ��ҽ��ϴ�."); ���̴ٱ��ż�++;}	
		}
		
		else if (ch==3) { System.out.println("-----------��ٱ���-----------");
						System.out.println("��ǰ��\t����\t�ݾ�");
			
			if(��ġ���ż� !=0) System.out.println("��ġ������\t"+��ġ���ż�+"\t"+(��ġ���ż�*4500));
			if(������ż� !=0) System.out.println("���\t"+������ż�+"\t"+(������ż�*5500));
			if(��鱸�ż� !=0) System.out.println("���\t"+��鱸�ż�+"\t"+(��鱸�ż�*2000)); 
			if(���ڱ��ż� !=0) System.out.println("����Ƣ��\t"+���ڱ��ż�+"\t"+(���ڱ��ż�*2000));
			if(���̴ٱ��ż� !=0) System.out.println("���̴�\t"+���̴ٱ��ż�+"\t"+(���̴ٱ��ż�*1000));
		
			int �Ѱ����� = (��ġ���ż�*4500)+(������ż�*5500)+(��鱸�ż�*2000)+(���ڱ��ż�*2000)+(���̴ٱ��ż�*1000) ;
			
			System.out.println("��ǰ �� ������ : " + �Ѱ����� );
			System.out.println("--------------------------------------");
			System.out.println("1. ���� 2. ���");	int ch4 = scanner.nextInt();
			
			
			if( ch4 == 1 ) { while(true) {  System.out.println("�Ա� �ݾ� : "); int �ݾ� = scanner.nextInt();
				if(�ݾ�<�Ѱ�����) { System.err.println("�ݾ��� �����մϴ�.");
			}
				else { System.err.println("���Ű� �Ϸ�Ǿ����ϴ�.");}
			
			��ġ���ż� = 0; ������ż� = 0; ��鱸�ż� = 0; ���ڱ��ż� = 0; ���̴ٱ��ż� = 0;
			
			System.out.println("�ܵ� : " + (�ݾ� - �Ѱ�����)+"��" ); 
		
			break; } 
		}

			} else { System.out.println("�߸��� ��ȣ�� �Է��Ͽ����ϴ�.");
		}
	}
		
////////////////////////////////////////////////		
	}


}
