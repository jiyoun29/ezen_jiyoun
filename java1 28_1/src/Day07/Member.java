package Day07;

public class Member {
	// 멤버 클래스
	
	//1. 필드
		// 일단 필드 먼저 정한다.
	int mno;	// 회원번호 [ 자동번호, 중복x ]
	String id;	// 아이디 [ 중복x ]
	String pw;	// 비밀번호
	String name; // 이름
	String phone; // 연락처
	
 
	//2. 생성자
		// 클래스명과 생성자명은 동일
		// 1. 빈생성자[ 기본생성자 ]
	public Member() {}
		// 2. 모든 필드를 받는 생성자
	//마우스 우클릭->소스->아래서3번째 필드 눌러서 원하는 것 넣기
	// 회원가입용 객체 생성시
	public Member(int mno, String id, String pw, String name, String phone) {
		super();
		this.mno = mno;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}

	
	//3. 메소드
		// 회원가입 [인수x반환o]
	boolean 회원가입() { // 횐갑 성공 true 실패 false
		System.out.println("--------------회원가입 페이지--------------");
		//1. id pw name phone 입력 받는다.(4개) = 매개변수 입력받기
		System.out.print(" MEMBER ID : "); String id = Day07_5_BookApplication.scanner.next();
		System.out.print(" MEMBER PASSWORD : "); String pw = Day07_5_BookApplication.scanner.next();
		System.out.print(" MEMBER NAME : "); String name = Day07_5_BookApplication.scanner.next();
		System.out.print(" MEMBER PHONE : "); String phone = Day07_5_BookApplication.scanner.next();
			// scanner 객체를 이용하고 싶다! 그런데 다른 클래스내 static으로 선언되어 있다.
			//application에 static이 있는데 이건 패키지가 달라도 불러올 수 있다. 굳이 새로 만들 필요x
			// static = 모든 객체에서 사용 가능.
			//사용법: 클래스명.필드명 ( Day07_5_BookApplication.scanner.next(); )

		
		// 아이디 중복체크
		//왜 :인가?
		for (Member temp : Day07_5_BookApplication.members) {
			if(temp != null && temp.id.equals(id)) {
				//만일 공백이 아니면서 배열 내 id와 입력받은 id가 동일하다면
				System.out.println("알림) 현재 사용 중인 아이디입니다.");
				return false; //함수 종료 --> 아이디가 중복되었기 때문에 가입실패(false)
			}
		} //boolean =idcheck 사용하지 않아도 괜찮음
		
		//////////// 회원번호 자동주입 [ 가장 최근에 가입한 회원(마지막 회원)의 번호 +1]
		int bno = 0; //회원번호 저장하는 변수
		int j = 0; //반복횟수 = 인덱스
	
		for(Member temp : Day07_5_BookApplication.members) { 
			
			//1. null을 찾는다.
			//null을 찾았ㅇ르 때 null-1이 마지막 회원이 된다.
			if (temp == null) //인덱스 위치를 찾기 위해 int를 위에 추가
			{  	//j가 0일때 1을 깎으면 -1이 되므로 첫회원은? 자동으로 첫번호를 주어야함..
				//첫회원이라는 걸 알 수 있는 방법은?
				
				if(j==0) {bno=1; break;} //이해해야함..
				//첫번째 인덱스가 null이라는 건 첫번째 회원이라는 뜻으로, 첫회원번호는 1로 시작
				// 첫번째 회원 넣고 끝내므로 break
				
				else { //첫회원이 아니면 아래
			//이후 찾는법	
				bno = Day07_5_BookApplication.members[j-1].mno +1 ;
			//null(마지막 회원)을 찾고 1을 더한다. 				//j(null)번째에 -1을 한다.
			break; }	//return은 하지 않음!!!
				
			} j++;  //만일 temp가 0이면 증가시킨다.
		}
		
		//2. 4개변수 -> 객체화 -> 1개
		Member member = new Member(bno, id, pw, name, phone);
			// 알아서 위의 < public Member(int mno, String id, String pw, String name, String phone) >
			// 를 받아온다. 받아서 내부 변수에 저장한다.
		int i = 0; // 반복 횟수 [인덱스 체크]
		
		for (Member temp : Day07_5_BookApplication.members ) {
			
			if (temp == null) { //빈공간 찾기
				// 빈 공간이면 빈 인덱스에 새로운 회원 대입(아래 코드)
				Day07_5_BookApplication.members[i] = member;
				//서로 다른 클래스에서 호출을 하기 위해 어저고저저고 긴 코드 붙이는 것.
				System.out.println(" 알림)) 회원님의 회원번호 : " + bno);
				return true; // 회원가입 메소드 종료 ------------ 반환값 true(성공을 알림)
				
			} i++; // i 증가
		}
		//4. 성공 true 실패 false
		return false; // 회원가입 실패 ---------------반환값 false
		
		//3. 배열내 빈 공간을 찾아 새로운 회원[객체] 추가
	}
	
