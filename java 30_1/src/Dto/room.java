package Dto;

public class room {

	private int ronum;
	private String roname;
	private String roip;
	private int romcount; //�ο���
		//����ʵ� db����x
	
	public room() {
	}

	
	
	public room(int ronum, String roname, String roip, int romcount) {
		super();
		this.ronum = ronum;
		this.roname = roname;
		this.roip = roip;
		this.romcount = romcount;
	}

	
	
	public int getRonum() {
		return ronum;
	}

	public void setRonum(int ronum) {
		this.ronum = ronum;
	}

	public String getRoname() {
		return roname;
	}

	public void setRoname(String roname) {
		this.roname = roname;
	}

	public String getRoip() {
		return roip;
	}

	public void setRoip(String roip) {
		this.roip = roip;
	}

	public int getRomcount() {
		return romcount;
	}

	public void setRomcount(int romcount) {
		this.romcount = romcount;
	}
	
	
	
	
	
	
////////////////////////////////////////////////
}
