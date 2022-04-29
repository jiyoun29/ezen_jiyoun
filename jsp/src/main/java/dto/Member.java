package dto;

public class Member {

	private int mnum;
	private static String id;
	private String pw;
	private String name;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(int mnum, String id, String pw, String name) {
		super();
		this.mnum = mnum;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public static String getId() {
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
		
	
	
		
	
}
