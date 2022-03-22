package Day15;

public class 학생 extends 사람 { //day15_1, 사람, 직업
	// 자식클래스 		상속	 부모클래스
	
	
	//필드
	String 이름;
	
	
	//생성자
	public 학생(String 이름) {
		//this는 본인 것을 부르는 거
		super(이름);
	}
	
	
	//메소드
	//@ 하나 만들고 이름을 넣어보자.
	
	@Override //꼭 안 적어도 괜찮음(초록삼각)
	//오버라이드는 부모 클래스 내 동일한 메소드(동일한 메소드명/인수)를 지니고 있을 때 사용
	
	public void 이름호출() {
		System.out.println("자식 클래스에서 실행");
		System.out.println(this.이름);
		//상속을 받으면 현 클래스에 없는 필드가 부모클래스에 존재하면 사용이 가능하다.
		System.out.println(super.이름); //부모의 것.사람 불러오기

	}

}
