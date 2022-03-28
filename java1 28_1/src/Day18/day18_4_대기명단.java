package Day18;

import java.util.ArrayList;
import java.util.Scanner;

public class day18_4_대기명단 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//대기명단 프로그램
			//메뉴 : [고객] 1.대기추가 2.대기취소 [관리자] 3.대기자입장
				//대기 추가 : 인원수를 입력받아 대기번호 받음
				//대기 취소 : 대기번호 입력받아 명단 취소
				//대기자 입장 : 첫번빼 대기 중인 대기번호 호출
		
		//껏다키면 리셋되도록
		int 대기번호 = 0;//선언
		
		ArrayList<대기> 대기명단 = new ArrayList<>();
			//여러개 대기객체 저장
		
		while(true) {
			System.out.println("대기번호\t인원수\t대기예약시간[인덱스]");
				//반복문을 이용한 리스트 내 모든 객체 호출
			for(대기 temp : 대기명단) {
				if(대기명단.indexOf(temp)==0) System.out.println(temp.대기번호+"\t"+temp.인원수+"\t"+"입장");
																			//내 위치찾기(indexOf)
				System.out.println(temp.대기번호+"\t"+temp.인원수+"\t"+대기명단.indexOf(temp)*3+"분");
			}
			
			//메뉴
			System.out.println("1.대기추가 2.대기취소 [관리자] 3.대기자 입장"); int ch = scanner.nextInt();
			if(ch == 1) {  //입력받은 값ㅇ르 변ㄱ수에 저장
				System.out.println("전화번호 : "); String 전화번호 = scanner.next();
				System.out.println("인원수 : "); int 인원수 = scanner.nextInt();
				//변수 객체화
				대기 temp = new 대기(대기번호, 전화번호, 인원수);
				
				//대기인원 저장
				대기명단.add(temp);
				대기번호++; //대기번호 증가
				
			} else if (ch == 2) {
				//입력된 값을 받아서 삭제
				System.out.println("대기번호 : "); int 삭제번호 = scanner.nextInt();
				//리스트 내 객체 필드 검색
				for(대기 temp : 대기명단) {
					if(temp.대기번호 == 삭제번호) {대기명단.remove(temp); break;}
					//대기명단 리스트에 하나씩 temp를 호출하여 만약 temp내 대기번호가 입력받은 삭제대기번호와 같으면 해당 temp는 삭제후 반목분 종료
				}
				
				
				
				
				
			} else if (ch == 3) {
				
				System.out.println("가장 앞에 있는 대기 명단을 입장 시킵니다."); 대기명단.remove(0); 
				//0번째 인덱스 삭제
				
				
				
			} else {}
			
			
			
			
			
		}
		
		
	}
}
