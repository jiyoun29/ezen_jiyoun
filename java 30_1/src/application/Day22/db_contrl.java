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
							// Initializable : fxml이 새로 열렸을 때 초기값[처음값] 설정 메소드 제공
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 초기값 설정 메소드
		Day22_2 DB연동 = new Day22_2();
		
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
    	System.out.println("DB내 데이터를 호출합니다.");
    	
    	//1.db연동 객체 만들기
    	Day22_2 db연동 = new Day22_2();
    	//2.db 객체내 메소드 호출 후 결과를 리스트로 받기
    	ArrayList<데이터> 데이터목록 = db연동.get();
    	
    	//3.리스트를 컨트롤에 넣어주기
    	for(데이터 temp : 데이터목록) {
    		
    		//fxid.appendText : 해당 컨트롤에 내용 추가
    		textcontent.appendText(
    				
    				"번호 "+temp.get번호()+
    				"작성자 "+temp.get작성자()+
    				"내용 "+temp.get내용() + "\n"
    				
    				
    				); //해당 컨트롤에 내용추가
     		
    	}
 
    }

    @FXML
    void write(ActionEvent event) {
    	System.out.println("DB내 데이터를 등록합니다.");
    	
    	//fxid명.getText(); 해당 컨트롤에 입력된 값을 가져오기
    	String 작성자 = txtwriter.getText();
    	//필드에서 빼옴
    	String 내용 = textcontent.getText();
    	
    	//1. db연동 객체 만들기
    	Day22_2 db연동 = new Day22_2();
    	//2. db연동 객체 내에서 삽입 메소드[write] 호출
    	    	
    	boolean result = db연동.write(작성자, 내용);
    	
    	//결과 확인
    	if(result) {
    		System.out.println("db에 데이터 저장 성공");
    	
    		//성공시 컨트롤에 입력된 데이터 지워주기
    			//fxid명.setText : 해당 컨트롤에 값 넣기
    		txtwriter.setText(""); //성공시 입력창 공백으로
    		textcontent.setText(""); //성공시 입력창 공백으로
    	
    	} else { System.out.println("db에 데이터 저장 실패"); }
    	
    }

}
