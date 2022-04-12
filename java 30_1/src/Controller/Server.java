package Controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextArea;

public class Server  { // fxml ������� �ʴ� Ŭ���� [ ���� ��Ʈ�� ��� ] 
	//implements Initializable
	
	
	//��øŬ����[Client
		//Ŭ���� �ȿ� Ŭ������ ����
	public class Client{
///////////////////////////////////
	//������ ������ Ŭ���̾�Ʈ�� Ŭ����
	
	//1. �ʵ�[����]
	public Socket socket;
	
	//2.������
	public Client (Socket socket) {
		
		this.socket = socket; 
		
		recive(); 
		}//������ ����� Ŭ���̾�Ʈ ��ü�� ������ �� �ޱ� �޼ҵ� ����
	
	//5. ������ �޼��� �޴� �޼ҵ�
	public void recive() {

		//��Ƽ������ [Thread Ŭ���� vs Runnable �������̽�]
			//run �޼ҵ带 �ʼ������� �����ؾ���
		//�������̽��� �߻� �޼ҵ尡 �����ϱ� ������ �����ʼ�[Ŭ�������� implements vs �͸�ü]
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() { //�߻� �޼ҵ� ����
				//��������� �޽��� �޴� ����
				

				while(true) {
			try {
					//1. �Է½�Ʈ�� �����
					InputStream inputStream = socket.getInputStream();

					//2. ����Ʈ �迭����[��Ʈ���� ����Ʈ ����]
					byte[] bytes = new byte[1000]; 
					
					//3. �Է½�Ʈ������ ����Ʈ �о����
					inputStream.read(bytes);
					
					//4. ����Ʈ�� -> ���ڿ� ��ȯ
					String msg = new String(bytes);
					
					//*������ ���� �޽����� ���� ������ ���ӵ� ��� Ŭ���̾�Ʈ���� ���� �޽��� ������
						//���� ���ӵ� Ŭ���̾�Ʈ����Ʈ ������
					for( Client client: clientlist) {
						client.send( msg );
						//4������ ����
						//���� �޽����� �ä����� ���ӵ� clientlist ��� Ŭ���̾�Ʈ���� �޽��� ����
		
					}//for end
				
				
			} catch (Exception e) {}
		
//			serverstop();  System.out.println("�����޽��� �ޱ� ���� : " +e); break;
			
				}//while end
				
			} //run end
			
		}; //runnable end
		//��Ƽ������ ���� ��
		
		//�ش� ��Ƽ�����带 ������Ǯ�� �־��ֱ�
		threadpool.submit(runnable);

		
	} //recive end
		
	
	
	//4. ������ �޼��� ���� �޼ҵ�
		//�������� : ������ �޽����� �޾��� ��
	
	public void send (String msg) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				
				try {
					//1. ��� ��Ʈ��
					OutputStream outputStream = socket.getOutputStream();
					//2. ��������
					outputStream.write(msg.getBytes());	
				} catch (Exception e) {  }
				//	serverstop(); System.out.println("���� �޼��� �ޱ� ���� : "+e); 
			}
		}; //���� ��
	
		threadpool.submit(runnable);
	}
		
	}
	///////////////////////////////
	
	
	
		
//	    @FXML
//	    private Button btnserver;

//	    @FXML
//	    private TextArea txtserver;
	    
	    //������ ����� Ŭ���̾�Ʈ�� �����ϴ� ����Ʈ
	    
	    public Vector<Client> clientlist = new Vector<>();
	    	//vector ����ϴ� ���� : ����ȭo
	    		//����ȭ : ���� �����尡 �ϳ��� �޼ҵ� ������ ��� ��� ����
	    
	    
	    
	    //��Ƽ�����带 �������ִ� ������Ǯ
	    public ExecutorService threadpool;
	    	//ExecutorService: ������Ǯ ���� �������̽� [
	    	//�޸� �Ҵ��� ����
	    	
	    
	    //1.���� ���� ����
	    ServerSocket serverSocket;
	    
	    //2.���� ���� �޼ҵ� //�μ��� ip�� port �޾Ƽ� ���� ip�� port�� �������� ���ε�[����]
	   public void serverstart(String ip, int port) {
	    	try {
	    		// 1. �������� �޸� �Ҵ�
	    		serverSocket = new ServerSocket();
	    		// 2. �������� ���ε� [ip �� port ����]
	    		serverSocket.bind(new InetSocketAddress(ip, port)); //�μ��� ����
	    		
	    	} catch (Exception e) {  System.out.println("���� �޼��� �ޱ� ���� : "+e); }
	    		// 3. Ŭ���̾�Ʈ�� ��û ���
	    		// [��Ƽ������ ����ϴ� ���� : Ŭ���̾�Ʈ ����, ������, �ޱ� �����۾�]
	    	
	    	Runnable runnable = new Runnable() {
					//���� �����ͼ� ����Ʈ�� �����ϴ°� ���� ����
				@Override
				public void run() {
					//����ó��
					try { while(true) {
							Socket socket = serverSocket.accept();
							//��û ���� �Ŀ� ������ ������ ����
							
							clientlist.add(new Client(socket)); }
							//������ Ŭ���̾�Ʈ�� ����
							//����� Ŭ���̾�Ʈ ���� �Ŀ� ����Ʈ�� ����
							
					} catch (Exception e) {  }
				}
			}; //��Ƽ������ ���� ��
			//������Ǯ�� �޸� �ʱ�ȭ
			threadpool = Executors.newCachedThreadPool();
				//�޸� �Ҵ�
				//@������ �Ѵ� ��. ������ �� ���� �޸� �Ҵ� �ϴ°� ����
			
			
			//������ ������ ��Ƽ�����带 ������Ǯ�� �־��ֱ�
			threadpool.submit(runnable);	    }
	    
	    
	    
	    
	    //3.���� ���� �޼ҵ�
	    public void serverstop() {
	    	
	    	try {  	//1.���ӵ� ��� Ŭ���̾�Ʈ���� ���� �ݱ�
	    	for( Client clients : clientlist) {
	    		//�� �����ͼ� ������ ������
	    		clients.socket.close();
	    	}
	    	//2. ���� ���� �ݱ�
	    	serverSocket.close();
	    	//3. ������Ǯ �ݱ�
	    	threadpool.shutdown();
	    	
	    	} catch (Exception e) { serverstop();
			System.out.println("���� �޼��� �ޱ� ���� : "+e); }
	    	
	    }
	    
	    

//	    @FXML
//	    void server(ActionEvent event) { //���� ���� ��ư
//	    	if(btnserver.getText().equals("���� ����")) {
//	    		
//	    		//��������
//	    		serverstart(); //�������� �޼ҵ� ȣ��
//	    		
//	    		
//	    		
//	    		//���࿡ ��ư�� �ؽ�Ʈ�� "���� ����" �̸�
//	    			//�ؽ�Ʈ��Ͽ� ���� �߰�
//	    		txtserver.appendText("���� �����մϴ�.");
//	    		//��ư�� �ؽ�Ʈ ����
//	    		btnserver.setText("���� ����");
//	    		
//	    	} else { //���� ��ư�� �ؽ�Ʈ�� "���� ����"�̸�
//	    		
//	    		serverstop(); //�������� �޼ҵ� ȣ��
//	    		
//	    		txtserver.appendText("[������ �����մϴ�.]");
//	    		btnserver.setText("���� ����");
//	    	}
//	    	
//	    }
//
//	    
//		@Override
//		public void initialize(URL arg0, ResourceBundle arg1) {
//			txtserver.setDisable(true); //�ش� fxid ������
//			
//		}

	}


