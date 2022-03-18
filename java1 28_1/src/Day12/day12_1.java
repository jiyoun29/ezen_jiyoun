package Day12;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class day12_1 { //p.496
	public static void main(String[] args) throws IOException {
	
		//소스상에서 문자열 리터럴은 String 객체로 자동 생성 된다.
		//String 클래스
			//String 문자열 클래스
				//JAVA.lang 패키지 [ import x ] 소속 //기본 클래스
		//scanner클래스는 임폴트, 하지만 스트링은 하지 않는다.
		//scanner scanner~을 만들었을때 위에 뉴 객체가 생기지만 string은 그렇지 않음
				//객체인데 자동 리터럴 [ 객체가 자동 생성 ]
		
		String 설명1 = new String("유재석");
		String 설명2 = "유재석";
		//두가지가 동일하다. new가 객체이고 정적은 static이고 둘 다 메모리 할당이지만
		//new를 쓰지않아도 자동 객체 생성을 통해 나온다.
		
				//13개의 생성자로 구성[문자열, 바이트열 등]
		String 설명3 = new String();
		//(ctrl space 했을때 나오는 초록색 버튼들. 작대기 그어진건 비권장-사용은 가능)
				//외부로 받은 데이터는 보통 바이트열
		
		
		
		//바이트는 문자로 변환이 가능하다.
		//why? 1. 바이트 -> +-127까지 표현이 가능하다.
			//이와 유사한 것 : 아스키 코드( 0 or 1 조합된 7자리 -> 0101011 -> 2의 7승 -> 128문자 표현가능
			//바이트 -> 아스키코드 변환
		//자바 자료형 구글링 참고(이미지)
			//아스키코드 : 영문/특수문자 1바이트 한글 2바이트
		
		
		//기계어 : 0 or 1
		//7자리 기계어 : 아스키코드 [1000001 = A ]
		//스트링 클래스는 바이트로 가져온 것을 문자열로 바꿔주는 역할
	
		
		//p.497
		//1. 여러개 바이트를 저장할 수 있는 바이트 배열 선언
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		//71->H 등 아스키코드로 변경이 된다. 그래서 이걸 출력하면 hello java가 나온다.

		//2. 바이트배열 -> 문자열 변환[ new String(배열) ; ] 
		String str1 = new String (bytes);
		//string -> 아스키코드 변환. 문자열로 저장 가능해짐
		
		//3. 확인
		System.out.println("바이트 배열 -> 문자열 배열" + str1);
		
		//4. 특정 위치부터 변환 (인덱스 순서)
		String str2 = new String(bytes, 6, 4);
		//			new String(배열명, 시작, 개수)
		//어디서부터 어디까지 변환시킬거다. 6번 인덱스에서 4개를 변경.
		
		
		//5. 확인
		System.out.println("바이트내 배열 6번 인덱스부터 4개 변환 :" + str2);
		
		
		//498
		// System.out : 시스템 클래스 내 출력 필드
		// System.in : 시스템 클래스 내 입력 필드
		byte[] bytes2 = new byte[100]; //100개 바이트를 저장할 수 있는 배열
		

		System.out.println("입력 : "); //출력필드 내 print 메소드 호출
		//객체는 메소드를 호출하는 방법 1. 객체 생성 후 메소드 호출
		//2. 연산자를 이용한 메소드 호출 3. static으로 되어있는 필드나 메소드를 객체없이 클래스명.필드로 호출
		//out = static
		int readBytesNo = System.in.read(bytes2);
		//					키보드\
		//빨간줄 이유 : io, 입출력. 눌러서 throw
		//외부통신 : 자바프로그램 외 키보드, 파일, 네트워크 등 입출력 예외
		//입력했을때 나오는 것 : 97 a 13 \n 10 \r(커서를앞으로) <-엔터를 쳤으므로 같이 나온다.
		
		
		System.out.println("입력받은 바이트 : " + Arrays.toString(bytes2));
		
		// 0, readByteNo를 추가한다.
		String str = new String(bytes2, 0, readBytesNo-2);
						//읽은 바이트수 -2 ***항상 그래야 13 10이 안 나온다.
		System.out.println("입력받은 바이트 -> 문자열 변환 : "+str);
		
		
		//scanner 클래스 [ system.in으로부터 입력받은 바이트를 객체에 저장
		Scanner scanner = new Scanner(System.in);
		scanner.next(); //바이트->문자열 변환
		scanner.nextInt(); // 바이트->정수열 변환
		scanner.nextDouble(); //바이트->실수열 변환
		
		
		
		
		
		
		
		
		
	}
}
