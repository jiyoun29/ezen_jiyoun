package Day19;

import java.util.TreeSet;

public class day19_5 {
	public static void main(String[] args) {
		
		//753 treeset Ŭ����
			//�ϳ��� ��ü�� ����� �Ѵ�
			//�� ���� 2���� �ڽ� ��带 ���� �� �ִ�
			//�θ𺸴� ������ ���� �ڽ� / �θ𺸴� ũ�� ������ �ڽ�
			//Tree�������� ���� ���ʿ� �ִ°� ���� ���� ��
			//Tree�������� ���� �����ʿ� �ִ� ���� ���� ū ��
		
		//�ʱ�
		
		
		//1. TreeSet Ŭ������ ��ü ����
		TreeSet<Integer> scores = new TreeSet<>();

		System.out.println("==========");

		//2. TreeSet ��ü�� ��ü(���) �߰�
		scores.add(87); System.out.println("Ȯ�� :" + scores);
		scores.add(98); System.out.println("Ȯ�� :" + scores);
		scores.add(75); System.out.println("Ȯ�� :" + scores);
		scores.add(95); System.out.println("Ȯ�� :" + scores);
		scores.add(80); System.out.println("Ȯ�� :" + scores);
		// �ڵ�����  @Ȯ�� :[75, 80, 87, 95, 98]

		System.out.println("==========");

		//3. ���� ���� ������ 
		System.out.println(scores.first()); //75 ���� ���� ��� ȣ��
		System.out.println(scores.last()); // 98 ���� ������ ��� ȣ��
		System.out.println(scores.lower(95)); //87 95�������� ���� ��� ȣ�� [95���� ����
		System.out.println(scores.higher(95)); //98 95�������� ������ ��� ȣ�� [95���� ū
		System.out.println(scores.floor(95)); // 95���� �������� ���� ��� [95���� ���ų� ū
		System.out.println(scores.ceiling(85)); // 85���� �������� ������ ��� [85���� ���ų� ū

		System.out.println("==========");
		
		//4.
		System.out.println(scores.pollFirst()); //���� ���ʺ��� ��� ����
		System.out.println(scores.pollLast()); //���� �����ʺ��� ��� ����
		
		System.out.println("==========");

		System.out.println("Ȯ�� : "+scores);
		
		System.out.println("==========");
		
		//5. �������� vs ��������
		System.out.println("�⺻ �������� : "+scores);
		//�������� descendingSet
		System.out.println("�⺻ �������� : "+scores.descendingSet());
		
		System.out.println("==========");
		
		//�������� �ϳ��� ���
		for(Integer temp : scores) {System.out.println(temp);}
			//@temp�� ���ھ�� �ϳ��� ���´�
		//�������� �ϳ��� ���
		for(Integer temp : scores.descendingSet()) {System.out.println(temp);}
		
		
		
		
	///////////////////	
	}
}
