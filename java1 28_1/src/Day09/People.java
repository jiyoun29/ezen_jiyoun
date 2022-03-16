package Day09;

public class People { //day09_2
	
	//1. 필드
	public String name;
	//접근제한자 자료형 변수명;
	public String ssn;
	
	//2. 생성자
	public People(String name, String ssn) {
		//super();를 명시 안 해도 된다. 상속 없으면 수퍼는 오브젝트.
		//모든 클래스는 꼭대기에 항상 오브젝트가 있다. 하겠다고 안 해도 있음.
		this.name = name;
		this.ssn = ssn;
	}

	
	//3. 메소드

}
