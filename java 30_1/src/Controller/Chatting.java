package Controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.login.login;
import Dao.roomDao;
import Dto.Roomlive;
import Dto.room;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;

public class Chatting implements Initializable {


	@FXML
	private TableView<room> roomtable;

	@FXML
	private TextField txtroomname;

	@FXML
	private Button btnadd;

	@FXML
	private Label lblselect;

	@FXML
	private TextArea txtmidlist;
	
	@FXML
	private Button btnconnect;

	@FXML
	private Button btnsend;

	@FXML
	private TextArea txtcontent;

	@FXML
	private TextField txtip;

	@FXML
	private TextField txtmsg;

	@FXML
	private TextField txtname;

	@FXML
	private TextField txtport;
	

	////////////////////////////////////////////////////////
	

	
	//�������� ����[��� �޼ҵ忡�� ���]
	public Server server;  

	public static room selectroom; //���̺�信�� ���õ� �� ��ü
		//static���� �ؼ� start Ŭ���� ������ ���
	
	
	
	//1���� ������ ä�ù��� ���ĵǴ°� : (1)����Ʈ�� �������ϰų�, (2)catch �ȿ� �ִ� �� �����.
		//server.clientlist.romove(socket);
		//�� ������ �������� �� ���ӵ� ���� ����Ʈ���� ���� ����(1�� ���)
	
	
	public void Show() { // ���Ǵ� �� [ initialize , add �޼ҵ� ]
		//1. db���� ��� �� ��� ��������
		ObservableList<room> roomlist =
				roomDao.roomDao.roomList();
		//�븮��Ʈ �ϳ� ����
		
		//2. ���̺���� ù��° �ʵ带 �����ͼ� ���ȣ �ʵ�� ����
		TableColumn tc = roomtable.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("ronum"));
		
		//3. ���̺���� �ι�° �ʵ带 �����ͼ� ���̸� �ʵ带 ����
		tc = roomtable.getColumns().get(1);
		tc.setCellFactory(new PropertyValueFactory<>("roname"));
		
		//4. ���̺���� ����° �ʵ带 �����ͼ� ���ο� �ʵ�� ����
		tc = roomtable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("mcount"));
		
		//5. ���̺�信 ����Ʈ �־��ֱ�
		roomtable.setItems(roomlist);
		
		//6. �ش� ���̺�並 Ŭ������ ��	//���ٽ�
		roomtable.setOnMouseClicked(e -> {
			//���ϴ� �����ڵ�
			
			//7. Ŭ���� ��ü ��������
				roomtable.getSelectionModel().getSelectedItem();
			//8. ���̺� ǥ�õǴ� �� ***
				lblselect.setText("���� ���õ� �� : "+selectroom.getRoname());
			//9. ���� ��ư Ȱ��ȭ ***
			btnconnect.setDisable(false);
			
		});
		
	}
	
	
	
	@FXML
	void add(ActionEvent event) { //�氳�� ��ư�� ������ ��
			//1. ���̸��� �Է¹���
		String roomname = txtroomname.getText();
		
			
		if(roomname.length() < 4) { //���̸��� 4���� �̸��̸� �氳�� ����

    		txtroomname.setText("");// ������ ���̸� �Է�â ���� ó��
    		
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("�� ���� ����");
			alert.showAndWait();
			return; } //�˸� ����
		
			//2. �� ��ü
		room room = new room(0, roomname, "127.0.0.1", 0);
		
			//3. db ó��
		roomDao.roomDao.roomadd(room);
		
			//4. �ش� �� ���� ����
		server = new Server();// �޸��Ҵ�
		// **���� ���� [ �μ��� ip �� port=���ȣ �ѱ�� ]
		server.serverstart(room.getRoip(), roomDao.roomDao.getroomnum());
		
		txtroomname.setText(""); //���� �� ���̸� �Է�â ���� ó��
		
		Show(); //���̺� ���ΰ�ħ
		
		//�˶� ����
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("�� ������ �Ǿ����ϴ�.\n���ȣ: "+ roomDao.roomDao.getroomnum());
			alert.showAndWait();

	    }

	
