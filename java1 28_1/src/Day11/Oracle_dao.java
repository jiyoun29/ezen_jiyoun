package Day11;

public class Oracle_dao implements DAO {
	
	@Override
	public Void select() {
		System.out.println("오라클 DB에서 검색");
	}
	@Override
	public Void insert() {
		System.out.println("오라클 DB에서 삽입");
	}
	@Override
	public Void update() {
		System.out.println("오라클 DB에서 수정");
	}
	@Override
	public Void delete() {
		System.out.println("오라클 DB에서 삭제");
	}
	

}
