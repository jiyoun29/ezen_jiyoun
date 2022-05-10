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

/**
 * Servlet implementation class rereplywrite
 */
@WebServlet("/board/rereplywrite")
public class rereplywrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

   public rereplywrite() {
        super();

   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int rindex = Integer.parseInt(request.getParameter("rno"));
		//rindex : 어떤 댓글의 댓글인지 식별번호(상위/부모 댓글 번호)
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		String rcontent = request.getParameter("rrcontent");
			String mid = (String)request.getSession().getAttribute("login");
		int mno = MemberDao.getMemberDao().getmno(mid);
		
		//객체화(댓글번호, 작성일, mid 제외)
		Reply reply = new Reply(0, rcontent, null, rindex, bno, mno, null);
		//db처리
		boolean result = BoardDao.getBoardDao().replywrite(reply);
		if(result) { response.getWriter().print(1);
		} else { response.getWriter().print(2); }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
