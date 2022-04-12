package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import Dto.Member;


public class MemberDao { //DB ���ٰ�ü

		private Connection con; //db������ ���Ǵ� Ŭ���� : db����Ŭ����
		private PreparedStatement ps; //����� db�� sql ���� �� �� ���Ǵ� db���� �������̽�
		private ResultSet rs; //������� �����ϴ� �������̽�
		
		public static MemberDao memberDao = new MemberDao(); //db ���� ��ü;
		
		
		public MemberDao(){

			
			//����ó�� �ʼ�
			
			try {
				//db����
					//1. db����̹� ��������
				Class.forName("com.mysql.cj.jdbc.Driver");
					//2. db�ּ� ����
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
						"root", "1234");

			} catch (Exception e) { System.out.println("db ���� ���� : "+ e);	}
			
		}
		
		
		//�޼ҵ�
			//���̵� �ߺ�üũ �޼ҵ�(�μ� : ���̵� �μ��� �޾� db�� �����ϴ��� üũ)
		public boolean idcheck(String id) {

			try {
				//1. SQL �ۼ�						//where = ����
					//�˻�: select * from ���̺�� where ����(�ʵ��=��) ***
				String sql = "select * from member where mid=?";
				
				//2. SQL ����
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				
				//3. SQL ����
				rs = ps.executeQuery(); // select ���� -> �˻��� ������� �����Ѵ� -> resultset 0
				//resultset ó�� �⺻���� : null -> next() -> ��� ���ڵ�		
				
				//4. SQL ���
				if(rs.next()) {
					//���࿡ ���� ������� �����ϸ� -> �ش� ���̵� ���� -> �ߺ�O
					return true; //�ش� ���̵�� �ߺ��� ����
					
				}
				
			} catch (Exception e) {System.out.println("sql���� : "+e);}	
			
			return false; //�������� ����(�ش� ���̵�� �ߺ��� ����)
		}
		
		
		
		
		
		
		
		//1. ȸ������ �޼ҵ� (�μ� : db�� ���� ���̵�, ��й�ȣ, �̸��̸� �ּ�)
		public boolean signup(Member member) {

			try {
				//1. sql �ۼ�(ȸ����ȣ(�ڵ���ȣ=auto),������ ��� �ʵ� ����
				String sql = "insert into member(mid, mpw, memail,maddress,mpoint, msince)"
						+ "values(?,?,?,?,?,?)";
				
				//2. sql ����
				ps = con.prepareStatement(sql); //preparedStatement �������̽��� ����� db�� sql �ֱ�
				ps.setString(1, member.getMid()); //���̵�
				ps.setString(2, member.getMpw()); //���
				ps.setString(3, member.getMemail()); //�̸���
				ps.setString(4, member.getMaddress()); //�ּ�
				ps.setInt(5, member.getMpoint()); //����Ʈ
				ps.setString(6, member.getMsince()); //������
				
				// ȸ������ �� �ȵɱ��???
				
				//3. sql ����
				ps.executeUpdate();
				
				return true;
			
			} catch (Exception e) { System.out.println( "[SQL ����]"+e  );}
		
		
		return false;} //���н�
		
		
		
		
		
		
		//2. �α��� �޼ҵ� (�μ�: �α��� �� �ʿ��� ���̵�, ��й�ȣ)
		public boolean login(String id, String pw){
			
			try {	
				//1. sql �ۼ�
					//������ and : ����1 and ����2 		�̸鼭
					//or : ����1 or ����2 				�̰ų�
					
				String sql = "select * from member where mid=? and mpw=?";
				
				
				//2. sql ����
				ps = con.prepareStatement(sql);
				ps.setString(1, id); //ù��° ?�� id ���� �ֱ�
				ps.setString(2, pw); //�ι�° ?�� pw ���� �ֱ�
				
				
				//3. sql ����
				rs = ps.executeQuery(); //select ����
				
				
				//4. sql ���
				if(rs.next()) { //select �� ������� ������
					return true; // ���̵�� ��й�ȣ�� ���� -> �α��� ����
				}
				
				
			} catch (Exception e) { System.out.println("sql ���� : "+e);	}	
				
			return false;} //�α��� ����
		
		
		
		
		
		//3. ���̵�ã�� �޼ҵ� (�μ� : ���̵� ã�� �� �ʿ��� �̸���)
		public String findid(String email) {
			
			try {
			
				//1. sql �ۼ�
				String sql = "select * from member where memail="+email;
				
				//2. sql ����
				ps = con.prepareStatement(sql);
				ps.setString(1, email);
				
				//3. sql ����
				ps.executeQuery(); //select ���๮
				
				//4. sql ���
				if(rs.next()) { //���� ����� ���� ���ڵ� ��������
					return rs.getString(0); // �ʵ� ��ȣ
					// rs.getString(������ �ʵ� ���� ��ȣ);
				}
				
				
				
			} catch (Exception e) { System.out.println("SQL ���� : "+e);	}
		return null; } 
		
		
		
		
		
		
		
		//4. ��й�ȣã�� �޼ҵ� (�μ� : ��й�ȣ ã�� �� �ʿ��� ���̵�, �̸���)
		public String findpw(String id, String email) {
			
			try {
				//1. SQL �ۼ�
				String sql = "select * from member where mid=? and memail=?";
				
				//2. SQL ����
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, email);
				
				//3. SQL ����
				rs = ps.executeQuery();
				
				
				//4. SQL ���
				if(rs.next()) { //�н������ db �� 3��° �ʵ��̹Ƿ� 3
					return rs.getString(3);
				}
				
				
				
			} catch (Exception e) {System.out.println("SQL ���� : "+e);	}
			
			return null;}
		
		
		
		
		
		//5. ���̵� �μ��� ȸ������ ȣ��
		public Member getmember(String id) {
			
			try {
			//1. sql �ۼ�
				String sql = "select * from member where mid=?";
				
			//2. sql ����
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
						
			//3. sql ����
				rs = ps.executeQuery();
				
			//4. sql ���
				//������ 1��
				if(rs.next()) {
					//1.��ü ����
					Member member = new Member(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getString(7));
							//1���� ���
					//rs.next(): ����� ���� ���ڵ�(��,����)
					//rs.getInt(�ʵ������ȣ): �ش� �ʵ��� �ڷ����� ���������� ��������
					//rs.getString(�ʵ������ȣ): �ش� �ʵ��� �ڷ����� ���ڿ��� ��������
							
					//2. ��ȯ(���� ��� ��ȯ)
					return member;
				} else {}

			} catch (Exception e) {		System.out.println("sql����"+e);	}	
			return null;
		}
		
		
		//6. ȸ��Ż��[ ȸ����ȣ�� �μ��� �޾� �ش� ȸ����ȣ�� ���ڵ� ����]
		public boolean delete(int mnum) {
			
			try {
			
			//1. sql �ۼ�
					//���ڵ� ���� : delete from ���̺�� where ����
				String sql = "delete from member where mnum = "+ mnum;
				
			//2. sql ����
				ps = con.prepareStatement(sql);
				ps.setInt(1, mnum);
				
			//3. sql ����
				ps.executeUpdate(); //insert, update, delete ����
				
			//4. sql ���
				return true;				
				
			} catch (Exception e) { System.out.println("sql ���� : "+e);	}
		
		return false;
		}
		
	
		
		//7. ȸ������ [ȸ����ȣ(���), �̸���(����), �ּҸ� �μ��� �޾Ƽ� ȸ������ ó��]
		public boolean update(int mnum, String email, String address) {
			
			try {
			//1. sql �ۼ�
				String sql = "update member set memail=?, maddress=? where mnum=?";
								//���̺��			�ʵ��1=������1, �ʵ��2=������2... where(����) @�׳� �ϱ�
					//������ ȸ����ȣ��� �������� �޴´�.
				
			//2. sql ����
			ps = con.prepareStatement(sql);
			ps.setString(1, email); ps.setString(2, address); ps.setInt(3, mnum);
			
			//3. sql ����
			ps.executeUpdate();
			
			//4. sql ���
			return true;
			
			} catch (Exception e) {System.out.println("sql ���� : "+e);}
			
			return false;
		}
		
		
		
		//8. �ش� ȸ����ȣ�� �ش� id ã��
		public String getmid(int mnum) {
			
			try {
				String sql = "select mid from member where =?";
				
				ps = con.prepareStatement(sql);
				ps.setInt(1, mnum);
				rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getString(1); //ã�� id ��ȯ
				}
			} catch (Exception e) {System.out.println("sql ���� : "+e);}
			return null;
		}
		
		
		
		
		//11. ī�װ��� ����
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
		
		//9. ��ü ȸ����/��ǰ��/�Խ��� �� ��ȯ
		
		public int counttotal(String tname) {
			
		String sql = "select count(*) from"+tname;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) { return rs.getInt(1); }
			//��ȸ ����� ù��° �ʵ带 ��ȯ
		} catch (Exception e) {}
	
		return 0;
		
		}

		
		
