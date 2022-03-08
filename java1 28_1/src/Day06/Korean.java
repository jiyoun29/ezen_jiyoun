package Day06;

public class Korean {
	// Korean 클래스 선언
	
	//1. 필드
	String nation = "대한민국"; //국가변수
	String name; //이름 변수에는 초기화x[null]
	String ssn; //주민등록번호. 초기화x [null]
	
	//2. 생성자
		// 조건1. 생성자의 이름 == 클래스의 이름
		// 조건2. 외부로부터 들어오는 매개값[인수] 선언
		// 조건3. 동일한 생성자 이름을 가질 수 있다. [오버로딩]
				// 오버로딩 : 동일한 이름일 경우 재정의.
						// 이름은 같지만 코드는 다르다.
	
	Korean(){ //1. 깡통(빈 생성자)을 먼저 만들기(내용물x)	
		
	} 
	// 2. 필드 1개를 갖는 생성자
	Korean(String n){
		name = n;
	}
	
	// 2. 필드 2개를 갖는 생성자 
	Korean (String n , String s){
		name = n;
		ssn = s;
		// 내부변수 (현재 클래스내 변수)
		// 매개변수 (외부로부터 들어온 변수)
		// 내부변수 == 매개변수 : 충돌
			// 단, 내부변수 표기 방법 : this - 현재 클래스 표시
			// this.name = name; 
			// this.필드명 = 필드명 호출
		// 외부로부터 들어오는 값을 반환하지 않고 저장. 똑같이 하려면 this를 붙여 구분
	}
	
	// 3. 필드 3개를 갖는 생성자
	Korean(String nation, String name, String ssn){
		nation = nation; name = name; ssn = ssn;
	}
	
	
	//3. 메소드
	
	
}
