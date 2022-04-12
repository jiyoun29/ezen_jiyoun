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

public class Server  { // fxml 사용하지 않는 클래스 [ 서버 컨트롤 사용 ] 
	//implements Initializable
	
	
	//중첩클래스[Client
		//클래스 안에 클래스가 선언
	public class Client{
///////////////////////////////////
	//서버에 들어오는 클라이언트의 클래스
	
	//1. 필드[소켓]
	public Socket socket;
	
	//2.생성자
	public Client (Socket socket) {
		
		this.socket = socket; 
		
		recive(); 
		}//서버와 연결된 클라이언트 객체가 생성될 때 받기 메소드 실행
	
	//5. 서버로 메세지 받는 메소드
	public void recive() {

		//멀티스레드 [Thread 클래스 vs Runnable 인터페이스]
			//run 메소드를 필수적으로 구현해야함
		//인터페이스는 추상 메소드가 존재하기 때문에 구현필수[클래스에세 implements vs 익명객체]
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() { //추상 메소드 구현
				//계속적으로 메시지 받는 상태
				

				while(true) {
			try {
					//1. 입력스트림 만들기
					InputStream inputStream = socket.getInputStream();

					//2. 바이트 배열선언[스트림은 바이트 단위]
					byte[] bytes = new byte[1000]; 
					
					//3. 입력스트림으로 바이트 읽어오기
					inputStream.read(bytes);
					
					//4. 바이트열 -> 문자열 변환
					String msg = new String(bytes);
					
					//*서버가 받은 메시지를 현재 서버에 접속된 모든 클라이언트에게 받은 메시지 보내기
						//현재 접속된 클라이언트리스트 빼오기
					for( Client client: clientlist) {
						client.send( msg );
						//4번으로 보냄
						//받은 메시지를 ㅓㅅ버에 접속된 clientlist 모든 클라이언트에게 메시지 보냄
		
					}//for end
				
				
			} catch (Exception e) {}
		
//			serverstop();  System.out.println("서버메시지 받기 실패 : " +e); break;
			
				}//while end
				
			} //run end
			
		}; //runnable end
		//멀티스레드 구현 끝
		
		//해당 멀티스레드를 스레드풀에 넣어주기
		threadpool.submit(runnable);

		
	} //recive end
		
	
	
	//4. 서버가 메세지 보는 메소드
		//실행조건 : 서버가 메시지를 받았을 때
	
	public void send (String msg) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				
				try {
					//1. 출력 스트림
					OutputStream outputStream = socket.getOutputStream();
					//2. 내보내기
					outputStream.write(msg.getBytes());	
				} catch (Exception e) {  }
				//	serverstop(); System.out.println("서버 메세지 받기 실패 : "+e); 
			}
		}; //구현 끝
	
		threadpool.submit(runnable);
	}
		
	}
	///////////////////////////////
	
	
	
		
//	    @FXML
//	    private Button btnserver;

//	    @FXML
//	    private TextArea txtserver;
	    
	    //서버에 연결된 클라이언트를 저장하는 리스트
	    
	    public Vector<Client> clientlist = new Vector<>();
	    	//vector 사용하는 이유 : 동기화o
	    		//동기화 : 여러 스레드가 하나의 메소드 접근할 경우 대기 상태
	    
	    
	    
	    //멀티스레드를 관리해주는 스레드풀
	    public ExecutorService threadpool;
	    	//ExecutorService: 스레드풀 구현 인터페이스 [
	    	//메모리 할당이 없음
	    	
	    
	    //1.서버 소켓 선언
	    ServerSocket serverSocket;
	    
	    //2.서버 실행 메소드 //인수로 ip와 port 받아서 받은 ip와 port로 서버소켓 바인딩[생성]
	   public void serverstart(String ip, int port) {
	    	try {
	    		// 1. 서버소켓 메모리 할당
	    		serverSocket = new ServerSocket();
	    		// 2. 서버소켓 바인딩 [ip 와 port 설정]
	    		serverSocket.bind(new InetSocketAddress(ip, port)); //인수로 받음
	    		
	    	} catch (Exception e) {  System.out.println("서버 메세지 받기 실패 : "+e); }
	    		// 3. 클라이언트의 요청 대기
	    		// [멀티스레드 사용하는 이유 : 클라이언트 연결, 보내기, 받기 동시작업]
	    	
	    	Runnable runnable = new Runnable() {
					//소켓 가져와서 리스트에 저장하는게 무한 루프
				@Override
				public void run() {
					//예외처리
					try { while(true) {
							Socket socket = serverSocket.accept();
							//오청 수락 후에 수락된 소켓을 저장
							
							clientlist.add(new Client(socket)); }
							//수락된 클라이언트의 소켓
							//연결된 클라이언트 생성 후에 리스트에 저장
							
					} catch (Exception e) {  }
				}
			}; //멀티스레드 구현 끝
			//스레드풀에 메모리 초기화
			threadpool = Executors.newCachedThreadPool();
				//메모리 할당
				//@실제로 켜는 것. 서버를 켤 때만 메모리 할당 하는게 좋음
			
			
			//위에서 구현된 멀티스레드를 스레드풀에 넣어주기
			threadpool.submit(runnable);	    }
	    
	    
	    
	    
	    //3.서버 종료 메소드
	    public void serverstop() {
	    	
	    	try {  	//1.접속된 모든 클라이언트들의 소켓 닫기
	    	for( Client clients : clientlist) {
	    		//다 꺼내와서 소켓을 가져옴
	    		clients.socket.close();
	    	}
	    	//2. 서버 소켓 닫기
	    	serverSocket.close();
	    	//3. 스레드풀 닫기
	    	threadpool.shutdown();
	    	
	    	} catch (Exception e) { serverstop();
			System.out.println("서버 메세지 받기 실패 : "+e); }
	    	
	    }
	    
	    

//	    @FXML
//	    void server(ActionEvent event) { //서버 실행 버튼
//	    	if(btnserver.getText().equals("서버 실행")) {
//	    		
//	    		//서버실행
//	    		serverstart(); //서버실행 메소드 호출
//	    		
//	    		
//	    		
//	    		//만약에 버튼의 텍스트가 "서버 실행" 이면
//	    			//텍스트목록에 내용 추가
//	    		txtserver.appendText("서버 실행합니다.");
//	    		//버튼의 텍스트 변경
//	    		btnserver.setText("서버 중지");
//	    		
//	    	} else { //만일 버튼의 텍스트가 "서버 중지"이면
//	    		
//	    		serverstop(); //서버중지 메소드 호출
//	    		
//	    		txtserver.appendText("[서버를 중지합니다.]");
//	    		btnserver.setText("서버 실행");
//	    	}
//	    	
//	    }
//
//	    
//		@Override
//		public void initialize(URL arg0, ResourceBundle arg1) {
//			txtserver.setDisable(true); //해당 fxid 사용금지
//			
//		}

	}


