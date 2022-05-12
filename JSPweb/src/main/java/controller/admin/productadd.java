package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDao;
import dto.Product;

@WebServlet("/admin/productadd")
public class productadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public productadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//방법 2가지 1. 프로젝트폴더(개발자pc) 저장 //2. 서버(톰캣) 폴더에 저장
		MultipartRequest multi = new MultipartRequest(
			request, //요청타입
			request.getSession().getServletContext().getRealPath("/admin/productimg"),
							//getServletInfo() , //저장 폴더 위치
			1024*1024*1024 ,  //파일 최대용량
			"UTF-8" , //파일 인코딩 타입
			new DefaultFileRenamePolicy() //보안 방식
			//DefaultFileRenamePolicy : 파일명이 중복이면 파일명 뒤에 숫자 자동 부여 = 식별
			);
		

		
		String pname = multi.getParameter("pname");

		int pprice = Integer.parseInt(multi.getParameter("pprice"));
		float pdiscount = Float.parseFloat( multi.getParameter("pdiscount")) ;
		int cno = Integer.parseInt(multi.getParameter("cano"));
		String pimg = multi.getFilesystemName("pimg"); //첨부파일 파일명은 요청시 .getFilesystemName에 저장
		

		Product product = new Product(0, pname, pprice, pdiscount, 0, pimg, cno);
//		Product product = new Product(0, pname, pprice, pdiscount, 0, pimg, cano);
		
		
		boolean result = ProductDao.getProductDao().psave(product);
		
		if(result) {response.getWriter().print(1);} //성공 2명 실패
		else  {response.getWriter().print(2);}
	}


}
