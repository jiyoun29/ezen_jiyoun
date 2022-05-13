package dto;

public class users {
	public users() {
		// TODO Auto-generated constructor stub
	}
	
	private int Uno;
	private int mno;
	private int Ulocation;
	private int Umoney;
	private int Uturn;
	private int Urank;
	private int Uorder;
//    foreign key(mno) references memdb (mno) on update cascade
	
	
	
	public users(int uno, int mno, int ulocation, int umoney, int uturn, int urank, int uorder) {
		super();
		Uno = uno;
		this.mno = mno;
		Ulocation = ulocation;
		Umoney = umoney;
		Uturn = uturn;
		Urank = urank;
		Uorder = uorder;
	}


	

	public int getUno() {
		return Uno;
	}



	public void setUno(int uno) {
		Uno = uno;
	}



	public int getMno() {
		return mno;
	}



	public void setMno(int mno) {
		this.mno = mno;
	}



	public int getUlocation() {
		return Ulocation;
	}



	public void setUlocation(int ulocation) {
		Ulocation = ulocation;
	}



	public int getUmoney() {
		return Umoney;
	}



	public void setUmoney(int umoney) {
		Umoney = umoney;
	}



	public int getUturn() {
		return Uturn;
	}



	public void setUturn(int uturn) {
		Uturn = uturn;
	}



	public int getUrank() {
		return Urank;
	}



	public void setUrank(int urank) {
		Urank = urank;
	}



	public int getUorder() {
		return Uorder;
	}



	public void setUorder(int uorder) {
		Uorder = uorder;
	}
	
	
	
	
	
}
