package Day08;

public class Day08_1 {
	
	public static void main(String[] args) {
		
		//p.238 : static
			// 정적변수
			// 공용적인 데이터 = 프로그램 전반적으로 사용하는 
		
		//1. 클래스내 필드, 메소드 접근방법
			// a) static 멤버가 아닐때 객체 생성 -> 객체.멤버
		 		// 객체가 생성할 때 new 연산자로 객체(내 멤버 포함) 메모리 할당
		Calculator calculator = new Calculator();
		//calculator의 static이 없어도 위와 같이객체 생성 후 pi 접근 가능
		System.out.println("객체를 이용한 멤버 접근 : " +calculator.pi);

		// static 멤버가 일때 -> 클래스명.멤버
		// class가 로딩 되고 메소드 영역에 static 변수에 메모리 할당
		System.out.println("객체 없이 멤버 접근 : "+calculator.pi);
		
		double result = 10 * 10 * calculator.pi;
								// 클래스명.정적변수명		
		int result2 = calculator.plus(10, 5);
		// 클래스에 static이 없으면 위와 같이 객체.멤버 로 불러오기
		int result3 = calculator.minus(10, 5);
		
		System.out.println("result1 : "+result);
		System.out.println("result2 : "+result2);
		System.out.println("result3 : "+result3);
		
	} //main end
}
