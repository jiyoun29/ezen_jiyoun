package Day11;

import java.util.Scanner;

import Day10.book;

public class day11_4_BoardApp {
	/*게시판 + 댓글달기
	 * 	[m]게시물 클래스
	 * 		제목, 내용, 작성자, 작성일, 조회수
	 * 		댓글 리스트
	 * 	[m]댓글 클래스
	 * 		내용, 작성자, 작성일
	 * 	[c]컨트롤러 클래스
	 * 		목록, 쓰기, 보기, 수정, 삭제, 댓글 쓰기
	 * 		게시물 저장
	 * 	[v]day11_4_BoardApp 클래스(예외처리가 생기면 v에게 던진다)
	 * 		입출력 [ 입력받아 컨트롤러에게 입력받은 값 전달 ]
	 */
	
	 public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in); //입력객체
		 
		 Controller.load(); //파일[모든 게시물]불러오기
		// System.out.println("확인 : " +Controller.boardlist);
		 
		 
	while(true) {
		
		try { //예외발생 : 사용자 문자 입력시 예외발생 -> catch 이동
			
			
			//모든 게시물 출력
			System.out.printf("%s\t%s\t%s\t%s\t%s\t \n","번호","제목","작성자","작성일","조회수");
			//번호는 저장되는 순서로 인덱스 처리
			
			int i = 0; //리스트 내 인덱스
			for (Board board : Controller.boardlist) {
				System.out.printf("%s\t%s\t%s\t%s\t \n", i, board.getTitle(),  board.getWriter(),
						board.getDate(), board.getViewcount() );				
						//"번호","제목","작성자","작성일","조회수");
				i++;
			}
			
			
			
						
			/////////////////////
			//Controller.boardlist(); //객체 없이 메소드 호출이 되는 이유 : static
			System.out.println("1.쓰기 2.보기"); int ch = scanner.nextInt();
			
			//넥스트라인 : 공백 포함 입력 가능
			//but 넥스트라인 앞에 일단 next 하나로 취급
			//해결방법 : 일반 넥스트와 넥스트 라인 사이에 의미없는 넥스트라인 추가
		scanner.nextLine(); //<-(엔터취급)
		
		
		if(ch == 1) { System.out.println("===== 게시물 등록 =====");
				System.out.print("제목 : "); String 제목 = scanner.nextLine();			
				System.out.print("내용 : "); String 내용 = scanner.nextLine();
				System.out.print("작성자 : "); String 작성자 = scanner.next();
				System.out.print("비밀번호[수정삭제용] : "); String 비밀번호 = scanner.next();
				
				//쓰기로 넘기기(인수 전달)
				Controller.write(제목, 내용, 작성자, 비밀번호);
				
				
				
				
			} else if (ch == 2) {
				//해당 게시물 번호[인덱스]를 입력 받아 해당 게시물의 정보를 띄움
				System.out.println("게시물 번호 : "); int index = scanner.nextInt();
				
				//빼올때는 get
				//해당 인덱스 출력
				Board temp =  Controller.boardlist.get(index); // 해당 인덱스의 객체를 임시 객체 [코드 줄이기]
				System.out.println("=====게시물 보기=====");
				System.out.println("제목 : "+ temp.getTitle());
				System.out.println("작성자 : "+ temp.getWriter()+ "\n" + "작성일 : "+ temp.getDate()+ "\n" + "조회수 : "+ temp.getViewcount());
				System.out.println("내용 : "+ temp.getContent());
				
				
				//댓글출력[추후]
				
				//메뉴
				System.out.println("1.뒤로가기 2.수정 3.삭제 4.댓글쓰기"); int ch2 = scanner.nextInt();				
				//입력 받음
				if (ch2 == 1) {} //그냥 코드가 끝나서 반복문이 돌아가는건데 뒤로가기처럼 보임
				
				
				else if (ch2 == 2 ) {
							//수정할 인덱스 번호, 제목, 내용 + 패스워드 체크
									//수정 : 누구의 어떤 필드의 데이터를 수정할 지

					System.out.println("현 게시물 패스워드 : "); String pw = scanner.next();
					
					scanner.nextLine(); //일반 next 다음 nextline을 사용하게 되면 문제 발생 [ 개별 행 취급 ]
					
					System.out.println("변경 제목 : "); String title = scanner.nextLine();
					System.out.println("변경 내용 : "); String content = scanner.nextLine();
					
					Boolean result = Controller.update(index, pw, title, content); //수정할 인덱스 넣기
					
					if(result) System.out.println("수정 성공");
					else System.out.println("수정 실패");
					
				}
				else if (ch2 == 3 ) { //현 게시물의 패스워드 먼저 체크
					System.out.println("현 게시물 패스워드 : "); String pw = scanner.next();
					//보낸다 = 인수로 보낸다					
					boolean result = Controller.delete(index, pw); // 삭제할 인덱스 번호, 패스워드 ->인수가 된다.
					if(result) System.out.println("삭제 성공"); //result = true
					else System.err.println("삭제 실패(패스워드 오류)");
					
				}
				else if (ch2 == 4) {
					Controller.replywriter(); // 인덱스 번호, 댓글 내용, 댓글 작성자 + 댓글 패스워드
					
				} else {}
				
				
				
				
			} else {}
		
		}catch(Exception e) { System.err.println( "사용할 수 없는 입력입니다."); //이걸 안 넣으면 강제 종료
		 scanner = new Scanner(System.in); // trycatch하고 스캐너까지 해야 함
		} //다시 메모리 할당 [ 기록 내용을 지우기 ]
		
	}
		 
		 
		 
		 
	/////////////////////////////////////////	 
	}
		
}
