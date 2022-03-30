package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class findid implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
    @FXML
    private TextField txtemail;

    @FXML
    private Button back;

    @FXML
    private Button findid;

    @FXML
    void accback(ActionEvent event) {
    	System.out.println("뒤로가기");
    	login.instance.loadpage("/view/loginpane.fxml");
    }

    
	
}
