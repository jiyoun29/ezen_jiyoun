package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//**sql로 가져오기
import java.sql.ResultSet;

import Dto.Board;
import Dto.Reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoardDAO {

	//필드
	private Connection conn; //1. DB 연결 클래스
	private PreparedStatement ps; //2.연결된 DB내 SQL 조작 인터페이스
	private ResultSet rs; //3.SQL 결과 레코드를 가져오는 인터페이스
	
	//연동객체(메모리 할당을 미리 해놓겠다는 뜻 : 반복적인 호출에 쉬움)
	public static BoardDAO boardDAO = new BoardDAO();
	/*why?
		다른 클래스에 있는 멤버 호출 시 두가지 방법이 있음
		
		1.new 객체 생성
		boarddao boarddao = new board dao;
		boarddao.메소드();
	
		2.static(정적변수)
		static 메소드는 바로 호출 가능
		boarddao.메소드();
	
		->연동객체를 굳이 만드는 이유
		
		3. 메모리 할당을 해두면 바로 가능
		boarddao.boarddao.메소드();
	*/
	
	//생성자
	public BoardDAO() { //생성자에서 연동하는 이유 : 객체 생성시 바로 DB에 넣기 위해서
		
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버이름은 회사마다 다름
						//jdbc 드라이브 크래스 호출
			conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root", "1234"); //위처럼 다르고 동일
			
		} catch (Exception e) {	}
		
	}
	
	
	//메소드 (회원가입과 유사)
		//1. 글쓰기
	public boolean write(Board board) {
		
		try {
		//1. sql 작성									//외워야함
			String sql = "insert into board(btitle, bcontent, bwriter) values(?,?,?)";
				// 저랑 다르게 = 작성자를 write 가 아닌 writer 로 했기 때문에 
				// 헷갈리수 있으니 write 로 할껀지 writer 할껀지 정하세요~
		//2. sql 조작
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBwriter());
			
		//3. sql 실행
			ps.executeUpdate(); //insert, update, delete <-> ps.executeQuery;<-select
		
		//4. sql 결과
			return true;
			//성공
			
		} catch (Exception e) { System.out.println("sql오류:"+e);	}
		
		return false; //실패
	}
	
	
	
	
		//2. 모든 글 호출
		//반환타입 : ObservableList 
	public ObservableList<Board> list() {

		//리스트 선언
		ObservableList<Board> boardlist = FXCollections.observableArrayList();
		
		try {
		//1. sql 작성
			String sql = "select * from board order by bnum desc";
				//정렬 : oder by 필드명 asc [해당 필드명 기준으로 오름차순]
								// desc [해당 필드명 기준으로 내림차순]
			
		//2. sql 조작
			ps = conn.prepareStatement(sql);
			
		//3. sql 실행
			rs = ps.executeQuery(); //select
			
		//4. sql 결과
			//rs : 검색 결과 레코드를 하나씩 순회(가져오기 = next);
			while(rs.next()) {	//레코드가 없을 때까지 반복
					//rs.next(): 검색 결과의 다음 레코드
					//rs.get자료형(해당 필드 순서 번호) : 현 레코드에서 해당 필드의 데이터 가져오기
					
				//1. 객체화
				Board board = new Board(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6));
				
				//2. 해당 객체를 리스트에 담기
				boardlist.add(board);	}
			
			//성공시 리스트 반환
			return boardlist;
			
		} catch (Exception e) {System.out.println("sql 오류 : "+e);}
		
		return null; //실패시 null
		
	}	
	
	
	
	
		//3.글 삭제 메소드
	public boolean delete(int bnum) { 
		
		try {
		//1. sql 작성
			String sql = "delete from board where bnum=?";
					//테이블명 안에 bnum와 같은 걸 지우겠다
			
		//2. sql 조작
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bnum);
			
		//3. sql 실행
			ps.executeUpdate();
			
		//4. sql 결과
			return true;
			
		} catch (Exception e) { System.out.println("sql 오류 : " + e);}		
		
		return false; }
	
	
	
	
		//4. 글 수정
	public boolean update(int bnum, String title, String contetnt) {
		
		
		
		try {
			//1. sql 작성
			String sql = "update board set btitle=?, bcontent=? where bnum=?";
					
			//2. sql 조작
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, contetnt );
			ps.setInt(3, bnum);
			
			//3. sql 실행
			ps.executeUpdate();
			
			//4. sql 결과
			return true;
		
		} catch (Exception e) { System.out.println("sql 오류 : "+e); }		
		return false;
	}
	
	
	
	//5. 댓글 작성 메소드
	
	public boolean rwrite(Reply reply) {
	
		try {
		String sql = "insert into reply(rcontent,rwrite,bnum) values (?,?,?)";
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setString(2, reply.getRwrite());
			ps.setInt(3, reply.getBnum());
			ps.executeUpdate();
			
		return true;
		
		} catch (Exception e) { System.out.println("sql오류: "+e);}
	
		return false;
	}
	
	
	
	//6. 댓글 호출 메소드
	
	public ObservableList<Reply> replylist (int bnum) {
		
		ObservableList<Reply> replylist = FXCollections.observableArrayList();
		
		try {															//오름차순
			String sql = "select * from reply where bnum =? order by bnum desc";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bnum);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Reply reply = new Reply(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getInt(5));
				replylist.add(reply);
			}
			return replylist;
			
			} catch (Exception e) { System.out.println("sql오류: "+e);}
		return null;
	}
	
	
}
