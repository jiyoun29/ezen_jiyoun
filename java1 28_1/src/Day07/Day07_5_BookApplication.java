package Day07;

import java.util.Scanner;

public class Day07_5_BookApplication {

	//입출력만
	//BookApplication 클래스 : 입출력 관련 코드
	//Book 클래스 : 도서 관련 코드
	//Member 클래스 : 회원 관련 코드
	
	//*도서 대여 console 프로그램[클래스 버전]
		//클래스 구성(설계) (백)
			// 1. book
				// 필드: ISBN, 도서명, 작가, 도서대여여부, 대여회원
				// 메소드: 1.도서검색 2.도서목록 3.도서대여 4.도서반납
			// 2. member
				// 필드: 회원번호, 아이디, 비밀번호, 이름, 연락처
				// 메소드: 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 5.로그아웃
		//화면 구성(설계) (프론트)
			// 1. 초기메뉴
				// 1.회원가입 2.로그인 3.아이디 찾기 4.비밀번호 찾기
				// 일반 회원 메뉴 1.도서검색 2.도서목록 3.도서대여 4.도서반납 5.로그아웃
				// 관리자 메뉴 1.도서등록 2.도서목록 3.도서삭제 4.로그아웃 (여유가 있으면 통계도)
	
	/////////////
	
	// main 밖에 변수를 선언하는 이유 : 모든 메소드에서 사용하기 위해서
		// 지역변수 : {변수 선언} 괄호 내에서 선언된 변수는 {}밖으로 나갈 수 없다.
			//서로 다른 메소드에서 사용하는 변수, 서로 다른 {}내에서 사용시->전역변수
			//전역변수,정적변수 static : 프로그램 종료시까지 메모리 할당
				//프로그램 시작시 메모리가 할당되고 프로그램 종료시 메모리가 초기화된다.
				//프로그램 전반적으로 모든 곳에 사용되는 메모리[변수] ->잠깐 쓰고 버릴 거면 지역변수로.
	
	static Scanner scanner = new Scanner(System.in);
	// => book, member 둘 다 가져와서 쓸 수 있는 코드
	static Member[] members = new Member[1000];
	//모든 곳에서 사용할 것이니 static이 붙음	
	static Book[] books = new Book[1000];
	//모든 곳에서 쓰이는 정적필드 Static. 공용적이 데이터
	
	
	//main의 역할 : 코드를 읽어주는 시작점. 메소드. [스레드]
	public static void main(String[] args) { // main start

		// menu(); // 내부호출 불가능.

		//메소드 호출
			// 내부호출
			// 왜? static이 있어서. 메모리가 우선할당이기 때문에. static 외 메소드, 필드를 읽지 못함
			// static은 먼저 할당하고 void는 할당 전이라 읽지 못함
			//main 메소드: static 메소드이기 때문에 static 메소드만 내부 호출 가능
			// static으로 메모리 할당

			// 외부호출
				//1. 객체 생성(메모리 할당) -> 메소드 호출
				// void 앞에 static 붙이면 메모리가 아까움
				// 현재 클래스 기준으로 메소드 호출
		
		Day07_5_BookApplication application = new Day07_5_BookApplication();
		//내가 만든 클래스에 있는 객체를 다시 클래스(설계)에 넣을 수 있다.
		application.menu();
		//이렇게하면 menu();, static+void menu 사용하지 않아도 된다.
		
		
	}	//main end 
	
	//1. 메소드 선언 : 초기 메뉴
	//void앞에 static 넣으면 실행이 된다.
	void menu() {

   

		while(true) {
		System.out.println("--------------도서 대여 프로그램--------------");
		System.out.println("1.회원가입 2.로그인 3.아이디 찾기 4.비밀번호 찾기");
		
		//호출을 위해 객체가 필요. member 클래스.
			int ch = scanner.nextInt();
			
			Member member = new Member();
			// ch==1안이 아니라 여기에 작성하여 모든 곳에서 사용할 수 있도록 함
			// 1~4 {} 괄호에서 사용 가능
			
			if(ch == 1) { // 회원가입 메소드 호출
				//1. 객체 생성
			 //반환 타입이 없으면 돌려받으니 알려줘야한다. 따라서 boolean 생성
				boolean result = member.회원가입(); //회원가입 메소드 호출
				if(result) System.out.println("알림) 회원가입 성공");
				else System.out.println("알림)회원가입 실패");}
			
			else if (ch == 2) { // 로그인 메소드 호출
				String result = member.로그인();

				if (result == null) { //로그인 실패
					System.out.println("알림) 동일한 회원 정보가 없습니다.");
					// 2. 관리자 메뉴 메소드 호출					
				} else	if(result.equals("admin")) { //null인데 관리자인 것
					System.out.println("안녕하세요! "+result+"님을 환영합니다.");
					adminmenu(); //내부 메소드 호출

					// 1. 일반회원 메뉴 메소드 호출
				} else { //일반
					System.out.println("안녕하세요! "+result+"님을 환영합니다.");
					membermenu(result);
					
				}
			}
			else if (ch == 3) { // 아이디 찾기 메소드 호출. 이름, 연락처 받기
				member.아이디찾기();
				
			}
			else if (ch == 4) { // 비밀번호 찾기 메소드 호출. 아이디, 연락처 받기
				member.비밀번호찾기();
				
			}
			else {System.err.println("알림)잘못된 번호를 입력하였습니다.");}
			
		} //while end
		
		
	}
	
	
	//관리자랑 일반회원 메뉴 메소드는 다르다.
	
	//2. 일반회원 메뉴 메소드
	void membermenu(String loginid) { //인수 변수명은 달라도 되지만 자료형은 동일해야함
		while(true) {
		System.out.println("--------------회원 메뉴--------------");
		System.out.println("1. 도서검색 2. 도서목록 3. 도서대여 4. 도서반납 5.로그아웃");
		
		//입력
		int ch = scanner.nextInt();
			Book book = new Book(); //빈생성자로 객체 -> 메소드 호출용 
		if(ch == 1) { book.도서검색(); }
		else if (ch == 2) { book.도서목록();}
		else if (ch == 3) { book.도서대여(loginid);} //loginid 인수를 받아와야한다.
		else if (ch == 4) { book.도서반납(loginid);}
		else if (ch == 5) { System.err.println("알림) 로그아웃 되었습니다.");
			return; // 일반회원 메소드 종료 [로그아웃]
		} else {
			
		}
		
	}
	} // while end
	
	//3. 관리자 메뉴 메소드
	void adminmenu() {
		while (true) {
		System.out.println("--------------관리자 메뉴--------------");
		System.out.println("1. 도서등록 2. 도서목록 3. 도서삭제 4.로그아웃");
		int ch = scanner.nextInt();
			Book book = new Book();
		if(ch == 1) {
			book.도서등록();

		} else if (ch == 2) {
			book.도서목록();

		} else if (ch == 3) {
			book.도서삭제();

		} else if (ch == 4) { System.err.println("알림) 로그아웃 되었습니다.");
			return; // 관리자 메소드 종료 [로그아웃]
		} else {
			
		}
		
	}
		
	} // while end
		/////////////////////////////////////////////////////////////

}
