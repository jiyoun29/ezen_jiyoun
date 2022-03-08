package Day06;

public class Day06_5 {
	public static void main(String[] args) {
		
		//p.207
		
		// 1. 빈 생성자로 객체 생성(생성자 없이 필드에 값 넣기)
		Korean k1 = new Korean();
			// 2. 객체 생성 후에 필드 값 변경
			k1.name = "유재석";
			k1.ssn = "12345678-12345678";
			System.out.println("k1 국적 : " + k1.nation);
			System.out.println("k1 이름 : " + k1.name);
			System.out.println("k1 주민등록번호 : " + k1.ssn);
			//생성자는 필수가 아니라 빈 생성자도 큰 차이가 없다.

			
		// 2. 필드 2개를 갖는 생성자로 객체 생성
		Korean k2 = new Korean("박자바", "12345678-23456789");
		System.out.println("k2 국적 : " + k2.nation);
		System.out.println("k2 이름 : " + k2.name);
		System.out.println("k2 주민등록번호 : " + k2.ssn);
		
		//생성자를 통해서 가는 게 안전하고 보안이 좋음
		///////////////////////////////////////////////
		// 1. 빈 생성자 객체
		Korean 한국인1 = new Korean(); //빈 생성자 1번 따라감
			// 1. 한국인1 국적이 대한민국이고 이름, 주민번호 없음
		
		// 2. 필드 1개 생성자 객체 생성
		Korean 한국인2 = new Korean("유재석");		
			// 한국인2 국적이 대한민국이고 이름 유재석, 주민번호 없음
		
		// 3. 필드 2개 생성자 객체 생성
		Korean 한국인3 = new Korean("강호동", "12345678-12345678");
			// 한국인3 국적 대한민국, 이름 강호동, 민증 있음
		
		//4. 필드 3개 생성자 객체 생성
		Korean 한국인4 = new Korean("일본","신동엽","12345678-12345678");
			//한국인4 국적 일본, 이름 신동엽, 민증 있음
		
		
	}
}
