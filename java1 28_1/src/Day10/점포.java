package Day10;
// day10_7_키오스크 
public class 점포 implements 키오스크 { //수퍼클래스
	//구현 안 하면 빨간줄
	
	//1. 필드
	public String 주소;
	
	//2. 생성자
		//깡통생성
	public 점포() {}
		
	
	//3. 메소드
	//오버라이드로 4가지 메소드를 구현(키오스크에서 가져옴)
	@Override
	public void 제품목록() {
		System.out.println("=======제품 목록=======");
	}
	@Override
	public void 장바구니() {
		System.out.println("=======장바구니=======");
		
	}
	@Override
	public void 결제() {
		System.out.println("======== 결제 ========");
		
	}
	@Override
	public void 상품추가() {
		System.out.println("======== 상품 추가 ========");
		
	}
	
}
