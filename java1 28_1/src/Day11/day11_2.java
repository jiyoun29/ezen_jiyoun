package Day11;

public class day11_2 {
	
	/*p.422
		컴퓨터 하드웨어 문제를 에러 [ 실행불가능 ]
		사용자의 잘못된 조작 or 개발자의 잘못된 코딩의 에러의 예외
			종류 : 1. 일반예외 2. 실행예외
				일반예외 : 컴파일[실행]전에 예외 검사 / 개발자에게 강제 예외처리(실행전) <-이게쪼끔더편함
				실행예외 : 컴파일[실행]후에 예외 검사 / 개발자의 경험으로 판단해서 예외처리
			예외처리
				목적 : 에러가 발생하면 프로그램은 종료한다. [ 안전성 문제 ]
				* 만일 에러가 발생하면 대체 코드를 실행 [ 프로그램이 종료되지 않게 만듦 ] 
	 */
	
	public static void main(String[] args) {
		
		//p.423 [NullPointerException]
	try {
		String data = null;
		System.out.println(data.toString());
			/*실행 전에는 에러가 없음
		Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.toString()" because "data" is null
		 at Day11.day11_2.main(day11_2.java:20)
			메인 스레드에서 예외 발생. 
		object클래스 메소드 : toString(): 객체 정보 출력
			에러가 발생하는 이유 : null은 메모리 할당이 없기 때문에 객체정보 출력 불가능
		*/
		
		} //try 끝(예외처리)
	catch(NullPointerException 객체명) { //(try에는 반드시 catch가 붙음)
		System.out.println("예외발생 : "+객체명);
		}//catch  end
	
	
	
	//p.424
		//배열생성
	
	try {
		String[] 배열 = new String[2]; //String 2개를 저장할 수 있는 배열
		배열[0] = "a"; 배열[1] ="b"; 배열[2]="c"; //if(변수<2)로 해서 배열2빼고도 가능
			//ArrayIndexOutOfBoundsException
		//array=배열 index out =나감 bounds=저장. 저장할 수 있는 인덱스를 나감.
		//인덱스 범위를 맞춰야함
	} catch(ArrayIndexOutOfBoundsException e) { //exception을 이용도 가능
			//예외 발생한 예외 클래스 
		//만약에 에외가 발생하면 실행되는 코드
		System.out.println("예외처리 : "+e);
	}
	
	
	//p.426
	try {
			String data1 = "100"; //문자열
			String data2 = "a100"; //문자열
		int value1 = Integer.parseInt(data1); //"100" -> 100 가능
		int value2 = Integer.parseInt(data2); //"a100" -> 불가능 [a는 정수로 표현 불가능]
				//integer.parseInt(문자열) ; 문자열 -> 정수
		//에러 사유 : 문자열 내 숫자형식은 변환이 가능하지만 문자열내 문자형식 변환이 불가능
		
		//오류가 발생하면 catch 이동 [오류 발생 이후 코드 실행x]
		int result = value1 + value2;
		System.out.println(data1 + "+"+ data2 + "="+result );
		
		
	} catch(NumberFormatException e) {
		System.out.println("오류발생 : "+e);
	}
	
	
	
	//p.428

		String 문자열 = "유재석"; //그냥 자바 클래스 중 하나
		Object 슈퍼객체 ; //자바 클래스 내 최상위 클래스(모든걸 다 받아줌)
	
		슈퍼객체 = 문자열; //자식->부모 가능
		문자열 = 슈퍼객체; //부모->자식 불가능
			//강제형변환
			//실행 중에 형변환
		//예외처리 판단
			//입출력(사용자 입장) 관련된 코드 [무조건 예외처리]
		
		//오류 ex -> try로 해결.
		
	
	
	
	
	
	///////////////////////////////////////////////
	}
}
