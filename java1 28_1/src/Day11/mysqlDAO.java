package Day11;

public class mysqlDAO implements DAO {
	//구현 받고 오버라이드
	
	@Override
	public Void select() {
		System.out.println("mysql DB에서 검색");
	}
	@Override
	public Void insert() {
		System.out.println("mysql DB에서 삽입");
	}
	@Override
	public Void update() {
		System.out.println("mysql DB에서 수정");
	}
	@Override
	public Void delete() {
		System.out.println("mysql DB에서 삭제");
	}

}
