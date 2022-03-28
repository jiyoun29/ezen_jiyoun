package Day18;

import java.util.Vector;

public class day18_2 {
	//730
	public static void main(String[] args) {
		
		/*
		 			ArrayList			vector
		 동기화			x					o
		 스레드	싱글스레드(main)	멀티스레드(Thread, Runnable)
		 
		
		 Vector 클래스
		 1. Vector 리스트 객체 선언
		 */
	Vector<Board> list = new Vector<>();
		//2. 리스트 객체 내 추가
	list.add(new Board("제목1", "내용1", "글쓴이1"));
		//두번째방법
		Board board = new Board("제목2", "내용2", "글쓴이2");
		list.add(board);
		
	System.out.println("확인"+list);

	//3. 검색
	
	System.out.println("검색"+list.contains(board));
	System.out.println("검색 위치:"+list.indexOf(board));
	
	
	//4. 삭제
	list.remove(2); System.out.println("삭제확인:"+list);

	
	
///////////////////////////////		
	}
}
