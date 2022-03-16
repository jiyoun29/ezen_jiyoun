package Day10;

public class day10_2 {
public static void main(String[] args) {
	
	/*인터페이스
		목적 : "동일한 목적" 하에 동일한 기능을 수행
			서로 다른 클래스들 간의 객체들을 동일한 목적으로 조작
		선언o구현(정의)x = 추상
			인터페이스에서 선언하고 각 클래스들이 구현한다. [다형성]
			인터페이스는 구현x
		예) 인터페이스 : 방향키, A버튼, B버튼
			1. 철권게임 클래스 A버튼 공격 B버튼 방어
			2. 축구게임 클래스 A버튼 슛 B버튼 방어
	*/
	
	//1.인터페이스 객체 선언
	RemoteControl rc;
	//인터페이스명 객체명
	//2. 인터페이스에 텔레비전 클래스 메모리를 할당하는 것 
	rc = new Television();
	///3. 인터페이스 실행
	rc.trunOn(); //tv 실행 메소드
	rc.trunOff(); //tv 종료 메소드
	rc.setVolume(10); //tv 소음 변경 메소드
	
	//4. 인터페이스 내 클래스 메모리 교체
	//오디옹 클래스 메모리 할당[교체]
	rc = new Audio();
	
	//5.인터페이스 실행
	rc.trunOn();
	rc.trunOff();
	rc.setVolume(5);
	
	//** 익명 구현 객체
	// 클래스 없이 인터페이스 추상 변수를 정의한다.
	RemoteControl rc2 = new RemoteControl() {
		
		//추상적인건 구현하고 쓰라고 나옴
		@Override
		public void trunOn() {
			System.out.println("리모콘을 켭니다.");
		}
		
		@Override
		public void trunOff() {
			System.out.println("리모콘을 끕니다.");
		}
		
		@Override
		public void setVolume(int Volume) {
			System.out.println("현재 소음 : " +Volume);
		}
	};
			//인터페이스 객체명 = new 인터페이스명
	
	rc2.trunOn();
	rc2.trunOff();
	rc2.setVolume(10);
	
	
	//디폴트 메소드 호출
	
	rc2.setMute(true); //이미 인터페이스에서 구현이 되어있는 메소드
	
	//정적 메소드 호출
	RemoteControl.changeBattery(); //객체없이 가능.

	//메모리를 할당 받는 방법
		//메모리 할당 해야하는 이유
			//외부클래스 인터페이스 내
			//필드(저장 가능), 메소드(저장 가능) 사용시
	// new, static 연산자를 사용해 객체 생성하거나 전역 변수로 쓰거나
	//
	
	
	
	
	//코드보기
	
	//////////////////////////////////////////
	}
}
