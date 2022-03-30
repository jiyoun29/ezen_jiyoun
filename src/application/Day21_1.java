package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Day21_1 extends Application {
					//extends : ��� [JAVAFX GUI ����Ŭ����]
					//��ӹ����� ����Ŭ���� �� ����� ����� �� �ִ�.
	//���� �� The type Day21_1 must implement the inherited abstract method Application.start(Stage)
		//���� �ʿ�
	
	//Ctrl space START
	@Override
	public void start(Stage stage) throws Exception {
		//javafx�� �����ϴ� �޼ҵ�[�߻� -> ����]
			//Start Stage ���������̸�(�ƹ��ų�)
		
		//stage = â scean = ��� �����̳� =vbox...��
		
		//1.�����̳� ����� [������ ��Ʈ���� ���η� ����]
		VBox box = new VBox();
			//2. ��Ʈ�� �����(��ư �����)
			Button button = new Button();
			button.setText("�ݱ�");
			button.setOnAction(e -> Platform.exit() ); //�ݱ� ������ ������ ����
							// �� -> ���ٽ� (�̸��� ���� �޼ҵ�)
				//3. �����̳ʿ� ��Ʈ�� ����
			box.getChildren().add(button);
					//4. �� ��ü ���� ��(�����̳�)
					Scene scene = new Scene(box , 500, 500); //500�� ������. �����̳� �̸� / ���λ����� / ���λ�����
						//5. ���������� �� �ֱ�
							stage.setScene(scene);
							stage.show(); //�������� ����
							
			//���� : �������� -> �� -> �����̳� -> �������� ��Ʈ��(��ư, �Է»���, ǥ ��)
	}
	
	public static void main(String[] args) { //���ν����� ��������
		launch(args); //start �޼ҵ� ȣ��
		
		
///////////////////////////////////////////		
	}
}
