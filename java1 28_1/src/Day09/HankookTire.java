package Day09;

public class HankookTire extends Tire {
		//서브클래스 extends 슈퍼클래스
	
	//1.필드
	//2.생성자
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
		//super(인수1, 인수2) // 수퍼클래스 내 인수 2개 생성자 호출
	}
	
	//3.메소드
		//ctrl+space로 roll을 오버라이드
	@Override //수퍼클래스 내 메소드를 재 정의. 수정.
	public boolean roll() {
		accumulatedRotation++; //아까 사용했던 것이므로 따로 주석x
		if(accumulatedRotation < maxRotation ) {
			System.out.println(location + "한국타이어 수명 : "+ (maxRotation-accumulatedRotation));
		return true; }
	else { System.out.println("*** "+location+"한국타이어 펑크 ***");
		return false;	}
	

		/////////////////////////
}
	
}
