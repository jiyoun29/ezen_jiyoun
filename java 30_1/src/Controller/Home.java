package Controller;

//import java.awt.Button; // x
//import java.awt.Label; // x
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Controller.login.login;
import Dao.MemberDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Home implements Initializable {
	
	
	public static Home home; //객체
	//this:이것,지금... : 현재 클래스의 메모리 호출 (@현재 사용하는 보더팬의 메모리를 home 객체에 넣을 수 있음)
	public Home() {home=this;} //생성자
	
	////////////////
	


	//실행초기 메소드
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//채팅
		loadpage("/view/chatting.fxml");
		
		
		
		loginid.setText(login.member.getMid()+" 님");
		labpoint.setText("포인트 :"+login.member.getMpoint()+"점");
		
		
	}
	
	
	
	@FXML
	private Label loginid;  // 자동완성 하실때 절대 javafx 말고 java.awt 나 swing 사용하면 안됩니다~~
	@FXML
	private Label logout; //
	@FXML
	private Label labpoint;
	@FXML
	private Label delete; //fxid 가져오기
	
	@FXML
	private Label labelinfo;
	
	@FXML
	private Label Lableupdate;
	
	@FXML
	private Label lblboard;
	
	@FXML
	private Label record;
	
	@FXML
	public void accrecord(MouseEvent e) {	loadpage("/View/record.fxml");	}
	
	
	
	@FXML
	private BorderPane borderPane; //이름 home.fxml 이랑 동일하게

	
	//구분을 위한 카테고리
	public static String category;
	
	
	@FXML //남성의류
	private Label lblproduct1;

	@FXML
	public void accproduct1(MouseEvent e) {
		loadpage("/View/product/product.fxml");
		category="남성의류";
	}
	
	
	@FXML //여성의류
	private Label lblproduct2;

	@FXML
	public void accproduct2(MouseEvent e) {
		loadpage("/View/product/product.fxml");
		category="여성의류";		
	}

	
	@FXML //게임기기
	private Label lblproduct3;

	@FXML
	public void accproduct3(MouseEvent e) {
		loadpage("/View/product/product.fxml");
		category="게임기기";		
	}

	
	@FXML //생활용품
	private Label lblproduct4;
	
	@FXML
	public void accproduct4(MouseEvent e) {
		loadpage("/View/product/product.fxml");
		category="생활용품";
	}

	
	
	
	
	
	
	
	
	
	//내가쓴글
	@FXML
	public void accmylist(MouseEvent e) {
		
	}
	
	
	
	
			
	@FXML	//제품
	public void accproduct(MouseEvent e) { loadpage("/view/product/product.fxml"); }
			
			
			
	@FXML	//자유게시판
	public void accboard(MouseEvent e) { loadpage("/view/board/board.fxml"); }




	@FXML //회원정보 이벤트
	public void accInfo(MouseEvent e) {loadpage("/view/home/Info.fxml");}

	
	
	public void loadpage(String page) {
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderPane.setCenter(parent);
		} catch (Exception e) {	 System.out.println(e);	} // 예외처리 결과 출력하면 오류 이유를 알수 있어요~
		
	}
	
	
	
	@FXML //회원수정 이벤트(업데이트)
	public void accupdate(MouseEvent e) {loadpage("/view/home/Info2.fxml");}

	
	
	@FXML //로그아웃 레이블을 클릭 했을 때
	public void logout(MouseEvent e) {
		//1.login 정보 지우기
		login.member = null;
		
		//2.페이지 전환
		main.instance.loadpage("/view/loginfx.fxml");
	}
	
	
	
	
	@FXML //회원탈퇴 레이블을 클릭했을 때
	public void delete(MouseEvent e) {
		//이벤트를 걸었으니 fxml에 적용해야한다.
		
		//1.메시지
		Alert alert = new Alert(AlertType.CONFIRMATION); //확인, 취소 버튼 타입
			alert.setHeaderText("정말 탈퇴 하시겠습니까?");
			
		//2. 버튼 확인 Optional : 클래스 
			Optional<ButtonType> optional = alert.showAndWait();
			//실행
			
			if(optional.get() == ButtonType.OK) {		//확인 버튼을 눌렀을 때
				
				//회원탈퇴진행
			boolean result = MemberDao.memberDao.delete(login.member.getMnum());
			
				if(result) { //탈퇴 성공
					//로그아웃 [ login 클래스 내 member 객체 null값 넣고 수정 ]
					login.member = null;
					
					//페이지 전환
					main.instance.loadpage("/View/loginfx.fxml");
					
				} else {//탈퇴 실패
					}
				}
	}
	
		
	
	
	
	
	
	
}
