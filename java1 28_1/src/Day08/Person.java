package Day08;

public class Person {
	
	// static final : 프로그램 전반적으로 사용되는 상수 (변수 앞에 붙는다.)
	static final double pi = 3.14;
	// static : 프로그램 전반적으로 사용되는 변수
	static double pi2 = 3.14;
	// final : 객체 내에서 사용되는 상수(객체 필요)
	final double pi3 = 3.14;
	
	// 설계에 따라 고정으로 쓸지를 판단
	// 불변의 상수를 만들 때에는 static final
	

	// 1. 필드
	String nation = "Korea"; //고정값
	String ssn; //final을 넣으면 수정 불가능
	String name;

	//2. 생성자(객체 초기화)
	// 우클릭 소스 필드
	public Person(String ssn, String name) {
		super();
		this.ssn = ssn;
		this.name = name;
	}
	
	//3. 메소드
	
	
	
}
