package Day12;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class day12_3 {
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		/*도서 검색 프로그램
			조건
			1. 입력받기 [system.in.read()]
			2. String 배열을 이용한 도서명을 여러개 저장
				-String[] 도서목록 = { "된다! 네이버 블로그&포스트" "스프링 부트 실전 활용 마스터"
									"tucker의 go 언어 프로그래밍" "혼자 공부하는 c 언어"
			3. 검색기능, 수정기능
				-검색 기능: 특정 문자를 입력받아 도서내 포함된 문자가 있으면 모두 출력
					'언어' 검색 ->	"tucker의 go 언어 프로그래밍" / "혼자 공부하는 c 언어"
					'수정' 수정 -> 수정할 도서명의 일부를 입력받아 출력된 도서명증 번호를 선택 후 수정기능 적용
						수정할 도서명의 일부 문자 / 새로운 문자 입력받아 수정 완료
		 	*/	

		
		String[] booklist = {"된다! 네이버 블로그&포스트","스프링 부트 실전 활용 마스터",
				"tucker의 go 언어 프로그래밍","혼자 공부하는 c 언어"};
		
		
		while(true) {
			System.out.println("메뉴 : 1.도서검색 2.도서수정");
		
			byte[] bytes = new byte[100];
			int count = System.in.read(bytes);
			// 키보드로부터 [스트림] 바이트를 읽어오기 //일반예외!! [예외 떠넘기기]
			//읽어온 byte 개수
			
			String ch = new String(bytes, 0, count-2); //bytes에서 2개를 빼야 equals를 했을 때 엔터등이 포함x
			
			if(ch.equals("1")) {
				System.out.print("검색할 도서 이름 : "); count= System.in.read(bytes);
				String search = new String(bytes, 0 ,count-2); // 찾을문자
				
				System.out.println("검색 결과");
					for(String temp : booklist) {//모든배열 내 문자열을 하나씩 꺼내오기
						if(temp.indexOf(search) != 1) { 
							//해당 문자열내 찾을문자의 인덱스가 존재하면.
							
							//indexOf 메소드 -1 반환되는경우는 동일한 단어가 없을경우 [검색x
							System.out.println(temp); //찾음
							//해당 문자열내 찾을 문자가 존재
										
			//방법2
//				if(temp.contains(search)) {
//					//문자열.contains("찾을문자") : 문자열내 찾을문자가 true[있다] / false[]없다
//					System.out.println(temp); }
			
						}
					}
			} 
			else if(ch.equals("2")) {
				System.out.println("수정할 도서 이름(일부 기입 가능) : ");
				count = System.in.read(bytes); //키보드로부터 바이트 읽어와서 배열에 저장
				String search = new String(bytes, 0, count-2); //0번 인덱스 바이트부터 -2제외한 인덱스까지
				
				int i = 0 ; //인덱스를 만들어줌
				for(String temp : booklist) {
					if(temp.indexOf(search) != 1) { 
						//문자열.contains("찾을문자") : 문자열내 찾을문자가 true[있다] / false
						System.out.println("도서번호 : "+ i + "교재명 : " +temp); //찾음
						//해당 문자열내 찾을 문자가 존재
				}	
			} i++;
				
			//도서번호[인덱스] 입력받아 수정하기
			System.out.println("도서 번호 선택 : ");
					count = System.in.read(bytes); //따로 저장
					String ch2 = new String(bytes, 0 ,count-2);
					int index = Integer.parseInt(ch2); //ch2 문자열로 입력받음 ->인덱스[숫자] 변환
					
			//수정 내용 입력받기
				System.out.println("기존 문자 : ");
					String oldstr = new String(bytes , 0, count-2);
				System.out.println("새로운 문자 : ");
					count = System.in.read(bytes);
					String newstr = new String(bytes, 0 ,count-2);
				//수정처리
				booklist[index].replace(oldstr, newstr);
				System.out.println("변경 되었습니다.");
						
			}
		
		
		}
		
		
/////////////////////////////////////////////	
	}
}
