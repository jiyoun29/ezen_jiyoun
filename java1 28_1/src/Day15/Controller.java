package Day15;

import java.util.ArrayList;

public class Controller {


	public static ArrayList<Car> 주차장 = new ArrayList<>();
	
	
	//입차시간 메소드
	
	
	

	//입차 메소드
	public static boolean 입차 ( String 차량번호 ) {
		
		//입차 코드 작성 (순서도 만들기)
			//1. 입력받은 차량번호(인수)를 가져온다.		* 중복 체크
			//2. 입차 날짜를 구한다.
			//3. 입차 시간을 구한다.
			// 출차 시간, 금액은 출차 시 진행
			//4. 3가지 변수를 하나의 객체로 만듦(객체화) ->new로 묶는것
			//5. 저장을 위해 차량객체를 배열이나 리스트에 넣음
			//6. 파일처리나 DB처리
		
		//일단 시간 ㅃ ㅐ고 차량번호만 받아서 저장
		
		for(int i = 0; i<=100; i++) {
			//주차장 자리
			if(주차장.get(i).get차량번호().equals(차량번호));{
			//주차장에서 차량번호와 비교
			Car car = new Car();
			주차장.remove(i);
			주차장.add(car);
			return true;
			}
		}

				
		return false;
		
	}
	
	
	//출차시간 메소드
	
	
	
	
	//출차 메소드
	
	public static boolean 출차 ( String 차량번호 ) {
		
		//출차 코드 작성
			//1. 입력받은 차량번호(인수)를 가져온다.
			//2. 배열or리스트 내 동일한  차량 번호를  찾음
			//3. 출차시간(현재시간)을 구한다.    *변수 이름만 다름
			//4. 계산 [ 출차시간 - 입차시간 => 분(단위로 받아서 계산(하루계산x))- 30)/10(1의 자리수 없앰)*1000 ]
			//5. 찾은 객체 내 출차 시간과 금액을 대입한다. (수정) 
		
		//일단 요금 제외하고 차량번호만
		
		for(int i = 0; i<=100; i++) {
			
			if(주차장.get(i).get차량번호().equals(차량번호)) {
			//받은 것과 비교
				//이부분에서 삭제 전 시간 저장 코드 삽입해야함
				
			주차장.remove(i);
			//삭제
						
			break;
				
			} //if end
			
			else {System.out.println("잘못된 입력입니다.");}
			
		} //for end 
		
		return false;
	}

//app에 적어둠	
	
	
	
	
	
	
	
	

}
