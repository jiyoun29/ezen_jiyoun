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
import dto.Stock;

@WebServlet("/admin/getstock")
public class getstock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public getstock() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		String field = request.getParameter("field");
		//전부 불러오기
		ArrayList<Stock> list = ProductDao.getProductDao().getstock(pno);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String html = "";
		
		//제품리스트 페이지에서 선택된 색상과 사이즈에 해당하는 재고량 출력 구역
		if(field != null && field.equals("amount")) {
			String scolor = request.getParameter("scolor");
			String ssize = request.getParameter("ssize");
			
			for(Stock temp : list) {
				if(temp.getScolor().equals(scolor) && temp.getSsize().equals(ssize)) {
					out.print(temp.getSamount()+','+temp.getUpdatedate() );
					//쉼표 기준으로 앞이 재고량, 두번째가 수정날짜를 보냈음
						//문자열 분해함수 : split
				}
			}
		} else { //제품 재고 페이지에서 사용되는 제품별 재고정보 출력 구역		
//		if(field != null && field.equals("ssize")) {
//			for(Stock temp : list) {
//				if(temp.getPno() == pno) {
//				html+=
//					"<option value=\""+temp.getSno()+"\">"+temp.getSsize()+"</option>";
//					//화면에는 사이즈를 보여주고 값에는 넘버를 넣어줌
//				}
//			}
		for(Stock temp : list) {
			html +=
				"<tr>" +
					"<td> "+temp.getScolor()+" </td>"+
					"<td> "+temp.getSsize()+" </td>"+
					"<td> "+temp.getSamount()+" </td>"+
					"<td>" +
					"<button onclick=\'showupdate("+temp.getSno()+")\'>수정</button>"+
					"<button>삭제</button>"+"</td>"+
				"</tr>";		
			}
		}
		out.print(html);
	}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
