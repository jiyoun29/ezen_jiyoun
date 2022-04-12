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
	
	@FXML //��ưŬ��->actionevent, ���̺� Ŭ��->mouseevent
	public void update(ActionEvent e) {
		
		//1.��Ʈ�ѷ���������
		String email = txtemail.getText();
		String address = txtaddress.getText();
		//2.������Ʈ ó�� [ ȸ����ȣ=login.member�� ����־�ξ���***
			//�α��ο� �����ϸ�, �α����ҿ� �α���Ŭ������ ȸ�������� ����
		boolean result = MemberDao.memberDao.update(login.member.getMnum(), email, address);
		
		if(result) {
			Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("ȸ�������� �����Ǿ����ϴ�. �� �α��� ���ּ���.");
			alert.showAndWait();
			//������ �α��� ������ �ֱ� ���� �α׾ƿ� �ʿ�
			
			main.instance.loadpage("/view/loginfx.fxml");
			//������ ��ȯ
			
			//�α��� ���� null
			login.member = null;
			
			
		} else {Alert alert = new Alert( AlertType.INFORMATION ); // �޽��� ���
				alert.setHeaderText("ȸ�������� ���� ���� [ �����ڿ��� ���� ]");
				alert.showAndWait();}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//�Էµ� �� �������
		txtemail.setText(login.member.getMemail());
		txtaddress.setText(login.member.getMaddress());
		
	}
}
