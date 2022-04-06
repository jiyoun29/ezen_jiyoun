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
    	//1.��Ʈ�ѿ� �Էµ� ������ �������� (��ȿ�� �˻� ����)
    	String pname = txtpname.getText();
    	String pcontent = txtpcontent.getText();
    	int pprice = Integer.parseInt(txtpprice.getText());	//���ڿ� -> ������ ��ȯ
    		//*ī�װ�
    	String pcategoty = "";
    		if(opt1.isSelected()) {	//���� opt1�̶�� fxid�� ��Ʈ���� ���õǾ�����
    			pcategoty="�����Ƿ�"; }
    		if(opt2.isSelected()) {pcategoty="�����Ƿ�";}
    		if(opt3.isSelected()) {pcategoty="���ӱ��";}
    		if(opt4.isSelected()) {pcategoty="��Ȱ��ǰ";}
    	int mnum = login.member.getMnum();
    		    	
    	//2.��üȭ
    	Product product = new Product(0, pname, pimage, pcontent, pcategoty, pprice, 1, null, mnum);
    	
    	//3.DBó��
    	boolean result = ProductDao.productDao.add(product);
    	
    	//4.���ó��
    	if(result) { Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("��ǰ ��� �Ϸ�");
    		alert.showAndWait();
    		
    		Home.home.loadpage("/view/product/product.fxml");
    		
    	} else {Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("��ǰ ��� ����");
		alert.showAndWait();
		}

    }

    
    
    
    @FXML
    void accback(ActionEvent event) {
    	Home.home.loadpage("/view/product/product.fxml");

    }

    
    //��� ������ ���� �ۿ� ����������
    private String pimage = null;
    	//�޼ҵ� �ۿ��� �����ϴ� ���� : imgeadd�޼ҵ�� add �޼ҵ忡�� ����ϱ� ����
    
    
    @FXML
    void imgadd(ActionEvent event) { //�̹��� ��� ��ư�� Ŭ������ ��
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

    	//���� ��ΰ� �ٸ�
//    		System.out.println(file.getPath()); 			��α��м� : \
//    		System.out.println(file.toURI());				��α��м� : /
//    		System.out.println(file.toURI().toString());	��α��м� : /
    	
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
