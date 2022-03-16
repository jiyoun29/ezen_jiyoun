package test;

import java.util.Scanner;

public class Board { //출력하는 곳
	public static void main(String[] args) {

		//학생 이름,성적 입력 받아서 총점,평균,석차 나타내기
		//저장하고 맨앞에서 성적표 출력하기
		//등록 삭제 만들기
		
		Scanner scanner = new Scanner(System.in);
		
	// 	Controller.load(); //모든 게시물 불러오기
		
		
	while(true) {

		try {
			System.out.println("===========성적표============");

		//	System.out.println("번호 이름 국어 영어 수학 총점 평균 석차");
			
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%.1f\t%s \n",
						"번호","이름","국어","영어","수학","총점","평균","석차");
				
				System.out.println("==========================");
				//번호는 저장되는 순서로 인덱스 처리

				int i = 0; //리스트 내 인덱스
				for (student student : Controller.studentlist) {
					System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%d \n", i,
							student.getIndex(),
							student.get이름(), student.get국어(),
							student.get영어(), student.get수학(),
							student.get총점(), student.get평균(),
							student.get석차());
						i++; } // for end
				
			
			System.out.println("메뉴 : 1. 학생점수 등록 2.학생점수 삭제"); int ch = scanner.nextInt();
			
			scanner.nextLine();
			//엔터 취급으로 잘라줌
			
				if(ch == 1) { System.out.println("===== 학생점수 등록 =====");
				System.out.println("번호 : "); int index = scanner.nextInt();	
				System.out.println("이름 : "); String 이름 = scanner.next();			
				System.out.println("국어 : "); int 국어 = scanner.nextInt();
				System.out.println("영어 : "); int 영어 = scanner.nextInt();
				System.out.println("수학 : "); int 수학 = scanner.nextInt();
				
				//쓰기로 넘기기(인수 전달)
				Controller.write(index, 이름, 국어, 영어, 수학);
				
				} else if (ch == 2) { System.out.println("===== 학생점수 삭제 =====");
				System.out.println("삭제할 학생 번호 : "); int index = scanner.nextInt();
				System.out.println("삭제할 학생 이름 : "); String 이름 = scanner.nextLine();	
					boolean result = Controller.delete(index, 이름);{
					if(result) System.out.println("삭제 성공");
					else System.out.println("삭제 실패.다시 입력해주세요.");
					}
				}
				else { System.out.println("다시 입력해주세요."); }
			
	
			
			} catch(Exception e) { System.out.println("다시 입력해주세요.");
				scanner = new Scanner(System.in);
				
			}
			
	}
		
		
		
////////////////////////////////////////////////////
	}
}
