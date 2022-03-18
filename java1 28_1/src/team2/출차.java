package team2;

import java.util.Scanner;

public class 출차 { //윤지윤

	//차량번호를 입력 받아 차량리스트에 있는지 확인한 다음
	//일치하면 출차 가능 (else로 불일치)
	//출차 시 출차 시간 입력 받아 저장
	//*출차시 금액계산* (일단 지금은 제외)
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
	//	String[] carlist = new String[12]; //총 3층에 1층마다 4자리
		
		System.out.println("출차할 자동차 번호를 입력해주세요 : "); String out = scanner.next();
		//차량번호와 출차시간도 같이 받아서 출차 시간은 저장하고 차량번호는 리스트에서 제외함
		System.out.println("출차 시간을 입력해주세요. : "); String outtime = scanner.next();
		//입차시간 - 출차 시간 = 머무른 시간(요금으로 변경)
		//월 일 시 분 - 입차와 동일
		
		
	for( int i = 0 ; i<carlist.length; i++  ) { //i는 0이고 이게 주차장을 하나씩 비교해가며 올라갈때
		
			if( carlist[i] == out ) { //주차장이 비어있지 않고
									//주차장을 떠도는 i와 입력값이 동일할때 = 주차장에 차가 있음
				
				//차량 리스트에서 제외하고 출차 시간을 저장 !!!!!!!!!!!!
				
				
				
				////
//				boolean result = Controller.carout(out) {    //리스트에서 아웃 
//					//빼내고 출차한 시간 입력값을 저장하고
//					//입차-출차=요금 값을 나타낸다.
//					//result가 맞으면 if 아니면 else
//					if(result) System.out.println("출차가 완료되었습니다.");
//					else System.out.println("출차에 실패하였습니다. 다시 입력해주세요."); } // boolean end
				
			}
			//i는 0이고 이게 주차장을 하나씩 비교해가며 올라갈때 주차장을 떠도는 i와 입력값이 다를 때
			else { System.out.println("입차하지 않은 차량입니다."); }
		}//for end
		
		
/*	
	private int location ;
	private String carnum ; 
	private String intime ;
	
	출차시 : 차량번호[4자리] 를 입력받아 출차시 금액계산
			* 금액표 
				1. 최초 30분 무료 
				2. 30분 이후부터 10분당 1000원
				3. 하루 최대 5만원 부과
				4. 1일당 5만원
		//월 일 시 분
	입차시 : 
				
				else if( ch2 == 3 ) { 
						System.out.println(" 현 게시물 패스워드 : "); String password = scanner.next(); 
						boolean result =  Controller.delete( index , password); // 삭제할 인덱스번호,패스워드 => 인수
						if( result ) System.err.println(" 알림]] 삭제 성공 ");
						else System.err.println(" 알림]] 삭제 실패 ( 패스워드가 다릅니다.) ");
				
for( int i = 0 ; i<carlist.length ; i++ ) {
if( carlist[i] == null ) { carlist[i] = strnum; save=true; break; }
} //for end
					
		
 * //주차장이 비어있지 않으며 차량 리스트에서 일치하는 번호가 잇을 경우
		차량리스트 != null (만일 null일 경우 주차된 차량이 없다고 송출)
			//일치하는 번호가 있을 경우
			if(차량리스트 == out) { System.out.println("출차 시간을 입력해주세요."); String outtime = scanner.next();
					//출차 시간 저장
				* 입차시간-출차시간 = 머문시간(요금값으로 변경) 하여 나타내는 코드
		
				//출차 시간xxxxx
				 요금값을 저장하는 코드 받고 한번 더 괄호로 묶어서
				 System.out.println("출차가 완료되었습니다."); 를 나타낸다.
				//리스트에서 제외
		} else {System.out.println("주차되지 않은 차량입니다.");}
*/	
		

		
////////////////////////////////////////////////////		
	}	
}
