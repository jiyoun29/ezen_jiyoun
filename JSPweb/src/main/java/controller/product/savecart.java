package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.MemberDao;
import dao.ProductDao;
import dto.Stock;
import dto.cart;


@WebServlet("/product/savecart")
public class savecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public savecart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pno = Integer.parseInt(request.getParameter("pno"));
		//추가


		//json형식 문자열 통신 호출
		String data = request.getParameter("json");
		System.out.println(data);
		
		
		
		//json형식 문자열 -> json 객체로 변환
		//예외처리 무조건 발생
		try { //1. 통신한 데이터를 JSONArray형(배열)으로 형변환
			JSONArray jsonArray = new JSONArray(data);
			//[{0},{1},{2},{3}~~] ->문자열 JSONArray

			//쓰려고 빼옴()
			int error = -1; //-1 : 인덱스가 없다		
			int i = 0;
			//1개라도 error값이 있으면 error변수에 true를 넣음
	//		if(re == false) error = i;

			
			
			//2. 반복문 이용한 jsonArray에서 JSONobject를 호출
			for(i = 0; i<jsonArray.length(); i++) {
		
				//1바퀴 돌면서
				//3. jsonArray 배열 내 i번째 객체 호출
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				//4. 해당 객체에 키를 이용한 값 호출
				System.out.println(jsonObject.get("pname"));
				System.out.println(jsonObject.get("color"));
				System.out.println(jsonObject.get("size"));
				System.out.println(jsonObject.get("amount"));
				System.out.println(jsonObject.get("pprice"));
				System.out.println(jsonObject.get("totalprice"));
				System.out.println(jsonObject.get("point"));
				//장바구니 객체에 담아 넘겨야 한다.(dto에 담아 db처리)
				
				//5. 현재js는 dto로 변환을 시켜 객체 생성
					//섹션에 존재하는 mno를 빼오기(로그인된 아이디 빼오기)
				String mid = (String)request.getSession().getAttribute("login");
				int mno = MemberDao.getMemberDao().getmno(mid);
				
				int amount = Integer.parseInt(jsonObject.get("amount").toString());
					//get메소드는 제이슨 객체.get(키)를 넣으면 반환타입이 오브젝트이다.
				//to String으로 스트링값으로 받은 다음, 다시 int 값으로 바꾼다.
				int totalprice = Integer.parseInt(jsonObject.get("totalprice").toString());
					//sno
					//두가지를 받아서 형변환
					String color = jsonObject.get("color").toString();
					String size = jsonObject.get("size").toString();

					
				int sno = 0;
				ArrayList<Stock> list = ProductDao.getProductDao().getstock(pno);
					//pno값을 가져와서 리스트의 사이즈를 돌려서
					for(Stock s : list) {//동일한 걸 꺼내옴
						if(s.getSsize().equals(size) && s.getScolor().equals(color)) {
							sno = s.getSno();
						} 
					}
					
				cart cart = new cart(0, amount, totalprice, sno, mno);
				System.out.println("json -> dto: "+ cart.toString()); //테스트 확인
				
			//json을 받아서 dto로 만든 것
				
				//dao 작업 후 넘어옴
	//			boolean re = ProductDao.getProductDao().savecart(cart);
			//	if(re) { System.out.println("db저장 성공");}
			//	else {System.out.println("");}
					//스위치 생성
			//	boolean error = false; //여러개 db처리 중 오류 여부 저장
				
				boolean re = ProductDao.getProductDao().savecart(cart); //db처리
				if( re == false ) error = i ;	//만일 하나라도 오류가 발생하면 eroor변수에 true;
				
			} //jsonarray 끝
			if(error == -1) response.getWriter().print(-1); //오류가 없으면 -1 전송
			else {response.getWriter().print(i);} //만약에 오류가 있으면 i번째 인덱스 전송
			
		} catch (Exception e) { System.out.println(e);}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
