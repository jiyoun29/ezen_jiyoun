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
		//board ��Ʈ�� �� ���̺��� ���õ� ��ü ȣ��
		
		//�� ��Ʈ�ѿ� �����ϱ�
		lblwrite.setText("�ۼ��� : " + board.getBwriter());
		lbldate.setText("�ۼ��� : " + board.getBdate());
		lblview.setText("��ȸ�� : " + board.getBview());
		txttitle.setText(board.getBtitle());
		txtcontent.setText(board.getBcontent());
		
		//���࿡ �ۼ��ڿ� ���� �α��ε� id�� �������� ������
		if( ! board.getBwriter().equals(login.member.getMid())) { //!:����
		//��ư �����
		btndelete.setVisible(false); 
		btnupdate.setVisible(false); 
		}
		//true = ���̱�

		//�ؽ�Ʈ �ʵ� ��Ʈ�� ���� ���ϰ� ��� ó��
		txttitle.setEditable(false);
		txtcontent.setEditable(false);
	}
	
	
    
    @FXML
    private TableView<Reply> replytable;
    	//���̺�信 ���� �ڷ��� = ����
    
    
    // ��� ���̺� �޼ҵ�
    	//�޼ҵ� ȭ ��Ų ���� : ������ ���̺��� ȣ���ϱ� ���ؼ�
    public void replytableshow() {
    
    	//���� �Խù� ��ȣ
    	int bnum = Controller.board.Board.board.getBnum();
    	
    	//���� �������
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
    	
    	
    	//���̺�信 ����Ʈ �־��ֱ�
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
    void rewrite(ActionEvent event) { //��� �ۼ� ��ư
    	
    	//1. ��Ʈ�ѿ� �Էµ� ������ ��������
    	String rcontent = txtcontent.getText();
    	
    	//2. ���� �α��ε� ���� ��������
    	String rwrite = login.member.getMid();
    	
    	//3. ���� ���̺�信�� Ŭ���� �Խù��� �Խù���ȣ ��������
    	int bnum = Controller.board.Board.board.getBnum();
    	
    	//��üȭ
    	Reply reply = new Reply(0, rcontent, rwrite, null, bnum);
    	
    	//dbó��
    	boolean result = BoardDAO.boardDAO.rwrite(reply);
    	
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setHeaderText("��� ��� ����");

    			alert.showAndWait();
    			//��� �Է�â �ʱ�ȭ
    		//��� �Է�
    		txtrecontent1.setText("");
    		
    		//��� �ۼ� ��
    		replytableshow();
    	}
    }

    
    
    
    ////////////////////////////////////
    
    
    @FXML //�� ����
    void delete(ActionEvent event) {
    	//1. ��� �޽��� �˸�
		Alert alert = new Alert(AlertType.CONFIRMATION); //Ȯ��, ��� ��ư Ÿ��
			alert.setHeaderText("���� ����ðڽ��ϱ�?");
			
			Optional<ButtonType> optional = alert.showAndWait(); //�� �޼ҵ��� ��ȯŸ���� -> ������ ��ư
			// Optional Ŭ���� : null ��ü�� �����ϴ� Ŭ����
			
		if(optional.get() == ButtonType.OK) { //2. Ȯ�� ��ư ������ ��
			
		
		 //3. ���� ó�� (boarddao���� ����)
		BoardDAO.boardDAO.delete(Controller.board.Board.board.getBnum() );
		
		
		//4.������ ��ȯ
		Home.home.loadpage("/view/board/board.fxml");
		
		}

    }
		

    
    boolean upcheck = true; //���� ��ư ����ġ ����
    @FXML
    void update(ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.INFORMATION); //1.�޽���

    	if(upcheck) {// ���� ����
    	alert.setHeaderText("�Խñ� ���� �� ���� �Ϸ� ��ư�� �����ּ���.");
    	alert.showAndWait();
    	
		txttitle.setEditable(true);
		txtcontent.setEditable(true);
		btnupdate.setText("���� �Ϸ�");
		
    	upcheck = false;
    	
    	} else { //�����Ϸ�
    		//dbó��
    		BoardDAO.boardDAO.update(Controller.board.Board.board.getBnum(),
    				txttitle.getText(),
    				txtcontent.getText());
   
        	alert.setHeaderText("������ �Ϸ� �Ǿ����ϴ�.");
        	alert.showAndWait();
        	
    		txttitle.setEditable(false);
    		txtcontent.setEditable(false);
    		btnupdate.setText("����");
    		upcheck = true;
    	}

    }
    
    
    
    
}
