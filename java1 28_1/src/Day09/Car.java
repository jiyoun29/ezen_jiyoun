package Day09;

public class Car { //tire.
	//클래스 선언
	
	//1. 필드 (변수, 객체, static 변수)
	//뒤 숫자는 타이어 수명 넣어본거
	Tire frontLeftTire = new Tire("앞왼쪽", 6);
	Tire frontRightTire = new Tire("앞오른쪽", 2);
	Tire backLeftTire = new Tire("뒤왼쪽", 3);
	Tire backRightTire = new Tire("뒤오른쪽", 4);
	//클래스명 객체명 = new 생성자(타이어 위치, 타이어 수명);
		
	//2.생성자
	// X
	
	//3.메소드
	int run() { // 자동차 회전 [모든 타이어객체가 1회씩 회전]
		System.out.println("자동차가 달립니다.");
		//타이어 돌리기
		if(frontLeftTire.roll() == false) {stop(); return 1;} //리턴=1 [앞왼쪽 타이어 펑크]
		//타이어가 회전을 했는데 결과가 false이면 펑크
		//true이면 수명 남아있음		
		if(frontRightTire.roll() == false) {stop(); return 2;} //리턴=2 [앞오른쪽 타이어 펑크]
		if(backLeftTire.roll() == false) {stop(); return 3;} //리턴=2 [뒤왼쪽 타이어 펑크]
		if(backRightTire.roll() == false) {stop(); return 4;} //리턴=2 [뒤오른쪽 타이어 펑크]
		return 0; //리턴이 0이면 펑크x. 리턴=1 [앞왼쪽 타이어 펑크]
	}
	//
	void stop() {
		System.out.println("자동차가 멈춥니다.");
	}
	//객체 4개를 만들고 run.
	
	
	
}
