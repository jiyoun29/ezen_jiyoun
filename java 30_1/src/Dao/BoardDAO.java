package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//**sql�� ��������
import java.sql.ResultSet;

import Dto.Board;
import Dto.Reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoardDAO {

	//�ʵ�
	private Connection conn; //1. DB ���� Ŭ����
	private PreparedStatement ps; //2.����� DB�� SQL ���� �������̽�
	private ResultSet rs; //3.SQL ��� ���ڵ带 �������� �������̽�
	
	//������ü(�޸� �Ҵ��� �̸� �س��ڴٴ� �� : �ݺ����� ȣ�⿡ ����)
	public static BoardDAO boardDAO = new BoardDAO();
	/*why?
		�ٸ� Ŭ������ �ִ� ��� ȣ�� �� �ΰ��� ����� ����
		
		1.new ��ü ����
		boarddao boarddao = new board dao;
		boarddao.�޼ҵ�();
	
		2.static(��������)
		static �޼ҵ�� �ٷ� ȣ�� ����
		boarddao.�޼ҵ�();
	
		->������ü�� ���� ����� ����
		
		3. �޸� �Ҵ��� �صθ� �ٷ� ����
		boarddao.boarddao.�޼ҵ�();
	*/
	
	//������
	public BoardDAO() { //�����ڿ��� �����ϴ� ���� : ��ü ������ �ٷ� DB�� �ֱ� ���ؼ�
		
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); //����̹��̸��� ȸ�縶�� �ٸ�
						//jdbc ����̺� ũ���� ȣ��
			conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root", "1234"); //��ó�� �ٸ��� ����
			
		} catch (Exception e) {	}
		
	}
	
	
	//�޼ҵ� (ȸ�����԰� ����)
		//1. �۾���
	public boolean write(Board board) {
		
		try {
		//1. sql �ۼ�									//�ܿ�����
			String sql = "insert into board(btitle, bcontent, bwriter) values(?,?,?)";
				// ���� �ٸ��� = �ۼ��ڸ� write �� �ƴ� writer �� �߱� ������ 
				// �򰥸��� ������ write �� �Ҳ��� writer �Ҳ��� ���ϼ���~
		//2. sql ����
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBwriter());
			
		//3. sql ����
			ps.executeUpdate(); //insert, update, delete <-> ps.executeQuery;<-select
		
		//4. sql ���
			return true;
			//����
			
		} catch (Exception e) { System.out.println("sql����:"+e);	}
		
		return false; //����
	}
	
	
	
	
		//2. ��� �� ȣ��
		//��ȯŸ�� : ObservableList 
	public ObservableList<Board> list() {

		//����Ʈ ����
		ObservableList<Board> boardlist = FXCollections.observableArrayList();
		
		try {
		//1. sql �ۼ�
			String sql = "select * from board order by bnum desc";
				//���� : oder by �ʵ�� asc [�ش� �ʵ�� �������� ��������]
								// desc [�ش� �ʵ�� �������� ��������]
			
		//2. sql ����
			ps = conn.prepareStatement(sql);
			
		//3. sql ����
			rs = ps.executeQuery(); //select
			
		//4. sql ���
			//rs : �˻� ��� ���ڵ带 �ϳ��� ��ȸ(�������� = next);
			while(rs.next()) {	//���ڵ尡 ���� ������ �ݺ�
					//rs.next(): �˻� ����� ���� ���ڵ�
					//rs.get�ڷ���(�ش� �ʵ� ���� ��ȣ) : �� ���ڵ忡�� �ش� �ʵ��� ������ ��������
					
				//1. ��üȭ
				Board board = new Board(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6));
				
				//2. �ش� ��ü�� ����Ʈ�� ���
				boardlist.add(board);	}
			
			//������ ����Ʈ ��ȯ
			return boardlist;
			
		} catch (Exception e) {System.out.println("sql ���� : "+e);}
		
		return null; //���н� null
		
	}	
	
	
	
	
		//3.�� ���� �޼ҵ�
	public boolean delete(int bnum) { 
		
		try {
		//1. sql �ۼ�
			String sql = "delete from board where bnum=?";
					//���̺�� �ȿ� bnum�� ���� �� ����ڴ�
			
		//2. sql ����
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bnum);
			
		//3. sql ����
			ps.executeUpdate();
			
		//4. sql ���
			return true;
			
		} catch (Exception e) { System.out.println("sql ���� : " + e);}		
		
		return false; }
	
	
	
	
		//4. �� ����
	public boolean update(int bnum, String title, String contetnt) {
		
		
		
		try {
			//1. sql �ۼ�
			String sql = "update board set btitle=?, bcontent=? where bnum=?";
					
			//2. sql ����
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, contetnt );
			ps.setInt(3, bnum);
			
			//3. sql ����
			ps.executeUpdate();
			
			//4. sql ���
			return true;
		
		} catch (Exception e) { System.out.println("sql ���� : "+e); }		
		return false;
	}
	
	
	
	//5. ��� �ۼ� �޼ҵ�
	
	public boolean rwrite(Reply reply) {
	
		try {
		String sql = "insert into reply(rcontent,rwrite,bnum) values (?,?,?)";
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setString(2, reply.getRwrite());
			ps.setInt(3, reply.getBnum());
			ps.executeUpdate();
			
		return true;
		
		} catch (Exception e) { System.out.println("sql����: "+e);}
	
		return false;
	}
	
	
	
	//6. ��� ȣ�� �޼ҵ�
	
	public ObservableList<Reply> replylist (int bnum) {
		
		ObservableList<Reply> replylist = FXCollections.observableArrayList();
		
		try {															//��������
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
			
			} catch (Exception e) { System.out.println("sql����: "+e);}
		return null;
	}
	
	
}
