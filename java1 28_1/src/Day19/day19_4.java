package Day19;

import java.util.Hashtable;
import java.util.Scanner;

public class day19_4 {
	public static void main(String[] args) {
		
		//p.747
		
		//1. Hashtable class�� Ŭ���� ��ü ����
		Hashtable<String, String> map = new Hashtable<>();
		
		//2. map ��ü�� �߰�
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
				//key       value
				//���̵�		��й�ȣ
		
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) { //�ݺ��� ���ѷ���
			System.out.println("���̵� : "); String id = scanner.next();
			System.out.println("��й�ȣ : "); String pw = scanner.next();
			
			// ���࿡ map��ü �� �ش� key�� �����ϸ�? true/ �ƴϸ� false
			if(map.contains(id)){
				//���� �Է��� ���̵� map ��ü �� key�� �����ϸ�
				if(map.get(id).equals(pw)) {
					//���࿡ key �̿��� �� ȣ���ؼ� �Է��� pw �� �����ϸ�
					
				} else {System.out.println("�Է� �Ͻ� ��й�ȣ�� �ٸ��ϴ�.");}
				
			} else {System.out.println("�Է� ���� ���̵� �������� �ʽ��ϴ�."); }
			
		} //while end
		
//////////////////////////////////////////////////////		
		
	}
}
