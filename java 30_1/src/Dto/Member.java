package Dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Member { //������ ��

	private int mnum; // ȸ�� ��ȣ;
	private String mid; //ȸ�� ���̵�;
	private String mpw; //ȸ�� ��й�ȣ
	private String memail; //�̸���
	private String maddress; //�ּ�
	private int mpoint; //����Ʈ
	private String msince; //������
	
	
	public Member() {
		// TODO Auto-generated constructor stub
	}


	//������
	public Member(int mnum, String mid, String mpw, String memail, String maddress, int mpoint, String msince) {
		super();
		this.mnum = mnum;
		this.mid = mid;
		this.mpw = mpw;
		this.memail = memail;
		this.maddress = maddress;
		this.mpoint = mpoint;
		this.msince = msince;
	}


	//�޼ҵ�
	public static void sendmail(String �޴»���̸���, String ����) {
		
		//���̹� �������� ����
		
		//1. ������ ��� ����
		String �����»���̸��� = "���̵�@naver.com";
		String �����»���̸��Ϻ�й�ȣ = "��й�ȣ";
		
		//2. ȣ��Ʈ ���� [���̹����� �����ڵ�]
		Properties properties = new Properties(); //�÷��������ӿ�ũ�� ���� [map �÷���]
		properties.put("mail.smtp.host", "smtp.naver.com"); //ȣ��Ʈ �ּ�
		properties.put("mail.smtp.port", 587); //ȣ��Ʈ ��Ʈ ��ȣ
		properties.put("mail.smtp.auth", "true"); //�����»���̸��� ����
		
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); //���� ���� ���� ����
		
		
		//3. ���� [Session : javax.mail ��Ű��]  // import �Ҷ� �� javax.mail ���ּ���~
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(�����»���̸���, �����»���̸��Ϻ�й�ȣ);
			}
		});
		
		
		//4. ���� ������ //������ �Ŷ� ����ó��
		try {
			MimeMessage message = new MimeMessage(session); //����
				//mime �������� : ���ڿ��� ǥ�� ����[����, �ƽ�Ű�ڵ�]
			message.setFrom(new InternetAddress(�����»���̸���));
			message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(�޴»���̸���)); //�޴»���̸���
			
			
			//����
			message.setSubject("�Ȼ����� �߰�ŷ� ȸ������ �н����� ã��"); //���� ����, ����ó��
			message.setText("ȸ������ ��й�ȣ : " + ����); //���� ���� ������
			//����
			Transport.send(message);
			
			
			
		} catch (Exception e) {System.out.println("�������۽��� : "+e);		}
	}
	
	
	
	
	
	
	
	
	
	
	//////////////////////////////////
	public int getMnum() {
		return mnum;
	}


	public void setMnum(int mnum) {
		this.mnum = mnum;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getMpw() {
		return mpw;
	}


	public void setMpw(String mpw) {
		this.mpw = mpw;
	}


	public String getMemail() {
		return memail;
	}


	public void setMemail(String memail) {
		this.memail = memail;
	}


	public String getMaddress() {
		return maddress;
	}


	public void setMadress(String maddress) {
		this.maddress = maddress;
	}


	public int getMpoint() {
		return mpoint;
	}


	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}


	public String getMsince() {
		return msince;
	}


	public void setMcince(String msince) {
		this.msince = msince;
	}
	
	
	
	
	
	
}
