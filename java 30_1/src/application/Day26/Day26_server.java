package application.Day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Day26_server { //������Ĺ
	
			//��ſ� ���� ����⸦ �� �� ����
				//1. �������� �����
					// ����: Ŭ���̾�Ʈ���� ������ ���񽺸� �������ִ� ��ǻ��
					//���� : PC���� ��� ������
				//2. �������� ���ε�
					//������ ip�ּҿ� port��ȣ ����
						// *ip: ��� �ν� ��ȣ [ pc�� �ĺ��ϴ� ��ȣ ]
						// *port : pc�� ���μ���(���α׷�) �ĺ��ϴ� ��ȣ ((�̰�.. localhost ���� ��ȣ�ΰ���
						// ip�� 6���� ���� port ��� ����
						// * port : 3306 ��ȣ�� mysql ���α׷����� �����ϴ� ��ȣ

	public static void main(String[] args) {

			//1.�������� �����
		try {
			ServerSocket serverSocket = new ServerSocket();
			//2. �������� ���ε�			//ip �ּ�, port ����
			serverSocket.bind(new InetSocketAddress("127.168.102.50",5000) );
			
			//3. Ŭ���̾�Ʈ�� ��û ���
			while(true) {
			System.out.println("[[������ ���� ������Դϴ�]]");
				//4. ��û�� ���� ��� ����
				Socket socket = serverSocket.accept(); //��������.accept() : ��û����
			//5. ������ ��Ĺ�� ���� Ȯ��
				InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[Ŭ���̾�Ʈ�� ������ �Ǿ����ϴ�. ����� Ŭ���̾�Ʈ ����] :"+socketAddress.getHostName());

			//6.Ŭ���̾�Ʈ���� ������ ����[�ޱ�]�ϱ�
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1000];
			inputStream.read(bytes);
			System.out.println("Ŭ���̾�Ʈ�� ���� �޽��� : "+new String(bytes));
			
			//7.Ŭ���̾�Ʈ���� ������ �۽�[������] �ϱ�
				//������ �Է� �ޱ�
			Scanner scanner = new Scanner(System.in);
			System.out.println("Ŭ���̾�Ʈ���� ���� �޼��� : ");
			String msg = scanner.next();
				//��������(������ ��� ��Ʈ��)
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write(msg.getBytes());
			
			}

		}catch (Exception e) {}


	}


//			������ Ŭ���̾�Ʈ���� ��Ʈ��ũ�� ���� ������ ���񽺸� �����ϴ� ��ǻ�� �ý����̷�....
//			��Ʈ��ũ ������ ��ǻ�� ��Ʈ��ũ�� �����ϴ� ���μ��� �� ����� �������̶�� ��
//			���ε��� ���α׷��� ���� ���� ����� ���� �� �Ǵ� ������Ƽ�� �������� ������
//			��Ʈ�� ���ͳ� �������� ����Ʈ���� ��Ʈ�� � ü�� ��ô��� �������̴�. ��Ʈ��ũ ���񽺳� Ư�� ���μ����� �ĺ��ϴ� ���� �����̴�.
}