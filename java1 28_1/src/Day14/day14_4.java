package Day14;

import java.awt.Toolkit;

import Day07.Calculator;

public class day14_4 { //576 멀티스레드
	
	public static void main(String[] args) {
		
		// https://github.com/itdanja/ezen_web_2022_A/blob/main/java1/src/Day14/Day14_4.java
		//보면서 틀린거 찾아내기
		
	/*
	 멀티스레드의 개념
	 	프로세스 : 운영체제에서는 실행 중인 하나의 어플리케이션을 뜻한다.
	 	운영체제가 프로세스에게 필요한 메모리를 할당해준다.(중요한것 : 자바에서 메모리 관리x(직접적으로는 불가능), 운영체제(윈도우)가 담당.)
	 	
	 	1. 싱글 스레드
 			코드를 읽어주는 흐름이 한 가지 = main메소드
	 	2. 멀티 스레드
	 		코드를 읽어주는 흐름이 여러개 = main메소드 말고 더 있다는 뜻
	 	
	 	병렬 : 설계상 병렬 흐름이지만 결국 1개씩 순차적(운영체제가 우선순위를 할당)으로 처리한다.
			실행순서 : 코드1 -> 코드2 -> 코드3 -> 코드4
			
		스레드 클래스 : 병렬로 만들어지는 클래스(새로운 스레드) vs 메인 메소드 : 기본 스레드가 내장되어 있음
			thread는 상속이 1개만 가능.  extend thread는 1개만 가져오므로 사용x
			runnable은 인터페이스고 여러개가 가능.	
			-> 두 가지의 다른 점
			
		***********두가지 반드시 외우기
			Thread 클래스
				임의클래스에 Thread에서부터 extends 상속 받음
				객체를 생성( run() 메소드 오버라이딩[재정의]
				객체를 생성
				객체에서 객체.start() 하면 끝
				->start() 메소드 호출시 run메소드 실행
			
			Runnable 인터페이스
				임의클래스에 implements Runnable
				run() 메소드 구현
				외부에서 구현 객체 생성
				Thread라는 객체 생성 시 생성자에 구현객체를 넣어준다.
				Thread 클래스 객체 내 start(원래 있음)메소드를 실행
				@구현된 클래스에서
				.start 메소드는 run() 메소드를 호출한다. (run이 멀티로 이용된다)
	 			run() 메소드는 main스레드를 제외한 새로운 스레드를 만든다.
	 			
	 		익명개체
	 			인터페이스가 구현을 받지 않고 인터페이스 내에 직접 구현
	 			
	 */
	
	
	//581 예제
	//싱글스레드 (main 메소드 1개) : 위에서 아래로 실행
		//0.5초 간격으로 소리를 실행하면서 0.5초 간격으로 "띵"을 출력한다.
		
	Toolkit toolkit = Toolkit.getDefaultToolkit(); 
	//잘 안 쓰니 외우지x, 소리 관련 메소드를 제공해주는 클래스
	
	//소리
	//반복문 돌리기
		for(int i = 0 ; i<5 ; i++); { //i가 0부터 5까지 1씩 돈다. 
			toolkit.beep(); // .beep() : 소리 메소드
			//실행하면 또롱~ 소리 난다.
			
			try { //스레드 클래스에 스립 추가. 오류나니 트라이캐치 추가. 
				Thread.sleep(500); // 현재 메인 스레드를 0.5초간 일시정지 시킨다.
				//실행하면 소리가 먼저 5번 나고 띵이 5번 나온다.
			} catch (Exception e) {}
			
		}
		//출력
		for(int i = 0 ; i<5 ; i++); { 
			System.out.println("띵"); }
	
	System.out.println("--------------싱글-----------------");
	
	//582 예제
	//멀티 스레드 (소리와 출력 같이) + day14_4_BeepTask
	//메인 스레드 하나와 runable라는 인터페이스를 구현하여 새로운 스레드를 만들어 사용 -> 멀티 스레드
	
	
	//1. 인터페이스에 구현객체
		Runnable runnable = new day14_4_BeepTask();
	//2. Thread 클래스 객체 생성 시 생성자에 구현 객체 넣기
		Thread thread = new Thread(runnable);
	
	//3.Thread 객체 내 start()메소드를 호출
		//시작 넣어보기
		thread.start();
		
		
		//출력
		try {
			for(int i = 0 ; i<5 ; i++); { 
				System.out.println("띵") ; 
				Thread.sleep(500);
			}
		} catch (Exception e) {}
		
		//소리와 띵이 같이 나온다.
		
		System.out.println("--------------멀티-----------------");		
		
		//p584 : Thread 클래스를 이용한 멀티스레드
		
		//1. 스레드 객체 생성
		Thread thread2 = new day14_5_BeepThread(); //메모리 할당ㅁㄴ beepthread
		//슈퍼클래스      =   자식 클래스의 생성자 [ 다형성 ]
		//자식은 부모에게 갈 수 있음(자동 형변환) . 부모는 자식으로 대입 불가능 (강제형변환)
		
		//2. 스레드 객체내 start() 호출 : run 메소드 호출 역할(멀티 스레드 실행)
			//스레드 클래스내 미리 만들어진 객체
		thread2.start();
		
		//출력
		for(int i = 1; i<5; i++) {
			System.out.println("띵");
			try { Thread.sleep(5000);
			} catch(Exception e) {}
		}
		
		System.out.println("-------------멀티(익명)------------------");
		
		
		
		/*인터페이스 사용방법
			1. 클래스에게 implements 한 후에 구현 = 구현 객체
			2. 인터페이스에 new 연산자를 통한 추상메소드 구현 -> 익명 객체 [클래스 관련x]
		*/
		
		
		//class 만들지 않고 익명으로
		
		//class만 new 사용 가능
		Runnable runnable2 = new Runnable() {
			
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0 ; i<5 ; i++) {
					toolkit.beep();
						try { Thread.sleep(500);
						} catch (Exception e) {}
				}
		};
		
