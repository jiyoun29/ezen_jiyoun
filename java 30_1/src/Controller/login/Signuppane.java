package Controller.login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Signuppane implements Initializable {
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		con.setText(""); //처음 실행시 문구 없애기
	}
	

	   @FXML
	    private Button btback;

	    @FXML
	    private Button btsignup;

	    @FXML
	    private Label con;

	    @FXML
	    private TextField txtaddress;

	    @FXML
	    private TextField txtemail;

	    @FXML
	    private TextField txtid;

	    @FXML
	    private PasswordField txtpw;

	    @FXML
	    private PasswordField txtpwcon;

	

    @FXML
    void accback(ActionEvent event) {
    	System.out.println("뒤로가기");
    	login.instance.loadpage("/view/loginpane.fxml");
    	
    }


    @FXML
    void signup(ActionEvent event) {
    	//컨트롤에 입력된 데이터 가져오기 [  fxid명.gettext() ]
    	String id = txtid.getText();
    	String pw = txtpw.getText();
    	String pwcon = txtpwcon.getText();
    	String email = txtemail.getText();
    	String address = txtaddress.getText();
    	
    	//현재 날짜 가져오기 [날짜 모양(형식) 변환 클래스]
    	SimpleDateFormat format = new SimpleDateFormat("yy-mm-dd");
   	
    	String since = format.format(new Date() ); //현재 날짜를 현식 변환
    	
    	// 오타 조심하세요~~ㅠㅠ
    	// *유효성 검사
    		//1. id중복체크
    	boolean result2 = MemberDao.memberDao.idcheck(id);
    		if(result2) {
    			con.setText("실패 사용중인 아이디입니다.");
    			return; //가입 못하게 메소드 종료
    		}
    	
    	
    	
    			//id 길이 체크 [ 길이가 4~10 사이 ]
		if( id.length() < 4 || id.length() >10 ) {
			con.setText(" [ 실패 ] 아이디 4~10 사이로 입력해주세요!");
			return; // 가입 못하게 [ 메소드 종료 ]
		}
    	
    		//2. 비밀번호 길이 체크
    			//문자열.length(); 문자열 길이
    	if(pw.length() < 4 || pw.length() >10 || pwcon.length() < 4 || pwcon.length() > 10 ) {
    		con.setText("비밀번호는 4글자 이상 10글자 미만으로 입력해주세요.");
    		
    		return; //가입 못하게 [메소드 종료]
    	}
    	
    			//비밀번호 일치 체크
    	if( ! pw.equals(pwcon)) { //패스워드랑 패스워드검사 일치하지 않으면 [ ! : 부정 (반대) ] 
    		con.setText("비밀번호가 일치하지 않습니다.");
    		
    		return; //메소드 종료
    		}
    	
    	
    	
    		//3. 이메일 체크 [문자열.indexOf("문자") : 해당 문자열내 문자가 존재하면 해당 문자의 인덱스 호출 / 만일 없으면 -1
    	if(email.indexOf("@") == -1) { //만일 입력한 이메일에 @가 없으면...
    		con.setText("@를 포함한 형식으로 입력해주세요.");
    		
    		return; //메소드 종료
    	}
    	
    	
    	
    		//4. 주소 체크 [문자열.contains("문자") : 해당 문자열내 문자가 존재하면 true / 없으면 false
    	
    	if(! address.contains("시") && address.contains("구") && address.contains("동")) {
    		con.setText("주소형식(시,구,동 포함)으로 입력해주세요.");
    		
    		return; //메소드 종료	
    	}
    	
    	
    	
    	
    	
    	
    	
    	//* 모든 유효성 검사 통과시 DB에 저장
    		//1. 객체화
    	Member member = new Member(0, id, pwcon, email, address, 0, since);
    
    		//2. DB 객체 내 메소드 호출
    	boolean result = MemberDao.memberDao.signup(member);
    	
    	
    	//3.확인
    	if(result) {
    		//1. 메시지 창 출력[alert : 메시지 클래스
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("알림"); //메시지 제목 설정
    		alert.setHeaderText("안산시 중고 거래에 가입을 축하합니다.");
    		alert.setContentText("회원가입 성공");
    		alert.showAndWait(); ///메시지 실행
    		
    		
    		
    		
    		//2. 화면 전환 [로그인 페이지 전환]
    		login.instance.loadpage("/view/loginpane.fxml");
    		
    		
    		
    		System.out.println("가입성공");
    	} else { 
    		con.setText("가입실패");
    		return;} //가입 못하게 메소드 종료
    	
    	
    	
    	
    	
    }

    
    
    
    
}
