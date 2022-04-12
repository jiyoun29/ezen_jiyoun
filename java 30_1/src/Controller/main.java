package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class main implements Initializable {
							//@�ʱ�ȣ �����
							//view�� ���� ������ �� �ʱⰪ ���� �޼ҵ� ����
	
	
	public static main instance;
	public main() {
		instance = this;
	}
	
	
	//////////////////////////////////////////
	
    @FXML
    private BorderPane borderpane; //���������� ���� �����̳� ����
    //fx : id
	//import �ʼ�(ctrl space)
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { //�ش� fxml�� ������ �� �ʱⰪ ����
		// TODO Auto-generated method stub
	//	System.out.println("main �䰡 ����(view <-> controller ����)�Ǿ����ϴ�."); //loadpage �޼ҵ� ȣ��� (���ϰ��)
		//1. ȭ����ȯ �޼ҵ�
		loadpage("/view/loginfx.fxml");
	}
	
	
	//�޼ҵ� �����
	public void loadpage(String page) { //loadpage (���ϰ��)
		try {
			//������(fxml) ��üȭ
			Parent parent = FXMLLoader.load(getClass().getResource(page)); //������ ����ó��
			//
			
			borderpane.setCenter(parent); //�����̳�(fxml) ����� �ٸ� ������ �ֱ�
		} catch (Exception e) {System.out.println("������ ���� ����" +e);} //������ �������� ������ ��"�� �߻�
	}
	
	

}
