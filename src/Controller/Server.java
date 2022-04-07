package Controller;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Dto.Clients;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Server implements Initializable {

		
	    @FXML
	    private Button btnserver;

	    @FXML
	    private TextArea txtserver;
	    
	    //서버에 연결된 클라이언트를 저장하는 리스트
	    
	    public static Vector<Clients> clientlist = new Vector<>();
	    	//vector 사용하는 이유 : 동기화o
	    		//동기화 : 여러 스레드가 하나의 메소드 접근할 경우 대기 상태
	    
	    
	    
	    //멀티스레드를 관리해주는 스레드풀
	    public static ExecutorService threadpool;
	    	//ExecutorService: 스레드풀 구현 인터페이스 [
	    	//메모리 할당이 없음
	    	
	    
	    //1.서버 소켓 선언
	    ServerSocket serverSocket;
	    
	    //2.서버 실행 메소드
	    public void serverstart() {
	    	try {
	    		// 1. 서버소켓 메모리 할당
	    		serverSocket = new ServerSocket();
	    		// 2. 서버소켓 바인딩 [ip 와 port 설정]
	    		serverSocket.bind(new InetSocketAddress("127.0.0.1", 1234));
	    		
	    	} catch (Exception e) { }
	    		// 3. 클라이언트의 요청 대기
	    		// [멀티스레드 사용하는 이유 : 클라이언트 연결, 보내기, 받기 동시작업]
	    	
	    	Runnable runnable = new Runnable() {
					//소켓 가져와서 리스트에 저장하는게 무한 루프
				@Override
				public void run() {
					//예외처리
					try {
				
						while(true) {
							Socket socket = serverSocket.accept();
							//오청 수락 후에 수락된 소켓을 저장
							
							clientlist.add(new Clients(socket));
							//수락된 클라이언트의 소켓
							//연결된 클라이언트 생성 후에 리스트에 저장
							
						}
						
					} catch (Exception e) { }
					
				}
			}; //멀티스레드 구현 끝
			//스레드풀에 메모리 초기화
			threadpool = Executors.newCachedThreadPool();
				//메모리 할당
				//@실제로 켜는 것. 서버를 켤 때만 메모리 할당 하는게 좋음
			
			
			//위에서 구현된 멀티스레드를 스레드풀에 넣어주기
			threadpool.submit(runnable);
	    	
	    	
	    }
	    
	    
	    
	    
	    //3.서버 종료 메소드
	    public void serverstop() {
	    	
	    	try {
	    	//1.접속된 모든 클라이언트들의 소켓 닫기
	    	for( Clients clients : clientlist) {
	    		//다 꺼내와서 소켓을 가져옴
	    		clients.socket.close();
	    	}
	    	//2. 서버 소켓 닫기
	    	serverSocket.close();
	    	//3. 스레드풀 닫기
	    	threadpool.shutdown();
	    	
	    	} catch (Exception e) {}
	    	
	    }
	    
	    
	    

	    @FXML
	    void server(ActionEvent event) { //서버 실행 버튼
	    	if(btnserver.getText().equals("서버 실행")) {
	    		
	    		//서버실행
	    		serverstart(); //서버실행 메소드 호출
	    		
	    		
	    		
	    		//만약에 버튼의 텍스트가 "서버 실행" 이면
	    			//텍스트목록에 내용 추가
	    		txtserver.appendText("서버 실행합니다.");
	    		//버튼의 텍스트 변경
	    		btnserver.setText("서버 중지");
	    		
	    	} else { //만일 버튼의 텍스트가 "서버 중지"이면
	    		
	    		serverstop(); //서버중지 메소드 호출
	    		
	    		txtserver.appendText("[서버를 중지합니다.]");
	    		btnserver.setText("서버 실행");
	    	}
	    	
	    }

	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			txtserver.setDisable(true); //해당 fxid 사용금지
			
		}

}
