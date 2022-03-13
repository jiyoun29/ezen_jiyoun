package study4;

import java.util.Random;
import java.util.Scanner;

public class loto4 {
	
	/* 로또 판별기
	1. 사용자 6개 수 입력받기 -> 배열 저장
		1. 1~45 사이 수만 입력받기 아니면 재입력	2. 중복x 재입력
	2. 추첨번호 : 컴퓨터 난수 6개 발생 -> 배열 저장
		1. 1~45사이	2. 중복x
	3. 사용자 번호와 컴퓨터 추첨번호와 동일수의 개수
	*/

	public static void main(String[] args) {
	
		
	int[] mynum = new int[6]; int[] comnum = new int[6]; 
	Scanner scanner = new Scanner(System.in);

	for(int i=0; i<6; i++) {  System.out.println("1~45 사이의 수를 입력하세요 : ");
		int num = scanner.nextInt();
		
	boolean safe = true;

	if(num<1 || num>45) { System.out.println("불가능한 번호입니다. 다시 입력해주세요.");
		i--;
		safe = false;
	} //if end
	
	for(int j=0; j<6; j++) { if(num == mynum[j])
	{ System.out.println("이미 입력된 번호입니다. 다시 입력해주세요."); i--;}
	safe = false; }
	mynum[i] = num; } //for end
	
	System.out.println("\n 입력한 번호 : ");
	for(int temp : mynum) {
		System.out.println(temp + "\t");
		}
	
	for(int i =0; i<6; i++) {Random random = new Random();
	int num = random.nextInt(45)+1; 
	
	boolean safe = true;
	
	for(int temp : comnum) {
		if(num == temp) {
			i--; safe = false;} 
		}
		
		if(safe) comnum[i] = num;}
		System.out.println("\n comnum : ");
	
	for(int temp : comnum) {System.out.println(temp + "\t");}

	int same = 0; 
	for (int i = 0; i<comnum.length; i++){
		for (int j = 0; j<comnum.length; j++) { 
			if(mynum[i] == comnum[j]) 
			{same++;} }
		} //for end
		System.out.println("동일한 수의 개수 : "+same);

		
	} // me

}
