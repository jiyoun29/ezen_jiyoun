package Day16;

public class day16_1 { //656

	public static void main(String[] args) {
		
	//제네릭
		
		//656 비 제네릭 예제
		
		//1. box 객체 생성
		Box box = new Box();
		//2. Box에 set으로 저장
		box.set("홍길동"); //객체 내 메소드 호출하여 홍길동 저장 : 가능
		//인수 String -> Object 가능
		
		//3. 객체 내 메소드 호출 -> 반환 : Object
		String name = (String) box.get();
		
		//자식객체 -> 부모객체[자동형변환]
		//부모객체 -> 자식객체[자동x 강제o] (위에 코드의 소괄호 (String) 넣어서 변환)
		
		//4.
		box.set(new Apple()); //박스에 Apple을 넣는 건 가능
		//인수 = apple(사용자가 만든 클래스)
		Apple apple = (Apple) box.get();
		//(Apple) <-강제 형 변환
	
		//박스에는 여러가지가 들어갈 수 있지만
		//저장할 때에는 부모로 받아야 한다
		
		
////////////////////////////////////////////////////////		
	}
}
