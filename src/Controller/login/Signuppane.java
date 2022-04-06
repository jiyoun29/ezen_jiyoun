package Controller.login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Signuppane implements Initializable {
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		con.setText(""); //ó�� ����� ���� ���ֱ�
	}
	

	   @FXML
	    private Button btback;

	    @FXML
	    private Button btsignup;

	    @FXML
	    private Label con;

	    @FXML
	    private TextField txtaddress;

	    @FXML
	    private TextField txtemail;

	    @FXML
	    private TextField txtid;

	    @FXML
	    private PasswordField txtpw;

	    @FXML
	    private PasswordField txtpwcon;

	

    @FXML
    void accback(ActionEvent event) {
    	System.out.println("�ڷΰ���");
    	login.instance.loadpage("/view/loginpane.fxml");
    	
    }


    @FXML
    void signup(ActionEvent event) {
    	//��Ʈ�ѿ� �Էµ� ������ �������� [  fxid��.gettext() ]
    	String id = txtid.getText();
    	String pw = txtpw.getText();
    	String pwcon = txtpwcon.getText();
    	String email = txtemail.getText();
    	String address = txtaddress.getText();
    	
    	//���� ��¥ �������� [��¥ ���(����) ��ȯ Ŭ����]
    	SimpleDateFormat format = new SimpleDateFormat("yy-mm-dd");
   	
    	String since = format.format(new Date() ); //���� ��¥�� ���� ��ȯ
    	
    	// ��Ÿ �����ϼ���~~�Ф�
    	// *��ȿ�� �˻�
    		//1. id�ߺ�üũ
    	boolean result2 = MemberDao.memberDao.idcheck(id);
    		if(result2) {
    			con.setText("���� ������� ���̵��Դϴ�.");
    			return; //���� ���ϰ� �޼ҵ� ����
    		}
    	
    	
    	
    			//id ���� üũ [ ���̰� 4~10 ���� ]
		if( id.length() < 4 || id.length() >10 ) {
			con.setText(" [ ���� ] ���̵� 4~10 ���̷� �Է����ּ���!");
			return; // ���� ���ϰ� [ �޼ҵ� ���� ]
		}
    	
    		//2. ��й�ȣ ���� üũ
    			//���ڿ�.length(); ���ڿ� ����
    	if(pw.length() < 4 || pw.length() >10 || pwcon.length() < 4 || pwcon.length() > 10 ) {
    		con.setText("��й�ȣ�� 4���� �̻� 10���� �̸����� �Է����ּ���.");
    		
    		return; //���� ���ϰ� [�޼ҵ� ����]
    	}
    	
    			//��й�ȣ ��ġ üũ
    	if( ! pw.equals(pwcon)) { //�н������ �н�����˻� ��ġ���� ������ [ ! : ���� (�ݴ�) ] 
    		con.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
    		
    		return; //�޼ҵ� ����
    		}
    	
    	
    	
    		//3. �̸��� üũ [���ڿ�.indexOf("����") : �ش� ���ڿ��� ���ڰ� �����ϸ� �ش� ������ �ε��� ȣ�� / ���� ������ -1
    	if(email.indexOf("@") == -1) { //���� �Է��� �̸��Ͽ� @�� ������...
    		con.setText("@�� ������ �������� �Է����ּ���.");
    		
    		return; //�޼ҵ� ����
    	}
    	
    	
    	
    		//4. �ּ� üũ [���ڿ�.contains("����") : �ش� ���ڿ��� ���ڰ� �����ϸ� true / ������ false
    	
    	if(! address.contains("��") && address.contains("��") && address.contains("��")) {
    		con.setText("�ּ�����(��,��,�� ����)���� �Է����ּ���.");
    		
    		return; //�޼ҵ� ����	
    	}
    	
    	
    	
    	
    	
    	
    	
    	//* ��� ��ȿ�� �˻� ����� DB�� ����
    		//1. ��üȭ
    	Member member = new Member(0, id, pwcon, email, address, 0, since);
    
    		//2. DB ��ü �� �޼ҵ� ȣ��
    	boolean result = MemberDao.memberDao.signup(member);
    	
    	
    	//3.Ȯ��
    	if(result) {
    		//1. �޽��� â ���[alert : �޽��� Ŭ����
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("�˸�"); //�޽��� ���� ����
    		alert.setHeaderText("�Ȼ�� �߰� �ŷ��� ������ �����մϴ�.");
    		alert.setContentText("ȸ������ ����");
    		alert.showAndWait(); ///�޽��� ����
    		
    		
    		
    		
    		//2. ȭ�� ��ȯ [�α��� ������ ��ȯ]
    		login.instance.loadpage("/view/loginpane.fxml");
    		
    		
    		
    		System.out.println("���Լ���");
    	} else { 
    		con.setText("���Խ���");
    		return;} //���� ���ϰ� �޼ҵ� ����
    	
    	
    	
    	
    	
    }

    
    
    
    
}
