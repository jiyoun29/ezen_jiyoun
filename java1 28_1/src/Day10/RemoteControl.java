package Day10;
// day10_2 
public interface RemoteControl { // 인터페이스 선언
	
	/*멤버 p.348
		1. 상수필드 : 고정된 데이터
		2. 추상 메소드** : 선언o 구현x
		3. 디폴트 메소드 : 선언o 구현o
		4. 정적 메소드 : 선언o 구현o [ 객체없이 가능 ]
		
	*/

	// 1. 상수필드 : 고정된 데이터
	public int MAX_VOLUE = 10; //리모컨 최대소음
	public int MIN_VOLUE = 0; //리모컨 최소소음
	
	
	// 2. 추상 메소드** : 선언o 구현x
	public void trunOn(); //{} : 중략 [구현x]
	public void trunOff(); //구현x
	public void setVolume(int Volume); //구현x
	
	
	// 3. 디폴트 메소드 : 선언o 구현o
	default void setMute ( boolean mute ) {
		if (mute) {
			System.out.println(" 무음 처리 ");
		} else {
			System.out.println("무음 해제");
		}
	}
	
	
	// 4. 정적 메소드 : 선언o 구현o [ 객체없이 가능 ]
	static void changeBattery() {
		System.out.println("건전지를 교체합니다.");
	}
	


}
