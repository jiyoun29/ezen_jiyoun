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
    	System.out.println("�ڷΰ���");
    	login.instance.loadpage("/view/loginpane.fxml");
    	
    	
    }
	
    //////////////////////////////////??????????

    @FXML
    private Label con;

    @FXML
    void findpw(ActionEvent event) {
    	
    	//1. ��Ʈ�ѿ� �Էµ� ������ ��������
    	String id = txtid.getText();
    	String email = txtemail.getText();
    	
    	//2.db�ޙ� ��ȣ��
    	String pw = MemberDao.memberDao.findpw(id, email);

    	//3.Ȯ��
    	if(pw != null) { //ã���� ���
    		
    		
    			//dto member �ۼ� �� ����� �̵�
    		Member.sendmail(email, pw);
    		//�̸��� ���� �޼ҵ� ȣ��
    		
    		
    		
    		//1.�޽���(�˶�)
    		Alert alert = new Alert(AlertType.INFORMATION); //�޽��� ��ü ����
    			//���빰 ä���
    			alert.setHeaderText("ȸ������ ��й�ȣ�� : "+ id);
    		alert.showAndWait(); //����
    		
    		
    	} else {con.setText("������ ȸ�������� �������� �ʽ��ϴ�.");}
    }
	
	

}
