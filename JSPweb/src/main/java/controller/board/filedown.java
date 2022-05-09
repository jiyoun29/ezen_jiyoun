package controller.board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class filedown
 */
@WebServlet("/board/filedown")
public class filedown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public filedown() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //요청시 한글 인코딩타입
		//리퀘스트는 전송시 한글변환x
		
		//다운로드 받을 변수 요청
		String bfile = request.getParameter("bfile"); //파일명 먼저 꺼내오기
//확인용		System.out.println("다운로드 파일명 : " +bfile); 
		
		//서버에서 해당 파일 찾기
		//서버 내경로 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload/"+bfile);
		
		//3.파일 객체화
		File file = new File(uploadpath);
		
		//4. 다운로드 형식[브라우저마다 다름]
		response.setHeader("Content-Disposition", //다운로드형식 html	
				"attachment;filename="+URLEncoder.encode(bfile, "UTF-8"));
					//다운로드 화면에서 표시할 파일명 //한글파일명
				//URLEncoder.encode : url내 한글 인코딩 타입
		
		
		//5. 바이트 형식으로 내보내기(통신)
			//입력스트림[서버가 ps에 있는 파일을 스트림으로 가져옴]
		BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
			//1. 바이트배열 선언 //파일크기를 구할 수 있는데 int로 형변환 해줌
		byte[] bytes = new byte[(int)file.length()]; //파일 길이(크기=용량)만큼 배열 선언
			//2. 바이트 읽어오기
		fin.read(bytes);
			//출력스트림[서버가 가져온 pc내 파일을 내보내기 단계]
		BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
												// 내보내기 위해 response를 가져와서 씀
		fout.write(bytes);
		
			//스트림 닫기(용량, 기록 제거
		fin.close();
		fout.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
