package Day06;

public class Day06_2 {
	
	public static void main(String[] args) {
		
	
	 // 설계도 없으면 선언 불가. 클래스 생성
	// 1. 클래스(설계) 후 -> 객체 생성
	Car myCar = new Car();  // 객체 생성
		// 1. Car : 정의된 클래스명
		// 2. myCar :객체이름[아무거나]
		// 3. new : 메모리 할당 연산자
		// 4. Car() : 생성자
	
	//2. 객체 내 필드 호출 [.=접근연산자(객체 내 멤버 접근)]
	System.out.println("제작회사 : "+ myCar.company);
		//myCar 객체 내 필드 접근을 위해 myCar.으로 점을 찍는다.
		//객체를 먼저 쓰고 객체를 불러와 필드명을 적는다. myCar.이름 <-불러내진다.
	System.out.println("모델명 : "+ myCar.model);	// myCar.model ->모델필드 호출.
	System.out.println("색깔 : "+ myCar.color);	// myCar.color : color 필드 호출.
	System.out.println("최고속도 : " + myCar.maxSpeed);	// myCar.maxSpeed : maxSpeed 필드 호출
	System.out.println("현재속도 : " + myCar.speed);	// myCar.speed : speed 필드 호출
	
	//내용물 확인 = . <<붕어빵 안을 까보고 싶을때 .을 찍음. 접근이 가능해짐
	//설계도가 있으면 객체를 가지고 필드에 접근이 가능
	
	// 3. 객체내 필드 값 변경 가능
	myCar.speed = 60;
		// myCar 객체 내 speed 필드를 호출하여 60 데이터를 대입
	System.out.println("수정된 속도 : " + myCar.speed);
	
	// new = 하나당 새로운 칸을 만든다.
	// 새로운 자동차 객체 생성
	Car yourCar = new Car();
	//첫번째 객체가 모습을 바꾸더라도 두번째 객체는 독립적이다.
	System.out.println("2번 자동차 : " + yourCar.speed);
	
	
	
	
	
	
	
	
	
	
	
	
	
	}//me
} // ce
