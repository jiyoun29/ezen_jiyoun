package Day10;

import java.util.ArrayList;
import java.util.Scanner;

public class day10_5_도서관리_리스트버전 {
	public static void main(String[] args) {
		
		
		//1.리스트(객체) 생성
		ArrayList<book> booklist = new ArrayList<>();
		//리스트 클래스<리스트 안에 저장할 클래스>
			//<클래스> : 리스트 안에 저장할 클래스명. 해당 클래스의 여러 개체를 리스트에 저장.
			//길이는 가변[ 기본 : 10 ] 자동으로 늘어나고 줄어든다.
		
	Scanner scanner = new Scanner(System.in);
	
		while(true) {
			System.out.println("1.등록 2.목록 3.삭제 4.수정");
			//입력 받고 if
			int ch = scanner.nextInt();
			if(ch==1) {
				//1. 입력 받음
			System.out.println("도서명 : "); String 도서명 = scanner.next();
			System.out.println("저자 : "); String 저자 = scanner.next();
			
			
				//2. 객체화(여러 변수를 하나의 객체로.)
			book book = new book(도서명, 저자);
					//입력 받은 값을 전달

			
			
				//3. 배열 저장 [공백을 찾아서 저장] vs 리스트 [공백 찾지 않음]
			booklist.add(book); //리스트에 저장
			// why : add 라는 메소드가 어느 객체를 추가할때 사용.
				// 마지막 인덱스에 자동적으로 객체가 추가된다.
			
			}
			if(ch==2) {
				// 1.배열[공백(null) 제외] vs 리스트
				System.out.println("도서명 \t 저자");
				for(book book : booklist) {
					System.out.println(book.get도서명() + "\t"+ book.get저자());
				}	
			}
			
			if(ch==3) {
				// 1. 배열[삭제 후에 뒤 인덱스 당기기] vs 인덱스[자동]
				// 1 2 3 4 [2삭제] 1 null 3 4    vs    1 3 4
				System.out.println("삭제할 도서명 : ");
				String 도서명 = scanner.next();
				
				//도서 찾기
				for(book book : booklist) {
					if(book.get도서명().equals(도서명)) {
						booklist.remove(book); break;
					}
				}
				
				
			}
			if(ch==4) {
				System.out.println("수정할 도서명 : ");
				String 도서명 = scanner.next();
				for(book book : booklist) {
					
					if(book.get도서명().equals(도서명)) {
						
						System.out.println("수정할 저자이름 : ");
						String 저자 = scanner.next();
						
						//setter저장 getter 불러오기
						book.set저자(저자);
						break;
					}
				}
				
				
				
			}
			
		}
		
		
		
//////////////////////////////////
	}

}
