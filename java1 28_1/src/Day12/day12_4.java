package Day12;

import java.util.Random;
import java.util.Scanner;

import javax.swing.event.CaretListener;

public class day12_4 {
	
	//차량번호 구분 프로그램
	//조건
		//난수 0000-9999 사이의 난수 10개 생성해서 배열에 저장
		//모든 차량 번호를 배열에 저장
		//끝자리 번호로 홀/짝 구분
		//차량 끝자리 번호가 홀수 차량 출력
		//차량 끝자리 번호가 짝수 차량 출력
		//홀수차량 배열 출력 //짝수차량 배열 출력
public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	String[] carlist = new String[10]; //문자열 10개 저장할 수 있는 배열(최대 10개)
	String[] evenlist = new String[10]; //짝수차량
	String[] oddlist = new String[10]; //홀수차량
	
//	for(String temp : carlist) {
//		if( temp != null) System.out.println(temp);
//	}//만일 템프가 널이 아니면 차량번호 저장
//	
//	
	
	
	while(true) {
		System.out.println("\n 주차중인 모든 차량 번호");
		for(String temp : carlist) {
			//템프가 비어있지 않으면 열에 추가
			if(temp != null) {
				
				if(Integer.parseInt(temp)%2 == 0) {
					// 수%2==0 나머지가 0이면 짝수
						System.out.println(temp+"[짝]");			
						
				} else {System.out.println(temp+"[홀]");}
			} //위에 배열 추가
		} // for end	
		//문자는 나누기가 안 되므로 숫자로 바꾼 후 나눈다,
	
			
		
		
		

		/////////////////////////////////////////////////////////////////
		
		
		
		
		// 홀수차량 번호 출력 
		System.out.println(" \n 주차중인 모든 홀수 차량 [ 차량 2부제 ]");
			for( String temp : oddlist  ) {
				if( temp != null ) { System.out.print( temp+" " ); }
				}
					
		// 짝수차량 번호 출력 
		System.out.println(" \n 주차중인 모든 짝수 차량 [ 차량 2부제 ]");
			for( String temp : evenlist  ) {
				if( temp != null ) { System.out.print( temp+" " ); }
				}
		
			
			
			
	///////////////////////////////////////////////////////	
		System.out.println("1.차량 입차"); int ch = scanner.nextInt();
			if(ch==1) { //차량번호 난수생성
				Random random = new Random(); //랜덤겍채
				int intnum = random.nextInt(10000); //0~9999난수 발생
			String 차량넘버 = String.format("%04d", intnum);
			// %d: 정수, %f: 실수 , %s : 문자열, %c :문자
			// %숫자d:숫자만큼 자릿수[만일 해당 자릿수가 없으면 공백]
			// %0숫자d: 숫자만큼 자릿수[만일 해당 자릿수가 없으면 0]
			//이결 배열에 저장
		
			//배열내 공백을 찾아 차량번호 저장
			boolean save = false;
			for( int i = 0 ; i<carlist.length ; i++ ) {
				if( carlist[i] == null ) { carlist[i] = 차량넘버; save=true; break; }
			}
			
			if( save == true ) {
				// 짝수홀수 차량 분배 
				if( Integer.parseInt(차량넘버) % 2 == 0 ) { // 수%2==0 나머지가 0이면 짝수 
					// 짝수차량배열에 저장 
					for( int i = 0 ; i<evenlist.length ; i++) {
						if( evenlist[i] == null ) { evenlist[i] = 차량넘버; break; }
					}
				}else {		// 수%2 == 1 나머지가 1이면 홀수 
					for( int i = 0 ; i<oddlist.length ; i++) {
						if( oddlist[i] == null ) { oddlist[i] = 차량넘버; break; }
					}
				}
			}
			
			// 만약에 빈공간이 없으면 만차 
			if( save == false )System.err.println(" 만차 [ 주차 불가 ] ");
		}
	}
	
	//난수 0000-9999 사이의 난수 10개 생성해서 배열에 저장
			//모든 차량 번호를 배열에 저장
	
	
	
	

////////////////////////////////////////////////////	
	}	
	
}
