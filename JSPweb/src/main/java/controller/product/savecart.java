package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;


@WebServlet("/product/savecart")
public class savecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public savecart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//json형식 문자열 통신 호출
		String data = request.getParameter("json");
		System.out.println(data);
		
		//json형식 문자열 -> json 객체로 변환
		//예외처리 무조건 발생
		try { //1. 통신한 데이터를 JSONArray형(배열)으로 형변환
			JSONArray jsonArray = new JSONArray(data);
			//2. 반복문 이용한 jsonArray에서 JSONobject를 호출
			for(int i = 0; i<jsonArray.length(); i++) {
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
			}
		} catch (Exception e) {}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
