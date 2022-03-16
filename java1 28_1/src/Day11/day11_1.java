package Day11;

public class day11_1 {
	
	
	/* p.386 확인문제
		1. 3 [인터페이스 멤버 : 상수필드, 추상메소드, 디폴트메소드, 정적메소드]
		2. 4 [인터페이스 변수 = 구현객체]
			구현객체 = 클래스가 implements한 객체
	*/

	
	private static void printSound ( Soundable soundable ) {
	//접근제한자 정적  반환타입  메소드명    ( 인수[변수 배열 객체 인터페이스])
		//바로 호출하려고 static
		System.out.println(soundable.sound());
	}
	
	
	
	public static void dbwork(DAO DAO) {
		
	}
	//????????????
	
	
	
	public static void main(String[] args) {
		
		//3.
		printSound(new Cat());
				   //구현객체
		printSound(new dog());
		
		Soundable soundable = new Cat(); //2번의 2번
					//매개 변수가 인터페이스 타입일 경우 다양한 구현 객체를 대입할 수 있다.
		Soundable[] soundables = new Cat[100]; //2번의 3번
					//배열이 인터페이스 타입일 경우 다양한 구현 객체를 저장할 수 있다.
				//배열로 생성(인터페이스 여러개 배열에 저장)	
	
	
	//4.
	//관례적으로 사용되는 단어(여러명이서 일할때)
		//Dao:DB접근 객체. 데이터베이스에 접근할 때 쓰는 객체
		//Dto:데이터의 이동 객체. 서로다른 클래스 간 이동하는 객체
	dbwork(new Oracle_dao());
	dbwork(new mysqlDAO());
	
	
	
	//5. 익명객체 [인터페이스 직접 구현]
		//구현객체 : 인터페이스 객체명 = new 클래스();
		//익명객체 : 인터페이스 객체명 = new 인터페이스(){구현}; //1회용
	Action action = new Action() {
		
		@Override
		public void work() {
			System.out.println("복사를 합니다.");
		}
	}; //구현끝(세미클론 필수)
	//자동으로 추상메소드 생성. 안에 구현만 하면 된다
	
	
	action.work();
	
	
	
	
	
	
	
	
	
	}
	
}
