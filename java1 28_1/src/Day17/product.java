package Day17;

public class product<���׸�Ÿ��1, ���׸�Ÿ��2> { //659
				//�ܺηκ��� ���� �ڷ��� �̸� : �ƹ��ų�
				//tv    string
	//�ʵ�
	private ���׸�Ÿ��1 kind; //tv, car, Integer
	private ���׸�Ÿ��2 model; //string. String, double
	
	public static <���׸�Ÿ��1> Box<���׸�Ÿ��1> boxing(���׸�Ÿ��1 kind){
		
		//�޼ҵ带 �����ϴ� ���, �����
		//1. ����������
		//2. ����
		//3. ��ȯŸ�� : void, string�� �ƴ϶� <���׸�Ÿ��1> Box<���׸�Ÿ��1>
		//boxing: �޼ҵ��̸�. (���׸�Ÿ��)
		
		Box<���׸�Ÿ��1> box = new Box<>();
		box.set(kind);
		
		return box;
	}

	
	//get
	//set
	
	public ���׸�Ÿ��1 getKind() {
		return kind;
	}
	public void setKind(���׸�Ÿ��1 kind) {
		this.kind = kind;
	}
	public ���׸�Ÿ��2 getModel() {
		return model;
	}
	public void setModel(���׸�Ÿ��2 model) {
		this.model = model;
	}
	
	
	
	

}
