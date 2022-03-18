package team2;

public class Car {

	private int location ;
	private String carnum ; 
	private String intime ;
	
	
	//朔 持失切
	public Car() {}

	
	//熱持失切
	public Car(int location) {
		this.location = location;
	}

	public Car(int location, String carnum, String intime) {
		this.location = location;
		this.carnum = carnum;
		this.intime = intime;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}
	
	
}