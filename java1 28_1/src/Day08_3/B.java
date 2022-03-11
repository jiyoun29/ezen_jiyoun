package Day08_3; //A클래스와 동일 패키지

public class B { //A와 패키지는 같지만 클래스가 다르다.
	//private 접근 불가능
	
	// 1.필드
	A a1 = new A(true);
	A a2 = new A(1);
//	A a3 = new A("문자열");
	
	//2. 생성자
	
	public B( ) {
		
		A a = new A(true);
		a.field1 = 1;
		a.field2 = 1;
	// a.field3; -> private라서 사용 불가능
		
		
		a.method1();
		a.method2();
		
		
	}
	
	
	//3. 메소드
	
}
