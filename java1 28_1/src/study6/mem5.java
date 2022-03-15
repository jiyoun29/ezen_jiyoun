package study6;

import java.util.Scanner;

public class mem5 {
	public static void main(String[] args) {

		// 회원제 방문록 프로그램
		// 1. 초기메뉴 [ 1. 회원가입 2.로그인 ]
			// 1. 회원가입 [ 아이디, 비번, 이름]
			// 2. 로그인 [ 아이디, 비번 동일하면 로그인 처리]
		// 2. 로그인 시 메뉴 [ 1. 방문록 쓰기 2.로그아웃]
			// 1. 방문록 쓰기 [ 제목, 내용, 작성자(로그인 아이디)]
			// 2. 로그아웃 [초기메뉴로 돌아가기]

//		int[][] 배열2 = new int[2][3]; 
//		//2차원 배열. 앞이 행, 뒤가 열. 4바이트 * 2 * 3 => 24바이트 배열
//		배열2[0][0] = 80; 배열2[0][1] = 90; 배열2[0][2] = 100;
//		배열2[1][0] = 40; 배열2[1][1] = 50; 배열2[1][2] = 60;

////////////////////////////////////////
	

		Scanner scanner = new Scanner(System.in);
		
		// 1. 배열을 생성한다.
		String[][] memlist = new String [10][3]; //행/열 /회원
		String[][] boardlist = new String [10][3]; //게시물


	//입장
	while(true) { System.out.println("=====회원제 방문록=====");
	System.out.println("1. 회원가입 2. 로그인"); int ch = scanner.nextInt();

	
	
		
		//2. 회원가입
		if(ch==1) {System.out.println("=====회원가입 페이지=====");
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.print("비밀번호 : "); String pw = scanner.next();
		System.out.print("이름 : "); String name = scanner.next();
		

		//중복체크
		boolean idcheck = true;
		
		//일치할경우
		for(int i = 0; i<memlist.length ; i++) {
			//멤버리스트에서 하나씩 대조
			if(memlist[i][0] != null && memlist[i][0].equals(id)) {
			//안내출력
				System.out.println("동일한 아이디가 존재합니다."); idcheck = false;
				break; } 
				}// for end
		
		//false 저장
		//wht idcheck?
		if (idcheck) {  for(int i = 0 ; i<memlist.length ; i++) {
			if(memlist[i][0] == null) {
				memlist[i][0] = id; memlist[i][1] = pw; memlist[i][2] = name;
				//배열이 비어있으면 집어넣는다.
				System.out.println("회원가입이 완료되었습니다."); break;}	
			} // for end
		} //if end	
	} //회원가입 if
		
		
		
		
		//3. 로그인
		
		else if (ch == 2) { System.out.println("=====로그인 페이지=====");
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.print("비밀번호 : "); String pw = scanner.next();	

		
		//확인
		boolean logincheck = false; //로그인 성공을 초기값으로 돌린다.
		
		
		for(int i = 0; i<memlist.length; i++) { 
			if (memlist[i][0].equals(id) && memlist[i][1].equals(pw) ) {
				System.out.println("로그인 성공"); logincheck = true;
				
				
			
			//로그인 성공 후
			while(true) {
				System.out.println("=====방문록 페이지=====");	
				System.out.println("번호\t작성자\t제목\t내용");
				
				//저장된 방문록 출력
			for( int j = 0 ; j<boardlist.length ; j++  ) {
			if( boardlist[j][0] != null ) { System.out.printf("%d\t%s\t%s\t%s \n" , 
					j , boardlist[j][2] , boardlist[j][0] , boardlist[j][1] ); }
			}
			
			
			System.out.print("1.방문록 남기기 2.로그아웃"); int ch2 = scanner.nextInt();

			
			if( ch2 == 1 ) { System.out.println("=====글쓰기 페이지=====");	
			System.out.print(" 제목 : "); 	String title = scanner.next();
			System.out.print(" 내용 : ");	String content = scanner.next();
			
			
			//저장
			for( int j = 0 ; j<boardlist.length ; j++ ) {
			if( boardlist[j][0] == null  ) { 
				boardlist[j][0] = title;
				boardlist[j][1] = content;
				boardlist[j][2] = id;
				
				System.out.println("방문록이 작성되었습니다.");break; }
						}
		} 
			else if( ch2 == 2 ) { System.out.println(" 로그아웃 되었습니다."); break; }
			
			
			
	else { System.err.println(" 알수 없는 번호입니다."); }
				
	} // while end 
} // if end
			
	} // for end 
		
		
		if( logincheck == false ) System.out.println(" 회원정보가 없거나 다릅니다."); }
		else { System.err.println(" 알수 없는 번호입니다."); }
		
		
	} //while end	
	
////////////////////////////////////////
	}//main end
}
