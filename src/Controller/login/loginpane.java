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
		con.setText(""); // ó�� ����� ���� �����
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
	    	
	    	//2�� ���
//	    	String id = txtid.getText(); //�ش� fxid�� �Էµ� �� ��������
//	    	String pw = txtpw.getText();
//	    	
//	    	if(id.equals("admin") && pw.equals("1234")) {
//	    		con.setText("�����ڴ�, �ȳ��ϼ���.");
//	    	} else {con.setText("�Ϲ��δ�, �ȳ��ϼ���.");}
	    	
	    	//1�� ���
	    	//System.out.println(txtid.getText() + "�� ���̵�� �ԷµǾ����ϴ�.");
	    	//System.out.println(txtpw.getText() + "�� ��й�ȣ�� �ԷµǾ����ϴ�.");
	    	
	    	
	    
	    	
	    	//1.��Ʈ�ѿ� �Էµ� �� ��������
	    	String id = txtid.getText();
	    	String pw = txtpw.getText();
	    	
	    	//2.db��ü �� �޼ҵ� ȣ��
	    	boolean result = MemberDao.memberDao.login(id, pw);
	    	
	    	//3. ��� Ȯ��
	    	if(result) { //������ ��ȯ
	    		
	    		
	    		//�α��� ������ ����ȯ ȸ������ ���� [ �α׾ƿ� �� �ʱ�ȭ ]
	    		
	    		login.member = MemberDao.memberDao.getmember(id);
	    		//�ش� id�� db�� ����־ sel
	    		
	    		//������ ��ȯ
	    		main.instance.loadpage("/view/home/home.fxml");
	    		
	    		
	    		
	    		//*�׽�Ʈ
	    		con.setText("�α��� ����");
	    		
	    	} else { con.setText("������ ȸ�� ������ �����ϴ�."); }
	    	
	    }
	
}
