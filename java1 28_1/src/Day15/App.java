package Day15;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		//���⼭�� ����ϹǷ� ��ĵ �����
		Scanner scanner = new Scanner(System.in);
		
		//�ݺ���
		while(true) {
			//1. ��� ����ǥ ���
				//�迭�̳� ����Ʈ�� ȣ���ϴ� �ݺ��� �ֱ�(�Խ��� ����)
			
			try {
				System.out.printf( //��� �Խù� ���
						"%s\t%s\t%s\t%s\t%s\n",
						"��¥", "������ȣ", "�����ð�", "�����ð�", "�ݾ�");
				
				int i = 0; //�ε��� ����
				for(Controller temp : ������) {
					if(temp != null) {
						temp.
					}
					
				}
				
				
//				for(Students temp : studentlist) {
//					if(temp != null) {
//						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
//								temp.getNo(),temp.getName(),temp.getKor(),temp.getEng(),temp.getMath(),temp.getTotal(),temp.getAve(),(h+1));
//					}
//					h++;
//				}
				
			} catch (Exception e) {			}
					
			
			
			System.out.println("1. ����      2. ����");
			int ch = scanner.nextInt();
			
			if(ch == 1) { //�޼ҵ�.
				// ������ȣ�� �Է� ����
				// �Է� ���� ������ȣ�� ��Ʈ�ѷ����� �ѱ��.
					//
				// �޼ҵ� ����� ���� ���
				boolean ��� = Controller.����(null); //������ȣ
				
			} else if (ch == 2) {	
				// ������ȣ�� �Է� ����
				// �Է� ���� ������ȣ�� ��Ʈ�ѷ����� �ѱ��.
				// �޼ҵ� ����� ���� ���
				boolean ��� = Controller.����(null); //������ȣ
				
			}
			
			
			
			break;
		}
		
		
		
		
		
	}
}
