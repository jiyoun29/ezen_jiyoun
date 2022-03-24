package Day17;

public class Box<T> {	//day17_1
		// <제네릭타입>
		// 변수명처럼 <>는 아무거나 ㄱㅊ
		//자료형의 이름이 되어주는 것
	
	//필드
	private T t; 
	
	//get 메소드
	public T get() {
		return t;
	}
	
	//set 메소드
	public void set(T t) {
		this.t = t;
	}
	

}
