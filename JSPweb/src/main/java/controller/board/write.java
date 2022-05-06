package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDao;
import dao.MemberDao;
import dto.board;

/**
 * Servlet implementation class write
 */
@WebServlet("/board/write") //url 지정 = 현재 클래스와 통신할 경로
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public write() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//저장경로. 제어문자 \ -> \\,/ 로 변경 
		
		//1. 개발 죽인 프로젝트 경로
//		String uploadpath = "C:/Users/504/git/ezen_jiyoun/JSPweb/src/main/webapp/board/upload";
			//첨부파일을 webapp-board-upload에 업로드를 할 것
			//절대 경로 복사해와서 넣기
		//2.서버 폴더 경로
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload");
															//파일명을 넣으면 진행 가능
//		System.out.println("서버의 경로 찾기 : "+ request.getSession().getServletContext().getRealPath("/board/upload"));

		
		
		//첨부파일 업로드 [MultipartRequest : cos 라이브러리 제공 클래스]
		MultipartRequest multi = new MultipartRequest
				(request, uploadpath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
				//요청 방식, 파일 저장 경로, 파일 최대 용량 허용 범위, 인코딩 타입, 동일한 파일명이 있을 경우 자동 이름 변환(보안방식)
										//10메가
		//데이터 요청
//		request.setCharacterEncoding("UTF-8");
		//리퀘스트 안 씀

		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile"); //첨부파일:getfilesystemName
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("login"); //로깅에 있는 걸 빼오기
		
		int mno = MemberDao.getMemberDao().getmno(mid); 

		//객체화
		board board = new board(0, btitle, bcontent, mno, 0, null, bfile, null);
				
				//new board(0, btitle, bcontent, mno, bfile, 0, null, null);
//		System.out.println(board.toString());
		
		//db처리
		boolean result = BoardDao.getBoardDao().write(board);
		
		//결과
		if(result) {response.sendRedirect("/JSPweb/board/boardlist.jsp");}
		else {response.sendRedirect("/JSPweb/board/boardwrite.jsp");} //센드 실패
	}

}
