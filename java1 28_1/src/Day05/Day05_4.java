package Day05;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Day05_4 {

	/* 1. 입출력 2.변수/자료형/연산 3.제어/반복 4.배열
	 * 도서 대여 console 프로그램
	 * 	1. 배열 : 회원(아이디(중복x), 비밀번호), 도서(도서명(중복x), 도서대여여부, 대여인)
	 *  2. 초기메뉴 : 회원가입, 로그인 -> 회원가입시 아이디 중복체크
	 *  -------------------------------------------------
	 *  3. 로그인시 메뉴
	 *  	도서 검색, 도서 목록, 도서 대여, 도서 반납, 로그아웃
	 *  		- 도서 검색 시 도서명이 일치하면 도서명과 도서 대여여부(가능, 불가능) 출력
	 *  		- 도서목록시 모든 도서명 출력
	 *  		- 도서대여시 도서대여여부가 가능할때 도서대여 처리
	 *  		- 도서반납시 본인이 대여한 도서만 반납 처리
	 *  		- 로그아웃시 초기메뉴로
	 *  -------------------------------------------------
	 *  4. 로그인시 아이디가 admin이면 관리자 메뉴
	 *  	: 도서등록, 도서목록, (할수있으면 도서 삭제도) 로그아웃
	 *  		- 도서 등록 시 도서명을 입력받아 도서 등록처리
	 *  		- 도서 목록 시 모든 도서명 출력
	 *  		- 도서 삭제 시 삭제할 도서명을 입력받아 동일한 도서명 삭제[null]
	 *  		- 로그아웃시 초기메뉴로
	 */
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		// 회원 100명[id,password] 저장하는 배열
		String[][] memberlist = new String[100][2]; // 100행 2열	=> 회원당 1행	[1열=id][2열=pw]
		
		//도서 목록 만들기
		String[] bookArray = {"어린왕자","목걸이","라푼젤","호수","인형"};
		ArrayList<String> booklist = new ArrayList<>(Arrays.asList(bookArray));

//		int[][] 배열2 = new int[2][3]; 
//		//2차원 배열. 앞이 행, 뒤가 열. 4바이트 * 2 * 3 => 24바이트 배열
//		배열2[0][0] = 80; 배열2[0][1] = 90; 배열2[0][2] = 100;
//		배열2[1][0] = 40; 배열2[1][1] = 50; 배열2[1][2] = 60;
		
		//////////////////////////////////////////////////////////////////////////
	
		while(true) {
			System.out.println("------------------------");
			System.out.println("-------- 도서 대여 --------");
			System.out.print("1.회원가입 2.로그인 선택 : "); int ch = scanner.nextInt(); 
		
		// 1. 회원가입

		if ( ch == 1) { System.out.println("-------- 회원가입 페이지 ---------");
			System.out.print(" MEMBER ID : "); 			String id = scanner.next();
			System.out.print(" MEMBER PASSWORD : "); 	String pw = scanner.next();
			boolean idcheck = true;
			for(int i = 0 ; i<memberlist.length ; i++ ) {
				if( memberlist[i][0] !=null && memberlist[i][0].equals(id) ) {
					System.err.println(" 알림]] 동일한 아이디가 존재합니다.");
					idcheck = false; // 회원가입 불가능하게 idcheck 변수를 false 변경
					break;
				}
			}
			if( idcheck ) { // idcheck 가 true 인 경우에만 회원가입처리 
				for( int i =0 ; i<memberlist.length ; i++ ) {
					if( memberlist[i][0] == null ) {
						memberlist[i][0] = id;	memberlist[i][1] = pw; 
						System.err.println(" 알림]] 회원가입이 되었습니다.");
						break; 
				}
			}
		}	
			
		} // if end
		
		else if( ch == 2 ) { System.out.println("-------- 로그인 페이지 ---------");
			System.out.print(" MEMBER ID : "); 			String id = scanner.next();
			System.out.print(" MEMBER PASSWORD : "); 	String pw = scanner.next();
			
			boolean logincheck = false; 
			for(int i =0; i<memberlist.length; i++) {
				if( memberlist[i][0] !=null && memberlist[i][0].equals( id ) &&
				memberlist[i][1].equals(pw) ) { System.err.println(" 알림]] 로그인 성공 ");
			logincheck = true; // 로그인 성공 값 저장
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
			
			while(true) { //로그인 시 메뉴. 종료 : 로그아웃
				System.out.println("------------------------");
				System.out.println("-------도서 대여 목록-------");
				System.out.print("1.도서 검색 2.도서 목록 3.도서 대여 4.도서 반납 5.로그아웃 "); int ch2 = scanner.nextInt(); 
				
				if(ch2 == 1) { System.out.println("도서 검색 : "); 
							String 검색 = scanner.next(); int index = booklist.indexOf(검색);
					 System.out.println("검색한 도서 : " + 검색 + "\n" + "대여 가능 여부 : " + booklist.indexOf(검색) );
					 	// 책이 대여 전이면 대출 가능, 아니면 대출 불가능
					 
				} else if (ch2 == 2) { System.out.println("\t도서 목록\t");
									System.out.println(booklist);
									//대여가능여부도 나타나도록
									
				} else if (ch2 == 3) { System.out.println("대여할 도서 이름 : " );
								//대여 가능 여부에 따라
									System.out.println( "대여가 완료되었습니다."); 
							//대여한 책을 리스트에서 제외하고 대여가 안 될 시 대여가 불가능하다********라는 코드 짜야함

				} else if (ch2 == 4) {//본인이 대여한 도서만 반납처리
					System.out.println("반납할 수 있는 도서 목록"); // 대여한 도서 목록
				System.out.println("반납할 도서 이름 : ");  String 반납 = scanner.next(); //대여한 도서가 맞는 지 확인
				System.out.println( 반납 + "를(을) 반납하였습니다."); 
				
				} else if (ch2 == 5) { System.err.println("알림)로그아웃 되었습니다."); //////로그아웃시 초기메뉴로
				} else {	System.err.println("알림) 알 수 없는 번호입니다.");		}
				
//				- 도서 검색 시 도서명이 일치하면 도서명과 도서 대여여부(가능, 불가능) 출력
//				   		- 도서목록시 모든 도서명 출력
//				   		- 도서대여시 도서대여여부가 가능할때 도서대여 처리
//				   		- 도서반납시 본인이 대여한 도서만 반납 처리
//				   		- 로그아웃시 초기메뉴로
				//////////////////////////////////////////////////////////////////////////////////////
				
			} //로그인시메뉴 while end
			
			}
		}
			
			// 로그인시 실패시
			if( logincheck == false ) System.err.println(" 알림]] 회원정보가 없거나 다릅니다.");			
		} // ch==2 if end 
		else { System.err.println(" 알림]] 알수 없는 번호입니다.!!"); }
			
		
		} // wirle true end
		////////////////////////////////
	} //m e
} // c e
