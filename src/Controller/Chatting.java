package Controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.security.PublicKey;
import java.util.ResourceBundle;

import Controller.login.login;
import Dto.Clients;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

public class Chatting implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//ä��fxml �������� �ʱⰪ �޼ҵ�
			//ä�ù� ���� ���� ��� ���ϰ� ���Ƶα�
		txtmsg.setText("ä��â ���� �� ��� ����");
		
		txtmsg.setEditable(false);//ä�� �Է�â ���� ����
		txtcontent.setDisable(false);//ä��â ��� ��� ����
		btnsend.setDisable(false); //���۹�ư ��� ����
		
	}
	
	
	//1.Ŭ���̾�Ʈ ���� ����
	Socket socket;
	
	//2.Ŭ���̾�Ʈ ���� �޼ҵ�
	public void clientstart() {
		//��Ƽ ������
		Thread thread = new Thread(){
			@Override
			public void run() {
				try {
					socket = new Socket("127.0.0.1",1234); //������ ip�� ��Ʈ��ȣ �־��ֱ�[������ ����]
					
					send(login.member.getMid()+"�� �����߽��ϴ�.\n");
					//���Ӱ� ���ÿ� ����޽��� ������
					
					receive(); //���Ӱ� ���ÿ� �ޱ� �޼ҵ�� ���ѷ���
				} catch (Exception e) {	}
			};
		}; //��Ƽ ������ ���� ��		
		thread.start(); //��Ƽ ������ ����
		
	}

	
	//3.Ŭ���̾�Ʈ ���� �޼ҵ�
	public void clientstop() {try { socket.close(); }catch (Exception e) {	} }
	
	
	
	//4.�������� �޽��� ������ �޼ҵ�
	public void send(String msg) {
		Thread thread = new Thread() {
			@Override
			public void run() {
			try {
				OutputStream outputStream = socket.getOutputStream(); //��� ��Ʈ��
				outputStream.write(msg.getBytes()); //��������
				
				outputStream.flush(); //��Ʈ�� �ʱ�ȭ[��Ʈ�� �� ����Ʈ �����]
				
			} catch (Exception e) {	}
		}
		
	}; //��Ƽ������ ���� ��
		thread.start();
	}
	
	
	
	
	//5. �������� �޽��� �ޱ� �޼ҵ�
	public void receive() {
		try {
			while(true) {
				InputStream inputStream = socket.getInputStream(); //�Է� ��Ʈ��
				byte[] bytes = new byte[1000]; //����Ʈ �迭 ����
				inputStream.read(bytes); //����Ʈ�� ����
				String msg = new String(bytes); //����Ʈ��->���ڿ� 
				txtcontent.appendText(msg); //�Է¹��� ������ ä��â�� �߰��ϱ�
			}
			
		} catch (Exception e) {	}	
	}	
	
	
	
	
	

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
	
	


    @FXML
    void send(ActionEvent event) { //���۹�ư�� ��������
    	String msg = txtmsg.getText()+"\n"; //���� �޽���
    	send(msg); //�޽��� ������
    	txtmsg.setText(""); //�������� �޽��� �Է�â �����
    	txtmsg.requestFocus(); //�������� �޽��� �Է�â���� ��Ŀ��(Ŀ��) �̵�
    }//send end
    
    


	@FXML
	void connect(ActionEvent event) {
	   if(btnconnect.getText().equals("����")) {//���࿡ ��ư�� �ؽ�Ʈ�� "����" �̸� 
   		//Ŭ���̾�Ʈ ���� �޼ҵ�	    		    		
	    clientstart();
    		txtcontent.appendText("---[ä�ù� ����]---\n");
    		btnconnect.setText("������");
    		
    		
    		txtmsg.setText("");
    		
    		txtmsg.setEditable(false);//ä�� �Է�â ��밡��
    		txtcontent.setDisable(false);//ä��â ��� ��밡��
    		btnsend.setDisable(false); //���۹�ư ��밡��
    		
    		txtmsg.requestFocus(); //ä�� �Է�â���� ��Ŀ��[Ŀ��] �̵�
    		
	    		
	    } else { //�ƴϸ�
	    		
	    //Ŭ���̾�Ʈ ���� �޼ҵ�
	    clientstop();
    		txtcontent.appendText("---[ä�ù� ����]---\n");
    		btnconnect.setText("����");
    		

			//ä�ù� ���� ���� ��� ���ϰ� ���Ƶα�
		txtmsg.setText("ä��â ���� �� ��� ����");
		
		txtmsg.setEditable(true);//ä�� �Է�â ���� ����
		txtcontent.setDisable(true);//ä��â ��� ��� ����
		btnsend.setDisable(true); //���۹�ư ��� ����
    		
	    	}

	    }
	
	
	
}
