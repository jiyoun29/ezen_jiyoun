package Day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class day10_6 {
	/*�� �����ġ : �޸� : RAM : ���α׷� ���� �ÿ��� ���� �޸�
	 ���� �����ġ : C����̺�, USB, CD : (���α׷�) ���� [���� ����]
	 ����ó�� [�ڹٳ� �޸�Ʋ -> ���������ġ]
	 DBó��[�ڹٳ� �޸� -> DB������ġ]
		Stream��Ʈ�� : ���α׷� �ܺ� [Ű���� ���� ��Ʈ��ũ��] ���
		 ��� ���� : byte
		FileOutputStream : ������� Ŭ����
			��ü��.write(����Ʈ��);
		FileInputStream	: �����Է� Ŭ����
			��ü��.read(����Ʈ�迭);
		String Ŭ����
			���ڿ�.equlas() : ���ڿ� �� �޼ҵ�
			���ڿ�.getBytes() : ���ڿ�->����Ʈ�� ��ȯ
			new String(����Ʈ�迭) : ����Ʈ�迭 -> ���ڿ� �迭
	����
	*/
	
	public static void main(String[] args) throws IOException {
							// throws <-������. ������ �־ ���ο��� �ְڴ�.
		
		//2. ���� ��� [ ����->�ڹ�]
	FileOutputStream ������� = new FileOutputStream("C:/java/java1.txt");
	// FileOutputStream : ���� ����� Ŭ����
	//FileOutputStream (���� ��� / ���ϸ�.Ȯ����); // 
	
	String ���� = "�ڹٿ��� �Էµ� ������";
	�������.write(����.getBytes() ); //����[����]
	
	
	
	//1. ���� �Է� [ �ڹ�->���� ]
	FileInputStream �����Է� = new FileInputStream("C:/java/java1.txt");
	byte[] bytes = new byte[1000];
	�����Է�.read(bytes);
	System.out.println("���ϳ��� : " + new String(bytes));
	
	
	
		
		
		////////////////////////////////////////
	}
}