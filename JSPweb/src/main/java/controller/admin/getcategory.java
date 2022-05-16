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
import dto.Category;

@WebServlet("/admin/getcategory")
public class getcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getcategory() {
        super();    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//productstock을 위한 추가
		//반환타입 직접 생성
		String type = request.getParameter("type");
		
		
		//변수 요청 없음
		//db에서 카테고리 리스트 호출
		ArrayList<Category> arrayList = ProductDao.getProductDao().getcategorylist();
		
		//자바에서 js(ajax)에게 html 전송
		response.setCharacterEncoding("UTF-8"); //한글
		PrintWriter out = response.getWriter(); //html 에게 전송할 객체 생성
		String html =""; //응답할 문자열

		
		
		//productstock을 위한 추가
		if(type != null && type.equals("option")) { //option으로 반환

			for(Category temp : arrayList) {
				html +=
				"<option value=\""+temp.getCano()+"\">"+temp.getCaname()+"</option>";
			}
			
		} else { //input 반환
			
			int i = 1;
			for(Category temp : arrayList) {
			html+=
			"<input type=\"radio\" name=\"cano\" value=\""
					+temp.getCano()+"\">"+temp.getCaname();
			if( i % 6 == 0 ) html += "<br>"; // 만약에 카테고리가 개수 6배수마다 줄바꿈처리 
			
			i++;
		}

		}
	//  java에서 " " : 문자열 인식용 	//  		\"  : " 표시(출력)
		out.print(html); //해당 문자열 응답
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
