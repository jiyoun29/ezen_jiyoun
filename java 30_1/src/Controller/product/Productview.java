package Controller.product;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;

import Controller.Home;
import Controller.login.login;
import Dao.MemberDao;
import Dao.ProductDao;
import Dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Productview implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//1.��Ͽ��� ���õ� ��ǰ�� ��ü�� ȣ��
		Product product = ProductControl.select;
		
		//2.�� ��Ʈ�ѿ� �� �ֱ�
		img.setImage(new Image(product.getPimg()));
		txtpname.setText(product.getPname());
		txtpcontent.setText(product.getPcontent());
		
			//õ���� ��ǥ
			DecimalFormat decimalFormat = new DecimalFormat("���� : #,##0��");
			
		txtpprice.setText(decimalFormat.format(product.getPprice()));
		
		if(product.getPactivation() == 1) { txtpactivation.setText("���� : �Ǹ���");  //���� ��ư
				btnacctivation.setText("�ŷ���");		}
		if(product.getPactivation() == 2) { txtpactivation.setText("���� : �ŷ���"); 
				btnacctivation.setText("�ǸſϷ�"); }
		if(product.getPactivation() == 3) { txtpactivation.setText("���� : �ǸſϷ�"); 
				btnacctivation.setText("�Ǹ���");}
		
		txtmdate.setText("��ǰ ����� : "+product.getPdate());
		
		//ȸ����ȣ�� �̿��� ȸ��id ã�� [dao���� �޼ҵ� �̿�]
		txtmid.setText("��ǰ ���ȸ�� : "+MemberDao.memberDao.getmid(product.getNum()));
		
		//�����Ұ�
		txtpname.setEditable(false);
		txtpcontent.setEditable(false);

		//* ��ǰ���ȸ���� �α��ε� ȸ���� �������� ������
		if(product.getNum() != login.member.getMnum()) {
			btndelete.setVisible(false);
			btnupdate.setVisible(false);
		}
		
	}
	
	
//���� ����
	    @FXML
	    private Button btnacctivation;
	
	
	    @FXML
	    void acctivation(ActionEvent event) {
	    	
	//   	txtpactivation.setText("���� : �ǸſϷ�");

	    	if(btnacctivation.getText().equals("�ŷ���")) {
	    		
	    		//��Ʈ�ѿ� �� ����
	    		txtpactivation.setText("���� : �ŷ���"); btnacctivation.setText("�ǸſϷ�");
	    		//��Ʈ�ѿ� ���� ������ pnum�� �Ѱܼ� �װſ� �ش��ϴ� ���� select�ؼ� 1���̸� 2������ ������Ʈ ó��

	    		//db�� �� ����
	    		ProductDao.productDao.activation(ProductControl.select.getPnum());

	    		//���õ� ��ǰ�� ���º���
	    		ProductControl.select.setPactivation(2); //�ŷ���
	    		
	    		
	    		return; }
	    	
	    	if( btnacctivation.getText().equals("�ǸſϷ�") ) {
	    		txtpactivation.setText("���� : �ǸſϷ�");	
	    		btnacctivation.setText("�Ǹ���");
	    		ProductDao.productDao.activation( ProductControl.select.getPnum()  );
	    		ProductControl.select.setPactivation(3);
	    		return;
	    	}
	    	if( btnacctivation.getText().equals("�Ǹ���") ) {
	    		txtpactivation.setText("���� : �Ǹ���");	
	    		btnacctivation.setText("�ŷ���");
	    		ProductDao.productDao.activation( ProductControl.select.getPnum()  );
	    		ProductControl.select.setPactivation(1);
	    		return;
	    	}

	    }

	 ///////////////////////////////////   
	    
	
	   @FXML
	    private Button btnback;

	    @FXML
	    private Button btndelete;

	    @FXML
	    private Button btnupdate;

	    @FXML
	    private ImageView img;

	    @FXML
	    private Label txtmdate;

	    @FXML
	    private Label txtmid;

	    @FXML
	    private Label txtpactivation;

	    @FXML
	    private TextField txtpcontent; // ��Ʈ�� �����̹� ������ �ٲ���� ����

	    @FXML
	    private TextField txtpname;

	    @FXML
	    private Label txtpprice;

	    @FXML
	    void accback(ActionEvent event) {
	    	Home.home.loadpage("/view/product/product.fxml");

	    }

	    
	    
	    @FXML
	    void delete(ActionEvent event) {
	    	
	    	Alert  alert = new Alert(AlertType.CONFIRMATION);
	    		alert.setHeaderText("��ǰ�� �����Ͻðڽ��ϱ�?");
	    	Optional<ButtonType> optional = alert.showAndWait();
	    	
	    	if(optional.get() == ButtonType.OK) {
	    		ProductDao.productDao.delete(ProductControl.select.getPnum());
	    		Home.home.loadpage("/view/product/product.fxml");
	    	}
	    }

	    
	    
	    
	    @FXML
	    void update(ActionEvent event) {
	    	Home.home.loadpage("/view/product/productupdate.fxml");

	    }
	    
}
