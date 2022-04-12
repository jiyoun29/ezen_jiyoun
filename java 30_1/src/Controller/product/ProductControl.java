package Controller.product;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.Home;
import Dao.ProductDao;
import Dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ProductControl implements Initializable {
							//�������̽� = �����ϴ�
	
	//��Ʈ�ѷ� ��������� ���ᵵ �� ��
	
    @FXML
    private Button btnadd;

    @FXML
    private ScrollPane btnsb;

    @FXML
    private VBox btnvb;
    

    @FXML
    private Button btnsearch;

    @FXML
    private TextField txtsearch;
    

    
    @FXML
    void search(ActionEvent event) { //�˻� ��ư ��������
    	
    	String search = txtsearch.getText(); //�˻�â�� �Էµ� ������ ��������
    	show(search); //�Է��� �˻�� show �޼ҵ忡 �־��ֱ�
    }
    
    
    
    
    void show(String search) {
    	
    	
    	if(btnvb.getChildren().isEmpty() == false) {
    		// isEmpty() : �ش� ��ü �� ��� �ִ��� Ȯ��[vbox����]

    		//������� ������
    		btnvb.getChildren().remove(0); // ��ü�� ������� ������ vbox�� ���� ��ü�� ����
    		
    	}
    	
		
		//1.��� ��ǰ ��������
		ArrayList<Product> productlist = ProductDao.productDao.list(Home.category, search);
		//���Ǿ��� ��� ����Ʈ ������(home.category����ؼ� ���� ������ �� ����ֱ�)
		
		
//		System.out.println("Ȯ��:"+productlist.toString()); //Ȯ��
		
		
		//* ��ǰ�� ������ �ټ��϶�
//		ImageView imageView = new ImageView(new Image(productlist.get(0).getPimg()));
//		Button button = new Button(null, imageView);
//		vBox.getChildren().add(button);

		
		//2. �׸��� Ŭ���� [��/��]
			GridPane gridPane = new GridPane();
		
			//�׸��尣 ����
			gridPane.setPadding(new Insets(10) );
			//��ư �� ����
			gridPane.setHgap(20); //���ο���
			gridPane.setVgap(20); //���ο���
			
		
		//3. �ݺ���
		int i = 0; //�ε����� ����
		for(int row = 0 ; row<productlist.size()/3; row++) { //��
			for(int col = 0 ; col<3 ; col++) { //��
				
				//1.�̹���
				ImageView imageView = new ImageView(new Image(productlist.get(i).getPimg()));
					//*�̹��� ������
					imageView.setFitWidth(250); //�̹��� ���α���
					imageView.setFitHeight(200); //�̹��� ���α���
				
				//2. ��ư ����(��ư�� ������ �ֱ�) @�ش� �̹����� ��ư�� ����
				Button button = new Button(null, imageView);
					//*��ư ��� ���� [transparent:�����]
					//button.setStyle("-fx-backgroud-color:transparent");
					
					//��ư id�� �ֱ�[��ǰ �ĺ� = index]
					button.setId(i+"");
					
					//��ư Ŭ���̺�Ʈ
						//button.setOnAction(e -> {}); //���ٽ� : �μ� -> {�����ڵ�}
					button.setOnAction(e -> {
						System.out.println(e.toString());
						//1. Ŭ���� ��ư�� id ��������
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
//						System.out.println("e���� id�� ���� ���:" +id);
//						System.out.println("�ش� id�� ��ǰ���� :"+productlist.get(id).getPname());
						
						//2. Ŭ���� ��ǰ ��ȣ ����
						select = productlist.get(id);
						
						//3.ȭ�� ��ȯ
						Home.home.loadpage("/View/product/productview.fxml");
						
					} );
		
				gridPane.add(button, col, row);
				//�׸��峻 �ش� ����ȣ, ���ȣ�� ��ư �߰�
				
				i++; //1�� �ε��� ����
			}
		}
		
		//*3����� ��������
		int row = productlist.size() / 3; //������ ��
		
		int remain = productlist.size() % 3; //������ ���� ������
		if (remain != 0){ //�������� �����ϸ�
			for(int col = 0 ; col<remain ; col++) {
				ImageView imageView = new ImageView(new Image(productlist.get(i).getPimg()));
					imageView.setFitWidth(250); 
					imageView.setFitHeight(200); 
				Button button = new Button(null, imageView);
					button.setStyle("-fx-backgroud-color:transparent");
					button.setId(i+"");
					
					button.setOnAction(e -> {
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
						select = productlist.get(id); 
						
						//3.ȭ�� ��ȯ
						Home.home.loadpage("/View/product/productview.fxml"); } );
				
				gridPane.add(button, col, row+1); //�������࿡ �������� ��ŭ ��ư�� �߰��ؼ� �׸��忡 �߰�
				i++; //1�� �ε��� ����
			}
		}
		
		
		//4. vbox�� �׸��� �ֱ�
		btnvb.getChildren().add(gridPane);
		
		//�� ��,���� �¼��̳� ��Ÿ ��� ���� ���� 
		
		
    }



    @FXML
    void accadd(ActionEvent event) { //��ǰ���
    	Home.home.loadpage("/View/product/productadd.fxml");

    }
	
    public static Product select; //���õ� ��ư ����
	
	
	@Override //���� �Ϸ�
	public void initialize(URL arg0, ResourceBundle arg1) { //��ü�ڵ带 �޼ҵ�ȭ
													//���� : search�Ҷ����� ini~�� ���� ����ϱ� ������
												//�����а� �� �����ͼ� ���� show�� �ֱ�
		show(null); //�����ͼ� ���
		//�ȿ� null�� ����.
		//ȭ���� ó�� ������ ������ �˻�� null �־��ش�.
	}
	
}

