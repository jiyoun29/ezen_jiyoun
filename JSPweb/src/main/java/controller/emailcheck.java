package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.member;


@WebServlet("/emailcheck")
public class emailcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public emailcheck() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		
		boolean result = MemberDao.getMemberDao().emailcheck(email);
		
		if(result) {response.getWriter().print(1);}
		else {response.getWriter().print(2);}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		
		doGet(request, response);
	}

}
