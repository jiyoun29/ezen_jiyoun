package Controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.main;
import Dao.MemberDao;
import Dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginpane implements Initializable {

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		con.setText(""); // 처음 실행시 문구 숨기기
	}
	
	  @FXML
	    private TextField txtid;

	    @FXML
	    private PasswordField txtpw;

	    @FXML
	    private Button signup;

	    @FXML
	    private Button btlogin;

	    @FXML
	    private Button findid;

	    @FXML
	    private Button findpw;

	    @FXML
	    private Label con;
	    
	    
	    //액션

	    @FXML
	    void accfindid(ActionEvent event) {
	    	System.out.println("아이디 찾기 페이지로 이동");
	    	login.instance.loadpage("/view/findid.fxml");
	    }

	    @FXML
	    void accfindpw(ActionEvent event) {
	    	System.out.println("비밀번호 찾기 페이지로 이동");
	    	login.instance.loadpage("/view/findpw.fxml");
	    }
	    
	    

	    @FXML
	    void accsingup(ActionEvent event) {
	    	System.out.println("회원가입 페이지로 이동");
	    	//login 컨트롤에 존재하는 borderpane 객체 내 센터 변경
	    		//문제 : 해당 보더팬의 객체가 다른 콘트럴에 있다.
	    	
//	    	login login = new login(); //new는 새로운 메모리 할당
	    					//기존 보더팬이 아닌 새로운 보더팬이 생기는 것
	    	//사용하지 말고 기존 것 가져오기
	    	
	    	//기존 login 클래스에서 사용중인 borderpane;
	    	login.instance.loadpage("/view/Signuppane.fxml");
	    	
//	    	login.loadpage("/view/Signuppane");

	    	
	    	
	    }

	    @FXML
	    void login(ActionEvent event) {
	    	
	    	//2번 방법
//	    	String id = txtid.getText(); //해당 fxid에 입력된 값 가져오기
//	    	String pw = txtpw.getText();
//	    	
//	    	if(id.equals("admin") && pw.equals("1234")) {
//	    		con.setText("관리자님, 안녕하세요.");
//	    	} else {con.setText("일반인님, 안녕하세요.");}
	    	
	    	//1번 방법
	    	//System.out.println(txtid.getText() + "가 아이디로 입력되었습니다.");
	    	//System.out.println(txtpw.getText() + "가 비밀번호로 입력되었습니다.");
	    	
	    	
	    
	    	
	    	//1.컨트롤에 입력된 값 가져오기
	    	String id = txtid.getText();
	    	String pw = txtpw.getText();
	    	
	    	//2.db객체 내 메소드 호출
	    	boolean result = MemberDao.memberDao.login(id, pw);
	    	
	    	//3. 결과 확인
	    	if(result) { //페이지 전환
	    		
	    		
	    		//로그인 성공시 성공환 회원정보 저장 [ 로그아웃 시 초기화 ]
	    		
	    		login.member = MemberDao.memberDao.getmember(id);
	    		//해당 id를 db에 집어넣어서 sel
	    		
	    		//페이지 전환
	    		main.instance.loadpage("/view/home/home.fxml");
	    		
	    		
	    		
	    		//*테스트
	    		con.setText("로그인 성공");
	    		
	    	} else { con.setText("동일한 회원 정보가 없습니다."); }
	    	
	    }
	
}
