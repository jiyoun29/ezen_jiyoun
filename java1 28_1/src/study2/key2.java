package study2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class key2 { //키오스크
	
	//1. 메뉴 [햄버거, 음료]
		// 햄버거: 불고기버거(2000) 치즈버거(1000) 새우버거(2500)
		// 음료: 레몬에이드(1000), 사이다(1000), 커피(500)
	//2. 주문 받기
	//3. 계산
	
	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	ArrayList<String> 메뉴 = new ArrayList<>(Arrays.asList("불고기버거","치즈버거",
			"새우버거","레몬에이드","사이다","커피"));
	int 불고기구매수 = 0; int 치즈구매수 = 0; int 레몬구매수 = 0;
	int 새우구매수 = 0; int 사이다구매수 = 0; int 커피구매수 = 0;
	
	while (true) {
		System.out.println("----------------- 메뉴 -----------------");
		System.out.println("메뉴를 선택해주세요.");
		System.out.println("1.햄버거 2.음료 3.결제"); int ch = scanner.nextInt();
		
		//선택지
		if (ch==1) { System.out.println("1.불고기버거(2000), 2.치즈버거(1000) 3.새우버거(2500)")
			;
			int ch1 = scanner.nextInt();
			
			if(ch1==1) { System.out.println("불고기버거를 선택하였습니다."); 불고기구매수++;}
			else if(ch1==2) { System.out.println("치즈버거를 선택하였습니다."); 치즈구매수++;}
			else if(ch1==3) { System.out.println("새우버거를 선택하였습니다."); 새우구매수++;}
			
		} else if (ch==2) {	System.out.println("1.레몬에이드(1000), 2.사이다(1000) 3.커피(500)");
		
			int ch2 = scanner.nextInt();
			
			if(ch2==1) { System.out.println("레몬에이드를 한 잔 담았습니다."); 레몬구매수++;}
			else if(ch2==2) { System.out.println("사이다를 한 잔 담았습니다."); 사이다구매수++;}
			else if(ch2==3) {System.out.println("커피를를 한 잔 담았습니다."); 커피구매수++;}	
			
		} else if (ch==3) {
			
			System.out.println("-----------------장바구니-----------------");
			System.out.println("제품명\t수량\t금액");
			
			if(불고기구매수 !=0) System.out.println("불고기버거\t"+불고기구매수+"\t"+(불고기구매수*2000));
			if(치즈구매수 !=0) System.out.println("치즈버거\t"+치즈구매수+"\t"+(치즈구매수*1000));
			if(새우구매수 !=0) System.out.println("새우버거\t"+새우구매수+"\t"+(새우구매수*2500)); 
			
			if(레몬구매수 !=0) System.out.println("레몬에이드\t"+레몬구매수+"\t"+(레몬구매수*1000));
			if(사이다구매수 !=0) System.out.println("사이다\t"+사이다구매수+"\t"+(사이다구매수*1000));
			if(커피구매수 !=0) System.out.println("커피\t"+커피구매수+"\t"+(커피구매수*500)); 
		
			int 총결제액 = (불고기구매수*2000)+(치즈구매수*1000)+(새우구매수*2500)+(레몬구매수*1000)+(사이다구매수*1000)+(커피구매수*500) ;
			
			System.out.println("제품 총 결제액 : " + 총결제액 );
			System.out.println("1. 결제 2. 취소");
		
			int ch4 = scanner.nextInt();
			if( ch4 == 1 ) { while(true) {  System.out.println("입금 금액 : "); int 금액 = scanner.nextInt();
			if(금액<총결제액) { System.err.println("금액이 부족합니다. 다시 투여해주세요.");} 
			else { System.err.println("구매가 완료되었습니다.");}
			불고기구매수 = 0; 치즈구매수 = 0; 레몬구매수 = 0; 새우구매수 = 0; 사이다구매수 = 0; 커피구매수 = 0;
			System.out.println("잔돈 : " + (금액 - 총결제액)+"원" ); 
		
			break; } 
		}

			} else { System.out.println("잘못된 번호를 입력하였습니다.");
		}
	}
		
		
		
	
	}//while end

}
