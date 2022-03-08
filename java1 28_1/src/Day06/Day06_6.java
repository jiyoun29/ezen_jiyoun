package Day06;

import java.util.Scanner;

public class Day06_6 { // c s
	
	// 비회원제 게시판[클래스] (메소드x 필드랑 생성자만 사용)
		// 0. 게시물 설계 => 클래스 선언
			// 필드 : 제목, 내용, 작성자, 비밀번호
			// 생성자 : 사용유무 선택
		// 1. 첫화면 [모든 게시물 출력(글번호, 작성자, 제목-출력)]
		// 2. 메뉴 [ 1. 글쓰기 2. 글보기]
			// 1. 글쓰기 : 제목, 내용, 작성자, 비밀번호를 입력받아 => 4개 변수를 객체화
			// 2. 글보기 : 해당 글번호의 입력받아 해당 글 상세페이지(번호, 작성자, 제목, 내용) 표시
				// 글 번호는 배열에 저장되는 순서 [ 인덱스 ] 
		// 3. 글보기 메뉴 [ 1. 목록 보기 2. 삭제 3. 수정 ]
			// 1. 삭제시 : 비밀번호 입력받아 동일하면 삭제
			// 2. 수정시 : 비밀번호 입력받아 동일하면 제목과 내용만 수정
	
