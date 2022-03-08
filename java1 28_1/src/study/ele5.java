package study;

import java.util.Random;
import java.util.Scanner;

public class ele5 {

	public static void main(String[] args) {
		
		
		/* 1. 엘리베이터의 현재 층
		 * 2. 내가 있는 현재 층
		 * 3. 엘리베이터 이동
		 */
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("1층부터 15층까지 운영합니다.");
		//현재 내가 있는 층
		System.out.println("현재 내가 있는 층수는 : "); int me = scanner.nextInt();
		
		//엘레베이터가 있는 층
		int ele = random.nextInt(15)+1; System.out.println("엘레베이터가 있는 층은 : "+ele);
		
		//움직일 층
		System.out.println(me+"층에서 이동할 층은 : "); int mo = scanner.nextInt();
	
		
		//엘레베이터 호출
			while(true) { if(ele==me) { System.out.println("엘레베이터에 탑승합니다.");} // 내가 있는 곳과 엘레베이터가 일치하면 탑승
			else { // 일치하지 않으면 호출
				System.out.println(ele+"층에 있는 엘레베이터를"+me+"층으로 호출합니다. 1.호출"); int ho = scanner.nextInt();
				//호출값 ho
					if (ho == 1) { //호출하였을때, 엘레베이터를 0으로 만든다.
						int ele2 = 0;
							if(ele>me) { System.out.println("엘레베이터가 "+ele+"층에서 내려옵니다.");
									ele2 = me-ele; ele=ele-ele2;
									System.out.println("엘레베이터가 "+me+"층에 도착했으니 탑승하여주세요.");
									}else if(ele<me) { System.out.println("엘레베이터가"+ele+"층에서 올라옵니다.");
									ele2 = ele-me; ele=ele-ele2;
									System.out.println("엘레베이터가 "+me+"층에 도착했으니 탑승하여주세요.");					
					} else {System.out.println("알림)엘레베이터를 호출해주세요.");
					} break;
				
				} //else end
					System.out.println("알림)엘레베이터를 호출해주세요.");
			}
			} //while end
		
	} // me
	
} // c e
