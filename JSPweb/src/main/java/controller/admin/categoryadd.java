package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDao;
import dto.Product;

@WebServlet("/admin/categoryadd")
public class categoryadd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public categoryadd() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String caname = request.getParameter("caname");

		boolean result = ProductDao.getProductDao().csave(caname);
		if(result) {response.getWriter().print(1);}
		else {response.getWriter().print(2);}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
}
