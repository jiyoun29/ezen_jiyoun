package Day18;

import java.util.ArrayList;
import java.util.Scanner;

public class day18_4_����� {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//����� ���α׷�
			//�޴� : [��] 1.����߰� 2.������ [������] 3.���������
				//��� �߰� : �ο����� �Է¹޾� ����ȣ ����
				//��� ��� : ����ȣ �Է¹޾� ��� ���
				//����� ���� : ù���� ��� ���� ����ȣ ȣ��
		
		//����Ű�� ���µǵ���
		int ����ȣ = 0;//����
		
		ArrayList<���> ����� = new ArrayList<>();
			//������ ��ⰴü ����
		
		while(true) {
			System.out.println("����ȣ\t�ο���\t��⿹��ð�[�ε���]");
				//�ݺ����� �̿��� ����Ʈ �� ��� ��ü ȣ��
			for(��� temp : �����) {
				if(�����.indexOf(temp)==0) System.out.println(temp.����ȣ+"\t"+temp.�ο���+"\t"+"����");
																			//�� ��ġã��(indexOf)
				System.out.println(temp.����ȣ+"\t"+temp.�ο���+"\t"+�����.indexOf(temp)*3+"��");
			}
			
			//�޴�
			System.out.println("1.����߰� 2.������ [������] 3.����� ����"); int ch = scanner.nextInt();
			if(ch == 1) {  //�Է¹��� ������ �������� ����
				System.out.println("��ȭ��ȣ : "); String ��ȭ��ȣ = scanner.next();
				System.out.println("�ο��� : "); int �ο��� = scanner.nextInt();
				//���� ��üȭ
				��� temp = new ���(����ȣ, ��ȭ��ȣ, �ο���);
				
				//����ο� ����
				�����.add(temp);
				����ȣ++; //����ȣ ����
				
			} else if (ch == 2) {
				//�Էµ� ���� �޾Ƽ� ����
				System.out.println("����ȣ : "); int ������ȣ = scanner.nextInt();
				//����Ʈ �� ��ü �ʵ� �˻�
				for(��� temp : �����) {
					if(temp.����ȣ == ������ȣ) {�����.remove(temp); break;}
					//����� ����Ʈ�� �ϳ��� temp�� ȣ���Ͽ� ���� temp�� ����ȣ�� �Է¹��� ��������ȣ�� ������ �ش� temp�� ������ �ݸ�� ����
				}
				
				
				
				
				
			} else if (ch == 3) {
				
				System.out.println("���� �տ� �ִ� ��� ����� ���� ��ŵ�ϴ�."); �����.remove(0); 
				//0��° �ε��� ����
				
				
				
			} else {}
			
			
			
			
			
		}
		
		
	}
}
