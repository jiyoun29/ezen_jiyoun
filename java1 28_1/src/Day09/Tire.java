package Day09;

public class Tire { //클래스 선언. 부모로 사용할 예정

	//1.필드
	public int maxRotation; //최대 회전수[회전가능수]
	public int accumulatedRotation; //누적 회전수
	public String location; //타이어 위치
	
	//2. 생성자
	//객체 생성 시 초기값을 말함.
	public Tire( String location, int maxRotation ) {
			//타이어의 위치와 최대 회전수.
		this.location = location; //그것을 this, 즉 외부로부터 전달받은 인수를 내부변수에 대입한다.
		this.maxRotation = maxRotation;
	}
	
	//3. 메소드
	public boolean roll() { //타이어 회전 구현 메소드
		accumulatedRotation++; // 누적 회전수를 1 증가. 타이어 회전
		if(accumulatedRotation < maxRotation) {
			//만일 누적 회전수가 최대 회전수보다 적으면 수명이 남았다...는 뜻. 같거나 크면 수명이 없다는 것.
			System.out.println(location+"Tire 수명 : "+(maxRotation - accumulatedRotation)+"회");
			return true;
		} else { //아니면 수명 없다.
			System.out.println("***" + location + "Tire 펑크"+"***");
			return false;
		}
	}
	
}
