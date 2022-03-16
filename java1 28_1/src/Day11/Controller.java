package Day11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Controller { //처리
	
	//리스트만들기
	
	//0.게시물 리스트 (모든 게시물을 담는 리스트)
	public static ArrayList<Board> boardlist =
			new ArrayList<>();


	//모든 메소드는 static
	
	//1. 목록 메소드
	// public static void boardlist() {}
	// 제외
	
	//2. 쓰기 메소드
	//baorad app에서 받아옴
	public static void write(String 제목, String 내용, String 작성자, String 비밀번호) {
		//1. 객체화 : 변수가 4개 이상이면 관리가 어려우므로 하나의 객체로 만듦
		Board board = new Board(제목, 내용, 작성자, 비밀번호);
		
		//2. 리스트에 저장
		boardlist.add(board);
		
		//3. 파일에 저장
		save();
	} //쓰기 닫기
	
	
	
//	//3. 보기 메소드
//	public static void view() {}
	
	
	
	
	//4. 수정 메소드
	public static boolean update(int index, String pw, String title, String content) {
		//수정할 인덱스 번호, 제목, 내용 + 패스워드 체크
		if(pw.equals(boardlist.get(index).getPw()) ) { //패스워드가 동일하면 수정 처리
			
			//수정할 값
		boardlist.get(index).setTitle(title);
		boardlist.get(index).setContent(content);
			//성공 true false 이므로 void는 다시 boolean
		//파일 업데이트
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	//////
	
	//5. 삭제 메소드
	public static boolean delete(int intdex, String pw) { //인덱스는 인트
		//현 게시물 인덱스와 현 게시물 패스워드를 받아온다.
		
		//현재 boardlist에 있는 겟.인덱스의 겟.패스워드를 가져와서 >비교<
		if (pw.equals( boardlist.get(intdex).getPw() ) ) {
			//입력받은 패스워드와  해당 인덱스 게시물번호의 패스워드가 동일하면
			
			boardlist.remove(intdex);
			// 리스트.add(객체) : 추가
			// 리스트.get(인덱스): 호출
			// 리스트.remove(인덱스): 삭제
			
			save(); //리스트에서 삭제 후 파일도 삭제 리스트를 업데이트
			
			return true;
			
		} else { return false;}
		//void는 return이 없다는 뜻이므로 처음엔 void를 사용해도 나중에 리턴이 들어오면 boolean으로 바꾼다.
		
	}
	
	
	
	
	
	
	
	//6. 댓글쓰기 메소드
	public static void replywriter() {}
	
	
	
	
	
	
	
	//7. 게시물 저장 메소드
	public static void save() { //만든다음 호출(save)
		//리스트의 모든 게시물을 파일에 저장
		try {
			//1.파일 출력 클래스
			FileOutputStream outputStream = new FileOutputStream("C:/java/게시물파일.text");
			
			
				//2.파일에 작성할 내용 (한줄씩 = 게시물 1개씩 = 객체 1개씩 )
				for(Board board : boardlist) { // ,=필드구분 \n객체구분
					
					String 작성내용 = board.getTitle() + "," + board.getContent()+ ","+
							board.getPw() + "," + board.getWriter()+ ","+
							board.getViewcount()+ ","+board.getDate()+"\n";
					
					
				//3.내용(문자열) -> 바이트열 변환(외부통신(스트림) : 통신단위 : 바이트)
					//통신을 위한 스트림이지만 바이트밖에 못 쓰므로 변환해서 외부와 통신
					
				//4.내보내기(write)
					outputStream.write(작성내용.getBytes());
				} //for end
			
			} catch (Exception e) {
			System.out.println("파일저장 실패(관리자 문의)");
		}
		
		
		
	} //save end
	
	
	
	
	//8. 게시물 불러오기 메소드 [프로그램 시작] 파일 -> 리스트
	public static void load() {
		//예외처리 무조건
		try {
	
				FileInputStream inputStream = new FileInputStream("C:/java/게시물파일.text");
			
			//2. 바이트배열 선언
			byte[] bytes = new byte[1000];
			
			//3. 모든 바이트 읽어와서 바이트에 저장
			inputStream.read(bytes);
	
			//4. 바이트 -> 문자열 변환
			String file = new String(bytes);
			
			//5. 문자열 자르기 [ 한줄씩 -> 1개 객체 ]
			String[] boards = file.split("\n"); //문자열 자르기 한줄씩 \n
			
			
			int i = 0; //인덱스용
			
				for(String temp : boards ) { //배열내 문자열을 하나씩 꺼내기
					
					if(i+1 == boards.length) break;
				//6. 문자열 자르기 [ 객체 내에서 ,로 필드 구분. ]
					String[] field = temp.split(",");
				//7. 객체화
					Board board = new Board(field[0], field[1],
							field[2], field[3],
							Integer.parseInt(field[4]), field[5], null);
					//문자를 숫자로 바꾼다			//조회수는 필드의 정수형이므로 정수형으로 형변환[Integer.parseInt(문자열)]
								
				//8. 리스트  담기
					boardlist.add(board); 
				i++; //인덱스 증가
			}
		
		} catch(Exception e) {System.err.println(" 알림]] 파일로드  실패( 관리자에게문의 )"+e); }
		
		
		
		
		
		
		
	}
	
}
