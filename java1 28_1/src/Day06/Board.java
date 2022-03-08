package Day06;

public class Board {
	// * board 클래스 선언. main메소드xx설계도에선 안 씀
	// 1. 필드 (4개 필요)
		String title; String content; String writer; String pw;
		
	// 2. 생성자 (클래스 이름과 동일하면 생성자명)
		// 자동 : 오른쪽 클릭 source
		
		// 1. 빈 생성자(깡통)
	Board(){}		
	
		// 2. 1개 필드를 받는 생성자
	Board(String title){ //외부변수
		this.title = title; }
		// this.필드명 => 내부변수. 외부로부터 들어온 제목을 내부변수에 저장
	
		// 3. 2개 필드를 받는 생성자
	Board(String title, String content)
	{ this.title = title; this.content = content; }
		
		// 4. 3개 필드를 받는 생성자
	Board(String title, String content, String writer)
	{ this.title = title; this.content = content; this.writer = writer; }
	
		// 5. 4개 필드를 받는 생성자
	Board(String title, String content, String writer, String pw)
	{ this.title = title; this.content = content; this.writer = writer;
	this.pw = pw;}
		
	// 3. 메소드
	

}
