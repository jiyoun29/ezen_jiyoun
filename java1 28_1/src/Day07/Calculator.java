package Day07;

public class Calculator { //cs
	// p217
	//클래스 선언
	
	// 1. 필드
	
	// 2. 생성자
		// 만약에 생성자가 선언이 1개도 없으면 기본 생성자가 자동으로 추가 된다.
		// 기본생성자 : 매개변수(인수)가 없다.
	
	// 3. 메소드
	void powerOn() {  // 인수가 없고(소괄호가 빔) 반환도 없다.->함수에 인수와 반환을 구분할줄알아야함
		System.out.println("전원을 켭니다."); }
		// 1. void : 리턴타입
				// 함수가 종료되면서 나가는 데이터가 없다.
				//void 사용할 때에는 return 생략 가능
				// 단 실행부 중간에 사용시 함수 종료
					// 리턴을 만나면 나가버린다. 리턴 밑의 프린트는 사라짐
		// 2. powerOn: 메소드 이름[아무거나]
		// 3. (매개변수[인수]) : 함수로 들어오는 데이터
		// 4. { 실행코드 } : 함수 실행부

	int plus(int x , int y) { // 인수0 반환0
				// x = 5, x = 6
		int result = x+y;
		return result; //함수를 호출했던 곳으로 이동(day07_1의 3번으로)
	}
		//1. int: 리턴타입[함수가 종료되면서 int형 데이터가 반환]
			//5. return 반환값;
				//리턴 타입이 int이므로 return에도 int형 데이터
				//문자를 내보낼거면 string 써야함
				//
		//2. plus: 메소드이름[아무거나]
		//3. (int x, int y) : int형 2개 매개변수 받기
			// 함수 호출시 함수로 들어오는 x와 y는 int형으로 받기
		//4. { 실행부 }
	
	
	double divide(int x, int y) { //인수와 반환 구분 확실히 하기..익숙해질때까지
	// 리턴타입 메소드명 (인수1, 인수2) <-선언부 { 실행코드; return에는 무조건 실수데이터(double이므로) }
		double result = (double)x / (double)y;
			// (자료형)변수명 : 강제형변환
				//int형 변수를 double형 변수로 변경시키는 것
				//why? 나누기 후에 소수점이 나올 수 있으므로.
		
		return result; //결과값 ---> 메소드 호출했던 곳으로 이동
		
	}

	void powerOFF() { //인수x 반환x
		//리턴타입 메소드명() {}
		System.out.println("전원을 끕니다.");
	}
	
	
	
	
	
}
