package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerStart extends Application {
	//서버키는거랑 스타트랑 따로
	
	@Override
	public void start(Stage stage) throws Exception {
		
		//처음가져오는것****까먹지말기
		Parent parent = FXMLLoader.load(getClass().getResource("View/server/server.fxml"));
		
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
