package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;


@WebServlet("/product/deletecart")
public class deletecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deletecart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartno = Integer.parseInt(request.getParameter("cartno"));
		boolean dc = ProductDao.getProductDao().deletecart(cartno);
		response.getWriter().print(dc);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
