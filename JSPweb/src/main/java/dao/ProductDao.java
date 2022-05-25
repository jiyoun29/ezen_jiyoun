package dao;

import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;

import dto.Category;
import dto.Product;
import dto.Stock;
import dto.cart;
import dto.porder;

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
		ArrayList<Product> products = new ArrayList<Product>();

		String sql = "select * from product";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product product = new Product
						(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getFloat(4),
						rs.getInt(5), rs.getString(6),
						rs.getInt(7));
				products.add(product);
			}
			return products;
		} catch (Exception e) {System.out.println("오류"+e);}
		
		return null;
	}
	
	//3. 제품 개별 호출[r]
	public Product getproduct(int pno) {
		String sql = "select * from product where pno = "+ pno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Product product = new Product
						(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getFloat(4),
						rs.getInt(5), rs.getString(6),
						rs.getInt(7));
				return product;
			}
		} catch (Exception e) {System.out.println("오류"+e);}
		return null;
	}
	
	//4. 제품 수정[u]
	
	//4-1. 상태 변경
	public boolean activechange( int pactive, int pno) {
		String sql = "update product set pactive = "+pactive+" where pno="+pno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;			
		} catch (Exception e) {System.out.println("오류"+e);}
		
		return false;
	}
	
	//5. 제품 삭제[d]

	
///////////////////////////////////////재고/////////////////////////////////////////////

	//1. 제품의 재고 등록[c]
	public boolean ssvae(Stock stock) {
		try {
			String sql = "insert into stock(scolor, ssize, samount, pno)values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, stock.getScolor());		ps.setString(2, stock.getSsize());
			ps.setInt(3, stock.getSamount());		ps.setInt(4, stock.getPno());
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println("오류"+e);}
		
		return false;}
	
	//2. 제품의 재고 호출
	public ArrayList<Stock> getstock(int pno) {
		ArrayList<Stock> list = new ArrayList<Stock>();
		try {
			String sql = "select * from stock where pno ="+pno;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Stock stock = new Stock(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
				list.add(stock);
			}
			return list;
		} catch (Exception e) {System.out.println("재고호출오류:"+e);}
		
		return null;
	}
	
	//4. 제품의 재고 수정[u]
	public boolean stockupdate(int sno, int samount) {
		String sql = "update stock set samount = "+samount+" where sno="+sno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println("재고수정오류:"+e);}
		return false;
	}
	
	
	//5. 제품의 재고 삭제[d]
	
	
	
	
	
	
/////////////////////찜하기
	public int saveplike(int pno, int mno) {
		
		try {

		//1. 검색 -> 제품번호, 회원번호가 동일하면
		String sql = "select plikeno from plike where pno="+pno+" and mno="+mno;	
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		if(rs.next()) { //2. 존재하면 삭제 처리
			sql = "delete from plike where plikeno = "+rs.getInt(1);
			//방금 검색된, 기존에 있는 것을 삭제 처리한다.
			ps = con.prepareStatement(sql); ps.executeUpdate();
		
			return 2; //삭제
		} else { //3. 존재하지 않으면 등록처리
										// 물음표 대신 바로 값 넣기
			sql = "insert into plike( pno, mno )values( "+pno+","+mno+" )";
			ps = con.prepareStatement(sql); ps.executeUpdate();
			
			return 1; //등록
		}
		//4. 그외 오류

		} catch (Exception e) {System.out.println("오류:"+e); return 3;//db오류	
		
	} }
	

// 해당 제품 찜하기 여부 확인 메소드 
	public boolean getplike(int pno, int mno) {
		String sql = "select * from plike where pno ="+pno+" and mno="+mno;
		
		try { ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) return true;
		} catch (Exception e) {System.out.println("오류:"+e);
	} return false;
}
	
////////////////////////////////장바구니
	
	public boolean savecart(cart cart) {
		
	try {					//누구의 카트인지 알아야하므로 sno 뒤에 넣기
		String sql = "select cartno from cart where sno = "+cart.getSno()+" and mno = "+cart.getMno();
		ps = con.prepareStatement(sql); rs = ps.executeQuery();
		if(rs.next()) { //1. 장바구니 내에 제품이 동일하면 수량 업데이트 처리
			sql = "update cart set samount = samount + "+cart.getSamount()+
					", totalprice = totalprice + " + cart.getTotalprice() +
					" where cartno = " + rs.getInt(1);
				//회원번호와 재고가 동일한 값을 찾아서 장바구니로 가져와 수량을 업데이트 한다.
			ps = con.prepareStatement(sql); ps.executeUpdate(); return true;
			
		} else { //2. 존재하지 않으면 등록
			sql = "insert into cart( samount, totalprice , sno , mno )values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getSamount()); ps.setInt(2, cart.getTotalprice());
			ps.setInt(3, cart.getSno()); ps.setInt(4, cart.getMno());
			ps.executeUpdate(); return true;
			}
		} catch (Exception e) {System.out.println("오류:"+e);
	} return false;	
	}
	
