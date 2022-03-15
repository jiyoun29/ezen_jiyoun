package study6;

import java.util.Scanner;

public class mem3 {
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
		
	String[][] memlist = new String [10][3]; //회원
	String[][] boardlist = new String [10][3]; //게시물
		

	//1.초기
	while(true) { System.out.println("=====회원제 방문록=====");
	System.out.println("1. 회원가입 2. 로그인"); int ch = scanner.nextInt();
		
	
	
	//2. 회원가입
		
	if(ch==1) { //1.회원가입을 선택하였을 경우
			System.out.println("=====회원가입 페이지=====");
			System.out.print("아이디 : "); String id = scanner.next();
			System.out.print("비밀번호 : "); String pw = scanner.next();
			System.out.print("이름 : "); String name = scanner.next();
			//입력받은다음 멤버리스트에 저장한다.
		
			//아이디 중복체크
		boolean idcheck = true; //체크 여부가 동일할때
		    for(int i = 0; i<memlist.length ; i++) {
			if(memlist[i][0] != null && memlist[i][0].equals(id)) {
				System.out.println("동일한 아이디가 존재합니다."); idcheck = false;
				break; }  //멈추고 빠져나감
				} // for end
		
		   //체크 여부가 같지 않을때(같은 아이디 없음)
		if (idcheck) { for(int i = 0 ; i<memlist.length ; i++) { 
		if(memlist[i][0] == null) { //비어있는 배열을 찾아 넣는다.
		memlist[i][0] = id; memlist[i][1] = pw; memlist[i][2] = name;
		System.out.println("회원가입이 완료되었습니다."); break; }	// 멈추고 빠져나간다.
		} // for end
	} //if end	
		
}// ch1 end
	
	
	
	//3. 로그인
	else if (ch == 2) {
		System.out.println("=====로그인 페이지=====");
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.print("비밀번호 : "); String pw = scanner.next();	
		
		//멤버리스틍 ㅔ일치하는 게 있는지.
		boolean logincheck = false; //로그인 성공을 초기값으로
		
		for(int i = 0; i<memlist.length; i++) { 
			if (memlist[i][0].equals(id) && memlist[i][1].equals(pw) ) { //각각 비교
				System.out.println("로그인 성공"); logincheck = true;

				
				
			//로그인 성공
		while(true) { System.out.println("=====방문록 페이지=====");	
					  System.out.println("번호\t작성자\t제목\t내용");
			
		for( int j = 0 ; j<boardlist.length ; j++  ) {
		if( boardlist[j][0] != null ) { System.out.printf("%d\t%s\t%s\t%s \n" , 
				j , boardlist[j][2] , boardlist[j][0] , boardlist[j][1] ); }
		}//for end
		//저장된 방문록 송출 후 선택
		
		System.out.print("1.방문록 남기기 2.로그아웃"); int ch2 = scanner.nextInt();
		
		if( ch2 == 1 ) { System.out.println("=====글쓰기 페이지=====");	
		System.out.print(" 제목 : "); 	String title = scanner.next();
		System.out.print(" 내용 : ");	String content = scanner.next();
		
		
		
		for( int j = 0 ; j<boardlist.length ; j++ ) {
			
			if( boardlist[j][0] == null  ) { 
				boardlist[j][0] = title;
				boardlist[j][1] = content;
				boardlist[j][2] = id;
				System.out.println("방문록이 작성되었습니다.");break; }
					} //저장
	}
		
		
		else if( ch2 == 2 ) { System.out.println(" 로그아웃 되었습니다."); break; }
	else { System.err.println(" 알수 없는 번호입니다."); }
				
	} // while end 
			
			} // if end = login end  
		} // for end 
		if( logincheck == false )
			System.out.println(" 회원정보가 없거나 다릅니다.");
		
	} // 
	else { System.err.println(" 알수 없는 번호입니다."); }
		
		
	} //while end	
	
////////////////////////////////////////
	}//main end
}
