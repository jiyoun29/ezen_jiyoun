package Day15;

import java.awt.Toolkit;

public class day15_7 {
	public static void main(String[] args) {
		
		/*601 스레드 제어
			1. Thread.sleep() : 주어진 시간동안 일시 정지
				시간 단위 : 밀리초(1000/1초)
				일반 예외 발생 : 일시 정지 상태에서 주어진 시간이 되기 전에 interrupted(종료)가 발생하였을 때 미리 처리 코드를 넣어놓는 것
			2. Thread.yield() : 다른 스레드에게 실행 양보 [ 대기 상태 ]
			3. 다른 스레드의 종료를 기다림 [ 다른 스레드가 종료될 때까지 일시 정지 상태 유지 ]
		*/
		
		
		//602 sleep 에제		
		//@소리나는거
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//			for(int i = 0 ; i<10 ; i++) {
//				toolkit.beep();
//				//소리가 한 번 이상 작동하기 전에 for문이 종료
//				
//				//일시정지 넣기 (예외처리 필쑤)
//				try {	Thread.sleep(3000);
//				} catch (Exception e) {			}
//			}
//			
		
		
		
//		
//		
//		//604~606 yield 예제
//			
//			//1. 객체 생성
//			ThreadA threadA = new ThreadA();
//			ThreadB threadB = new ThreadB();
//			
//			//2. 스레드 시작
//			threadA.start();
//			threadB.start();
//			
//			//3. 스레드 일시 정지
//			try { Thread.sleep(3000); }
//			catch (Exception e) {}
//			
//			//4. 스레드a에 work값 변경
//			threadA.work = false; // Thread.yield() //양보
//						
//			//3. 스레드 3초간 일시 정지
//			try { Thread.sleep(3000); }
//			catch (Exception e) {}
//			
//			//4. 스레드a에 work값 변경 (true값으로 바꿨으므로 일시정지가 해제)
//			threadA.work = true;
//			
//			//3. 스레드 3초간 일시 정지
//			try { Thread.sleep(3000); }
//			catch (Exception e) {}
//			
//			//5.스레드 a b 종료
//			threadA.stop = true;
//			threadB.stop = true;
//			
//			//6. 권장x
////			threadA.stop(); ->권장하지 않는 메소드
//			//스레드가 실행 되는 도중에 갑자기 종료 됨
//			
			
			
			
			
			
			//607 : join(); 사용
			
			//1. 객체 생성
			SumThread sumThread = new SumThread();
			//2. 스레드 실행
			sumThread.start();
			
			try { //3. main스레드와 sum스레드를 join (하나의 스레드가 된다.)
				sumThread.join(); //일반예외처리 발생
			} catch (Exception e) { }
			
			//4.
			System.out.println("1~100의 합 : "+sumThread.getsum());
			//main 스레드가 join을 하지 않았을 때 : 0
				//sumThread가 더하기를 끝나기 전에 main스레드가 먼저 출력 진행해버림
			//main 스레드가 join 했을 때 : 5050
			
			
			
	}
}
