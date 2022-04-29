package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Board;
import dto.Member;


public class MemberDao {
	 
	private Connection con; //db 연결 클래스
	private PreparedStatement ps; // db조작 인터페이스
	private ResultSet rs; //멀티베이스
	
	
	
	//연동
	public MemberDao() {
		//jdbc : 자바 db 연동
			//1. 프로젝트 내 build path에 mysqljdbc.jar 추가
			//2. 프로젝트 내 webapp -> web-inf-lib- mysqljdbc.jar 추가
		
		//무조건 예외처리
		
		try {
		//연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsptest?serverTimezone=UTC",
				"root", "1234");
			System.out.println("연동 성공");
		} catch (Exception e) {System.out.println("연동 실패"+e);}
	} //memberdao end
	
	
	//회원가입
	public boolean signup(Member member) {
		//1. sql 작성
		String sql = "insert into member(mid, mpw, mname) values(?,?,?)";
				//insert into 테이블(필드명1, 필드명2, 필드명3) values(값1, 값2, 값3)
				//insert into 테이블 values(값1, 값2, 값3, 값4);
		
		//2. 연결된 db에 sql 연결(예외처리) 
		try {
			ps = con.prepareStatement(sql);
			//3. 각 ?에 데이터 대입
			ps.setString(1, member.getId());
			ps.setString(2, member.getPw());
			ps.setString(3, member.getName());
			//4. sql 실행
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("오류"+e);}
		return false;	}
	
	
	//로그인
	public boolean login(String id, String pw) {
		String sql = "select * from member where mid=? and mpw=?";
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, id); ps.setString(2, pw); rs = ps.executeQuery();
			if(rs.next()) {return true;}
		} catch (Exception e) {System.out.println("오류"+e);}
		return false;
	}
	
	
	
	
	//게시물 작성
	public boolean writer(Board board) {
		String sql = "insert into board(btitle, bcontent, bwriter, bdate) value(?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setString(3, board.getWriter());
			ps.setString(4, board.getDate());
			
			ps.executeUpdate(); //insert = update
			return true;
		}catch (Exception e) {System.out.println("오류"+e);}
		return false;
	}
	
	
	
	//모든 글 출력
	public ArrayList<Board> list(){
		ArrayList<Board> boardlist = new ArrayList<Board>(); //리스트 선언 - 여러개 게시물 저장
		String sql = "select * from board order by bnum desc"; //조건 없는 모든 레코드 출력
					//aesc 오름차순
		try {
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Board board = new Board(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5));
			boardlist.add(board);
			}
		return boardlist;
		} catch (Exception e) {System.out.println(e);} return null;
	}
	
	
	//개별 글 조회
	//(식별 번호 전달 받음)
	public Board get(int bnum) {
		String sql = "select * from board where bnum=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Board board = new Board(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5));
				//반환(중요)
				return board;
			}			
		} catch (Exception e) {} return null;
	}
	
	
	//게시물 삭제
	public boolean bdelete(int bnum) {
		String sql = "delete from board where bnum =?";
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			ps.executeUpdate();
			return true;// 성공시
		} catch (Exception e) {} return false;
	}
	
	
	//회원탈퇴
	public boolean delete(String id, String pw) {
		
		try {
			String sql = "delete from member where mid=? and mpw=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			
			ps.executeUpdate();
			
			return true;
		} catch (Exception e) {System.out.println("오류"+e);}
		return false;
	}
	
	
	

}
