package team3;

import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Controller {

	public static boolean ��¥üũ(String ��¥) {
		Calendar calendar = Calendar.getInstance(); // �Է¹��� ���� ������ ���� ���ϱ� ����
		int month = Integer.parseInt(��¥) / 100; // �Է¹��� ��¥ 4�ڸ����Ŀ��� ���� 2�ڸ��� '��'�� ����
		int day = Integer.parseInt(��¥) % 100; // �Է¹��� ��¥ 4�ڸ����Ŀ��� ���� 2�ڸ��� '��'�� ����
		calendar.set(2022, month-1, 1); // �Է¹��� ���� ���������ڸ� ���ϱ� ���� �� 1�Ϸ� ����
		int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH); // �Է¹��� ���� ���������� ����
		if(month>=1 && month<=12 && day>=1 && day<=eday) {
			return true;
		} // if e
		return false;
	} // ��¥üũ e
	
	public static void ������() {
		for(Room temp : ȣ�ڿ���.roomlist) {
			if(temp != null) {
				System.out.println(temp.getDate()+"\t"+temp.getRname()+"\t\t"+temp.getName());
			} // if e
		} // for e
	} // ������ e

	public static int ����(String ��¥, String name, int ch) {
		
		Room room1 = new Room("Ʈ����", "10,000��","����Ұ�", name, ��¥);
		Room room2 = new Room("�����", "20,000��","����Ұ�", name, ��¥);
		Room room3 = new Room("�ٴٺ�Ʈ����", "30,000��","����Ұ�", name, ��¥);
		Room room4 = new Room("�ٴٺ�����", "40,000��","����Ұ�", name, ��¥);
		Room room5 = new Room("����Ʈ��", "50,000��","����Ұ�", name, ��¥);
		
		for(int i = 0; i<ȣ�ڿ���.roomlist.length; i++) {
			if(ȣ�ڿ���.roomlist[i]==null) {
					if(ch==1) {	ȣ�ڿ���.roomlist[i]=room1;
						return 1; } // if e
					else if(ch==2) { ȣ�ڿ���.roomlist[i]=room2;
						return 2; } // else if e
					else if(ch==3) { ȣ�ڿ���.roomlist[i]=room3;
						return 3; } // else if e
					else if(ch==4) { ȣ�ڿ���.roomlist[i]=room4;
						return 4; } // else if e
					else if(ch==5) { ȣ�ڿ���.roomlist[i]=room5;
						return 5; } // else if e
					} // if e
				} // for e	
			return 6; } // ���� e

	
	///////////////////////////
	
	
	public static void ��� (String id) {
		
		
		
	} // ��� end
	
	
	
	

//	public static int ����(int �ݾ�) {
//		for(Room temp : ȣ�ڿ���.roomlist) {
//			if(temp.getRname().equals("Ʈ����")) {
//				if(�ݾ�<10000) {	return 1; }
//				else {	return 2; } // else e
//			} // if e
//			else if(temp.getRname().equals("�����")) {
//				
//			} // else if
//		} // for e
//		
//	return 10;
//	} // ���� e
	
	
	
	
} // ce
