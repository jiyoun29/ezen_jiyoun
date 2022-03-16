package Day11;

public class Reply {
	
	//1.필드
	private String content;
	private String pw;
	private String writer;	
	private String date;	
	
	
	//2.생성자
		//1.빈 생성자
	public Reply() {}
		//2. 풀 생성자(모든 필드)

	public Reply(String content, String pw, String writer, String date) {
		super();
		this.content = content;
		this.pw = pw;
		this.writer = writer;
		this.date = date;
	}


	
		//3. 댓글등록시 사용되는 생성자
	
	public Reply(String content, String pw, String writer) {
		super();
		this.content = content;
		this.pw = pw;
		this.writer = writer;
	}

	
	//3.메소드

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

	
	
	
	
	
}
