package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import Dto.Member;


public class MemberDao { //DB 접근객체

		private Connection con; //db연동시 사용되는 클래스 : db연동클래스
		private PreparedStatement ps; //연결된 db내 sql 조작 할 때 사용되는 db조작 인터페이스
		private ResultSet rs; //결과물을 조작하는 인터페이스
		
		public static MemberDao memberDao = new MemberDao(); //db 연동 객체;
		
		
		public MemberDao(){

			
			//예외처리 필수
			
			try {
				//db연동
					//1. db드라이버 가져오기
				Class.forName("com.mysql.cj.jdbc.Driver");
					//2. db주소 연결
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
						"root", "1234");

			} catch (Exception e) { System.out.println("db 연동 오류 : "+ e);	}
			
		}
		
		
		//메소드
			//아이디 중복체크 메소드(인수 : 아이디를 인수로 받아 db에 존재하는지 체크)
		public boolean idcheck(String id) {

			try {
				//1. SQL 작성						//where = 조건
					//검색: select * from 테이블명 where 조건(필드명=값) ***
				String sql = "select * from member where mid=?";
				
				//2. SQL 조작
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				
				//3. SQL 실행
				rs = ps.executeQuery(); // select 실행 -> 검색은 결과물이 존재한다 -> resultset 0
				//resultset 처음 기본값은 : null -> next() -> 결과 레코드		
				
				//4. SQL 결과
				if(rs.next()) {
					//만약에 다음 결과물이 존재하면 -> 해당 아이디가 존재 -> 중복O
					return true; //해당 아이디는 중복이 존재
					
				}
				
			} catch (Exception e) {System.out.println("sql오류 : "+e);}	
			
			return false; //존재하지 않음(해당 아이디는 중복이 없음)
		}
		
		
		
		
		
		
		
		//1. 회원가입 메소드 (인수 : db에 넣을 아이디, 비밀번호, 이메이르 주소)
		public boolean signup(Member member) {

			try {
				//1. sql 작성(회원번호(자동번호=auto),제외한 모든 필드 삽입
				String sql = "insert into member(mid, mpw, memail,maddress,mpoint, msince)"
						+ "values(?,?,?,?,?,?)";
				
				//2. sql 조작
				ps = con.prepareStatement(sql); //preparedStatement 인터페이스내 연결된 db에 sql 넣기
				ps.setString(1, member.getMid()); //아이디
				ps.setString(2, member.getMpw()); //비번
				ps.setString(3, member.getMemail()); //이메일
				ps.setString(4, member.getMaddress()); //주소
				ps.setInt(5, member.getMpoint()); //포인트
				ps.setString(6, member.getMsince()); //가입일
				
				// 회원가입 왜 안될까요???
				
				//3. sql 실행
				ps.executeUpdate();
				
				return true;
			
			} catch (Exception e) { System.out.println( "[SQL 오류]"+e  );}
		
		
		return false;} //실패시
		
		
		
		
		
		
		//2. 로그인 메소드 (인수: 로그인 시 필요한 아이디, 비밀번호)
		public boolean login(String id, String pw){
			
			try {	
				//1. sql 작성
					//연산자 and : 조건1 and 조건2 		이면서
					//or : 조건1 or 조건2 				이거나
					
				String sql = "select * from member where mid=? and mpw=?";
				
				
				//2. sql 조작
				ps = con.prepareStatement(sql);
				ps.setString(1, id); //첫번째 ?에 id 변수 넣기
				ps.setString(2, pw); //두번째 ?에 pw 변수 넣기
				
				
				//3. sql 실행
				rs = ps.executeQuery(); //select 실행
				
				
				//4. sql 결과
				if(rs.next()) { //select 시 결과물이 있으면
					return true; // 아이디와 비밀번호가 동일 -> 로그인 성공
				}
				
				
			} catch (Exception e) { System.out.println("sql 오류 : "+e);	}	
				
			return false;} //로그인 실패
		
		
		
		
		
		//3. 아이디찾기 메소드 (인수 : 아이디 찾기 시 필요한 이메일)
		public String findid(String email) {
			
			try {
			
				//1. sql 작성
				String sql = "select * from member where memail="+email;
				
				//2. sql 조작
				ps = con.prepareStatement(sql);
				ps.setString(1, email);
				
				//3. sql 실행
				ps.executeQuery(); //select 실행문
				
				//4. sql 결과
				if(rs.next()) { //실행 결과에 다음 레코드 가져오기
					return rs.getString(0); // 필드 번호
					// rs.getString(가져올 필드 순서 번호);
				}
				
				
				
			} catch (Exception e) { System.out.println("SQL 오류 : "+e);	}
		return null; } 
		
		
		
		
		
		
		
		//4. 비밀번호찾기 메소드 (인수 : 비밀번호 찾기 시 필요한 아이디, 이메일)
		public String findpw(String id, String email) {
			
			try {
				//1. SQL 작성
				String sql = "select * from member where mid=? and memail=?";
				
				//2. SQL 조작
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, email);
				
				//3. SQL 실행
				rs = ps.executeQuery();
				
				
				//4. SQL 결과
				if(rs.next()) { //패스워드는 db 내 3번째 필드이므로 3
					return rs.getString(3);
				}
				
				
				
			} catch (Exception e) {System.out.println("SQL 오류 : "+e);	}
			
			return null;}
		
		
		
		
		
		//5. 아이디 인수로 회원정보 호출
		public Member getmember(String id) {
			
			try {
			//1. sql 작성
				String sql = "select * from member where mid=?";
				
			//2. sql 조작
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
						
			//3. sql 실행
				rs = ps.executeQuery();
				
			//4. sql 결과
				//무조건 1명
				if(rs.next()) {
					//1.객체 선언
					Member member = new Member(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getString(7));
							//1개씩 담기
					//rs.next(): 결과내 다음 레코드(줄,가로)
					//rs.getInt(필드순서번호): 해당 필드의 자료형이 정수형으로 가져오기
					//rs.getString(필드순서번호): 해당 필드의 자료형이 문자열로 가져오기
							
					//2. 반환(없을 경우 반환)
					return member;
				} else {}

			} catch (Exception e) {		System.out.println("sql오류"+e);	}	
			return null;
		}
		
		
		//6. 회원탈퇴[ 회원번호를 인수로 받아 해당 회원번호의 레코드 삭제]
		public boolean delete(int mnum) {
			
			try {
			
			//1. sql 작성
					//레코드 삭제 : delete from 테이블명 where 조건
				String sql = "delete from member where mnum = "+ mnum;
				
			//2. sql 조작
				ps = con.prepareStatement(sql);
				ps.setInt(1, mnum);
				
			//3. sql 실행
				ps.executeUpdate(); //insert, update, delete 실행
				
			//4. sql 결과
				return true;				
				
			} catch (Exception e) { System.out.println("sql 오류 : "+e);	}
		
		return false;
		}
		
	
		
		//7. 회원수정 [회원번호(대상), 이메일(내용), 주소를 인수로 받아서 회원수정 처리]
		public boolean update(int mnum, String email, String address) {
			
			try {
			//1. sql 작성
				String sql = "update member set memail=?, maddress=? where mnum=?";
								//테이블명			필드명1=수정값1, 필드명2=수정값2... where(조건) @그냥 암기
					//동일한 회원번호라면 수정값을 받는다.
				
			//2. sql 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, email); ps.setString(2, address); ps.setInt(3, mnum);
			
			//3. sql 실행
			ps.executeUpdate();
			
			//4. sql 결과
			return true;
			
			} catch (Exception e) {System.out.println("sql 오류 : "+e);}
			
			return false;
		}
		
		
		
		//8. 해당 회원번호로 해당 id 찾기
		public String getmid(int mnum) {
			
			try {
				String sql = "select mid from member where =?";
				
				ps = con.prepareStatement(sql);
				ps.setInt(1, mnum);
				rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getString(1); //찾은 id 반환
				}
			} catch (Exception e) {System.out.println("sql 오류 : "+e);}
			return null;
		}
		
		
		
		
		//11. 카테고리별 개수
		public Map<String , Integer> countcategory(){
			Map<String, Integer> map = new HashMap<>();
		String sql = "select pcategory, count(*) from product group by pcategory";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) { map.put(rs.getString(1), rs.getInt(2)); }
				return map;
			} catch (Exception e) {} return null;		
		}
		
		//9. 전체 회원수/제품수/게시판 수 반환
		
		public int counttotal(String tname) {
			
		String sql = "select count(*) from"+tname;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) { return rs.getInt(1); }
			//조회 결과의 첫번째 필드를 반환
		} catch (Exception e) {}
	
		return 0;
		
		}

		
		
