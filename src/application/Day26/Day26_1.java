package application.Day26;

import java.net.InetAddress;

public class Day26_1 {

	/*��Ʈ��ũ : �� �� �̻��� ��ǻ�͵��� ��Ÿ��� ���� �����ϰ� ����� �� �ִ� ��
		��Ÿ� : ���ڽ�ȣ�� ���� ����ϴ� ��� ��Ⱑ ���� ����ϱ� ���� �ϳ��� ��
			�������� : ��ǻ�ͳ���/��ǻ�� ���� ������ ��ȯ ����� �����ϴ� ��Ģ[ü��]
				SMTP : ���� ���� ��������
				IP : ���ͳ� ��������
	
	TCP/IP
		TCP : Transmission Control Protocol : ��� ����
		IP : Internet Protocol address : ��� �ν� ��ȣ[�ּ�-PC �ּ�-���ּ�] : 0.0.0.0 ~ 255.255.255.255
				�츮�� <--����--> ģ����
							ģ������ �ּ�
				�� ��ǻ�� <----> ���̹� ��ǻ��[Ȩ������]
							www.naver.com [������ �ּ� : �����̱� ������ �ܿ�� ����]	
							223.130.195.200 [ ip�ּ� : �����̱� ������ �ܿ�� ����.]
							
	*/
	
	public static void main(String[] args) {
		
		//1. ���� pc�� ip �ּ� Ȯ��
			//������->cmd->ipconfig - > ip ���� Ȯ�� ����
		   //ipconfig �Է½� ��Ʈ��ũ(ip) ������ �� �� �ִ�.
		//2. �ڹٿ��� ip�ּ� Ȯ��
		
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
				//Inet4Address ��Ʈ��ũ ������ �����ϴ� Ŭ����
				//Inet4Address.getLocalHost(); �ڹٿ� ����� ��� �Ϲݿ��� �߻�(try�ʼ�)
							//get: ����(��pc)�� ���� ȣ��
			System.out.println("���� pc�� ��Ʈ��ũ ��ü : "+inetAddress);
			System.out.println("���� pc�� �̸� :"+inetAddress.getHostName());
			System.out.println("���� pc�� ip�ּ� :"+inetAddress.getHostAddress());
			
			
		//3.���̹� ȸ�翡 ip �ּ� Ȯ��
			InetAddress inetAddress2 = InetAddress.getByName("www.naver.com");
			System.out.println("���̹� pc�� ���� ��ü : "+inetAddress2);
			System.out.println("���̹� pc�� �̸� : "+inetAddress2.getHostName());
			System.out.println("���̹� pc�� ip �ּ� : "+inetAddress2.getHostAddress());
			
			
		//4. ���̽��� ȸ�翡 ip �ּ� Ȯ��
			InetAddress inetAddress3 = InetAddress.getByName("www.facebook.com");
			System.out.println("���̽��� pc�� ���� ��ü : "+inetAddress3);
			System.out.println("���̽��� pc�� �̸� : "+inetAddress3.getHostName());
			System.out.println("���̽��� pc�� ip �ּ� : "+inetAddress3.getHostAddress());
			
			
		} catch (Exception e) {		}
		
		
		
	}
	
}
