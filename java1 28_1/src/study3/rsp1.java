package study3;

//1. ����0����1��2 �߿� ����
	// 2. ��ǻ�� ���� �߻� 0~2
	// 3. ����ڿ� ��ǻ�� �� �¸��� �Ǵ� [ ����� �� (�̱�.��.���.) ]
	// 4. 3�� �����ϱ� ������ ���� ����
	// 5. 3�� ���ý� 1) �� ���� �� (n��) 2) ���� �¸�(��ǻ��n ���n) = ���

import java.util.Random;
import java.util.Scanner;

public class rsp1 {
	
	public static void main(String[] args) {

		//���ڸ� ������ �� �ִ� ��ü�� �����.
		int me; //���� ������ ��
		int com; //��ǻ���� ��
		int game =0; //����� ������ ��. �ʱⰪ�� 0
		int mewin = 0; int comwin =0; //������ �¸� ��. �ʱⰪ�� 0
	
	Scanner scanner = new Scanner(System.in);
	//���� �� �ִ� ��ĳ�ʸ� �����Ѵ�.

	//����
	while(true) { System.err.println("���������� ������ �����մϴ�.");
		//3�� �����ϸ� break�� ������.
	
		//�÷��̾ ���� �����Ѵ�.
		System.out.println("����(0) ����(1) ��(2)\t ����(3) \n���� : ");
		me = scanner.nextInt(); //�÷��̾� ���� �����Ѵ�.
		System.out.println("���� �� �� : "+me);
		
		//�� ���� ��ǻ�� ���� �������� ����Ѵ�.
		Random random = new Random(); //���� ��ü ����
		com = random.nextInt(3); // 0���� ���Ƿ� 3���� �ؾ� 2���� ���� �ȴ�.
		System.out.println("��ǻ�Ͱ� �� �� : "+com); //��ǻ���� ���� �����ش�.
		
		//�÷��̾��� �������� ���� ��¹��� �����.
		if(me == 3) { System.out.println("������ �����մϴ�.\n���� Ƚ�� :"+game);
				//�÷��̾ �¸��Ͽ��� ���
					if( mewin > comwin ) System.out.println("�¸��� : �÷��̾�");
				//��ǻ�Ͱ� �¸��Ͽ��� ���
					else if( mewin < comwin ) System.out.println("�¸��� : ��ǻ��");
				//�ΰ����� ������ ���
					else System.out.println("�¸��� : ���º�");
					break; } //�����Ѵ�.
		//�ºο� ���ؼ� ����Ѵ�. ���� �� ���� 0�� ���ų� ŭ, �Ǵ� 2�� ���ų� ������?
		else if( me >=0 && me <=2 ) {
		//����0����1��2 ���� ����Ͽ� if�� ����
			if( (me==0 && com==2 || (me==1 && com==0) || (me==2 && com==1) )) {
				//�÷��̾��� �¸� : -1, 2
				System.out.println("�÷��̾� �¸��Դϴ�."); mewin++;
			} //���� 0�̶� ����� ���
			else if((me==0 && com==0 || (me==1 && com==1) || (me==2 && com==2) )) {
				System.out.println("�����ϴ�.");
				//�� ���� ���� ��ǻ���� �¸��̴�.
			} else {System.out.println("��ǻ�� �¸��Դϴ�."); comwin++; } game++;
		} else {System.out.println("��ǻ���� �¸��Դϴ�.");}



		} //while end
	} // me
}
