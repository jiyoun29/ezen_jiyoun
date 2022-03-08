package study;

import java.util.Random;
import java.util.Scanner;

public class ele4 {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		while(true) { System.out.println("1층부터 15층까지 운영합니다.");
		System.out.println("내가 있는 층수 : "); int me = scanner.nextInt();
		
		int ele = random.nextInt(15)+1;
		System.out.println("현재 엘리베이터는 : "+ele+"층");
		
		System.out.println("이동할 위치는 : "); int move = scanner.nextInt();
		
			while(true)
			{ if(ele==me); { System.out.println("엘레베이터에 탑승하였습니다."); }
			 System.out.println("엘레베이터를"+ele+"층에서 호출합니다. 1.호출"); int ho = scanner.nextInt();
					if(ho==1) { int arr=0;
						if(ele>me) { System.out.println("엘레베이터가"+ele+"층에서 내려옵니다.");
							arr = me-ele; ele=ele-me; System.out.println("엘레베이터가"+me+"층에 도착하였습니다. 탑승해주세요.");}
						else if(ele<me) { System.out.println("엘레베이터가"+ele+"층에서 올라옵니다.");
							arr = ele-me; ele=ele-me; System.out.println("엘레베이터가"+me+"층에 도착하였습니다. 탑승해주세요.");}
						else {System.out.println("알림)호출 번호를 눌러주세요,");  } break;} 
				else {System.out.println("알림)호출 번호를 눌러주세요,");}
				
		
			} //wile2 end
				
		}//while end
		////////////////////////////////
	}

}
