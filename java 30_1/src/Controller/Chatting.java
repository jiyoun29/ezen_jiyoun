package Controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.login.login;
import Dao.roomDao;
import Dto.Roomlive;
import Dto.room;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;

public class Chatting implements Initializable {


	@FXML
	private TableView<room> roomtable;

	@FXML
	private TextField txtroomname;

	@FXML
	private Button btnadd;

	@FXML
	private Label lblselect;

	@FXML
	private TextArea txtmidlist;
	
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
	

	////////////////////////////////////////////////////////
	

	
	//서버소켓 생성[모든 메소드에서 사용]
	public Server server;  

	public static room selectroom; //테이블뷰에서 선택된 방 객체
		//static으로 해서 start 클래스 에서도 사용
	
	
	
	//1명이 나가면 채팅방이 폭파되는것 : (1)리스트를 리무브하거나, (2)catch 안에 있는 걸 지운다.
		//server.clientlist.romove(socket);
		//방 나갈때 서버소켓 내 접속된 소켓 리스트에서 소켓 제거(1번 방법)
	
	
	public void Show() { // 사용되는 곳 [ initialize , add 메소드 ]
		//1. db에서 모든 방 목록 가져오기
		ObservableList<room> roomlist =
				roomDao.roomDao.roomList();
		//룸리스트 하나 빼옴
		
		//2. 테이블뷰의 첫번째 필드를 가져와서 방번호 필드로 설정
		TableColumn tc = roomtable.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("ronum"));
		
		//3. 테이블뷰의 두번째 필드를 가져와서 방이름 필드를 설정
		tc = roomtable.getColumns().get(1);
		tc.setCellFactory(new PropertyValueFactory<>("roname"));
		
		//4. 테이블뷰의 세번째 필드를 가져와서 방인원 필드로 설정
		tc = roomtable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("mcount"));
		
		//5. 테이블뷰에 리스트 넣어주기
		roomtable.setItems(roomlist);
		
		//6. 해당 테이블뷰를 클릭했을 때	//람다식
		roomtable.setOnMouseClicked(e -> {
			//원하는 실행코드
			
			//7. 클릭된 객체 가져오기
				roomtable.getSelectionModel().getSelectedItem();
			//8. 레이블에 표시되는 방 ***
				lblselect.setText("현재 선택된 방 : "+selectroom.getRoname());
			//9. 접속 버튼 활성화 ***
			btnconnect.setDisable(false);
			
		});
		
	}
	
	
	
	@FXML
	void add(ActionEvent event) { //방개설 버튼을 눌렀을 때
			//1. 방이름을 입력받음
		String roomname = txtroomname.getText();
		
			
		if(roomname.length() < 4) { //방이름이 4글자 미만이면 방개설 실패

    		txtroomname.setText("");// 개설후 방이름 입력창 공백 처리
    		
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("방 개설 실패");
			alert.showAndWait();
			return; } //알림 띄우기
		
			//2. 방 객체
		room room = new room(0, roomname, "127.0.0.1", 0);
		
			//3. db 처리
		roomDao.roomDao.roomadd(room);
		
			//4. 해당 방 서버 실행
		server = new Server();// 메모리할당
		// **서버 실행 [ 인수로 ip 와 port=방번호 넘기기 ]
		server.serverstart(room.getRoip(), roomDao.roomDao.getroomnum());
		
		txtroomname.setText(""); //개설 후 방이름 입력창 공백 처리
		
		Show(); //테이블 새로고침
		
		//알람 띄우기
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("방 개설이 되었습니다.\n방번호: "+ roomDao.roomDao.getroomnum());
			alert.showAndWait();

	    }

	
