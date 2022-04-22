package teest0422;

public class UserDto {
	
	private int gnum;
	private String gid;
	private String gpw;
	private String gname;
	private String gmail;
    
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}


	public UserDto(int gnum, String gid, String gpw, String gname, String gmail) {
		super();
		this.gnum = gnum;
		this.gid = gid;
		this.gpw = gpw;
		this.gname = gname;
		this.gmail = gmail;
	}


	public int getGnum() {
		return gnum;
	}


	public void setGnum(int gnum) {
		this.gnum = gnum;
	}


	public String getGid() {
		return gid;
	}


	public void setGid(String gid) {
		this.gid = gid;
	}


	public String getGpw() {
		return gpw;
	}


	public void setGpw(String gpw) {
		this.gpw = gpw;
	}


	public String getGname() {
		return gname;
	}


	public void setGname(String gname) {
		this.gname = gname;
	}


	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	
	
}
