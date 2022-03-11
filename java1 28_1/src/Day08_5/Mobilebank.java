package Day08_5;

import java.util.Scanner;

import javax.xml.transform.Result;

import Day08_5.Member;
import Day08_5.Loanclass;

public class Mobilebank {
	

	// 모바일 뱅크 프로그램 [ 2인 과제 ]
		// 요구사항
		// 회원 주요기능 : 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호 찾기
			// 회원가입 : 이름, 번호, 아이디, 비밀번호 받음. 아이디 중복검사

		// 계좌 주요기능 : 1.계좌생성 5.대출 6.계좌목록 / 2.입금 3.출금 4.이체
							// (대출)               (통장)
		// 회원이 계좌 만들어서 사용
				// 계좌번호 숫자 5자리 입력 (계좌비번 여유되면...)
	
		// 관리자(은행원) 대출 상품을 등록하면 등록된 대출상품을 회원이 선택해서 대출 사용
				// 관리자의 대출 등록 메뉴 1.상품 이름 2.상품 설명 3. 대출 한도
	
	// 설계 : 통장, 대출, 회원
			// 필드
			// 메소드

	static Scanner scanner = new Scanner(System.in);
	static Loanclass loanclass = new Loanclass();
	static Member[] members = new Member[1000];	
		
	public static void main(String[] args) { 

	
		
		
		
		
		

		while (true) { System.out.println("---------------MOVBILE BANK---------------");	
		System.out.println("1.회원가입 2.로그인 3.아이디 찾기 4.비밀번호 찾기");
		int ch = scanner.nextInt();
		Member member = new Member();

		if(ch == 1) { boolean result = member.회원가입();
				if(result) { System.out.println("알림) 회원가입 성공");}
				else {System.out.println("알림)회원가입 실패");} }
				else if (ch == 2) { String result = member.로그인();
				if (result == null) {  System.out.println("알림) 동일한 회원 정보가 없습니다."); 	}
	} else if (ch == 3) { member.아이디찾기(); } else if (ch==4) {member.비밀번호찾기();} 
				else { System.out.println("알림) 로그인 성공! "); } }
		 //void menu end
	
	
	
	
	
	
	
	
	
	
	}
}
