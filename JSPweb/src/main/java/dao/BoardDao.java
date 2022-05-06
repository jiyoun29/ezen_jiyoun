package dao;

import java.util.ArrayList;

import dto.board;

public class BoardDao extends Dao {

	public BoardDao() {
		super();
		//슈퍼클래스 호출(db연동)
		//super.메소드() super.필드명 super() : 생성자
	}

	//필수x인데 편함
	public static BoardDao boardDao = new BoardDao();
	public static BoardDao getBoardDao() {return boardDao;}

//	public boolean write() {return false;}
//	public static void main(String[] args) {
//		//메소드 호출방법1
//		BoardDao boardDao2 = new BoardDao();
//		boardDao2.write();
//		//메소드 호출방법2
//		BoardDao.getBoardDao().write();	}
	
	
	//1. 게시물 쓰기 메소드 [인수 : 작성 내용 필요 ]
	public boolean write( board board) {
		
		String sql = "insert into board(btitle, bcontent, mno, bfile)values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle()); ps.setString(2, board.getBcontent());
			ps.setInt(3, board.getMno()); ps.setString(4, board.getBfile());
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println("오류"+e);}	
		return false;}
	
	
	//2. 모든 게시물 출력 메소드 [추후 기능 - 검색 : 조건]
	public ArrayList<board> getboardlist() {
		
		ArrayList<board> boardlist = new ArrayList<board>();
		
		//내림차순
		String sql = "select * from board order by bno desc";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//왜while을쓰지?
			while(rs.next()) { //다 꺼내오기
				board board = new board(rs.getInt(1),rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), null);
					//숫자 잘 맞추기
				boardlist.add(board); //추가하기
			}
			return boardlist; //되돌리기
		} catch (Exception e) {System.out.println("오류"+e);}			
		return null;}
	
	
	
	//3. 개별 게시물 출력 메소드[인수 : 게시물 번호]
	public board getboard(int bno) {return null;}
	
	//4. 게시물 수정 메소드[인수 : 수정할 게시물 번호 / 수정된 내용]
	public boolean update(board board) {return false;}
	
	//5. 게시물 삭제 메소드[인수 : 삭제할 게시물 번호]
	public boolean delete(int bno) {return false;}

	//6. 게시물 조회 증가 메소드[인수 : 증가할 게시물 번호]
	public boolean increview(int bno) {return false;}

	
	///////////////////
	
	//7. 댓글 작성 메소드[인수 : 작성할 데이터들 = dto]
	public boolean replywrite() {return false;}

	//8. 댓글 출력 메소드[인수 : x]
	public boolean replylist() {return false;}
	
	//9. 댓글 수정 메소드[인수 : 수정할 댓글 번호]
	public boolean replyupdate() {return false;}
	
	//10. 댓글 삭제 메소드[인수 : 삭제할 댓글 번호]
	public boolean replydelete() {return false;}
	
	
	

}
