package Day09;

public class day9_6_은행 {
	
	//1.필드 	// string으로 한글로 넣어보자
	private String 계좌번호; //계좌번호(중복x=식별)
	private String 비밀번호; //비밀번호
	private String 계좌주; //계좌주
	private int 예금액; //예금액
	//string 적고 getter setter넣어서 앞에 private 넣기
	
	//이걸 국민 신한 하나에 연결.
	
	
	//2.생성자 (저번주에 한 것처럼)
		//1. 빈 생성자. 깡통 만들기
	//메소드 호출용으로 만든다.
	public day9_6_은행 () {} 
	
		//2. 모든 필드 생성자
	//우클릭 소스 필드  불러오기
	public day9_6_은행(String 계좌번호, String 비밀번호, String 계좌주, int 예금액) {
		super();
		this.계좌번호 = 계좌번호;
		this.비밀번호 = 비밀번호;
		this.계좌주 = 계좌주;
		this.예금액 = 예금액;
	} //
	
	
	
	//3.메소드
		//getter setter 메솓, [필드가 private 인 경우]
	
	public String get계좌번호() {
		return 계좌번호;
	}
	public void set계좌번호(String 계좌번호) {
		this.계좌번호 = 계좌번호;
	}
	public String get비밀번호() {
		return 비밀번호;
	}
	public void set비밀번호(String 비밀번호) {
		this.비밀번호 = 비밀번호;
	}
	public String get계좌주() {
		return 계좌주;
	}
	public void set계좌주(String 계좌주) {
		this.계좌주 = 계좌주;
	}
	public int get예금액() {
		return 예금액;
	}
	public void set예금액(int 예금액) {
		this.예금액 = 예금액;
	}
		
		//1.계좌생성
		//2.입금
		//3.출금
		//4.이체
		//5.내계좌목록
		//6.대출

}
