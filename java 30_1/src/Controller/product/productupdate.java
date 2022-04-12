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
		
		if(product.getPcategory().equals("�����Ƿ�")) {opt1.setSelected(true);}
		if(product.getPcategory().equals("�����Ƿ�")) {opt2.setSelected(true);}
		if(product.getPcategory().equals("���ӱ��")) {opt3.setSelected(true);}
		if(product.getPcategory().equals("��Ȱ��ǰ")) {opt4.setSelected(true);}
		
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
    	
    	if(pimage == null) { //���� ������ ������
    				//���� ���� ��θ� �״�� �����´�.
    		pimage = ProductControl.select.getPimg();
    		
    		String pcategory = null;
    		//������ �Ǿ������� ~��� ����,
    		if(opt1.isSelected()) pcategory="�����Ƿ�";
    		if(opt2.isSelected()) pcategory="�����Ƿ�";
    		if(opt3.isSelected()) pcategory="���ӱ��";
    		if(opt4.isSelected()) pcategory="��Ȱ��ǰ";
    	
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
    		alert.setHeaderText("��ǰ ���� ����");
    		alert.showAndWait();
    		Home.home.loadpage("/view/product/productview.fxml");
    	} else { 
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("��ǰ ���� ����");
    		alert.showAndWait();    		
    	}
    }
    }

    @FXML
    void imgadd(ActionEvent event) {
    	//�̹��� ��� ��ư�� Ŭ������ ��
    	//1. ���� ���� Ŭ���� ��ü ����
    	FileChooser fileChooser = new FileChooser();
    	
    		//2. ���ϼ���[����] ����
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("�̹�������:imagefile", "*png","*jpg","*jpeg","*gif"));
    	
    	//3.���ο� stage(������â)
    	File file = fileChooser.showOpenDialog(new Stage());
    		//���ϼ��ð�ü.sho~log(�������� �̸�)
    		//filechooser ȭ�鿡�� ���õ� ������ file Ŭ���� ��üȭ
    	
    	//4. ������ ������ ��� ǥ��
    	txtpath.setText("���� ��� :" + file.getPath());
    	
    		//5.���� ��� ����
    	pimage = file.toURI().toString();
    						//toString : ���ڿ� ��ȯ

    	//5. �̹��� �̸����� ����
    	Image image = new Image(pimage);
    	img.setImage(image);
    	
    	
    	//*���õ� ������ ���� ������Ʈ ������ �����ؿ���
    	//1. ���� �Է� ��Ʈ�� [�̵����� : ����Ʈ]    	
    	try { FileInputStream inputStream = new FileInputStream(file);
    			//���õ� ������ �������
    		//file:filechooser���� ���õ� ���� ��ü
    	//2. ���� ��� ��Ʈ��
    			//���� �̸��� ��� ����			// ���								// /�������ϴ�.    	
    		File copyfile = new File("C:/Users/JIYUN/git/git2/ezen_jiyoun/src/img/"+file.getName());
    		FileOutputStream outputStream = new FileOutputStream(copyfile);
    		//img��Ű���� ����Ʈ�� �����ؼ� ����
    		
    	//3. ����Ʈ �迭 ����
    		byte[] bytes = new byte[1024*1024*1024];
    		//1����Ʈ->1024����Ʈ->1Ű�ι���ũ->1024Ű�ι���Ʈ->1�ް�����Ʈ
    		
    	//4. �ݺ��� �̿��� inputstream�� ���� ��Ʈ�� ��� �о����
    		int size;
    		while( (size = inputStream.read(bytes)) > 0) { //�о�� �� �����ϰ� ����� ���.
    				//�о�� ����Ʈ�� 0���� ������ �ݺ��� ����
    			outputStream.write(bytes , 0 , size); //�о�� ����Ʈ��ŭ ��������
    		}
    	
    	//5. �뷮�� ū ��� ��Ʈ�� ���� �ʼ�*
    		inputStream.close();
    		outputStream.close();
    		
    		//����� ������ ��θ� db�� ����
        	pimage = copyfile.toURI().toString();
    		
    	} catch (Exception e) {System.out.println("sql����:"+e);}

    }

    
}
