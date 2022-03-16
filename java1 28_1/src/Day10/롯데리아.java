package Day10;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

//day10_7_키오스크 
public class 롯데리아 extends 점포 {
		//점포 상속
	//롯데리아만의 제품목록
	
	//1. 필드
	private String 점주;
	private ArrayList<상품> 상품리스트 = new ArrayList<>();
	
	//2.생성자
	//깡통
	public 롯데리아() {}

	// 우클 소스 필드
	public 롯데리아(String 점주, ArrayList<상품> 상품리스트) {
		super();
		this.점주 = 점주;
		this.상품리스트 = 상품리스트;
	}



	//오버라이팅
	@Override
	public void 제품목록() {
			System.out.println("======롯데리아 제품 목록======");
			
			int i = 1;
			for(상품 temp : 상품리스트) {
				System.out.print(i+"."+temp.get상품명()+
						"("+temp.get가격()+")");
				i++;
			}
		System.out.println();
		}
		
		
		//입력
		@Override
		public void 상품추가() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("======롯데리아 상품 추가======");
			System.out.print("상품명 "); String 상품명 = scanner.next();
			System.out.print("재고 "); int 재고 = scanner.nextInt();
			System.out.print("가격 "); int 가격 = scanner.nextInt();

		//객체 (여러변수 -> 하나 객체)
			상품 상품 = new 상품(상품명, 재고, 가격);
	
		//리스트에 저장
		상품리스트.add(상품);
		
		//파일처리(출력으ㅗㄹ 가져옴)
		try {
		//예외(오류)가 발생할 것 같은 코드 묶음(예상)
		FileOutputStream outputStream = new FileOutputStream("C:/java/롯데리아재고.text", true);
		//경로 받지 않기																파일경로, true=이어쓰기			
		String 내보내기 = 상품명+","+재고+","+가격+"\n"; //구분
					// , : 필드 구분. \n : 제품 구분
		
		outputStream.write(내보내기.getBytes()); //문자열 ->바이트열
		} catch(Exception e) {
			//예외(오류) 처리(잡기) : Exception 클래스
		}
		
		System.out.println("알림) 상품 저장 완료");
		//어레이리스트는 재부팅시 사라지므로 영구저장
		
		}

}
