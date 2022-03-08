package study;

import java.util.Random;
import java.util.Scanner;

public class ele1 {
	public static void main(String[] args) {
		
		/* 엘리베이터 코드화 하기
		 * 1. 엘리베이터의 현재 층
		 * 2. 내가 있는 현재 층
		 * 3. 엘리베이터 이동
		 */
		Random random = new Random();
		//랜덤 객체 지정
		Scanner scanner = new Scanner(System.in);
		// 스캐너 지정
		
		while (true) {
			
			System.out.println("1층부터 15층까지 운행합니다.");
			// 사용자가 입력할 수 있는 값을 나타낸다.
			System.out.print("내가 있는 층수는 : " ); int here = scanner.nextInt();
			//현재 내가 있는 층수를 입력 받아 저장한다.
			
			int elevator = random.nextInt(15)+1;	// 엘리베이터 장소는 랜덤. 0~14+1=15
			System.out.println("현재 엘리베이터의 위치는 " + elevator+ "층");
			//랜덤으로 받은 엘리베이터 값을 보여준다.
				
			System.out.print(here+"층에서 이동할 장소는 : "); int move = scanner.nextInt();
		//내가 이동할 장소를 지정하고 값을 저장한다.
			
				while (true) { //while2 start
					if(elevator == here) { System.out.println("엘리베이터에 탑승합니다."); }
				//만일 내가 있는 장소와 엘리베이터가 같으면  끝
				
				// 내가 있는 장소와 엘리베이터가 다르면 버튼을 눌러서 엘리베이터가 내가 있는 장소로 이동하도록 한다.
					else { System.out.println("엘리베이터가 "+elevator+"층에 있습니다. 1. 호출"); int ch2 = scanner.nextInt();
					//호출 값을 받아 if 생성
					if (ch2 == 1) {	int c = 0; //엘리베이터와 내가 있는 장소가 똑같아 지도록 c를 지정	
						if(elevator > here) { // 내가 있는 장소보다 위에 있으면 0으로 만들어준다.
							c = here - elevator; elevator=elevator+c;
							System.out.println("엘리베이터가 하강하였습니다. 탑승해주세요.");}
						else if(elevator < here) { // 내가 있는 장소보다 위에 있으면 0으로 만들어준다,
							c = elevator - here; elevator=elevator-c;
							System.out.println("엘리베이터가 상승하였습니다. 탑승해주세요.");} 
						//엘리베이터가 오면 탑승하고, 잘못된 선택지에 대한 알림 송출
						} else {System.err.println("올바른 버튼을 눌러주세요.");} //else end
					
					break;
			
		} //while2 end
	}// while end

		}
	///////////////////////////////////////////////
	} // me
} // c e
