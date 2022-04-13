package Controller;

//import java.awt.Button; // x
//import java.awt.Label; // x
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Controller.login.login;
import Dao.MemberDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Home implements Initializable {
	
	
	public static Home home; //��ü
	//this:�̰�,����... : ���� Ŭ������ �޸� ȣ�� (@���� ����ϴ� �������� �޸𸮸� home ��ü�� ���� �� ����)
	public Home() {home=this;} //������
	
	////////////////
	


	//�����ʱ� �޼ҵ�
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//ä��
		loadpage("/view/chatting.fxml");
		
		
		
		loginid.setText(login.member.getMid()+" ��");
		labpoint.setText("����Ʈ :"+login.member.getMpoint()+"��");
		
		
	}
	
	
	
	@FXML
	private Label loginid;  // �ڵ��ϼ� �ϽǶ� ���� javafx ���� java.awt �� swing ����ϸ� �ȵ˴ϴ�~~
	@FXML
	private Label logout; //
	@FXML
	private Label labpoint;
	@FXML
	private Label delete; //fxid ��������
	
	@FXML
	private Label labelinfo;
	
	@FXML
	private Label Lableupdate;
	
	@FXML
	private Label lblboard;
	
	@FXML
	private Label record;
	
	@FXML
	public void accrecord(MouseEvent e) {	loadpage("/View/record.fxml");	}
	
	
	
	@FXML
	private BorderPane borderPane; //�̸� home.fxml �̶� �����ϰ�

	
	//������ ���� ī�װ���
	public static String category;
	
	
	@FXML //�����Ƿ�
	private Label lblproduct1;

	@FXML
	public void accproduct1(MouseEvent e) {
		loadpage("/View/product/product.fxml");
		category="�����Ƿ�";
	}
	
	
	@FXML //�����Ƿ�
	private Label lblproduct2;

	@FXML
	public void accproduct2(MouseEvent e) {
		loadpage("/View/product/product.fxml");
		category="�����Ƿ�";		
	}

	
	@FXML //���ӱ��
	private Label lblproduct3;

	@FXML
	public void accproduct3(MouseEvent e) {
		loadpage("/View/product/product.fxml");
		category="���ӱ��";		
	}

	
	@FXML //��Ȱ��ǰ
	private Label lblproduct4;
	
	@FXML
	public void accproduct4(MouseEvent e) {
		loadpage("/View/product/product.fxml");
		category="��Ȱ��ǰ";
	}

	
	
	
	
	
	
	
	
	
	//��������
	@FXML
	public void accmylist(MouseEvent e) {
		
	}
	
	
	
	
			
	@FXML	//��ǰ
	public void accproduct(MouseEvent e) { loadpage("/view/product/product.fxml"); }
			
			
			
	@FXML	//�����Խ���
	public void accboard(MouseEvent e) { loadpage("/view/board/board.fxml"); }




	@FXML //ȸ������ �̺�Ʈ
	public void accInfo(MouseEvent e) {loadpage("/view/home/Info.fxml");}

	
	
	public void loadpage(String page) {
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderPane.setCenter(parent);
		} catch (Exception e) {	 System.out.println(e);	} // ����ó�� ��� ����ϸ� ���� ������ �˼� �־��~
		
	}
	
	
	
	@FXML //ȸ������ �̺�Ʈ(������Ʈ)
	public void accupdate(MouseEvent e) {loadpage("/view/home/Info2.fxml");}

	
	
	@FXML //�α׾ƿ� ���̺��� Ŭ�� ���� ��
	public void logout(MouseEvent e) {
		//1.login ���� �����
		login.member = null;
		
		//2.������ ��ȯ
		main.instance.loadpage("/view/loginfx.fxml");
	}
	
	
	
	
	@FXML //ȸ��Ż�� ���̺��� Ŭ������ ��
	public void delete(MouseEvent e) {
		//�̺�Ʈ�� �ɾ����� fxml�� �����ؾ��Ѵ�.
		
		//1.�޽���
		Alert alert = new Alert(AlertType.CONFIRMATION); //Ȯ��, ��� ��ư Ÿ��
			alert.setHeaderText("���� Ż�� �Ͻðڽ��ϱ�?");
			
		//2. ��ư Ȯ�� Optional : Ŭ���� 
			Optional<ButtonType> optional = alert.showAndWait();
			//����
			
			if(optional.get() == ButtonType.OK) {		//Ȯ�� ��ư�� ������ ��
				
				//ȸ��Ż������
			boolean result = MemberDao.memberDao.delete(login.member.getMnum());
			
				if(result) { //Ż�� ����
					//�α׾ƿ� [ login Ŭ���� �� member ��ü null�� �ְ� ���� ]
					login.member = null;
					
					//������ ��ȯ
					main.instance.loadpage("/View/loginfx.fxml");
					
				} else {//Ż�� ����
					}
				}
	}
	
		
	
	
	
	
	
	
}