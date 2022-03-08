package study;

import java.util.Random;
import java.util.Scanner;

public class ele2 {

	public static void main(String[] args) {
		
		/* 엘리베이터 코드화 하기
		 * 1. 엘리베이터의 현재 층
		 * 2. 내가 있는 현재 층
		 * 3. 엘리베이터 이동
		 */

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		while(true) { System.out.println("1층부터 15층까지 운영합니다.");
			System.out.print("내가 있는 층수는 : "); int here = scanner.nextInt();

			//엘레베이터 위치 입력값 랜덤
			int elevator = random.nextInt(15)+1; // 0~14+1 = 15
			System.out.println("현재 엘레베이터 위치는 : "+elevator+"층 입니다.");
		
			System.out.println(here + "층에서 이동할 위치는 : "); int move = scanner.nextInt();

				while(true) {
					if(elevator==here); {System.out.println("엘레베이터에 탑승합니다.");}
					//내가 있는 곳과 엘레베이터가 같으면 종료
				
					//다른 곳에 있는 엘레베이터 호출
					 { System.out.println("엘레베이터를 " +elevator+ "층에서 호출합니다. 1. 호출"); int ch2 = scanner.nextInt();
					 if (ch2 == 1) { int arr = 0; //0이 되어야 같은 곳에 있는 것	
					 
					 
						 if(elevator > here) {System.out.println("엘레베이터가 "+elevator+"층에서 내려옵니다.");
							arr = here - elevator; elevator=elevator-arr; //내가 있는 곳에서 엘레베이터 위치를 빼서 0이 되면 탑승 가능
							System.out.println(here+"층에 엘레베이터가 도착하였습니다. 탑승해주세요."); }
						//내가 있는 곳보다 엘레베이타기 위에 있으면
					
						 
						else if(elevator < here) {System.out.println("엘레베이터가 "+elevator+"층에서 올라옵니다.");
							arr = elevator - here ; elevator=elevator-arr; //내가 있는 곳에서 엘레베이터 위치를 빼서 0이 되면 탑승 가능
							System.out.println(here+"층에 엘레베이터가 도착하였습니다. 탑승해주세요."); }
						//내가 있는 곳보다 엘레베이터가 아래 있으면
					
						 
						else {System.out.println("알림)호출 버튼을 눌러주세요.");} //잘못 호출?
					break;} else {System.out.println("알림)호출 버튼을 눌러주세요.");}
				}
			
				} // while2 end
		} //while end	
	} // m e
	
} // c e
