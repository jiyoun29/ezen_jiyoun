package Day17;

public class day17_1 { //658
	public static void main(String[] args) {
		
		//���׸�
			//���� : public class Ŭ������ <���׸� �̸�>
			//���� : �ܺηκ��� ���� �ڷ������� ���ο� �ش� �ڷ��� ���
		
		
		//1. ��ü ����
		Box<String> box1 = new Box<String>();
		//�ڽ��� ��Ʈ�� �ְ� �̸� ����
		//Ŭ������ String Ÿ�� �ֱ�
		box1.set("ȫ�浿"); //�̸� �߰�
		String str = box1.get();
		
		//2. ��ü ����
		Box<Integer> box2 = new Box<>();
		//Ŭ������ Integer Ÿ�� �ֱ�		���� ����(�־ �ǰ� �� �־ ok)
		box2.set(6);
		int value = box2.get();
		
		
		
		//659
		//1. ��ü �����ϴµ� ���׸� Ÿ�� �ֱ�
		product<TV, String> product1 = new product<>();
		
		//2. �� ��ü �� �ʵ忡 �� ���׸� Ÿ������ ���� ����
		product1.setKind(new TV() );
		product1.setModel("����Ʈ TV");
		
		//3. ȣ��
		TV tv = product1.getKind(); //�� ��ȯ ����.
		String tvmodel = product1.getModel();
		
		
		
		//car
		//1.��ü �����ϴµ� ���׸� Ÿ�� �ֱ�
		product<Car, String> product2 = new product<>();
		
		//2. ��ü�� �ʵ忡 �� ���׸� Ÿ������ �� �ֱ�
		product2.setKind(new Car());
		product2.setModel("����");
		
		//3. ȣ�� (���� �� �ְ� ���� �Ŷ� �� ��ȯ�� ����.)
		Car car = product2.getKind();
		String carmodel = product2.getModel();
		
		
		//
		product<Integer, double> product3 = new product<>();
		
		
		
		
		
		
		
		
		
//////////////////////////////////////////////////////////		
	}
}
