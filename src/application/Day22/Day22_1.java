package application.Day22;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*java ��� ����
		1. javafx ��ġ
		2. javafx ������Ʈ ����
		3. ������Ʈ �� javafx ���̺귯�� �߰�
		4. ���̺귯�� ���� ����
	*/

public class Day22_1 extends Application {
			//��� �ޱ�
	//1.�������̵�[start : javafx]
	
	@Override
	public void start(Stage stage2) throws Exception {
		// �������� �̸� ����(�ƹ��ų�)
		
		//1. �ź������� ����� ����fxml ��ü�� ��������
		Parent parent = FXMLLoader.load(getClass().getResource("db_test.fxml"));
		//2. �� ��ü�� ���� ������ fxml ��ü�� �־��ش�.
		Scene scene = new Scene(parent);
		//3. �� ��ü�� ���������� ����
		stage2.setScene(scene);
		
		
		//4. �������� ����
		stage2.show();
	}
	
	//2. ���� �޼ҵ� ����
	public static void main(String[] args) {
		launch(args);
	}
	

	
	
	
}
