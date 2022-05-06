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
	
	
	
	///////////////////////////////// 5/4
	
	//개별 회원정보 출력 [인수:세션에 저장된 회원id]
	public member getMember(String mid) {
		
		//String sql = "select * from member where mid = ?";
		String sql = "select * from memdb where mid = '"+mid+"'";
		
		try { //패스워드는 제외
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//검색된 레코드의 모든 필드의 값을 객체화
			if(rs.next()) {	//패스워드는 제외이므로 null
				member member = new member(rs.getInt(1), rs.getString(2), null,
						rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7),
						rs.getInt(8), rs.getString(9));
				//반환 필수
				return member; //
			}
			
		} catch (Exception e) {System.out.println(e);} return null;
	
	}
	
	
	
	
	//패스워드 확인 메소드
	public boolean passwordcheck(String mid, String mpassword) {
		
		String sql = "select * from memdb where "
				+ "mid = '"+mid+"' and mpassword = '"+mpassword+"'";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) return true; //아이디와 비번이 동일하면 true(1)
			
		} catch (Exception e) {System.out.println(e);} 
		
		return false;//아이디와 비번이 동일하지 않으면 true(2)
	}
	
	
	
	//회원 삭제 메소드
	public boolean delete(String mid) {
		String sql = "delete from memdb where mid = '"+mid+"'";
		
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate(); return true;			
		} catch (Exception e) {System.out.println(e);} 
		return false;
	}
	
	
	
	//회원 수정 메소드
	public boolean update(member member) {
		
		try {
		if(member.getMpassword() == null){ // 패스워드 변경이 없을때 
			String sql = "update memdb set mname=?,  mphone=?, memail=?, maddress=? where mno=?";
				ps = con.prepareStatement(sql);
				ps.setString( 1 , member.getMname() );
				ps.setString( 2 , member.getMphone() );
				ps.setString( 3 , member.getMemail() );
				ps.setString( 4 , member.getMaddress() );
				ps.setInt( 5, member.getMno() );
		}
		else {	// 패스워드가 변경이 있을때 
	
		String sql = "update memdb set mname=?, mpassword=?, mphone=?, memail=?, maddress=? where mno=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMname());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMphone());
			ps.setString(4, member.getMemail());
			ps.setString(5, member.getMaddress());
			ps.setInt(6, member.getMno());
		}
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println("패스워드변경오류"+e);} return false;
	}
	
	
	
	//회원번호 출력 메소드
	public int getmno(String mid) {
		String sql = "select mno from memdb where mid ='"+mid+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) return rs.getInt(1);
		} catch (Exception e) {System.out.println("회원번호출력실패"+e);} return 0;
	}
	
	
	
	
	
	
	
}
