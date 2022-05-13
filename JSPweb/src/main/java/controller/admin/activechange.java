package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

/**
 * Servlet implementation class activechange
 */
@WebServlet("/admin/activechange")
public class activechange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public activechange() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("확인");
		//변수요청
		int pactive = Integer.parseInt(request.getParameter("active"));
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		//db처리
		boolean result = ProductDao.getProductDao().activechange(pactive, pno);
		
		if(result) {response.getWriter().print(1);}
		else {response.getWriter().print(2);}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