 ///////////////////////////////////////////////////
	// 로그인 [인수x반환o]
	String 로그인() { // 성공은 true 실패는 false. 성공한 아이디 반환. / 실패시 null 반환
		//성공한 아이디를 반환시켜 일반회원인지 admin인지 볼 것
		System.out.println("--------------로그인 페이지--------------");
		System.out.print(" MEMBER ID : "); String id = Day07_5_BookApplication.scanner.next();
		System.out.print(" MEMBER PASSWORD : "); String pw = Day07_5_BookApplication.scanner.next();
		//scanner을 또 만들지 않고 가지고 온다.
		//입력받은 2개를 회원가입시 입력한 정보와 동일하면 반복문for 돌린다.
		for (Member temp : Day07_5_BookApplication.members) {

			// null이 아니면(!=)을 꼭 넣어야함 ***
			if( temp != null && temp.id.equals(id) && temp.pw.equals(pw)) {
				//공백이 아니면서 id와 pw가 동일하도록.
				return temp.id; } //로그인 성공했다는 기록 남기기
		} // for end

		// 로그인 성공시 입력한 id 반환, 실패시 null
		return null; //실패시 null 반환
	}
	
		// 아이디 찾기 [인수x반환x]
	void 아이디찾기() {
		System.out.println("--------------아이디 찾기 페이지--------------");
		// 1. 입력 받기 : 이름과 연락처를 받는다.
		System.out.print(" MEMBER NAME : "); String name = Day07_5_BookApplication.scanner.next();
		System.out.print(" MEMBER PHONE : "); String phone = Day07_5_BookApplication.scanner.next();
		// 입력 받은 다음 동일한 입력이 있는지 확인한다(로그인과 유사) : 입력 받은 값을 배열에서 찾는다.
		for(Member temp : Day07_5_BookApplication.members) {
			if(temp != null && temp.name.equals(name) && temp.phone.equals(phone)) {
				// 공백이 아니면서 해당 객체 내 name, phone이 입력받은 값과 동일하면
			 System.out.println("알림) 회원님의 아이디는 : " + temp.id + "입니다."); //찾은 id 안내
			 return; // 동일한 값을 찾았으면 해당 메소드 종료
			}
		}
		// 찾지 못하였으면 없음 출력
		System.out.println("알림) 동일한 회원 정보가 없습니다.");	
	}
	
		// 비번 찾기 [인수x반환x]
	void 비밀번호찾기() {
		System.out.println("--------------비밀번호 찾기 페이지--------------");
		
		for(Member temp : Day07_5_BookApplication.members) {
			System.out.print(" MEMBER ID : "); String id = Day07_5_BookApplication.scanner.next();
			System.out.print(" MEMBER PHONE : "); String phone = Day07_5_BookApplication.scanner.next();
			if(temp != null && temp.id.equals(id) && temp.phone.equals(phone)) {
 // 위와 동일하게 진행
			for(Member temp1 : Day07_5_BookApplication.members) {
				if(temp1 != null && temp1.name.equals(id) && temp1.phone.equals(phone)) {
				 System.out.println("알림) 회원님의 비밀번호는 : " + temp1.pw + "입니다.");
				 return; // 동일한 값을 찾았으면 해당 메소드 종료
				}
			}
		System.out.println("알림) 동일한 회원 정보가 없습니다.");	
			}
		}
	}
	
		// 탈퇴
	
	
	
		// 회원 수정(시간되면)
	
	
	
}
