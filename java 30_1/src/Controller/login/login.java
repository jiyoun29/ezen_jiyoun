package Controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import Dto.Member;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class login implements Initializable {
	
	//해당 클래스의 메모리를 반환해주는 메소드
	public static login instance;
	
	//login 본인객체;
	//본인객체를 만들고 생성자를 통해서 본인객체에 this를 넣어줌
	public login() { instance = this; }
//		본인객체 = this; //super : 슈퍼클래스(상속) this : 현클래스
//		// this : 현재 클래스 자체 메모리 호출
//	}
//	public static login get본인객체() {
//		return 본인객체;
//	}

	
	//로그인 성공한 회원객체
	public static Member member; //로그인 성공한 객체를 클래스로 부름
	
	
	
	///////////////////////////////////////////
	
	@FXML
    private MediaView mediaview; //fxid
	
    @FXML
    private BorderPane borderpane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//1. 동영상 삽입하기
			//1. 동영상 파일 객체화
		Media media = new Media(getClass().getResource("/img/login.mp4").toString());
			//2. 미디어 플레이어에 미디어 뷰 객체에 동영상 넣기						//문자열 변환
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			//3. 미디어뷰에 미디어플레이어 넣기
			mediaview.setMediaPlayer(mediaPlayer);
			//4. 미디어 시작
			mediaPlayer.play();
			
			
			//*동영상 무한 재생
			mediaPlayer.setOnEndOfMedia(new Runnable() {
											//멀티스레드
				@Override
				public void run() {
					mediaPlayer.seek(Duration.ZERO);
					//미디어의 현재 위치를 처음으로 돌리기
				}
			}); //endpoint를 만났을 때 멀티스레드를 사용하여 seek값을 0으로 돌리는 것
			
			
			loadpage("/view/loginpane.fxml");
		
	}
	
	public void loadpage(String page) {
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent);
			
			
		} catch (Exception e) {
			System.out.println("해당 파일이 없습니다."+e);
		}
	}
	
	
	
	
	
}
