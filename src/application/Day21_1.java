package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Day21_1 extends Application {
					//extends : 상속 [JAVAFX GUI 관련클래스]
					//상속받으면 슈퍼클래스 내 멤버를 사용할 수 있다.
	//오류 ㅣ The type Day21_1 must implement the inherited abstract method Application.start(Stage)
		//구현 필요
	
	//Ctrl space START
	@Override
	public void start(Stage stage) throws Exception {
		//javafx를 실행하는 메소드[추상 -> 구현]
			//Start Stage 스테이지이름(아무거나)
		
		//stage = 창 scean = 장면 컨테이너 =vbox...등
		
		//1.컨테이너 만들기 [여러개 컨트롤을 세로로 저장]
		VBox box = new VBox();
			//2. 컨트롤 만들기(버튼 만들기)
			Button button = new Button();
			button.setText("닫기");
			button.setOnAction(e -> Platform.exit() ); //닫기 누르면 꺼지게 만듦
							// 값 -> 람다식 (이름이 없는 메소드)
				//3. 컨테이너에 컨트롤 삽입
			box.getChildren().add(button);
					//4. 씬 객체 만들어서 씬(컨테이너)
					Scene scene = new Scene(box , 500, 500); //500은 사이즈. 컨테이너 이름 / 가로사이즈 / 세로사이즈
						//5. 스테이지에 씬 넣기
							stage.setScene(scene);
							stage.show(); //스테이지 열기
							
			//순서 : 스테이지 -> 씬 -> 컨테이너 -> 여러개의 컨트롤(버튼, 입력상자, 표 등)
	}
	
	public static void main(String[] args) { //메인스레드 가져오기
		launch(args); //start 메소드 호출
		
		
///////////////////////////////////////////		
	}
}
