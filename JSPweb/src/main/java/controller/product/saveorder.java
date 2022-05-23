package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;
import dao.ProductDao;
import dto.porder;

@WebServlet("/product/saveorder")
public class saveorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public saveorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String mid = (String) request.getSession().getAttribute("login");
		int mno = MemberDao.getMemberDao().getmno(mid);
		
		//js에서 가져옴
		String json = request.getParameter("orderjson");
		
		try {
			JSONObject jo = new JSONObject(json); //new 생성자 넣기
			
			//json이나 string 중 선택해서 넘김(orderpay.js의 saveorder와 연계)
			String ordername = jo.getString("ordername"); //방법1
			String orderphone = jo.get("orderphone").toString(); //방법2
			String orderaddress = jo.getString("orderaddress");
			int ordertotalpay = jo.getInt("ordertotalpay");
			String orderrequest = jo.getString("orderrequest");
			//key value값을 가져온다음
			//dto 가져오기
			porder porder = new porder(0, null, ordername, orderphone, orderaddress,
					ordertotalpay, 0, orderrequest, 0, mno);
			
			System.out.println(porder.toString());
			
			//1. 주문 db처리 [pk
			boolean result = ProductDao.getProductDao().saveorder(porder);
			//dao에서 작업 완료

			//[cart -> ordertail
			
			//2. 
			response.getWriter().print(result);
			
			//3. 

		
		} catch (Exception e) {}		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