//////
    
    public void midshow() { //msg �޼ҵ� : �Է�â���� ���� ���� ��/send �޼ҵ� : ���۹�ư ������ ��

    	//1. ���̺�信�� ���õ� �� ��ȣ�� ���ӵ� ȸ����� ��������
    	ArrayList<Roomlive> roomlivelist 
			= roomDao.roomDao.getRoomlivelist( selectroom.getRonum() );
    	//@��� �븮��Ʈ ������.
    		//@���̺�並 �� ������ ����������Ʈ���� �� �ܿ��� �� ���� ��̸���Ʈ�� ����ؼ� ��� �����´�.
    	
    		//��ü�� �ϳ��� ���ͼ�
    	txtmidlist.setText(""); //2. ��� �ʱ�ȭ

    	//���
    	int i = 1; 
		for( Roomlive temp : roomlivelist ) {
			txtmidlist.appendText( i +"�� "+ temp.getMid() +"\n");
			i++;
		}
    }
	////
	
	
	@FXML
	void msg(ActionEvent event) { //�Է�â���� �Է� �� ���͸� ������ ��
		
		String msg = login.member.getMid()+" : "+txtmsg.getText()+"\n";
		send(msg);
		txtmsg.setText("");
		txtmsg.requestFocus(); //��Ŀ��=Ŀ�� �����̱�
		
//		ArrayList<Roomlive> roomlivelist
//			= roomDao.roomDao.getRoomlivelist(selectroom.getRonum());
//		
//		txtmidlist.setText("");
		
		midshow();		}
//		int i = 1;
//		for(Roomlive temp : roomlivelist) {
//			
//			txtmidlist.appendText(i+"�� "+temp.getMid() + "\n");
//			i++;

		
		
	    
	
	//msg�� send �����ϰ�
	
	
    @FXML
    void send(ActionEvent event) { //���۹�ư�� ��������
    	String msg = login.member.getMid()+" : "+txtmsg.getText()+"\n"; //���� �޽���
    	send(msg); //�޽��� ������
    	txtmsg.setText(""); //�������� �޽��� �Է�â �����
    	txtmsg.requestFocus(); //�������� �޽��� �Է�â���� ��Ŀ��(Ŀ��) �̵�
    	

//		ArrayList<Roomlive> roomlivelist
//			= roomDao.roomDao.getRoomlivelist(selectroom.getRonum());
//		
//		txtmidlist.setText("");
		
		midshow();

//		int i = 1;
//		for(Roomlive temp : roomlivelist) {
//			
//			txtmidlist.appendText(i+"�� "+temp.getMid() + "\n");
//			i++; }
			
    }//send end
    
	
	
	
