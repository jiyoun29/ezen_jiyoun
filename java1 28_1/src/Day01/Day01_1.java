// 확대/축소 : ctrl + shift + (+) (-)
 // 주석처리( 컴파일[실행] 제외 )
 	// 1. // 슬래시 2번 : 한줄 주석
 	// 2. /*	여러줄주석    */ 
// tab : 들여쓰기 [ 5칸 이동 ], 중가로 1번에 탭 1번

package Day01; // 패키지명 [ 소스파일들의 폴더 ]
 
public class Day01_1 { // class start
	
	//public : 접근제한자 -> 전범위
		// class : 클래서 사용 선언
			// Day01_1 : 클래스 이름
	// * 모든 곳에서 사용하는 Day01_1이라는 이름을 갖는 클래스 선언
		// { : 시작, } : 끝
	
	// 1. class { } 안에서 코드를 작성한다. [ class 밖에서 작성 불가 ]
	// 2. 실행코드 main 함수 crt+space -> 자동완성 목록 -> enter
	
	public static void main(String[] args) { //main start
		// public : 접근제한자
			//static : 정적
				// void : 반환타입[돌려주는 값] 없음
					// main 함수 : 메인 스레드를 가지고 있는 함수 [ 필수 ]
					// 스레드 : 코드를 읽어주는 흐름
		
		// * main함수 {} 안에 작성된 코드는 실행된다.
		// syso -> ctrl+space : 출력 자동완성
		System.out.println("java 출력"); // 고급언어 [ 사람 이해 ]
		// 컴파일[ ctrl+F11 ] or 상단 실행버튼 or 우클릭 run		
		
	} // main end
	
} // class end
