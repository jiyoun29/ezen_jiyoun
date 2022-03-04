package Day03;

import java.util.Scanner;

public class Day03_6 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //입력객체
		
		// 별문제1 : 입력받은 수만큼 *을 출력(반복문 사용)
		System.out.println("문제1) 별개수 : "); int s1 = scanner.nextInt();
		for(int i = 1 ; i<=s1 ; i++) {
			// i는 1부터 입력 받은 수까지 i는 1씩 증가한다.
			System.out.print("*");		}
		
		// 별문제2 : 입력받은 수만큼 *을 출력 [단 5개마다 줄바꿈 처리]<-if 처리
		System.out.println("문제2) 별개수 : "); int s2 = scanner.nextInt();
		for(int i = 1 ; i<=s2 ; i++) {
			// i는 1부터 입력받은 수까지 i는 1씩 증가하면서 실행문 반복처리.
			System.out.print("*"); //5개마다 줄바꿈 처리 -> 5배수마다 내림 -> 배수찾기 처리
			if(i%5==0) //i를 나누기 5했을때 0으로 떨어진다. 5배수 찾기.
				System.out.println(); //줄바꿈 처리. 라인이 내려간다.
			}
		
		// 별문제3 : 입력받은 줄수만큼 출력(3이면 ***) 변수를 몇개 사용할지 생각
		// i을 줄로 간주하고 i=n일때를 생각. s=별일때 i=1 <> s=1. i=2 <> s= 1 2 이런식
		// 패턴찾기. i는 1부터 5까지 1씩 증가. s는 1부터 
		System.out.print("문제3) 줄수 : "); int line3 = scanner.nextInt();
		for(int i=1 ; i<=line3 ; i++ ) { //입력받은 수까지를 line으로 입력.
			// s는 1부터 현재 줄수까지 1씩 증가하며 별을 출력
			// i는 1부터 입력받은 줄 수까지 1씩 증가
			
			// 1. 별찍기
			for(int s = 1 ; s<=i ; s++) {
				System.out.print("*");
			}
			
			// 2. 줄바꿈처리
			System.out.println();
			// 현재 줄수를 알려주는 i, 별은 1줄당 1개, 2개...늘어나므로 i가 2면 s는 2번.
		}
		
		// 순서도
			// 사용자가 3을 입력했을때 i = 1 ; i<=3 [true]
				// for 문 중첩이므로 s 실행.
				// s = 1 ; 1<=1 [true] -> * 별을 찍음 -> s++
				// s= 2 ; 2<=1 [false] -> 반복문 종료
			//줄바꿈
				// i = 2 i<=3 [true]
				// s = 1 s<= 2 [true] -> * -> s++
				// s = 2 s<= 2 [true] -> * -> s++
				// s = 3 s<= 3 [false] -> 반복문 종료
			// 줄바꿈
				// i = 3 ; i <= 3 [true]
				// s = 1 ; s<= 3 [true] -> * -> s++
				// 반복. s = 4 ; s<=4 [false] -> 반복문 종료
			// 줄바꿈
				// i = 4 ; i<=3 [false] 반복문 종료
		
		//별문제4
		System.out.print("문제4) 거꾸로 별 : "); int line4 = scanner.nextInt();
		for(int i=1 ; i<=line4 ; i++ ) { 
			// i는 입력 받은 수까지 1씩 증가 줄바꿈. s는 1부터 입력 받은 수-현재 줄수까지 1씩 증가. 별출력
			// 1. 별찍기
			// i를 빼면 1씩 감소하므로 뺀 것에 다시 1을 더해야 5 4 3 2 1이 된다. 계산식을 찾아야함
			for(int s = 1 ; s<=line4-i ; s++) {
				System.out.print("*");	
			}
			// 2. 줄바꿈
			System.out.println();
		}
		
		// 별문제5 : 입력받은 줄만큼 출력 (줄을 찍는 i, 공백을 찍는 b. 별을 찍는s 필요)
		System.out.print("문제5) 직각 별 : "); int line5 = scanner.nextInt();
		for(int i=1 ; i<=line5 ; i++) {
			//1. 공백찍기
			for(int b = 1 ; b<=line5-i ; b++) {
				System.out.print(" "); // 공백 -> 스페이스
			}
			//2. 별찍기
			for(int s = 1 ; s<=i ; s++) {
				System.out.print("*");
			}
			//3. 줄바꿈
			System.out.println();
		} //잘안된다 다시 해보기	/ ln하지말고 print로 하고. 1이랑 i헷갈리지 않기*****
		
		
		//별문제6 : 입력받은 줄만큼 출력 ****이해 필요
		System.out.print("문제6) 거꾸로 직각 별 : "); int line6 = scanner.nextInt();
		for(int i=1 ; i<=line6 ; i++) { //i는 1부터 입력받은 수까지 출력
			//1. 공백찍기
			// i까지가 아니라 i전까지. -i(b<=i-1)을 하거나 미만(b<i)처리하기
			for(int b = 1 ; b<=i-1 ; b++) {
				System.out.print(" ");
			}
			//2. 별찍기
			// s는 5 4 3 2 1 이므로 입력받은 값-1. 입력받은 수에 현재 상태i를 빼고 1을 더한다.
			for(int s = 1 ; s<=line6-i+1 ; s++) {
				System.out.print("*");
			}
			//3. 줄바꿈처리
			System.out.println();
		} //순서도를 적어놓고 증가하는 단위를 찾음

		//별문제7 : 입력받은 줄만큼 출력
		System.out.println("문제7) 트리 : "); int line7 = scanner.nextInt();
		for(int i=1 ; i<=line7 ; i++) {
			//1.공백찍기
			for(int b=1 ; b<=line7-i ; b++) {	System.out.print(" ");	}
			//2. 별찍기
			//처음부터 2를 곱하면 2부터 출력되므로 -1를 찍는다.
		for(int s =1 ; s<=i*2-1 ; s++) {	System.out.print("*");
		} System.out.println("");
		}
		
		//별문ㅁ제8 : 트리모양 숫자
		System.out.println("문제8) 숫자트리 : "); int line8 = scanner.nextInt();
		for(int i=1 ; i<=line8 ; i++) {
			//1.공백찍기
			for(int b=1 ; b<=line8-i ; b++) {	System.out.print(" ");	}
			//2. 별찍기
			//처음부터 2를 곱하면 2부터 출력되므로 -1를 찍는다.
			//찍는걸 별이 아니라 i로 바꾼다.
		for(int s =1 ; s<=i*2-1 ; s++) {	System.out.print(i);
		} System.out.println("");
		}
		
		//별문제9 : 입력받은 줄만큼 출력
		System.out.println("문제9) 거꾸로 트리 : "); int line9 = scanner.nextInt();
		for(int i=1 ; i<=line9 ; i++) {
			//1. 공백찍기
			for(int b = 1 ; b<=i*2+1 ; b++) { System.out.print(" ");		}
			//2. 별찍기
			for(int s=1 ; s<=i+1 ; s++) {	System.out.print("*");}
			for(int b = 1 ; b<=i*2-1 ; b++) { System.out.print(i);		}
			System.out.println(" ");
		} 
		
		
//		System.out.print("문제6) 거꾸로 직각 별 : "); int line6 = scanner.nextInt();
//		for(int i=1 ; i<=line6 ; i++) { //i는 1부터 입력받은 수까지 출력
//			//1. 공백찍기
//			// i까지가 아니라 i전까지. -i(b<=i-1)을 하거나 미만(b<i)처리하기
//			for(int b = 1 ; b<=i-1 ; b++) {
//				System.out.print(" ");
//			}
//			//2. 별찍기
//			// s는 5 4 3 2 1 이므로 입력받은 값-1. 입력받은 수에 현재 상태i를 빼고 1을 더한다.
//			for(int s = 1 ; s<=line6-i+1 ; s++) {
//				System.out.print("*");
//			}
//			//3. 줄바꿈처리
//			System.out.println();
//		} //순서도를 적어놓고 증가하는 단위를 찾음
		
		//별문제10 (7+9)
		
		
		
		// --------------------건들지 x
	} // me
} //ce
