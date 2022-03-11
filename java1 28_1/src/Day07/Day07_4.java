package Day07;

public class Day07_4 {
	//p.229 : 외부호출
	
	public static void main(String[] args) {
		
		//외부호출을 위해서 반드시 객체 생성
		//1. 객체 생성
		Car2 myCar = new Car2();
		//2. 자동차 시동 걸기 메소드 호출
		myCar.keyTurnOn(); // 인수x반환x
		//3. 자동차 전진 메소드 호출
		myCar.run(); //인수x반환x
		//4. 현재 스피드 확인 메소드 호출
		int speed = myCar.getSpeed(); // 인수x반환o
		//반환이 있으므로 그 값을 저장할 int까지 입력.
		
		System.out.println("현재 속도 : "+speed+"km/h");
		
	}
	

}
