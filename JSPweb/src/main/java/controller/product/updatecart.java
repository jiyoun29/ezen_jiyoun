package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.ProductDao;

@WebServlet("/product/updatecart")
public class updatecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updatecart() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getParameter("json"); //json 변수 요청
		try {
			JSONArray jsonArray = new JSONArray(json); //json 배열로 형변환 
			for(int i = 0 ; i<jsonArray.length() ; i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i); //json배열내 json객체를 하나씩 호출
				int cartno = Integer.parseInt(jsonObject.get("cartno").toString()); //객체내 key를 이용한 value 호출
				int samount = Integer.parseInt(jsonObject.get("samount").toString());
				int totalprice = Integer.parseInt(jsonObject.get("totalprice").toString());
				ProductDao.getProductDao().updatecart(cartno, samount , totalprice); //dao를 이용한 수량/금액 업데이트 처리
			}
		} catch(Exception e) {System.out.println("오류:"+e); }
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
