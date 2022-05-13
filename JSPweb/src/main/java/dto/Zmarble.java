package dto;

public class Zmarble {
	public Zmarble() {
		// TODO Auto-generated constructor stub
	}
	
	private int Zno;
	private String Zname;
	private int Zprice;
	private String Zproprietor;
	
	
	
	public Zmarble(int zno, String zname, int zprice, String zproprietor) {
		super();
		Zno = zno;
		Zname = zname;
		Zprice = zprice;
		Zproprietor = zproprietor;
	}



	public int getZno() {
		return Zno;
	}



	public void setZno(int zno) {
		Zno = zno;
	}



	public String getZname() {
		return Zname;
	}



	public void setZname(String zname) {
		Zname = zname;
	}



	public int getZprice() {
		return Zprice;
	}



	public void setZprice(int zprice) {
		Zprice = zprice;
	}



	public String getZproprietor() {
		return Zproprietor;
	}



	public void setZproprietor(String zproprietor) {
		Zproprietor = zproprietor;
	}
	
	
	
	
	
    
}
