package Day19;

import java.util.Hashtable;
import java.util.Scanner;

public class day19_4 {
	public static void main(String[] args) {
		
		//p.747
		
		//1. Hashtable class로 클래스 객체 선언
		Hashtable<String, String> map = new Hashtable<>();
		
		//2. map 객체에 추가
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
				//key       value
				//아이디		비밀번호
		
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) { //반복문 무한루프
			System.out.println("아이디 : "); String id = scanner.next();
			System.out.println("비밀번호 : "); String pw = scanner.next();
			
			// 만약에 map객체 내 해당 key가 존재하면? true/ 아니면 false
			if(map.contains(id)){
				//만일 입력한 아이디가 map 객체 내 key로 존재하면
				if(map.get(id).equals(pw)) {
					//만약에 key 이용한 값 호출해서 입력한 pw 와 동일하면
					
				} else {System.out.println("입력 하신 비밀번호가 다릅니다.");}
				
			} else {System.out.println("입력 받은 아이디가 존재하지 않습니다."); }
			
		} //while end
		
//////////////////////////////////////////////////////		
		
	}
}
