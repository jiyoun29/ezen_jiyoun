package Controller.board;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Controller.Home;
import Controller.login.login;
import Dao.BoardDAO;
import Dto.Board;
import Dto.Reply;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class Boardview implements Initializable {


    @FXML
    private Button btnback;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnrewrite;

    @FXML
    private Button btnupdate;

    @FXML
    private Label lbldate;

    @FXML
    private Label lblview;

    @FXML
    private Label lblwrite;
    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		replytableshow();

		Board board = Controller.board.Board.board;
		//board 컨트롤 내 테이블에서 선택된 객체 호출
		
		//각 컨트롤에 설정하기
		lblwrite.setText("작성자 : " + board.getBwriter());
		lbldate.setText("작성일 : " + board.getBdate());
		lblview.setText("조회수 : " + board.getBview());
		txttitle.setText(board.getBtitle());
		txtcontent.setText(board.getBcontent());
		
		//만약에 작성자와 현재 로그인된 id가 동일하지 않으면
		if( ! board.getBwriter().equals(login.member.getMid())) { //!:부정
		//버튼 숨기기
		btndelete.setVisible(false); 
		btnupdate.setVisible(false); 
		}
		//true = 보이기

		//텍스트 필드 컨트롤 수정 못하게 잠금 처리
		txttitle.setEditable(false);
		txtcontent.setEditable(false);
	}
	
	
    
    @FXML
    private TableView<Reply> replytable;
    	//테이블뷰에 넣을 자료형 = 리플
    
    
    // 댓글 테이블 메소드
    	//메소드 화 시킨 이유 : 여러번 테이블을 호출하기 위해서
    public void replytableshow() {
    
    	//현재 게시물 번호
    	int bnum = Controller.board.Board.board.getBnum();
    	
    	//리플 끌고오기
    	ObservableList<Reply> replylist = BoardDAO.boardDAO.replylist(bnum);
    
    	//
    	TableColumn tc = replytable.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rnum"));

    	tc = replytable.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rwrite"));

    	tc = replytable.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rdate"));

    	tc = replytable.getColumns().get(3);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rcontent"));
    	
    	
    	//테이블뷰에 리스트 넣어주기
    	replytable.setItems(replylist);
    }    

    @FXML
    private TextArea txtcontent;

    @FXML
    private TextArea txtrecontent1;

    @FXML
    private TextField txttitle;

    @FXML
    void back(ActionEvent event) {
    	Home.home.loadpage("/view/board/board.fxml");

    }

    

    
    
    @FXML
    void rewrite(ActionEvent event) { //댓글 작성 버튼
    	
    	//1. 컨트롤에 입력된 데이터 가져오기
    	String rcontent = txtcontent.getText();
    	
    	//2. 현재 로그인된 정보 가져오기
    	String rwrite = login.member.getMid();
    	
    	//3. 현재 테이블뷰에서 클릭된 게시물의 게시물번호 가져오기
    	int bnum = Controller.board.Board.board.getBnum();
    	
    	//객체화
    	Reply reply = new Reply(0, rcontent, rwrite, null, bnum);
    	
    	//db처리
    	boolean result = BoardDAO.boardDAO.rwrite(reply);
    	
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setHeaderText("댓글 등록 성공");

    			alert.showAndWait();
    			//댓글 입력창 초기화
    		//댓글 입력
    		txtrecontent1.setText("");
    		
    		//댓글 작성 후
    		replytableshow();
    	}
    }

    
    
    
    ////////////////////////////////////
    
    
    @FXML //글 삭제
    void delete(ActionEvent event) {
    	//1. 경고 메시지 알림
		Alert alert = new Alert(AlertType.CONFIRMATION); //확인, 취소 버튼 타입
			alert.setHeaderText("정말 지우시겠습니까?");
			
			Optional<ButtonType> optional = alert.showAndWait(); //이 메소드의 반환타입은 -> 선택한 버튼
			// Optional 클래스 : null 객체로 저장하는 클래스
			
		if(optional.get() == ButtonType.OK) { //2. 확인 버튼 눌렀을 때
			
		
		 //3. 삭제 처리 (boarddao에서 삭제)
		BoardDAO.boardDAO.delete(Controller.board.Board.board.getBnum() );
		
		
		//4.페이지 전환
		Home.home.loadpage("/view/board/board.fxml");
		
		}

    }
		

    
    boolean upcheck = true; //수정 버튼 스위치 변수
    @FXML
    void update(ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.INFORMATION); //1.메시지

    	if(upcheck) {// 수정 시작
    	alert.setHeaderText("게시글 수정 후 수정 완료 버튼을 눌러주세요.");
    	alert.showAndWait();
    	
		txttitle.setEditable(true);
		txtcontent.setEditable(true);
		btnupdate.setText("수정 완료");
		
    	upcheck = false;
    	
    	} else { //수정완료
    		//db처리
    		BoardDAO.boardDAO.update(Controller.board.Board.board.getBnum(),
    				txttitle.getText(),
    				txtcontent.getText());
   
        	alert.setHeaderText("수정이 완료 되었습니다.");
        	alert.showAndWait();
        	
    		txttitle.setEditable(false);
    		txtcontent.setEditable(false);
    		btnupdate.setText("수정");
    		upcheck = true;
    	}

    }
    
    
    
    
}
