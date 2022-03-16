package Day09;

import java.util.Scanner;

public class day9_6_은행계좌프로그램 {
	
	//은행계좌프로그램 [ 상속 ] 
		//sub :  국민은행, 신한은행, 하나은행
		// 주 기능 : 1. 계좌생성 2.입금 3.출급 4.이체 5.내계좌목록 6.대출

	
		// main밖에서 선언하는 이유 : 모든 클래스에서 사용하기 위해 static 배열로 선언
			//static 변수는 공통변수이며 프로그램 시작 시 메모리 할당. 프로그램 종료 시 메모리 초기화
	public static day9_6_은행[] 계좌리스트 = new day9_6_은행[100];
	
	
	
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		//최대한 메모리를 아끼기 위해 위에 작성
		
		while(true) {
			System.out.println("-------------계좌 시스템-------------");
			System.out.println("1.계좌 생성 2.입금 3.출금 4.이체 5.내 계좌 목록 6.대출");
			//입력을 받아보자. (스캐너 필요)
			int 선택 = scanner.nextInt();
			
		//컨트롤러 메소드 호출용 객체
			day9_6_은행컨트롤러 컨트롤 = new day9_6_은행컨트롤러();
			//메모리를 넣어주고 호출
			
			
			if(선택 == 1) { System.out.println("-----계좌 등록 페이지-----");
			//계좌번호는 난수로
			System.out.println("비밀번호 : "); String 비밀번호 = scanner.next();
			System.out.println("계좌주 : ");	String 계좌주 = scanner.next();		
			System.out.println("은행 선택 \n 1.국민 2.신한 3.하나"); int 은행번호 = scanner.nextInt();
			//입력한 것을 은행컨트롤러 클래스로 옮긴다.(총 3개)

			
			//컨트롤러 연결
			String 계좌번호 = 컨트롤.계좌생성(비밀번호, 계좌주, 은행번호); //메소드 호출
			//인수 3개를 넣어주고 메소드 반환을 저장 = 계좌번호 혹은 null
			
			
			//메소드 실행 후 메시지 출력
			if(계좌번호 != null) { //result가 true이면
				System.out.println("계좌 생성");
				System.out.println("고객님의 계좌번호 : "+계좌번호);
			} else {System.err.println("계좌 등록 실패 (관리자에게 문의)");}
			
			//result가 true이면
//			if(계좌번호) {	System.out.println("계좌 생성"); // true;
//			} else { System.out.println("알림) 계좌등록 실패");} //false//
			
				
			} else if(선택 == 2) { System.out.println("-----입금 페이지-----");
				System.out.println("계좌번호 : " ); String 계좌번호 = scanner.next();
				System.out.println("입금할 금액 : "); 	int 입금액 = scanner.nextInt();
				//은행 컨트롤러의 2번으로 보낸다.
				
			boolean result = 컨트롤.입금(계좌번호 , 입금액);
			
			if(result) { System.out.println("입금 성공");
				
			} else {System.out.println("입금 실패. 동일한 계좌가 존재하지 않습니다.");}
					
				
			} else if(선택 == 3) { System.out.println("-----출금 페이지-----");
			System.out.println("계좌번호 : " ); String 계좌번호 = scanner.next();
			System.out.println("비밀번호 : " ); String 비밀번호 = scanner.next();
			System.out.println("출금할 금액 : "); 	int 출금액 = scanner.nextInt();
			// 은행 컨트롤러 3번으로 보낸다.
			
			int result = 컨트롤.출금(계좌번호, 비밀번호, 출금액); //보내고 보낸쪽도 받았다고 입력
			//메소드 호출 : 객체명.메소드명(인수1,인수2,인수3);
			
			if(result == 1) {
				System.out.println("잔액이 부족합니다.");
			} else if (result == 2) {
				System.out.println("출금 성공");
			} else if (result == 3) {
				System.out.println("올바른 정보가 아닙니다.");
			}
			
			
				
			} else if(선택 == 4) { System.out.println("-----이체 페이지-----");
			System.out.println("계좌번호 : " ); String 계좌번호 = scanner.next();
			System.out.println("비밀번호 : " ); String 비밀번호 = scanner.next();
			System.out.println("이체금액 : "); 	int 이체금 = scanner.nextInt();

			System.out.println("이체계좌 : "); String 받는계좌 = scanner.next();
////////////////////반대로 씀(이따 수정)
			
			int result = 컨트롤.이체(계좌번호, 비밀번호, 이체금, 받는계좌);			
			
			if(result == 1) {
				System.out.println("잔액이 부족합니다.");
			} else if (result == 2) {
				System.out.println("이체 성공");
			} else if (result == 3) {
				System.out.println("받는 계좌 정보가 틀립니다.");
			} else if(result == 4) {
				System.out.println("보내는 계좌 정보가 없습니다.");
			}
			
			
			
			} else if(선택 == 5) { System.out.println("-----내 계좌 목록 페이지-----");
				System.out.println("계좌주 : "); String 계좌주 = scanner.next();
				//메소드 호출
				day9_6_은행[] 내계좌목록 = 컨트롤.계좌목록(계좌주);
			
				System.out.println("검색한 계좌주 님의 계좌목록");
				int i = 1;
				for(day9_6_은행 temp : 내계좌목록) {
					if(temp != null) //리스트는 이거 안 해도 된다.
				System.out.println(i+ "번 계좌번호 : "+ temp.get계좌번호() );
				i++;}
				
			} 
			
			
			
			
			else if(선택 == 6) { System.out.println("-----대출 페이지-----");
				
			} else { System.err.println("잘못된 입력입니다.");}
			
			
		} //while end
		
		
		
		
//////////////////////////////////		
	}

}
