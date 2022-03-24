package Day17;

public class product<제네릭타입1, 제네릭타입2> { //659
				//외부로부터 받을 자료형 이름 : 아무거나
				//tv    string
	//필드
	private 제네릭타입1 kind; //tv, car, Integer
	private 제네릭타입2 model; //string. String, double
	
	public static <제네릭타입1> Box<제네릭타입1> boxing(제네릭타입1 kind){
		
		//메소드를 선언하는 방법, 선언부
		//1. 접근제한자
		//2. 정적
		//3. 반환타입 : void, string이 아니라 <제네릭타입1> Box<제네릭타입1>
		//boxing: 메소드이름. (제네릭타입)
		
		Box<제네릭타입1> box = new Box<>();
		box.set(kind);
		
		return box;
	}

	
	//get
	//set
	
	public 제네릭타입1 getKind() {
		return kind;
	}
	public void setKind(제네릭타입1 kind) {
		this.kind = kind;
	}
	public 제네릭타입2 getModel() {
		return model;
	}
	public void setModel(제네릭타입2 model) {
		this.model = model;
	}
	
	
	
	

}
