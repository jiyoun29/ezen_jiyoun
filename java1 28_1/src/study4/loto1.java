package study4;

import java.util.Random;
import java.util.Scanner;

public class loto1 {
	/* 로또 판별기
	1. 사용자 6개 수 입력받기 -> 배열 저장
		1. 1~45 사이 수만 입력받기 아니면 재입력	2. 중복x 재입력
	2. 추첨번호 : 컴퓨터 난수 6개 발생 -> 배열 저장
		1. 1~45사이	2. 중복x
	3. 사용자 번호와 컴퓨터 추첨번호와 동일수의 개수
	*/

	public static void main(String[] args) {
		
	int[] mynum = new int[6]; int[] comnum = new int[6]; //각자의 수열 받기

	Scanner scanner = new Scanner(System.in);

	for(int i=0; i<6; i++) { //i는 0이며 6보다 작고 1씩 증가한다.
		//입력 받기
		System.out.println("1~45 사이의 수를 입력하세요 : "); int num = scanner.nextInt();
		
	boolean safe = true; //통과는 참이다.
	
	//입력받은 번호가 0보다 작거나 46을 넘으면 초기화한다.
	if(num<1 || num>45) { //i를 초기화하고 통과를 거짓으로 변경한다.
		System.out.println("불가능한 번호입니다. 다시 입력해주세요."); i--; safe = false;
	} //if end
	
	for(int j=0; j<6; j++) { //입력한 숫자가 내 숫자와 같을 시
		if(num == mynum[j]) { System.out.println("이미 입력된 번호입니다. 다시 입력해주세요."); i--;}
	safe = false; }
	
	//중복도 아니고 올바른 번호를 입력하면 배열에 저장한다.	
	mynum[i] = num; } //for end
	
	
	System.out.println("\n 입력한 번호 : ");
	for(int temp : mynum) {System.out.println(temp + "\t");}
	
	
	
	
	for(int i =0; i<6; i++) {Random random = new Random();
	//컴퓨터의 수는 랜덤으로
	int num = random.nextInt(45)+1; //0~44에 +1

	//중복을 체크한다. 통과가 참일때
	boolean safe = true;
		for(int temp : comnum) { if(num == temp) {
			i--; safe = false;} }
		
		if(safe) comnum[i] = num;}
		
		System.out.println("\n comnum : ");
	
	for(int temp : comnum) {System.out.println(temp + "\t");}
	//비교하여 두 배열간 동일한 수를 찾는다. 6개 숫자를 전부 비교하고 모든 인뎃그와 비교해야하므로 기준점을 잡고 하나씩 비교. 6 6 비교니까 총 36번 비교된다.
		
	int same = 0; //같은 수는 0이다.
		for (int i = 0; i<comnum.length; i++) //length로 길이를 재고 1씩 증가시킨다.
		{for (int j = 0; j<comnum.length; j++) { //j 비교
			if(mynum[i] == comnum[j]) //둘이 같으면 동일한 수를 증가.
			{same++;} }
		} //for end
		System.out.println("동일한 수의 개수 : "+same);


		
////////////////////////////////////////////////////
	}	
}
