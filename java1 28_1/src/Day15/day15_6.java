package Day15;

public class day15_6 {
public static void main(String[] args) {
	
	/*p597
		�����ٸ� : CPU(�ü��)�� �޸𸮸� ���μ������� �Ҵ��ϴ� ���
	*/
	
	//598~600
	//1. ��ü ���� (TargetThread)
	StatePrintThread statePrintThread =
			new StatePrintThread(new TargetThread());
	StatePrintThread.start();
	
	
}
}
