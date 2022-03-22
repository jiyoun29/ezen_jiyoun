package Day14;

public class day14_2_게시판 { //day14_2_클래스멤버

	//@게시판을 짠다고 했을때 뭐를 필드,생성자,메소드로 생성할 것인지 선택(설계)
	//@다른 사람들것 많이 참고
	
	//1. 필드
	private String title;
	private String content;
	private String writer;
	private int point;

	//2. 생성자[객체 생성시 초기값 = 처음값]
	
	//빈생성자
	public day14_2_게시판() {};
	
	//풀생성자
	public day14_2_게시판(String title, String content, String writer, int point) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.point = point;
	}
	
	//3.모든필드
	
}
