package App;



import Controller.Chatting;
import Controller.login.login;
import Dao.roomDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Start extends Application {
	
	
	
	@Override
	public void start(Stage stage) throws Exception {
		//5. 컨테이너 불러오기
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		
		//6.씬 객체 -> 컨테이너
		Scene scene = new Scene(parent);
		//7. 씬 ->스테이지
		stage.setScene(scene);
		
		
		//3. 스테이지 로고 설정
			//1. 이미지 불러오기
		Image image = new Image("/img/logo.png"); //이미지 객체화
			//절대 경로 vs 상대 경로
			//모든 경로 : 현 위치 기준 경로
		//모든경로:C:\Users\504\Desktop\lynk\java 30_1\src\img
		//상대경로:현위치[프로젝트 src] 기준 경로
			//생략 [src폴더부터] /img/stagelogo.
		
		
		//*외부폰트 적용
			//1. 폰트 가져오기
		Font.loadFont(getClass().getResourceAsStream("SANGJU Gotgam.ttf"), 13);
			//2. 외부 스타일시트 적용
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	
		
		
		/////////
		
		//stage = 윈도우 창에 x 버튼을 눌렀을 때
		stage.setOnCloseRequest(e ->{
			//만약 로그인이 되어있으면
			if(login.member != null) { //null이면 로그인 안 했다는 것
				//1. 방 접속명단 삭제
				roomDao.roomDao.roomlivedelete(login.member.getMid());
											//로그인된 멤버의 아이디 가져오기
				
				//2. 방 삭제
				if(Chatting.selectroom != null) {
					//만약에 방에 접속 되어 있는 상태이면
					roomDao.roomDao.roomdelete(Chatting.selectroom.getRonum());
				}							//채팅에 내가 선택한 방의 방 번호 넣어주기
				
				//3. 선택 방 초기화
				Chatting.selectroom = null;
				
			}
			
		});
		
		
		
		
		//////////
		
		
		//스테이지 설정
			stage.getIcons().add(image);
			stage.setResizable(false); //사이즈 조정 불가
		
		stage.setTitle("이젠마켓"); // 2. 스테이지 창 이름
		stage.show(); // 1. 스테이지 열기
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
