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
	    
	    
	    //�׼�

	    @FXML
	    void accfindid(ActionEvent event) {
	    	System.out.println("���̵� ã�� �������� �̵�");
	    	login.instance.loadpage("/view/findid.fxml");
	    }

	    @FXML
	    void accfindpw(ActionEvent event) {
	    	System.out.println("��й�ȣ ã�� �������� �̵�");
	    	login.instance.loadpage("/view/findpw.fxml");
	    }

	    @FXML
	    void accsingup(ActionEvent event) {
	    	System.out.println("ȸ������ �������� �̵�");
	    	//login ��Ʈ�ѿ� �����ϴ� borderpane ��ü �� ���� ����
	    		//���� : �ش� �������� ��ü�� �ٸ� ��Ʈ���� �ִ�.
	    	
//	    	login login = new login(); //new�� ���ο� �޸� �Ҵ�
	    					//���� �������� �ƴ� ���ο� �������� ����� ��
	    	//������� ���� ���� �� ��������
	    	
	    	//���� login Ŭ�������� ������� borderpane;
	    	login.instance.loadpage("/view/Signuppane.fxml");
	    	
//	    	login.loadpage("/view/Signuppane");

	    }

	    @FXML
	    void login(ActionEvent event) {
	    	System.out.println("�α��� ó��");

	    }
	
	
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
		  
		    
		}
}
