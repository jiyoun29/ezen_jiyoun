package Day19;

import java.util.HashMap;

public class day19_3 {
	public static void main(String[] args) {
		
		/* Map �÷��� = json
		 	Ű(��ü), ��(��ü) = �������� '��Ʈ��' (���� �ѽ�)
		 	map�� ��ü 2���� ��
		 	Ű : set �÷��� ���(�ߺ� �Ұ���)
		 	�� : list �÷��� ���(�ߺ� ����)
		 	hashmap Ŭ����
		 		1. map ��ü��.put(Ű ��ü, �� ��ü) : �ϳ��� ��Ʈ��(Ű, ��) �߰�
		 		2. map ��ü��.size() : ��Ʈ�� ����
		 		3. map ��ü��.get( Ű ��ü ) : �ش� Ű�� ���� ȣ���Ѵ�
		 		4. map ��ü��.keyset() : map��ü �� ��� Ű ȣ�� ����
		 		5. map ��ü��.values() : map ��ü �� ��� �� ȣ�� ����
		 			Ű(�ߺ�x)�� �˰� ������ ���� �� �� �ִ�.
		 			for(�ӽ� ��ü �� : map ��ü��.keyset() ) :
		 				@key ���� �ݺ��� ������ get. key�� �ĺ����̶� �ߺ� �Ұ���
		 		6. map ��ü��.remove() : map ��ü �� Ű�� ��Ʈ�� ����
		 		7. map ��ü��.clear() : map ��ü �� ��� ��Ʈ�� ����
		 		
		 		
		 	* List �÷��� : ����(�ε���) ���� = �迭 ����
		 	* Set �÷��� : ���� ���� ����, �ߺ� �Ұ���
		 	* Map �÷��� : Űset�� ��list���� �̷���� ��Ʈ�� ����(���� x)
		 		
		 	
		 	1. HashMap Ŭ������ ��ü ����
		 */
		HashMap<String, Integer> map = new HashMap<>();
	//Hashmap : �÷��� ������ ��ũ map Ŭ����
			//<���׸�, ���׸�> : key, valu�� ������ ���׸�
			//map : map ��ü��( �ƹ��ų� )
				//new : ��ü ������ �޸� �Ҵ�
				//hashmap<>() : ������
		
		//2. map ��ü�� �߰�
		map.put("�ſ��", 85); System.out.println("Ȯ�� : "+map);
			//����Ʈ = [��ü, ��ü, ��ü]
			//��Ʈ = [��ü, ��ü, ��ü]
			//�� = { Ű = �� }
		map.put("ȫ�浿", 90); System.out.println("Ȯ�� : "+map);
		map.put("ȫ�浿", 80); System.out.println("Ȯ�� : "+map);

			//key�� �ߺ� �Ұ���
		map.put("ȫ�浿", 95); System.out.println("Ȯ�� : "+map);
			//�ߺ������� ���������

			//valu�� �ߺ� ����
		map.put("���缮", 95); System.out.println("Ȯ�� : "+map);
			//�̰� �ȴ�

		
		System.out.println("==========");

		
		//3. map��ü��.size() : ��Ʈ�� �� (3�� ���´���,)
		System.out.println("map ��ü �� ��Ʈ�� �� :"+map.size());

		//4. map��ü��.get() : map ��ü Ű -> �� ȣ�� (95�� ���´�.)
		System.out.println("map ��ü �� ȣ�� : "+map.get("���缮"));
	

		
		System.out.println("==========");

		
		
		//5. ��� key ȣ��
		System.out.println("map ��ü �� Ű ȣ��"+map.keySet());
		
		//6. ��� value ȣ��
		System.out.println("map ��ü �� �� ȣ��"+map.values());

		
		System.out.println("==========");
		

		//7. �ݺ��� [key �ݺ��� �̿��ؼ� ��� value ȣ�� ����]
		for(String temp : map.keySet() ) {
			System.out.println(temp + " : "+map.get(temp));
		}
		
		
		System.out.println("==========");
		
		//8. ����
		map.remove("ȫ�浿"); System.out.println("Ȯ�� : "+map);
		
		//9. ��� ����
		map.clear(); System.out.println("Ȯ�� : "+map);
		
		
	}
}
