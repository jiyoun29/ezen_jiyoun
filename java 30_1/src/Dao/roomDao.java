package Dao;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import Dto.Product;
import Dto.Roomlive;
import Dto.room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class roomDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	//db���� �Ĳ���
	
	public static roomDao roomDao = new roomDao();
	
	public roomDao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
		"root", "1234"); 

		} catch (Exception e) {} }
		
		//dao ���� ��
		
		
	//1.�� ���� �޼ҵ�
	public boolean roomadd(room room) {

		try { //����ó���ʼ�
		//sql �߰�				//���̺��(�ʵ�)values(��1)
		String sql = "insert into room(roname,roip) values(?,?)";
					//���̺� ���ڵ� �߰� ���� = insert into ���̺��(�ʵ��1,�ʵ��2) values(��1, ��2);
		ps = con.prepareStatement(sql);
		ps.setString(1, room.getRoname());
		ps.setString(2, room.getRoip());
		ps.executeUpdate();
		return true;
		} catch (Exception e) {System.out.println("����="+e);}
		return false;
	}
	
		
	//2.���ȣ ȣ�� �޼ҵ� [ ���ȣ = ��Ʈ��ȣ�� ����� ���� ]
	public int getroomnum() {
		try { //����ó���ʼ�
			
			//���� �ֱٿ� ��ϵ� �� ��ȣ ��������(max(�ʵ��) : �ش� �ʵ��� ���� ū ��)<-db�Լ�
			String sql = "select max ronum from room";
						//�˻�
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1); //������ �����ͼ� �ֱٿ� ��ϵ� ���ȣ�� ��ȯ
			}
			
			
		} catch (Exception e) {System.out.println("����="+e);}
		
		return 0; //������ 0
		
	}
	


	///////
	//3. ��� �� ȣ�� �޼ҵ�
	public ObservableList<room> roomList(){
		ObservableList<room> roomlist = FXCollections.observableArrayList();
		try {

			String sql = "select * from room order by ronum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				room room = new room(rs.getInt(1),rs.getString(2),rs.getString(3),0 );
				
				
				roomlist.add(room);
			}
			return roomlist;
			
		} catch (Exception e) {System.out.println("����="+e);}
		return null;
	}
	
	
	
	/////////////////////
	
	
	//4. ä�ù� ���� ��� �߰�
	public boolean addroomlive(Roomlive roomlive) {
		
		String sql = "insert into roomlive(ronum,mid) values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomlive.getRonum());
			ps.setString(2, roomlive.getMid());
			
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {System.out.println("����="+e);}

		return false;
	}
	
	
	
	//5. ä�ù濡 ������ ��� ��� ȣ��
	public ArrayList<Roomlive> getRoomlivelist (int ronum){
		
		ArrayList<Roomlive> roomlivelist = new ArrayList<>();
		try {
			String sql = "select * from roomlive where ronum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ronum);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Roomlive roomlive = new Roomlive(rs.getInt(1),
						rs.getInt(2), rs.getString(3));
				roomlivelist.add(roomlive);
			}
			return roomlivelist;
			
			
		} catch (Exception e) {System.out.println("����="+e);}
		return null;

	}
	
	///////////////////////
	
	
	
	//6. ä�ù� ���� ��� ����
	public boolean roomlivedelete(String mid) {
		
		//������ ���ϴ�... ��� ���� sql�� �ܿ��
		String sql = "delete from roomlive where mid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.executeUpdate(); //������Ʈ ���·� ����
			return true;
			
		} catch (Exception e) {System.out.println("����="+e);}
	
		return false;

	}
	
	
	//7. ä�ù� ����[���� : �ο��� 0�϶�]
	public boolean roomdelete(int ronum) {
	
		//���࿡ �ش� �� ��ȣ�� roomlive���� �˻����� �� �˻������ ����(���ڵ� ����)�ϸ� �� ����x
			//�˻� ����� ������(���ڵ� �������� ����) �� ����o
		
		String sql = "select * from roomlive where ronum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ronum);
			rs = ps.executeQuery();
			
			if(rs.next()) { //����� �����ϸ� �� ���� ����
				return false;
			} else { //����� ������ �� ���� ó��
				String sql2 = "delete from room where ronum =? ";
				//���� ����
				ps = con.prepareStatement(sql);
				ps.setInt(1, ronum);
				ps.executeUpdate();
				return true; //���� ����� ���� �� ���� ����
			}
			
		} catch (Exception e) {System.out.println("����="+e);}
					
		
	
		return false;
	}
	
	
	///////////////////////////////
}
