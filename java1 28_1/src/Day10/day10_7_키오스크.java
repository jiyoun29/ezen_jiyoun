package Day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class day10_7_키오스크 {

	/* 상속 : 점포
	 * 클래스 : 롯데리아, 버거킹
	 * 인터페이스 : 키오스크
	 * 파일처리 : 재품재고 관리
	 * 
	 점포가 키오스크를 가지고 점포는 롯데리아에게도 상속된다.
	*/
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //입력객체
		
		
		//1. 파일입력(딱 1번만 끌고오면 됨)
		//들어올대는 input
		try { //try {}안에 예외[오류]가 발생할 것 같은 코드 넣기 (예상)
			FileInputStream inputStream = new FileInputStream("C:/java/롯데리아재고.text");
			
		//2. 파일 읽어오기(파일 -> 스트림(바이트만 가능) -> 자바)
			// 바이트 배열 생성
		Byte[] bytes = new Byte[1024]; // bit(8개) > byte(1024개) > kb > mb > gb
		
			// 읽어와서 배열 저장
		InputStream.read(bytes);
		
			// 분해. ,: 필드구분 \n : 객체구분
		String 파일내용 = new String (bytes); //바이트열->문자열 변경
		
			// string 분해 메소드 split("기준") ; 
		String[] 상품목록 = 파일내용.split("\n");
		
		
		ArrayList<상품> 상품리스트 = new ArrayList<>();
		for(String temp : 상품목록) {
			String[] 필드목록 = temp.split(",");
			상품 상품 = new 상품( 필드목록[0], 
					Integer.parseInt(필드목록[1]), Integer.parseInt(필드목록[2]) );
				//문자열 -> 정수형 변환 [ Integer.parseInt[문자열]
				//리스트 저장
			상품리스트.add(상품);
		}
		
		
		} catch(Exception e) { // catch : 예외 잡기 -> Exception 클래스의 객체에 저장
			
		}
		
		//점주가 유재석인 롯데리아 키오스크 객체 생성
		키오스크 롯데리아 = new 롯데리아("유재석", 상품리스트 ); // 롯데리아 키오스크 생성
		
		
		while(true) {
			//무한루프
			
			롯데리아.제품목록();
			int ch = scanner.nextInt();
			
			if(ch == -1) {
				롯데리아.상품추가();
			} else { //해당하는 번호를 장바구니에 담음
			}
			
		}
		
		
		
		
		
/////////////////////////////////////////////////		
	}
}
