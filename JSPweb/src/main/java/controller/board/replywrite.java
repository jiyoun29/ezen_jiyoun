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


@WebServlet("/board/replywrite")
public class replywrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public replywrite() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int bno = Integer.parseInt(request.getParameter("bno"));
		String rcontent = request.getParameter("rcontent");
			String mid = (String)request.getSession().getAttribute("login");
		
		int mno = MemberDao.getMemberDao().getmno(mid);

		//rindex는 0 할 것이므로 객체화
		Reply reply = new Reply(0, rcontent, null, 0, bno, mno, null);
	
		//db처리
		boolean result = BoardDao.getBoardDao().replywrite(reply);
		
		if(result) { //만약에 실패
			response.getWriter().print(1);
		} else { response.getWriter().print(2); }
		
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
