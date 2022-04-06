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
	  void write(ActionEvent event) { //�Խù� ��� ��ư�� ������ �� �̺�Ʈ
		  	//1.��Ʈ�ѿ� �Էµ� ������ �������� @��ĳ��ó�� ���
		  String title = txttitle.getText(); //�ش� fxid��ü���� �Էµ� ������ ��������
		  String content = txtcontent.getText();
		  		//�ۼ���: ���� �α��ε� ��ü �� id�� ���
		  String write = login.member.getMid();
				  //�α��� ������ ��� ��ü�� ���������Ƿ� �װ� ���´�
		  
		  //2.��üȭ(dto�� �ִ� board)
		  	//��ȣ(����=0), ����, ����, �ۼ���, �ۼ���(�ڵ�), ��ȸ��(�ڵ�)
		  Board board = new Board(0, title, content, title, null, 0);
		  
		  //3.db����
		  	//dto/dao ������***�˾Ƶα�
		  	//1. new�� �Ἥ �޼ҵ� ȣ���ϴ� ��
//		  BoardDAO boardDAO = new BoardDAO;
//		  boardDAO.write(board);
		  	//2. static ��ü�� �̸� ����� �����Ƿ�
		 boolean result = BoardDAO.boardDAO.write(board);
		  	//�̰� �����ϴ�
		 	if(result) {
		 		//����������
		 		Alert alert = new Alert(AlertType.INFORMATION);
		 			alert.setHeaderText("�Խñ��� �ۼ��Ǿ����ϴ�.");
		 		alert.showAndWait();
		 		//������ ��ȯ
		 		
		 		Home.home.loadpage("/view/board/board.fxml");
		 		
		 	} else {}
		 	
		  

	    }

	  
	  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	    
	    
	    
}