//////
    
    public void midshow() { //msg 메소드 : 입력창에서 엔터 쳤을 때/send 메소드 : 전송버튼 눌렀을 때

    	//1. 테이블뷰에서 선택된 방 번호의 접속된 회원명단 가져오기
    	ArrayList<Roomlive> roomlivelist 
			= roomDao.roomDao.getRoomlivelist( selectroom.getRonum() );
    	//@모든 룸리스트 가져옴.
    		//@테이블뷰를 쓸 때에는 옵저버리스트지만 그 외에는 더 편한 어레이리스트를 사용해서 디비를 꺼내온다.
    	
    		//객체를 하나씩 빼와서
    	txtmidlist.setText(""); //2. 명단 초기화

    	//사용
    	int i = 1; 
		for( Roomlive temp : roomlivelist ) {
			txtmidlist.appendText( i +"번 "+ temp.getMid() +"\n");
			i++;
		}
    }
	////
	
	
	@FXML
	void msg(ActionEvent event) { //입력창에서 입력 후 엔터를 눌렀을 때
		
		String msg = login.member.getMid()+" : "+txtmsg.getText()+"\n";
		send(msg);
		txtmsg.setText("");
		txtmsg.requestFocus(); //포커스=커서 움직이기
		
//		ArrayList<Roomlive> roomlivelist
//			= roomDao.roomDao.getRoomlivelist(selectroom.getRonum());
//		
//		txtmidlist.setText("");
		
		midshow();		}
//		int i = 1;
//		for(Roomlive temp : roomlivelist) {
//			
//			txtmidlist.appendText(i+"번 "+temp.getMid() + "\n");
//			i++;

		
		
	    
	
	//msg와 send 동일하게
	
	
    @FXML
    void send(ActionEvent event) { //전송버튼을 눌렀을때
    	String msg = login.member.getMid()+" : "+txtmsg.getText()+"\n"; //보낼 메시지
    	send(msg); //메시지 보내기
    	txtmsg.setText(""); //보내기후 메시지 입력창 지우기
    	txtmsg.requestFocus(); //보내기후 메시지 입력창으로 포커스(커서) 이동
    	

//		ArrayList<Roomlive> roomlivelist
//			= roomDao.roomDao.getRoomlivelist(selectroom.getRonum());
//		
//		txtmidlist.setText("");
		
		midshow();

//		int i = 1;
//		for(Roomlive temp : roomlivelist) {
//			
//			txtmidlist.appendText(i+"번 "+temp.getMid() + "\n");
//			i++; }
			
    }//send end
    
	
	
	
