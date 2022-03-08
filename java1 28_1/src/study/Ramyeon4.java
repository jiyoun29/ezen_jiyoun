package study;

import java.util.Random;
import java.util.Scanner;

public class Ramyeon4 {
	public static void main(String[] args) {
		
		 /* 라면 레시피
		  * 1. 물 3컵을 넣고 물이 끓으면 면, 분말스프를 넣는다.
		  * 취향에 따라 대파와 계란을 넣는다.
		  */
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		
	while(true) { System.out.println("라면 끓이기를 시작합니다.\n냄비에 물을 몇 컵 채울까요? : "); int water = scanner.nextInt();
		System.out.println("냄비에 물을 "+water+"만큼 채웠습니다.");
		
		//면과스프
		System.out.println("물이 끓으면 1. 면을 먼저 2. 스프를 먼저"); int ch = scanner.nextInt();
			if(ch==1) { //면을 먼저
				System.out.println("면이 익으면 스프를 투입하고 재료를 추가해주세요."); }
			else if (ch ==2 ){System.out.println("스프가 풀어지면 면을 투입하고 재료를 추가해주세요.");}
			else {System.out.println("잘못된 선택입니다.");}
		
		//재료 추가
		
			while(true) { System.out.println("추가할 재료가 있나요? 1. 대파 2. 계란 3. 없음"); int ch2 = scanner.nextInt();
				if(ch2==1) { // 대파 추가
					System.out.println("대파를 얼마나 추가할까요? : "); int pa = scanner.nextInt();
					System.out.println("라면에 대파를 "+pa+"만큼 추가하였습니다.");	}
				else if(ch2==2) { System.out.println("계란을 얼마나 추가할까요? : "); int egg = scanner.nextInt();
				System.out.println("라면에 계란을 "+egg+"만큼 추가하였습니다.");	}
				else { //재료없음				
				System.out.println("곧 라면이 완성 됩니다.");}
				
				//완성
				
				System.out.println(random.nextInt(5)+"점 짜리 라면이 완성되었습니다.");
				break;
			}//while2 end
	} // while end
		///////////////////////////////////////////////////
	}

}
