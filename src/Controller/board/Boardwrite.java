package Controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.Home;
import Controller.login.login;
import Dao.BoardDAO;
import Dto.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Boardwrite implements Initializable {

	  @FXML
	  private Button btnback;

	  @FXML
	  private Button btnwrite;

	  @FXML
	  private TextArea txtcontent;

	  @FXML
	  private TextField txttitle;

	  @FXML
	  void back(ActionEvent event) {
		  Home.home.loadpage("/view/board/board.fxml");

	    }

	  @FXML
	  void write(ActionEvent event) { //게시물 등록 버튼을 눌렀을 때 이벤트
		  	//1.컨트롤에 입력된 데이터 가져오기 @스캐너처럼 사용
		  String title = txttitle.getText(); //해당 fxid객체에서 입력된 내용을 가져오기
		  String content = txtcontent.getText();
		  		//작성자: 현재 로그인된 객체 내 id로 사용
		  String write = login.member.getMid();
				  //로그인 성공시 멤버 객체에 저장했으므로 그걸 빼온다
		  
		  //2.객체화(dto에 있는 board)
		  	//번호(생략=0), 제목, 내용, 작성자, 작성일(자동), 조회수(자동)
		  Board board = new Board(0, title, content, title, null, 0);
		  
		  //3.db저장
		  	//dto/dao 차이점***알아두기
		  	//1. new를 써서 메소드 호출하는 것
//		  BoardDAO boardDAO = new BoardDAO;
//		  boardDAO.write(board);
		  	//2. static 객체를 미리 만들어 뒀으므로
		 boolean result = BoardDAO.boardDAO.write(board);
		  	//이게 가능하다
		 	if(result) {
		 		//성공했으면
		 		Alert alert = new Alert(AlertType.INFORMATION);
		 			alert.setHeaderText("게시글이 작성되었습니다.");
		 		alert.showAndWait();
		 		//페이지 전환
		 		
		 		Home.home.loadpage("/view/board/board.fxml");
		 		
		 	} else {}
		 	
		  

	    }

	  
	  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	    
	    
	    
}
