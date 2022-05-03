package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;

/**
 * 해당 클래스로 접근할 수 있는 url 정의
 * @ WebServlet("/login")
 * action은 접근
 * 
 * 목적 : 서로 다른 언어들 간의 통신이 된다.
 * 		view <->controller
 * 
 *  view(html,jsp,js,css등) ---- 매핑 ( @WebServlet ) ----->  controller(java)
 *		// 1. 해당 클래스의 @WebServlet 어노테이션 이용해서 클래스의 URL 정의[만들기]
 *		// 2. VIEW에서 경로를 설정하여 정의된 클래스의 URL로 이동할수 있다.
 */

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. 요청
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpassword");
		
		//2. 객체화(데이터가 적기 때문에 생략)	
		
		//3. db처리
		int result = MemberDao.getMemberDao().login(mid,mpw);
		
		//4. db결과
		if(result == 1) {
			//로그인 성공시 세션 부여 *****
			//[세션 : 서버에 메모리 할당] 장점:모든페이지에서 동일한 메모리 사용 가능
			HttpSession session = request.getSession(); //1.http 내장 세션 호출[ JSP 생략 => 내장객체 ] 
			//구현
			session.setAttribute("login", mid); //2.세션에 값 저장
							// 세션명, 데이터
			System.out.println("페이지전환불가");
			//페이지 전환
			response.sendRedirect("/JSPweb/main.jsp");
									// 아이디 혹은 비밀번호가 다름 //변수보내기
		} else if (result == 2) { 
			System.out.println("j");
			response.sendRedirect("/JSPweb/member/login.jsp?result=2");	
		System.out.println("페이지전환불2"); }
		else {response.sendRedirect("/JSPweb/member/error.jsp"); 
		System.out.println("페이지전환불가3");}
				//db오류
		doGet(request, response);
	}

}
