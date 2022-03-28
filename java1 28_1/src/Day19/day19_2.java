package Day19;

import java.util.HashSet;
import java.util.Scanner;

public class day19_2 {
	public static void main(String[] args) {
		
		//로또 프로그램
			//set을 이용하여 제작
		
		Scanner scanner = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<>();
		
		
		while(true) { //무한루프 [ 종료조건 : set객체 내 객체 수가 6이면  break;
			System.out.println("1~45 숫자 선택(중복불가능) : ");
			int num = scanner.nextInt();//3. 입력받기
			
			if(num<1 || num >45) { //4. 1~45 사이가 아니면 다시 입력받기
				System.out.println("선택할 수 없는 번호입니다.");
			} else {
				set.add(num); //5. 1~45 사이 객체이면 set에 저장
				System.out.println("확인 : "+set);
			}
			if(set.size() == 6) break;
			//저장된 객체 수가 6개이면 종료
		}
		
	}
}
