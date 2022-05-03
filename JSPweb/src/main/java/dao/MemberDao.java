package dao;

import dto.member;

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
		String sql = "select * from memdb where mid="+mid;
				
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//동일한 아이디가 존재하면
			if(rs.next()) {return true;}
			
		}  catch (Exception e) {System.out.println(e);}
		//동일한 아이디가 존재하지 않으면
		return false;
	}
	
	
	
	//이메일 중복체크 메소드
	public boolean emailcheck(String email) {
		String sql = "select * from memdb where memail ="+email;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	//emailcheck에서 signgup에서 작성한 걸 여기에 연결
	public boolean signup(member member) {
		
		String sql = "insert into memdb(mid,mpassword,mname,mphone,memail,maddress) values(?,?,?,?,?,?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, member.getMid()); ps.setString(2, member.getMpassword());
				ps.setString(3, member.getMname()); ps.setString(4, member.getMphone());
				ps.setString(5, member.getMemail()); ps.setString(6, member.getMaddress());
				
				ps.executeUpdate(); return true;
			} catch (Exception e) {System.out.println("회원가입오류"+e);}		
		
		return false;
	}
	
	
	
	// 로그인 메소드
	public int login(String mid, String mpw) {
		 String sql = "select * from memdb where mid = '"+mid+"' and mpassword = '"+mpw+"'";
//		String sql = "select * from memdb where mid=? and mpassword=?";
		try {
			ps = con.prepareStatement(sql);
//			ps.setString(1, mid); ps.setString(2, mpw); //?사용시 ?에 데이터 대입
			rs = ps.executeQuery(); if(rs.next()) return 1; //동일한 값이 있으면 1성공
			return 2; //동일한 값이 없으면 2 실패
		} catch (Exception e) {System.out.println(e);}
		return 3; //db오류이면 3 실패
	}
	
	
	
	
}
