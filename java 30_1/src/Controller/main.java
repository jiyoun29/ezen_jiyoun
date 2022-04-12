package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class main implements Initializable {
							//@초기호 ㅏ담당
							//view가 새로 열렸을 때 초기값 설정 메소드 제공
	
	
	public static main instance;
	public main() {
		instance = this;
	}
	
	
	//////////////////////////////////////////
	
    @FXML
    private BorderPane borderpane; //씬빌더에서 만든 컨테이너 결제
    //fx : id
	//import 필수(ctrl space)
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { //해당 fxml이 열렸을 때 초기값 설정
		// TODO Auto-generated method stub
	//	System.out.println("main 뷰가 실행(view <-> controller 연결)되었습니다."); //loadpage 메소드 호출시 (파일경로)
		//1. 화면전환 메소드
		loadpage("/view/loginfx.fxml");
	}
	
	
	//메소드 만들기
	public void loadpage(String page) { //loadpage (파일경로)
		try {
			//페이지(fxml) 객체화
			Parent parent = FXMLLoader.load(getClass().getResource(page)); //무조건 예외처리
			//
			
			borderpane.setCenter(parent); //컨테이너(fxml) 가운데에 다른 페이지 넣기
		} catch (Exception e) {System.out.println("페이지 연결 실패" +e);} //파일이 존재하지 않으면 예"외 발생
	}
	
	

}
