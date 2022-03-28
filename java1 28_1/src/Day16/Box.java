package Day16;

public class Box { // day16_1 

	//필드
	private Object object; //수퍼클래스(최상위 클래스)

	//메소드
	public void set(Object object) { //저장
		this.object = object;
	} //get을 사용해서 // day16_1 에 오브젝트를 넘김
	//부모는 자식이 될수x
	
	
	public Object get() { //호출
		return object;
	}
	
	
	
	
}
