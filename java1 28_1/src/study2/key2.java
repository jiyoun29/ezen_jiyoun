package study2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class key2 { //Ű����ũ
	
	//1. �޴� [�ܹ���, ����]
		// �ܹ���: �Ұ�����(2000) ġ�����(1000) �������(2500)
		// ����: �����̵�(1000), ���̴�(1000), Ŀ��(500)
	//2. �ֹ� �ޱ�
	//3. ���
	
	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	ArrayList<String> �޴� = new ArrayList<>(Arrays.asList("�Ұ�����","ġ�����",
			"�������","�����̵�","���̴�","Ŀ��"));
	int �Ұ�ⱸ�ż� = 0; int ġ��ż� = 0; int ���󱸸ż� = 0;
	int ���챸�ż� = 0; int ���̴ٱ��ż� = 0; int Ŀ�Ǳ��ż� = 0;
	
	while (true) {
		System.out.println("----------------- �޴� -----------------");
		System.out.println("�޴��� �������ּ���.");
		System.out.println("1.�ܹ��� 2.���� 3.����"); int ch = scanner.nextInt();
		
		//������
		if (ch==1) { System.out.println("1.�Ұ�����(2000), 2.ġ�����(1000) 3.�������(2500)")
			;
			int ch1 = scanner.nextInt();
			
			if(ch1==1) { System.out.println("�Ұ����Ÿ� �����Ͽ����ϴ�."); �Ұ�ⱸ�ż�++;}
			else if(ch1==2) { System.out.println("ġ����Ÿ� �����Ͽ����ϴ�."); ġ��ż�++;}
			else if(ch1==3) { System.out.println("������Ÿ� �����Ͽ����ϴ�."); ���챸�ż�++;}
			
		} else if (ch==2) {	System.out.println("1.�����̵�(1000), 2.���̴�(1000) 3.Ŀ��(500)");
		
			int ch2 = scanner.nextInt();
			
			if(ch2==1) { System.out.println("�����̵带 �� �� ��ҽ��ϴ�."); ���󱸸ż�++;}
			else if(ch2==2) { System.out.println("���̴ٸ� �� �� ��ҽ��ϴ�."); ���̴ٱ��ż�++;}
			else if(ch2==3) {System.out.println("Ŀ�Ǹ��� �� �� ��ҽ��ϴ�."); Ŀ�Ǳ��ż�++;}	
			
		} else if (ch==3) {
			
			System.out.println("-----------------��ٱ���-----------------");
			System.out.println("��ǰ��\t����\t�ݾ�");
			
			if(�Ұ�ⱸ�ż� !=0) System.out.println("�Ұ�����\t"+�Ұ�ⱸ�ż�+"\t"+(�Ұ�ⱸ�ż�*2000));
			if(ġ��ż� !=0) System.out.println("ġ�����\t"+ġ��ż�+"\t"+(ġ��ż�*1000));
			if(���챸�ż� !=0) System.out.println("�������\t"+���챸�ż�+"\t"+(���챸�ż�*2500)); 
			
			if(���󱸸ż� !=0) System.out.println("�����̵�\t"+���󱸸ż�+"\t"+(���󱸸ż�*1000));
			if(���̴ٱ��ż� !=0) System.out.println("���̴�\t"+���̴ٱ��ż�+"\t"+(���̴ٱ��ż�*1000));
			if(Ŀ�Ǳ��ż� !=0) System.out.println("Ŀ��\t"+Ŀ�Ǳ��ż�+"\t"+(Ŀ�Ǳ��ż�*500)); 
		
			int �Ѱ����� = (�Ұ�ⱸ�ż�*2000)+(ġ��ż�*1000)+(���챸�ż�*2500)+(���󱸸ż�*1000)+(���̴ٱ��ż�*1000)+(Ŀ�Ǳ��ż�*500) ;
			
			System.out.println("��ǰ �� ������ : " + �Ѱ����� );
			System.out.println("1. ���� 2. ���");
		
			int ch4 = scanner.nextInt();
			if( ch4 == 1 ) { while(true) {  System.out.println("�Ա� �ݾ� : "); int �ݾ� = scanner.nextInt();
			if(�ݾ�<�Ѱ�����) { System.err.println("�ݾ��� �����մϴ�. �ٽ� �������ּ���.");} 
			else { System.err.println("���Ű� �Ϸ�Ǿ����ϴ�.");}
			�Ұ�ⱸ�ż� = 0; ġ��ż� = 0; ���󱸸ż� = 0; ���챸�ż� = 0; ���̴ٱ��ż� = 0; Ŀ�Ǳ��ż� = 0;
			System.out.println("�ܵ� : " + (�ݾ� - �Ѱ�����)+"��" ); 
		
			break; } 
		}

			} else { System.out.println("�߸��� ��ȣ�� �Է��Ͽ����ϴ�.");
		}
	}
		
		
		
	
	}//while end

}
