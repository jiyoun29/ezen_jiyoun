package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginpane implements Initializable {

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
	    	System.out.println("로그인 처리");

	    }
	
	
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
		  
		    
		}
}
