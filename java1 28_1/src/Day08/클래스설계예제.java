package Day08;

public class 클래스설계예제 {
			// 회원클래스
	
	//컨트롤러예제 만들어서 회원가입 처리 메소드 생성.
	//여기는 설계(모델이라고 부름)만. 활동은 컨트롤러 클래스에서
	
	//1. 필드 [ private 권장 ]
	private String id;
	private String pw;
	private String name;
	private String point;


//2. 생성자
		// 1. [필드0개]빈생성자 [메소드 호출용 사용예정] *
public 클래스설계예제() {}
//우클릭 속스 필드4개 생성
	
	// 2. [필드3개]특정 생성자 [회원가입시 사용예정]
	
		// 3. [필드4개]풀생성자 [모든 회원정보 호출시 사용예정] *
		// * 두개는 만들고 시작
	public 클래스설계예제(String id, String pw, String name, String point) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.point = point;
}
	
	//3. 메소드
		// private 필드 사용시 get or set 메소드
	//우클릭 소스 게터세터  -> 아래 코드 자동 생성
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	

}
