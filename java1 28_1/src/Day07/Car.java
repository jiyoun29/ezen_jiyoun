package Day07;

public class Car {
	// 클래스 선언
	
	
	// 1. 필드
	int gas; // 가스변수
	
	// 2. 생성자
		// 생성자 없으면 기본생성자
	
	// 3.메소드
		// 1. gas를 외부로부터 받아서 내부에 저장하는 메소드 역할
	void setGas(int gas) { //인수o반환x
		//리턴x 메소드명 아무거나(인수1){내부변수 = 외부변수 변환}
		this.gas = gas;
		
		//내부변수와 외부변수와 이름이 동일할때 구별하는 방법
			//this.필드명 : 내부(현재클래스)변수 => 사용 가능
	}
	
	//두번째 메소드
	//2. 내부변수 gas에 데이터 확인[0=가스없다=false][1이상=가스있다=true]
	boolean isLeftGas() {
		// 논리반환 메소드명()
			// 메소드명 아무거나, 인수도 없지만 반환은 있음(들어오는거 없고 나가는 걳만)
		if(gas == 0) {
			System.out.println("gas가 없습니다. false"); return false;
			// 내부 변수에 gas가 0이면 false 반환
		} else { System.out.println("gas가 있습니다. true"); return true; }
		// 내부 변수에 gas가 0이 아니면 true 반환
		
	}
	
	//3. gas가 0일때까지 실행하는데 실행할때마다 가스 1씩 감소 메소드
	// gas 0이면 함수 종료
	void run() { //인수x 반환x(들어오는거x나가는거x)
		while(true) { //무한루프 생성
			// 무한루프 종료=메소드 종료. break, return, 스위치 변수.
			if(gas>0) //gas가 0보다 크면
			{System.out.println("달립니다. : " +gas+ ")" ); gas--;}
			//gas변수 1씩 차감
			else {System.out.println("멈춥니다. (gas 잔량 : " + gas + ")");}
			return; //함수 탈출(종료). break는 반복문 탈출(종료)
		}
		
		
	}
	

}
