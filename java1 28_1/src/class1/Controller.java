package class1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Controller  {
	
///////////////////////////////////////////////////////////////////////////////////////
	
	// ���� ����Ʈ , ����� �迭
	public static ArrayList<Car> carlist = new ArrayList<>();
	//������. ��̸���Ʈ�� �ڵ����� ���� �������� �����.
	
	public static int[] totalcharge = new int[12];
	// ���� ����. 12�� ���� ���� �����ϹǷ� int������ ����(���� �޼ҵ� Ȯ��)
	
	// ��� �޼ҵ�� static ****
	
	
	
	
	// 0. ������ȣüũ �޼ҵ�
	public static boolean checkcnum(String carnum) {
		//true false�� �ǵ����Ƿ� boolean���� �ڵ��� �ѹ��� üũ�ϴµ� ������ȣ ���ڿ��� �޾ƿ´�.
		if(carnum.length()==4) { //������ȣ�� 4�ڸ����θ� ���� �� �ִ�.
			return true; //4�ڸ���� true
		} return false; //4�ڸ��� �ƴ϶�� false�� �޴´�.
	}
	
	
	
	
	// 0 . ��¥üũ �޼ҵ�
	public static boolean checkdate(String date) {
		//���������� true false�� �ǵ����Ƿ� ��¥�� �޵� boolean���� üũ�Ѵ�.
		
		//�Է¹��� ���� ������ ���� ���ϱ� ����(���� ��¥ ���� �ʵ���) ��ü�� �ϳ� �����д�.
		Calendar calendar = Calendar.getInstance(); // �Է¹��� ���� ���������� ���ϱ� ���� ��ü ����
		//Ķ������ �̹� �����Ǿ� �����Ƿ� getInstance�� ���� �����´�.
		//getInstance��??? ** �⺻ �ð��� �� �������� ����Ͽ� �޷��� �����´�.

		
		//�Է¹��� ��¥�� �� ,�Ϸ� �����ؼ� �޴´�. 0320 -> 3�� 20��
		//�̰��� 100���� ���� ����. 0320 -> 3.2 ����
		int month = Integer.parseInt(date) / 100; // �Է¹��� ����4�ڸ��� ��, �Ϸ� ����
		
		//��¥�� 100���� ������???������??
		int day = Integer.parseInt(date) % 100;  // �Է¹��� ����4�ڸ��� ��, �Ϸ� ����

		//Ķ������ 12��?????
		calendar.set(2022, month-1, 1); // �������� ���ϱ����� �Է¹��� ���� calendar ����
		
		//�Է¹��� ������ ���� 
		//getActualMaximum :���������� �ð� ���� ������ ��� ������ �������� �ʵ忡 ���� ������ �ִ밪 ��ȯ.
		//�⺻ �������� �ݺ� �˰����� ����Ͽ� Ķ���� �ʵ��� ���� �ִ밪�� ����, �����ϸ� ����Ŭ������ ȿ������ ���� ��������
		int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH); // �Է¹��� ���� ���������� ����
		
		if(month>=1 && month<=12 && day>=1 && day<=eday) { // �Է¹������� 1~12����, �Է¹������� 1~�������� ���
			//���� 1���� ���ų� ũ��, 12���� ���ų� Ŭ��. ��¥�� 1���� ũ��, ���� ������ ���� ������.
			
				return true; //true�� ������. ??????????
			}
			return false ; // ��¥ ����
		}
	
	
	
	
	
	// 0. �ð�üũ �޼ҵ�
	public static boolean checktime(String time) {
		//�ð��� �Է� �޾� ������ �ð��� Ȯ���Ѵ�.
		
		
		int hour = Integer.parseInt(time) / 100 ;
		//�Է� ���� �ð��� 100���� ������ �����Ѵ�.
		int minute = Integer.parseInt(time) % 100 ;
		//�Է� ���� ���� 100���� ������ �������� �����Ѵ�.
		if(hour>-1 && hour<24 && minute>-1 && minute<60) {
		//�ð��� -1���� ũ�� 24���� ������ �� ���� -1���� ũ�� 60���� ������
			return true; //Ʈ��� ���� ??????
		} // if e
		return false; // �ð� ����
	}
	
	
	
	
	
	
	
	// 0. �����ð� üũ �޼ҵ�
	public static boolean checkouttimedate (String carnum, String outtime) {
		//������ȣ�� ������ �ð��� �Է¹޴� �޼ҵ�
		
		int i = 0 ; // �Է��� ����ȣ�� �ε��� ��ȣ�� ã������ ���� ����
		for (Car temp : carlist) {
			//temp�� �������???
			//�����忡 �Էµ� car�� ����?
			if(temp.getCarnum().equals(carnum)) {
				//�����忡 �Էµ� ������ȣ�� ������ ���� �Է��� ������ȣ�� ���Ѵ�.
				// == ��������ʰ� equals�� ����Ѵ�.
				break; //�������� Ȯ���Ѵ��� ����
				
			}
			
			i++; //0�̾��� �ε��� i�� �߰��Ѵ�.
		}
		
		long diffTime = 0 ; //��ó�� difftime�� 0���� �����Ѵ�.
		//long�� int���� ū ���� ����
		

		//??
		try { //����ó��
			Date in = new SimpleDateFormat("MMddhhmm").parse(carlist.get(i).getIntime());
			//���� �ð�
			//SimpleDateFormat: �̹� ������ �⺻ ��¥ ������ �ҷ��� ����
			//parse: ������ ���ڿ� ���ο��� �ؽ�Ʈ�� �м��Ͽ� ��¥�� ����(��ü ���x)
			
			Date out = new SimpleDateFormat("MMddhhmm").parse(outtime);
			//���� �ð�
			//
			
			diffTime = (out.getTime() - in.getTime()) / 60000 ; // �����ð�-�����ð� �� ������ ���
			//������ �ð����� ���� �ð��� ������ ���� 60000���� ���� ����???
		}
		catch (Exception e) {	} //����ó��
		
		
		
		if (diffTime > 0 ) { // �����ð��� 0 ���� Ŭ�� ( �����ð��� ���� �����ð��� �������)
			return true;
		}
		else{ // �� �� �Է��� �����ð��� �����ð� ������ ���
			return false;
		}
		
	}
	
	
	
	
	
	
	// 1. ���� �޼ҵ�
	public static boolean carin(String carnum, String intime) {
		//������ȣ�� �����ð��� �޾� ������ �����Ѵ�.
		
		for(int i = 0 ; i <=11 ; i++) { // �迭 �ε�����ġ�� ������� i ���� ���
			//������ �ڸ�. i�� 0�̰� 11���� ���� 0~11�̹Ƿ� �� 12�ڸ�. 1���� ����

			if(carlist.get(i).getCarnum().equals(" ")) { // �迭�� ��ü�� ������ȣ "" �̸�
				//�����忡�� �����ѹ��� ������ "   "�� ��.
				//�� �����忡 �ִ� ��ü���� "  "�� ���(�Ʒ�)
			
				Car car = new Car(i, carnum, intime); // �Ű������� ��ü ����
				//���ο� �ڵ��� ��ü�� ����� �ε���(�ڸ�)�� ������ȣ, �����ð��� ������ ����
				
				carlist.remove(i); // i��° ��ü�� ����� ( i, "" , "" )
				//���� "   "�̴� i�� �����
				
				carlist.add(i,car); // �Ű������� ������ ��ü ����
				//�� i�ڸ��� ������ ������ car ��ü�� ���Ѵ�.
				
				save(); //���Ͽ� �����Ѵ�.
				
				return true; //�̰� �Ǿ��ٸ� true�� ��ȯ
			}
		}
		return false;
	}

	
	
	
	
	
	//��ú���
	// 2. ���� �޼ҵ�
	public static String carout(String carnum) {
		//���� ������, ������ȣ�� �޾ƿ´�.

		boolean check = false ; String intime = null ;
		//��ú���
		//�����ð��� �������?
		
		for(int i = 0 ; i <=11 ; i++) { // �迭 �ε�����ġ�� ������� i ���� ���
		//�ε��� i�� 0�̰� 11���� �� 12�� �� ��
			
			if(carlist.get(i).getCarnum().equals(carnum)) { // �迭�� ��ü�� ������ȣ�� �Ű������� ���� ������ȣ�� ������
				//�����忡�� �ε��� i�� �������� ����� ������ȣ�� �����´��� �Է¹��� ������ȣ�� ��
				
				intime = carlist.get(i).getIntime(); // ������ intime �����͸� �޾Ƽ� �����صΰ�
											// ������ ���??
				//
				
				carlist.remove(i); // i��° ��ü�� ����� ( i, carnum , intime )
				//�����忡�� i�� ���� ����
				
				Car car = new Car(i, " ", " "); // ������ȣ ����ִ� ��ü �����ؼ�
				//����ִ� ���� ��ü�� ����
				
				carlist.add(i,car); // i�� �ε����� ����
				//�Ʊ� ������ i��° �ε����� ����ִ´�.
				//�̷��� ���� ��� 12���� ������ �ڸ��� 11���ۿ� ���� �ʴ´�.
				
				check = true;
				//������� ������ �Ǿ��ٸ� üũ�� true�̴�.
				
				break;
			}
			
		}
		
		
		save(); //������ �����ϰ�
		
		if (check == false) {
		
			return null ; // �������н� null ����
		}
		
		
		else {
		
			return intime ; // ���� ������ ���� �����ð� ����
		}
		
	}
	
	
	
	
	
	// 3. ��ݰ�� �޼ҵ�
	public static int pay(String carnum, String outtime, String intime) { // ������ �ð��޾Ƽ� �ð����� ���
		//������ȣ�� ������ �ð��� �޾ƿ´�.
		
		long diffMin = 0 ; int fee = 0 ;
		//���� �� ���� �ð��� �޾ƿ´�. fee=��������� �켱 0���� �޴´�.
		//?????
		
		
		try { //����ó��
				Date in = new SimpleDateFormat("MMddhhmm").parse(intime);
				// ������ ���Ͻú��̸� parse?????�� �����ð��� �����´�.
				
				
				Date out = new SimpleDateFormat("MMddhhmm").parse(outtime);
				diffMin = (out.getTime() - in.getTime()) / 60000 ; // �ð����̸� ������ ����Ͽ� long���� ��ȯ
				int parkingtime = (int)diffMin ; // long�ڷ����� int�� ����ȯ
				if(parkingtime<30) {
					fee = 0;
				}
				else if(parkingtime>=30 && parkingtime<1440) {
					if(parkingtime >= 500) { //5������ ����
						fee = 50000 ;
					}		
					else {
						fee = (parkingtime-30) * 100;
					}
				}
				else if(parkingtime==1440) {
					fee = (parkingtime/1440)*50000 ;	
				} // else if e
				else { // �����ð��� 24�ð��� �Ѿ ���
					if(parkingtime%1440>=500) {
						fee = ((parkingtime/1440)*50000) + 50000 ;
					}
					else {
						fee = ((parkingtime/1440)*50000)+((parkingtime%1440)*100);
					}
				} // else e			
		}
		catch (Exception e) {} //����ó��
		
		return fee; // ������� ��ȯ
	}
	
	// 4. ������ �޼ҵ�
	// (����� public static int[] totalcharge = new int[12];�� ����� �����ͼ� Ȯ��)
	public static void volume(String date, int charge) { // ��������, ������� �Ű����� �޾Ƽ�
		String month = date.substring(0,2); // �� ���ε����� �����Ͽ� (��)
		switch(month) { // 1~12���ϰ�� totalcharge�迭�� ����
			case "01" : totalcharge[0] += charge ; break;
			case "02" : totalcharge[1] += charge ; break;
			case "03" : totalcharge[2] += charge ; break;
			case "04" : totalcharge[3] += charge ; break;
			case "05" : totalcharge[4] += charge ; break;
			case "06" : totalcharge[5] += charge ; break;
			case "07" : totalcharge[6] += charge ; break;
			case "08" : totalcharge[7] += charge ; break;
			case "09" : totalcharge[8] += charge ; break;
			case "10" : totalcharge[9] += charge ; break;
			case "11" : totalcharge[10] += charge ; break;
			case "12" : totalcharge[11] += charge ; break;
		} 
	}
		
	// 5. ��������Ʈ ����޼ҵ�
	public static void save() {		
		try {
			FileOutputStream outputStream = new FileOutputStream("C:/java/������.txt"); // ������°�ü
			for(Car temp : carlist) {
				String file = temp.getLocation()+","+temp.getCarnum()+","+temp.getIntime()+"\n"; 
				outputStream.write(file.getBytes()); // ��������
			}

		}
		catch (Exception e) {
		}	
	}
	public static void save2() {
		try {
			FileOutputStream outputStream2 = new FileOutputStream("C:/java/����.txt");
			for(int temp : totalcharge) {
				String file2 = String.valueOf(temp)+"," ;
				outputStream2.write(file2.getBytes()); // ��������
			}
		}
		catch (Exception e) {
		}
		
			
	}
	// 6. ���� ����Ʈ �ҷ�����޼ҵ�
	public static void load() { 

		try {
			FileInputStream inputStream = new FileInputStream("C:/java/������.txt"); // �����Է°�ü
			byte[] bytes = new byte[1024]; // ����Ʈ�迭 ����
			inputStream.read(bytes); // ����Ʈ �о�ͼ� ����Ʈ�迭�� ����
			String file = new String(bytes); // ����Ʈ -> ���ڿ�
			String[] list = file.split("\n"); // ���ڿ��ڸ���
			int i = 0 ;
			for(String temp : list) {
				if( i+1 == list.length) {
					break;
				}
				String[] field = temp.split(","); // ���ڿ� �ڸ���
				Car car = new Car(Integer.parseInt(field[0]),field[1],field[2]); // ��ü����
				carlist.remove(i);
				carlist.add(i,car); // ����Ʈ ����
				i++;
			}
		}
		catch (Exception e) {
		}	
	}
	
	public static void load2() {
		try {
			FileInputStream inputStream2 = new FileInputStream("C:/java/����.txt");	 
			byte[] bytes2 = new byte[1024]; // ����Ʈ�迭 ����
			inputStream2.read(bytes2); // ����Ʈ �о�ͼ� ����Ʈ�迭�� ����
			String file2 = new String(bytes2); // ����Ʈ -> ���ڿ�
			String[] list2 = file2.split(","); // ���ڿ��ڸ���
			int i = 0 ;
			for(String temp : list2) {
				if( i+1 == list2.length) {
					break;
				}
				totalcharge[i] = Integer.parseInt(temp);
				i++;
			}
		}
		catch (Exception e) {
		}
	}

	/////////////////////////////////////////////////////////////////////
} //class end
