package Day17;

public class Course <T> {
		//���׸�<�̸�>
	//�ܺηκ��� ������ �ڷ���
	
	private String name; //�ڽ��̸�/������ : ���ڿ� ����*
	private T[] students; //�л��迭 : ���� ���������� ��
	//�ܺο��� ���׸����� ���� ���̹Ƿ� ���� �ڷ������� ��(�Ű� ���)
	
	
	//2. ������[�ܺηκ��� ������� �ο����� �޾Ƽ� �ο�����ŭ ���׸� Ÿ������ �迭�� �޸� �Ҵ�]
	public Course(String name, int capacity) {
					//������			�ο���
		this.name = name;
		students = (T[]) new Object[capacity];
					// �Ű�Ÿ������ new (�޸��Ҵ�) �ȵ�
				//1. new Object[�ο���] : �ο��� ��ŭ Object �迭 ����
				//2. Object �迭 -> T[]�迭�� ��������ȯ
				//Object Ŭ������ �ֻ���[�θ�] �̱� ������ ����
	}
	
	//�޼ҵ� : ������ ȣ�� �޼ҵ�
	public String getName() { return name; }
	
		// �л� �迭 ȣ�� �޼ҵ�
	public T[] getStudents() { return students; }
	
		//�л� �迭�� ��ü �߰��ϱ� [��̸���Ʈ�� ���]
	public void add(T t) {
		for(int i = 0; i<students.length; i++) {
			if ( students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}
	
	

	
	//���ϵ�ī�� : ? ���Ŭ��������
	//�ڽ����� ?�� ������ ��� ���׸� ����
	//�ڽ� ?  ��� Ŭ������ <-�ش� Ŭ�����κ��� ��ӹ���(�ڽ�) ���Ĥ����� ��� ����
	//�ڽ� ? super Ŭ������ <-�ش� Ŭ�����κ��� ����� �� (�θ�) ���׸� Ŭ���� ����

		public static void �ڽ����(�ڽ�<?> �ڽ����) {
			System.out.println(�ڽ����.getName()+"���������");
		}
	
	
	
	//2
	public static void �л��ڵ������(�ڽ�)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
