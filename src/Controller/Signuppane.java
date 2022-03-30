package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Signuppane implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	

    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpw;

    @FXML
    private Button btback;

    @FXML
    private Button btsignup;

    @FXML
    private Label con;

    @FXML
    private PasswordField txtpwcon;

    @FXML
    private TextField email;

    @FXML
    private TextField btsign;


    @FXML
    void accback(ActionEvent event) {
    	System.out.println("뒤로가기");
    	login.instance.loadpage("/view/loginpane.fxml");
    	
    }
    
}
