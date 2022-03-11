package Day07;

public class Calculator2 {
	
	//1. 필드
	
	//2. 생성자
	
	//3. 메소드
//두 번 불러내고 두 번 돌려받아 1로 올라온다.
		// 1. 실행 메소드
	void execute() { //인수값 x 반환값 x 없는 함수
		double result = avg(7,10);
		println("실행 결과 : "+result);
	}
	
		// 2. 평균 메소드
	
	double avg(int x, int y) { //인수가 있고 반환도 있다.
		double sum = plus(x, y); //합계 먼저 구하는데 합계 함수 만든다.
		double result = sum / 2; return result;
	}
	
	
		// 3. 더하기 메소드
	
	int plus(int x, int y) {//인수가 있고 반환도 있다.
		int result = x+y; return result;
	}
	
	
		// 4. 결과 출력 메소드
	
	void println(String message) { //인수있지만 반환없다.
		System.out.println(message);	}
	
	
	

}
