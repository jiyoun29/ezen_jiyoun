package Day09; //day09_1 + Cellphone

public class DmbCellphone extends Cellphone {
	//서브클래스(자식)가 슈퍼클래스(부모)를 선택한다. ==> extends : 상속
	//public class DmbCellphone 뒤에 extends Cellphone를 붙인다.
		// 서브 클래스가 슈퍼클래스 내 멤버 사용 가능
	
	//1.필드
	int channel;
	
	//2.생성자
	public DmbCellphone(String model , String color, int channel) {
		this.model = model; //this.필드명
		this.color = color; //this.필드명
		//현재 클래스에 없는 필드이므로 슈퍼클래스 내 멤버 호출
		this.channel = channel;
	}
	
	//3.메소드
	void turnOnDmb( ) {
		System.out.println("채널 "+ channel+"번 DMB 방송 수신을 시작합니다.");
	}
	
	void changeChannel1Dmb( int channel ) {
		this.channel = channel;
		System.out.println("채널 "+channel+"번으로 바꿉니다.");
	}
	void turnOffDmb( ) {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
	
	//상속을 받아 cellphone 내부 것들을 바로 사용 가능 (자식이 부모 선택)
	
}
