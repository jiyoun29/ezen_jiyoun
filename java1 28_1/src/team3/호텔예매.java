package team3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Total.Main;
import Total.예약정보;
import Total.예약정보_Controller;
import Total.호텔예매_Room;
import Total.회원가입정보;


public class 호텔예매 {
	
	public static Room[] roomlist = new Room[100];
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) {
			try {
				System.out.println("************** 호텔 예약 프로그램 **************");
				System.out.println("1.예약 2.예약목록 3. 예약취소"); int ch2 = scanner.nextInt();
				if(ch2==1) {
					System.out.println("날짜입력(mmdd) :");	String 날짜 = scanner.next();
					
					boolean result = Controller.날짜체크(날짜);
					
					if(result==true) {
						
						boolean[] 예약가능 = new boolean[5];
						for(Room temp : roomlist) {
							if(temp != null) {
						 // 날짜를 MM(월)dd(일)의 String 형식의 객체생성
							if(temp.getDate().equals(날짜)) { // temp안의 날짜와 입력받은 날짜가 동일하고
								if(temp.getRname().equals("트윈룸")) { // temp안의 방이름이 트윈룸과 동일하면
									예약가능[0] = true;	} // if e
								if(temp.getRname().equals("더블룸")) {
									예약가능[1] = true;	} // if e
								if(temp.getRname().equals("바다뷰트윈룸")) {
									예약가능[2] = true;	} // if e
								if(temp.getRname().equals("바다뷰더블룸")) {
									예약가능[3] = true;	} // if e
								if(temp.getRname().equals("스위트룸")) {
									예약가능[4] = true;	} // if e
								}	
							} // if e
						} // for e
						
						
			
						System.out.println("************** 방 예약 현황표 **************");
						System.out.println("번호\t방이름\t\t금액\t\t예약여부");
						System.out.println("1"+".\t"+"트윈룸\t\t"+"10,000원\t\t"+((예약가능[0])?"예약불가":"예약가능")); // 조건연산자[조건식? 참 : 거짓]
						System.out.println("2"+".\t"+"더블룸\t\t"+"20,000원\t\t"+((예약가능[1])?"예약불가":"예약가능"));
						System.out.println("3"+".\t"+"바다뷰트윈룸\t"+"30,000원\t\t"+((예약가능[2])?"예약불가":"예약가능"));
						System.out.println("4"+".\t"+"바다뷰더블룸\t"+"40,000원\t\t"+((예약가능[3])?"예약불가":"예약가능"));
						System.out.println("5"+".\t"+"스위트룸\t\t"+"50,000원\t\t"+((예약가능[4])?"예약불가":"예약가능"));
						
						System.out.println("방 번호 선택 : ");	int ch = scanner.nextInt();
						System.out.println("예약자 이름 : ");	String name = scanner.next();
					
						int result2 = Controller.예약(날짜, name, ch);
						
							
						if(result2==1) { System.out.println("1번방 트윈룸이 예약되었습니다.");
							System.out.println("객실금액은 10,000원입니다."); } // if e
						if(result2==2) { System.out.println("2번방 더블룸이 예약되었습니다.");	} // if e
						if (result2==3) { System.out.println("3번방 바다뷰트윈룸이 예약되었습니다."); } // if e
						if(result2==4) { System.out.println("4번방 바다뷰더블룸이 예약되었습니다."); } // if e
						if(result2==5) { System.out.println("5번방 스위트룸이 예약되었습니다."); } // if e
						if(result2==6) { System.out.println("알림))예약할 수 없습니다."); }
						
//						System.out.println("금액입력 : "); int 금액 = scanner.nextInt();
//						int result3 = Controller.결제(금액);
//						
//						if(result3==1) {
//							System.out.println("금액이 부족합니다.");
//						}
//						else if(result3==2) {
//							System.out.println("결제가 완료되었습니다.");
//						}
						
						
						
						for(Room temp1 : roomlist) {
							if(temp1 != null) {
								System.out.println(temp1.getRname()+"\t"+temp1.getReserve()+"\t"+temp1.getDate());
							} // if e
					
						} // for e
						
					} // if e
					else {
						System.out.println("알림))날짜를 잘못입력하였습니다.");
					}
				} // if e
				else if(ch2==2) {
					System.out.println("날짜\t방이름\t\t예약자");
					Controller.예약목록();
				}
				
				/////////////////////
				
				
				else if(ch2 == 3) { //날짜를 받아와서 
					System.out.println("날짜입력(mmdd) :"); String 취소날 = scanner.next(); //취소날짜 받아옴
					
					boolean result = Controller.날짜체크(취소날);
					//예약과 같이 날짜 검색. 날짜가 동일하면?
					Controller.예약목록(); //예약 목록을 가져오고 취소할 방 번호 받기

					//방번호와 아이디를 받아서 동일한지 확인 후 취소 진행
					System.out.println("취소를 진행합니다. 아이디를 입력해주세요 : ");	String id = scanner.next();
					
//					System.out.println("예매한 방 목록");
//					System.out.println("방번호\t방이름");
					//int i = 0;					
						
						for( 호텔예매_Room temp : Main.roomList) {
							if(temp.getid().equals(id)) {
								Main.roomList.remove(temp);
								System.out.println("취소가 완료되었습니다.");

//								System.out.print( i +"\t");
//								System.out.print( temp.getRname() +"\t");
//								System.out.print( temp.getDate() +"\n");
//								i++;
							} //if end
						} //for end
//						
		//			System.out.println(" 취소할 방번호 : "); int 삭제방번호 = scanner.nextInt();
			//			Main.roomList.remove( 삭제방번호 );
						

				} //else if 3 end
		
			/////////////////////////////////////
				
			} catch(Exception e) {
				System.out.println("알림))오류입니다(관리자에게문의)");
			} // catch e
		} // while e
		
	} // me

}
