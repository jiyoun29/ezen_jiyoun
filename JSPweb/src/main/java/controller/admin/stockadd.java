package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;


@WebServlet("/admin/stockadd")
public class stockadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public stockadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //응답 인코딩 타입
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		String scolor = request.getParameter("scolor");
		String ssize = request.getParameter("ssize");
		int samount = Integer.parseInt(request.getParameter("samount"));
		
		Stock stock = new Stock(0, scolor, ssize, samount, null, null, pno);
		
		boolean result = ProductDao.getProductDao().ssvae(stock);
		
		if(result) { response.getWriter().print(1);
		} else { response.getWriter().print(2);}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
