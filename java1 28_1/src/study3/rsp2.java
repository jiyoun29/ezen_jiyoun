package study3;

import java.util.Random;
import java.util.Scanner;

public class rsp2 {
	public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
		
	int me; int com; int game = 0; int mewin = 0; int comwin = 0;
		
	while(true) { System.out.println("���������� ������ �����մϴ�.");
		System.out.println("����(0) ����(1) ��(2)     ����(3)\n���� : ");
		me = scanner.nextInt(); //���� �� ���� ����
		System.out.println("���� �� �� : "+me);

	Random random = new Random();
	com = random.nextInt(3);
		System.out.println("��ǻ�Ͱ� �� �� : "+com);
	
		// ������
		// ���� ���Ḧ �����Ͽ��� ���
		if(me==3) {	System.out.println("������ �����մϴ�.\n����Ƚ�� : "+game);
		//���� ���� ���и� �Է�
		if( mewin > comwin ) System.out.println("�¸��� : �÷��̾�");
		else if( mewin < comwin ) System.out.println("�¸��� : ��ǻ��");
		else System.out.println("�¸��� : ���º�");break; }
		
		else if( me>=0 && me<=2 ) {
			//2, -1
			if((me==0 && com==2 || (me==1 && com==0) || (me==2 && com==1) ))
			{System.out.println("�÷��̾� �¸��Դϴ�."); mewin++; }
			//��� ���
			else if((me==0 && com==0 || (me==1 && com==1) || (me==2 && com==2) ))
				{System.out.println("�����ϴ�.");}
			else {System.out.println("��ǻ�� �¸��Դϴ�."); comwin++; } game++;
			} else {System.out.println("��ǻ���� �¸��Դϴ�.");}

		
	} //while end
		
/////////////////////////////		
	}

}
