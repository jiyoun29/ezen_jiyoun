package class1;

public class Car {

		// ��ġ, ������ȣ, �ð�
		private int location ;
		private String carnum ; 
		private String intime ;
		
		
		//�� ������
		public Car() {}

		
		//Ǯ ������
		public Car(String carnum) {
			this.carnum = carnum;
		}
		
		public Car(int location) {
			this.location = location;
		}
		
		public Car(String carnum, String intime) {
			this.carnum = carnum;
			this.intime = intime;
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
