package Day13;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class day13_2 { //539 날짜 클래스
	public static void main(String[] args) {

		//Date 클래스 (java.util에서 제공) : 윈도우 시스템의 날짜/시간을 알려준다.
		Date date = new Date(); //date 객체 생성
		System.out.println("현재 날씨/시간 : "+date);
		System.out.println("객체정보메소드 : "+date.toString());
		//오브젝트가 최상위인데 tostring과 equals는 최상위 클래스에서 시작된 것
		//둘 다 동일하게 나옴
		
		//날짜형식, 모양 변경 가능.
		//날짜/시간을 포맷(형식=꾸미기) 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
								//생성자 안에 패턴(yy mm 등) 넣기 **월의 MM은 대문자로
		//날짜에 형식 적용하기
		System.out.println("날짜형식변경 : "+sdf.format(date));
						//형식객체.format(날짜객체)
		//날짜 date 형식이 String형식으로 변환
		
		
		//540
			//calender 클래스 : 운영체제 시간대의 날짜/시간에 대한 정보
		Calendar now = Calendar.getInstance(); //캘린더 클래스 내 객체 호출
			//이미 캘린더 클래스 내 객체가 존재한다는 뜻이므로 new를 사용하지 않는다.(객체생성x)
			//getinstance라는 메소드를 통해 이미 시간을 다 만들어놓았음. 캘린더도 객체가 존재하므로 호출만 함
		
		//연도
		System.out.println("연도 : "+ now.get(Calendar.YEAR)); //변수없이 바로 출력
							//가져온다. 캘린더에서. 년도를.
		
		//월
		System.out.println("월 : "+(now.get(Calendar.MONTH)+1));
		//0부터 11까지 나오므로 1월은 0으로 나온다. 따라서 +1을 해야만 제대로 나옴
		//+1할때 괄호 꼭 씌우기
		
		//일
		System.out.println("일 : "+now.get(Calendar.DAY_OF_MONTH));
		//월 기준으로 일수
		
		//요일
		System.out.println("요일 : "+now.get(Calendar.DAY_OF_WEEK));
		//주 기준으로 일수.2:월 <이런식이므로 6=금 (한글로 안 알려줌 당연함 한국에서 안 만듦)
		
		//그래서 숫자로 나타난 요일을 한글로 변환하려면?
		int week = now.get(Calendar.DAY_OF_WEEK);
		String 요일 = null; //한글 요일을 저장할 변수로 사용할 예정
		switch(week) {
			//만일 case1의 요일이 일이면? 하고 쓰고 브레이크 필수
			case 1: 요일 = "일"; break;
			case 2: 요일 = "월"; break;
			case 3: 요일 = "화"; break;
			case 4: 요일 = "수"; break;
			case 5: 요일 = "목"; break;
			case 6: 요일 = "금"; break;
			case 7: 요일 = "토"; break;
		} System.out.println("요일(한글) : "+ 요일);
		
		
		//오전/오후
		System.out.println("오전/오후"+now.get(Calendar.AM_PM));
		//오전인지 오후인지. 오전=0 오후=1
		
		//한글변환
		int ampm = now.get(Calendar.AM_PM);
			String 오전오후 = null;
				if(ampm == 0) 오전오후 = "오전";
				else 오전오후 = "오후";
			System.out.println("오전/오후 : "+오전오후);
		
		
		System.out.println("시 : "+now.get(Calendar.HOUR));
		System.out.println("분 : "+now.get(Calendar.MINUTE));
		System.out.println("초 : "+now.get(Calendar.SECOND));
		
		
		
		//세계 협정시계(다른나라 시계도 구할 수 있음.)
		ZonedDateTime 협정시 = ZonedDateTime.now(ZoneId.of("UTC"));
										//각 나라마다 아이디가 있음. (외우기 어려우니 구글링)
			System.out.println("협정시 : "+협정시);
		협정시 = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
			System.out.println("서울 시간 : "+협정시);
		협정시 = ZonedDateTime.now(ZoneId.of("America/New_York"));
			System.out.println("뉴욕 시간 : "+협정시);
		// **대문자 주의
		
		
		
		
		
		
		
		
///////////////////////////////////////////
	}
}
