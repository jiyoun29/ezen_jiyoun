package Dto;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import Controller.Server;

public class Clients {
	//������ ������ Ŭ���̾�Ʈ�� Ŭ����
	
	//1. �ʵ�[����]
	public Socket socket;
	
	//2.������
	public Clients(Socket socket) {	
		this.socket = socket; 
		
		recive(); //������ ����� Ŭ���̾�Ʈ ��ü�� ������ �� �ޱ� �޼ҵ� ����
	
	}

	
	//3. ������ �޼��� �޴� �޼ҵ�
	public void recive() {

		//��Ƽ������ [Thread Ŭ���� vs Runnable �������̽�]
			//run �޼ҵ带 �ʼ������� �����ؾ���
		//�������̽��� �߻� �޼ҵ尡 �����ϱ� ������ �����ʼ�[Ŭ�������� implements vs �͸�ü]
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() { //�߻� �޼ҵ� ����
				//��������� �޽��� �޴� ����
				
				
			try {
				while(true) {
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
					for( Clients client: Server.clientlist) {
						
						client.send( msg );
						//4������ ����
						//���� �޽����� �ä����� ���ӵ� clientlist ��� Ŭ���̾�Ʈ���� �޽��� ����
						
						
					}//for end
				}//while end
				
			} catch (Exception e) {		}
			
			} //run end
			
		}; //runnable end
		//��Ƽ������ ���� ��
		
		
		//�ش� ��Ƽ�����带 ������Ǯ�� �־��ֱ�
		Server.threadpool.submit(runnable);
		
		
		
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
					
				} catch (Exception e) { }
			}
			
		}; //���� ��
	
		Server.threadpool.submit(runnable);
	}
		
	

} // class end
