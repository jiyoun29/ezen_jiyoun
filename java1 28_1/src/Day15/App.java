package Day15;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		//여기서만 출력하므로 스캔 만들기
		Scanner scanner = new Scanner(System.in);
		
		//반복문
		while(true) {
			//1. 모든 차량표 출력
				//배열이나 리스트를 호출하는 반복문 넣기(게시판 참고)
			
			try {
				System.out.printf( //모든 게시물 출력
						"%s\t%s\t%s\t%s\t%s\n",
						"날짜", "차량번호", "입차시간", "출차시간", "금액");
				
				int i = 0; //인덱스 생성
				for(Controller temp : 주차장) {
					if(temp != null) {
						temp.
					}
					
				}
				
				
//				for(Students temp : studentlist) {
//					if(temp != null) {
//						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
//								temp.getNo(),temp.getName(),temp.getKor(),temp.getEng(),temp.getMath(),temp.getTotal(),temp.getAve(),(h+1));
//					}
//					h++;
//				}
				
			} catch (Exception e) {			}
					
			
			
			System.out.println("1. 입차      2. 출차");
			int ch = scanner.nextInt();
			
			if(ch == 1) { //메소드.
				// 차량번호를 입력 받음
				// 입력 받은 차량번호를 컨트롤러에게 넘긴다.
					//
				// 메소드 결과에 따른 출력
				boolean 결과 = Controller.입차(null); //차량번호
				
			} else if (ch == 2) {	
				// 차량번호를 입력 받음
				// 입력 받은 차량번호를 컨트롤러에게 넘긴다.
				// 메소드 결과에 따른 출력
				boolean 결과 = Controller.출차(null); //차량번호
				
			}
			
			
			
			break;
		}
		
		
		
		
		
	}
}
