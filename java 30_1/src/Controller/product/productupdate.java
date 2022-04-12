package Controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.Home;
import Dao.ProductDao;
import Dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class productupdate implements Initializable {
 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Product product = ProductControl.select;
		txtpname.setText(product.getPname());
		txtpcontent.setText(product.getPcontent());
		txtpprice.setText(product.getPprice()+"");
		txtpath.setText(product.getPimg());
		
		if(product.getPcategory().equals("남성의류")) {opt1.setSelected(true);}
		if(product.getPcategory().equals("여성의류")) {opt2.setSelected(true);}
		if(product.getPcategory().equals("게임기기")) {opt3.setSelected(true);}
		if(product.getPcategory().equals("생활용품")) {opt4.setSelected(true);}
		
	}
	

    @FXML
    private Button btnback;

    @FXML
    private Button btnimg;

    @FXML
    private Button btnupdate;

    @FXML
    private ToggleGroup category;

    @FXML
    private ImageView img;

    @FXML
    private Label imgview;

    @FXML
    private RadioButton opt1;

    @FXML
    private RadioButton opt2;

    @FXML
    private RadioButton opt3;

    @FXML
    private RadioButton opt4;

    @FXML
    private Label txtpath;

    @FXML
    private TextArea txtpcontent;

    @FXML
    private TextField txtpname;

    @FXML
    private TextField txtpprice;

    
    private String pimage = null;
    
    
    @FXML
    void accback(ActionEvent event) {
    	Home.home.loadpage("/view/product/productview.fxml");

    }

    @FXML
    void accupdate(ActionEvent event) {
    	
    	if(pimage == null) { //사진 수정이 없으면
    				//기존 사진 경로를 그대로 가져온다.
    		pimage = ProductControl.select.getPimg();
    		
    		String pcategory = null;
    		//선택이 되어있으면 ~라고 띄운다,
    		if(opt1.isSelected()) pcategory="남성의류";
    		if(opt2.isSelected()) pcategory="여성의류";
    		if(opt3.isSelected()) pcategory="게임기기";
    		if(opt4.isSelected()) pcategory="생활용품";
    	
    	Product upproduct = new Product
    			(ProductControl.select.getPnum(),
    			txtpname.getText(),
    			pimage,
    			txtpcontent.getText(),
    			pcategory,
    			Integer.parseInt(txtpprice.getText()),
    			0, null, 0);
    	
    	
    	boolean result = ProductDao.productDao.update(upproduct);
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("제품 수정 성공");
    		alert.showAndWait();
    		Home.home.loadpage("/view/product/productview.fxml");
    	} else { 
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("제품 수정 실패");
    		alert.showAndWait();    		
    	}
    }
    }

    @FXML
    void imgadd(ActionEvent event) {
    	//이미지 등록 버튼을 클릭했을 때
    	//1. 파일 선택 클래스 객체 생성
    	FileChooser fileChooser = new FileChooser();
    	
    		//2. 파일선택[필터] 형식
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("이미지파일:imagefile", "*png","*jpg","*jpeg","*gif"));
    	
    	//3.새로운 stage(윈도우창)
    	File file = fileChooser.showOpenDialog(new Stage());
    		//파일선택객체.sho~log(스테이지 이름)
    		//filechooser 화면에서 선택된 파일을 file 클래스 객체화
    	
    	//4. 선택한 파일의 경로 표시
    	txtpath.setText("파일 경로 :" + file.getPath());
    	
    		//5.파일 경로 저장
    	pimage = file.toURI().toString();
    						//toString : 문자열 변환

    	//5. 이미지 미리보기 띄우기
    	Image image = new Image(pimage);
    	img.setImage(image);
    	
    	
    	//*선택된 파일을 현재 프로젝트 폴더로 복사해오기
    	//1. 파일 입력 스트림 [이동단위 : 바이트]    	
    	try { FileInputStream inputStream = new FileInputStream(file);
    			//선택된 파일을 집어넣음
    		//file:filechooser에서 선택된 파일 객체
    	//2. 파일 출력 스트림
    			//파일 이름과 경로 설정			// 경로								// /빠졌습니다.    	
    		File copyfile = new File("C:/Users/JIYUN/git/git2/ezen_jiyoun/src/img/"+file.getName());
    		FileOutputStream outputStream = new FileOutputStream(copyfile);
    		//img패키지로 바이트로 복사해서 넣음
    		
    	//3. 바이트 배열 선언
    		byte[] bytes = new byte[1024*1024*1024];
    		//1바이트->1024바이트->1키로바이크->1024키로바이트->1메가바이트
    		
    	//4. 반복을 이용한 inputstream의 파일 스트림 모두 읽어오기
    		int size;
    		while( (size = inputStream.read(bytes)) > 0) { //읽어온 걸 저장하고 사이즈를 잰다.
    				//읽어온 바이트가 0보다 작으면 반복문 종료
    			outputStream.write(bytes , 0 , size); //읽어온 바이트만큼 내보내기
    		}
    	
    	//5. 용량이 큰 경우 스트림 종료 필수*
    		inputStream.close();
    		outputStream.close();
    		
    		//복사된 파일의 경로를 db에 저장
        	pimage = copyfile.toURI().toString();
    		
    	} catch (Exception e) {System.out.println("sql오류:"+e);}

    }

    
}
