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
		//채팅fxml 열렸을때 초기값 메소드
			//채팅방 입장 전에 사용 못하게 막아두기
		txtmsg.setText("채팅창 입장 후 사용 가능");
		
		txtmsg.setEditable(false);//채팅 입력창 수정 금지
		txtcontent.setDisable(false);//채팅창 목록 사용 금지
		btnsend.setDisable(false); //전송버튼 사용 금지
		
	}
	
	
	//1.클라이언트 소켓 선언
	Socket socket;
	
	//2.클라이언트 실행 메소드
	public void clientstart() {
		//멀티 스레드
		Thread thread = new Thread(){
			@Override
			public void run() {
				try {
					socket = new Socket("127.0.0.1",1234); //서버의 ip와 포트번호 넣어주기[서버와 연결]
					
					send(login.member.getMid()+"님 입장했습니다.\n");
					//접속과 동시에 입장메시지 보내기
					
					receive(); //접속과 동시에 받기 메소드는 무한루프
				} catch (Exception e) {	}
			};
		}; //멀티 스레드 구현 끝		
		thread.start(); //멀티 스레드 실행
		
	}

	
	//3.클라이언트 종료 메소드
	public void clientstop() {try { socket.close(); }catch (Exception e) {	} }
	
	
	
	//4.서버에게 메시지 보내기 메소드
	public void send(String msg) {
		Thread thread = new Thread() {
			@Override
			public void run() {
			try {
				OutputStream outputStream = socket.getOutputStream(); //출력 스트림
				outputStream.write(msg.getBytes()); //내보내기
				
				outputStream.flush(); //스트림 초기화[스트림 내 바이트 지우기]
				
			} catch (Exception e) {	}
		}
		
	}; //멀티스레드 구현 끝
		thread.start();
	}
	
	
	
	
	//5. 서버에게 메시지 받기 메소드
	public void receive() {
		try {
			while(true) {
				InputStream inputStream = socket.getInputStream(); //입력 스트림
				byte[] bytes = new byte[1000]; //바이트 배열 선언
				inputStream.read(bytes); //바이트를 읽음
				String msg = new String(bytes); //바이트열->문자열 
				txtcontent.appendText(msg); //입력받은 내용을 채팅창에 추가하기
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
    void send(ActionEvent event) { //전송버튼을 눌렀을때
    	String msg = txtmsg.getText()+"\n"; //보낼 메시지
    	send(msg); //메시지 보내기
    	txtmsg.setText(""); //보내기후 메시지 입력창 지우기
    	txtmsg.requestFocus(); //보내기후 메시지 입력창으로 포커스(커서) 이동
    }//send end
    
    


	@FXML
	void connect(ActionEvent event) {
	   if(btnconnect.getText().equals("입장")) {//만약에 버튼의 텍스트가 "입장" 이면 
   		//클라이언트 실행 메소드	    		    		
	    clientstart();
    		txtcontent.appendText("---[채팅방 입장]---\n");
    		btnconnect.setText("나가기");
    		
    		
    		txtmsg.setText("");
    		
    		txtmsg.setEditable(false);//채팅 입력창 사용가능
    		txtcontent.setDisable(false);//채팅창 목록 사용가능
    		btnsend.setDisable(false); //전송버튼 사용가능
    		
    		txtmsg.requestFocus(); //채팅 입력창으로 포커스[커서] 이동
    		
	    		
	    } else { //아니면
	    		
	    //클라이언트 종료 메소드
	    clientstop();
    		txtcontent.appendText("---[채팅방 퇴장]---\n");
    		btnconnect.setText("입장");
    		

			//채팅방 입장 전에 사용 못하게 막아두기
		txtmsg.setText("채팅창 입장 후 사용 가능");
		
		txtmsg.setEditable(true);//채팅 입력창 수정 금지
		txtcontent.setDisable(true);//채팅창 목록 사용 금지
		btnsend.setDisable(true); //전송버튼 사용 금지
    		
	    	}

	    }
	
	
	
}
