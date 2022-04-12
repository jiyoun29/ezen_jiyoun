package Controller.login;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class findpw implements Initializable {
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		con.setText("");
		
	}
	
    @FXML
    private TextField txtemail;

    @FXML
    private Button back;

    @FXML
    private Button findpw;

    @FXML
    private TextField txtid;

    @FXML
    void accback(ActionEvent event) {
    	System.out.println("뒤로가기");
    	login.instance.loadpage("/view/loginpane.fxml");
    	
    	
    }
	
    //////////////////////////////////??????????

    @FXML
    private Label con;

    @FXML
    void findpw(ActionEvent event) {
    	
    	//1. 컨트롤에 입력된 데이터 가져오기
    	String id = txtid.getText();
    	String email = txtemail.getText();
    	
    	//2.db메솓 ㅡ호출
    	String pw = MemberDao.memberDao.findpw(id, email);

    	//3.확인
    	if(pw != null) { //찾았을 경우
    		
    		
    			//dto member 작성 후 여기로 이동
    		Member.sendmail(email, pw);
    		//이메일 전송 메소드 호출
    		
    		
    		
    		//1.메시지(알람)
    		Alert alert = new Alert(AlertType.INFORMATION); //메시지 객체 선언
    			//내용물 채우기
    			alert.setHeaderText("회원님의 비밀번호는 : "+ id);
    		alert.showAndWait(); //실행
    		
    		
    	} else {con.setText("동일한 회원정보가 존재하지 않습니다.");}
    }
	
	

}
