package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.mysql.cj.xdevapi.JsonArray;

import dao.ProductDao;


@WebServlet("/admin/getchart")
public class getchart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getchart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt(request.getParameter("type"));

		int value = 0;
		//가져왔는데 없을 경우(선언만 하는거)
		if(request.getParameter("value") != null ) {
			value = Integer.parseInt(request.getParameter("value"));
		}
		
		JSONArray jsonArray = ProductDao.getProductDao().getchart( type , value );
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
