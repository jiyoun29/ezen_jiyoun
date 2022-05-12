package dto;

public class Product {
	public Product() {
		// TODO Auto-generated constructor stub
	}

	private int pno;
	private String pname;
	private int pprice;
	private float pdiscount;
    private int pactive; //제품상태
    private String pimg;
    private int cano;
    
    
    
    
	public Product(int pno, String pname, int pprice, float pdiscount, int pactive, String pimg, int cano) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.pactive = pactive;
		this.pimg = pimg;
		this.cano = cano;
	}




	public int getPno() {
		return pno;
	}




	public void setPno(int pno) {
		this.pno = pno;
	}




	public String getPname() {
		return pname;
	}




	public void setPname(String pname) {
		this.pname = pname;
	}




	public int getPprice() {
		return pprice;
	}




	public void setPprice(int pprice) {
		this.pprice = pprice;
	}




	public float getPdiscount() {
		return pdiscount;
	}




	public void setPdiscount(float pdiscount) {
		this.pdiscount = pdiscount;
	}




	public int getPactive() {
		return pactive;
	}




	public void setPactive(int pactive) {
		this.pactive = pactive;
	}




	public String getPimg() {
		return pimg;
	}




	public void setPimg(String pimg) {
		this.pimg = pimg;
	}




	public int getCano() {
		return cano;
	}




	public void setCano(int cano) {
		this.cano = cano;
	}
    
    
    
    
    
    
}
