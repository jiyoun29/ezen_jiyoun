package Day08_5;

import Day08_5.Mobilebank;
import Day08_5.Member;


public class Member {

	// 멤버 클래스
	
	//1. 필드
	String id;	// 아이디 [ 중복x ]
	String pw;	// 비밀번호
	String name; // 이름
	String phone; // 연락처
	

	
	
	//2. 생성자
	public Member() {}

	public Member(String id, String pw, String name, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;	}

	
	//3. 메소드
		// 회원가입
	boolean 회원가입() { System.out.println("--------------회원가입 페이지--------------");
		//1. id pw name phone 입력 받는다.(4개) = 매개변수 입력받기
		System.out.print(" ID : "); String id = Mobilebank.scanner.next();
		System.out.print(" PASSWORD : "); String pw = Mobilebank.scanner.next();
		System.out.print(" NAME : "); String name = Mobilebank.scanner.next();
		System.out.print(" PHONE : "); String phone = Mobilebank.scanner.next();
		
		// 아이디 중복체크
		for (Member temp : Mobilebank.members) {
			if(temp != null && temp.id.equals(id)) { System.out.println("알림) 현재 사용 중인 아이디입니다.");
				} return false; }
		return true; }

		
	// 로그인 [인수x반환o]
	String 로그인() { System.out.println("--------------로그인 페이지--------------");
		System.out.print(" ID : "); String id = Mobilebank.scanner.next();
		System.out.print(" PASSWORD : "); String pw = Mobilebank.scanner.next();
		for (Member temp : Mobilebank.members) {
			if( temp != null && temp.id.equals(id) && temp.pw.equals(pw)) {	//공백이 아니면서 id와 pw가 동일
				return temp.id; } }	return null; } //실패시 null 반환

	
	// 아이디 찾기 [인수x반환x]
	void 아이디찾기() { System.out.println("--------------아이디 찾기 페이지--------------");
		System.out.print(" NAME : "); String name = Mobilebank.scanner.next();
		System.out.print(" PHONE : "); String phone = Mobilebank.scanner.next();
		for(Member temp : Mobilebank.members) {
			if(temp != null && temp.name.equals(name) && temp.phone.equals(phone)) {
			 System.out.println("알림) 회원님의 아이디는 : " + temp.id + "입니다."); return; } }
		System.out.println("알림) 동일한 회원 정보가 없습니다.");	 }
	
		// 비번 찾기 [인수x반환x]
	void 비밀번호찾기() { System.out.println("--------------비밀번호 찾기 페이지--------------");
		for(Member temp : Mobilebank.members) {
			System.out.print(" ID : "); String id = Mobilebank.scanner.next();
			System.out.print(" PHONE : "); String phone = Mobilebank.scanner.next();
			if(temp != null && temp.id.equals(id) && temp.phone.equals(phone)) {

				for(Member temp1 : Mobilebank.members) {
				if(temp1 != null && temp1.name.equals(id) && temp1.phone.equals(phone)) {
				 System.out.println("알림) 회원님의 비밀번호는 : " + temp1.pw + "입니다."); return; } }
		System.out.println("알림) 동일한 회원 정보가 없습니다.");	
			}
		}
	}

}
