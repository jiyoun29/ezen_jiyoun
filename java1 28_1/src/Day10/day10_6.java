package Day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class day10_6 {
	/*주 기억장치 : 메모리 : RAM : 프로그램 실행 시에만 저장 메모리
	 보조 기억장치 : C드라이브, USB, CD : (프로그램) 파일 [영구 저장]
	 파일처리 [자바내 메모리틀 -> 보조기억장치]
	 DB처리[자바내 메모리 -> DB보조장치]
		Stream스트림 : 프로그램 외부 [키보드 파일 네트워크등] 통신
		 통신 단위 : byte
		FileOutputStream : 파일출력 클래스
			객체명.write(바이트열);
		FileInputStream	: 파일입력 클래스
			객체명.read(바이트배열);
		String 클래스
			문자열.equlas() : 문자열 비교 메소드
			문자열.getBytes() : 문자열->바이트열 변환
			new String(바이트배열) : 바이트배열 -> 문자열 배열
	예제
	*/
	
	public static void main(String[] args) throws IOException {
							// throws <-던지기. 오류가 있어도 메인에게 주겠다.
		
		//2. 파일 출력 [ 파일->자바]
	FileOutputStream 파일출력 = new FileOutputStream("C:/java/java1.txt");
	// FileOutputStream : 파일 입출력 클래스
	//FileOutputStream (파일 경로 / 파일명.확장자); // 
	
	String 내용 = "자바에서 입력된 데이터";
	파일출력.write(내용.getBytes() ); //예외[오류]
	
	
	
	//1. 파일 입력 [ 자바->파일 ]
	FileInputStream 파일입력 = new FileInputStream("C:/java/java1.txt");
	byte[] bytes = new byte[1000];
	파일입력.read(bytes);
	System.out.println("파일내용 : " + new String(bytes));
	
	
	
		
		
		////////////////////////////////////////
	}
}
