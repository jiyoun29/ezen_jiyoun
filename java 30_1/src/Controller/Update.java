package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.login.login;
import Dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Update implements Initializable {

	
	@FXML
	private TextField txtemail;

	@FXML
	private TextField txtaddress;
	
	@FXML
	private Button btupdate;
	
	@FXML //버튼클릭->actionevent, 레이블 클릭->mouseevent
	public void update(ActionEvent e) {
		
		//1.컨트롤러가져오기
		String email = txtemail.getText();
		String address = txtaddress.getText();
		//2.업데이트 처리 [ 회원번호=login.member에 집어넣어두었음***
			//로그인에 성공하면, 로그인팬에 로그인클래스에 회원정보를 저장
		boolean result = MemberDao.memberDao.update(login.member.getMnum(), email, address);
		
		if(result) {
			Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("회원정보가 수정되었습니다. 재 로그인 해주세요.");
			alert.showAndWait();
			//수정을 로그인 정보에 넣기 위해 로그아웃 필요
			
			main.instance.loadpage("/view/loginfx.fxml");
			//페이지 전환
			
			//로그인 정보 null
			login.member = null;
			
			
		} else {Alert alert = new Alert( AlertType.INFORMATION ); // 메시지 출력
				alert.setHeaderText("회원정보가 수정 실패 [ 관리자에게 문의 ]");
				alert.showAndWait();}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//입력된 것 끌고오기
		txtemail.setText(login.member.getMemail());
		txtaddress.setText(login.member.getMaddress());
		
	}
}
