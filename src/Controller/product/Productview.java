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

		//1.목록에서 선택된 제품의 객체를 호출
		Product product = ProductControl.select;
		
		//2.각 컨트롤에 값 넣기
		img.setImage(new Image(product.getPimg()));
		txtpname.setText(product.getPname());
		txtpcontent.setText(product.getPcontent());
		
			//천단위 쉼표
			DecimalFormat decimalFormat = new DecimalFormat("가격 : #,##0원");
			
		txtpprice.setText(decimalFormat.format(product.getPprice()));
		
		if(product.getPactivation() == 1) { txtpactivation.setText("상태 : 판매중"); }
		if(product.getPactivation() == 2) { txtpactivation.setText("상태 : 거래중"); }
		if(product.getPactivation() == 3) { txtpactivation.setText("상태 : 판매완료"); }
		
		txtmdate.setText("제품 등록일 : "+product.getPdate());
		
		//회원번호를 이용한 회원id 찾기 [dao에서 메소드 이용]
		txtmid.setText("제품 등록회원 : "+MemberDao.memberDao.getmid(product.getNum()));
		
		//수정불가
		txtpname.setEditable(false);
		txtpcontent.setEditable(false);

		//* 제품등록회원과 로그인된 회원이 동일하지 않으면
		if(product.getNum() != login.member.getMnum()) {
			btndelete.setVisible(false);
			btnupdate.setVisible(false);
		}
		
	}
	
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
	    private TextField txtpcontent; // 컨트롤 스페이바 누를때 바뀌었나 봐요

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
	    		alert.setHeaderText("제품을 삭제하시겠습니까?");
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
