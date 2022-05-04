package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dto.member;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public update() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // 요청시 사용되는 인코딩타입 [ 한글 포함 ] 
		
		//패스워드 체크 [유효성 검사]
		String oldpw = request.getParameter("oldpw");
		String newpw = request.getParameter("newpw");
		
		
		//수정 (형변환)		
		int mno = Integer.parseInt( request.getParameter("mno") ); // 수정 식별 대상 
		String mname =request.getParameter("mname");	
		String mphone =request.getParameter("mphone");
		String memail =request.getParameter("memail");
		String memailaddress =request.getParameter("memailaddress");
			String email = memail +"@"+memailaddress;
		String address1 =request.getParameter("address1");
		String address2 =request.getParameter("address2");
		String address3 =request.getParameter("address3");
		String address4 =request.getParameter("address4");
			String address = address1+"_"+address2+"_"+address3+"_"+address4;
		
		
		member member = null;
		if(oldpw.equals("") || newpw.equals("")) { //패스워드 변경이 없을때
			// 객체화
			member = new member
					(mno, null, null, mname, mphone, email , address, 0 , null);
				
		} else { //패스워드 변경이 있을때
			
			//기존 패스워드 체크
			HttpSession session = request.getSession();
			String mid = (String)session.getAttribute("login");
			
			boolean result = MemberDao.getMemberDao().passwordcheck(mid, oldpw);
		System.out.println("3");	
		if(result) { //기존 패스워드가 동일하면
		member = new member(mno, null, newpw, mname, mphone, email , address, 0 , null);
		} else { //동일하지 않으면
		response.sendRedirect("/JSPweb/member/update.jsp?result=3");
		
		//실행 못하게 놀려보내고 return으로 끝내버림
		return;
				}				
		}
			
		// 테스트 // System.out.println( member.toString() );
		// DB처리 
		boolean result = MemberDao.getMemberDao().update(member);
		if( result ) { response.sendRedirect("/JSPweb/member/update.jsp?result=1"); System.out.println("1");}
		else { response.sendRedirect("/JSPweb/member/update.jsp?result=2"); System.out.println("2"); }
		
	}

}