	public static void main(String[] args) { // m s
		// 준비 [모든 {} 안에서 사용되는 변수 선언]
		Scanner scanner = new Scanner(System.in);
		Board[] boardlist = new Board[100]; //board 객체를 100개 저장할 수 있는 1차원 배열
		
		//프로그램 실행
		while(true) { //프로그램 실행 무한루프 [종료조건 : x]
			System.out.println("-----------커뮤니티-----------");
			
			///////////////////////게시물 조회//////////////////
			
			System.out.println("번호\t작성자\t제목");
				//출력 먼저. 배열 내 모든 객체(게시물) 출력 반복문
			int index = 0; //인덱스 변수(숫자용으로 만듦), 배열 내 객체 수 체크
			for( Board board : boardlist) {
				if (board != null) { //만약 해당 board 객체가 내용물이 있으면 출력		
					//반복문으로 1개씩 가져옴
				System.out.printf("%d\t%s\t%s \n",index,board.writer,board.title); //번호d 문자s
				//형식문자 : %s 문자 %d 숫자. %숫자s : 숫자만큼 자리 차지(만약에 해당 데이터가 없으면 공백)
				}	index++; ///인덱스 증가
			}
			
			/////////////////////////////////////////
			
			System.out.println("1.글쓰기 2.글보기");
			int ch = scanner.nextInt(); //스캔에서 받아와 입력
			if(ch == 1) { // 1. 글쓰기
				
				//////////////////////////////글쓰기//////////////////////////////
				
				System.out.println("----------------글쓰기 페이지----------------");
				
				// 4개 변수를 string으로 입력 받는다.
				System.out.print("title : "); 	String title = scanner.next();
				System.out.print("content : "); String content = scanner.next();
				System.out.print("writer : "); 	String writer = scanner.next();
				System.out.print("pw : "); 		String pw = scanner.next();
				// 4개 변수를 객체화 한다. 객체를 만들어 4개 변수를 객체 내 필드 저장
				Board board = new Board(title, content, writer, pw);
				//생성자를 쓰면 객체내 필드= 입력받은값으로 따로따로 만들지 않아도 괜찮다.
				// 배열 내 빈 공간을 찾아서 빈공간에 객체 대입
				int i = 0;	for(Board temp : boardlist) { // 빈공간 찾았으면 해당 인덱스에 새로운 객체 저장
					if(temp == null) {boardlist[i] = board; //i를 추가
					break; // 한번 저장 했으면 더이상 반복문 x
				} i++;
				}
				//////////////////////////////글보기//////////////////////////////
				
			} else if (ch == 2) { // 2. 글보기
				
				System.out.println("게시물 번호(인덱스) 선택 : "); int bno = scanner.nextInt();

				System.out.println("--------게시물 상세 페이지---------");
				// 반복문 사용 목적 x -> 출력할 위치[인덱스] 입력 받았기 때문에. 재검색할 필요도 없음. 출력할 위치를 입력 받음.
				// 입력받은 인덱스 위치에 객체 출력
				System.out.printf("작성자 : %s 제목 : %s \n", boardlist[bno].writer , boardlist[bno].title ); //선택한 객체에서 꺼냄
				System.out.printf("내용 : %s \n" , boardlist[bno].content);
				System.out.println("------------------------------");
				//이렇게 했을 때 인덱스 검색을 통해 글을 찾아낼 수 있음 
				
				
				/////////////////////////////////////
				
				System.out.println("1. 목록보기(뒤로가기) 2. 글삭제 3. 글수정");
				int ch2 = scanner.nextInt();
				if(ch == 1) { } // 목록보기(뒤로가기)
					// 코드가 반복문이 없으므로 자동으로 내려가 종료하게 된다./
					
					/////////////////////////////////////////////
				
				else if (ch == 2) { // 글 삭제
					System.out.println("알림) 현 게시물 비밀번호 : ");	String pw = scanner.next();
					// pw를 입력 받아 동일한 것을 찾아내 삭제. // 인덱스를 알고 있으므로(bno) 반복문 사용하지 않아도 ok
					// 반복문 x 검색 x => 삭제할 인덱스 위치를 입력 받았기 때문에
					if (boardlist[bno].pw.equals(pw)) { //만일 리스트에 있는 bno가 패스워드와 같으면 삭제
					System.err.println("알림) 삭제 성공");
					boardlist[bno] = null; //기존 게시물에 null 대입, 삭제 처리
					// 삭제 후에 삭제된 인덱스 뒤로 한칸씩 앞으로 이동
					//why? 하지 않을 경우(해당 코드가 없을 경우) 배열 내 사이사이 공백 발생
				// 그래서 당겨와야 한다. 당기는 방법 아래
					for( int i = bno ; i< boardlist.length ; i++ ) { // 배열길이 = 100  인덱스 : 0~99
						// * 검색된 게시물의 인덱스부터 마지막인덱스까지 1씩증가 
						if( i == boardlist.length-1 ) boardlist[ boardlist.length-1 ] = null;
						// i가 마지막인덱스 와 같으면 마지막인덱스에는 null 대입
						else boardlist[i] = boardlist[i+1];// 삭제된 게시물 다음 게시물
						// 마지막 인덱스가 아니면 인덱스 당기기 
							// *  	만약에 2번 인덱스 삭제시 
							// 		2인덱스 = 3인덱스 
							//	  	3인덱스 = 4인덱스 
							//		4인덱스 = 5인덱스 
							//      ~~~~~~~~~~~
							//		98인덱스 = 99인덱스 [ 0번~99번 -> 100개 인덱스 ]
							//		99인덱스 = null [ 99번 인덱스 : 마지막인덱스 ] 
					}
				}else {	System.out.println(" 알림)) 비밀번호가 다릅니다 [ 삭제실패 ]");} }
				
		//////////////////////////////////////////////////////////
				
			else if (ch == 3) { // 글 수정
				//상세페이지에서 가져옴
				// 1. 비밀번호 입력 받기
				System.out.println("알림) 현 게시물의 비밀번호 : "); String pw = scanner.next();
				//bno = 현재 내가 보고 있는 게시물
				if(boardlist[bno].pw.equals(pw)) {
					System.out.println("수정할 제목 : "); boardlist[bno].title = scanner.next();
					System.out.println("수정할 내용 : "); boardlist[bno].content = scanner.next();
					// 해당 게시물의 제목과 내용을 새로 입력받아 현 게시물 객체에 대입
					System.err.println("알림)내용이 수정되었습니다."); }
					
/////////////////////////////////////////////////////////////////////	
				
			} else { System.err.println("알림)알 수 없는 번호입니다."); } }
			
			
		} // 프로그램 실행 끝
		
/////////////////////////////////////////////////////////////////////////
	} // me

}
