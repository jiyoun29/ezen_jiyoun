package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Day21_2 extends Application { //���ø����̼� Ŭ�����κ��� ��� ����

		@Override
		public void start(Stage arg0) throws Exception { //start����
			
			//fxml ���� �ҷ����� : �����̳�
			Parent parent = FXMLLoader.load(getClass().getResource("test.fxml"));
				//parent : fxml ����(������ ����)�� ��üȭ
					//fxmlloader.load(getclass().getresourse("���/fxml���ϸ�")
			
			//�� ��ü ���� : �����̳� �ֱ�
			Scene scene = new Scene(parent);
			
			//���������� �� �ֱ�
			arg0.setScene(scene);
			
			//�������� ����
			arg0.show(); //�������� ����
			
			
		}
		public static void main(String[] args) {
			
			launch(args); //start �޼ҵ� ȣ��
			
		}
}
