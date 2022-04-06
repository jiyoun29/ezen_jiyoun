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
	
	//�ش� Ŭ������ �޸𸮸� ��ȯ���ִ� �޼ҵ�
	public static login instance;
	
	//login ���ΰ�ü;
	//���ΰ�ü�� ����� �����ڸ� ���ؼ� ���ΰ�ü�� this�� �־���
	public login() { instance = this; }
//		���ΰ�ü = this; //super : ����Ŭ����(���) this : ��Ŭ����
//		// this : ���� Ŭ���� ��ü �޸� ȣ��
//	}
//	public static login get���ΰ�ü() {
//		return ���ΰ�ü;
//	}

	
	//�α��� ������ ȸ����ü
	public static Member member; //�α��� ������ ��ü�� Ŭ������ �θ�
	
	
	
	///////////////////////////////////////////
	
	@FXML
    private MediaView mediaview; //fxid
	
    @FXML
    private BorderPane borderpane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//1. ������ �����ϱ�
			//1. ������ ���� ��üȭ
		Media media = new Media(getClass().getResource("/img/login.mp4").toString());
			//2. �̵�� �÷��̾ �̵�� �� ��ü�� ������ �ֱ�						//���ڿ� ��ȯ
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			//3. �̵��信 �̵���÷��̾� �ֱ�
			mediaview.setMediaPlayer(mediaPlayer);
			//4. �̵�� ����
			mediaPlayer.play();
			
			
			//*������ ���� ���
			mediaPlayer.setOnEndOfMedia(new Runnable() {
											//��Ƽ������
				@Override
				public void run() {
					mediaPlayer.seek(Duration.ZERO);
					//�̵���� ���� ��ġ�� ó������ ������
				}
			}); //endpoint�� ������ �� ��Ƽ�����带 ����Ͽ� seek���� 0���� ������ ��
			
			
			loadpage("/view/loginpane.fxml");
		
	}
	
	public void loadpage(String page) {
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent);
			
			
		} catch (Exception e) {
			System.out.println("�ش� ������ �����ϴ�."+e);
		}
	}
	
	
	
	
	
}
