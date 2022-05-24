package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.mysql.cj.xdevapi.JsonArray;

import dao.MemberDao;
import dao.ProductDao;

@WebServlet("/product/getorder") //JSPweb을 생략하고 url 정의
public class getorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getorder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1. 섹션 값을 가져온다.
		String mid = (String)request.getSession().getAttribute("login"); //해당 아이디 값
		//2. 가져온 것을 멤버로 바꾼다.
		int mno = MemberDao.getMemberDao().getmno(mid);
		
		//3. 주문한 오더를 가져오기 위해 회원번호가 필요.
			// 오더를 빼오기 위해 sql로 간다.
		JSONArray jsonArray = ProductDao.getProductDao().getorder(mno);
		
		//언어변경
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
