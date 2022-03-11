package Day07;

public class Day07_3 {
	//메소드 호출시
		// 내부호출 : 메소드가 선언된 클래스[파일]내 메소드 호출 시
				//메소드 명만 사용
				//avg(인수1, 인수2);
		// 외부호출 : 메소드가 선언된 다른 클래스[파일]내 메소드 호출 시
				// 객체를 통해서 메소드명 호출
				// myCalc.avg(인수1,인수2);
	
	
	//p.227 내부호출
	
	public static void main(String[] args) {
		
		// 내부는 메소드명만 사용하면 된다.
		Calculator2 myCalc = new Calculator2();
		myCalc.execute(); //이 메소드를 외부에서 호출한다.(.) 찍었으므로
		
		
	}
	
	
}
