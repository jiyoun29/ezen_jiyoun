package controller.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.board;

/**
 * Servlet implementation class deleteboard
 */
@WebServlet("/board/deleteboard")
public class deleteboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
//		System.out.println("요청:"+bno);

		//db삭제 전에 파일명 가져오기
		//bfile 가져오기
		board board = BoardDao.getBoardDao().getboard(bno);
		String bfile = board.getBfile();
		//bno를 넘겨서 bfile 가져옴
		
		boolean result = BoardDao.getBoardDao().delete(bno);
		
		response.setCharacterEncoding("UTF-8"); //응답 인코딩 타입 = 한글
		response.setContentType("text/html; charset=UTF-8"); //응답 파일타입 = html 설정
		PrintWriter out = response.getWriter();
		if(result) {
			
		//*삭제 성공시 해당 파일도 서버에서 삭제처리
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload/"+bfile);
		File file = new File(uploadpath); //해당 파일 객체화
		file.delete(); //파일 삭제하기
			
			
			////////////
			
			//java에서 html 작성하기(js명령어) 사용하기
		
			//1.html 내보내기
//			out.println("<html>");
//			out.println("<boady>");
//			out.println("</boady>");
//			out.println("</html>");
			
			//2.js 내보내기
			out.println("<script>");
			out.println("alert('게시물이 삭제 되었습니다.')");
			out.println("location.href='boardlist.jsp'"); //js에서 하이퍼링크
			out.println("</script>");
			
		} else {
			out.println("<script>");
			out.println("alert('삭제 실패[관리자에게 문의]')");
			out.println("history.back();"); //이전페이지로가기
			out.println("</script>");			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
