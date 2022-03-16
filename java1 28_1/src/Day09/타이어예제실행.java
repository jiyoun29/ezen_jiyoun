package Day09;

public class 타이어예제실행 {
	public static void main(String[] args) {
		
		//1. 객체 생성 [ 자동차 1대 생성 ]
		Car mycar = new Car(); //붕어빵 틀
		//car가 여기에.
		
		//클래스 내 타이어 객체가 4대 -> mycar 포함
		
		//2. 메소드 호출
		for(int i = 1; i<=5; i++) {
			int problemLocation = mycar.run(); //자동차 회전메소드 호출->5번
			//수명이 다해 펑크
			//run하면 펑크날 위치가 이리로 온다.
			
			//tire에 있는 roll이 이리로.
			//run할때마다 roll(회전)을 하는데 거기에 false, true를 넣어
			//만일 누적 회전수가 달리되면 펑크를 리턴.
			
		switch (problemLocation) {
		case 1: System.out.println("앞왼쪽 한국 타이어 교체");
			//형변환
			mycar.frontLeftTire = new HankookTire("앞왼쪽", 15);
		//슈퍼 클래스 객체명 = new 서브클래스() ;
		//상속 받아야만 가능!!!!
		//자식은 부모한테 형변환 가능.
			
			// Object object = new Tire("asd",13);
			// 최상위이므로 된다.
			
		break; //switch에선 break 필수. switch를 탈출.
		
		case 2: System.out.println("앞오른쪽 금호 타이어 교체");
			mycar.frontRightTire = new KumhoTire("앞오른쪽", 13);
		break;
		
		case 3: System.out.println("뒤왼쪽 한국 타이어 교체");
			mycar.backLeftTire = new HankookTire("뒤왼쪽", 14);
		break;
		
		//마지막은 브레이크 안 넣어도 된다
		case 4: System.out.println("뒤오른쪽 금호 타이어 교체");
			mycar.backRightTire = new KumhoTire("뒤오른쪽", 15);
		}
			
			
		}

		
		
		/////////////////////////////////
	}

}
