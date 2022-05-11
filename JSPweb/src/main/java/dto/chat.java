package dto;

public class chat {
	
	private String cname;
	private String ccontent;
	private int cnum;
	
	public chat() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "chat [cname=" + cname + ", ccontent=" + ccontent + ", cnum=" + cnum + "]";
	}



	public chat(String cname, String ccontent, int cnum) {
		super();
		this.cname = cname;
		this.ccontent = ccontent;
		this.cnum = cnum;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	
	
	
}
