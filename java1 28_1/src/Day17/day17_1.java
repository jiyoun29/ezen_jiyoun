package Day17;

public class day17_1 { //658
	public static void main(String[] args) {
		
		//제네릭
			//선언 : public class 클래스명 <제네릭 이름>
			//목적 : 외부로부터 받은 자료형으로 내부에 해당 자료형 사용
		
		
		//1. 객체 생성
		Box<String> box1 = new Box<String>();
		//박스에 스트링 넣고 이름 정함
		//클래스에 String 타입 넣기
		box1.set("홍길동"); //이름 추가
		String str = box1.get();
		
		//2. 객체 생성
		Box<Integer> box2 = new Box<>();
		//클래스에 Integer 타입 넣기		생략 가능(넣어도 되고 안 넣어도 ok)
		box2.set(6);
		int value = box2.get();
		
		
		
		//659
		//1. 객체 생성하는데 제네릭 타입 넣기
		product<TV, String> product1 = new product<>();
		
		//2. 각 객체 내 필드에 각 제네릭 타입으로 값을 넣음
		product1.setKind(new TV() );
		product1.setModel("스마트 TV");
		
		//3. 호출
		TV tv = product1.getKind(); //형 변환 없다.
		String tvmodel = product1.getModel();
		
		
		
		//car
		//1.객체 생성하는데 제네릭 타입 넣기
		product<Car, String> product2 = new product<>();
		
		//2. 객체내 필드에 각 제네릭 타입으로 값 넣기
		product2.setKind(new Car());
		product2.setModel("디젤");
		
		//3. 호출 (본인 걸 넣고 빼는 거라 형 변환이 없다.)
		Car car = product2.getKind();
		String carmodel = product2.getModel();
		
		
		//
		product<Integer, double> product3 = new product<>();
		
		
		
		
		
		
		
		
		
//////////////////////////////////////////////////////////		
	}
}
