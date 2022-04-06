package Dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Member { //데이터 모델

	private int mnum; // 회원 번호;
	private String mid; //회원 아이디;
	private String mpw; //회원 비밀번호
	private String memail; //이메일
	private String maddress; //주소
	private int mpoint; //포인트
	private String msince; //가입일
	
	
	public Member() {
		// TODO Auto-generated constructor stub
	}


	//생성자
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


	//메소드
	public static void sendmail(String 받는사람이메일, String 내용) {
		
		//네이버 기준으로 진행
		
		//1. 보내는 사람 정보
		String 보내는사람이메일 = "아이디@naver.com";
		String 보내는사람이메일비밀번호 = "비밀번호";
		
		//2. 호스트 정보 [네이버기준 고정코드]
		Properties properties = new Properties(); //컬렉션프레임워크와 동일 [map 컬렉션]
		properties.put("mail.smtp.host", "smtp.naver.com"); //호스트 주소
		properties.put("mail.smtp.port", 587); //호스트 포트 번호
		properties.put("mail.smtp.auth", "true"); //보내는사람이메일 인증
		
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); //보안 연결 버전 설정
		
		
		//3. 인증 [Session : javax.mail 패키지]  // import 할때 다 javax.mail 해주세요~
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(보내는사람이메일, 보내는사람이메일비밀번호);
			}
		});
		
		
		//4. 메일 보내기 //나가는 거라 예외처리
		try {
			MimeMessage message = new MimeMessage(session); //인증
				//mime 프로토콜 : 전자우편 표준 포맷[형식, 아스키코드]
			message.setFrom(new InternetAddress(보내는사람이메일));
			message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(받는사람이메일)); //받는사람이메일
			
			
			//내용
			message.setSubject("안산지역 중고거래 회원님의 패스워드 찾기"); //메일 전송, 파일처리
			message.setText("회원님의 비밀번호 : " + 내용); //위의 내용 가져옴
			//전송
			Transport.send(message);
			
			
			
		} catch (Exception e) {System.out.println("메일전송실패 : "+e);		}
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
