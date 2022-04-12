package application.Day22;

import java.net.MulticastSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class Day22_2 {
	//1. �ʵ�
		private Connection connection; //DB���� ��ü ����
	//2. ������
		public Day22_2 () {

		try { //java �� ����� ������ �Ϲ� ���� �߻�
			
			//1. DB����̺� Ŭ���� ȣ�� [ DB ȸ�� ���� �ٸ��� ������ �ϱ�x]
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. DB ����
			connection = DriverManager.getConnection(
					// jdbc : java database connection ���Ӹ�
					// jdbc:mysql:IP�ּ�(����[����pc]�̸�localhost):port��ȣ/db�̸�?db�ð�����
					// ������, db��й�ȣ,
					
					"jdbc:mysql://localhost:3306/javfx?serverTimezone=UTC",
					"root",
					"1234");
			
			
			//3.Ȯ��
			System.out.println("DB���� ����");
		} catch (Exception e) { System.out.println("DB���� ���� : "+e); }
			}
	
	//3. �޼ҵ�
		public boolean write(String �ۼ���, String ����) {
			
			try {
			//1. sql�ۼ� [db�� ���̺� ������ ����]
				//@"Insert into" //�ܿ��
				//db�� ���̺� ������ ���� : insert into ���̺��1(�ʵ��1, �ʵ��2) values(�ʵ��1�� ��, �ʵ��2�� ��)
			String sql = "Insert into test(writer, content) values(?,?)";
			
			//2. sql ����[����� db��  sql ����]
				//PreparedStatement= ����� db���� ���̺� ����(����, ����, ����, ����)�� �� ���� �������̽�
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, �ۼ���); //sql�� �ۼ��� ù��° ?�� ���� �ֱ� [ 1 : ù��° ?]
			ps.setString(2, ����); //[2: �ι�° ? ]
			
			//3. sql ����
			ps.executeUpdate(); //����
			
			
			//����true
			return true;
			
			
			} catch (Exception e) {
				System.out.println("sql ���� ���� : "+e);
			}
		//���� false
			return false;
			
		}
		
		
		//3. ������ ȣ�� �޼ҵ�
		//��ȯŸ���� arraylist ����� ���� : ������[���ڵ�]�� �������� ���ؼ�.
		
		public ArrayList<������> get(){
			
			//db���� ������ �����͸� ������ ����Ʈ ����
			ArrayList<������> �����͸�� = new ArrayList<>();
			
			
			try {
				//1. sql �ۼ�[������ ȣ��]
				
					// select * (����ʵ�) from ���̺�� : ��� �����͸� ��������
				String sql = "select * from test";
				
				//2. sql ����[db�� �����������̽� ����]
				PreparedStatement ps = connection.prepareStatement(sql);
				
				//3. sql ���� [resultset �������̽� java.sql ��Ű��]
				ResultSet rs = ps.executeQuery(); //�����(���پ�=���ڵ�) ��������
				
				//����� �ϳ��� �ƴϰ� ������ �̹Ƿ� �ݺ��� ����ؼ�
					//���پ�(���ڵ�) ��üȭ �Ͽ� ����Ʈ�� ����
				
					while(rs.next()) { //���� ���� ������ �ϳ��� ������
						
						//1. ���ڵ�[���پ�]
						������ temp = new ������(
						
						rs.getInt(1), //�ش� ��[���ڵ�]�� ù��° �ʵ�[����] ���� �����´�.
						rs.getString(2),
						rs.getString(3));
						
						//2. ��ü�� ����Ʈ�� ����ֱ�
						�����͸��.add(temp);
						
					}
					//�ݺ��� ����Ǹ� ����Ʈ ��ȯ
				
				
				//������ ������ ��� ��ȯ
				return �����͸��;
				}
			catch (Exception e) { System.out.println("sql ���� ���� : " + e);	}
			
			//���н�
			return null;
			
			
			
		}
		
		
		
		
}
