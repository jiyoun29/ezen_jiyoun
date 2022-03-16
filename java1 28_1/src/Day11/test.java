package Day11;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		
		학생[] 학생배열 = new 학생[100]; //새로 클래스 만들어서 filed와 geterseter 불러오는것
		//학생을 추가해도 학생이 보여야한다..
		Scanner scanner = new Scanner(System.in);
		
		while(true) {

			try { //프로그램이 돌아갈수잇게 예외처리도
				System.out.println("학생 목록");
				
				//점수 출력
				
				System.out.println("1. 학생 등록 2. 학생 삭제");
				int ch =scanner.nextInt();
				
				if(ch == 1) {
					
				} else if (ch == 2) {
					
				} else {
					
				}
			} catch(Exception e) {
				
			}
		}
		
	}

}
