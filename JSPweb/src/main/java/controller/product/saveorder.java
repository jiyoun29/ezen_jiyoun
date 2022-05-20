package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

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
		
		//1. 주문 db처리 [pk
		
		//2. 주문 상세 db처리 [cart -> ordertail
		
		//3. 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
