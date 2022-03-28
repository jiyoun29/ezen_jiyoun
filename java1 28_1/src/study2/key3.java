package study2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class key3 {//키오스크
	
	//1. 메뉴 [식사, 사이드]
		// 식사: 김치볶음밥(4500) 돈까스(5500) 라면(2000)
		// 사이드: 감자튀김(2000) 사이다(1000)
	//2. 주문 받기
	//3. 계산
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	
	ArrayList<String> 메뉴 = new ArrayList<>(Arrays.asList("김치볶음밥","돈까스","라면","감자튀김","사이다"));
	int 김치구매수 = 0; int 돈까스구매수 = 0; int 라면구매수 = 0;
	int 감자구매수 = 0; int 사이다구매수 = 0;
	
	while (true) {
		System.out.println("-----------메뉴----------");
		System.out.println("메뉴를 선택해주세요.");
		System.out.println("1.식사 2.사이드 3.결제");
		int ch = scanner.nextInt();
		
		
		//식사
		if (ch==1) { System.out.println("1.김치볶음밥(4500), 2.돈까스(5500) 3.라면(2000)"); int ch1 = scanner.nextInt();
				if(ch1==1) { System.out.println("김치볶음밥을 주문하였습니다."); 김치구매수++;}
				else if(ch1==2) { System.out.println("돈까스를 주문하였습니다."); 돈까스구매수++;}
				else if(ch1==3) { System.out.println("라면을 주문하였습니다."); 라면구매수++;}
		}
		//사이드
		else if (ch==2) { System.out.println("1.감자튀김(2000), 2.사이다(1000)"); int ch2 = scanner.nextInt();
			if(ch2==1) { System.out.println("감자튀김을 주문하였습니다."); 감자구매수++;}
			else if(ch2==2) { System.out.println("사이다를 한 잔 담았습니다."); 사이다구매수++;}	
		}
		
		else if (ch==3) { System.out.println("-----------장바구니-----------");
						System.out.println("제품명\t수량\t금액");
			
			if(김치구매수 !=0) System.out.println("김치볶음밥\t"+김치구매수+"\t"+(김치구매수*4500));
			if(돈까스구매수 !=0) System.out.println("돈까스\t"+돈까스구매수+"\t"+(돈까스구매수*5500));
			if(라면구매수 !=0) System.out.println("라면\t"+라면구매수+"\t"+(라면구매수*2000)); 
			if(감자구매수 !=0) System.out.println("감자튀김\t"+감자구매수+"\t"+(감자구매수*2000));
			if(사이다구매수 !=0) System.out.println("사이다\t"+사이다구매수+"\t"+(사이다구매수*1000));
		
			int 총결제액 = (김치구매수*4500)+(돈까스구매수*5500)+(라면구매수*2000)+(감자구매수*2000)+(사이다구매수*1000) ;
			
			System.out.println("제품 총 결제액 : " + 총결제액 );
			System.out.println("--------------------------------------");
			System.out.println("1. 결제 2. 취소");	int ch4 = scanner.nextInt();
			
			
			if( ch4 == 1 ) { while(true) {  System.out.println("입금 금액 : "); int 금액 = scanner.nextInt();
				if(금액<총결제액) { System.err.println("금액이 부족합니다.");
			}
				else { System.err.println("구매가 완료되었습니다.");}
			
			김치구매수 = 0; 돈까스구매수 = 0; 라면구매수 = 0; 감자구매수 = 0; 사이다구매수 = 0;
			
			System.out.println("잔돈 : " + (금액 - 총결제액)+"원" ); 
		
			break; } 
		}

			} else { System.out.println("잘못된 번호를 입력하였습니다.");
		}
	}
		
////////////////////////////////////////////////		
	}


}