//////////////////////////////////////////////////////////////////

	

    Socket socket;   // 1. 클라이언트 소켓 선언 
    
    
    

    // 2. 클라이언트 실행 메소드
    public void clientstart(String ip, int port) {
    	Thread thread = new Thread() { // 멀티스레드 
    		@Override
    		public void run() {
    			try {
    				socket = new Socket(ip,port); // 서버의 ip와 포트번호 넣어주기 [ 서버와 연결 ]
    				send( login.member.getMid()+"님 입장했습니다\n"); // 접속과 동시에 입장메시지 보내기 
    				receive(); // 접속과 동시에 받기 메소드는 무한루프
    			}catch(Exception e ) { } //clientstop(); System.out.println("오류="+e);
    		};
    	};// 멀티스레드 구현 끝
    	thread.start(); // 멀티스레드 실행
    }
    
    
    // 3. 클라이언트 종료 메소드 
    public void clientstop() {  try{ socket.close(); }
    catch(Exception e ) {} }
	
	
	

    // 4. 서버에게 메시지 보내기 메소드 
    public void send( String msg ) {
    	Thread thread = new Thread() { 
    		@Override
    		public void run() {
    			try {
    				OutputStream outputStream = socket.getOutputStream(); // 1. 출력 스트림
    				outputStream.write( msg.getBytes() ); // 2. 내보내기
    				outputStream.flush(); // 3. 스트림 초기화 [ 스트림 내 바이트 지우기 ]
    			}catch( Exception e ) { } 
    		}
    	};// 멀티스레드 구현 끝 
    	thread.start();
    }
    
    
    
    // 5. 서버에게 메시지 받기 메소드 
    public void receive() {
    	
    	while(true) { //위치 주의할것
    		
    		try {

	    		InputStream inputStream = socket.getInputStream(); // 1. 입력 스트림
	    		byte[] bytes = new byte[1000]; 	// 2. 바이트배열 선언 
	    		inputStream.read(bytes);		// 3. 읽어오기 
	    		String msg = new String(bytes);	// 4. 바이트열 -> 문자열 변환
	    		txtcontent.appendText(msg); 	// 4. 받은 문자열을 메시지창에 띄우기 

    	}catch( Exception e ) {	} //clientstop(); System.out.println("오류="+e); break; 
    		
    	}
    }

    

	@FXML
	void connect(ActionEvent event) { //접속버튼을 눌렀을 때
	   if(btnconnect.getText().equals("입장")) {//만약에 버튼의 텍스트가 "입장" 이면 
   		//클라이언트 실행 메소드	    		    		
		   //ip와 port를 클라이언트 실행 메소드로 넣음
	  clientstart(selectroom.getRoip(), selectroom.getRonum()); //포트 대신 넣음
	  
	  //현재 방 접속명단 추가
	  Roomlive roomlive = new Roomlive(0, selectroom.getRonum(),
			  					login.member.getMid());
	  //db처리
	  roomDao.roomDao.addroomlive(roomlive);
	  
	  
	  ///////////
    		txtcontent.appendText("---[채팅방 입장]---\n");
    		btnconnect.setText("나가기");
    		
    		
    		txtmsg.setText("");
    		
    		txtmsg.setEditable(false);//채팅 입력창 사용가능
    		txtcontent.setDisable(false);//채팅창 목록 사용가능
    		btnsend.setDisable(false); //전송버튼 사용가능
    		
    		txtmsg.requestFocus(); //채팅 입력창으로 포커스[커서] 이동
    		
    		txtroomname.setDisable(true); //채팅방 이름 입력창 사용 금지
    		btnadd.setDisable(true); //채팅 개설 버튼 사용 금지
    		roomtable.setDisable(true); //채팅방 목록 사용 금지
    		
    		
	    		
	    } else { clientstop(); //클라이언트 종료 메소드
	    
    		txtcontent.appendText("---[채팅방 퇴장]---\n");
    		btnconnect.setText("입장");
    		

			//채팅방 입장 전에 사용 못하게 막아두기
		txtmsg.setText("채팅창 입장 후 사용 가능");
		
		txtmsg.setEditable(true);//채팅 입력창 수정 금지
		txtcontent.setDisable(true);//채팅창 목록 사용 금지
		btnsend.setDisable(true); //전송버튼 사용 금지
		btnconnect.setDisable(true);
		
		txtroomname.setDisable(false);
		btnadd.setDisable(false);
		roomtable.setDisable(false);
		
		/*1.방 접속 명단에서 제외[삭제]하기
			2.만약에 방 접속 명단이 0명이면 방삭제
				2-1.만일 방이 삭제되면 서버소켓 종료
			3.서버소켓 종료
			* 테이블 뷰에서 선택된 방 객체 초기화
			* 선택된 방 레이블 초기화
		*/
		//1번
		roomDao.roomDao.roomlivedelete(login.member.getMid());
		
		//2-1.코드
		boolean result = roomDao.roomDao.roomlivedelete(selectroom.getRoname());
		System.out.println(result);
		if(result) { server.serverstop(); }
		
		//테이블 뷰에서 선택된 방 객체 초기화
		selectroom = null;
		//선택된 방 레이블 초기화
		lblselect.setText("현재 선택된 방 : ");
		
		Show(); //방목록 테이블 새로고침
		// 방 나갈때 서버소켓내 접속된 소켓 리스트에서 소켓 제거 
	    	}

	    }
	
	

	 @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	    	// 채팅fxml 열렸을때 초기값 메소드  	// * 채팅방 입장전에 아래 fxid를 사용못하게 금지 
	    	txtmsg.setText("채팅방 입장후 사용가능");
	    	txtmsg.setDisable(true); 		// 채팅입력창 사용금지 
	    	txtcontent.setDisable(true); 	// 채팅창 목록 사용금지
	    	btnsend.setDisable(true); 		// 전송버튼 사용금지
	    	btnconnect.setDisable(true); 	// 입장버튼 사용금지
	    	txtmidlist.setDisable(true);  	// 방접속회원 목록 사용금지 
	    
	    	Thread thread = new Thread() { // 채팅방 목록 실시간 화면 처리
				@Override
				public void run() {
					while( true ) { 
						try { Show();
							Thread.sleep(1000);
						}catch( Exception e ) {} 
					}
				}
			}; 
			thread.start();
	    }
	
	
}
