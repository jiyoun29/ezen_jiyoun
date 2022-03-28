package Day18;

import java.util.ArrayList;
import java.util.LinkedList;

public class day15_3 { //731
	
	public static void main(String[] args) {
		
		/* LinkedList Ŭ����
		 				ArrayList				LinkedList
		 			   		�迭						��ũ
		 ���α�������	�ε��� �������� �޸𸮰� ����	���� �ٸ� �޸��ּ� ����
		 �ӵ�	
		 add[�߰�]			����						
		 add[�߰� ����]								����
		 �˻�					����
		 
		 */
		
		
		//1.��̸���Ʈ ��ü ���� [ ���׸� = String ]
		ArrayList<String> list1 = new ArrayList<>();
		
		//2.��ũ�帮��Ʈ ��ü ���� [ ���׸� = String ]
		LinkedList<String> list2 = new LinkedList<>();
		
		
		//3. �ð�����
		Long starttime; //���۽ð�
		Long endtime; //������ �ð�
		
		
		//4.arraylist ��ü�� ���� ���� ->�����ϴµ� �ɸ��� �ð�
		starttime = System.nanoTime(); //���� �ð� ���� ������ ȣ��
		
		for(int i = 0 ; i<10000 ; i++) {
			list1.add(0, i+""); //����->���ڿ� ��ȯ
								//1. String.valueOf(����) ������ �ٲ�   2. ����+""
								//���ڿ�->���� ��ȯ : 1. Integer.parseInt(���ڿ�)
		}
			endtime = System.nanoTime(); //������ = 10��/1��
			System.out.println("��̸���Ʈ�� 10000�� �����ϴµ� �ɸ��� �ð� :"+(endtime - starttime)+"ns");
		
		//5. ��ũ�帮��Ʈ ��ü 10000�� �����ϴµ� �ɸ��� �ð�
			
			starttime = System.nanoTime();
			for(int i = 0 ; i<10000 ; i++) {
				list2.add(0, i+"");
			} endtime = System.nanoTime();
			System.out.println("��ũ�� ����Ʈ�� ���� �����ϴµ� �ɸ��½ð� :"+(endtime - starttime)+"ns");
		
		
	}

}
