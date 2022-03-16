package Day09;

public class Computer extends Calcurator {
	//서브클래스 extends 슈퍼클래스
	
	//1. 필드
	//2. 생성자
	//3. 메소드
		//오버라이딩[부모 클래스내 메소드 재정의(수정)]
	//ctrl+space->세모:오버라이드로 할건지 묻는것
	
	@Override //무조건 사용이 맞지만 editer(이클립스 등 툴을 제공해주는 것)를 쓰면 생략 가능
	// 상속을 준 부모가 가지고 있는 메소드 호출
	double areaCircle(double r) {
		System.out.println("Computer 객체의  areaCircle() 실행");
		return Math.PI * r * r;
	}
}
