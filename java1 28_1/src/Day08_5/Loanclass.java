package Day08_5;

import java.util.Scanner;
import Day08_5.Loanclass;

public class Loanclass {

	//대출 클래스
	
		// 1. 필드
		int bank;	// 계좌번호 [ 숫자5, 중복x ]
		int money; //입금 금액
		boolean loan; //대출가능 여부
		String loname; //대출상품 이름
		String locontent; //대출상품 설명
		String lolimits; //대출상품 한도
		
		
		
		
		// 관리자(은행원) 대출 상품을 등록하면 등록된 대출상품을 회원이 선택해서 대출 사용
				// 관리자의 대출 등록 메뉴 1.상품 이름 2.상품 설명 3. 대출 한도(선택)

		// 2. 생성자
		public Loanclass() {}
		//객체 생성
		public Loanclass(int bank, int money, boolean loan, String loname,
			String locontent, String lolimits) { super();
			this.bank = bank;
			this.money = money;
			this.loan = loan;
			this.loname = loname;
			this.locontent = locontent;
			this.lolimits = lolimits; }
		
		
		// 3. 메소드
		//계좌생성 //////////////////////////////////////
	void 계좌생성(String loginid) { System.out.println("------ 계좌 생성 페이지 ------");
		System.out.println("계좌 번호 5자리를 입력하세요 : "); int bank = Mobilebank.scanner.nextInt();
		System.out.println("계좌에 초기 금액을 입금해주세요 : "); int money = Mobilebank.scanner.nextInt();
		System.out.println("계좌번호 : "+bank+"초기 금액 : "+money+"\n 계좌가 생성되었습니다.");
		int i = 0; for(Loanclass temp : Mobilebank.loanclass) {
			if(temp == null) { //빈공간 찾기
				Mobilebank.loanclass[i] = loanclass; return true;} i++;
		} return false; }


	// 대출 목록 ////////////////////////////////////////////////////
		
	void 대출목록(String loginid) {
	System.out.println("------ 대출 목록 페이지 ------");
		System.out.println("상품 이름\t상품 설명\t상품 한도\t신청 가능 여부\n");
		System.out.println(loname+"\t"+locontent+"\t"+lolimits+"\t"+loan);
		int j = 0; for(Loanclass temp : Mobilebank.loanclass) {
			if(temp == null) { //빈공간 찾기
				Mobilebank.loanclass[j] = loanclass; return true;} j++;
		} return false; }
	
	
	// 대출 신청 ////////////////////////////////////////////////////

	void 대출신청(String loginid) {
		System.out.println("------ 대출 신청 페이지 ------");
		System.out.println("신청할 대출 상품 : "); String loname = Mobilebank.scanner.next();
		for(Loanclass temp : Mobilebank.loanclass) {
			if(temp != null && temp.loname.equals(loname) && temp.loan) {
				System.out.println("알림) 해당 대출을 신청합니다."); temp.loan = false; return;
			} else {System.out.println("알림) 현재 대출 신청이 불가능한 상태입니다."); return;}
			System.out.println("알림) 동일한 상품이 존재하지 않습니다.");}	}
	
		
	///////대출 등록
		
	void 대출등록(String loginid) { System.out.println("------ 대출 등록 페이지 ------");
	
	System.out.print(" 등록할 대출 상품 이름 : "); String loname = Mobilebank.scanner.next();
	System.out.print(" 등록할 대출 상품 설명 : "); String locontent = Mobilebank.scanner.next();
	System.out.print(" 등록할 대출 상품 한도 : "); String lolimits = Mobilebank.scanner.next();
	System.out.print(" 등록할 대출 상품 기간 : "); String years = Mobilebank.scanner.next();
		//객체화
//	Loanclass loanclass = new Loanclass(loname, locontent, lolimits, years, true, null);

	//배열 대입
	int i = 0;
	for(Loanclass temp : Mobilebank.loanclass) {
		if (temp == null) {	Mobilebank.loanclass[i] = loanclass;
			System.out.println("알림) 대출 등록이 완료되었습니다.");
			return;} i++;}
	}
	

///////////////////////////////////////////////////
		
}
