package Controller;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Dao.ProductDao;
import Dto.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class Record implements Initializable {
	
	@FXML
	private Label lblmtotal; //fxid 객체화	
	
	@FXML
	private Label lblptotal; //fxid 객체화
	
	@FXML
	private Label lblbtotal; //fxid 객체화
	
	@FXML
	private BarChart<?, ?> mbc;
	
	@FXML
	private BarChart<?, ?> bbc;
	
	@FXML
	private BarChart<?, ?> pbc;
	
	@FXML
	private PieChart ppc;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// 전체 회원수
		int mtotal = MemberDao.memberDao.counttotal("member");
		lblmtotal.setText(mtotal+" 명");
		// 전체 제품수
		int ptotal = MemberDao.memberDao.counttotal("product");
		lblptotal.setText(ptotal+" 개");		
		// 전체 게시물수
		int btotal = MemberDao.memberDao.counttotal("board");
		lblbtotal.setText(btotal+" 개");		
	
	
	
		//날짜별로 회원 가입한 수
			//<> 제네릭 제외
	
		//1. xy축 계열 생성
		XYChart.Series series = new XYChart.Series<>(); //1. xy 축 계열 생성
			//XYChart.Series : 계열 클래스 
				//XYChart.Data : 계열데이터 클래스[x축의 값, y축의 값]
		
		//2. db에서 데이터 가져오기
			//날짜별로 회원가입 수 체크 [ 날짜 별로 저장][2022-04-11, 3]
			//map 컬렉션 -> 키(날짜), 값(가입수)으로 하나의 엔트리 구성
		Map<String, Integer> map = MemberDao.memberDao.datetotal("member","msince");
		
		//3. 데이터를 계열에 추가
			for(String key : map.keySet()) { //반복문
				//3-1. 데이터 계열 선언( 생성자 : key = 날짜, value=가입자수)
				XYChart.Data data = new XYChart.Data<>(key, map.get(key));
				//3-2. 해당 데이터 객체를 계열에 추가
				series.getData().add(data);	}
			
		//4. 해당 계열을 막대 차트에 추가
			//막대차트 이름
		mbc.getData().add(series);
		
		
		//1. 계열 생성
		XYChart.Series series2 = new XYChart.Series<>();
		Map<String , Integer> map2 = MemberDao.memberDao.datetotal("board","bdate");
		
			for(String key1 : map2.keySet()) {
				//2.데이터 생성
				XYChart.Data data = new XYChart.Data<>(key1, map2.get(key1));
				//3.계열에 데이터 추가
				series2.getData().add(data); }
		
		//4. 해당 계열을 추가
		bbc.getData().add(series2); 
	


		// 1. 계열 생성 
		XYChart.Series series3 = new XYChart.Series<>();
		
			series3.setName("국어점수"); // * 계열명 
		
			// 2. 데이터 선언 ( x축값 , y축값 )
			XYChart.Data data = new XYChart.Data<>("신동엽" , 10);
			// 3. 계열에 데이터 추가
			series3.getData().add(data);
			
			XYChart.Data data2 = new XYChart.Data<>("강호동" , 20);
			series3.getData().add(data2);
			
			XYChart.Data data3 = new XYChart.Data<>("유재석" , 15);
			series3.getData().add(data3);
			
		// 4. 차트에 계열추가
		pbc.getData().add(series3);
			
		XYChart.Series series4 = new XYChart.Series<>();
			series4.setName("영어점수");

			XYChart.Data data4 = new XYChart.Data<>("신동엽" , 25); // 2. 데이터 선언 ( x축값 , y축값 )
			series4.getData().add(data4); // 3. 계열에 데이터 추가
			
			XYChart.Data data5 = new XYChart.Data<>("강호동" , 40);
			series4.getData().add(data5);
			
			XYChart.Data data6 = new XYChart.Data<>("유재석" , 50);
			series4.getData().add(data6);
	
		pbc.getData().add(series4);
	
		
		
		
		//원형차트 : 카테고리별 개수
			//1.ObservableList 선언<원형차트 데이터 자료형> 리스트 선언
		
//		List<Product> list = ProductDao.productDao.list(null, null);
		ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
		//모든 제품 다 빼오기
		
		//2.db에서 카테고리별 개수
		Map<String, Integer> map3 =MemberDao.memberDao.countcategory();
		
		//3.원형차트 데이터 추가
		for(String key : map3.keySet()) {
			PieChart.Data temp = new PieChart.Data(key, map3.get(key));
			//*데이터를 리스트에 추가
			list.add(temp);
		}
		
		//2. piechart에 date 추가 	PieChart.Data date7 = new PieChart.Data("남성의류", 10);
		//3. 데이터를 리스트에 추가	list.add(date7);
		
		//반복문
//		for(Product product : list) { pielist.add(new PieChart.Data(product.getPcategory(), 1));	}

		ppc.setData(list); //리스트를 원형차트에 추가
		
		
	}
	
}
