package Day08;

public class Day08_4 {
	
	//p.267~268 : Setter, Getter 메소드
		//필드는 privater로 사용되는 경우가 많다.
		//외부에서 필드로 접근이 불가능 하다.
		//목적 : 외부에서 필드에 직접 접근 제한하고 메소드를 통한 필드 접근
		//Setter 메소드 : 필드 데이터 변경
		//Getter 메소드 : 필드 데이터 호출

	public static void main(String[] args) {
		//1. 객체 생성
		Car myCar = new Car();
		//2. 객체내 메소드 호출 [setter 메소드]
		myCar.setSpeed(-50);
		//3. 객체내 메소드 호출 [getter 메소드]
		System.out.println("현재 속도 : "+ myCar.getSpeed());
		//4.
		myCar.setSpeed(60);
		System.out.println("현재 속도 : "+ myCar.getSpeed());
		//5.
		if(!myCar.isStop()) { //!느낌표 연산자는 false를 부정해서 true 값을 내놓는다.
			//정지 상태가 아니면
			// ! = 부정연산자[true를 false로, false를 true로]
			myCar.setStop(true);
		}
		System.out.println("현재 속도 : "+myCar.getSpeed());
	}
	
	
}
