package Dao;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dto.Product;

public class ProductDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	//������ ������ dao�� ���� ��
	
	//new �ݺ����̱� ���� �׷� �̸� ��������
	public static ProductDao productDao = new ProductDao();
	
	public ProductDao() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
		"root", "1234"); 

		} catch (Exception e) {} }
		
		//dao ���� ��
		
		
		
		//1. ��ǰ���
		public boolean add(Product product) {
			try {
			String sql = "insert into product(pname,pimg,pcontent,pcategory,pprice,pactivation,mnum)values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setString(2, product.getPimg());
			ps.setString(3, product.getPcontent());
			ps.setString(4, product.getPcategory());
			ps.setInt(5, product.getPprice());
			ps.setInt(6, product.getPactivation());
			ps.setInt(7, product.getNum());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("sql ����:"+e); }
		return false;}
		
		
		//2. ��� ��ǰ ���								//��ġ�� ����
		public ArrayList<Product> list( String category, String search ){ //control�� list���� �̵�
									// ��ȣ �ȿ� ��Ʈ�� ī�װ� �־���
			
			ArrayList<Product> productlist = new ArrayList<>();
			
			try {
				//search �ְ� �ٽ� �ڵ� �߰�
				String sql = null;
				
				if(search == null) { sql = "select * from product where pcategory =? order by pnum desc"; //sql �ۼ�
				ps = con.prepareStatement(sql);		//sql ����			//������ �� @order by
				ps.setString(1, category);
				
				} //�˻��� ���� ���
				//�˻��� ���� ���										//�̸��� ������
				else {sql = "select * from product where pcategory =? and pname like '%"+search+"%' order by pnum desc"; //sql �ۼ�
				ps = con.prepareStatement(sql);		//sql ����							//������ �� @order by
																		//like : 
																	//�ʵ�� = �� [=�񱳿�����] //�ʵ�� like '%��%'[ ���� ���Ե� ]
																						//�յ� ����ǥ �ʼ�
				ps.setString(1, category);
					// ps.setString(2, search);
					}
				
				rs = ps.executeQuery();				//sql ����
				
				while(rs.next()) { 					//sql���[���ڵ� ����]
					Product product = new Product	//�ش� ���ڵ� ��üȭ
					(rs.getInt(1),	rs.getString(2), 
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
					productlist.add(product);
				}
				return productlist;
				
			} catch (Exception e) {System.out.println("sql ����:"+e); }
			return null;
		}
		
		
		//3. ��ǰ ��ȸ
		
		
		//4. ��ǰ ����
		
		public boolean delete(int pnum) {
			
			try {
				String sql = "delete from product where pnum=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, pnum);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {System.out.println("sql ����:"+e); }
			return false;
		}
		
		
		
		
		
		//5. ��ǰ ����
		
		public boolean update(Product product) {
			
			
			try {
				String sql = "update product set pname=?, pimg=?, pcontent=?, pcategory=?, pprice=? where pnum=?";
				ps = con.prepareStatement(sql);
				ps.setString(1,	product.getPname());
				ps.setString(2,	product.getPimg());
				ps.setString(3,	product.getPcontent());
				ps.setString(4,	product.getPcategory());
				ps.setInt(5,	product.getPprice());
				ps.setInt(6,	product.getPnum());
				ps.executeQuery();
				
			} catch (Exception e) {System.out.println("sql ����:"+e); }
			
			return false;
		}
		
		
		
		
		
		//6. ���º���
		public boolean activation(int pnum ) {

			try {
				//���� ���� �˾ƺ��� select. ���� ��ǰ�� ���� �˻�
				String sql = "select pactivation form poduct where pnum=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, pnum);
				
				rs = ps.executeQuery();
				
				//����� next�ؿ�
				if(rs.next()) {
						String upsql = null;
					if(rs.getInt(1) == 1) { upsql = "update product set pactivation=2 where pnum=?"; }
					//���� ������ ���°� 1�̸� 2�� ������Ʈ�� �ϰڴٴ� ��
					
					else if(rs.getInt(2) == 2) { upsql = "update product set pactivation=3 where pnum=?"; }
					else if(rs.getInt(3) == 3) { upsql = "update product set pactivation=1 where pnum=?"; }
				
				//���� �ٽ�
				ps = con.prepareStatement(upsql);
				ps.setInt(1, pnum);
				ps.executeQuery();
				return true;				
				}
				
			} catch (Exception e) {System.out.println("sql ����:"+e); }
			
			
			return false;
		}
		
		
		
		
		
	

}