//장바구니 출력 메소드
	public JSONArray getcart(int mno) {
	JSONArray jsonArray = new JSONArray(); //json 배열 선언
	String sql = "select "+
			"A.cartno as 장바구니번호 , "+
		    "A.samount as 구매수량 , "+
		    "A.totalprice as 총가격 , "+
		    "B.scolor as 색상 , "+
		    "B.ssize as 사이즈 , "+
		    "B.pno as 제품번호 , "+
			"C.pname as 제품명 , "+
			"C.pimg as 제품이미지 "+
			"from cart A "+
			"join stock B "+
			"on A.sno = B.sno "+
			"join product C "+
			"on B.pno = C.pno "+
			"where A.mno ="+ mno;

	
		try { ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) { //결과내 하나의 레코드를 -> 하나의 jspn객체 변환
				JSONObject object = new JSONObject();
				object.put("cartno", rs.getInt(1));
				object.put("samount", rs.getInt(2));
				object.put("totalprice", rs.getInt(3));
				object.put("scolor", rs.getString(4));
				object.put("ssize", rs.getString(5));
				object.put("pno", rs.getInt(6));
				object.put( "pname" , rs.getString(7) );
				object.put( "pimg" , rs.getString(8) );
				
				//하나씩 json객체를 json배열에 담기
				jsonArray.put(object);
			} 
			return jsonArray;
		} catch (Exception e) {System.out.println("오류:"+e); } return null;	
	}	
	
	
//장바구니 업데이트
	public boolean updatecart(int cartno , int samount, int totalprice) {
		String sql = "update cart set samount = "+samount+" , totalprice = "+totalprice+" where cartno = "+cartno;
		try { ps = con.prepareStatement(sql); ps.executeUpdate(); return true;			
		} catch (Exception e) {System.out.println("장바구니 업데이트 오류:"+e); 
		return false;
	}
}
	
	
	
//장바구니 삭제
	public boolean deletecart(int cartno) {
		String sql = "delete from cart where cartno="+cartno;
		try { ps = con.prepareStatement(sql); ps.executeUpdate(); return true;			
		} catch (Exception e) {System.out.println("장바구니 삭제 오류:"+e); 
		return false;
	}	
}
	
////////////////////////////////// 주문 /////////////////////////////////
	
	
	public boolean saveorder(porder porder) {
		
		String sql = "insert into porder(ordername,orderphone,orderaddress,"
				+ "ordertotalpay, orderrequest,mno)value(?,?,?,?,?,?)";
		//insert 후에 자동 생성된 pk값 가져오기 ********
		try {  ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
									// sql의 Statement. 기본 키 빼내어오기
			ps.setString(1, porder.getOrdername());
			ps.setString(2, porder.getOrderphone());
			ps.setString(3, porder.getOrderaddress());
			ps.setInt(4, porder.getOrdertotalpay());
			ps.setString(5, porder.getOrderrequest());
			ps.setInt(6, porder.getMno());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys(); //pk값 가져오기
			
			if(rs.next()) {
				System.out.println("방금 생성된 pk값"+rs.getInt(1));
			int pk = rs.getInt(1);	
		//cart -> porderdetail
		sql = "insert into porderdetail( samount , totalprice , orderno , sno )"
				+ "select samount, totalprice,"+pk+", sno from cart where mno = "+porder.getMno();
											//pk뒤에 ',' 놓치지 말기 ********
			ps = con.prepareStatement(sql);
			ps.executeUpdate(); // 끝
			
		//cart -> delete
		sql = "delete from cart where mno ="+porder.getMno();
		ps = con.prepareStatement(sql);
		ps.executeUpdate(); return true; //서블릿으로 가서 마저 적기
		}
	} catch (Exception e) {System.out.println("장바구니 삭제 오류:"+e); }
	return false;
}
	
	

