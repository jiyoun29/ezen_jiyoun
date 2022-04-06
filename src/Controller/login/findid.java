package Controller.login;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class findid implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		con.setText("");
	}
	
    @FXML
    private TextField txtemail;

    @FXML
    private Button back;

    @FXML
    private Button findid;

    @FXML
    private Label con;

    @FXML
    void accback(ActionEvent event) {
    	System.out.println("뒤로가기");
    	login.instance.loadpage("/view/loginpane.fxml");
    }


    @FXML
    void findid(ActionEvent event) {//1. 아이디 찾기 버튼 눌렀을 때
		//1. 컨트롤에 입력된 것 가져오기
    	String email = txtemail.getText();
    	//2. DB 연동 객체에서 이어 찾기 메소드 설정
    	String id = MemberDao.memberDao.findid(email);
    	//3. 확인
    	if(id != null) {//알람 띄우기
    		
    		//1.메시지(알람)
    		Alert alert = new Alert(AlertType.INFORMATION); //메시지 객체 선언
    			//내용물 채우기
    			alert.setHeaderText("회원님의 아이디는 : "+ id);
    		alert.showAndWait(); //실행
    		
    		
    	} else {//null이명 db 오류 혹은 찾은 아이디가 없다.
    		con.setText("해당 이메일의 아이디 정보가 없습니다."); 
    		
    	}
    	
    }

    
	
}
