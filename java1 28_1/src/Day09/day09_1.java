package Day09;

public class day09_1 {
	public static void main(String[] args) {
		
		// 상속
			// 부모에게 물려받는 것
			// 현실 : 부모->자식 선택
			// 프로그래밍 : 자식->부모 선택
			// extends : 연장하다[상속하다]
			// 목적 : 빠른 설계 [ 기존에 있던 모범 코드, 클래스의 연장이자 연결 ]
				// 핸드폰 제조회사 설립할 때 뭘 할까?
					// 1. 핸드폰의 대조 -> 일일이 하지 않고 기본 설계에 따라 우리 회사만의 무언가를 추가한다.
			// 부모클래스는 무조건 1명. 상속은 딱 1명에게서만 받을 수 있다.
				//하지만 자식은 여러명 가능하다.
		
		//p290~292 예제
		
		//파란색이 부모의 것. 물려받았기 때문에 접근이 가능하다.
		
		// 1.서브클래스로 객체 생성
		DmbCellphone dmbCellphone = new DmbCellphone("자바폰", "검정", 10);
		
		//2. 서브클래스로 만들어진 객체로 슈퍼클러스내 멤버 접근
		System.out.println("모델 : "+dmbCellphone.model);
		System.out.println("색상 : "+dmbCellphone.color);
			
		//3. 서브클래스로 만들어진 객체로 본인 멤버 접근
		System.out.println("채널 : "+dmbCellphone.channel);

		//4. 서브클래스로 만들어진 객체로 슈퍼클래스 내 멤버메소드 접근
		dmbCellphone.powerOn(); //슈퍼클래스(부모) 내 선언된 메소드 [ 호출 가능 ]
		dmbCellphone.bell();
		dmbCellphone.sendvoice("여보세요");
		dmbCellphone.receiveVoice("안녕하세요, 저는 홍길동입니다.");
		dmbCellphone.sendvoice("반갑습니다.");
		dmbCellphone.hangUp();
		
		//5. 서브클래스로 만들어진 객체로 본인 멤버 접근
		dmbCellphone.turnOnDmb();
		dmbCellphone.changeChannel1Dmb(12);
		dmbCellphone.turnOffDmb();
		
		
		//////////////////////////////////////////////
	}
}
