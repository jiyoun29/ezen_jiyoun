package Day05;

import java.util.Scanner;

public class Day05_3 {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while (run) { //무한루프 종료조건 : 5번
			System.out.println("--------------------------------");
			System.out.println("1.학생 수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------");
			System.out.println("선택 : ");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				System.out.println("학생수 : "); studentNum = scanner.nextInt();
				// 입력 받은 학생수 만큼 배열 길이 선언
				scores = new int[studentNum]; //입력수만큼 배열의 길이를 선언
			} else if(selectNo == 2) {
				for(int i = 0 ; i<scores.length; i++) { //배열 내 모든 인덱스 만큼 반복처리
					System.out.printf("scores[%d] : \n", i ); scores[i]= scanner.nextInt();
				}				
			} else if(selectNo == 3) { //학생 점수 출력하기
				for(int i = 0 ; i<scores.length; i++) {
					System.out.printf("scores[%d] : %d \n", i , scores[i]);
				}								
			} else if(selectNo == 4) { int 최고점수 = 0; int 총합계 =0; double 평균점수 = 0.0;
				for(int i = 0; i <scores.length; i++) {
					//최고점수 구하기
					if(최고점수 < scores[i] ) 최고점수 = scores[i]; //i번째ㅔ 인덱스에 데이터 대입
					// 누적합계
					총합계 += scores[i];
				}
				//평균점수 구하기
				평균점수 = (double)총합계/scores.length;

				
			System.out.println("최고 점수 : " +최고점수);
			System.out.println("평균 점수 : " +평균점수);
				
			} else if(selectNo == 5) {
				run = false; // run이 false가 되면 종료(break와 같음), 반복문 탈출
			}	
		}
		
		System.out.println("프로그램 종료");
		
		
		//////////////////////////////////////////
	}

}
