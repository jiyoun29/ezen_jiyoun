package Day17;

public class day17_2 {
		public static void main(String[] args) {
			
			//1.��ü ����
			Box<Integer> box1 = new Box<>();
			
			//2. �޼ҵ� ȣ�� �� ������� ��ü�� ����
			box1 = Util.<Integer>boxing(100);
			
			//3.Ȯ��
			System.out.println("Ȯ�� : "+ box1.get());
			
			
			//662~663
				//p1 ��ü�� �����ϴµ� �����ڿ� ����1�� ���ڿ� '���' �ֱ�
			//���� : ���׸�<����, ���ڿ�>
			Pair<Integer, String > p1
			= new Pair<Integer, String>(1, "���");
			
			//2. P2 ��ü
			Pair<Integer, String> p2
			= new Pair<Integer, String>(1, "���");
			
			//3. �񱳸޼ҵ� ȣ��
			boolean result1 = Util.<Integer, String>compare(p1, p2);

			//4. ��� ����
			if(result1 ) {
				System.out.println("������ ��ü");
			} else {
				System.out.println("�������� ���� ��ü");
			}
			
			
			
			
			
			//
		Pair<String , String> p3 = new Pair<String, String>("user1", "ȫ�浿");
		Pair<String , String> p4 = new Pair<String, String>("user2", "ȫ�浿");
		
		boolean result2 = Util.compare(p3, p4);
		if(result2) {
			System.out.println("������ ��ü");
		} else {
			System.out.println("�������� ���� ��ü");
		}
			
			
			
			
			
/////////////////////
		}
}
