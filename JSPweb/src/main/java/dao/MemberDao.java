package dao;

public class MemberDao extends Dao { //자식클래스로 객체 생성 시 부모클래스의 생성자 호출
	
	public MemberDao(){
		super(); //부모클래스 생성자 호출
	}
	
	public static MemberDao memberDao = new MemberDao();
		//dao 호출시 반복되는 new 연산자 사용
	public static MemberDao getMemberDao() {return memberDao;}
	
	
	//아이디 중복체크 메소드
	public boolean idcheck(String mid) { //인수를 mid로 받아옴
		//하나만 가져올 때에는 =? 안 쓰고 바로 넣는다
		String sql = "select * from member where mid="+mid;
				
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//동일한 아이디가 존재하면
			if(rs.next()) {return true;}
			
		}  catch (Exception e) {System.out.println(e);}
		//동일한 아이디가 존재하지 않으면
		return false;
		
	}
	
	
}