//		//10. ��ü ��ǰ �� ��ȯ
//		public int producttotal() {
//			String sql = "select count(*) from product";
//			try {ps = con.prepareStatement(sql);
//				rs = ps.executeQuery();
//				if(rs.next()) {return rs.getInt(1);}
//			} catch (Exception e) {System.out.println("sql ���� : "+e);}
//			return 0; }
		
		
		//10. �μ�:���̺��, ��¥ �ʵ���� ��¥�� ���ڵ� ��ü ���� ��ȯ
			//(��¥���� �����ڼ� ��ȯ)
		public Map<String, Integer> datetotal( String tname , String date ) {
			Map<String, Integer> map = new HashMap<>();
			
//			String sql = "select msince, count(*) from member group msince";
			String sql = "select substring_index("+date+",'',1), count(*)"
					+ "from" + tname //board��� ������ tname���� ����
					+ "group by substring_index("+date+",'',1)";
												//��¥�ʵ��
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					map.put(rs.getString(1), rs.getInt(2));
					//����� �ش� ���ڵ� ù��° �ʵ�, �ι�° �ʵ�
				}
				return map;
			} catch (Exception e) {} return null;
			
		} //end
		
		
		//11.��¥���� �Խù� ��ϼ� ��ȯ -> 10���� ��ħ
//		public Map<String, Integer> detetotal2(){
//			Map<String , Integer> map = new HashMap<String, Integer>();
//			String sql = "select * from board group by substring_index(bdate,'',1)";
//						//��¥�� �ð��� ���� �����ϱ� ������ ��¥�� �ð� �и�(���� ����)
//			try { ps = con.prepareStatement(sql);
//				rs = ps.executeQuery();
//				while(rs.next()) {
//					map.put(rs.getString(1), rs.getInt(2)); }
//				return map; } catch (Exception e) {} return null;		}
		
		
		
		
		
		
		
		
		
}
