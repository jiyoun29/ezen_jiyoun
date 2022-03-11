package Day07;

public class Day07_2 {
	public static void main(String[] args) {
		
		//p.223~224 : 리턴 값이 없는 메소드(void)
		
		//1.객체 선언[빈 생성자=기본생성자]
		Car mycar = new Car();
		//2. 메소드 호출 [인수 1개 =5]
		mycar.setGas(5);
		//필드에서 바로 넣거나 메소드로 불러오거나 같음(mycar.gas=5;)
		
		
		// 3. 메소드 호출[인수x 반환=true 혹은 false]
		if(mycar.isLeftGas()) //메소드 gas에 있는 코드를 가져옴
		{ //가스가 있을 때에는 출발. 위에서 5를 저장했으므로 출발
			System.out.println("출발합니다.");

			// 4. 메소드 호출[인수x 반환x]		
			mycar.run(); //gas가 5개 이므로 0이 될때까지 달린다.	
		}
		 // 5. 메소드 탈출
		if(mycar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else { System.out.println("gas를 주입하세요.");
		}
		
		
		
		
		
		
		///////////////
	}

}
