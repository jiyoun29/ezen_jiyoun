package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

@WebServlet("/product/updateorderdetail")
public class updateorderdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updateorderdetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int active = Integer.parseInt(request.getParameter("active"));
		int orderdetailno = Integer.parseInt(request.getParameter("orderdetailno"));

		//db처리
		if( ProductDao.getProductDao().cancleorder(orderdetailno, active) ) {
			response.getWriter().print(1);
		} else { response.getWriter().print(2); }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
