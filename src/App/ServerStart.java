package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerStart extends Application {
	//����Ű�°Ŷ� ��ŸƮ�� ����
	
	@Override
	public void start(Stage stage) throws Exception {
		
		//ó���������°�****���������
		Parent parent = FXMLLoader.load(getClass().getResource("View/server/server.fxml"));
		
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
