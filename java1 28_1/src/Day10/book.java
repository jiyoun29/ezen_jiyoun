package Day10;

public class book {
	
	//1. 필드
	private String 도서명;
	private String 저자;

	
	
	
	//2. 생성자
	
	//빈생성자 하나, 우클릭 소스 필드 하나.
	public book() {}
	public book(String 도서명, String 저자) {
		super();
		this.도서명 = 도서명;
		this.저자 = 저자;
	}
	
	
	
	//3. 메소드[ getter setter]
	
	public String get도서명() {
		return 도서명;
	}
	public void set도서명(String 도서명) {
		this.도서명 = 도서명;
	}
	public String get저자() {
		return 저자;
	}
	public void set저자(String 저자) {
		this.저자 = 저자;
	}
	
	
	
	
	

}
