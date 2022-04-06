package Controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.Home;
import Controller.login.login;
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
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class productadd implements Initializable {
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
	}
	

    @FXML
    private Button btnadd;

    @FXML
    private Button btnback;

    @FXML
    private Button btnimg;

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

    @FXML
    void accadd(ActionEvent event) {
    	//1.컨트롤에 입력된 데이터 가져오기 (유효성 검사 생략)
    	String pname = txtpname.getText();
    	String pcontent = txtpcontent.getText();
    	int pprice = Integer.parseInt(txtpprice.getText());	//문자열 -> 정수열 변환
    		//*카테고리
    	String pcategoty = "";
    		if(opt1.isSelected()) {	//만일 opt1이라는 fxid의 컨트롤이 선택되었으면
    			pcategoty="남성의류"; }
    		if(opt2.isSelected()) {pcategoty="여성의류";}
    		if(opt3.isSelected()) {pcategoty="게임기기";}
    		if(opt4.isSelected()) {pcategoty="생활용품";}
    	int mnum = login.member.getMnum();
    		    	
    	//2.객체화
    	Product product = new Product(0, pname, pimage, pcontent, pcategoty, pprice, 1, null, mnum);
    	
    	//3.DB처리
    	boolean result = ProductDao.productDao.add(product);
    	
    	//4.결과처리
    	if(result) { Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("제품 등록 완료");
    		alert.showAndWait();
    		
    		Home.home.loadpage("/view/product/product.fxml");
    		
    	} else {Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("제품 등록 실패");
		alert.showAndWait();
		}

    }

    
    
    
    @FXML
    void accback(ActionEvent event) {
    	Home.home.loadpage("/view/product/product.fxml");

    }

    
    //경로 저장을 위해 밖에 ㅏㄴ들어놓기
    private String pimage = null;
    	//메소드 밖에서 선언하는 이유 : imgeadd메소드와 add 메소드에서 사용하기 위해
    
    
    @FXML
    void imgadd(ActionEvent event) { //이미지 등록 버튼을 클릭했을 때
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

    	//각각 경로가 다름
//    		System.out.println(file.getPath()); 			경로구분선 : \
//    		System.out.println(file.toURI());				경로구분선 : /
//    		System.out.println(file.toURI().toString());	경로구분선 : /
    	
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
