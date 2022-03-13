package study4;

import java.util.Random;
import java.util.Scanner;

/* 로또 판별기
1. 사용자 6개 수 입력받기 -> 배열 저장
	1. 1~45 사이 수만 입력받기 아니면 재입력	2. 중복x 재입력
2. 추첨번호 : 컴퓨터 난수 6개 발생 -> 배열 저장
	1. 1~45사이	2. 중복x
3. 사용자 번호와 컴퓨터 추첨번호와 동일수의 개수
*/

public class loto5 {
public static void main(String[] args) {

	// 배열 만들기
	int[] mynumber = new int[6]; int[] comnumber = new int[6];
	//입력 받기 위한 스캐너 생성
	Scanner scanner = new Scanner(System.in);
	
	//입력 받기
	for(int i = 0; i<6; i++) { //0~5까지 6개
		System.out.println("1~45 사이 입력 : ");
		int number = scanner.nextInt();		
	//참 혹은 거짓 (why?)
		boolean safe = true;
		
	//1~45 사이의 수
	if(number < 1 || number > 45) { //만일 입력 받은 번호가 0보다 작거나 46을 넘으면선택 초기화. int i=1
		System.err.println("알림) 불가능한 번호입니다. 다시 입력해주세요."); i--; safe = false;
		//i를 제외하고 통과를 false로 바꿔 저장하지 않는다.
		} //if end
		
	// 중복 체크
	// 배열 내 인덱스를 모두 호출하여 입력받은 값과 같은지 비교
		
		for(int j = 0; j<6; j++) { //j가 5까지 1씩 증가하며 하나씩 비교된다.
			if(number == mynumber[j]) { //내가 쓴 번호가 배열 안에 입력된 번호와 같은가?
				//같을시
				System.err.println("알림) 이미 입력된 번호입니다. 다시 입력해주세요."); i--; }
			safe = false; } //저장하지 않고 넘어간다.
	//중복없는 1~45 사이의 수를 입력하였으면 저장한다.
		mynumber[i] = number; } //for end
	
	System.out.println("\n 입력한 번호 : "); //입력한 변호를 보여준ㄷ,
	//temp가 내가 입력한 번호일때
	for(int temp : mynumber) { System.out.println(temp + "\t");}

	//컴퓨터 값 입력(랜덤으로)
	for(int i = 0; i<6 ; i++) { Random random = new Random(); //랜덤으로 진행하도록 랜덤 코드를 넣고
		int number = random.nextInt(45)+1; //0~44+1의 숫자를 랜덤으로 6개 가져오게 한다.
	
	//참거짓 판별
		boolean safe = true;
		for(int temp : comnumber) { if (number == temp) {
			//temp가 컴퓨터의 숫자이고 만일 입력된 숫자가 그것과 같을때
			i--; safe = false;  } }
		
		if(safe) comnumber[i] = number; } //중복이 있을 경우 저장x
	System.out.println("\n comnumber : "); //컴퓨터의 숫자를 나타낸다.
		for(int temp : comnumber) { System.out.println(temp + "\t"); }
	// 기준점을 잡고 총 36번 비교

		int same = 0;
		//같은 숫자를 0으로 초기화 지정해준다.
	for(int i = 0; i<mynumber.length; i++) { //length로 몇 번 돌지.
		//i1이 0일때 내 숫자와 하나씩 늘려가며 비교한다.
		for (int j = 0; j<comnumber.length; j++) { if(mynumber[i] == comnumber[j])
			//둘이 같으면 동일한 수를 증가시킨다.
			{same++;}
		}
	} // for end
	System.out.println("동일한 수의 개수 : "+ same);
	//동일한 숫자를 나타내고 종료한다.


//			 * for (int 기준수 : 사용자번호) { //사용자번호 배열내 하나씩 비교기준 대입
//			 * for (int 비교대상 : 추첨번호) { //추첨번호 배열내 하나씩 비교대상 대입
//			 * if (기준수 == 비교대상) 동일한수++ ;
//			 * } }
//			 * 둘이 같으면 동일한 수가 더 올라간다.
//			 * 사용자가 선택한 번호를 하나씩 꺼내와서 한 번 더 돌기 전에 추첨번호도 꺼내와서 비교.
//			 * 사용자 번호가 1번 돌 때 추첨번호는 6번 돈다.

	///////////////////////////////////////
	} // me
}
