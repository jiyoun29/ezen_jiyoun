package Day19;

import java.util.HashSet;
import java.util.Iterator;

public class day19_1 {
	public static void main(String[] args) {
		
		/* �÷��� ������ ��ũ
		 ����=����/�̸� ������� Ŭ����
		 	�迭�� ������ �����Ͽ� ����Ѵ�
		 		1. LIST �÷���
		 			* �ε���(���� ����)
		 			a. Arraylist Ŭ����  : �̱� ������ (������ �߰�/������ �� ����)
		 			b. Vector Ŭ����	   : ��Ƽ ������(����ȭ O)
		 			c. Linkedlist Ŭ���� : �߰� ����/���� (����)
		 		2. SET �÷���
		 			* �ε��� X (���� ������ ���� ������ �ڵ����� ��ü�� �ߺ� �Ұ���) <������
		 			a. HashSet Ŭ����
		 				��. .add(��ü��) : set ��ü �� ��ü(���) �߰�
		 				��. .size(��ü��) : set ��ü �� ��� ����
		 				��. .Iterator(��ü��) : set ��ü ��ȸ �޼ҵ�
		 						Iterator<���׸�> �������̽��� : �������� ��ü ��ȸ �޼ҵ�
		 						Iterator<���׸�> iterator : set.iterator();
		 							1. iterator.hashsetnext() : ���� ��ü ���� ���� Ȯ��
		 							2. iterator.next() : ���� ��� ��������
		 						or
		 						for(�ӽð�ü��)
		 				��. .remove(��ü��) : set ��ü�� ��ü ����
		 				��. .clear() : set ��ü �� 
		 		3. MAP �÷���
		 
		 
		 p.737
		 1. HashSet Ŭ������ ��ü ����
		 */
		
		HashSet<String> set = new HashSet<>();
			//1. Hashset : �÷��� �����ӿ�ũ Ŭ���� (������ ���õ� ����
			//2. <��׸�> : Set Ŭ���� �ȿ� ���� �ڷ���
			//3. set : ��ü��(�ƹ��ų�)
			//4. new : ��ü ������ �޸� �Ҵ�
			//5. HashSet<��������>()
		
		
		//2. set��ü �� ��ü �ֱ� [set ��ü��.add(��ü��)]
		set.add("java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("java");
		
		System.out.println(set);
		//�ߺ� ���� 3���� ���(��ü �ߺ� �Ұ���)
		
		
		//3.set��ü �� ��ü �� [set��ü��.size]
		System.out.println("set �ȿ� ����ִ� ��ü �� : " + set.size());
		
		
		//4.Iterator : ����� ��ü�� �ѹ��� �������� �ݺ��� ���� ( ��ȸ )
			//*set �÷��ǿ��� ���Ǵ� ���� : �ε����� ���� ������ ��ü�� ȣ���ϴ� ���(get)�� ����.
		Iterator<String> iterator = set.iterator();
			//set ��ü �� iterator��� ������ ��ȸ�� �ȴ�.
		
		while(iterator.hasNext()){ //hasNext: ���� ��� ���� ���� Ȯ��(������ true �ƴϸ� false)
			String element = iterator.next(); //.next : ���� ��� ��������
			System.out.println(element); //�¸��� �Ϸķ� ��
		} //while end
		// for�� ���� iterator �� �ᵵ �ȴ�
		for(String element : set) {
			//for(�ӽ� ��ü�� : �÷���/�迭){} : �ӽ� ��ü�� �÷���/�迭 �� ��ҵ��� �ѹ��� �������� �ݺ���
			System.out.println(element);
		}
		
		
		//5. ����. set.remove(��ü��) : set ��ü �� �ش� ��ü�� ����
		set.remove("JDBC"); System.out.println(set);
		
		
		//6. ����. set.clear() : set ��ü �� ��� ��ü ����[����]
		set.clear();  System.out.println(set);
		
		
		
	}
}
