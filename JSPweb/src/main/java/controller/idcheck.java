package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

/**
 * Servlet implementation class idcheck
 */
@WebServlet("/idcheck")
public class idcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public idcheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		
		//1. dao와 통신해서 해당 id가 있는지 체크(직접해...)
		boolean result = MemberDao.getMemberDao().idcheck(mid);
		
		// 요청할때 request 응답할때 response
		// ajax에게 데이터 보내기 (print:반환)		
		if(result) { //2. 만약에 해당 아이디가 존재하면 1 존재하지 않으면 2
			response.getWriter().print(1); //성공시 1			
		} else { response.getWriter().print(2); //실패시 2
		}
		

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
