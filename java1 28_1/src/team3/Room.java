package team3;

public class Room {

	// �ʵ�
		private String rname;
		private String rprice;
		private String reserve;
		private String name;
		private String date;
		
		// ������
		public Room() {}

		public Room(String rname, String rprice, String reserve, String name, String date) {
			super();
			this.rname = rname;
			this.rprice = rprice;
			this.reserve = reserve;
			this.name = name;
			this.date = date;
		}

		public Room(String reserve, String name, String date) {
			super();
			this.reserve = reserve;
			this.name = name;
			this.date = date;
		}
		
		// �޼ҵ�
		public String getRname() {
			return rname;
		}

		public void setRname(String rname) {
			this.rname = rname;
		}

		public String getRprice() {
			return rprice;
		}

		public void setRprice(String rprice) {
			this.rprice = rprice;
		}

		public String getReserve() {
			return reserve;
		}

		public void setReserve(String reserve) {
			this.reserve = reserve;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		
}
