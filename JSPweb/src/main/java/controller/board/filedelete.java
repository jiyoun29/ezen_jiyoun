package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

/**
 * Servlet implementation class filedelete
 */
@WebServlet("/filedelete")
public class filedelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filedelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 삭제할 파일이 있는 게시물 번호 요청
		int bno = Integer.parseInt(request.getParameter("bno"));
		String bfile = BoardDao.getBoardDao().getboard(bno).getBfile(); //기존파일명 임시저장
		//2. [db변경]해당 게시물 번호의 첨부파일의 필드 null 변경
		boolean result = BoardDao.getBoardDao().filedelete(bno);
		//3. [파일삭제]서버내 첨부파일은 삭제
		if(result) {
			String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload/"+bfile);
			File file = new File(uploadpath);
			file.delete();
			
			//js에게 응답하기
			response.getWriter().print("1");// 성공시 1 js에게 응답하기
		} else { response.getWriter().print("2"); } // 실패시 2 js에게 응답하기
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
