package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Product;

@WebServlet("/admin/getproduct")
public class getproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public getproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//변수 요청
		String type = request.getParameter("type");
		int cano = Integer.parseInt(request.getParameter("cano"));

		//응답 객체 설정
		response.setCharacterEncoding("UTF-8"); //응답시 인코딩 타입
		PrintWriter out = response.getWriter();
		
		//db처리(이미 있는거 꺼내옴)
		ArrayList<Product> list = ProductDao.getProductDao().getproductlist();
		String html = ""; //반환된 html 변수 선언
		
		//반환 타입
		if(type != null && type.equals("option")) { //타입이 옵션이면 옵션인걸로
			for(Product temp : list) {
				if(temp.getCano() == cano) { //옵션을 계속적으로 추가
					html +=
						"<option value=\""+temp.getPno()+"\">"+temp.getPname()+"</option>";			
				}
			}
		}  else {  } //반환
		out.print(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
