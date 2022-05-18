package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

@WebServlet("/product/getamount")
public class getamount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getamount() {
        super();
        // TODO Auto-generated constructor stub
    }


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //한글이 있을 수 있으므로 받아옴
	   request.setCharacterEncoding("UTF-8"); //한글 인코딩 타입
	   
	   //받아오기
	   int pno = Integer.parseInt(request.getParameter("pno")); //제품번호 요청
	   String color = request.getParameter("color"); //색상 요청
	   String size =  request.getParameter("size"); //사이즈 요청
	   
	   //재고 꺼내오기
	   ArrayList<Stock> stocks = ProductDao.getProductDao().getstock(pno); //해당 제품의 재고목록
	   
	   for(Stock s : stocks) {
		   //만일 s의 칼라, 사이즈가 동일하면 리스폰 한다.				공백이 들어갈 경우 size.trim()으로 공백 제거
		   if(s.getScolor().equals(color) && s.getSsize().equals(size)) {
			   response.getWriter().print(s.getSamount());
		   }
	   }
	   
   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
