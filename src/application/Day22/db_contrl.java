package application.Day22;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class db_contrl implements Initializable {
							// Initializable : fxml�� ���� ������ �� �ʱⰪ[ó����] ���� �޼ҵ� ����
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// �ʱⰪ ���� �޼ҵ�
		Day22_2 DB���� = new Day22_2();
		
	}
	
	////////////////////////
	

    @FXML
    private Button btnget;

    @FXML
    private Button btnwrite;

    @FXML
    private TextField textcontent;

    @FXML
    private TextArea txtlist;

    @FXML
    private TextField txtwriter;

    @FXML
    void get(ActionEvent event) {
    	System.out.println("DB�� �����͸� ȣ���մϴ�.");
    	
    	//1.db���� ��ü �����
    	Day22_2 db���� = new Day22_2();
    	//2.db ��ü�� �޼ҵ� ȣ�� �� ����� ����Ʈ�� �ޱ�
    	ArrayList<������> �����͸�� = db����.get();
    	
    	//3.����Ʈ�� ��Ʈ�ѿ� �־��ֱ�
    	for(������ temp : �����͸��) {
    		
    		//fxid.appendText : �ش� ��Ʈ�ѿ� ���� �߰�
    		textcontent.appendText(
    				
    				"��ȣ "+temp.get��ȣ()+
    				"�ۼ��� "+temp.get�ۼ���()+
    				"���� "+temp.get����() + "\n"
    				
    				
    				); //�ش� ��Ʈ�ѿ� �����߰�
     		
    	}
 
    }

    @FXML
    void write(ActionEvent event) {
    	System.out.println("DB�� �����͸� ����մϴ�.");
    	
    	//fxid��.getText(); �ش� ��Ʈ�ѿ� �Էµ� ���� ��������
    	String �ۼ��� = txtwriter.getText();
    	//�ʵ忡�� ����
    	String ���� = textcontent.getText();
    	
    	//1. db���� ��ü �����
    	Day22_2 db���� = new Day22_2();
    	//2. db���� ��ü ������ ���� �޼ҵ�[write] ȣ��
    	    	
    	boolean result = db����.write(�ۼ���, ����);
    	
    	//��� Ȯ��
    	if(result) {
    		System.out.println("db�� ������ ���� ����");
    	
    		//������ ��Ʈ�ѿ� �Էµ� ������ �����ֱ�
    			//fxid��.setText : �ش� ��Ʈ�ѿ� �� �ֱ�
    		txtwriter.setText(""); //������ �Է�â ��������
    		textcontent.setText(""); //������ �Է�â ��������
    	
    	} else { System.out.println("db�� ������ ���� ����"); }
    	
    }

}
