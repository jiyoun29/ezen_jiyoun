package Day13;

import java.util.Calendar;
import java.util.Scanner;

public class day13_3 {
	public static void main(String[] args) {
		
		
		//메소드화 시켜놓으면 나중에 다시 불러올 때 편하고 인수에 따라 결과를 다르게 할 수도 있다.
		
		
		Scanner scanner = new Scanner(System.in);
		//스캐너로 입력 받는 방법도 있음(2번 주석처리)
		System.out.print("연도 : ");  int year = scanner.nextInt();
		System.out.print("월 : ");  int month = scanner.nextInt();
		//이러면 console에서 2022, 4 검색하면 달력 나온다.
		
		달력(year, month);
		
		
		
		
		////////////////
		
	//메소드 만들게 주석
//		//1. 캘린더 클래스 내 현재 날짜/시간 객체 호출
//		Calendar calendar = Calendar.getInstance();
//			//가장 많이 사용되는데 뭐에 쓰는 건지 궁금하다면 원본 확인
//		
//		
//			//2.연도, 월, 일
////		int year = calendar.get(Calendar.YEAR);
////		int month = calendar.get(Calendar.MONTH)+1;
//		int day = calendar.get(Calendar.DAY_OF_MONTH);
//		
//		
//		//해당 월의 1일의 요일 찾기
//				//1. 사용자 정의 캘린더 설정
//				calendar.set(year, month-1, 1); //원하는 년도, 월 넣고 아까 +1했으니 컴퓨터가 읽을 때에는 1 깎아줌
//						// 22년 3월 1일임
//					//현재 날짜는 getinstane고 사용자가 만들때에는 캘린더.set
////				System.out.println("사용자가 날짜만들기 : " +calendar.toString());
//			
//			
//				//2.int sweek = 3월 1일의 요일 구하기
//				int sweek = calendar.get(Calendar.DAY_OF_WEEK);
//					//1일을 기준으로 화요일이므로 3이 나온다.
////				System.out.println(sweek);
//			
//			
//				//3.3월의 마지막 일
//				int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//		//		System.out.println(eday);
//			
//			
//				
//				
//			//3. 출력
//		System.out.println("====="+year+"년 "+month+"월 "+day+"일"+"=====");
//		System.out.println("일\t월\t화\t수\t목\t금\t토");
//		//달력 만들때 반복문 돌리면 되지만 중요한건 1일을 어떻게 찍을 것인지 생각**
//		//1찍고 마지막 날까지 반복문 돌리기
//		
//		
//		
//			//현재 월 1일의 위치 앞에 공백 채우기
//				//별찍기 한것처럼!! 2번 건너서 화요일에 1 찍기(공백 2개 찍고 1 찍기)
//			for(int i = 1; i<sweek; i++);{ //시작 요일까지 돌리기
//								//3월 1일 = 화 = 3
//				//요일부터 화요일까지 -1을 추가하겠다는 뜻
//					 	System.out.println("\t");
//				}  //1일부터 마지막 날까지 출력
//				//2번의 반복문을 돌려서 공백 출력
//			
//			
//			for(int i = 1; i <=eday; i++);{
//				
//				//오늘 체크
//		//		if(i == day) System.err.print(i+"\t");
//		//		else System.out.print( i + "\t"); //i가 일수를 출력
//				 //토요일마다 라인을 내리므로 계산해서 내려야함
//					//토요일은 7이므로 요일의 7배수마다 내리
//				
//					if( sweek % 7 == 0)	//7의 배수 찾기
//						System.out.println(); //배수마다 줄바꿈
//					sweek++; //하루씩 요일이 증가
//					
//			}
		
		////////////////////////////
	
		
		
/////////////////////////////////		
	}
	
	
	//1. 달력 메소드
		//메인 밖, 클래스 안
	public static void 달력(int year, int month) {
		//이거 적고 그 안에 복붙
	
		
	while(true) {	
		//무한루프 추가
				
			
			//1. 캘린더 클래스 내 현재 날짜/시간 객체 호출
			Calendar calendar = Calendar.getInstance();
				//가장 많이 사용되는데 뭐에 쓰는 건지 궁금하다면 원본 확인
			
			
				//2.연도, 월, 일
		//	int year = calendar.get(Calendar.YEAR);
		//	int month = calendar.get(Calendar.MONTH)+1;
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			
			
			//해당 월의 1일의 요일 찾기
					//1. 사용자 정의 캘린더 설정
					calendar.set(year, month-1, 1); //원하는 년도, 월 넣고 아까 +1했으니 컴퓨터가 읽을 때에는 1 깎아줌
							// 22년 3월 1일임
						//현재 날짜는 getinstane고 사용자가 만들때에는 캘린더.set
		//			System.out.println("사용자가 날짜만들기 : " +calendar.toString());
				
				
					//2.int sweek = 3월 1일의 요일 구하기
					int sweek = calendar.get(Calendar.DAY_OF_WEEK);
						//1일을 기준으로 화요일이므로 3이 나온다.
		//			System.out.println(sweek);
				
				
					//3.3월의 마지막 일
					int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			//		System.out.println(eday);
				
				
					
					
				//3. 출력
			System.out.println("===== "+year+"년 "+month+"월 =====");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			//달력 만들때 반복문 돌리면 되지만 중요한건 1일을 어떻게 찍을 것인지 생각**
			//1찍고 마지막 날까지 반복문 돌리기
			
			
			
				//현재 월 1일의 위치 앞에 공백 채우기
					//별찍기 한것처럼!! 2번 건너서 화요일에 1 찍기(공백 2개 찍고 1 찍기)
				for(int i = 1; i<sweek; i++);{ //시작 요일까지 돌리기
									//3월 1일 = 화 = 3
					//요일부터 화요일까지 -1을 추가하겠다는 뜻
						 	System.out.println("\t");
					}  //1일부터 마지막 날까지 출력
					//2번의 반복문을 돌려서 공백 출력
				
				
				for(int i = 1; i <= eday; i++ ) {
					
					//i가 일수를 출력
					System.out.print(i+"\t");
					
			//		else System.out.print( i + "\t"); 
					
					 //토요일마다 라인을 내리므로 계산해서 내려야함
						//토요일은 7이므로 요일의 7배수마다 내리기
						if( sweek % 7 == 0)	//7의 배수 찾기
							System.out.println(); //배수마다 줄바꿈
						sweek++; //하루씩 요일이 증가
						
				}
			
				
				
				
				//버튼 하나 만들기 1. 이전달 2. 다음달 3. 다시검색
				

			//행여 예외가 생기지 않도록 try catch 넣어놓기
			try {//만일 try{} 안에서 예외(에러)가 발생하면 catch로 이동한다.
						//코드 오류가 아니라 사용자 사용 중을 대비하여 프로그램 다운을 대비.
				
				System.out.println("\n 1. 이전달 2. 다음달 3. 다시검색 4. 종료");	
				Scanner scanner = new Scanner(System.in); int  ch =scanner.nextInt();
				//입력객체 생성
				//무한루프 필쑤!!!!!!!!!!!!
				
				if(ch == 1) { month -= 1;
					//month에서 -1을 깎는다. -=를 이용해서 깎아야함.
					// 계산 후 저장도 필쑤
				
					//만일 월이 0이 되면 연도는 1을 감소하고 월은 12가 되도록 만든다.
						if (month == 0) {
							year -= 1; month = 12;
						}
				
				} else if (ch == 2) { month += 1;
					//+= : 더하고 대입하라는 뜻 (대입연산자)
						if (month == 13) //만일 month가 13이면 month를 1로 만들고 연도에 +1을 하자
							{ month = 1; year += 1; }				
				
				} else if (ch == 3) {
					System.out.print("연도 : "); year = scanner.nextInt();
					System.out.print("월 : "); month = scanner.nextInt();
					
				} else if (ch == 4) {
					System.out.println("달력 프로그램 종료");
					break; //종료
					//다음에는 코드가 없으므로 메소드 종료
				}
		
		// **************************
			} catch (Exception e) { //만일 try에서 예외가 생길 경우 해당 코드를 출력
				System.err.println("정상적인 입력을 해주세요."); }
			
		
		
		} //while end
		
		
		
	} //void end
	
	
} // class
