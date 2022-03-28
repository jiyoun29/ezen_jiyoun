package teat2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import Day01.Car;

public class Controller {
 //컨트롤러 : 각각 메소드를 만들어서 동작하는 부분을 만들기
	
	
	//자동차를 저장할 주차장 리스트를 만든다.
	public static ArrayList<teat2.Car> 주차장 = new ArrayList<teat2.Car>();
	//앞에 퍼블릭 스타틱 잊지 말고 넣기(아래에서 못 받음)
	
	
	//입차
		//차량번호를 받고 입차시간은 현재시간을 찍음
		//출차시간은 출차할 때만 나가도록 하고 그 이전에는 주차 중
		//금액도 나갈때 정산하고 그 전에는 정산 전으로 표시
	//view에서 입력 받은 차량 번호를 가져온다..
	public static boolean 입차(String 차량번호) { //인수
		//차량번호를 가져왔으면 주차장의 빈 공간에 주차한다.
		//중복체크
		for (teat2.Car temp : 주차장) { //주차장을 돈다.
			if(temp.get차량번호().equals(차량번호)) {
				//주차장에 있는 원래 차량번호와 내가 입력받은 차량번호가 동일한지 확인 후
				return false; //리턴
			}
		}
		//입차한 날짜와 시간은 현재 시간으로 받아온다. //now = 현재 시간
		LocalDate 날짜 =	LocalDate.now();
		LocalTime 입차시간 = LocalTime.now();
	//LocalTime.now() = 현재시간;
		
		//세가지를 다 받았으면
		//하나의 객체로 바꿔서 주차장에 넣어줘야 한다.
		
		teat2.Car car = new teat2.Car(날짜, 차량번호, 입차시간, null, 0);
		//출차시간은 아직 받지 못했으니까 비어있다는 뜻으로  null이 된다. 금액도 아직 정산 전이니까 0
		주차장.add(car);
		//추자장에 위에서 만든 자동차를 넣어준다.
		
		//파일처리 하지 않으므로 save 넣지 않는다.
		
		return false;
	} //end
	
	
	
	//출차
		//차량번호를 받고 출차시간을 찍고 시간을 계산해서 요금 출력
	public static boolean 출차(String 차량번호) { //인수
		//차량번호를 가져왔으면 주차장에 주차되어 있는지를 확인한다.
		
		for (teat2.Car temp : 주차장) { //입차할 때랑 똑같이 차량번호를 가지고주차장을 돈다.
			if(temp.get차량번호().equals(차량번호)) {
//				//주차장에 있는 원래 차량번호와 내가 입력받은 차량번호가 동일한지 확인 후

				//확인한 다음에 일치하면 출차하는 지금 시간을 구하고
				LocalTime 출차시간 = LocalTime.now(); //현재 시간을 나간 시간으로 넣는다.
				
				//시간을 분으로 바꿔서 요금을 계산한다.
				//30분 무료, 10분씩 1000원
				
				
				
				
				
				
				//차이 구하기
//		int 이용시간 = temp.get입차시간().until(출차시간, ChronoUnit.MINUTES);
				
//				두 개의 특정 날짜 사이의 차이를 일수(days)로 구하려면 ChronoUnit.DAYS.between(a, b)를 사용합니다.
				
				return false; } } //boolean에는 return 

		return false;
	} //end
		
}
