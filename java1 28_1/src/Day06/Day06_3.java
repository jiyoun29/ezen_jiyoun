package Day06;

import java.util.Scanner;

public class Day06_3 {
	// 회원제 프로그램 [클래스]
	
		// 0. 회원 설계 -> 회원 클래스 만들기
			// 1. 필드 (나중에 생성자, 메소드도 추가하게 될 것..배우면. 그럼 더  편해짐)
				// 필드는 네이버 참고 (객체에 저장할 데이터)
				// 1. 아이디 2. 비밀번호 3. 이름 4. 전화번호
		// 1. 초기메뉴 [1. 회원가입 2. 로그인 3.아이디찾기 4.비밀번호 츶가]
			// 1. 회원가입시  입력 받아 저장 -> 아이디, 비밀번호
			// 2. 로그인시 아이디와 비밀번호가 동일하면 로그인 처리
			// 3. 아이디 찾기는 이름과 전화번호가 동일하면 아이디 출력
			// 4. 비밀번호 찾기는 아이디와 전화번호가 동일하면 출력
	
	public static void main(String[] args) {
	
		// 위에 선언하는 이유 : main메소드를 모든 곳에서 사용하기 위해서.
						// 지역 변수는 {}를 나가면 소멸된다.
		
			Scanner scanner = new Scanner(System.in);
			Member[] memberlist = new Member[100];	// 1차원 배열
			// 만약에 클래스가 없을 경우에는**String[][] memberlist = new Member[100][4]로 2차원 배열을 사용한다.
			// 현재 객체로 묶였기 때문에 2차 배열 사용하지 않아도 된다.
			// Member 클래스로 만들어진 객체(4개) 100개를 저장할 수 있는 배열을 표현한 것. =총 400개
			
		while(true) { //프로그램 실행 while start

			System.out.println("-----------------회원제[클래스]-----------------");
			System.out.println("1.회원가입 2.로그인 3.아이디 찾기 4.비밀번호 찾기");
			System.out.println(" 선택 : "); int ch = scanner.nextInt();
			
			//클래스에 메모리 할당할때 반드시 new 
			
			if(ch == 1) { // 회원가입
				// 1. id, pw, name, phone 입력 받기 -> 변수 4개
				System.out.println("---------------회원가입 페이지---------------");
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("비밀번호 : "); String pw = scanner.next();
				System.out.println("이름 : "); String name = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
			
				// 2. 따로따로 묶는게 아니라 클래스, 객체에게 저장.
				Member member = new Member();
				// member 클래스의 멤버를 만들고 뉴 멤버를 하나 더 만든다.
				// 회원 1명당 member 하나. 여러개 만들기 때문에 위에 배열을 생성한다.
				
				// 3. 입력 받은 변수 4개를 객체 내 필드에 저장하기
				member.id = id; //입력 받은 걸 집어넣는다.
				// 객체 내 필드 = 입력 받은 값을 넣어준다. 차곡차곡~
				member.pw = pw; member.name = name;	member.phone = phone;
				
				// * 아이디 중복체크
					// 1.배열 내 객체 중 입력한 아이디와 동일한 아이디 찾기
				boolean idcheck = false; //일종의 스위치버튼
				for(Member temp : memberlist) {
					//모든 객체를 하나씩 꺼내와 비교. 내가 입력한 아이디equals 같으면 중복
					// memberlist 배열 내 객체들을 하나씩 temp에 대입 반복
					if (temp != null && temp.id.equals(id)) {
						//temp가 null이 아닐때,
						//만일 해당 객체 내 아이디가 입력 받은 아이디와 같으면
						System.err.println("알림) 사용 중인 아이디입니다."); //송출
						idcheck = true;
						break; 
					}
				}
				
				// 아이디가 중복이 없을 경우 저장 (중복 있다 없다만 넣는것이므로 boolean.
				// 중복이 안 걸리면 false 중복이면 true)
				if (idcheck = false); {
					//중복이 없을 경우에 송출
					
				// 4. 여러개 객체를 저장하는 배열에 저장 (반복)
					// 1. 무작정 저장하지 말고 공백 인덱스를 찾아서 공백 인덱스에 객체 저장
					// 그렇지 않으면 덮어씌우기가 되어 기존 입력값이 사라지므로 반드시 공백 찾을것
				int i= 0; //인덱스 위치 변수;
				for( Member temp : memberlist ) { //temp이름은 아무거나. for문의 활용
					//memberlist 배열 내 member 객체 하나씩 꺼내와서 temp에 저장 반복
					if (temp == null) { //만일 temp가 null이면 해당 인덱스에 새로 만들어진 객체를 저장한다.
						memberlist[i] = member; 
						System.out.println("알림) 회원가입 성공");
						break; //for문 나가기. 나가지 않으면 모든 공백에 동일한 객체가 저장됨
				} i++; //인덱스 증가			
			} // for문 끝
		} //아이디 체크
		} // ch1 if 끝, 회원가입 end
			
			
			else if(ch == 2) {// 로그인
				// 1. 입력 받기
				System.out.println("----------------로그인 페이지----------------");
				System.out.println("아이디 : "); String loginid = scanner.next();
				System.out.println("비밀번호 : "); String loginpw = scanner.next();
				// memberlist 안에 입력 받아서 저장한 Member 객체 안 어디에 있는지를 찾아야함
				// 하나씩 비교, 즉 equals
				
				// 2. 기존 배열 [회원리스트]내 입력 받은 값과 비교
				boolean loginchek = false; // ture:로그인 성공 false:로그인 실패로 반복할 목적
				//로그인 했는지 안 했는지 반드시 기록을 남겨야한다. 로긴 체크를 만들어서 실패 만들어놓고 성공란에 true로 성공표시 남기기
				for(Member temp : memberlist) {
					// memberlist 내 0번 인덱스부터 끝 인덱스까지 하나씩 temp에 대입
					// temp가 null이 아닌 경우 추가. null이 아닐 때만 equals를 한다는 코드
					if( temp != null && temp.id.equals(loginid) && temp.pw.equals(loginpw)) {
						System.out.println("알림) 로그인 성공"); loginchek = true; } //로그인 성공했다는 기록 남기기
				} // for end
				
				//3. 로그인 성공 유무
				if (loginchek == false) {System.out.println("알림)동일한 회원정보가 없습니다.");	}
				// 위의 boolean이 여기로 도착. true일 경우 지나감				
			} //로그인 end
			
			
			else if(ch == 3) {// 아이디 찾기
					// 1. 이름과 연락처를 입력 받는다.
				System.out.println("----------아이디 찾기----------");
				System.out.println("이름 : "); String name = scanner.next();
				System.out.println("연락처 : "); String phone = scanner.next();
				
					// 2. 배열내 동일한 이름과 연락처가 있는지 확인한다. (로그인과 유사)
				boolean findcheck = false;
				for(Member temp : memberlist) { //Member 자리에는 배열의 자유형이 들어가야한다. string=x
					// temp가 공백이 아니면서 -
					if(temp != null && temp.name.equals(name) && temp.phone.equals(phone)) ;				
					// 3. 동일한 객체가 있으면 해당 아이디 출력
					{ System.err.println("알림) 아이디 찾기 성공");
					System.out.println("회원 ID : " + temp.id);
					findcheck = true;
					break;
					}//if end
				} // for end
				
				// 아이디 찾기 성공, 실패를 저장을 위해서 boolean
				
					// 4. 없으면 없다고 출력
				if ( findcheck == false ) {
					System.err.println("알림) 동일한 회원 정보가 없습니다. ");
				}
			}
			
			
			else if(ch == 4) {// 비밀번호 찾기
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
				boolean findcheck = false;
				for ( Member temp : memberlist) {
					if(temp != null && temp.equals(id) && temp.equals(phone)) {
						System.out.println("알림) 비밀번호 찾기 성공");
						System.out.println("회원 비밀번호 : " + temp.pw);
						findcheck = true; // 찾았으면 true 변경. 찾았다는 기록
						break;
					}
				}
				if (findcheck = false) {
					System.out.println("알림) 동일한 회원 정보가 없습니다.");
				}
			} // ch4 else if end
			else { System.err.println("알 수 없는 번호입니다.");} 	
		} //프로그램 실행 while end
		
		
		
	/////////////////////////////////////////////////////////////
	} // me	

} // ce
