package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.chatDao;


/**
 * Servlet implementation class write
 */
@WebServlet("/chat") //url 지정 = 현재 클래스와 통신할 경로
public class chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public chat() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cname = request.getParameter("cname");
		String ccontent = request.getParameter("ccontent");
//		int cnum = Integer.parseInt(request.getParameter("cnum"));
		
		//객체화
		dto.chat chat = new dto.chat(cname, ccontent, 0); 
		
		//db처리
		boolean result = chatDao.getChatDao().chatwrite(chat);
						
		//결과
		if(result) { response.getWriter().print(1); }
		else {response.getWriter().print(2);} //센드 실패
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);	}

}
