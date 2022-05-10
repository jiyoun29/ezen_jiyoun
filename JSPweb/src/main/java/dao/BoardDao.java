package dao;

import java.util.ArrayList;

import dto.Reply;
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
			
			//왜while을쓰지? -> 지속적으로 반복하기 위해서
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
	public board getboard(int bno) {
		
		//1. sql 작성 //bno 빼오기
		String sql = "select * from board where bno="+bno;
		
		try {
			//2. 연결된 db(con)에 sql 넣어서 조작
			ps = con.prepareStatement(sql);
			//3. 조작된 sql을 실행
			rs = ps.executeQuery();
			
			//4. 검색 결과 가져오기 위해 rs.next를 할때마다 레코드 한개씩 호출
			//한개 빼올때에는 if. 다 빼올 때에는 while
			if(rs.next()) {
				board board = new board(rs.getInt(1),rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), null);
				return board; //성공시 board를 줌
			}			
		} catch (Exception e) {System.out.println("오류"+e);}		
		return null;} //실패시 null값을 줌
	
	
	
	
	//4. 게시물 수정 메소드[인수 : 수정할 게시물 번호 / 수정된 내용]
	public boolean update(board board) {
		String sql = "update board set btitle=? , bcontent=? , bfile=? where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBfile());
			ps.setInt(4, board.getBno());
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println("오류"+e);}
		return false;}
	
	
	
	
	//5. 게시물 삭제 메소드[인수 : 삭제할 게시물 번호]
	public boolean delete(int bno) {
		String sql = "delete from board where bno="+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
			}catch (Exception e) {System.out.println("오류"+e);}	
		return false;}
	
	
	
	//5-1. 첨부파일만 삭제(null 변경) 메소드
	public boolean filedelete(int bno) {
		String sql = "update board set bfile = null where bno ="+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
			}catch (Exception e) {System.out.println("오류"+e);}	
		return false;
	}
	
	

	//6. 게시물 조회 증가 메소드[인수 : 증가할 게시물 번호]
	public boolean increview(int bno) {
		String sql = "update board set bview = bview+1 where bno = "+bno;
		try { ps = con.prepareStatement(sql);
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println("오류"+e);}	
		return false;}

	
	
	
	///////////////////
	
	
	
	
	//7. 댓글 작성 메소드[인수 : 작성할 데이터들 = dto]
	public boolean replywrite(Reply reply) {
		
		String sql = "insert into reply(rcontent,rindex,bno,mno)values(?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setInt(2, reply.getRindex());
			ps.setInt(3, reply.getBno());
			ps.setInt(4, reply.getMno());
			
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {System.out.println("댓글작성오류"+e);}	

		return false;}
	
	

	//8. 댓글 출력 메소드[인수 : 현재 게시물 번호]
	public ArrayList<Reply> replylist(int bno) {
		
		ArrayList<Reply> replylist = new ArrayList<Reply>();		
		
		// rindex = 0  : 대댓글 제외. 댓글만 출력
		String sql = "select * from reply where bno = "+bno+" and rindex = 0";
												//부모가 없는 애만 가져옴(댓글만 빼오고 대댓글은 안 빼옴 / rindex = 0)
		
		try { ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Reply reply = new Reply(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),
						null);
				replylist.add(reply);
			}
			return replylist;
		} catch (Exception e) {System.out.println("오류"+e);}	
	return null;
	}
	
	
	//8-2. 대댓글 출력 메소드
	public ArrayList<Reply> rereplylist(int bno, int rno){
		ArrayList<Reply> rereplyList = new ArrayList<Reply>();
		
		String sql = "select * from reply where bno = "+bno+" and rindex = "+rno;

		try { ps = con.prepareStatement(sql); rs = ps.executeQuery();
		
		while(rs.next()) {
			Reply reply = new Reply(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),
					null);
			rereplyList.add(reply);
		}
		return rereplyList;
	} catch (Exception e) {System.out.println("오류"+e);}	
		return null;
	}
	
	
	
	
	//9. 댓글 수정 메소드[인수 : 수정할 댓글 번호]
	public boolean replyupdate(Reply reply) {
		String sql = "update reply set rcontent=? where rno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setInt(2, reply.getRno());
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println("오류"+e);}
		return false;}
	
	
	
	
	//10. 댓글 삭제 메소드[인수 : 삭제할 댓글 번호]
	public boolean replydelete(int rno) {
		
		String sql = "delete from reply where rno ="+rno; //+"or rindex ="+rno
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
					return true;
		} catch (Exception e) {System.out.println("오류"+e);}	
		
		return false;}
	
	
	

}
