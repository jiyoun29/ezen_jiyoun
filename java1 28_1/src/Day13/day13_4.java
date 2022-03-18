package Day13;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class day13_4 {
	public static void main(String[] args) throws InterruptedException {
		
		//544
		// DecimalFormat 클래스 : 숫자 데이터를 원하는 형식으로 표현
		double num = 1234567.89;
		
		DecimalFormat df = new DecimalFormat("0");
				//패턴 : 0이면 자릿수를 4개[빈자리면 0으로 채움]
					// #이면 자릿수를 표현[빈자리면 채우기 안하고 공백으로 둠]
		System.out.println(df.format(num)); //소수점 날아감
		
		
		df = new DecimalFormat("0.00"); //0은 자릿수를 의미하고 숫자가 없으면 0으로 채운다.
		System.out.println(df.format(num));
		

		df = new DecimalFormat("000000000.000000000000"); //0은 자릿수를 의미
		System.out.println(df.format(num));
		
		
		df = new DecimalFormat("#"); //#은 빈자리를 공백으로 둔다.
		System.out.println(df.format(num));

		
		df = new DecimalFormat("#.#");
		System.out.println(df.format(num));


		//#은 데이터가 있어야만 표시
		df = new DecimalFormat("#####.########");
		System.out.println(df.format(num));

		
		df = new DecimalFormat("#.0");
		System.out.println(df.format(num));
		
		
		df = new DecimalFormat("+#.0");
		System.out.println(df.format(num));

		
		df = new DecimalFormat("-#.#");
		System.out.println(df.format(num));
		
		//다 문자. text 형식으로 바뀐다.
		
		
		//천단위 구분 쉼표 (셋이 다르다) ***제일 중요. 나머지는 필요에 따라...
		//만약에 금액이 0원이면
		df = new DecimalFormat("#,##0원"); //0원
		System.out.println(df.format(0));
		
		df = new DecimalFormat("#,###원"); //0원
		System.out.println(df.format(0));
		
		df = new DecimalFormat("0,000원"); //0,000원
		System.out.println(df.format(0));

		
		df = new DecimalFormat("0.0E0"); //E : 지수문자
		System.out.println(df.format(num));
		
		
		df = new DecimalFormat("[양]+#,### ;[음]-#,###"); //양수 ; 음수
		System.out.println(df.format(num)); //세미클론 기준으로 양수 음수 표현/구분 가능
		
		
		
		// ********* % : 컴퓨터는 백분율을 모르기 때문에 일반적으로 계산시 1:100%고 0.5가 50%, 0.05가 5%이니 이렇게 취급한다.
		//계산할때 % 넣지말기 컴퓨터는 모름...소수점으로 계산해서 넣기 (double 변수 = 10 * 0.3
		
		
		df = new DecimalFormat("#,###%"); //천단위 쉼표
		System.out.println(df.format(num));

		
		df = new DecimalFormat("\u00A4 #,###");
		System.out.println(df.format(num));

		
		
		/////////////547
		// MessageFormat 클래스
		
			/* DecimalFormat : 숫자 형식 변환
				SimpleDateFormat : 날짜 형식 변환
				MessageFormat : 문자 형식 변환
			 */
		
		String id = "java";
		String name = "신용권";
		String tel = "010-123-4567";
		
		
						// {} 변수가 들어가는 위치 (0번 부터 시작)	
		//중괄호의 등장 : 어떤 패턴의 순서. %d와 유사함
		String text = "회원 아이디 : {0} \n 회원 이름 : {1} \n 회원 전화 : {2} ";
		//메세지 가져온 것을 result 에 저장
		String result = MessageFormat.format(text, id, name,tel);
		System.out.println(result);				//패턴, {0} {1} {2}
		
		
		//변수 문자처리x이므로 +id+로 연결
		//나중에 DAO(데이터 베이스)에서 사용할 예정.. 사용하면 코드가 짧아짐
		String sql = "insert info member values {0}, {1} ,{2})";
								//인덱스 순으로 0 1 2
		Object[] 배열 = {id, name, tel};
		String result1 = MessageFormat.format(sql, 배열);
		System.out.println( result1 );
		
		//하나씩 차곡차곡 들어감
		
		
		
		
		/////////////JAVA 7버전 이전 date  이후에는 여러가지 날짜 aPI가 추가 중이다.
		LocalDate currDate = LocalDate.now(); //new 사용 안 함. static이 따로 있다.
		System.out.println("현재 날짜 : " + currDate);
		
		LocalDate currTime = LocalDate.now();
		System.out.println("현재 시간 : "+ currTime);
		
		/*
		Date 현재 날짜/시간 : 조작이 안 되거나 비교기능이 불충분
		vs
		LocalDate : 현재 날짜
		LocalTime : 현재 시간
		*/
		
		LocalDateTime currdatetime = LocalDateTime.now();
		System.out.println("현재 날짜.시간 : "+ currdatetime);
		
		
		//시간계산
		Instant instant1 = Instant.now();
		Thread.sleep(10); //1초 대기. 코드 흐름을 1초가 멈춤
		//throw로 던짐. 일반예외 무조건 뜬다
		Instant instant2 = Instant.now();
		
			if(instant1.isBefore(instant2)) {
				System.out.println("instant1 더 빠름");
			} else if (instant1.isAfter(instant2)) {
				System.out.println("instant2가 더 늦음");
			} else { System.out.println("동일한 시간 입니다."); }
		//비포 애프터로 누가 더 빠르고 느린지 차이를 나타냄..
			
			//이거 좀 더 기억할것 ***
			System.out.println("시간 차 : "+instant1.until(instant2, ChronoUnit.NANOS));
			//컴퓨터 시간 계산할때                               나노스를 써서 두가지를 계산.
						//밀리초 : 1000/1초     마이크로초 : 1000000/초      나노초 : 1000000000/1초

			
			
			
			
			
			
			
			
			
			
			
	}
}
