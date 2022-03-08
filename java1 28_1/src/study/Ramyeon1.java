package study;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ramyeon1 {
 public static void main(String[] args) {
	
	 /* 라면 레시피
	  * 1. 물 3컵을 넣고 물이 끓으면 면, 분말스프를 넣는다.
	  * 취향에 따라 대파와 계란을 넣는다.
	  */
 
	 Scanner scanner = new Scanner(System.in);
	 //읽을 수 있는 스캐너를 생성한다.
	 Random random = new Random();
	 // 랜덤을 읽을 수 있게 객체를 생성한다.
	 
	 while(true) {  System.out.println("----------라면 끓이기 시작!----------");
	 // 1. 냄비에 물을 채운다.
	 	System.out.print("냄비에 물을 몇 컵 채울까요? : "); int water = scanner.nextInt(); 
	 	// 사용자의 입력값(물)을 저장한다.
	 	System.out.println("냄비에 물을 "+ water + "컵 채웠습니다.");
		// 저장한 입력값을 같이 송출하여 확인하게 한다. 
	 	
	 	//2. 면과 스프 넣기
		 	System.out.println("물이 끓습니다. 1. 면 먼저 넣는다. 2. 스프 먼저 넣는다."); int ch = scanner.nextInt();
		 	// 사용자의 입력값을 저장한 다음, if, else if, else로 나뉘어진 선택지를 생성한다.
		 		if(ch == 1) { System.out.println("면을 먼저 넣었습니다."); System.out.println("면이 풀어지면 스프를 넣고 진행합니다."); }
		 		//면을 먼저 넣었을 때의 문장을 송출한다.
	 			else if (ch == 2) { System.out.println("스프를 먼저 넣었습니다.");	System.out.println("스프가 퍼지면 면을 넣고 진행합니다.");
		 		//스프를 먼저 넣었을 때의 문장을 송출한다.
		 		} else { System.out.println("알림) 알 수 없는 번호입니다."); } 
		 		//올바르지 않은 번호를 입력하였을 경우를 입력해둔다.
		 // 3. 추가할 재료
		 		System.out.println("면이 익어갑니다. 추가할 재료가 있나요?");
		 		//추가 여부를 묻고 선택지에 대한 입력값을 받는다.
		 		System.out.println("1. 대파 2. 계란 3.없다."); int ch2 = scanner.nextInt();
		 		
		 		//대파
		 		while(true) { if(ch2 == 1) { System.out.println("대파를 몇 개 넣을까요? : "); String 대파 =scanner.next();
		 		// 대파 입력 갯수를 저장하고 송출한다.
		 			System.out.println("대파를 " + 대파 + "개 넣었습니다.");  }
		 		
		 		else if (ch2 == 2) {  System.out.println("계란을 몇 개 넣을까요?"); String 계란 = scanner.next();
		 		//계란 입력 갯수를 저장하고 송출한다.
		 			System.out.println("계란을 "+ 계란 +" 넣었습니다.");
		 			
		 		} else if (ch2 == 3) { System.out.println("라면이 완성되어 갑니다.");
		 		//추가 없을 경우 진행 상황 송출
		 		
		 		}else { System.out.println("알림) 알 수 없는 번호입니다."); }
		 		//잘못된 숫자 입력시 알림 발송'
		 		
		 		 System.out.println( random.nextInt(10) + "점 짜리 라면이 완성 되었습니다.");
		 		 //랜덤으로 라면의 점수를 송출한다.
		 		 
		 		 break;
		 		} // while2 end
		 		
	 } // while end
 
	 
 } // me
	
} // c e
