package Day06;

public class Day06_4 {

		public static void main(String[] args) {
			
			//외부. 설계도(car2)가 내부
			
			// 빈 생성자로 객체 생성
			Car2 yourCar = new Car2();
			// 이건 안 된다. 생성자가 없으면 기본 생성자가 생기지만 하나라도 있으면 x
			// 외부로부터 들어온게 없으면 깡통.
			
			Car2 myCar = new Car2("검정",3000);
				// new 생성자명( 인수1, 인수2) : 검정->color변수에 저장, 300->int cc변수에 저장
			//외부로부터 들어온게 있는 통.(음료통)
			
			//코드에는 정답이 없으므로 둘 중 어느게 사용이 될지는 판단에 따름
			
			
			
		} // me
} // ce
