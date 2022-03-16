package Day09;

public class Cellphone { //day09_1
	//1. 필드
	String model; String color;

	//2. 생성자
	
	
	//3. 메소드
	
	void powerOn() {System.out.println("전원을 겹니다.");}
	//void가 없고 인수가 없다. -> 둘 다 들어오는 것도 나가는 것도 없다.
	//반환타입 메소드명(인수){실행코드} //인수반환x
	
	void powerOff() {System.out.println("전원을 끕니다.");}
	
	void bell() {System.out.println("벨이 울립니다.");}

	void sendvoice(String message) {System.out.println("나 : "+message);}
	//반환 없고 메소드명(인수가 있음){}
	
	//반환타입=리턴타입
	
	void receiveVoice(String message) {System.out.println("상대방 : "+message);}
	
	void hangUp() {System.out.println("전화를 끊습니다.");}
	
	//메소드는...틀리면 그때 보고 해석해서 알아가기
	//extend 사용해서 dmbcellphone 클래스로 끌고 간다.
	
////////////////////////////////////////////////////	
}
