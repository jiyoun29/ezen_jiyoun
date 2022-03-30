package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Day21_2 extends Application { //어플리케이션 클래스로부터 상속 받음

		@Override
		public void start(Stage arg0) throws Exception { //start구현
			
			//fxml 파일 불러오기 : 컨테이너
			Parent parent = FXMLLoader.load(getClass().getResource("test.fxml"));
				//parent : fxml 파일(씬빌더 파일)을 객체화
					//fxmlloader.load(getclass().getresourse("경로/fxml파일명")
			
			//씬 객체 생성 : 컨테이너 넣기
			Scene scene = new Scene(parent);
			
			//스테이지에 씬 넣기
			arg0.setScene(scene);
			
			//스테이지 시작
			arg0.show(); //스테이지 열기
			
			
		}
		public static void main(String[] args) {
			
			launch(args); //start 메소드 호출
			
		}
}
