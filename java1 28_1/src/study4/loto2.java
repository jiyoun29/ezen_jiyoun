package study4;

import java.util.Random;
import java.util.Scanner;

public class loto2 {
	
	/* 로또 판별기
	1. 사용자 6개 수 입력받기 -> 배열 저장
		1. 1~45 사이 수만 입력받기 아니면 재입력	2. 중복x 재입력
	2. 추첨번호 : 컴퓨터 난수 6개 발생 -> 배열 저장
		1. 1~45사이	2. 중복x
	3. 사용자 번호와 컴퓨터 추첨번호와 동일수의 개수
	*/
	public static void main(String[] args) {
		
	int[] mynum = new int[6];
	int[] comnum = new int[6];
	Scanner scanner = new Scanner(System.in);

	//값 입력 받기
	for(int i =0; i<6; i++)	{
		System.out.println("1~45 사이 숫자를 입력해주세요 : ");
		int num = scanner.nextInt(); 
		
	boolean safe = true; //why
	
	if(num<1 || num>45){
	System.out.println("불가능한 번호입니다. 다시 입력해주세요.");
	i--; safe = false;}
	
	//내 숫자인 i와 같을 때
	for(int j=0; j<6; j++){
		if(num == mynum[i]){
			System.out.println("이미 입력된 숫자입니다. 다시 입력해주세요.");
			i--; }
		safe = false; }  //통과 실패
	
		mynum[i] = num; 
		
	} //for end

		System.out.println("\n 입력한 번호 : ");
			for(int temp : mynum) {
				System.out.println(temp+"\t");}
		// int temp는 내가 입력한 숫자이다. 이때 \t를 출력??
		
		//컴퓨터 수 입력
		
		for(int i=0; i<6; i++) {
	Random random = new Random();
		int num = random.nextInt(45)+1; //0~44+1번호 //왜?			
		
		//////????????
		boolean safe = true;
		for(int temp : comnum) {
	if(num == temp) { i--;
	safe = false;
		}
	}
		if(safe) comnum[i] = num; } //for end
		
		System.out.println("\n comnum : ");
	for(int temp : comnum) {
			System.out.println(temp + "\t");	}
	//비교하여 동일한 수를 찾음 기준점을 잡고 총 36번 비교
	
	int same = 0;

	for (int i = 0; i<comnum.length; i++)
	{
		for (int j = 0; j<comnum.length; j++) { //j 비교
		if(mynum[i] == comnum[j]) //둘이 같으면 동일한 수를 증가.
		{ same++;}
		
		}
	
	} //for end //14

	System.out.println("동일한 수의 개수 : "+same); 


	////////////////////////////////////////////////2
	}
}
