package Controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.Home;
import Dao.BoardDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Board implements Initializable {

    @FXML
    private Button btnwrite;
	
    @FXML
    private TableView<Dto.Board> boardtable; //테이블에 넣을 자료형 선택
    				//dto의 보드 가져옴
    				// 여기가 문제였던것 같아요 컨트롤명과 dto 이름이 같아서 헷갈리수 있어요
    	//테이블에 게시물을 표기하기 위해
    
    
    

	//클릭한 걸 임시로 저장
    public static Dto.Board board; 
    
    
    
    
    @FXML
    void accwrite(ActionEvent event) {
    	
    	//home클래스 내 boarderpane center 변경
    	Home.home.loadpage("/view/board/boardwrite.fxml");

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// arraylist말고 ObservableList 사용
		//javafx에서 만든 arraylist
		//table view가 ObservableList 사용
		
		//1.db에서 모든 게시글 가져오기
		ObservableList<Dto.Board> boardlist = BoardDAO.boardDAO.list();
//		System.out.println(boardlist.toString());
		//객체2개 레코드2개
		
		
		
		//2.table view에 추가(적은 글 띄우기)
		TableColumn tc = boardtable.getColumns().get(0);
			//TableColumn : 테이블 열
				//boardtable.getColumns().get(0); : 첫번째 열 호출
		tc.setCellValueFactory(new PropertyValueFactory<>("bnum"));
				
		tc = boardtable.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		
		tc = boardtable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("bwriter"));
		
		tc = boardtable.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("bdate"));
		
		tc = boardtable.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("bview"));

		
		
		
		//3.tableview
		boardtable.setItems(boardlist);
			//테이블명(fxid).setItems(observalbelist);
		//테이블에 표시할 리스트(일반적 arraylist X)설정

		
		
		
		//*table view 에서 해당 셀을 클릭했을 때 이벤트
		boardtable.setOnMouseClicked(e -> {
			
			//1.테이블에서 클릭한 객체를 임시객체에 저장
			board = boardtable.getSelectionModel().getSelectedItem();
			//클릭한 board 객체 호출
			
			//2.조회수 증가
			
			
			
			//3.페이지 전환
			Home.home.loadpage("/view/board/boardview.fxml");
			
			
			});
		//boardtable.setOnMouseClicked(e->실행코드); : 테이블을 클릭했을때

		
		// [일회용] 인수 -> 실행코드 : 람다식(=익명함수) : 일반적으로 이름이 없는 함수. 인수와 실행코드만 존재
			// vs
		// void 함수명(인수1){실행코드} : 일반적인 함수
			//이걸 안 쓰겠다는 뜻(람다가)
		
		
		
		
	}
	
	
	

    
}
