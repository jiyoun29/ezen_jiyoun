package Day16;

public class day16_1 { //656

	public static void main(String[] args) {
		
	//���׸�
		
		//656 �� ���׸� ����
		
		//1. box ��ü ����
		Box box = new Box();
		//2. Box�� set���� ����
		box.set("ȫ�浿"); //��ü �� �޼ҵ� ȣ���Ͽ� ȫ�浿 ���� : ����
		//�μ� String -> Object ����
		
		//3. ��ü �� �޼ҵ� ȣ�� -> ��ȯ : Object
		String name = (String) box.get();
		
		//�ڽİ�ü -> �θ�ü[�ڵ�����ȯ]
		//�θ�ü -> �ڽİ�ü[�ڵ�x ����o] (���� �ڵ��� �Ұ�ȣ (String) �־ ��ȯ)
		
		//4.
		box.set(new Apple()); //�ڽ��� Apple�� �ִ� �� ����
		//�μ� = apple(����ڰ� ���� Ŭ����)
		Apple apple = (Apple) box.get();
		//(Apple) <-���� �� ��ȯ
	
		//�ڽ����� ���������� �� �� ������
		//������ ������ �θ�� �޾ƾ� �Ѵ�
		
		
////////////////////////////////////////////////////////		
	}
}
