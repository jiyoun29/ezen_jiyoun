package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		//5. �����̳� �ҷ�����
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		
		//6.�� ��ü -> �����̳�
		Scene scene = new Scene(parent);
		//7. �� ->��������
		stage.setScene(scene);
		
		
		//3. �������� �ΰ� ����
			//1. �̹��� �ҷ�����
		Image image = new Image("/img/stagelogo.png"); //�̹��� ��üȭ
			//���� ��� vs ��� ���
			//��� ��� : �� ��ġ ���� ���
		//�����:C:\Users\504\Desktop\lynk\java 30_1\src\img
		//�����:����ġ[������Ʈ src] ���� ���
			//���� [src��������] /img/stagelogo.
		
		//�������� ����
			stage.getIcons().add(image);
			stage.setResizable(false); //������ ���� �Ұ�
		
		stage.setTitle("��������"); // 2. �������� â �̸�
		stage.show(); // 1. �������� ����
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