//주문내역 메소드
	public JSONArray getorder(int mno) {
		String sql = "select A.orderno as 주문번호, A.orderdate as 주문일 , "
				+ "B.orderdetailno as 주문상세번호 , B.orderdetailactive as 주문상세상태 , "
				+ "B.samount as 주문상세수량 , C.sno as 재고번호 , C.scolor as 색상 , "
				+ "C.ssize as 사이즈 , D.pno as 제품번호, D.pname as 제품명 , D.pimg as 제품사진 "
				+ "from porder A join porderdetail B on A.orderno = B.orderno "
				+ "join stock C on B.sno = C.sno "
				+ "join product D on C.pno = D.pno where A.mno = "+mno+" order by A.orderno desc;";
		
		try { ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		
			//json 사용하는 이유 -> js로 전송하기 위해서.
			//array 사용하는 이유 -> jsp로 사용하기 위해서
			JSONArray parentlist = new JSONArray(); //상위 리스트[여러개의 하위 리스트]
				//어레이리스트 하나 더 생성 (그룹 짓기 위해서)
				JSONArray childlist = new JSONArray();
				
				int oldorderno = -1; //이전 데이터의 주문번호 임시저장 변수
		
			//우선 다 빼오기
			while(rs.next()) {
				
				//동일한 주문번호끼리 묶음처리
				// { 키 : 값 } <-json의 형태
				// { "orderno" : [ 키 : 값 , 키 : 값 ] , "orderno" : [ 키 : 값 , 키 : 값 ] };	
					// 주문번호 따라 가능

			//데이터 json 객체	
				//while문을 돌려서 오브젝트를 하나 생성
				JSONObject jsonObject = new JSONObject();				
				
				//오브젝트에 key값을 하나씩 넣어준다.
				jsonObject.put( "orderno" , rs.getInt(1));
				jsonObject.put( "orderdate" , rs.getString(2));
				jsonObject.put( "orderdetailno" , rs.getInt(3));
				jsonObject.put( "orderdetailactive" , rs.getInt(4));
				jsonObject.put( "samount" , rs.getInt(5));
				jsonObject.put( "sno" , rs.getInt(6));
				jsonObject.put( "scolor" , rs.getString(7));
				jsonObject.put( "ssize" , rs.getString(8));
				jsonObject.put( "pno" , rs.getInt(9));
				jsonObject.put( "pname" , rs.getString(10));
				jsonObject.put( "pimg" , rs.getString(11));
				// 이렇게 사용시, 따로 dto가 필요하지 않다.
				
				//동일한 주문번호이면 동일한 리스트에 담기
				//{키 : 값}
				//{키:[], 키:[], 키:[]}				
				
				if(oldorderno == rs.getInt(1)) {
					//이전 주문번호와 현재 주문번호가 동일하면 하위리스트를 초기화x
					childlist.put(jsonObject);// 하위리스트에 데이터 담기
				} else { //동일하지 않으면
					childlist = new JSONArray(); // 하위 리스트 초기화
					childlist.put(jsonObject); //하위 리스트에 데이터 담기
					parentlist.put(childlist); //상위 리스트에 하위 리스트 추가
				}			
				oldorderno = rs.getInt(1); //이전 주문번호 변수에 현재 주문번호 넣기
				
				//담은 것을 jsonarray에 담아준다.
				// jsonArray.put(jsonObject);
			} return parentlist;	
		} catch (Exception e) {System.out.println("주문내역 오류:"+e); }
		return null;
	}
	

	//주문취소
	public boolean cancleorder(int orderdetailno , int active) {
		try { String sql = "update porderdetail set orderdetailactive = "+active
				+" where orderdetailno = " +orderdetailno;
			ps = con.prepareStatement(sql); ps.executeUpdate(); return true;
		} catch (Exception e) { System.out.println("취소:"+e); }
		return false;
	}
	
	
///////////////////////////////////////////////////////////////////
	
	public JSONArray getchart( int type ) {
		String sql = "";
		JSONArray ja = new JSONArray();
		
		if( type == 1) { //일별 매출
			sql = "select substring_index( orderdate , ' ' , 1 ) as 날짜 , "
					+ " sum( ordertotalpay ) from porder "
					+ " group by 날짜 order by 날짜 desc ";
		} else  if (type == 2) { //카테고리별 전체 판매량
			sql = "select sum(A.samount) ,"
			+ "	D.caname "
			+ "	from porderdetail A, stock B, product C, category D "
			+ " where A.sno = B.sno and B.pno = C.pno and C.cano = D.cano "
			+ "	group by D.caname order by orderdetailno desc ";
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				JSONObject jo = new JSONObject();
				if( type == 1 ) {
					jo.put("date", rs.getString( 1 ) );
					jo.put("value", rs.getInt(2) );
					ja.put(jo);
				}else if( type == 2 ) {
					jo.put("value", rs.getString( 1 ) );
					jo.put("category", rs.getString(2) );
					ja.put(jo);
				}
			}
			return ja;
		} catch (Exception e) { System.out.println("겟차트오류:"+e); }
	return null; // 오류발생,,
}






//////////////////////////////////
}