//		//10. 전체 제품 수 반환
//		public int producttotal() {
//			String sql = "select count(*) from product";
//			try {ps = con.prepareStatement(sql);
//				rs = ps.executeQuery();
//				if(rs.next()) {return rs.getInt(1);}
//			} catch (Exception e) {System.out.println("sql 오류 : "+e);}
//			return 0; }
		
		
		//10. 인수:테이블명, 날짜 필드명의 날짜별 레코드 전체 개수 반환
			//(날짜별로 가입자수 반환)
		public Map<String, Integer> datetotal( String tname , String date ) {
			Map<String, Integer> map = new HashMap<>();
			
//			String sql = "select msince, count(*) from member group msince";
			String sql = "select substring_index("+date+",'',1), count(*)"
					+ "from" + tname //board라고 적힌걸 tname으로 변경
					+ "group by substring_index("+date+",'',1)";
												//날짜필드명
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					map.put(rs.getString(1), rs.getInt(2));
					//결과의 해당 레코드 첫번째 필드, 두번째 필드
				}
				return map;
			} catch (Exception e) {} return null;
			
		} //end
		
		
		//11.날짜별로 게시물 등록수 반환 -> 10번과 합침
//		public Map<String, Integer> detetotal2(){
//			Map<String , Integer> map = new HashMap<String, Integer>();
//			String sql = "select * from board group by substring_index(bdate,'',1)";
//						//날짜랑 시간이 같이 존재하기 때문에 날짜랑 시간 분리(공백 기준)
//			try { ps = con.prepareStatement(sql);
//				rs = ps.executeQuery();
//				while(rs.next()) {
//					map.put(rs.getString(1), rs.getInt(2)); }
//				return map; } catch (Exception e) {} return null;		}
		
		
		
		
		
		
		
		
		
}
