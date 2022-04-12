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
							//인터페이스 = 구현하다
	
	//컨트롤러 만들었으면 연결도 할 것
	
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
    void search(ActionEvent event) { //검색 버튼 눌렀을때
    	
    	String search = txtsearch.getText(); //검색창에 입력된 데이터 가져오기
    	show(search); //입력한 검색어를 show 메소드에 넣어주기
    }
    
    
    
    
    void show(String search) {
    	
    	
    	if(btnvb.getChildren().isEmpty() == false) {
    		// isEmpty() : 해당 객체 내 비어 있는지 확인[vbox내에]

    		//비어있지 않으면
    		btnvb.getChildren().remove(0); // 객체가 비어있지 않으면 vbox내 기존 객체를 삭제
    		
    	}
    	
		
		//1.모든 제품 가져오기
		ArrayList<Product> productlist = ProductDao.productDao.list(Home.category, search);
		//조건없이 모든 리스트 빼오기(home.category라고해서 내가 선택한 것 집어넣기)
		
		
//		System.out.println("확인:"+productlist.toString()); //확인
		
		
		//* 제품의 개수가 다수일때
//		ImageView imageView = new ImageView(new Image(productlist.get(0).getPimg()));
//		Button button = new Button(null, imageView);
//		vBox.getChildren().add(button);

		
		//2. 그리드 클래스 [행/열]
			GridPane gridPane = new GridPane();
		
			//그리드간 여백
			gridPane.setPadding(new Insets(10) );
			//버튼 간 여백
			gridPane.setHgap(20); //세로여백
			gridPane.setVgap(20); //가로여백
			
		
		//3. 반복문
		int i = 0; //인덱스용 변수
		for(int row = 0 ; row<productlist.size()/3; row++) { //행
			for(int col = 0 ; col<3 ; col++) { //열
				
				//1.이미지
				ImageView imageView = new ImageView(new Image(productlist.get(i).getPimg()));
					//*이미지 사이즈
					imageView.setFitWidth(250); //이미지 가로길이
					imageView.setFitHeight(200); //이미지 세로길이
				
				//2. 버튼 생성(버튼에 임지ㅣ 넣기) @해당 이미지를 버튼에 넣음
				Button button = new Button(null, imageView);
					//*버튼 배경 제거 [transparent:투명색]
					//button.setStyle("-fx-backgroud-color:transparent");
					
					//버튼 id값 넣기[제품 식별 = index]
					button.setId(i+"");
					
					//버튼 클릭이벤트
						//button.setOnAction(e -> {}); //람다식 : 인수 -> {실행코드}
					button.setOnAction(e -> {
						System.out.println(e.toString());
						//1. 클릭한 버튼의 id 가져오기
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
//						System.out.println("e에서 id만 빼온 결과:" +id);
//						System.out.println("해당 id의 제품정보 :"+productlist.get(id).getPname());
						
						//2. 클릭한 제품 번호 저장
						select = productlist.get(id);
						
						//3.화면 전환
						Home.home.loadpage("/View/product/productview.fxml");
						
					} );
		
				gridPane.add(button, col, row);
				//그리드내 해당 열번호, 행번호에 버튼 추가
				
				i++; //1씩 인덱스 증가
			}
		}
		
		//*3배수의 나머지값
		int row = productlist.size() / 3; //마지막 행
		
		int remain = productlist.size() % 3; //마지막 행의 나머지
		if (remain != 0){ //나머지가 존재하면
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
						
						//3.화면 전환
						Home.home.loadpage("/View/product/productview.fxml"); } );
				
				gridPane.add(button, col, row+1); //마지막행에 나머지값 만큼 버튼을 추가해서 그리드에 추가
				i++; //1씩 인덱스 증가
			}
		}
		
		
		//4. vbox에 그리드 넣기
		btnvb.getChildren().add(gridPane);
		
		//이 행,열로 좌석이나 기타 등등 생성 가능 
		
		
    }



    @FXML
    void accadd(ActionEvent event) { //제품등록
    	Home.home.loadpage("/View/product/productadd.fxml");

    }
	
    public static Product select; //선택된 버튼 저장
	
	
	@Override //구현 완료
	public void initialize(URL arg0, ResourceBundle arg1) { //전체코드를 메소드화
													//이유 : search할때에도 ini~할 때도 써야하기 때문에
												//만들어둔거 다 가져와서 위의 show에 넣기
		show(null); //가져와서 사용
		//안에 null을 넣음.
		//화면이 처음 열렸을 때에는 검색어를 null 넣어준다.
	}
	
}

