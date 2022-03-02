package Day02;

import java.util.Scanner;

public class Day02_5 {

	public static void main(String[] args) {
	
		// 문제 2. 지폐 세기
		
		// 1.  입력객체
		Scanner scanner = new Scanner(System.in);
		
		// 2. 입력 받은 데이터 -> 변수로 이동
		System.out.println("금액 : "); int 금액 = scanner.nextInt();
		// 3. 연산
		System.out.println("입력한 금액 : " + 금액 );
		System.out.println("십만원 : " + (금액/100000) + "장");
		// 십만원 제외
		금액 = 금액 - (금액/100000)*10000 ; //금액에서 십만원 단위 제외
		금액-= (금액/100000)*100000;
		System.out.println("십만원 제외 : " + 금액 );

		System.out.println(" 만원 : " + (금액/10000) + "장");
		// 만원 제외
		금액 = 금액 - (금액/10000)*1000 ; //금액에서 만원 단위 제외
		금액-= (금액/10000)*10000;
		System.out.println("만원 제외 : " + 금액 );	
		
		System.out.println(" 천원 : " + (금액/1000) + "장");
		금액 = 금액 - (금액/1000)*1000 ; //금액에서 천원 단위 제외
		System.out.println(" 백원 : " + (금액/100) + "개" );
		
		
		//문제3
			//배수 찾기
				// 값 % 수 했을때 나머지가 0 어떤 값은 그 수의 배수
		System.out.println("문제3 정수입력:");
		int 문제3 = scanner.nextInt(); //하나의 정수 입력받기
		System.out.println("입력한 정수는 7의 배수 판단 : " + (문제3%7 == 0));
											// 나누기 7 했을때 0이면 배수
		
		//문제4
			//홀짝 찾기
				// 홀수 : 값 % 2 했을때 나머지가 1 이면 값은 홀수
				// 짝수 : 값 % 2 했을때 나머지가 0 이면 값은 짝수
		System.out.println("문제4 홀짝찾기:");
		int 문제4 = scanner.nextInt();
		System.out.println("입력한 정수는 홀수 판단 : " + (문제4%2 == 1));
						// 나누기 1을 했을 때 1로 떨어지면 홀수, 0으로 떨어지면 짝수
		
		// 문제5
			// 7의 배수이면서 짝수인지
		// System.out.println("7의 배수이자 짝수 : ");
		// int 문제5 = scanner.nextInt();
		// System.out.println("입력한 정수는 7의 배수이자 짝수 판단 : " + (문제5%7 == 1 && 문제5%2 == 0));
			//풀이
		System.out.println("문제4) 정수입력 : "); int 문제5 = scanner.nextInt();
		System.out.println("입력한 정수는 7의 배수이면서 짝수 판단 : " + (문제5%7 == 0));
		
		//문제6
			// 두개의 정수를 입력 받아 큰지 출력
			// 풀이
		System.out.println("문제6) 정수1 입력: "); int 문제6_1 = scanner.nextInt();
		System.out.println("문제6) 정수2 입력: "); int 문제6_2 = scanner.nextInt();
		int 큰수 = 문제6_1 > 문제6_2 ? 문제6_1 : 문제6_2;
				// ?=참 :=거짓 맞으면 1을 아니면 2를
		System.out.println("더 큰 수는 : " + 큰수 );

		//문제7
			// 반지름을 입력받아 원 넓이 출력하기 ( 반지름 * 반지름 * 원주율[3.14])
		// System.out.println("반지름 : ");
		// int 반지름 = scanner.nextInt();
		// System.out.println("반지름을 이용한 원 넓이 : " + (반지름*반지름*3.14));
		
		System.out.println("문제7) 정수 입력 : "); int 문제7 = scanner.nextInt();
		System.out.println(" 원 넓이 : " +(문제7*문제7*3.14));
		
		
		//문제8
			// 두 실수를 입력받아 앞 실수의 값이 뒤의 값의 몇% 인지 출력하기
		// 예) 54.5   84.3 이면    64.285714%
		
		// System.out.println("문제8) 첫번째 실수 입력 : "); int 문제8_1 = scanner.nextInt();
		// System.out.println("문제8) 두번째 실수 입력 : "); int 문제8_2 = scanner.nextInt();
		// System.out.println("1번은 2번의 몇 %인가? : " + (문제8_2/문제8_1));
		
		System.out.println("문제8) 실수1 입력 : "); double 문제8_1 = scanner.nextDouble();
		System.out.println("문제8) 실수2 입력 : "); double 문제8_2 = scanner.nextDouble();
		double 비율 = (문제8_1/문제8_2)*100;
		System.out.println("실수1의 실수2 백분율 : " + 비율 + "%");
		System.out.println("실수1의 실수2 백분율 : %.2f %%" + 비율);
				// %f : 실수.
				// %.숫자f : 숫자만큼 소수점이 나옴

		//문제9
			// 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기]
		//사다리꼴 계산식 = > (윗변 * 밑변) * 높이 / 2
//		System.out.println("문제9) 윗변 : "); int 문제9_1 = scanner.nextInt();
//		System.out.println("문제9) 밑변 : "); int 문제9_2 = scanner.nextInt();
//		System.out.println("문제9) 높이 : "); int 문제9_3 = scanner.nextInt();
//		System.out.println(" 사다리꼴의 넓이는 : " + ((문제9_1*문제9_2)*문제9_3)/2);
		System.out.println("문제9) 윗변 : "); double 윗변 = scanner.nextDouble();
		System.out.println("문제9) 밑변 : "); double 밑변 = scanner.nextDouble();
		System.out.println("문제9) 높이 : "); double 높이 = scanner.nextDouble();
		System.out.println(" 사다리꼴의 넓이는 : " + (윗변*밑변)*높이/2);
				
		//문제10: 키를 정수를 입력받아 표준체중 출력하기
				//표준체중 계산식 = > (키 - 100) * 0.9
		System.out.println("문제10) 키 : "); int 키 = scanner.nextInt();
		System.out.println("표준체중은 : " + (키-100)*0.9);

		//문제11: 키와 몸무게를 입력받아 BMI 출력하기
				//BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))
		System.out.println("문제11) 키 : "); int 키2 = scanner.nextInt();
		System.out.println("문제11) 몸무게 : "); int 몸무게 = scanner.nextInt();
		System.out.println("BMI는 : " + 몸무게/((키2/100)*(키2/100)));
		// double로 한다면 %.2f 등을 이용해 나타낼 수 있다. 단, 숫자도 소숫점까지 입력( 100.0 )
		
		//문제12: inch 를 입력받아 cm 로 변환하기 [ 1 inch -> 2.54cm ] 
		System.out.println("문제12) 변환할 인치 : "); int 문제12 = scanner.nextInt();
		System.out.println(" cm는? : " + (문제12*2.54));
		
		
		
		//문제13:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하기
				//소수 둘째 자리 까지 점수 출력하기
				//중간고사 반영비율 => 30 %
				//기말고사 반영비율 => 30 %
				//수행평가 반영비율 => 40 %
		System.out.println("문제13) 중간고사 : "); double 중간고사 = scanner.nextDouble();
		System.out.println("문제13) 기말고사 : "); double 기말고사 = scanner.nextDouble();
		System.out.println("문제13) 수행평가 : "); double 수행평가 = scanner.nextDouble();
		중간고사 = 중간고사*0.3;
		기말고사 *= 0.3;
		수행평가 *= 0.4;
		System.out.printf("반영비율 점수 : %.2f \n", (중간고사+기말고사+수행평가));
		
		//문제14 :  연산 순서 나열 하고 x와 y값 예측하기
			//int x = 10; int y = x-- + 5 + --x;
			//printf(" x의 값 : %d , y의값 :  %d ", x, y)
				// 1. x-- + 5 (후위감소므로 더하기가 먼저) -> 10+5
				// 2. x-- -> x 감소 [x=9]
				// 3. 15 + --x -> 감소가 먼저 [x=8]
				// 4. 15 + 8 => y=23
	
	
		// 혼자서 해보기 15~17
		//문제15 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년으로 출력하기
	

		//문제16 : 3개의 정수를 입력받아 오름차순으로 정렬 
		//	int num[] = new int[3];
		//	Scanner input = new Scanner(System.in);
		//	System.out.println("숫자 3개를 입력하세요 : ");

				
		//문제17 : 4개의 정수를 입력받아 내림차순으로 정렬 
		
		
				
				// p. 102 확인문제
		
	}
}