		Thread thread3 = new Thread(runnable2);
		//스레드 클래스 내 생성자에 스레드 인터페이스 넣기
		thread3.start();
			for (int i = 0 ; i<5 ; i++) {
				toolkit.beep();
					try { Thread.sleep(500);
					} catch (Exception e) {}
			}
		
		
		
		//인터페이스 명   변수(객체) 명
			//인터페이스에 new = 메모리를 할당하겠다는 뜻
			//메모리 할당을 위해 추상메소드를 먼저 구현
			//추상 메소드를 구현하지 않으면 익명 객체 선언이 불가능하다.
		
		
		}
		

		
		
		System.out.println("-------------멀티(이름)------------------");	
		
		System.out.println("main 메소드 안에 있는 이름 : " + Thread.currentThread().getName() );
			//커렌트 스러드 : 현재 코드를 읽어주는 스레드 흐름
			//.name은 이름 호출 //setname은 이름변경
		//실행 돌리면 main이 나옴

		System.out.println("작업 스레드 이름 : "+Thread.getname() );
		//실행 돌리면 Thread-0 나옴
		System.out.println("작업 스레드 이름 : "+Thread2.getname() );
		System.out.println("작업 스레드 이름 : "+Thread3.getname() );
		

		
		
		
		
		System.out.println("-------------멀티(우선순위)------------------");	
		//590
		
		
		for(int i = 1 ; i<10 ; i++) {
				//10회 반복
			//i가 1일때 가장 먼저 스레드 객체가 생성 = thread1
			//중요한 건 먼저 만들어졌다고 한들 끝나는 속도는 뒤로 갈 수 있다.(우선 순위는 없음 ->운영체제가 스케줄을 짜서 순환할당 시킴)
			
			
			Thread thread4 = new day14_4_calThread("thread"+i);
			//1. i번째 스레드 객체를 생성

				//3. 우선순위
					//만일 10이 아니면 우선순위를 낮게 준다.(반드시 1등x 상위권에 들어감)
				if(i != 10) { thread4.setPriority(Thread.MIN_PRIORITY); }
					//max를 쓰면 우선순위, min을 쓰면 우선순위를 0으로 만듦
				else {thread4.setPriority(Thread.MAX_PRIORITY);}

			
			//2. i번째 스레드를 실행
			thread.start();
			//순서 뒤죽박죽한 현재 실행중인 스레드명 : Threa1~10이 멋대로 나옴
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
///////////////////////////////////////////////////////////////////////////////		
	
	} //main end

} //class end
