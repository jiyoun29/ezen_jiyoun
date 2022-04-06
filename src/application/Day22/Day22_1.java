package application.Day22;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*java 사용 설정
		1. javafx 설치
		2. javafx 프로젝트 생성
		3. 프로젝트 내 javafx 라이브러리 추가
		4. 라이브러리 연결 설정
	*/

public class Day22_1 extends Application {
			//상송 받기
	//1.오버라이딩[start : javafx]
	
	@Override
	public void start(Stage stage2) throws Exception {
		// 스테이지 이름 변경(아무거나)
		
		//1. 신빌더에서 사용한 파일fxml 객체로 가져오기
		Parent parent = FXMLLoader.load(getClass().getResource("db_test.fxml"));
		//2. 신 객체를 만들어서 가져온 fxml 객체를 넣어준다.
		Scene scene = new Scene(parent);
		//3. 씬 객체를 스테이지에 연결
		stage2.setScene(scene);
		
		
		//4. 스테이지 열기
		stage2.show();
	}
	
	//2. 메인 메소드 선언
	public static void main(String[] args) {
		launch(args);
	}
	

	
	
	
}
