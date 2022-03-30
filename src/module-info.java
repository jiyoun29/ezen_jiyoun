module java 30_1 {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
