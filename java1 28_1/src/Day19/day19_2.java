package Day19;

import java.util.HashSet;
import java.util.Scanner;

public class day19_2 {
	public static void main(String[] args) {
		
		//�ζ� ���α׷�
			//set�� �̿��Ͽ� ����
		
		Scanner scanner = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<>();
		
		
		while(true) { //���ѷ��� [ �������� : set��ü �� ��ü ���� 6�̸�  break;
			System.out.println("1~45 ���� ����(�ߺ��Ұ���) : ");
			int num = scanner.nextInt();//3. �Է¹ޱ�
			
			if(num<1 || num >45) { //4. 1~45 ���̰� �ƴϸ� �ٽ� �Է¹ޱ�
				System.out.println("������ �� ���� ��ȣ�Դϴ�.");
			} else {
				set.add(num); //5. 1~45 ���� ��ü�̸� set�� ����
				System.out.println("Ȯ�� : "+set);
			}
			if(set.size() == 6) break;
			//����� ��ü ���� 6���̸� ����
		}
		
	}
}
