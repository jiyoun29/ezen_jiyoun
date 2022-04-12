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
		
		if(product.getPactivation() == 1) { txtpactivation.setText("상태 : 판매중");  //변경 버튼
				btnacctivation.setText("거래중");		}
		if(product.getPactivation() == 2) { txtpactivation.setText("상태 : 거래중"); 
				btnacctivation.setText("판매완료"); }
		if(product.getPactivation() == 3) { txtpactivation.setText("상태 : 판매완료"); 
				btnacctivation.setText("판매중");}
		
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
	
	
//상태 변경
	    @FXML
	    private Button btnacctivation;
	
	
	    @FXML
	    void acctivation(ActionEvent event) {
	    	
	//   	txtpactivation.setText("상태 : 판매완료");

	    	if(btnacctivation.getText().equals("거래중")) {
	    		
	    		//컨트롤에 값 변경
	    		txtpactivation.setText("상태 : 거래중"); btnacctivation.setText("판매완료");
	    		//컨트롤에 내가 선택한 pnum을 넘겨서 그거에 해당하느 ㄴ걸 select해서 1번이면 2번으로 업데이트 처리

	    		//db의 값 변경
	    		ProductDao.productDao.activation(ProductControl.select.getPnum());

	    		//선택된 제품의 상태변경
	    		ProductControl.select.setPactivation(2); //거래중
	    		
	    		
	    		return; }
	    	
	    	if( btnacctivation.getText().equals("판매완료") ) {
	    		txtpactivation.setText("상태 : 판매완료");	
	    		btnacctivation.setText("판매중");
	    		ProductDao.productDao.activation( ProductControl.select.getPnum()  );
	    		ProductControl.select.setPactivation(3);
	    		return;
	    	}
	    	if( btnacctivation.getText().equals("판매중") ) {
	    		txtpactivation.setText("상태 : 판매중");	
	    		btnacctivation.setText("거래중");
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
