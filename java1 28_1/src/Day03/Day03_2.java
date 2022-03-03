package Day03;

import java.util.Scanner;

public class Day03_2 {
	public static void main(String[] args) {
		
		// 입력객체= {} 당 1번만 선언
		Scanner scanner = new Scanner(System.in);
		
		// 문제1 : 2개의 정수를 입력받아서 더 큰수 출력
		System.out.print("정수1 입력: ");		int 정수1 = scanner.nextInt();
			// int형 변수를 선언하고 입력받은 값을 정수로 가져와서 대입
		System.out.print("정수2 입력: ");		int 정수2 = scanner.nextInt();
		
		// 제어
		if (정수1 > 정수2) System.out.println("더 큰 수 : " + 정수1);
			// 만약에 입력받은 정수1변수가 정수2변수보다 크면 실행 아니면 다음 조건 확인.
		else if(정수1 < 정수2) System.out.println("더 큰 수 : " + 정수2);
			// 프린트 안의 정수는 조건문에 들어간 맞는 답
			// [다음조건] 정수1변수가 정수2변수보다 작으면 실행 아니면 그 외
		else System.out.println("같다.");
			// 그 외 나머지 실행

			// 코드가 너무 늘어나지 않게 변수를 사용하여 코드를 줄임
		// 문제2 : 3개의 정수를 입력받아서 가장 큰 수 출력
		System.out.print("정수3 입력: ");		int 정수3 = scanner.nextInt(); //변수명 중복x
		System.out.print("정수4 입력: ");		int 정수4 = scanner.nextInt();
		System.out.print("정수5 입력: ");		int 정수5 = scanner.nextInt();
		int max = 정수3; // max는 가장 큰 수를 임시로 저장하는 변수(역할)
						// 첫번째 값을 max로 넣어놓고 두번째 값과 비교
			// max에 첫번째 값 넣어두기
		if (max < 정수4) {
			// 만약에 max보다 두번째 값이 더 크면 교체
			//int temp = 정수4 ; // temp=임시, 교환용 (한바퀴 돌리는 것)
			// 정수4 = max; max = temp;	//한바퀴 돌림
			max = 정수4;	}
		if (max < 정수5) {max=정수5;}
		System.out.println("가장 큰 수 : " + max);
		
		
		// 문제3 : 4개의 정수를 입력받아서 가장 큰 수 출력
		System.out.print("정수6 입력: ");		int 정수6 = scanner.nextInt();
		System.out.print("정수7 입력: ");		int 정수7 = scanner.nextInt();
		System.out.print("정수8 입력: ");		int 정수8 = scanner.nextInt();
		System.out.print("정수9 입력: ");		int 정수9 = scanner.nextInt();
		int max2 = 정수6;
		if (max2 < 정수7) { max = 정수7;} // max2가 정수 7보다 작으면 교체
		if (max2 < 정수8) { max = 정수8;}
		if (max2 < 정수9) { max = 정수9;} // 반복문을 배우면 코드가 줄어든다. 이 방법도 알아두기
		System.out.println("가장 큰 수 : " + max2);
		

		//문제4 : 3개의 정수를 입력받아 오름차순으로 정렬 
		System.out.print("정수10 입력: ");		int 정수10 = scanner.nextInt();
		System.out.print("정수11 입력: ");		int 정수11 = scanner.nextInt();
		System.out.print("정수12 입력: ");		int 정수12 = scanner.nextInt();
		
		if(정수10 > 정수11) {
			// max 없이 temp로 한바퀴 돌리기
			// 교체[스왑 - 두개 변수에 데이터 교화방법]
			int temp =  정수10; //임시변수=변수1
			정수10 = 정수11; // 변수1=변수2
			정수11 = temp; // 변수2= 임시변수			
		}
		if(정수10 > 정수12) { //똑같이 다시 돌리기
			int temp = 정수10; 정수10 = 정수12; 정수12= temp;	}
		if(정수11 > 정수12) { int temp=정수11; 정수11=정수12; 정수12=temp;}
		System.out.printf("입력한 값 오름차순 : %d %d %d", 정수10, 정수11, 정수12);
		// System.out.println("입력한 값 오름차순 :" + 정수10 + "" + 정수11 + "" + 정수12);
			
		//문제5 : 4개의 정수를 입력받아 내림차순으로 정렬 
		System.out.print("숫자1 입력: ");		int 숫자1 = scanner.nextInt();
		System.out.print("숫자2 입력: ");		int 숫자2 = scanner.nextInt();
		System.out.print("숫자3 입력: ");		int 숫자3 = scanner.nextInt();
		System.out.print("숫자4 입력: ");		int 숫자4 = scanner.nextInt();
		
		if(숫자1 < 숫자2) { int temp = 숫자1; 숫자1=숫자2; 숫자2=temp;}
		if(숫자2 < 숫자3) { int temp = 숫자2; 숫자2=숫자3; 숫자3=temp;}
		if(숫자3 < 숫자4) { int temp = 숫자3; 숫자3=숫자4; 숫자4=temp;}
		if(숫자4 < 숫자1) { int temp = 숫자4; 숫자4=숫자1; 숫자1=temp;}
		//숫자 2대신 1을 넣고 각각 따로따로 비교하는 방법도 있음
		System.out.printf("입력한 값 내림차순 : %d %d %d", 숫자1, 숫자2, 숫자3, 숫자4);
		
		
	}
}