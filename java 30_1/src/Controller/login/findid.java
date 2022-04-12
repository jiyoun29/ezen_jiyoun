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
    	System.out.println("�ڷΰ���");
    	login.instance.loadpage("/view/loginpane.fxml");
    }


    @FXML
    void findid(ActionEvent event) {//1. ���̵� ã�� ��ư ������ ��
		//1. ��Ʈ�ѿ� �Էµ� �� ��������
    	String email = txtemail.getText();
    	//2. DB ���� ��ü���� �̾� ã�� �޼ҵ� ����
    	String id = MemberDao.memberDao.findid(email);
    	//3. Ȯ��
    	if(id != null) {//�˶� ����
    		
    		//1.�޽���(�˶�)
    		Alert alert = new Alert(AlertType.INFORMATION); //�޽��� ��ü ����
    			//���빰 ä���
    			alert.setHeaderText("ȸ������ ���̵�� : "+ id);
    		alert.showAndWait(); //����
    		
    		
    	} else {//null�̸� db ���� Ȥ�� ã�� ���̵� ����.
    		con.setText("�ش� �̸����� ���̵� ������ �����ϴ�."); 
    		
    	}
    	
    }

    
	
}
