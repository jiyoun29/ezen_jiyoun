package teat2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class View { //사용자가 보는 화면. 주차장 현황 표와 입차 출차 버튼이 보여짐
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //입력객체 생성
		
		
		//주차현황표
		//현재시간
		//날짜, 차량번호, 입차시간, 출차시간, 금액
		
		while(true) { //반복
			
			System.out.println("=========주차현황표=========");
		
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("현재시간 : yyyy - MM - dd \t hh:mm");
//			Date now = new Date(); 
			//현재시간을 불러온 다음 출력
			System.out.println(dateFormat.format(date)+"\n"); //줄바꿈
			
			System.out.println("날짜\t차량번호\t입차시간\t출차시간\t금액\n");
			//여기에 입력한 내용이 출력되도록 함
			
			//객체 호출		
//			System.out.print(Controller.get);

			//호출은 반복된다. 반복문을 걸어서 준다.
			
			//주차장을 불러와서 돌린다.
			for(teat2.Car temp : Controller.주차장) { //?\
				System.out.println(temp.get날짜());
				System.out.println(temp.get차량번호());
				System.out.println(temp.get입차시간().getHour());
				System.out.println(temp.get출차시간());
				System.out.println(temp.get금액());
				
				
			}
			
		
		System.out.println("\t 1.입차 \t\t 2.출차"); int ch = scanner.nextInt();
								//선택을 입력 받음
		
		if(ch==1) { //입차
			System.out.println("차량 번호를 입력하세요. : ");
			String 차번호 = scanner.next(); //입력받은 값 저장해서 넘기기
			//입력 받은 차량번호를 넘겨서 저장한다.
			boolean 입차완료 = Controller.입차(차번호 );
			//불러오기
			
			return;
		} else if (ch ==2) { //출차
			System.out.println("차량 번호를 입력하세요. : ");
			String 차번호 = scanner.next(); //입력받은 값 저장해서 넘기기
			boolean 출차완료 = Controller.출차(차번호 );

			
			return;			
		} else { System.out.println("다시 선택해주세요."); }
		
		
		} //while end		
		
///////////////////////////////////////////////////////		
	}
}
