package Day14;

public class day14_3_컨트롤러 { //day14_3_메소드

	//1.메소드
		//static의 차이점
		//객체를 쓸 건지 static으로 쓸건지를 먼저 결정
	
	
		//입차메소드[인수o반환o]
	public boolean 입차(String 차량번호) {
		
		//코드 실행 자리
		
		return true;
		
		//입차메소드[static 메소드는 객체 없이 호출 가능]
	} public static boolean 입차2(String 차량번호) {
		
		return true;
		//true로 넘겨주므로 boolean
		//만일 string일 경우 반환 타입이 return "안녕"이 될 수도 있음
	}
	
	
		//출차 메소드
	//인수는 있으나 돌려주는 것이 없음
	
	public void 출차(String 차량번호) {
		//코드 실행 자리
		//void는 return 생략 가능
	}
	
	
		
		//매출 메소드
	public String 매출() {
		//코드 실행자리
		
		return "오늘 매출은 ---- 입니다.";
	}
	
	
	
		//차량리스트
	public void 차량리스트() {
		//코드실행 자리
	}
	
	
	//@본인이 주고 받는 자료형에 따라 누구를 받고 보내고를 선택하는게 중요
	//인수자리(String), 반환타입(bollean, void...)자리 잘 보기
	
	
	
	
	
}
