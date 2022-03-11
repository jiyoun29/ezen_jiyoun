package Day07;

import java.net.MulticastSocket;

public class Book {
	// 도서 클래스
	
	// 1. 필드
	String ISBN;	// ISBN
	String bname; // 도서명
	String bwritter; // 작가
	boolean brental; // 도서대여여부
	String mid;	// 대여인ID
	
	// 2. 생성자
		// 1. 빈생성자[기본생성자] : 메소드 호출용
		// ctrl+space로 자동완성
	public Book() { //빈 붕어빵 생성. 필드는 있는데 그 안에 아무것도 없다. 활동x 메소드 호출용
		 
	}


		// 2. 플생성자[모든 필드 받는 생성자] : 도서등록
	// 우클릭 소스 필드를 통해 가져옴 (수퍼는 제외)
	public Book(String iSBN, String bname, String bwritter, boolean brental, String mid) {
		ISBN = iSBN;
		this.bname = bname;
		this.bwritter = bwritter;
		this.brental = brental;
		this.mid = mid;
	} // 필요에 따라 추가 가능
	
	
	// 3. 메소드 (모두 반환값x)
		//1. 도서검색
	void 도서검색() {
		
		//직접 만들어봄
//		System.out.println("------ 도서 검색 페이지 ------");
//		System.out.print(" 검색할 도서명 : "); String bname = Day07_5_BookApplication.scanner.next();
//		int index = Book.indexOf(bname);
//		if(index >= 0)  {System.out.println("검색한 도서 : " + bname + "\n" + "대여 가능" );}
//		else {System.out.println("검색한 도서 : " + bname + "\n" + "대여 불가능" );}
		// 책이 대여 전이면 대출 가능, 아니면 대출 불가능 ******없는 책이면 없다고 나오게
	}

	
		//2. 도서목록
	void 도서목록() {
		System.out.println("------ 도서 목록 페이지 ------");
		System.out.print("ISBN\t도서명\t작가\t대여가능여부\n");
		
		for( Book temp : Day07_5_BookApplication.books) {
			if(temp != null) { //temp가 null이 아니어야함 //도서가 존재하면
			if(temp.brental) //temp에 있는 렌탈이 true이거나 false일때를 작성
				//도서대여 가능. 해당 도서 대여여부가 true
			System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwritter+"\t" + "가능");
			else //도서대여 불가능. 해당 도서 대여여부가 false
			System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwritter+"\t" + "대여중");
			}
		}
	}	
	
	
	//멤버의 로그인한 사람의 인수를 전달. 이걸 도서 대여로 옮기고 그 인수를 도서대여에 다시 전달.
		//3. 도서대여
	void 도서대여 (String loginid) { //인수를 받아서 여기에 string loginid 무조건*추가. 원본의 일반회원 메소드 부분
		System.out.println("------ 도서 대여 페이지 ------");
		System.out.print(" 대여할 도서명 : "); String bname = Day07_5_BookApplication.scanner.next();
		//현실에서는 바코드 찍는데 그게 ISBN이라고 생각하면 쉬움
	
		//여기에 반복문 i  선언하고 인덱스 넣어 만드는 방법도 있음
		//도서반납할때 탬프가 아니라 i를 찾아 수정
		int i = 0;
		
		for( Book temp : Day07_5_BookApplication.books) {
			//임시 객체 : 배열이름. 배열 내 0번 인덱스-마지막 인덱스 하나씩 임시 객체 대입
			
			//rental이 true이면 도서 대여 가능. 그리고 공백이 아니어야 하니 null 추가
			if(temp != null && temp.ISBN.equals(bname) && temp.brental) {
				System.out.println("알림) 해당 도서를 대여합니다.");
				Day07_5_BookApplication.books[i].brental = false;	// 대여중으로 변경
				Day07_5_BookApplication.books[i].mid = loginid; //현재 로그인한 id 대입 . 로그인 초기 메뉴*
				return; //리턴으로 끝내는게 중요!
			} else { System.err.println("알림) 해당 도서 대여중 상태입니다. [대여불가] "); 
			return; }
			
		} // 그 외
		System.err.println("알림) 동일한 도서명이 존재하지 않습니다.");

	} 
	
	
		//4. 도서반납
	void 도서반납(String loginid) {
		System.out.println("------ 도서 반납 페이지 ------");
		도서대여목록(loginid); //내도서 안내. 받고 넘기고 받고 넘기고(loginid를!)
		System.out.println("도서 이름"); String bname = Day07_5_BookApplication.scanner.next();
		for( Book temp : Day07_5_BookApplication.books) {
			if (temp != null && temp.bname.equals(bname)) {	
				if(temp.brental) {
				//대여인id와 현재 로그인한id가 동일하면
				if(temp.brental) { //대여중이 아니면
					System.err.println("알림) 대여한 도서가 아닙니다.");
				} else { // 대여중이면
					System.out.println("알림) 반납이 완료되었습니다.");
					// 반납 후 rental을 true. 대여중을 대여가능으로 변경
					temp.brental = true;
					temp.mid = null; //대여한 사람의id를 다시 없음 변경 [null]
					return;					
				}
			} else {
				System.err.println("알림) 대여한 도서가 아닙니다.");
			}
		}
		}

	}
	
		// 현재 로그인한 회원이 대여중인 도서목록 띄우기 [내 도서 대여 목록]
	
	void 도서대여목록(String loginid) {
		System.out.println("------ 도서 대여 목록 페이지 ------");
		System.out.print("ISBN\t도서명\t작가\t대여가능여부\n");
		
		for( Book temp : Day07_5_BookApplication.books) {
			if(temp != null && temp.mid.equals( loginid )) {
				// 본인것만 할거면 temp에 내 아이디를 넣어야 함
				//도서가 존재하면서 대여id와 현재 로그인된 아이디와 같으면
			System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwritter+"\t" + "대여중");
			}
		}
	}
	
	
	
	
		//5. 도서등록
	void 도서등록() { //ISBN, 도서명, 작가, 도서대여여부, 대여회원

		//회원가입과 비슷하게 짜면 되지 않을까?
		System.out.println("------ 도서 등록 페이지 ------");
		// 1. 입력받아
		System.out.print(" 등록할 도서 ISBN : "); String ISBN = Day07_5_BookApplication.scanner.next();
		System.out.print(" 등록할 도서 이름 : "); String bname = Day07_5_BookApplication.scanner.next();
		System.out.print(" 등록할 도서 작가 : "); String bwritter = Day07_5_BookApplication.scanner.next();
		
		// 2. 객체화
		// 렌탈은 true로. 대여인은 null로(대여회원 id로 할 것)
		Book book = new Book(ISBN, bname, bwritter, true, null); // 나중엔 DB에 넣게 될 것
		
		//3. 배열 대입[넣기]
		int i = 0; //반복 횟수
		// 중복 체크
		for (Book temp : Day07_5_BookApplication.books ) {
			if (temp == null) { //빈공간 찾기
				Day07_5_BookApplication.books[i] = book;
				System.out.println("알림)도서 등록이 완료되었습니다.");
				return; // 반환값 true(성공을 알림)				
			} i++; // 인덱스 증가
		}
		
	}
		//6. 도서삭제
	void 도서삭제() {
		System.out.println("------ 도서 삭제 페이지 ------");

	}

	
	
	
}
