package Day15;

public class day15_2 {//게임패드
	
	public static void main(String[] args) {
	
		/*인터페이스 [ ]
			동일한 목적을 가지고 있는 서로 다른 객체를 조작하기 위하여 사용.
			@동일한 목적이 생기면 그때 묶음
		
			1. 인터페이스의 멤버
				상수필드, 추상 메소드, default 메소드, 정적 메소드
			2. 사용방법
				public class 클래스명 implements 인터페이스명
				!필수 : 반드시 추상메소드 구현
			3. 구현객체 생성
				클래스로부터 메모리를 할당 받으면
			4. 익명객체 생성
				인터페이스에서 직접 구현				
		 */
		
		// 예1) 구현객체 만들기 : 구현한 메소드를 재사용 가능
	게임패드 pad1 = new 메이플스토리();
	//인터페이스명 객체명 = new 구현(implements)한 클래스명();

		// 예2) 익명객체 만들기 : 구현한 메소드를 재사용 불가능(@한번 쓰고 버릴때 사용)
	//인터페이스명 객체명 = new 인터페이스명(){ 추상메소드 구현 }
	게임패드 pad2 = new 게임패드() { //ctrlspace로 가져옴
		
		public void A버튼() {	
		}
		public void B버튼() {
		}
		public void C버튼() {
		}		
	}; //구현 끝		
		
	///////////////////////////////////////	

	//인터페이스 내 구현객체 교체
	//게임교체와 유사함
	
	pad1 = new 피파온라인();

	
	//클래스만 써도 게임교체가능
	//@게임클래스 하나 만들기
	게임 g1 = new 게임();
	g1 = new 메이플스토리();
	g1 = new 피파온라인();	
	
	///////////////////////////////////////	

		/*상속extends vs 인터페이스interpace
연결수 		   1			다중(여러개)
override  	재정의(수정)		구현(정의)
다형성	  	부모<-자식			부모<-자식
목적			모범 클래스 연장		동일한 목적의 서로 다른
			(빠른 설계)		클래스를 조작하기 위해
							(추상)
	*/
	
	
	
	
	
	
	
	
	}
}
