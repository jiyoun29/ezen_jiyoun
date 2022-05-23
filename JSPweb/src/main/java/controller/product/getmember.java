package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;
import dto.member;


@WebServlet("/product/getmember") //url 정의
public class getmember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getmember() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mid = (String)request.getSession().getAttribute("login");
		
		member member = MemberDao.getMemberDao().getMember(mid);
		
		//dto-> json 변환
		try {		
			JSONObject jsonObject = new JSONObject(); //1. json 객체 선언
			jsonObject.put("mno", member.getMno()); //비밀번호 제외 9개 뽑아오기
			jsonObject.put( "mid" , member.getMid() );
			jsonObject.put("mname", member.getMname());
			jsonObject.put("mphone", member.getMphone());
			jsonObject.put("memail", member.getMemail());
			jsonObject.put("maddress", member.getMaddress());
			jsonObject.put("mpoint", member.getMpoint());
			jsonObject.put("mdate", member.getMdate());
			//json -> 스크립트 통신으로 보냄 
			response.setCharacterEncoding("UTF-8"); //한글 인코딩 지원
			response.setContentType("application/json"); //json 형식으로 통신 타입 ***********꼭!
			response.getWriter().print(jsonObject);
		} catch (Exception e) {System.out.println("겟멤버오류"+e);}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
