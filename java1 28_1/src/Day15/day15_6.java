package Day15;

public class day15_6 {
public static void main(String[] args) {
	
	/*p597
		스케줄링 : CPU(운영체제)가 메모리를 프로세스에게 할당하는 방법
	*/
	
	//598~600
	//1. 객체 생성 (TargetThread)
	StatePrintThread statePrintThread =
			new StatePrintThread(new TargetThread());
	StatePrintThread.start();
	
	
}
}
