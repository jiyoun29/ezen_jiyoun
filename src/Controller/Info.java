package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.login.login;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Info implements Initializable {
	
	
	@FXML
	private Label lblid;

	@FXML
	private Label lblemail;

	@FXML
	private Label lbladdress;

	@FXML
	private Label lblpoint;

	@FXML
	private Label lblsince;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
		lblid.setText(login.member.getMid());
		lblemail.setText(login.member.getMemail());
		lbladdress.setText(login.member.getMaddress());
		lblpoint.setText(login.member.getMpoint()+"");
		lblsince.setText(login.member.getMsince());

	
	
	}





}
