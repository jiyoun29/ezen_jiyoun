package application.Day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Day26_client {

	//������ ����� ������
	
	public static void main(String[] args) {
		
		//1. ���� �����
		Socket socket = new Socket();
		
		//����ó��
		try {
		
		//2.������������ �����ϱ�
		while(true) { //���������� ip�� port ��ȣ �־��ֱ�
			socket.connect(new InetSocketAddress("127.168.102.50",5000));
			//ip��ȣ�� port��ȣ�� �����ؼ� ���� Ŀ��Ʈ�� �ɾ��� �� ����
			System.out.println("������ ���� �Ǿ����ϴ�.");

		//3. �������� ������ �۽��ϱ�[������]
			Scanner scanner = new Scanner(System.in);
			//��Ʈ���� �̿��� �ܺ� ��Ʈ��ũ ���
			
			//1. ������ �Է¹ޱ�
			System.out.println("�������� ���� �޼��� : ");
			String msg = scanner.nextLine();
			//2. ������ ��� ��Ʈ��(��Ŵ���:����Ʈ) ��������
			OutputStream outputStream = socket.getOutputStream();
										//���Ͽ� �ִ� ��Ʈ�� ��������
			//3. ��������[���ڿ� -> ����Ʈ��]
			outputStream.write(msg.getBytes());
			
			//4.�������� ������ ����[�ޱ�[�ϱ�]
				//������ �Է� ��Ʈ��
			InputStream inputStream = socket.getInputStream();
			//����Ʈ�迭 ����
			byte[] bytes = new byte[1000];
				//�Է� ��Ʈ�����κ��� ����Ʈ ��������
			inputStream.read(bytes);
			System.out.println("������ ���� �޽��� : "+new String(bytes));
			
			}
		} catch (Exception e) { }
		
		
	}
	
	
}
