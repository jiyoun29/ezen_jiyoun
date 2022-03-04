package Day04;

import java.util.Scanner;

public class Day4_1 {
	public static void main(String[] args) {
		
		// 제어문: if , switch
		// 반복문: for, while
			// for [] while [무한루프]
			// for은 필요: 1. 초기값, 2. 조건식, 3.증감식, 4.실행문
			// while의 형태
				// 초기값 ;
				// while (조건식){
				// 실행문 ;
				// 증감식 ; }
			// for과 while 형태 위치의 차이점
			// 어떤 조건이 true 이어야만 실행된다. **
			// 증감식을 넣지 않으면 무한 루프에 빠진다. *
		
		// for 예1)
		for(int i = 1 ; i <=10 ; i++) //i가 1일때 10 이하까지 1씩 더해간다면
			// i는 1부터 10이하까지 1씩 증가하면서 실행문 반복처리 -> 10번 실행 (이거 바로 읽을 수 있어야 함)
		{	System.out.println(i + " ");	}
		
		// while 예1)
		int i = 1 ; //1.초기값
		while(i<=10) { //i가 10 이하 이면서.... 2. 조건식 (while start)
		System.out.println(i+" "); //4. 실행문
		i++; //3. 증감식
		} // while end
		
		// for 예2) 1~100 누적합계
		int sum = 0;
		for(int j = 1 ; j<=100 ; j++) { // int i는 위에서 while이 선언했기 때문에 재사용이 불가능(초기값을 밖에서 선언하므로)
			sum += j; //누적합계. sum = sum + j
		} System.out.println("for 1+100까지 : " + sum);
				
		// while 예2) 1+100 누적합계
		int j = 1; // 1. 초기값
		int sum2 = 0;
		while(j<=100) { // 2.조건식 [true이면 실행]
			sum2 += j; // 3. 실행문; ->증감식까지 추가할것
			j++; //j가 증가를 하면 101이 되는 순간 끝난다.
		} System.out.println("while 1+100까지 : " + sum2);
		
		// while 예3) 무한루프 -> 프로그램이 24시간 돌아가게 할 때
		while(true) { //조건식이 true 실행 // true 상수-> 무한루프
			System.out.println("무한루프"); //무한루프에 빠진다.
			Scanner scanner = new Scanner(System.in);
		 int exit = scanner.nextInt(); //스캐너 만들기
		 if ( exit == 3 ); //exit가 3일때 탈출(브레이크)
			break; //switch에서 필수적으로 쓰는 브레이크. 브레이크 기준으로 가장 가까운 while문(if 제외 반복문) 탈출
		}
		
		
		
		
	} // me

} // c e
