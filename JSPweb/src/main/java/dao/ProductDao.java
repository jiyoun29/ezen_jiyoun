package dao;

import java.util.ArrayList;

import dto.Category;
import dto.Product;
import dto.Stock;

public class ProductDao extends Dao {
	
	public ProductDao() {
		super(); //상송 받을 부모클래스 생성자 호출(db연결에 필요)
	}
	
	//외부클래스에서 접근할 수 있도록 객체 생성
	private static ProductDao productDao = new ProductDao();
	public static ProductDao getProductDao() { return productDao; }
	

///////////////////////////////////////카테고리/////////////////////////////////////////////
	//1. 카테고리 등록[c]
	public boolean csave(String caname) {
		String sql = "insert into category(caname)values('"+caname+"')";
		
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println("오류"+e);}
	
	return false;}
	
	//2. 카테고리 호출[r]
	public ArrayList<Category> getcategorylist(){
		ArrayList<Category> list = new ArrayList<Category>();
		
		//전부 빼오기
		String sql = "select * from category";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				//1개 호출시 if. 여러개 호출시 while
			
			while(rs.next()) {
				Category category = new Category(rs.getInt(1), rs.getString(2));
				list.add(category);
			}
			return list;
		} catch (Exception e) {System.out.println("오류"+e);}
		
		return null;
	}

	
	//3. 카테고리 수정[u]
	
	
	//4. 카테고리 삭제[d]

	
	//메소드는 반환타입에 따른 return 값 설정
		//반환타입이 객체당 클래스이면 null, 기본 자료형이면 true-false, 0.
	
///////////////////////////////////////제품/////////////////////////////////////////////
	//1. 제품 등록[c]
	public boolean psave(Product product) {
	
		String sql = "insert into product(pname, pprice, pdiscount, pimg, cano)values(?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname()); ps.setInt(2, product.getPprice());
			ps.setFloat(3, product.getPdiscount()); ps.setString(4, product.getPimg());
			ps.setInt(5, product.getCano());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println("오류"+e);}

		return false;
	}	
	
	
	//2. 제품 모든 호출
	public ArrayList<Product> getproductlist(){
		
		return null;
	}
	
	//3. 제품 개별 호출[r]
	public Product getproduct() {
		return null;
	}
	
	//4. 제품 수정[u]
	//5. 제품 삭제[d]

	
///////////////////////////////////////재고/////////////////////////////////////////////

	//1. 제품의 재고 등록[c]
	public boolean ssvae() {return false;}
	
	//2. 제품의 재고 호출
	public Stock getstock() {
		return null;
	}
	
	//4. 제품의 재고 수정[u]
	//5. 제품의 재고 삭제[d]
	
	
	
}