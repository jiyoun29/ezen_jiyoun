package Day09;

public class KumhoTire extends Tire {
	//서브클레스 extends 슈퍼클래스
	
	//1.필드
	//2.생성자
	//상속 받은 다음 기입
	public KumhoTire(String location, int maxRotation) {
	super(location, maxRotation);
	//슈퍼 클래스 내 생성자 호출. 목적:코드 줄이기
	
	}
	
	//3.메소드
	
	
	@Override
	public boolean roll() {
		accumulatedRotation++; //아까 사용했던 것이므로 따로 주석x
		if(accumulatedRotation < maxRotation ) {
			System.out.println(location + "금호타이어 수명 : "+ (maxRotation-accumulatedRotation));
		return true; }
	else { System.out.println("*** "+location+"금호타이어 펑크 ***");
		return false; }
	//한국타이어에 적은거 가져옴
		
	}
}
