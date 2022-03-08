package study;

import java.util.Random;
import java.util.Scanner;

public class Ramyeon3 {

	public static void main(String[] args) {
		
		 /* 라면 레시피
		  * 1. 물 3컵을 넣고 물이 끓으면 면, 분말스프를 넣는다.
		  * 취향에 따라 대파와 계란을 넣는다.
		  *///////////////////////////////////////////////////

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		while(true) { System.out.println("----------라면 끓이기 시작----------");
			System.out.println("냄비에 물을 몇 컵 채울까요? : "); int water = scanner.nextInt();
			System.out.println("냄비에 물을"+water+"만큼 채웠습니다.");
			
			//면과 스프
				System.out.println("물이 끓습니다. 1. 면 먼저 2. 스프 먼저"); int ch = scanner.nextInt();
					if(ch == 1) { System.out.println("면이 익으면 스프를 넣고 재료를 추가해주세요,"); }
					else if (ch == 2) {System.out.println("스프가 풀어지면 면을 넣고 재료를 추가해주세요.");}
					else {System.err.println("알림) 올바른 선택지를 골라주세요.");}
					
					//재료 추가
				while(true) {
					System.out.println("추가할 재료를 선택해주세요. 1.대파 2.계란 3.양파 4.없음"); int ch2 = scanner.nextInt();
						if(ch2 == 1) {System.out.println("대파를 몇 개 추가하시겠습니까?"); int pa = scanner.nextInt();
							System.out.println("대파를 "+pa+"만큼 추가하였습니다.");	}
						else if(ch2 == 2) {System.out.println("계란를 몇 개 추가하시겠습니까?"); int egg = scanner.nextInt();
						System.out.println("계란을 "+egg+"만큼 추가하였습니다.");
						} else if(ch2 ==3) {System.out.println("양파를 몇 개 추가하시겠습니까?"); int pa2 = scanner.nextInt();
						System.out.println("양파를 "+pa2+"만큼 추가하였습니다.");
	
						}else {System.out.println("곧 라면이 완성 됩니다.");} //재료 없음
						
						System.out.println("라면이 완성되었습니다.");
					System.out.println("점수는 : "+random.nextInt(5));
				break;
				}
					
		} // while end
		
		
		
		
		///////////////////////////////////////////////////////
	}
}
