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
    private TableView<Dto.Board> boardtable; //���̺� ���� �ڷ��� ����
    				//dto�� ���� ������
    				// ���Ⱑ ���������� ���ƿ� ��Ʈ�Ѹ�� dto �̸��� ���Ƽ� �򰥸��� �־��
    	//���̺� �Խù��� ǥ���ϱ� ����
    
    
    

	//Ŭ���� �� �ӽ÷� ����
    public static Dto.Board board; 
    
    
    
    
    @FXML
    void accwrite(ActionEvent event) {
    	
    	//homeŬ���� �� boarderpane center ����
    	Home.home.loadpage("/view/board/boardwrite.fxml");

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// arraylist���� ObservableList ���
		//javafx���� ���� arraylist
		//table view�� ObservableList ���
		
		//1.db���� ��� �Խñ� ��������
		ObservableList<Dto.Board> boardlist = BoardDAO.boardDAO.list();
//		System.out.println(boardlist.toString());
		//��ü2�� ���ڵ�2��
		
		
		
		//2.table view�� �߰�(���� �� ����)
		TableColumn tc = boardtable.getColumns().get(0);
			//TableColumn : ���̺� ��
				//boardtable.getColumns().get(0); : ù��° �� ȣ��
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
			//���̺��(fxid).setItems(observalbelist);
		//���̺� ǥ���� ����Ʈ(�Ϲ��� arraylist X)����

		
		
		
		//*table view ���� �ش� ���� Ŭ������ �� �̺�Ʈ
		boardtable.setOnMouseClicked(e -> {
			
			//1.���̺��� Ŭ���� ��ü�� �ӽð�ü�� ����
			board = boardtable.getSelectionModel().getSelectedItem();
			//Ŭ���� board ��ü ȣ��
			
			//2.��ȸ�� ����
			
			
			
			//3.������ ��ȯ
			Home.home.loadpage("/view/board/boardview.fxml");
			
			
			});
		//boardtable.setOnMouseClicked(e->�����ڵ�); : ���̺��� Ŭ��������

		
		// [��ȸ��] �μ� -> �����ڵ� : ���ٽ�(=�͸��Լ�) : �Ϲ������� �̸��� ���� �Լ�. �μ��� �����ڵ常 ����
			// vs
		// void �Լ���(�μ�1){�����ڵ�} : �Ϲ����� �Լ�
			//�̰� �� ���ڴٴ� ��(���ٰ�)
		
		
		
		
	}
	
	
	

    
}