//////////////////////////////////////////////////////////////////

	

    Socket socket;   // 1. Ŭ���̾�Ʈ ���� ���� 
    
    
    

    // 2. Ŭ���̾�Ʈ ���� �޼ҵ�
    public void clientstart(String ip, int port) {
    	Thread thread = new Thread() { // ��Ƽ������ 
    		@Override
    		public void run() {
    			try {
    				socket = new Socket(ip,port); // ������ ip�� ��Ʈ��ȣ �־��ֱ� [ ������ ���� ]
    				send( login.member.getMid()+"�� �����߽��ϴ�\n"); // ���Ӱ� ���ÿ� ����޽��� ������ 
    				receive(); // ���Ӱ� ���ÿ� �ޱ� �޼ҵ�� ���ѷ���
    			}catch(Exception e ) { } //clientstop(); System.out.println("����="+e);
    		};
    	};// ��Ƽ������ ���� ��
    	thread.start(); // ��Ƽ������ ����
    }
    
    
    // 3. Ŭ���̾�Ʈ ���� �޼ҵ� 
    public void clientstop() {  try{ socket.close(); }
    catch(Exception e ) {} }
	
	
	

    // 4. �������� �޽��� ������ �޼ҵ� 
    public void send( String msg ) {
    	Thread thread = new Thread() { 
    		@Override
    		public void run() {
    			try {
    				OutputStream outputStream = socket.getOutputStream(); // 1. ��� ��Ʈ��
    				outputStream.write( msg.getBytes() ); // 2. ��������
    				outputStream.flush(); // 3. ��Ʈ�� �ʱ�ȭ [ ��Ʈ�� �� ����Ʈ ����� ]
    			}catch( Exception e ) { } 
    		}
    	};// ��Ƽ������ ���� �� 
    	thread.start();
    }
    
    
    
    // 5. �������� �޽��� �ޱ� �޼ҵ� 
    public void receive() {
    	
    	while(true) { //��ġ �����Ұ�
    		
    		try {

	    		InputStream inputStream = socket.getInputStream(); // 1. �Է� ��Ʈ��
	    		byte[] bytes = new byte[1000]; 	// 2. ����Ʈ�迭 ���� 
	    		inputStream.read(bytes);		// 3. �о���� 
	    		String msg = new String(bytes);	// 4. ����Ʈ�� -> ���ڿ� ��ȯ
	    		txtcontent.appendText(msg); 	// 4. ���� ���ڿ��� �޽���â�� ���� 

    	}catch( Exception e ) {	} //clientstop(); System.out.println("����="+e); break; 
    		
    	}
    }

    

	@FXML
	void connect(ActionEvent event) { //���ӹ�ư�� ������ ��
	   if(btnconnect.getText().equals("����")) {//���࿡ ��ư�� �ؽ�Ʈ�� "����" �̸� 
   		//Ŭ���̾�Ʈ ���� �޼ҵ�	    		    		
		   //ip�� port�� Ŭ���̾�Ʈ ���� �޼ҵ�� ����
	  clientstart(selectroom.getRoip(), selectroom.getRonum()); //��Ʈ ��� ����
	  
	  //���� �� ���Ӹ�� �߰�
	  Roomlive roomlive = new Roomlive(0, selectroom.getRonum(),
			  					login.member.getMid());
	  //dbó��
	  roomDao.roomDao.addroomlive(roomlive);
	  
	  
	  ///////////
    		txtcontent.appendText("---[ä�ù� ����]---\n");
    		btnconnect.setText("������");
    		
    		
    		txtmsg.setText("");
    		
    		txtmsg.setEditable(false);//ä�� �Է�â ��밡��
    		txtcontent.setDisable(false);//ä��â ��� ��밡��
    		btnsend.setDisable(false); //���۹�ư ��밡��
    		
    		txtmsg.requestFocus(); //ä�� �Է�â���� ��Ŀ��[Ŀ��] �̵�
    		
    		txtroomname.setDisable(true); //ä�ù� �̸� �Է�â ��� ����
    		btnadd.setDisable(true); //ä�� ���� ��ư ��� ����
    		roomtable.setDisable(true); //ä�ù� ��� ��� ����
    		
    		
	    		
	    } else { clientstop(); //Ŭ���̾�Ʈ ���� �޼ҵ�
	    
    		txtcontent.appendText("---[ä�ù� ����]---\n");
    		btnconnect.setText("����");
    		

			//ä�ù� ���� ���� ��� ���ϰ� ���Ƶα�
		txtmsg.setText("ä��â ���� �� ��� ����");
		
		txtmsg.setEditable(true);//ä�� �Է�â ���� ����
		txtcontent.setDisable(true);//ä��â ��� ��� ����
		btnsend.setDisable(true); //���۹�ư ��� ����
		btnconnect.setDisable(true);
		
		txtroomname.setDisable(false);
		btnadd.setDisable(false);
		roomtable.setDisable(false);
		
		/*1.�� ���� ��ܿ��� ����[����]�ϱ�
			2.���࿡ �� ���� ����� 0���̸� �����
				2-1.���� ���� �����Ǹ� �������� ����
			3.�������� ����
			* ���̺� �信�� ���õ� �� ��ü �ʱ�ȭ
			* ���õ� �� ���̺� �ʱ�ȭ
		*/
		//1��
		roomDao.roomDao.roomlivedelete(login.member.getMid());
		
		//2-1.�ڵ�
		boolean result = roomDao.roomDao.roomlivedelete(selectroom.getRoname());
		System.out.println(result);
		if(result) { server.serverstop(); }
		
		//���̺� �信�� ���õ� �� ��ü �ʱ�ȭ
		selectroom = null;
		//���õ� �� ���̺� �ʱ�ȭ
		lblselect.setText("���� ���õ� �� : ");
		
		Show(); //���� ���̺� ���ΰ�ħ
		// �� ������ �������ϳ� ���ӵ� ���� ����Ʈ���� ���� ���� 
	    	}

	    }
	
	

	 @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	    	// ä��fxml �������� �ʱⰪ �޼ҵ�  	// * ä�ù� �������� �Ʒ� fxid�� �����ϰ� ���� 
	    	txtmsg.setText("ä�ù� ������ ��밡��");
	    	txtmsg.setDisable(true); 		// ä���Է�â ������ 
	    	txtcontent.setDisable(true); 	// ä��â ��� ������
	    	btnsend.setDisable(true); 		// ���۹�ư ������
	    	btnconnect.setDisable(true); 	// �����ư ������
	    	txtmidlist.setDisable(true);  	// ������ȸ�� ��� ������ 
	    
	    	Thread thread = new Thread() { // ä�ù� ��� �ǽð� ȭ�� ó��
				@Override
				public void run() {
					while( true ) { 
						try { Show();
							Thread.sleep(1000);
						}catch( Exception e ) {} 
					}
				}
			}; 
			thread.start();
	    }
	
	
}
