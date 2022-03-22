package class1;

import java.util.Scanner;

public class View { // class start

	public static void main(String[] args) { // main start
		Scanner scanner = new Scanner(System.in);
		
		
		/////////////////////////////////////////////////////
		
		
		for (int i = 0 ; i <= 11 ; i++) {  // 12길이 리스트 생성 차량번호를 " " 넣어 " "일경우 빈자리로 출력
			
			Car car = new Car(i, " ", " ");
			//
			
			Controller.carlist.add(car);
			//컨트롤러에 생성된 주차장을 가지고 옴
		}
		Controller.load();
		Controller.load2();
		while(true) { // 무한루프 종료조건 없음
			System.out.println("----- 주차관리 프로그램 ------");
			int i = 1 ; // 한개층에 4칸씩 출력되도록 하기 위해 변수 선언 
			for (Car temp : Controller.carlist) {
				if(temp.getCarnum().equals(" ")) { // 차량번호 없으면 공백으로 출력
					System.out.printf("[    ]\t");
				}
				else if(temp.getCarnum() != " ") { // 차량번호있을땐 차량번호로 출력
					System.out.print("["+temp.getCarnum()+"]\t");
				}
				if(i%4==0) { // 4개 마다 줄바꿔서 층으로 표현
					System.out.println();
				}
				i++;
			}
			try { // int형 외 입력시 오류발생에 대한 예외처리
				System.out.println("1.입차 2.출차 3.매출확인");
				System.out.print("선택 > ");
				int ch = scanner.nextInt();
				if(ch==1) { // 입차 메뉴
					System.out.print("차량번호를 입력하세요 : "); String carnum = scanner.next();
					System.out.print("입차일을 입력하세요 [ex) 3월18일 = 0318] : "); String date = scanner.next();
					System.out.print("입차시간을 입력하세요 [ex) 오후 3시 15분 = 1515] : "); String time = scanner.next();
					boolean result = Controller.checkdate(date); // 입차일 체크 메소드
					boolean result2 = Controller.checktime(time); // 입차시간 체크 메소드
					boolean result4 = Controller.checkcnum(carnum);
					if (result4 == false) {
						System.out.println("알림] 차량번호를 잘못입력하셨습니다.");
					}
					else {
						if (result==false) { // 입차일 잘못입력할경우
							System.out.println("알림] 날짜를 잘못입력하셨습니다.");
						}
						else {	// 입차시간 잘못입력할경우	
							if(result2==false) {
								System.out.println("알림] 시간을 잘못입력하셨습니다.");
							}
							else { // 시간 제대로 입력시 입차 메소드
								String intime = date+time;
								boolean result3  = Controller.carin(carnum, intime);
								if(result3) {
									System.out.println("알림] 입차 성공.");
								}
								else {
									System.out.println("알림] 입차 실패 [자리가 없습니다.]");
								}
							}
						}
					}
				} // 입차 메뉴
				
				else if(ch==2) { // 출차 메뉴
					System.out.print("차량번호를 입력하세요 : "); String carnum = scanner.next();
					System.out.print("출차일을 입력하세요 [ex) 3월18일 = 0318] : "); String date = scanner.next();
					System.out.print("출차시간을 입력하세요 [ex) 오후 3시 15분 = 1515] : "); String time = scanner.next();
					String outtime = date+time;
					boolean result = Controller.checkouttimedate(carnum, outtime); // 출차시간 체크 메소드
					boolean result3 = Controller.checkdate(date); // 입차일 체크 메소드
					boolean result4 = Controller.checktime(time); // 입차시간 체크 메소드					
					if (result == false || result3 == false || result4 == false) { // 출차시간을 입차시간 전으로 입력할경우
						System.out.println("알림] 출차시간을 잘못입력하셨습니다.");
					}
					else {  // 출차시간 제대로 입력했을시
						String result2 = Controller.carout(carnum);
						if(result2 == null) { // 리턴값이 null이면 (=출차실패시)
							System.out.println("알림] 출차 실패 [잘못된 차량번호 입니다.]");		
						}
						else { // 리턴값이 null이아니면 출차시간 받아서 계산메소드 인수로
							int fee = Controller.pay(carnum, outtime, result2); // 반환된 시간차이를 변수로 저장		
							if (fee == 0) { // 30분 이내 무료
								System.out.println("알림) 회차 가능 시간");
							}
							else { // 1일 요금 최대 5만
								while(true) {
									System.out.println("알림) 주차요금은 : " + fee  + "원 입니다.");
									System.out.print("입금하세요 : "); int money = scanner.nextInt() ;
									if (money >= fee) {
										System.out.println("감사합니다");
										System.out.println("거스름돈 " +(money-fee) +" 을 받아가세요");
										Controller.volume(date, fee); // 월과 주차요금 매출계산메소드 인수
										Controller.save2();
										break;
									}
									else {
										System.out.println("알림] 돈이 부족합니다. 다시 입금해주세요");
									}
								}
								
							}

						}	
					}
				} // 출차 메뉴
				
				else if(ch==3) { // 매출확인 메뉴
					System.out.println("몇 월의 매출을 출력 하시겠습니까 : ");
					System.out.print("입력 > ");
					int month = scanner.nextInt();
					if ( 1 <= month && month <= 12) {
						if (Controller.totalcharge[month-1] == 0) {
							System.out.println("알림] 매출이 없습니다. ");
						}
						else {
							System.out.println(month+"월의 매출은 : " + Controller.totalcharge[month-1] + "원 입니다.");
						}
					}
					else {
						System.out.println("알림] 잘못 입력 하셨습니다");						
					}
				} // 매출계산 메뉴
				
				else { // 잘못된 번호 입력
					System.out.println("알림] 잘못된 번호입니다.");
				} // 잘못된 번호 입력
			}
			
			catch(Exception e) { // 예외 catch
				System.out.println("알림] 잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			} // 예외 catch
			
		} // while end	
		

////////////////////////////////////////////////////////////////
	} // main end
}
