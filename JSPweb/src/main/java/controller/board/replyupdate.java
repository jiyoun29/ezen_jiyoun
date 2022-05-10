package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.MemberDao;
import dto.Reply;


@WebServlet("/board/replyupdate")
public class replyupdate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public replyupdate() {
        super();   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		System.out.println("sadasdas");
		int rindex = Integer.parseInt(request.getParameter("rno")); //수정 식별 대상
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("sad444444");
		
		String rcontent = request.getParameter("rcontent");
			String mid = (String)request.getSession().getAttribute("login");
		int mno = MemberDao.getMemberDao().getmno(mid);	
		System.out.println("sad234234s");
			
		Reply reply = new Reply(0, rcontent, null, rindex, bno, mno, null);
		System.out.println("sad77777s");
		
		//db처리
		boolean result = BoardDao.getBoardDao().replyupdate(reply);
		if(result) {response.getWriter().print(1);}
		else {response.getWriter().print(2);}
		
		
	
	}
}
