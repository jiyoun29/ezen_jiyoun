package Day15;

import java.security.PublicKey;

public class 사람 extends 직업 { //day15_1, 학생, 직업
	//상속을 학생에게 주고 직업에게 받음
	
	//필드
	
	String 이름 ;

	
	//생성자
	public 사람( String 이름 ) {
	//@부모가 이렇게 생성자를 갖게 되었고 이름을 받을 때
	//학생에는 빨간줄이 들어간다. (부모에게 생성자가 있으므로)
		
		this.이름 = 이름;
	}
		
	//메소드 부모가 메소드를 가질 때
		//이름 호출
	public void 이름호출(){
		System.out.println("부모 클래스에서 실행");
		System.out.println(this.이름);
	}
		
	
	
}
