package Day15;

public class day15_5 {
	/*591 ����ȭ
	��Ƽ������ ��� �� ����ȭ ����
	���Ͻ����� ��� �ÿ��� ����ȭ �ʿ�x
	* ���� �����尡 ������ �޼ҵ带 ȣ���Ѵ�
	���ôٹ������� �ϳ��� �޼ҵ� ȣ��(�켱���� � ����)
	*/
	
	public static void main(String[] args) {
		
		
//��1) 592 ����ȭ ���� �޼ҵ� ��� ��(����ȭ�� ���� ���)
		//2���� �����尡 ������ �޼ҵ忡 ȣ���� ��

	//1. ���� ��ü ����	
//	Calculator ���� = new Calculator();
//	
//	//2. user1 ����(��ü) ����
//	User1 user1 = new User1();
//	//���� ��ü�� user1 ����(����)
//	user1.setCalculator(����);
//	user1.start();
//	
//	//3. user2 ����(��ü) ����
//	User2 user2 = new User2();
//	//���� ��ü�� user2 ����(����)
//	user2.setCalculator(����);
//	user2.start();
	
		Calculator ���� = new Calculator();
		
		// 2. user1 ��ü ���� 
		User1 ���1 = new User1();
		// * ���� ��ü�� user1 ����[����]
		���1.setCalculator(����);
		���1.start();
		
		// 3. user2 ��ü ���� 
		User2 ���2 = new User2();
		// * ���� ��ü�� user2 ����[����]
		���2.setCalculator(����);
		���2.start();

	
	
	
	}
}
