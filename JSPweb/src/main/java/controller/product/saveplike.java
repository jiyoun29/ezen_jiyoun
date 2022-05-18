package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.ProductDao;


@WebServlet("/product/saveplike")
public class saveplike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public saveplike() {
        super();
        // TODO Auto-generated constructor stub
    }

    //productdao와 js 사이의 통신을 해준다.,
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno")); //제품번호 요청
		String mid = request.getParameter("mid"); //회원 아이디 요청
		//값을 받아온다.
		
		//db처리
		int result =					//이미 만들어둬서 가져오기 가능
		ProductDao.getProductDao().saveplike(pno, MemberDao.getMemberDao().getmno(mid));
		
		//db결과를 js로 전달
		if(result == 1) { response.getWriter().print(result);
		} else if (result == 2) {
			response.getWriter().print(result);
		} else if (result == 3) {
			response.getWriter().print(result);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
