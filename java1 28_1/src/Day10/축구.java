package Day10;

public class 축구 implements  게임패드 {

	//**인터페이스 사용 목적에 대해 생각하기
		//설계가 다양해짐
	
	@Override
	public void A버튼() {
		System.out.println("슛");	
	}
	@Override
	public void B버튼() {
		System.out.println("수비");		
	}
	@Override
	public void C버튼() {
		System.out.println("선수교체");		
	}
	
	
}
