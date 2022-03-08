package study;

import java.util.Random;
import java.util.Scanner;

public class ele3 {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("1층부터 15층까지 운영합니다.");
		System.out.println("현재 내가 있는 층은 : "); int here = scanner.nextInt();
		
		//엘레베이터 랜덤
		int ele = random.nextInt(15)+1; //참고
		System.out.println("현재 엘레베이터 위치는 : "+ele+"층");
		
		System.out.println(here+"층에서 이동할 위치는 : "); int mov = scanner.nextInt();
		
		while(true) { if(ele==here) { System.out.println("엘레베이터에 탑승합니다.");}
		else { //같지 않으면 호출
			System.out.println(ele+"층에 있는 엘레베이터를 "+here+"층으로 호출합니다. 1.호출"); int ho = scanner.nextInt();
			//엘레베이터 호출값 ho
			//참고
				if (ho == 1) { int ar = 0;
				
					if(ele>here) { System.out.println("엘레베이터가 "+ele+"층에서 내려옵니다.");
						ar = here-ele; ele=ele-ar;
						System.out.println("엘레베이터가 "+here+"층에 도착하였습니다.");
					} else if (ele<here) { System.out.println("엘레베이터가 "+ele+"층에서 올라옵니다.");
						ar = ele-here; ele=ele-ar;
						System.out.println("엘레베이터가 "+here+"층에 도착했습니다.");
					} else {
						System.out.println("알림)엘레베이터를 호출해주세요.");
					}
					break;
				} else {System.out.println("알림) 엘레베이터를 호출해주세요.");}
			
		}
	
		
		} // while end
	} // me

} // ce
