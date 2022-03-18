package Day13;

import java.util.Random;

public class day13_1 {
	public static void main(String[] args) {
		
		// p534 : Math 클래스 [ 수학 관련 메소드 제공 ], static이므로 객체 없이 사용 가능
		//java.lang 패키지는 import 안 해도 사용 가능
		
		
		//1. 절대값. 해당 수의 절대값을 구할 수 있음
		//선생님 예제
		System.out.println("절대값 : " + Math.abs(-5));
		System.out.println("절대값 : " + Math.abs(-3.14));
		
		//책 예제
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1="+v1);
		System.out.println("v2="+v2);
		
		
		
		//2. 가장 가까운 정수로 올림
		//선생님 예제
		System.out.println("올림값 : "+Math.ceil(5.3)); //소수점 첫째자리에서 무조건 올림
		System.out.println("올림값 : "+Math.ceil(-5.3)); //-5
		
		//책 예제
		double v3 = Math.ceil(5.3);
		double v4 = Math.ceil(-5.3);
		System.out.println("v3="+v3);
		System.out.println("v4="+v4);
		
		
		
		//3. 가까운 정수로 내림
		//선생님 예제
		System.out.println("버림값 : "+Math.floor(5.3));
		System.out.println("버림값 : "+Math.floor(-5.3)); //음수일때 가까운 정수로 내려 뒤로 가므로 -6. 
		
		//책예제
		double v5 = Math.floor(5.3);
		double v6 = Math.floor(-5.3);
		System.out.println("v5="+v5);
		System.out.println("v6="+v6);		
		
		
		
		//4. 수를 2개 넣으면 그 중 더 큰 값
		//선생님 예제
		System.out.println("최댓값 : "+Math.max(5,9)); //둘 중 더 큰게 나옴
		System.out.println("최댓값 : "+Math.max(5.3,2.5)); 
		
		//책 예제
		int v7 = Math.max(5,9);
		double v8 = Math.max(5.3 ,2.5);
		System.out.println("v7="+v7);
		System.out.println("v8="+v8);

		
		
		//5. 수를 2개 넣으면 그 중 더 작은 값		
		//선생님 에제
		System.out.println("최솟값 : "+Math.min(5,9)); //둘 중 더 작은게 나옴
		System.out.println("최솟값 : "+Math.min(5.3,2.5)); 
		
		//책 예제
		int v9 = Math.min(5,9);
		double v10 = Math.min(5.3 ,2.5);
		System.out.println("v9="+v9);
		System.out.println("v10="+v10);
		
		
		
		//6. 인수가 없으나 0부터 1사이의 double형 난수를 반환
		System.out.println("난수 : "+Math.random()); //0~1 사이의 난수 발생
		//vs
		Random random = new Random(); //class와 next를 같이 쓰므로 이게 더 편할 ㅆ ㅜ도 있음
		random.nextBoolean(); //int형으로 보통 뽑아서 씀(편한거 사용하기)
		
		//입력 받을때 클래스 1.System.in.read() 2.Scanner 두가지를 사용하는 방법이 있음
			//허나 1번은 바이트열을 불러와 형변환을 직접해야 하고, 2번은 next를 이용해 객체인 바이트열을 문자등으로 바꿔 가져온다.
			//시기적으로 2번이 더 늦게 나왔으므로 더 편리함
		//난수 1.Math.random() : 형변환 직접. 2.Random : next를 쓰면 자동 형변환
		// 각 1번은 java.lang으로 초기부터 만들어져 있었고 2번들은 보안으로 업데이트된 것
		
		
		
		//7. 어떤 수를 가장 가까운 정수의 실수값을 반올림으로 표시
		//선생님 예제
		System.out.println("가까운 정수의 실수 값 : "+Math.rint(5.3)); //일종의 반올림
		System.out.println("가까운 정수의 실수 값 : "+Math.rint(5.7)); //5이상은 앞에 1을 더한다.
		//실제로 가까운 정수값을 구하느게 round
		//책예제 굳이 볼 필요 x..
		
		
		
		//8. 어떤 수를 가장 가까운 정수의 정수값으로 표시
		System.out.println("가까운 정수의 정수 값 : "+Math.round(5.3));
		System.out.println("가까운 정수의 정수 값 : "+Math.round(5.7));
		//실수가 나오지 않고 정수로 딱 떨어진다.(실수값 안나옴)

		//535p 41번째 : 특정 소수점 위치에서 반올림
		System.out.println(Math.round(12.3456));
		//소수점 첫째자리에서 반올림함 
		double value = 12.3456; //소수 3자리에서 반올림
		double temp1 = value * 100; //12.3456에 *100을 하면 1234.56이 된다.
		//소수점의 자리를 옮겨 반올림하고 다시 제자리로 돌려놓는다. 특정 자리에서 반올림은 불가능하므로 이런 방법 사용
		
		long temp2 = Math.round(temp1); //1234.56 반올림 -> 1235
		double v16 = temp2/100;
			//temp2/100 -> long/int -> 자바에서 기본 정수형은 100. 사용자가 정수를 입력하면 무조건 int
			//temp2에 100.0을 넣으면 long/double -> 기본 실수형은 double.
			//두 차이점 반드시 기억 ******
			//연산자는 자료형이 없지만 이런 계산은 자료형 필요?뭐라하셨지
		System.out.println("v16:"+v16);
		//round는 동일하면 소수 첫째짜리만 반올림하므로 12.3456에 100을 곱혀 1234.56으로 바꿔 올린다음 
			//원상복귀를 시키기 위해 다시 나누기 100을 한다.
		
		
		
		//536~537
		//난수. 주사위 1~6
		// int num = Math.random(); 를 double로 형변환을 위해
		// int num = (double)Math.random();
		System.out.println("0~1 사이의 실수형 : "+Math.random());
		System.out.println(Math.random()*6); //0~1 *6 = 0~6이 된다. 이렇게ㅐ 계산해서 만들어야함
		System.out.println(Math.random()*6 +1); //0~6에 1을 더해 1~7까지 값이 나온다.
		
		int num = (int)(Math.random()*6)+1; //강제 형변환
			//어떤 값 또는 변수 앞에 int double 등을 넣으면 데이터 손실이 있을 수 있으나 강제 형변환이 가능해진다.
			//큰 상자에서 작은 상자로 가므로 데이터손실.
			//double -> int 강제형변환시 -> 소수점 잘림
		System.out.println("1부터 6사이의 난수 : " + num);
			//1~6사이의 난수

		//클래스오 ㅏ비교. 더 편한 쪽 사용.(next가 형변환을 대신해준다.)
		
		Random random2 = new Random();         //괄호로 묶어야 연결
		System.out.println("1부터 6사이의 난수 : " + (random.nextInt(6)+1) ); //0부터 포함해서 5사이 이므로 1더하기
			//얘는 형변환이 필요없으므로 이게 더 쉬울 수도 있음
		
		
		
		
		
		
/////////////////////////////////////////////////		
	}	
}
