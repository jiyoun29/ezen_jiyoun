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
	//이전에 진행한 dao와 같은 거
	
	//new 반복적이기 조금 그럼 미리 만들어놓기
	public static ProductDao productDao = new ProductDao();
	
	public ProductDao() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
		"root", "1234"); 

		} catch (Exception e) {} }
		
		//dao 연동 완
		
		
		
		//1. 제품등록
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
		} catch (Exception e) {System.out.println("sql 오류:"+e); }
		return false;}
		
		
		//2. 모든 제품 출력								//서치도 받음
		public ArrayList<Product> list( String category, String search ){ //control의 list에서 이동
									// 괄호 안에 스트링 카테고리 넣어줌
			
			ArrayList<Product> productlist = new ArrayList<>();
			
			try {
				//search 넣고 다시 코드 추가
				String sql = null;
				
				if(search == null) { sql = "select * from product where pcategory =? order by pnum desc"; //sql 작성
				ps = con.prepareStatement(sql);		//sql 연결			//정렬이 뒤 @order by
				ps.setString(1, category);
				
				} //검색이 없을 경우
				//검색이 있을 경우										//이름이 같으면
				else {sql = "select * from product where pcategory =? and pname like '%"+search+"%' order by pnum desc"; //sql 작성
				ps = con.prepareStatement(sql);		//sql 연결							//정렬이 뒤 @order by
																		//like : 
																	//필드명 = 값 [=비교연산자] //필드명 like '%값%'[ 값이 포함됨 ]
																						//앞뒤 따옴표 필수
				ps.setString(1, category);
					// ps.setString(2, search);
					}
				
				rs = ps.executeQuery();				//sql 실행
				
				while(rs.next()) { 					//sql결과[레코드 단위]
					Product product = new Product	//해당 레코드 객체화
					(rs.getInt(1),	rs.getString(2), 
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
					productlist.add(product);
				}
				return productlist;
				
			} catch (Exception e) {System.out.println("sql 오류:"+e); }
			return null;
		}
		
		
		//3. 제품 조회
		
		
		//4. 제품 삭제
		
		public boolean delete(int pnum) {
			
			try {
				String sql = "delete from product where pnum=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, pnum);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {System.out.println("sql 오류:"+e); }
			return false;
		}
		
		
		
		
		
		//5. 제품 수정
		
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
				
			} catch (Exception e) {System.out.println("sql 오류:"+e); }
			
			return false;
		}
		
		
		
		
		
		//6. 상태변경
		public boolean activation(int pnum ) {

			try {
				//현재 상태 알아보는 select. 현재 제품의 상태 검색
				String sql = "select pactivation form poduct where pnum=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, pnum);
				
				rs = ps.executeQuery();
				
				//결과를 next해옴
				if(rs.next()) {
						String upsql = null;
					if(rs.getInt(1) == 1) { upsql = "update product set pactivation=2 where pnum=?"; }
					//내가 선택한 상태가 1이면 2로 업데이트를 하겠다는 뜻
					
					else if(rs.getInt(2) == 2) { upsql = "update product set pactivation=3 where pnum=?"; }
					else if(rs.getInt(3) == 3) { upsql = "update product set pactivation=1 where pnum=?"; }
				
				//연결 다시
				ps = con.prepareStatement(upsql);
				ps.setInt(1, pnum);
				ps.executeQuery();
				return true;				
				}
				
			} catch (Exception e) {System.out.println("sql 오류:"+e); }
			
			
			return false;
		}
		
		
		
		
		
	

}
