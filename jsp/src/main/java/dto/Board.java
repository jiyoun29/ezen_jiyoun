package dto;

public class Board {
	private int bnum;
	private String title;
	private String content;
	private String writer;
	private String date;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int bnum, String title, String content, String writer, String date) {
		super();
		this.bnum = bnum;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
