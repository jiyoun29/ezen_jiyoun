package Day07;

public class Day07_1 { // cs
	
	public static void main(String[] args) {
		
		//메소드 호출방법
			//1. 메소드가 존재하는 클래스의 객체 필요
			//2. 객체명.메소드명()
				// ex) scanner.nextInt();
				// . : 접근연산자(필드나 메소드 호출할때 사용)
		//1. 객체선언
		Calculator myCalc = new Calculator();
		//클래스명   객체명[이름]     (기본)생성자(클래스 이름과 동일)
				// = 메모리 할당 연산자
		
		//2. 메소드 호출
		myCalc.powerOn();
		
		//3. 메소드 호출 [ 인수 2개 ] 
		int result1 = myCalc.plus(5, 6);
		System.out.println("result1 : "+ result1);
		// 돌려 받은 다음 뭐 할건지도 필요(써먹을거면 저장)
			//plus메소드에 5와 6 전달 후에 11이라는 결과값 받기
		
		//4. 메소드 호출 [ 인수 2개 ]
		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("result2 : "+result2);
		
		
		//5.메소드 호출[인수x]
		myCalc.powerOFF();
		
	}
	
} // ce
