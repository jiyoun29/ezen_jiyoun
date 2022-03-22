package Day15;

public class day15_5 {
	/*591 동기화
	멀티스레드 사용 시 동기화 설정
	단일스레드 사용 시에는 동기화 필요x
	* 여러 스레드가 동일한 메소드를 호출한다
	동시다발적으로 하나의 메소드 호출(우선순위 등에 문제)
	*/
	
	public static void main(String[] args) {
		
		
//예1) 592 동기화 없는 메소드 사용 시(동기화가 없을 경우)
		//2개의 스레드가 동일한 메소드에 호출할 때

	//1. 계산기 객체 생성	
//	Calculator 계산기 = new Calculator();
//	
//	//2. user1 설정(객체) 생성
//	User1 user1 = new User1();
//	//계산기 객체를 user1 설정(대입)
//	user1.setCalculator(계산기);
//	user1.start();
//	
//	//3. user2 설정(객체) 생성
//	User2 user2 = new User2();
//	//계산기 객체를 user2 설정(대입)
//	user2.setCalculator(계산기);
//	user2.start();
	
		Calculator 계산기 = new Calculator();
		
		// 2. user1 객체 생성 
		User1 사람1 = new User1();
		// * 계산기 객체를 user1 설정[대입]
		사람1.setCalculator(계산기);
		사람1.start();
		
		// 3. user2 객체 생성 
		User2 사람2 = new User2();
		// * 계산기 객체를 user2 설정[대입]
		사람2.setCalculator(계산기);
		사람2.start();

	
	
	
	}
}
