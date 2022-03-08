package study;

import java.util.Random;
import java.util.Scanner;

public class Ramyeon5 {
	
	 /* 라면 레시피
	  * 1. 물 3컵을 넣고 물이 끓으면 면, 분말스프를 넣는다.
	  * 취향에 따라 대파와 계란을 넣는다.
	  */
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		//물
	while(true) {System.out.println("냄비에 물을 몇 컵 채울까요? : "); int water = scanner.nextInt();
			System.out.println("냄비에 물을"+water+"컵 채웠습니다.");
			
	//면과 스프
			System.out.println("물이 끓습니다. 1. 면 먼저 2. 스프 먼저"); int ch = scanner.nextInt();
			if(ch == 1) { System.out.println("면을 먼저 넣었습니다.\n면이 익으면 스프를 넣습니다.");
			} else if(ch==2) { System.out.println("스프를 먼저 넣었습니다.\n스프가 풀어지면 면을 넣습니다.");
			} else {System.out.println("알림)올바른 번호를 선택해주세요.");}

	//추가재료		
			while(true) { System.out.println("추가 재료를 선택하세요. \n 1.대파 2.계란 3.없음"); int ch2 = scanner.nextInt();
				if(ch2==1) {System.out.println("대파를 몇개 넣으시겠습니까? : "); int pa = scanner.nextInt();
				System.out.println("대파를 "+pa+"개 넣었습니다.");} //대파 end
				else if(ch2==2) { System.out.println("계란을 몇개 넣으시겠습니까? : "); int egg =scanner.nextInt();
				System.out.println("계란을 "+egg+"개 넣었습니다.");}//계란 end
				else {System.out.println("곧 라면이 완성 됩니다.");} //재료없음
				
	//완성
			System.out.println("라면이 완성되었습니다.");
			System.out.println("이 라면은 "+random.nextInt(5)+"점짜리 라면입니다.");
				break;
			}//while2 end
	} // while end

	
	
	///////////////////////////////////////////////
	}
	
}
