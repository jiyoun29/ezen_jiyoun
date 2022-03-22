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
	
	// 차량 리스트 , 매출액 배열
	public static ArrayList<Car> carlist = new ArrayList<>();
	//주차장. 어래이리스트로 자동차를 닮을 주차장을 만든다.
	
	public static int[] totalcharge = new int[12];
	// 매출 저장. 12월 각각 따로 저장하므로 int형으로 저장(매출 메소드 확인)
	
	// 모든 메소드는 static ****
	
	
	
	
	// 0. 차량번호체크 메소드
	public static boolean checkcnum(String carnum) {
		//true false를 되돌리므로 boolean으로 자동차 넘버를 체크하는데 차량번호 문자열을 받아온다.
		if(carnum.length()==4) { //차량번호는 4자리수로만 읽을 수 있다.
			return true; //4자리라면 true
		} return false; //4자리가 아니라면 false로 받는다.
	}
	
	
	
	
	// 0 . 날짜체크 메소드
	public static boolean checkdate(String date) {
		//마찬가지로 true false를 되돌리므로 날짜를 받되 boolean으로 체크한다.
		
		//입력받은 월을 마지막 일을 구하기 위해(없는 날짜 받지 않도록) 객체를 하나 만들어둔다.
		Calendar calendar = Calendar.getInstance(); // 입력받은 월의 마지막일을 구하기 위해 객체 생성
		//캘린더는 이미 생성되어 있으므로 getInstance를 통해 가져온다.
		//getInstance란??? ** 기본 시간대 및 로케일을 사용하여 달력을 가져온다.

		
		//입력받은 날짜를 월 ,일로 구분해서 받는다. 0320 -> 3월 20일
		//이것을 100으로 나눠 저장. 0320 -> 3.2 저장
		int month = Integer.parseInt(date) / 100; // 입력받은 월일4자리를 월, 일로 구분
		
		//날짜를 100으로 나누고???나머지??
		int day = Integer.parseInt(date) % 100;  // 입력받은 월일4자리를 월, 일로 구분

		//캘린더의 12월?????
		calendar.set(2022, month-1, 1); // 마지막을 구하기위해 입력받은 월로 calendar 정의
		
		//입력받은 마지막 날을 
		//getActualMaximum :일정관리의 시간 값이 지정된 경우 지정된 일정관리 필드에 지정 가능한 최대값 반환.
		//기본 구현에서 반복 알고리즘을 사용하여 캘린더 필드의 실제 최대값을 결정, 가능하면 서브클래스를 효율적인 구현 덮어써야함
		int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH); // 입력받은 월의 마지막일을 구함
		
		if(month>=1 && month<=12 && day>=1 && day<=eday) { // 입력받은월이 1~12월일, 입력받은일이 1~마지막일 경우
			//월이 1보다 같거나 크고, 12월과 같거나 클때. 날짜가 1보다 크고, 월의 마지막 날과 같을때.
			
				return true; //true로 돌린다. ??????????
			}
			return false ; // 날짜 오류
		}
	
	
	
	
	
	// 0. 시간체크 메소드
	public static boolean checktime(String time) {
		//시간을 입력 받아 주차한 시간을 확인한다.
		
		
		int hour = Integer.parseInt(time) / 100 ;
		//입력 받은 시간을 100으로 나누어 저장한다.
		int minute = Integer.parseInt(time) % 100 ;
		//입력 받은 분을 100으로 나누어 나머지를 저장한다.
		if(hour>-1 && hour<24 && minute>-1 && minute<60) {
		//시간이 -1보다 크고 24보다 작으며 분 또한 -1보다 크고 60보다 작으면
			return true; //트루로 저장 ??????
		} // if e
		return false; // 시간 오류
	}
	
	
	
	
	
	
	
	// 0. 출차시간 체크 메소드
	public static boolean checkouttimedate (String carnum, String outtime) {
		//차량번호와 나가는 시간을 입력받는 메소드
		
		int i = 0 ; // 입력한 차번호의 인덱스 번호를 찾기위해 변수 선언
		for (Car temp : carlist) {
			//temp의 사용이유???
			//주차장에 입력된 car를 본다?
			if(temp.getCarnum().equals(carnum)) {
				//주차장에 입력된 차량번호를 가져와 내가 입력한 차량번호와 비교한다.
				// == 사용하지않고 equals를 사용한다.
				break; //가져오고 확인한다음 종료
				
			}
			
			i++; //0이었던 인덱스 i에 추가한다.
		}
		
		long diffTime = 0 ; //맨처음 difftime은 0으로 지정한다.
		//long은 int보다 큰 수를 저장
		

		//??
		try { //예외처리
			Date in = new SimpleDateFormat("MMddhhmm").parse(carlist.get(i).getIntime());
			//들어온 시간
			//SimpleDateFormat: 이미 생성된 기본 날짜 형식을 불러와 구성
			//parse: 지정된 문자열 선두에서 텍스트를 분석하여 날짜를 생성(전체 사용x)
			
			Date out = new SimpleDateFormat("MMddhhmm").parse(outtime);
			//나간 시간
			//
			
			diffTime = (out.getTime() - in.getTime()) / 60000 ; // 출차시간-입차시간 을 분으로 계산
			//나가는 시간에서 들어온 시간을 제외한 다음 60000으로 나눠 저장???
		}
		catch (Exception e) {	} //예외처리
		
		
		
		if (diffTime > 0 ) { // 출차시간이 0 보다 클시 ( 입차시간에 비해 출차시간이 늦은경우)
			return true;
		}
		else{ // 그 외 입력한 출차시간이 입차시간 이전인 경우
			return false;
		}
		
	}
	
	
	
	
	
	
	// 1. 입차 메소드
	public static boolean carin(String carnum, String intime) {
		//차량번호와 입차시간을 받아 입차를 저장한다.
		
		for(int i = 0 ; i <=11 ; i++) { // 배열 인덱스위치를 얻기위해 i 변수 사용
			//주차장 자리. i가 0이고 11까지 가면 0~11이므로 총 12자리. 1개씩 증가

			if(carlist.get(i).getCarnum().equals(" ")) { // 배열내 객체중 차량번호 "" 이면
				//주차장에서 차량넘버를 가져와 "   "를 비교.
				//즉 주차장에 있는 객체들이 "  "일 경우(아래)
			
				Car car = new Car(i, carnum, intime); // 매개변수로 객체 생성
				//새로운 자동차 객체를 만들고 인덱스(자리)와 차량번호, 입차시간을 저장한 다음
				
				carlist.remove(i); // i번째 객체를 지우고 ( i, "" , "" )
				//원래 "   "이던 i를 지우고
				
				carlist.add(i,car); // 매개변수로 생성한 객체 삽입
				//그 i자리에 위에서 생성한 car 객체를 더한다.
				
				save(); //파일에 저장한다.
				
				return true; //이게 되었다면 true로 반환
			}
		}
		return false;
	}

	
	
	
	
	
	//잠시보류
	// 2. 출차 메소드
	public static String carout(String carnum) {
		//차가 나갈때, 차량번호를 받아온다.

		boolean check = false ; String intime = null ;
		//잠시보류
		//입차시간은 비어있음?
		
		for(int i = 0 ; i <=11 ; i++) { // 배열 인덱스위치를 얻기위해 i 변수 사용
		//인덱스 i가 0이고 11까지 총 12번 돌 때
			
			if(carlist.get(i).getCarnum().equals(carnum)) { // 배열내 객체중 차량번호가 매개변수로 받은 차량번호와 같으면
				//주차장에서 인덱스 i를 가져오고 저장된 차량번호를 가져온다음 입력받은 차량번호랑 비교
				
				intime = carlist.get(i).getIntime(); // 삭제전 intime 데이터를 받아서 저장해두고
											// 저장을 어떻게??
				//
				
				carlist.remove(i); // i번째 객체를 지우고 ( i, carnum , intime )
				//주차장에서 i를 지운 다음
				
				Car car = new Car(i, " ", " "); // 차량번호 비어있는 객체 생성해서
				//비어있는 차량 객체를 만들어서
				
				carlist.add(i,car); // i번 인덱스에 삽입
				//아까 삭제한 i번째 인덱스에 집어넣는다.
				//이렇게 않을 경우 12개의 주차장 자리가 11개밖에 남지 않는다.
				
				check = true;
				//여기까지 진행이 되었다면 체크가 true이다.
				
				break;
			}
			
		}
		
		
		save(); //차량에 저장하고
		
		if (check == false) {
		
			return null ; // 입차실패시 null 리턴
		}
		
		
		else {
		
			return intime ; // 출차 성공시 차량 입차시간 리턴
		}
		
	}
	
	
	
	
	
	// 3. 요금계산 메소드
	public static int pay(String carnum, String outtime, String intime) { // 입출차 시간받아서 시간차이 계산
		//차량번호와 입출차 시간을 받아온다.
		
		long diffMin = 0 ; int fee = 0 ;
		//분은 더 많은 시간을 받아온다. fee=주차요금은 우선 0으로 받는다.
		//?????
		
		
		try { //예외처리
				Date in = new SimpleDateFormat("MMddhhmm").parse(intime);
				// 입차는 월일시분이며 parse?????로 입차시간을 가져온다.
				
				
				Date out = new SimpleDateFormat("MMddhhmm").parse(outtime);
				diffMin = (out.getTime() - in.getTime()) / 60000 ; // 시간차이를 분으로 계산하여 long으로 반환
				int parkingtime = (int)diffMin ; // long자료형을 int로 형변환
				if(parkingtime<30) {
					fee = 0;
				}
				else if(parkingtime>=30 && parkingtime<1440) {
					if(parkingtime >= 500) { //5만원의 제한
						fee = 50000 ;
					}		
					else {
						fee = (parkingtime-30) * 100;
					}
				}
				else if(parkingtime==1440) {
					fee = (parkingtime/1440)*50000 ;	
				} // else if e
				else { // 주차시간이 24시간이 넘어갈 경우
					if(parkingtime%1440>=500) {
						fee = ((parkingtime/1440)*50000) + 50000 ;
					}
					else {
						fee = ((parkingtime/1440)*50000)+((parkingtime%1440)*100);
					}
				} // else e			
		}
		catch (Exception e) {} //예외처리
		
		return fee; // 주차요금 반환
	}
	
	// 4. 매출계산 메소드
	// (상단의 public static int[] totalcharge = new int[12];를 여기로 가져와서 확인)
	public static void volume(String date, int charge) { // 출차월일, 주차요금 매개변수 받아서
		String month = date.substring(0,2); // 앞 두인덱스만 추출하여 (월)
		switch(month) { // 1~12월일경우 totalcharge배열에 증액
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
		
	// 5. 차량리스트 저장메소드
	public static void save() {		
		try {
			FileOutputStream outputStream = new FileOutputStream("C:/java/주차장.txt"); // 파일출력객체
			for(Car temp : carlist) {
				String file = temp.getLocation()+","+temp.getCarnum()+","+temp.getIntime()+"\n"; 
				outputStream.write(file.getBytes()); // 내보내기
			}

		}
		catch (Exception e) {
		}	
	}
	public static void save2() {
		try {
			FileOutputStream outputStream2 = new FileOutputStream("C:/java/매출.txt");
			for(int temp : totalcharge) {
				String file2 = String.valueOf(temp)+"," ;
				outputStream2.write(file2.getBytes()); // 내보내기
			}
		}
		catch (Exception e) {
		}
		
			
	}
	// 6. 차량 리스트 불러오기메소드
	public static void load() { 

		try {
			FileInputStream inputStream = new FileInputStream("C:/java/주차장.txt"); // 파일입력객체
			byte[] bytes = new byte[1024]; // 바이트배열 선언
			inputStream.read(bytes); // 바이트 읽어와서 바이트배열에 저장
			String file = new String(bytes); // 바이트 -> 문자열
			String[] list = file.split("\n"); // 문자열자르기
			int i = 0 ;
			for(String temp : list) {
				if( i+1 == list.length) {
					break;
				}
				String[] field = temp.split(","); // 문자열 자르기
				Car car = new Car(Integer.parseInt(field[0]),field[1],field[2]); // 객체생성
				carlist.remove(i);
				carlist.add(i,car); // 리스트 저장
				i++;
			}
		}
		catch (Exception e) {
		}	
	}
	
	public static void load2() {
		try {
			FileInputStream inputStream2 = new FileInputStream("C:/java/매출.txt");	 
			byte[] bytes2 = new byte[1024]; // 바이트배열 선언
			inputStream2.read(bytes2); // 바이트 읽어와서 바이트배열에 저장
			String file2 = new String(bytes2); // 바이트 -> 문자열
			String[] list2 = file2.split(","); // 문자열자르기
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
